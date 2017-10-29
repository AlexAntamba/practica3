<%
	//Para verificar la sesión
	if (session.getAttribute("beanUsuarioSes") == null){
		response.sendRedirect("login.html");
	}
%>