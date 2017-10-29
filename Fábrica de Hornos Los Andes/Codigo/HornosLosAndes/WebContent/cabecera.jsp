<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link
	href="../../../../Desktop/HornosLosAndesv1.0/www/template/6848/hornoslosandes/css/styles.css"
	rel="stylesheet" type="text/css" />
<jsp:useBean id="beanUsuarioSes" class="UTIL.Beans.UsuarioBean"
	scope="session" />
<jsp:include page="/verificaSesion.jsp" />
<table width="100%" border="0" cellspacing="0" cellpadding="00">
	<tr>
		<td bgcolor="#FFCC59">
		<div align="center"><img
			src="img/header.jpg"
			width="778" height="337" alt="" /></div>
		</td>
	</tr>
</table>

<div align="left">
  <jsp:getProperty name="beanUsuarioSes"
	property="nombre" />  
  estás logueado como
  <jsp:getProperty
	name="beanUsuarioSes" property="login"/>  | 
<jsp:getProperty
	name="beanUsuarioSes" property="tipoUsuario" /> 
del sistema. <a href="cerrarSesion">Cerrar Sesión</a>.</div>
