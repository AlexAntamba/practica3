<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:display="urn:jsptld:http://displaytag.sf.net">
	<jsp:directive.page import="MaestroHornos.Beans.HornoBean" />
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
	<title>Hornos Los Andes :: Orden de Compra</title>
<script language="JavaScript" type="text/javascript">
	function comprar(){
		frmcompras.operacion.value="enviar";
		frmcompras.submit();	
	}
</script>
	<style type="text/css" media="all">
@import url("css/maven-base.css");

@import url("css/maven-theme.css");

@import url("css/site.css");

@import url("css/screen.css");
</style>
</head>
<body>
<jsp:include page="cabecera.jsp"/>

<form method="post" action="comprar" name="frmcompras">
<tr><td>                                    </td>
	<td>Prioridad : </td><td>
	</td>      <td>
					<select name="prioridad">
						<option value="Alta" >Alta</option>
						<option value="Media" >Media</option>
						<option value="Baja" >Baja</option>
					</select>
				</td></tr><br/><br/>
<input type="hidden" name="operacion" value="comprar" />
<display:table export="true" name="sessionScope.compras" pagesize="10"
		decorator="DECORATOR.ComprasDecorator">
		<display:column property="codigo" />
		<display:column property="modelo" />
		<display:column property="stock" />		
		<display:column property="cantidad" />
</display:table>
<table>
	<tr>
		<td><a href="comprarHornos.jsp">Seguir Comprando</a></td>
		<td><a href="JavaScript: comprar()">Comprar</a></td>
	</tr>
</table>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
</jsp:root>