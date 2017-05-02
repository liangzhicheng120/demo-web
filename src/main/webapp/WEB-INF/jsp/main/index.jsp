<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="liangzhicheng">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="#" type="image/png">
<title>首页</title>
<link id="bs-css" href='<%=basePath%>Charisma/css/theme/bootstrap-cerulean.min.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/charisma-app.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/fullcalendar.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='<%=basePath%>Charisma/css/chosen.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css//colorbox.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/responsive-tables.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/uploadify.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/main.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/mystyle.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/animate.min.css' rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@include file="../main/navbar.jsp"%>

	<div class="ch-container" style="margin-top: -15px;">
		<div class="row">
			<%@include file="../main/sidebar.jsp"%>
			<div id="content" class="col-lg-10 col-sm-10">
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-font"></i> Neural Networks and Deep Learning
								</h2>
							</div>
							<div class="box-content">
								<div class="page-header" style="margin: 0 0 0;">
									<h2 style="margin-top: 10px;margin-bottom: 5px;">神经网络与深度学习</h2>
								</div>
								<div class="row ">
									<div class="col-md-4">
										<h3>使用神经网络识别手写数字</h3>
										<p>人类的视觉系统是世上的一个奇迹。考虑以下这串手写的数字：</p>
										<p>
											<img src="http://neuralnetworksanddeeplearning.com/images/digits.png" alt="digits" style="width: 200px;">
										</p>
										<p>大部分人都能轻易地识别出图上的数字是504192。这个看似简单的过程的背后，实际上很复杂。在我们大脑的每个脑半球中，有一个叫做初级视皮层（primary visual
											cortex）的部分，也被称作V1。它拥有1亿4千万个神经元，包含了上百亿的神经元连接。然而，人类的视觉系统不仅仅依赖于V1，还依赖于整套视皮层——V2、V3、V4和V5的协同工作，来实现复杂的图像处理任务。我们的大脑就像一台超级计算机，经过了上亿年的进化，才得以能够出色地理解视觉的世界。识别手写数字不是一个简单的任务，但是，人类极其擅长理解眼睛所看到的东西，并且几乎所有这些工作都是在无意识的情况下完成的，所以我们通常不会意识到我们的视觉系统解决了的任务有多么困难。</p>
									</div>
									<div class="col-md-4">
										<h3>感知机</h3>
										<p>
											什么是神经网络？在回答这个问题之前，我会先解释一种叫做感知机（perceptron）的人工神经元。感知机由科学家<a href="https://en.wikipedia.org/wiki/Frank_Rosenblatt" target="_blank">Frank Rosenblatt</a>发明于1950至1960年代，他受到了来自<a
												href="http://en.wikipedia.org/wiki/Warren_McCulloch" target="_blank">Warren McCulloch </a>和<a href="http://en.wikipedia.org/wiki/Walter_Pitts" target="_blank">Walter Pitts</a>的更早<a
												href="http://scholar.google.ca/scholar?cluster=4035975255085082870" target="_blank">工作</a>的启发。现如今，我们通常使用其它种类的人工神经元模型——在这本书里，以及在许多关于神经网络的最新工作里，主要使用的是一种叫做sigmoid神经元（sigmoid
											neuron）的神经元模型。我们会在稍后学习sigmoid神经元。为了理解sigmoid神经元，我们首先需要花一点时间来理解感知机，这是非常有价值的。
										<div class="comments-icon">
											<div class="marker">+</div>
										</div>
										</p>
										<p>那么，感知机是怎么工作的呢？感知机的输入是几个二进制，输出是一位单独的二进制：</p>
										<p>
											<img src="http://neuralnetworksanddeeplearning.com/images/tikz0.png" alt="tikz0" style="width: 200px;">
										</p>
									</div>
									<div class="col-md-4 ">
										<div class="well">
											<p>
												<img src="http://neuralnetworksanddeeplearning.com/images/tikz14.png" alt="tikz14" style="width: 100%;">
											</p>
											<p>
												<img src="http://ww1.sinaimg.cn/large/006fVPCvjw1f25khyl3uuj30be07pjrm.jpg" alt="img" style="width: 100%;">
											</p>
										</div>
									</div>
								</div>
								<!--/row -->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=basePath%>Charisma/js/jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.cookie.js"></script>
	<script src="<%=basePath%>Charisma/js/moment.min.js"></script>
	<script src="<%=basePath%>Charisma/js/fullcalendar.min.js"></script>
	<script src="<%=basePath%>Charisma/js/chosen.jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.noty.js"></script>
	<script src="<%=basePath%>Charisma/js/bootstrap-tour.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.raty.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.iphone.toggle.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.uploadify-3.1.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.history.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.autogrow-textarea.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Charisma/js/charisma.min.js"></script>
	<script src="<%=basePath%>Charisma/js/common.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.hDialog.min.js"></script>
</body>
</html>
