<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width" />
        <title>日历邀请</title>
        <style type="text/css" >body,a,ul{margin:0;padding:0;list-style:none;word-wrap:break-word;text-decoration:none;font-family:"微软雅黑","Microsoft Yahei",sans-serif}.wrap{margin:0 auto;padding:0 12px;max-width:432px;text-align:center}.calendar{margin:51px auto 20px;width:66px;height:66px;border:1px solid #b9b9b9}.month{height:27px;line-height:27px;font-size:14px;color:#d9302b;background:#e2e2e2}.day{height:39px;line-height:39px;font-size:36px;color:#474747;background:#fafcfc}.title{padding:5px 0;font-size:18px}.prompt{color:#a3a3a3}.flyme{padding:73px 12px 0;font-size:0}.copyright{padding:8px 12px 24px;line-height:15px;font-size:10px;color:#7f7f7f}</style>
    </head>
	<body>
		<div class="wrap">
            <div class="calendar">
                <div id="month" class="month"></div>
                <div id="day" class="day"></div>
            </div>
            <div class="title">找不到事件详细信息</div>
            <div class="prompt">${message}</div>
            <div class="flyme">
                <img width="106" height="34" src="http://cal.meizu.com/resources/cal/images/flyme_263d305.png" />
            </div>
            <div class="copyright">©<span id="year"></span>
                Meizu Telecom Equipment Co.Ltd. All rights reserved.
            </div>
        </div>
        <script type="text/javascript">window.onload=function(){var e=new Date;document.getElementById("year").innerHTML=e.getFullYear(),document.getElementById("month").innerHTML=e.getMonth()+1+"月",document.getElementById("day").innerHTML=e.getDate()};</script>
	</body>
</html>