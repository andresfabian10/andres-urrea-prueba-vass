<%@ include file="./init.jsp" %>

<portlet:actionURL name="/hola" var="actionURL" />



<aui:form action="<%= actionURL %>" method="post" >
		<aui:input name="name" label="form.label.name" required="true" />
		<aui:input name="email" label="form.label.email" required="true" type="email" />
		<aui:button type="submit" value="form.button.submit" />
	</aui:form>
