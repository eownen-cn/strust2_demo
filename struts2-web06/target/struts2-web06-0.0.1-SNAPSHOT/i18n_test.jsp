<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="getText('info.title')"/></title>
<style type="text/css">
	*{
		list-style:none ;
		text-decoration:none ;
		margin:0;
		padding:0;
		box-sizing:border-box ;
	}
	.block {
		padding-left:30px;
		padding-top:30px;
	}
	body * li{
		padding-left:20px;
		padding-top:10px;
		margin-bottom:20px;
	}
	hr{
		margin:5px 0 ;
	}
	#lang{
		width: 120px;
	    height: 35px;
	    position: fixed;
	    left: 90%;
	    right: 5%;
	    top: 3%;
	    margin: auto;
	}
	
</style>
</head>
<body>
	
	<div class="block">
		<h3><s:property value="getText('info.b1')"/>&lt;s:i18n /&gt;<s:property value="getText('info.b2')"/></h3>
		<hr>
		<%-- <s:i18n name="myCustomBundle">
		   The i18n value for key aaa.bbb.ccc in myCustomBundle is <s:property value="%{getText('i18n')}" />
		</s:i18n> --%>
		<p>
			<s:property value="getText('info.b3')"/><br>
			<ul>
				<li><s:property value="getText('info.b4')"/></li>
				<li><s:property value="getText('info.b5')"/></li>
				<li><s:property value="getText('info.b6')"/></li>
				<li><s:property value="getText('info.b7')"/></li>
			</ul>
		
		<p>
			<s:property value="getText('info.b8')"/><br>
			<ul>
				<li><s:a href="http://lianghui.huanqiu.com/2018/pic/2018-03/2894892.html"><s:property value="getText('info.b9')"/></s:a></li>
				<li><s:a href="http://lianghui.huanqiu.com/2018/roll/2018-03/11656647.html"><s:property value="getText('info.b10')"/></s:a></li>
				<li><s:a href="http://opinion.huanqiu.com/editorial/2018-03/11656593.html"><s:property value="getText('info.b11')"/></s:a></li>
			</ul>
		
		<p>
			
		
	</div>
	<s:set value="getText('info.b12')" var="s_lang" />
	<s:set value="getText('info.b13')" var="s_zh_CN" />
	<s:set value="getText('info.b14')" var="s_en_US" />
	<s:set value="%{'zh_CN'}" var="v_zh_CN" />
	<s:set value="%{'en_US'}" var="v_en_US" />
	<s:select label="Area" id="lang" headerKey="-1" headerValue='%{s_lang}'
       list="#{#v_zh_CN:#s_zh_CN,#v_en_US:#s_en_US}" onchange="javascript:location.href='/struts2-web06/tag/i?request_locale='+this.value;" />
</body>
</html>