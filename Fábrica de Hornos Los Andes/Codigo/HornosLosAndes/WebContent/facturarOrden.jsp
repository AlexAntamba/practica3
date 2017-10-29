<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:display="urn:jsptld:http://displaytag.sf.net">
	<jsp:directive.page import="Compras.Beans.OrdenDeCompraBean" />
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
<title>Insert title here</title>
<style type="text/css" media="all">
@import url("css/maven-base.css");

@import url("css/maven-theme.css");

@import url("css/site.css");

@import url("css/screen.css");
</style>
</head>
<body>
<jsp:include page="cabecera.jsp"/>
<form method="post" action="factura" name="frmFactura">
<display:table export="true" name="sessionScope.listaOrden" pagesize="10"
		decorator="DECORATOR.OrdenDecorator">
		<display:column property="listar" title="Codigo"/>
		<display:column property="prioridad" />
		<display:column property="fecha" />
</display:table>
</form>
<td><a href="welcome.jsp">Regresar</a></td><br/>
<jsp:include page="footer.jsp"/>
</body>
</html>
</jsp:root>