<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>列表查询</title>
<link type="text/css" href="../css/main.css" rel="stylesheet" />
</head>
<body>

	<s:debug cssClass="debug"/>
	<ul>
		<li><h2 class="c list_title">用户列表</h2></li>
		<li>
			<span class="item">用户编号</span>
			<span class="item">用户名</span>
			<span class="item">用户密码</span>
			<span class="item">会员等级</span>
			<span class="item ctrls">选项</span>
		</li>
		<s:iterator value="userList">
			<li id="li_<s:property value='#this.uid'/>">
				<span class="item"><s:property value="#this.uid"/></span>
				<span class="item"><input class="filed" disabled value="<s:property value='#this.username' />"/></span>
				<span class="item"><input class="filed" disabled value="<s:property value='#this.password' />"/></span>
				<span class="item"><input class="filed" disabled value="<s:property value='#this.vipLevel' />"/></span>
				<span class="item ctrls">
					<s:url value="user/edit" var="u_save" escapeAmp="false">
						<s:param name="uid" value="#this.uid"/>
					</s:url>
					<s:a class="white" onclick="edit(this,%{#this.uid})">修改</s:a>
					
					 / 
					 
					<s:url value ="user/del" var="u_del" escapeAmp="false">
						<s:param name="uid" value="#this.uid" />
					</s:url>
					<s:a class="red" onclick="confirm('确定删除=> %{#this.username} <= ? ')?del(this,%{#this.uid}):void(0);">删除</s:a>
				</span>
			</li>
		</s:iterator>
	</ul>
	
</body>
	<script type="text/javascript" src="../js/main.js"></script>
</html>