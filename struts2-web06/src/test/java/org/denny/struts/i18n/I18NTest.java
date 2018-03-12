package org.denny.struts.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class I18NTest {
	
	
	public String getMsg(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("i18n",locale) ;
		return bundle.getString("msg");
	}
	
	@Test
	public void test() {
		System.out.println("英语，你好：" + getMsg(Locale.US));
		System.out.println("中文，你好：" + getMsg(Locale.CHINA));
	}
	
}
