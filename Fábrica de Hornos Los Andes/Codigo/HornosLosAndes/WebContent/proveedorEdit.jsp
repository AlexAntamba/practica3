<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="verificaSesion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hornos Los Andes ::  Modificar Proveedor</title>
<script language="JavaScript" type="text/javascript">
	function cancelar(){
		location.href="proveedor";	
	}
</script>
<script type="text/javascript">
function validar(e,modo) { // 1
tecla = (document.all) ? e.keyCode : e.which; // 2
if (tecla==8) return true; // 3
patron = (modo=='letra') ? /[A-Za-zs]/ : /d/ // 4
te = String.fromCharCode(tecla); // 5
return patron.test(te); // 6
}
</script>
<script language="javascript">
function numero (){
	var i;
	for (i = 0; i < document.frmProveedor.telefono.value.length; i++){
		if (document.frmProveedor.telefono.value.charCodeAt(i) < 48 || document.frmProveedor.telefono.value.charCodeAt(i) > 57)
		{
		document.frmProveedor.telefono.value = document.frmProveedor.telefono.value.slice(0, i);
		}
		}
	}
</script>
<SCRIPT LANGUAGE="JavaScript">
function isEmailAddress(theElement, nombre_del_elemento )
{
var s = theElement.value;
var filter=/^[A-Za-z][A-Za-z0-9_]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/;
if (s.length == 0 ) return true;
if (filter.test(s))
return true;
else
alert("Ingrese una dirección de correo válida");
theElement.focus();
return false;
}
</SCRIPT>
<script language="javascript">
	function campos(theElement, nombre_del_elemento){
		if(document.frmProveedor.nombre.value == ""){
			alert("Ingrese su Nombre")
			document.frmProveedor.nombre.focus()
			return false;
		}
		if(document.frmProveedor.direccion.value == ""){
			alert("Ingrese su Direccion")
			document.frmProveedor.direccion.focus()
			return false;
		}
		if(document.frmProveedor.telefono.value == ""){
			alert("Ingrese su telefono")
			document.frmProveedor.telefono.focus()
			return false;
		}
		if(document.frmProveedor.TextField.value == ""){
			alert("Ingrese su e-mail")
			document.frmProveedor.TextField.focus()
			return false;
		}
		if(document.frmProveedor.ciudad.value == ""){
			alert("Ingrese su Ciudad")
			document.frmProveedor.ciudad.focus()
			return false;
		}
		if(document.frmProveedor.TextField.value.length != ""){
			var s = theElement.value;
			var filter=/^[A-Za-z][A-Za-z0-9_]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/;
			if (s.length == 0 ) return true;
			if (filter.test(s))	return true;
			else{
			alert("Ingrese una dirección de correo válida");
			theElement.focus();
			return false;
			}
		}
		return true;
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
<jsp:include page="verificaSesion.jsp"/>
<%@ include file="cabecera.jsp"%>
<jsp:useBean id="proveedorReq" class="MaestroProveedores.Beans.ProveedorBean" scope="request" />
<form method="post" action="proveedor" name="frmProveedor"><input
	type="hidden" name="accion" value="modificar">
<input type="hidden" name="codigo"	value='<jsp:getProperty name="proveedorReq" property="codigo" />'>
<table border="1">
	<tr>
		<td>Nombre</td>
		<td><input type="text" name="nombre"
			value='<jsp:getProperty name="proveedorReq" property="nombre" />'
		maxlength="30"></td>
	</tr>
	<tr>
		<td>Direccion</td>
		<td><input type="text" name="direccion" maxlength="30"
			value='<jsp:getProperty name="proveedorReq" property="direccion" />'></td>
	</tr>
	<tr>
		<td>Telefono</td>
		<td><input type="text" name="telefono"
			value='<jsp:getProperty name="proveedorReq" property="telefono" />'
		maxlength="10" onkeyup="numero()"></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><input type="text" name="TextField" maxlength="30" 
			value='<jsp:getProperty name="proveedorReq" property="email" />'></td>
	</tr>
	<tr>
		<td>Ciudad</td>
		<td><input type="text" name="ciudad"
			value='<jsp:getProperty name="proveedorReq" property="ciudad" />'
	maxlength="30" onkeypress="return validar(event,'letra')"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Grabar" ONCLICK="return campos(TextField,'TextField')"></td>
		<td><input type="button" value="Cancelar" onclick="cancelar()"></td>
	</tr>
</table>
</form>
<%@ include file="footer.jsp"%>
</body>
</html>