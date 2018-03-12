package org.denny.struts.action;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.denny.struts.ognl.OGNLReferences;
import org.denny.struts.vo.User;

import com.opensymphony.xwork2.ActionSupport;

public class OGNLTestAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	
	// 普通属性
	private Date date ; 							// 日期类型
	private Double price ; 							// 数字类型
	private Boolean flag ; 							// 布尔类型
	private String gender ; 						// 字符串类型
	
	// 基本数据集
	private int[] numberArray ; 					// 数组
	private List<String> contentList;				// StringList集合
	private Map<String,String> contentMap ; 		// StringMap集合
	private Set<String> contentSet ;				// StringSet集合
	
	// 常用形式数据集
	private List<User> userList ; 					// UserList集合
	private Map<String,List<User>> userMapList ;	// UserMapList集合
	private Set<Map<String,User>> userSetMap ;  	// UserSetMap集合
	
	private OGNLReferences ref ; 					// 工具类引用对象
	
	public OGNLReferences getRef() {
		ref = new OGNLReferences() ;
		return ref ;
	}

	public void setRef(OGNLReferences ref) {
		this.ref = ref;
	}

	// 对象属性|域模型
	private User user = new User() ;
	

	{
		// 初始化所有数据
		date = new Date() ;
		price = 78.8 ;
		flag = true ;
		gender = "Gentleman" ;
		numberArray = new int[]{1,3,5,7,9};
		contentList = Arrays.asList("a","b","c") ;
		contentMap = new HashMap<String,String>() ;
		contentMap.put("1001", "龙") ;
		contentMap.put("1002", "永") ;
		contentMap.put("1003", "凌") ;
		contentSet = new TreeSet<>((排,序)->Math.random()>0.5?1:-1) ; // 使用lambda表达式排序，哈哈~
		contentSet.addAll(Arrays.asList("!","How","are","you")) ; // Set集合也是可以通过Arrays.asList添加数据的
		
		userList = Arrays.asList(
				new User("scott","tiger",15),
				new User("system","manager",25),
				new User("sys","change_on_install",35)
				) ;
		userMapList = new HashMap<>() ;
		userMapList.put("orcl_admin_users", userList) ;
		Map<String,User> userMap = new HashMap<>() ;
		userMap.put("u_1001", new User("Eownen","abc123",15)) ;
		userMap.put("u_1002", new User("TheClassic","def456",25)) ;
		userMap.put("u_1003", new User("Denny","ghi789",35)) ;
		userSetMap = new HashSet<>() ;
		userSetMap.add(userMap) ;
		ref = new OGNLReferences() ;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute done !" + this.user);
		return super.execute();
	}

	public List<String> getContentList() {
		return contentList;
	}

	public Map<String, String> getContentMap() {
		return contentMap;
	}

	public Set<String> getContentSet() {
		return contentSet;
	}

	public Date getDate() {
		return date;
	}

	public Boolean getFlag() {
		return flag;
	}

	public String getGender() {
		return gender;
	}

	public int[] getNumberArray() {
		return numberArray;
	}

	public Double getPrice() {
		return price;
	}

	public User getUser() {
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public Map<String, List<User>> getUserMapList() {
		return userMapList;
	}

	public Set<Map<String, User>> getUserSetMap() {
		return userSetMap;
	}
	
	public void setContentList(List<String> contentList) {
		this.contentList = contentList;
	}

	public void setContentMap(Map<String, String> contentMap) {
		this.contentMap = contentMap;
	}

	public void setContentSet(Set<String> contentSet) {
		this.contentSet = contentSet;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setNumberArray(int[] numberArray) {
		this.numberArray = numberArray;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setUserMapList(Map<String, List<User>> userMapList) {
		this.userMapList = userMapList;
	}

	public void setUserSetMap(Set<Map<String, User>> userSetMap) {
		this.userSetMap = userSetMap;
	}
	
	
}
