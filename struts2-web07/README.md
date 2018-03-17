经测试：httpheader
<result name="success" type="httpheader">
	<param name="status">204</param>
	<param name="headers.a">a custom header value</param>
	<param name="headers.b">another custom header value</param>
</result>

<result name="proxyRequired" type="httpheader">
	<param name="error">305</param>
	<param name="errorMessage">this action must be accessed through a proxy</param>
</result>
无效