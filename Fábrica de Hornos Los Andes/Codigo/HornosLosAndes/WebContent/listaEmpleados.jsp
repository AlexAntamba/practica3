<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:display="urn:jsptld:http://displaytag.sf.net">
	<jsp:directive.page import="MaestroMateriales.Beans.MaterialBean" />
	<jsp:directive.page language="java"
		contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Hornos Los Andes :: Lista de Empleados</title>
	<style type="text/css" media="all">
@import url("css/maven-base.css");

@import url("css/maven-theme.css");

@import url("css/site.css");

@import url("css/screen.css");
</style>
	</head>
	<body>
	<jsp:include page="cabecera.jsp"/>
	<form name="frmEmpleado" method="get" action="empleado"><input
		type="hidden" name="operacion" value="buscar" />
	<table border="1">
		<tr>
			<td><input type="submit" value="Buscar" /></td>
			<td>Nombre <input type="text" name="nombre" /></td>
			<td>Apellido <input type="text" name="apellido" /></td>
		</tr>
	</table>
	</form>
	<form name="frmEmpleados" action="empleado" method="post"><display:table
		name="sessionScope.listaEmpleados" pagesize="10"
		decorator="DECORATOR.EmpleadosDecorator" export="true">
		<display:column property="codigo" />
		<display:column property="modificar" title="Nombre" />
		<display:column property="apellido" />
		<display:column property="direccion" />
		<display:column property="email" />
		<display:column property="telefono" />
		<display:column property="eliminar" />
	</display:table> <a href="empleadoNew.jsp">Ingresar Empleado</a></form>
	<a href="welcome.jsp">Regresar</a>
<jsp:include page="footer.jsp"/>	
</body>
	</html>
</jsp:root>