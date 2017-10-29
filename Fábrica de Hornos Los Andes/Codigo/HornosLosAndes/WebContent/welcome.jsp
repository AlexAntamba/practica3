<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ include file="verificaSesion.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Hornos Los Andes :: Bienvenido</title>
<link href="css/styles.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>
<div id="content"><!-- header begins -->
<div id="header">
<div id="logo"></div>
<div id="menu">
<ul>
	<li id="button1"><a href="material" title="">Materiales</a></li>
	<li id="button2"><a href="empleado" title="">empleados</a></li>
	<li id="button3"><a href="horno" title="">hornos</a></li>
	<li id="button4"><a href="proveedor" title="">proveedores</a></li>
	<li id="button5"><a href="comprar" title="">Compras</a></li>
</ul>
</div>
</div>
 
<!-- header ends --> <!-- content begins -->
<div id="main">
<div id="right"><jsp:useBean id="beanUsuarioSes"
	class="UTIL.Beans.UsuarioBean" scope="session" /> Bienvenido <jsp:getProperty
	name="beanUsuarioSes" property="nombre" /><br/>Estás logueado como <jsp:getProperty
	name="beanUsuarioSes" property="login" />, <jsp:getProperty
	name="beanUsuarioSes" property="tipoUsuario" /> del sistema.</a></div>
<div id="left">
<h3>desarrollado por</h3>
<ul>
	<p>Luis Canales, Lucki Fernandez, Jorge Luis Jimenez, Arturo
	Marruffo y Jesús Sarmiento.</p>
</ul>
<h3>Menu Principal</h3>
<ul>
	<li id="calendar">
	<div id="calendar1"></div>
	</li>
</ul>
<a href="material">Mantenimiento de Materiales<br />
</a><a href="empleado">Mantenimiento de Empleados</a><br />
<a href="horno">Mantenimiento de Hornos</a><br />
<a href="proveedor">Mantenimiento de Proveedores</a><br />
<a href="comprar">Ordenar Compra de Materiales</a><br />
<a href="factura">Facturacion</a></p>
<a href="cerrarSesion">Cerrar Sesión</a>


</div>
<!--content ends --> <!--footer begins --></div>
</div>
<!-- footer ends-->
</body>
</html>