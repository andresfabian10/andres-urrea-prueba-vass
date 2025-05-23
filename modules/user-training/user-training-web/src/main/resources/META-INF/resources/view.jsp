
<%@ include file="./init.jsp"%>
<%@page import="com.user.training.vass.web.constants.MVCCommandNames"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page
	import="com.user.training.vass.web.configuration.CustomWebConfiguration"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>


<portlet:actionURL name="<%=MVCCommandNames.ACTION_CREATE_USER%>"
	var="actionURL" />
	
<portlet:actionURL name="<%=MVCCommandNames.ACTION_CREATE_USER_OBJECTS%>"
	var="actionObjectURL" />

<liferay-ui:error key="nameRequired" message="El nombre es obligatorio." />
<liferay-ui:error key="emailInvalid" message="El correo electr�nico no es v�lido." />
<liferay-ui:error key="errorService" message="Error en consumir el servicio" />

<%
CustomWebConfiguration n2f3WebConfiguration = (CustomWebConfiguration) request.getAttribute(CustomWebConfiguration.class.getName());
%>




<c:choose>
	<c:when test="${!isAdmin}">
		<p
			style="color: <%=n2f3WebConfiguration.fontColor()%>; font-family: <%=n2f3WebConfiguration.fontFamily()%>; font-size: <%=n2f3WebConfiguration.fontSize()%>pt;">

			<%=n2f3WebConfiguration.welcomeTitle()%><br />

		</p>
		
		<aui:form action="<%=actionURL%>" method="post">
			<aui:input name="name" label="Escribe tu nombre" required="true">
				<aui:validator name="required" />
			</aui:input>

			<aui:input name="email" label="Escribe tu email" type="email"
				required="true">
				<aui:validator name="required" />
				<aui:validator name="email" />
			</aui:input>
			<aui:button type="submit" value="Guardar" />
		</aui:form>
		
		
		
	
		
		
	</c:when>
	<c:otherwise>
	
		<div class="alert alert-info">
			
			<strong class="lead">Info:</strong>You Are Administrator!
		</div>
	</c:otherwise>

</c:choose>