<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

	
	<s:debug />
	<s:if test="%{#parameters.p != null && #parameters.pp != null}">
		This is the target jsp with <s:property value="%{#parameters.p}" /><s:property value="%{#parameters.pp}" />!
	</s:if>
	<s:else>
		This is the target jsp !
	</s:else>
