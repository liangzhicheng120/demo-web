<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- delete start -->
<div class="modal fade" id="noteDeleteDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>删除</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p>确定删除信息？</p>
				<input type="text" id="id" hidden="hidden">
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" class="btn btn-success btn-sm" data-dismiss="modal" id="deleteBtn">确定</a>
			</div>
		</div>
	</div>
</div>
<!-- delete end -->

<!-- error start -->
<div class="modal fade" id="errorDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>error</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p>
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
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h4>批量删除</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<p>确定批量删除信息？</p>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> <a href="javascript:void(0)" class="btn btn-success btn-sm" data-dismiss="modal" id="batchDeleteBtn">确定</a>
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
					<div style="margin-top: 10px; margin-bottom: 5px; font-size: 25px;">
						<i class="glyphicon glyphicon-edit"></i>新增笔记
					</div>
				</div>
				<div class="modal-body">
					<div style="width: 96%; margin: 17px auto;" class="input-group input-group-sm">
						<span class="input-group-addon">标题</span><input type="text" class="form-control" id="title" name="title">
					</div>
					<div id="odiv" style="display: none; position: absolute; z-index: 100;">
						<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" /> <img
							src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除" onclick="del();odiv.style.display='none';" />
					</div>
					<div id="content" style="clear: both; height: 400px;" class="editor"></div>
				</div>
				<div class="modal-footer" id="submitFooter">
					<a class="btn btn-danger btn-sm" onclick="">取消</a> <a class="btn btn-success btn-sm" id="noteSubmitBtn">提交</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- noteedit end -->

<!-- noteupdate start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteUpdateDia" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<div style="margin-top: 10px; margin-bottom: 5px; font-size: 25px;">
					<i class="glyphicon glyphicon-edit"></i>查看笔记
				</div>
			</div>
			<div class="modal-body">
				<div style="width: 96%; margin: 17px auto;" class="input-group input-group-sm">
					<span class="input-group-addon">标题词</span><input type="text" class="form-control" id="update-title" name="title">
				</div>
				<div class="form-inline" style="width: 96%; margin: 17px auto;">
					<div class="input-group input-group-sm">
						<span class="input-group-addon">关键词</span> <input type="text" class="form-control" id="key0" placeholder="关键词1">
					</div>
					<div class="input-group input-group-sm">
						<span class="input-group-addon">关键词</span><input type="text" class="form-control" id="key1" placeholder="关键词2">
					</div>
					<div class="input-group input-group-sm">
						<span class="input-group-addon">关键词</span><input type="text" class="form-control" id="key2" placeholder="关键词3">
					</div>
					<input type="text" hidden="hidden" id="noteId">

					<div class="input-group input-group-sm">
						<span class="input-group-addon">类型词</span> <select size="1" class="form-control" id="update-option" dir="ltr">
							<option value="">--请选择--</option>
						</select>
					</div>
					<div class="input-group input-group-sm">
						<a class="btn btn-danger btn-sm" onclick="">&nbsp;&nbsp;取消&nbsp;&nbsp;</a>&nbsp;<a class="btn btn-success btn-sm" id="noteUpdateBtn">&nbsp;&nbsp;修改&nbsp;&nbsp;</a>
					</div>
				</div>
				<div id="odiv" style="display: none; position: absolute; z-index: 100;">
					<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> <img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" /> <img
						src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> <img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除" onclick="del();odiv.style.display='none';" />
				</div>
				<div id="update-content" style="clear: both; height: 400px;" class="editor"></div>
			</div>
		</div>
	</div>
</div>
<!-- noteupdate end -->