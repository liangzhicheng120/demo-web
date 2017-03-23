<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- delete start -->
<div class="modal fade" id="deleteDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
<div class="modal fade" id="batchDeleteDia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="noteEdit" role="dialog" aria-labelledby="myLargeModalLabel">
	<div class="modal-dialog modal-lg" role="document">
		<form action="note/save.html" id="noteEditFrom">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3>
						<i class="glyphicon glyphicon-edit"></i>新增笔记
					</h3>
				</div>
				<div class="modal-body" >
					<div style="width: 96%;margin: 17px auto;"> 
					<input type="text" class="form-control" name="title" placeholder="标题"></div>
					<div id="odiv" style="display: none; position: absolute; z-index: 100;">
						<img src="./Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> 
						<img src="./Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" />
						<img src="./Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> 
						<img src="./Charisma/images/sc.png" title="删除" border="0" alt="删除" onclick="del();odiv.style.display='none';" />
					</div>
					<div onmousedown="show_element(event)" id="content" style="clear: both;height: 400px;" class="editor"></div>
				</div>
				<div class="modal-footer" id="submitFooter">
					<a class="btn btn-danger btn-sm" onclick="">取消</a> <a class="btn btn-success btn-sm" id="noteSubmitBtn">提交</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- noteedit end -->