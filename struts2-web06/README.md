	练习OGNL表达式

	1.在Action中使用DomainModel定义数据
	
	2.验证Struts2对请求参数类型的转换
	
	3.访问值栈中的各种数据和方法，包括引用数据和自定义的非私有方法
	
	4.测试Ajax在Struts2中的应用
	
		1).添加依赖：
			struts2-json-plugin => 对应Struts版本
			json-path 			=> 最新版
			
		1).struts.xml 添加单独Action，并实现对应的Action类及方法
			I.struts.xml修改后配置：
			    <package name="basicstruts1" namespace="/" extends="json-default">
				    	<action name="index" class="org.denny.struts.action.OGNLTestAction">
				    		<result>
				    			/index.jsp
				    		</result>
				    	</action>
				    	<action name="ajax" class="org.denny.struts.action.JSONProcessAction" method="responseAjax">
				    		<result type="json" />
				    	</action>
			    	</package>
		    	
			II.JSONProcessAction类：
				public class JSONProcessAction extends ActionSupport implements ServletResponseAware,Serializable{
					private static final long serialVersionUID = 1L;
					private HttpServletRequest request;
					private HttpServletResponse response ;
					private String username ;
					private String password ;
					Map<String, String> map ;
					{
						try {
							request = ServletActionContext.getRequest() ;
							request.setCharacterEncoding("utf-8") ;
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						request = ServletActionContext.getRequest();
					}
					public String responseAjax() throws IOException {
						username = request.getParameter("username") ;
						password = request.getParameter("password") ; 
						PrintWriter wt = new HttpServletResponseWrapper(response).getWriter() ;
						map = new HashMap<>() ; // 实例化map
						// 添加数据
						map.put("username", username) ;
						map.put("password", password) ;
						// 转换为JSON格式字符串
						String json = JSONObject.toJSONString(map);  
						wt.print(json); // 响应
						System.out.println(json);
						wt.flush();
						wt.close();
						return NONE ;
					}
					@Override
					public void setServletResponse(HttpServletResponse response) {
						this.response = response ;
					}
				}
			
			III.解决Ajax对Struts发送请求后，响应乱码的问题
				1.相关的 后台代码都在上面
				2.前台必要的处理如下：
					html:
						<p>
							通过Ajax提交数据：
							<s:form id="f" class="d s">
								<s:textfield name="user.username" class="d s"/>
								<s:textfield type="password" name="user.password" class="d"/>
								<s:submit value="更新对象" class="d"/>
							</s:form>
						</p>
						
						<p>
							private User user ==> 
							<s:if test="user.username!=null">
								<s:property value="user" />
							</s:if> 
						<font id="show_ajax_resp"></font>
						最新对象
						</p>
					javascript:
						var xhr , f , temp_k , temp_v , resp_text;
						f.submit = f_0.onclick = function (e){
							e.preventDefault() ;
				             xhr = new XMLHttpRequest() ;
				             xhr.onreadystatechange = function (){
				                 if ( this.readyState === 4 && this.status === 200 ){ // 请求完成
				                	 	console.log(this.responseText) ; // 解码前，控制台输出
				                	 	resp_text = decodeURI(this.responseText) ; // 接收后解码
				                	 	console.log('responseText' + resp_text) ; // 解码后控制台输出
				                	 	var _temp = JSON.parse(resp_text) ; // 将JSON字符串解码为JSON对象
				                	 	show_ajax_resp.innerText=resp_text ; // 输出到页面font标签中
				                     	console.log( 'Send successfully !' ) ;
				                 }
				             }
				             xhr.open('post','/struts2-web06/ajax!responseAjax',true) ; // 设置请求方式、目标、以及是否异步
				             f = new FormData() ; // h5新增，专用于打包发送form表单数据，尤其可以为ajax上传文件提供便利
				             
				             // 发送前第一次编码
				             temp_k = encodeURI(f_user_username.value) ;
				             temp_v = encodeURI(f_user_password.value) ;
				             
				             // 发送前再一次编码
				             temp_k = encodeURI(f_user_username.value) ;
				             temp_v = encodeURI(f_user_password.value) ;
				             
				             f.append('username',temp_k) ;
				             f.append('password',temp_v) ; 
				             xhr.send(f) ; // 发送请求
				         }
	5.国际化的应用
		1.创建对应国际化资源文件，放在classpath路劲下
			i18n_en_US.properties
			i18n_zh_CN.properties
		2.实现的方式：
			2.1 设置国际化语言文件资源包，struts.xml中增加如下配置：
    				<constant name="struts.custom.i18n.resources" value="i18n" />
    			2.2 重启服务器，在请求的URL后跟request_locale=文档代号(如:zh_CN表示中文，en_US表示英文)
    			
	6.struts2基本页面跳转与传参
		1.<s:url></s:url>标签传参乱码问题：在pom.xml的服务器插件中增加如下配置:
			<configuration>
				<uriEncoding>UTF-8</uriEncoding>
			</configuration> 
		2.参数中多出：',amp;',导致无法获取第二个及以上的参数的问题，解决方式如下：
			传递参数的：url标签中设置 escapeAmp="false" 
		
无效的示例：
	1.通过iterator遍历值栈中的[]对象 无结果
	2.use strust2 tag <s:bean /> 感觉没什么用
	3.in freemarker  freemarker语法无效
	
	
		