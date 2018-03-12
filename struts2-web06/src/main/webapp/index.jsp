<%@ page language="java" pageEncoding="UTF-8"
	import="java.util.Iterator"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	// 通过request获取绝对路劲

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" // 得到传输协议
			+ request.getServerName() + ":" // 得到服务器主机域名或IP
			+ request.getServerPort() // 得到端口号
			+ path + "/"; // 得到项目上下文路径，即 '/项目名'
%>
<html>
<head>
<meta charset="utf-8">
<title>OGNL测试</title>
<style type="text/css">
.d {
	display: inline-block ! important;
	padding: 0;
	outline: none;
	margin: 0 3px;
	text-indent: 3px;
	text-overflow: none;
}

.d:not(form) {
	width: 120px;
	height: 40px;
}

.s {
	margin-left: 0;
}
</style>
</head>
<body>
	<s:debug />
	<p>
		private Date date ==>
		<s:if test="date!=null">
			<s:property value="date" />
		</s:if>
	</p>
	<p>
		private Double price ==>
		<s:if test="price!=''">
			<s:property value="price" />
		</s:if>
	</p>
	<p>
		private Boolean flag ==>
		<s:if test="flag">
			<s:property value="flag" />
		</s:if>
	</p>
	<p>
		private String gender ==>
		<s:if test="gender!=''">
			<s:property value="gender" />
		</s:if>
	</p>
	<p>
		private int[] numberArray ==>
		<s:property value="numberArray" />
		自动遍历输出
	</p>
	<p>
		private List&lt;String&gt; contentList ==>
		<s:property value="contentList" />
		自动遍历输出
	</p>
	<p>
		private Map&lt;String,String&gt; contentMap ==>
		<s:property value="contentMap" />
		自动遍历输出
	</p>
	<p>
		private Set&lt;String&gt; contentSet ==>
		<s:property value="contentSet" />
		自动遍历输出
	</p>
	<p>
		private List&lt;User&gt; userList ==>
		<s:property value="userList" />
		自动遍历输出
	</p>
	<p>
		private Map&lt;String,List&lt;User&gt;&gt; userMapList ==>
		<s:property value="userMapList" />
		自动遍历输出
	</p>
	<p>
		private Set&lt;Map&lt;String,User&gt;&gt; userSetMap ==>
		<s:property value="userSetMap" />
		自动遍历输出
	</p>
	<p>
		通过form提交数据：
		<s:form action="index" class="d s" method="post">
			<s:textfield name="user.username" class="d s" />
			<s:textfield type="password" name="user.password" class="d" />
			<s:submit value="更新对象" class="d" />
		</s:form>
	</p>
	<p>
		通过Ajax提交数据：
		<s:form id="f" class="d s">
			<s:textfield name="user.username" class="d s" />
			<s:textfield type="password" name="user.password" class="d" />
			<s:submit value="更新对象" class="d" />
		</s:form>
	</p>

	<p>
		private User user ==>
		<s:if test="user.username!=null">
			<s:property value="user" />
		</s:if>
		<font id="show_ajax_resp"></font> 最新对象
	</p>

	<p>
		访问工具类的_普通引用对象的_普通字段：
		<s:property value="ref.infos" />
	</p>
	<p>
		访问工具类的_普通引用对象的_对象字段：
		<s:property value="ref.user.username" />
	</p>
	<p>
		访问值栈中的_普通引用对象的_普通方法：
		<s:property value="ref.info('!!!')" />
	</p>
	<p>
		访问工具类的静态字段：
		<s:property value="@org.denny.struts.ognl.OGNLReferences@INFO" />
	</p>
	<p>
		访问工具类的静态方法：
		<s:property value="@org.denny.struts.ognl.OGNLReferences@info()" />
	</p>
	<p>
		访问Math类的静态字段：
		<s:property value="@@PI" />
	</p>
	<p>
		访问Math类的静态方法：
		<s:property value="@@abs(-9/3)" />
	</p>
	<p>
		访问普通类的构造方法：
		<s:property value="new org.denny.struts.vo.User()" />
	</p>
	<p>
		遍历找出user集合中,username=scott的user的password：
		<s:property value="userList.{?#this.username=='scott'}[0].password" />
	</p>
	<p>
		遍历找出user集合中,user的age大于25的user中，第一个的username：
		<s:property value="userList.{^#this.age>25}.{username}[0]" />
	</p>
	<p>
		遍历找出user集合中,user的age小于50的user中，倒数第一个的username：
		<s:property value="userList.{$#this.age < 50}.{username}[0]" />
	</p>
	<p>
		遍历找出user集合中,user的age小于50的user中，倒数第一个的username的数据是否为空：
		<s:property value="userList.{$#this.age < 50}.{username}[0] == null" />
	</p>
	<p>
		通过[]访问值栈中的对象
		<s:property value="[0]" />
	</p>
	<p>
		通过iterator遍历值栈中的[]对象
		<s:iterator value="[0]" var="i">
			<s:if test="i.ref!= null">
				<s:property value="i" />
			</s:if>
		</s:iterator>
	</p>
	<p>
		通过iterator遍历值栈中的userList集合
		<s:iterator value="userList" var="u">
			<s:property value="u" />
		</s:iterator>
	</p>
	<p>
		use strust2 tag bean<br>
		<s:bean name="org.denny.struts.vo.User" var="myuser">
			<s:param name="username" value="黑咖啡" />
			<s:param name="password" value="TheBlackOfCoffee" />
			<s:property value="username" />
		</s:bean>
		in jsp form : <br>
		<s:property value="#myuser.username" />
		in freemarker form : <br>
		<s:property value="[s:property value='#myuser.username'/]" />
	</p>
	<p>
		append标签建立自定义的集合到context中,append的每个子项必须是集合(List,Map,Set):<br>
		追加普通字段,
		<s:append var="myAppended">
			<s:param value="%{userList}" name="ul1" />
			<s:param value="%{userList}" name="ul2" />
			<s:param value="%{userList}" name="ul3" />
		</s:append>
		使用iterator遍历这个新的集合：
		<s:iterator value="%{#myAppended}" var="v" status="i" step="1">
			<s:if test="{#v.username}[0] == 'sys'">
				<s:property value="{#v.password}" />
			</s:if>
		</s:iterator>
	<p>
	


</body>
<script type="text/javascript" src="./js/main.js">
	
</script>
</html>