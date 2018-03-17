package org.denny.struts.dao.impl;

import org.denny.struts.bean.User;
import org.junit.*;
public class UserDaoImplTest {
	
	private UserDaoImpl dao = null ;
	
	{
		dao = new UserDaoImpl() ;
	}
	
	@After
	public void after() {
		UserDaoImpl.showLog();
	}
	
	@Test
	public void testAdd() throws Exception{
		for( int a = 0 ; a < 10 ; a ++ ) {
			dao.add("你很牛班" + a + 1, "nihenniuban");
		}
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(20180327);
	}
	
	@Test
	public void testUpdate() throws Exception{
		dao.update(new User(20180388,"zzzzz","yyyy","铜牌会员"));
	}
	
	@Test
	public void testGetById() throws Exception{
		dao.getById(20180393) ;
	}
	
	@Test
	public void testGetList() throws Exception{
		dao.getList() ;
	}
    
}
