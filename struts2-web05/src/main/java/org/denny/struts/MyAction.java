package org.denny.struts;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.denny.vo.People ;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class MyAction extends ActionSupport implements ModelDriven<People>,ServletRequestAware{

	private static final long serialVersionUID = 1L;
	
	private People people = new People() ;
	
	private HttpServletRequest request ;
	
	private HttpSession session ;
	
	private ServletContext application ;

	public String execute() {
		double rand = Math.random() * 10000000 ;
		this.people.setUsername(this.people.getUsername() + " : " + rand);
		this.people.setPassword(this.people.getPassword() + " : " + rand);
		System.out.println("username : " + this.people.getUsername());
		System.out.println("password : " + this.people.getPassword());
		this.addFieldError("username", people.getUsername());
		this.addActionError(people.getUsername());
		this.addActionMessage(people.getUsername());
		return SUCCESS ;
	}

	@Override
	public People getModel() {
		return this.people;
	}
	
	/**
	 * 实现注册
	 * @return
	 */
	public String register() {
		System.out.println(request.getContextPath()+ request.getRequestURI());
		try {
			this.isEmpty() ;
			return this.checkUser();
		} catch (Exception e) {
			this.addFieldError("register_error", e.getMessage());
			return INPUT ;
		}
	}

	/**
	 * 实现登陆
	 * @return
	 */
	public String login() {
		System.out.println(request.getContextPath()+ request.getRequestURI());
		this.isEmpty() ;
		return this.checkUserLogin();
	}

	private String checkUser() {
		if ( application.getAttribute(people.getUsername()) == null && 
				session.getAttribute(people.getUsername()) == null ) {
			application.setAttribute(people.getUsername(), this.people);
			session.setAttribute(people.getUsername(), this.people);
			System.out.println("注册成功！");
			People p = (People) application.getAttribute(people.getUsername()) ;
			System.out.println("用户名:" + p.getUsername());
			System.out.println("密码:" + p.getPassword());
			return SUCCESS ;
			
		} else {
			this.addFieldError("register_error", "用户已存在！");
			return INPUT ;
		}
	}

	private String isEmpty() {
		if ( "".equals(this.people.getUsername()) ) {
			this.addFieldError("register_error", "用户名不能为空!") ;
			return INPUT ;
		}
		if ( "".equals(this.people.getPassword()) ) {
			this.addFieldError("register_error", "密码不能为空!");
			return INPUT ;
		}
		return null ;
	}
	
	private String checkUserLogin() {
		try {
			People p = (People) application.getAttribute(people.getUsername()) ;
			System.out.println("用户名:" + p.getUsername());
			System.out.println("密码:" + p.getPassword());
			if ( p.getUsername().equals(people.getUsername()) &&
				 p.getPassword().equals(people.getPassword())) {
				System.out.println("登陆成功！");
				return SUCCESS ;
			}
		} catch (Exception e) {
			this.addFieldError("login_error", e.getMessage());
			System.out.println("登陆异常！!");
			application.setAttribute(people.getUsername(), "");
			return INPUT ;
		}
		System.out.println("用户名或密码错误!");
		this.addFieldError("login_error", "用户名或密码错误!");
		return INPUT ;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request ;
		this.session = request.getSession() ;
		this.application = session.getServletContext() ;
	}
	
}
