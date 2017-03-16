/**
 * Created by ������
 * Email:sxchying@126.com
 * QQ:490746237
 */
window.html5Upload = (function () {
    function html5Upload() {
    }
    //����ļ���Option����
    var addFileOption = {};
    //����ϴ���Option����
    var uploadOption = {};
    //��չ����
    (function () {
        //ʹ��jq��չ�ļ���Ӻ���
        (function ($) {
            var defaults = {
                addFile: function (data) {

                },
                addFileError: function (data) {

                }
            };
            $.fn.addFile = function (options) {
                addFileOption = $.extend(defaults, options || {});
                return this.each(function () {
                    $(this).click(uploadFileOperation.addFile);
                });
            };
        })(jQuery);
        //ʹ��jq��չ�ϴ�����
        (function ($) {
            var defaults = {
                uploadInitUrl: "",
                uploadFinish: function (data) {

                },
                uploadProgress: function (data) {

                },
                uploadError: function (data) {

                },
                uploadAbort: function (data) {

                }
            };
            $.fn.upload = function (options) {
                uploadOption = $.extend(defaults, options || {});
                return this.each(function () {
                    $(this).click(function () {
                        //�ϴ�
                        videoUpload.tryUpload();
                    });
                });
            };
        })(jQuery);
    })();
    //cookie����
    var uploadCookie = (function () {
        function uploadCookie() {
        }
        uploadCookie.setCookie = function (key, value, expiresDays) {
            var date = new Date();
            date.setTime(date.getTime() + expiresDays * 24 * 3600 * 1000);
            document.cookie = key + "=" + value + "; expires=" + date.toGMTString();
        };
        uploadCookie.getCookie = function (key) {
            var strCookie = document.cookie;
            var arrCookie = strCookie.split("; ");
            for (var i = 0; i < arrCookie.length; i++) {
                var arr = arrCookie[i].split("=");
                if (arr[0] == key) {
                    return arr[1];
                }
                if (i == arrCookie.length - 1) {
                    return false;
                }
            }
        };
        uploadCookie.removeCookie = function (key) {
            uploadCookie.setCookie(key, "", -1);
        };
        return uploadCookie;
    })();
    //ajax
    var uploadAjax = (function () {
        function uploadAjax() {
        }
        uploadAjax.post = function (url, success, error) {
            $.ajax({
                url: url,
                type: 'post',
                dataType: "json",
                success: function (data) {
                    success(data);
                },
                error: function (data) {
                    if (error) {
                        error(data);
                    }
                }
            });
        };
        return uploadAjax;
    })();
    //�ϴ��ص�����
    var xhrEventCallback = (function () {
        function xhrEventCallback() {
        }
        xhrEventCallback.loadstart = function (e) {
            var currStack = videoUpload.cellStack;
            currStack.inittime = (new Date()).getTime(); //��ǿ�ʼ ��ʱ�� ʱ��
            var transferedsize = videoUpload.cellStack ? videoUpload.cellStack.transferedsize : 0;
            currStack.transferedsize = transferedsize;
        };
        xhrEventCallback.load = function (e) {
            var res = eval("(" + e.target.responseText + ")");
            if (!!res.transferedsize) {
                //��¼�ϵ�����token
                var tokenUrl = videoUpload.uploadUrl.split('token').pop();
                var videoToken = tokenUrl.substr(1, tokenUrl.length - 1).split('&')[0];
                uploadCookie.setCookie(html5Upload.exportObject.selectFile.fileKey, videoToken, 2);
                var transferedsize = parseInt(res.transferedsize);
                videoUpload.cellStack.transferedsize = transferedsize;
                transferedsize < html5Upload.exportObject.selectFile.file.size && videoUpload.streamUpload(transferedsize);
            }
            else {
                if (!res.totalsize && res.status != '200') {
                    uploadOption.uploadError({ code: res.status, msg: res.msg });
                    uploadCookie.removeCookie(html5Upload.exportObject.selectFile.fileKey);
                    videoUpload.xhrAbort();
                }
            }
            videoUpload.cellStack.starttime = (new Date()).getTime();
            if (res.transferedsize && res.transferedsize == res.totalsize) {
                //�ļ��ϴ����
                uploadOption.uploadFinish({ code: 0, msg: "�ϴ����" });
                uploadCookie.removeCookie(html5Upload.exportObject.selectFile.fileKey);
                videoUpload.xhrAbort();
            }
        };
        xhrEventCallback.progress = function (e) {
            var cellstack = videoUpload.cellStack, filetransfered = parseInt(cellstack.transferedsize);
            var pc = parseInt((filetransfered + e.loaded) / html5Upload.exportObject.selectFile.file.size * 100), delttime = ((new Date()).getTime() - (cellstack.starttime || cellstack.inittime)) / 1000, rate = e.loaded / delttime;
            rate = rate / 1024;
            rate = rate > 1024 ? (((rate / 1024 * 10) >> 0) / 10).toFixed(1) + "M/s" : (((rate * 10) >> 0) / 10).toFixed(1) + "K/s";
            //���ϴ�����������û��ڵ�����ɾ������Ƶ���ᴥ����Ƶ��ʧ����
            if (isNaN(pc)) {
                uploadOption.uploadError({ code: 203, msg: "��Ƶ��ʧ" });
                videoUpload.xhrAbort();
            }
            else {
                if (pc == 100) {
                    pc = 99;
                }
                uploadOption.uploadProgress({ progress: pc + "%", speed: rate });
            }
        };
        xhrEventCallback.error = function (e) {
            uploadOption.uploadError({ code: 404, msg: "�����쳣" });
            videoUpload.xhrAbort();
        };
        xhrEventCallback.abort = function (e) {
            uploadOption.uploadAbort({ code: 202, msg: "�ж��ϴ�" });
        };
        return xhrEventCallback;
    })();
    //�ϴ�
    var videoUpload = (function () {
        function videoUpload() {
        }
        var cellSize = 10485760;
        var xhr = null;
        var tryNum = 0;
        var sliceFile = function (file, start) {
            var blob;
            start = start || 0;
            var range = start + cellSize;
            if (start != -1) {
                if (file.slice) {
                    blob = file.slice(start, range);
                }
                else if (file.webkitSlice) {
                    blob = file.webkitSlice(start, range);
                }
                else if (file.mozSlice) {
                    blob = file.mozSlice(start, range);
                }
                else {
                    blob = file;
                }
            }
            else {
                return null;
            }
            return blob;
        };
        videoUpload.cellStack = {};
        videoUpload.uploadUrl = "";
        videoUpload.streamUpload = function (loadedsize) {
            videoUpload.cellStack.transferedsize = loadedsize;
            xhr = new XMLHttpRequest();
            html5Upload.exportObject.selectFile.xhrAbort = videoUpload.xhrAbort;
            xhr.upload.addEventListener("progress", function (e) { xhrEventCallback.progress(e); }, false);
            xhr.addEventListener("loadstart", function (e) { xhrEventCallback.loadstart(e); }, false);
            xhr.addEventListener("load", function (e) { xhrEventCallback.load(e); }, false);
            xhr.addEventListener("error", function (e) { xhrEventCallback.error(e); }, false);
            xhr.addEventListener("abort", function (e) { xhrEventCallback.abort(e); }, false);
            var cellFile = sliceFile(html5Upload.exportObject.selectFile.file, loadedsize);
            var content = loadedsize == -1 ? "bytes *" : "bytes " + (loadedsize + 1) + "-" + (loadedsize + cellFile.size) + "/" + html5Upload.exportObject.selectFile.file.size;
            xhr.open("POST", videoUpload.uploadUrl, true);
            xhr.setRequestHeader("X_FILENAME", encodeURI(html5Upload.exportObject.selectFile.file.name));
            xhr.setRequestHeader("Content-Range", content);
            xhr.send(cellFile);
        };
        videoUpload.xhrAbort = function () {
            xhr && xhr.abort();
        };
        videoUpload.tryUpload = function () {
            var video_name = encodeURIComponent(html5Upload.exportObject.selectFile.file.name);
            var uploadtype = 1;
            var file_size = html5Upload.exportObject.selectFile.file.size;
            var initUrl = uploadOption.uploadInitUrl + "?video_name=" + video_name + "&uploadtype=" + uploadtype + "&file_size=" + file_size;
            if (uploadCookie.getCookie(html5Upload.exportObject.selectFile.fileKey)) {
                initUrl = uploadOption.uploadInitUrl + "?token=" + uploadCookie.getCookie(html5Upload.exportObject.selectFile.fileKey) + "&uploadtype=" + uploadtype;
            }
            try {
                uploadAjax.post(initUrl, function (data) {
                    if (data.code == 0) {
                        html5Upload.exportObject.selectFile.video_id = data.data.video_id;
                        html5Upload.exportObject.selectFile.video_unique = data.data.video_unique;
                        tryNum = 0;
                        videoUpload.uploadUrl = data.data.upload_url.split('&')[0];
                        var nextBlob = data.data.upload_size || 0;
                        videoUpload.streamUpload(nextBlob);
                    } else {
                        switch (data.code) {
                            case 112:
                                if (tryNum < 2) {
                                    setTimeout(function () {
                                        videoUpload.tryUpload();
                                    }, 20000);
                                    ++tryNum;
                                } else {
                                    if (tryNum < 3) {
                                        uploadCookie.removeCookie(html5Upload.exportObject.selectFile.fileKey);
                                        ++tryNum;
                                        videoUpload.tryUpload();
                                    } else {
                                        uploadOption.uploadAbort({ code: data.code, msg: data.message });
                                        tryNum = 0;
                                    }
                                }
                                break;
                            default:
                                uploadOption.uploadAbort({ code: data.code, msg: data.message });
                        }
                    }
                }, function (data) {
                    if (tryNum < 3) {
                        setTimeout(function () {
                            videoUpload.tryUpload();
                        }, 1000);
                        ++tryNum;
                    } else {
                        uploadOption.uploadAbort({ code: 206, msg: data.statusText });
                        tryNum = 0;
                    }
                });
            } catch (e) {
                if (tryNum < 3) {
                    setTimeout(function () {
                        videoUpload.tryUpload();
                    }, 1000);
                    ++tryNum;
                } else {
                    uploadOption.uploadAbort({ code: 207, msg: e.message });
                    tryNum = 0;
                }
            }
        };
        return videoUpload;
    })();
    //�ļ�����
    var uploadFileOperation = (function () {
        function uploadFileOperation() {
        }
        //�����ϴ����ļ�����
        var fileTypes = "wmv|avi|dat|asf|rm|rmvb|ram|mpg|mpeg|mp4|mov|m4v|mkv|flv|vob|qt|divx|cpk|fli|flc|mod|dvix|dv|ts";
        //��ȡ�ļ�������
        var getFileType = function (file) {
            return file.name.split(".").pop();
        };
        //��ȡ�ļ���key
        var getFileKey = function (file) {
            return [getFileType(file), file.size, file.lastModifiedDate || file.name].join('_');
        };
        //ѡ���ļ���ʱ��
        var inputFileChange = function (e) {
            var file = e.target.files[0];
            var fType = getFileType(file);
            if (file.size < 0) {
                addFileOption.addFileError({ code: 100, msg: "�ļ���СΪ0" });
            } else if (!eval("/" + fileTypes + "$/i").test(fType)) {
                addFileOption.addFileError({ code: 101, msg: "��֧�ִ���Ƶ��ʽ" });
            } else {
                addFileOption.addFile({ code: 0, msg: "�ɹ�", data: { fileName: file.name, fileSize: file.size, fileType: fType } });
                html5Upload.exportObject.selectFile.file = file;
                html5Upload.exportObject.selectFile.fileKey = getFileKey(file);
            }
        };
        //����ļ�
        uploadFileOperation.addFile = function (e) {
            var inpfile = document.getElementById("fileUploadId_Hsc");
            if (inpfile) {
                inpfile.click && e.target != inpfile && inpfile.click();
            } else {
                inpfile = document.createElement("input");
                $(inpfile).append(inpfile);
                inpfile.setAttribute("id", "fileUploadId_Hsc");
                inpfile.setAttribute("type", "file");
                inpfile.style.display = "none";
                inpfile.addEventListener('change', inputFileChange, !1);
                inpfile.click && e.target != inpfile && inpfile.click();
            }
        };
        return uploadFileOperation;
    })();
    //�ɹ��û����ʵ�����
    html5Upload.exportObject = (function () {
        function exportObject() {
        }
        //ѡ�е��ļ�����
        exportObject.selectFile = {};
        return exportObject;
    })();
    return html5Upload;
})();