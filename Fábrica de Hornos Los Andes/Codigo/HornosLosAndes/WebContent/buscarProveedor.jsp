<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0" xmlns:display="urn:jsptld:http://displaytag.sf.net">
    <jsp:directive.page import="MaestroProveedores.Beans.ProveedorBean"/>
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
<title>Hornos Los Andes :: Buscar Proveedor</title>
<style type="text/css" media="all">
      @import url("css/maven-base.css");
      @import url("css/maven-theme.css");
      @import url("css/site.css");
      @import url("css/screen.css");
</style>
</head>
<body>
<jsp:include page="cabecera.jsp"/>
<h3>Resultados de la Busqueda</h3> 
<form name="frmProveedores" action="proveedor" method="post">
<display:table name="requestScope.Resultados" pagesize="10" decorator="DECORATOR.ProveedoresDecorator">
		<display:column property="codigo" />
		<display:column property="modificar" title="nombre" />
		<display:column property="direccion" />
		<display:column property="telefono" />
		<display:column property="email" />
		<display:column property="ciudad" />
		<display:column property="fechainicio" />
		<display:column property="estado" />
		<display:column property="eliminar" />
</display:table>
<br />
<a href="proveedor">Volver al Listado</a>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
</jsp:root>