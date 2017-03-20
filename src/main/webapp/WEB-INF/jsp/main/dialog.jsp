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
				<p>
					确定批量删除信息？
				</p>
			</div>
			<div class="modal-footer">
				<a href="javascript:void(0)" class="btn btn-default btn-sm" data-dismiss="modal">关闭</a> 
				<a href="javascript:void(0)" class="btn btn-success btn-sm" data-dismiss="modal" id="batchDeleteBtn">确定</a>
			</div>
		</div>
	</div>
</div>
<!-- batch delete end -->