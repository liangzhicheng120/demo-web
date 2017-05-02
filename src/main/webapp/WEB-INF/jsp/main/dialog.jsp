<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- delete start -->
<div class="modal fade" id="noteDeleteDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="padding-bottom: 3px;">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>删除</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p style="margin: 0 10px;">确定删除信息？</p>
				<input type="text" id="id" hidden="hidden">
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" class="btn btn-success btn-sm" data-dismiss="modal"
					id="deleteBtn">确定</a>
			</div>
		</div>
	</div>
</div>
<!-- delete end -->

<!-- error start -->
<div class="modal fade" id="errorDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="padding-bottom: 3px;">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>error</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p style="margin: 0 10px;">
					异常错误信息:<span id="msg"></span>
				</p>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" class="btn btn-success btn-sm" data-dismiss="modal">确定</a>
			</div>
		</div>
	</div>
</div>
<!-- error end -->

<!-- batch delete start -->
<div class="modal fade" id="noteBatchDeleteDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="padding-bottom: 3px;">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>批量删除</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p style="margin: 0 10px;">确定批量删除信息？</p>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" class="btn btn-success btn-sm" data-dismiss="modal"
					id="batchDeleteBtn">确定</a>
			</div>
		</div>
	</div>
</div>
<!-- batch delete end -->

<!-- noteedit start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteEditDia" role="dialog" aria-labelledby="myLargeModalLabel" style="top: -10px;">
	<div class="modal-dialog modal-lg" role="document">
		<form action="note/save.html" id="noteEditFrom">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<div style="margin-top: 10px; margin-bottom: 5px; font-size: 25px;">
						<i class="glyphicon glyphicon-edit"></i>新增笔记
					</div>
				</div>
				<div class="modal-body">
					<div style="width: 96.2%; margin: 0px auto;" class="input-group input-group-sm">
						<span class="input-group-addon">标题</span><input type="text" class="form-control" id="title" name="title">
					</div>
					<div id="odiv" style="display: none; position: absolute; z-index: 100;">
						<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" />
						<img src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除"
							onclick="del();odiv.style.display='none';" />
					</div>
					<div id="content" style="clear: both; height: 400px; width: 100%;" class="editor"></div>
				</div>
				<div class="modal-footer" id="submitFooter">
					<a class="btn btn-danger btn-sm" data-dismiss="modal">取消</a> <a class="btn btn-success btn-sm" id="noteSubmitBtn">提交</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- noteedit end -->

<!-- noteupdate start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteUpdateDia" role="dialog" aria-labelledby="myLargeModalLabel" style="top: -10px;">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<div style="margin-top: 10px; margin-bottom: 5px; font-size: 25px;">
					<i class="glyphicon glyphicon-edit"></i>查看笔记
				</div>
			</div>
			<div class="modal-body">
				<div class="row" style="width: 99%; margin: 5px auto;">
					<div class="col-md-12" style="padding-right: 0px; padding-left: 5px;">
						<div class="input-group input-group-sm">
							<span class="input-group-addon">标题</span><input type="text" class="form-control" id="update-title" name="title">
						</div>
					</div>
				</div>
				<div class="row" style="width: 99%; margin: 5px auto;">
					<div class="col-md-3" style="padding-right: 0px; padding-left: 5px;">
						<div class="input-group input-group-sm">
							<span class="input-group-addon">标签</span> <select size="1" class="form-control" id="update-option" dir="ltr">
								<option value="">--全部--</option>
							</select>
						</div>
					</div>
					<div class="col-md-2" style="padding-right: 0px; padding-left: 5px;">
						<div class="input-group input-group-sm">
							<span class="input-group-addon">关键词</span> <input type="text" class="form-control" id="key0" placeholder="关键词1">
						</div>
					</div>
					<div class="col-md-2" style="padding-right: 0px; padding-left: 5px;">
						<div class="input-group input-group-sm">
							<span class="input-group-addon">关键词</span><input type="text" class="form-control" id="key1" placeholder="关键词2">
						</div>
					</div>
					<div class="col-md-2" style="padding-right: 0px; padding-left: 5px;">
						<div class="input-group input-group-sm">
							<span class="input-group-addon">关键词</span><input type="text" class="form-control" id="key2" placeholder="关键词3">
						</div>
					</div>
					<input type="text" hidden="hidden" id="noteId">
					<div class="col-md-3" style="padding-right: 0px; padding-left: 5px;">
						<div class="input-group input-group-sm">
							<a class="btn btn-success btn-sm" id="noteUpdateBtn">&nbsp;&nbsp;修改&nbsp;&nbsp;</a>&nbsp; 
							<a class="btn btn-danger btn-sm" data-dismiss="modal">&nbsp;&nbsp;取消&nbsp;&nbsp;</a>&nbsp;
							<a class="btn btn-success btn-sm" id="noteDownloadBtn">&nbsp;&nbsp;下载&nbsp;&nbsp;</a>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: -5px;">
					<div class="col-md-12" style="padding-right: 0px; padding-left: 5px;">
						<div id="odiv" style="display: none; position: absolute; z-index: 100;">
							<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" />
							<img src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除"
								onclick="del();odiv.style.display='none';" />
						</div>
						<div id="update-content" style="clear: both; height: 400px; width: 100%;" class="editor"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- noteupdate end -->
<!-- galleryDialog -->
<div class="modal fade" id="galleryDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="padding-bottom: 3px;">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>创建分类</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<div class="example-wrapper">
					<div class="tags well">
						<label for="tag" class="control-label">类别</label>
						<div id="clzss-tag" data-tags-input-name="taggone" class="form-control"></div>
						<p class="help-block">按回车，逗号或空格键创建一个新的类别，退格键或删除删除最后一个。</p>
						<label for="tag" class="control-label">标签</label>
						<div id="label-tag" data-tags-input-name="taggone" class="form-control"></div>
						<p class="help-block">按回车，逗号或空格键创建一个新的标签，退格键或删除删除最后一个。</p>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a class="btn btn-sm btn-default" id='sumbitBtn'>提交</a> <a class="btn btn-sm btn-default" id='resetBtn'>重置</a>
			</div>
		</div>
	</div>
</div>