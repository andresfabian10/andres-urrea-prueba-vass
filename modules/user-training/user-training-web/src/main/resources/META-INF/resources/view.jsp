
<%@ include file="./init.jsp" %>
<%@page import="com.user.training.vass.web.constants.MVCCommandNames"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.user.training.vass.web.configuration.CustomWebConfiguration" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>


<portlet:actionURL name="<%= MVCCommandNames.ACTION_CREATE_USER %>" var="actionURL" />

<liferay-ui:error key="nameRequired" message="El nombre es obligatorio." />
<liferay-ui:error key="emailInvalid" message="El correo electrónico no es válido." />

<%
CustomWebConfiguration n2f3WebConfiguration = (CustomWebConfiguration)request.getAttribute(CustomWebConfiguration.class.getName());
%>

<p
	style="color: <%= n2f3WebConfiguration.fontColor() %>; font-family: <%= n2f3WebConfiguration.fontFamily() %>; font-size: <%= n2f3WebConfiguration.fontSize() %>pt;"
>
	
	<%= n2f3WebConfiguration.welcomeTitle() %><br />
	
</p>


<liferay-ui:message key="prueba.caption"/>

<aui:form action="<%= actionURL %>" method="post" >
		<aui:input name="name" label="form.label.name"  />
		<aui:input name="email" label="Escribe tu email" />
		<aui:button type="submit" value="Guardar" />
	</aui:form>



