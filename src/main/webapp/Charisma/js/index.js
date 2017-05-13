var index = {
	url : {
		list : 'note/recommendlist',
		get : 'note/get',
	},
	init : function() {
		$('#index-content').trumbowyg({
			lang : 'zh_cn',
			resetCss : true
		});
		$('#index-content').html(index.html.artical());
		common.doAjaxWithNotAsync(index.url.list, {}, function(data) {
			$('#recommend').html(index.html.ul(data));
		});
	},
	html : {
		ul : function(data) {
			var data = data.value;
			var li_body = '';
			for (var i = 0; i < data.length; i++) {
				li_body += '<li><a class="btn" href="javascript:index.show({0})" target="black">{1}</a></li>'
						.format(data[i]['id'], common.substring(data[i]['title'], 20, '......'));
			}
			var tmpl = '<a class="btn btn-default" href="#"><i class="glyphicon glyphicon-th-list"></i><span> 推荐列表</span></a>';
			tmpl += '<ul class="nav nav-pills nav-stacked text-center" style="display: block; margin-left: 0px;">{0}</ul>'.format(li_body);
			return tmpl;
		},
		header : function(data) {
			return '<h2><i class="glyphicon glyphicon-font"></i> {0}</h2>'.format(data);
		},
		artical : function() {
			var tmpl = '<div class="page-header" style="margin: 0 0 0;">';
			tmpl += '<h2 style="margin-top: 10px; margin-bottom: 5px;"><b>神经网络与深度学习</b></h2>';
			tmpl += '</div>';
			tmpl += '<div class="row ">';
			tmpl += '<div class="col-md-4">';
			tmpl += '<h3>使用神经网络识别手写数字</h3>';
			tmpl += '<p>人类的视觉系统是世上的一个奇迹。考虑以下这串手写的数字：</p>';
			tmpl += '<p>';
			tmpl += '<img src="http://neuralnetworksanddeeplearning.com/images/digits.png" alt="digits" style="width: 200px;">';
			tmpl += '</p>';
			tmpl += '<p>大部分人都能轻易地识别出图上的数字是504192。这个看似简单的过程的背后，实际上很复杂。在我们大脑的每个脑半球中，有一个叫做初级视皮层（primary visual';
			tmpl += 'cortex）的部分，也被称作V1。它拥有1亿4千万个神经元，包含了上百亿的神经元连接。然而，人类的视觉系统不仅仅依赖于V1，还依赖于整套视皮层——V2、V3、V4和V5的协同工作，来实现复杂的图像处理任务。我们的大脑就像一台超级计算机，经过了上亿年的进化，才得以能够出色地理解视觉的世界。识别手写数字不是一个简单的任务，但是，人类极其擅长理解眼睛所看到的东西，并且几乎所有这些工作都是在无意识的情况下完成的，所以我们通常不会意识到我们的视觉系统解决了的任务有多么困难。</p>';
			tmpl += '</div>';
			tmpl += '<div class="col-md-4">';
			tmpl += '<h3>感知机</h3>';
			tmpl += '<p>';
			tmpl += '什么是神经网络？在回答这个问题之前，我会先解释一种叫做感知机（perceptron）的人工神经元。感知机由科学家<a href="https://en.wikipedia.org/wiki/Frank_Rosenblatt" target="_blank">Frank Rosenblatt</a>发明于1950至1960年代，他受到了来自<a';
			tmpl += 'href="http://en.wikipedia.org/wiki/Warren_McCulloch" target="_blank">Warren McCulloch </a>和<a href="http://en.wikipedia.org/wiki/Walter_Pitts" target="_blank">Walter';
			tmpl += 'Pitts</a>的更早<a href="http://scholar.google.ca/scholar?cluster=4035975255085082870" target="_blank">工作</a>的启发。现如今，我们通常使用其它种类的人工神经元模型——在这本书里，以及在许多关于神经网络的最新工作里，主要使用的是一种叫做sigmoid神经元（sigmoid';
			tmpl += 'neuron）的神经元模型。我们会在稍后学习sigmoid神经元。为了理解sigmoid神经元，我们首先需要花一点时间来理解感知机，这是非常有价值的。';
			tmpl += '<div class="comments-icon">';
			tmpl += '<div class="marker">+</div>';
			tmpl += '</div>';
			tmpl += '</p>';
			tmpl += '<p>那么，感知机是怎么工作的呢？感知机的输入是几个二进制，输出是一位单独的二进制：</p>';
			tmpl += '<p>';
			tmpl += '<img src="http://neuralnetworksanddeeplearning.com/images/tikz0.png" alt="tikz0" style="width: 200px;">';
			tmpl += '</p>';
			tmpl += '</div>';
			tmpl += '<div class="col-md-4 ">';
			tmpl += '<div class="well">';
			tmpl += '<p>';
			tmpl += '<img src="http://neuralnetworksanddeeplearning.com/images/tikz14.png" alt="tikz14" style="width: 100%;">';
			tmpl += '</p>';
			tmpl += '<p>';
			tmpl += '<img src="http://ww1.sinaimg.cn/large/006fVPCvjw1f25khyl3uuj30be07pjrm.jpg" alt="img" style="width: 100%;">';
			tmpl += '</p>';
			tmpl += '</div>';
			tmpl += '</div>';
			tmpl += '</div>';
			return tmpl;
		}
	},
	show : function(id) {
		common.doAjaxWithNotAsync(index.url.get, {
			id : id
		}, function(data) {
			$('#index-content').html(data.value['content']);
			$('#index-header').html(index.html.header(data.value['title']))
		});
	},
}