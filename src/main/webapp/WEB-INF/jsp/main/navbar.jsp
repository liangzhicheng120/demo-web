<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="navbar navbar-default" role="navigation">
	<div class="navbar-inner">
		<button type="button" class="navbar-toggle pull-left animated flip">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.html"> <img alt="Charisma Logo" src="./Charisma/images/logo20.png" class="hidden-xs" /> <span>DEMOWEB</span></a>
		<div class="btn-group pull-right">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				<i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${sessionScope.ADMIN }</span> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="exit.html">安全退出</a></li>
			</ul>
		</div>
		<div class="btn-group pull-right theme-container animated tada">
			<button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				<i class="glyphicon glyphicon-tint"></i><span class="hidden-sm hidden-xs"> 更换主题</span> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" id="themes">
				<li><a data-value="classic"><i class="whitespace"></i> 经典模式1</a></li>
				<li><a data-value="lumen"><i class="whitespace"></i> 经典模式2</a></li>
				<li><a data-value="cerulean"><i class="glyphicon glyphicon-ok"></i> 蓝色经典1</a></li>
				<li><a data-value="cyborg"><i class="whitespace"></i> 夜间模式1</a></li>
				<li><a data-value="slate"><i class="whitespace"></i> 夜间模式2</a></li>
				<li><a data-value="darkly"><i class="whitespace"></i> 夜间模式3</a></li>
				<li><a data-value="simplex"><i class="whitespace"></i> 红色经典1</a></li>
				<li><a data-value="united"><i class="whitespace"></i> 红色经典2</a></li>
				<li><a data-value="spacelab"><i class="whitespace"></i> 灰色空间1</a></li>
			</ul>
		</div>
	</div>
</div>

