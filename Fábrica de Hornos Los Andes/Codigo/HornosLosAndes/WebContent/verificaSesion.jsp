<%
	//Para verificar la sesi�n
	if (session.getAttribute("beanUsuarioSes") == null){
		response.sendRedirect("login.html");
	}
%>