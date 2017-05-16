<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="col-sm-2 col-lg-2">
	<div class="sidebar-nav">
		<div class="nav-canvas">
			<div class="nav-sm nav nav-stacked"></div>
			<ul class="nav nav-pills nav-stacked main-menu">
				<li><a class="btn btn-default  ajax-link" href="index"><i class="glyphicon glyphicon-home"></i><span> 首页</span></a></li>
				<li><a class="btn btn-default" href="gallery"><i class="glyphicon glyphicon-arrow-left"></i>返回</a></li>
				<li class="accordion"><a class="btn btn-default " href="#"> <i class="glyphicon glyphicon-wrench"></i><span> 操作</span>
				</a>
					<ul class="nav nav-pills nav-stacked" style="display: block; margin-left: 0px;">
						<li>
							<div class="input-group input-group-sm">
								<span class="input-group-addon"><i class="glyphicon glyphicon-fire"></i></span> <select size="1" class="form-control" id="label" onchange="note.notechangelabel()">
									<option value=" ">---全部---</option>
								</select>
							</div>
						</li>
						<li>
							<div class="input-group input-group-sm">
								<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span> <input class="default-date-picker form-control" type="text" value="" id="start">
								<span class="input-group-addon">TO</span> <input id="end" class="default-date-picker form-control" type="text" value=""> <span class="input-group-addon"
									id="searchDateBtn"> <i class="glyphicon glyphicon-search"></i>
								</span>
							</div>
						</li>
						<li>
							<div class="input-group input-group-sm">
								<span class="input-group-addon"><i class="glyphicon glyphicon-fire"></i></span> <input type="text" class="form-control" placeholder="搜索内容" aria-describedby="basic-addon1"
									id="keyword"> <span class="input-group-addon" id="searchBtn"> <i class="glyphicon glyphicon-search"></i></span>
							</div>
						</li>
						<li><a class="btn btn-default" data-toggle="modal" data-target="#noteBagWordDialog" data-backdrop="static">词库</a></li>
						<li><a class="btn btn-default" data-toggle="modal" id="noteEditBtn" data-backdrop="static">新增</a></li>
						<li><a class="btn btn-default" data-toggle="modal" data-target="#noteBatchDeleteDia" data-backdrop="static">删除</a></li>
					</ul></li>
				<li><a class="btn btn-default" href="learn"><i class="glyphicon glyphicon-info-sign"></i><span> 学习网站 </span></a></li>
				<li><a class="btn btn-default" href="baike"><i class="glyphicon glyphicon-info-sign"></i><span> 百度百科 </span></a></li>
			</ul>
			<div style="margin-top: 120px; text-align: center;">
				<hr>
				<p class="copyright" style="margin-top: -10px; height: 30px;">
					&copy; <a href="https://github.com/liangzhicheng120" target="blank">东岸工作室</a>
				</p>
			</div>
		</div>
	</div>
</div>
