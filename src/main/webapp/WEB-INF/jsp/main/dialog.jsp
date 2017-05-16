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
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteEditDia" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<form action="note/save.html" id="noteEditFrom">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<div style="font-size: 23px;">
						<i class="glyphicon glyphicon-edit"></i>新增笔记
					</div>
				</div>
				<div class="input-group input-group-sm">
					<span class="input-group-addon">标题</span><input type="text" class="form-control" id="title" name="title">
				</div>
				<div id="odiv" style="display: none; position: absolute; z-index: 100;">
					<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" />
					<img src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除"
						onclick="del();odiv.style.display='none';" />
				</div>
				<div id="content" style="clear: both; height: 400px; width: 100%;" class="editor"></div>
				<div class="modal-footer" id="submitFooter">
					<a class="btn btn-danger btn-sm" data-dismiss="modal">取消</a> <a class="btn btn-success btn-sm" id="noteSubmitBtn">提交</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- noteedit end -->

<!-- noteupdate start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteUpdateDia" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content" style="position: absolute;">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<div style="font-size: 23px;">
					<i class="glyphicon glyphicon-edit"></i>查看
				</div>
			</div>
			<div class="col-lg-2 col-sm-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<div class="nav-sm nav nav-stacked"></div>
						<ul class="nav nav-pills nav-stacked main-menu">
							<li><span class="input-group-addon"><i class="glyphicon-leaf glyphicon glyphicon-fire"></i>标题</span><input type="text" class="text-center form-control"
								id="update-title" name="title"></li>
							<li><span class="input-group-addon"><i class="glyphicon-leaf glyphicon glyphicon-fire"></i>标签</span> <select size="1" class="text-center form-control"
								id="update-option" dir="ltr">
									<option value="">--全部--</option>
							</select></li>
							<li class="accordion"><a class="btn btn-default"><i class="glyphicon-leaf glyphicon glyphicon-fire"></i>备注</a>
								<ul class="nav nav-pills nav-stacked" style="display: none; margin-left: 0px;">
									<li><div id="remarks" style="clear: both; width: 100%;" class="editor"></div></li>
								</ul></li>
							<li class="accordion"><a class="btn btn-default">关键词</a>
								<ul class="nav nav-pills nav-stacked" style="display: block; margin-left: 0px;">
									<li><input type="text" class="text-center form-control" id="key0" placeholder="关键词1"></li>
									<li><input type="text" class="text-center form-control" id="key1" placeholder="关键词2"></li>
									<li><input type="text" class="text-center form-control" id="key2" placeholder="关键词3"></li>
								</ul></li>
							<li><a class="btn btn-default" id="noteUpdateBtn">修改</a></li>
							<li><a class="btn btn-default" id="noteDownloadBtn">下载</a></li>
							<li><a class="btn btn-default" data-dismiss="modal">取消</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-10 col-sm-10">
				<div id="odiv" style="display: none; position: absolute; z-index: 100;">
					<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" />
					<img src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除"
						onclick="del();odiv.style.display='none';" />
				</div>
				<div id="update-content" style="clear: both; height: 510px; width: 100%;" class="editor"></div>
			</div>
			<div class="modal-footer">
				<hr>
			</div>
		</div>
	</div>
	<input type="text" hidden="hidden" id="noteId">
</div>
<!-- noteupdate end -->
<!-- galleryDialog -->
<div class="modal fade" id="galleryDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="padding-bottom: 3px;">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>创建分类</h4>
				<div class="showloading"></div>
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
				<a class="btn btn-sm btn-default" id="sumbitBtn">提交</a> <a class="btn btn-sm btn-default" id='resetBtn'>重置</a>
			</div>
		</div>
	</div>
</div>
<!-- galleryUpdateDialog -->
<div class="modal fade" id="galleryUpdateDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="padding-bottom: 3px;">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>修改分类</h4>
				<div class="showloading"></div>
			</div>
			<div class="modal-body" style="text-align: center;">
				<div class="example-wrapper">
					<div class="tags well">
						<label for="tag" class="control-label">类别</label>
						<div id="update-clzss-tag" data-tags-input-name="taggone" class="form-control"></div>
						<p class="help-block">按回车，逗号或空格键创建一个新的类别，退格键或删除删除最后一个。</p>
						<label for="tag" class="control-label">标签</label>
						<div id="update-label-tag" data-tags-input-name="taggone" class="form-control"></div>
						<p class="help-block">按回车，逗号或空格键创建一个新的标签，退格键或删除删除最后一个。</p>
						<label for="tag" class="control-label">新标签</label>
						<div id="new-label-tag" data-tags-input-name="taggone" class="form-control tagging editable"></div>
						<p class="help-block">按回车，逗号或空格键创建一个新的标签，退格键或删除删除最后一个。</p>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a class="btn btn-sm btn-default" id='updateBtn'>提交</a> <a class="btn btn-sm btn-default" id='updateResetBtn'>重置</a>
			</div>
		</div>
	</div>
</div>

<!--  -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteBagWordDialog" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<div style="font-size: 23px;">
					<i class="glyphicon glyphicon-edit"></i>词库
				</div>
			</div>
			<div class="input-group input-group-sm">
				<span class="input-group-addon">标签</span> <select size="1" class="text-center form-control" id="bagWordLabelSelect" dir="ltr" onchange="note.updateBagWordOnChange()">
				</select>
			</div>
			<div id="odiv" style="display: none; position: absolute; z-index: 100;">
				<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" />
				<img src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除"
					onclick="del();odiv.style.display='none';" />
			</div>
			<div id="bagwordContent" style="clear: both; height: 400px; width: 100%;" class="editor"></div>
			<div class="modal-footer" id="submitFooter">
				<a class="btn btn-danger btn-sm" data-dismiss="modal">取消</a> <a class="btn btn-success btn-sm" id="updateBagWordBtn">修改 </a>
			</div>
		</div>
	</div>
</div>
