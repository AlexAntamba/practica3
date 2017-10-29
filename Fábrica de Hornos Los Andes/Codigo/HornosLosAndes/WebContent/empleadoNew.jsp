<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="verificaSesion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hornos Los Andes :: Nuevo Empleado</title>
<script language="JavaScript" type="text/javascript">
	function cancelar(){
		location.href="empleado";	
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
for (i = 0; i < document.frmEmpleado.telefono.value.length; i++){
	if (document.frmEmpleado.telefono.value.charCodeAt(i) < 48 || document.frmEmpleado.telefono.value.charCodeAt(i) > 57)
	{
	document.frmEmpleado.telefono.value = document.frmEmpleado.telefono.value.slice(0, i);
	}
	}
}
</script>
<script language="javascript">
	function campos(theElement, nombre_del_elemento){
		if(document.frmEmpleado.nombre.value == ""){
			alert("Ingrese su Nombre")
			document.frmEmpleado.nombre.focus()
			return false;
		}
		if(document.frmEmpleado.apellido.value == ""){
			alert("Ingrese su Apellido")
			document.frmEmpleado.apellido.focus()
			return false;
		}
		if(document.frmEmpleado.direccion.value == ""){
			alert("Ingrese su telefono")
			document.frmEmpleado.direccion.focus()
			return false;
		}
		if(document.frmEmpleado.TextField.value == ""){
			alert("Ingrese su e-mail")
			document.frmEmpleado.TextField.focus()
			return false;
		}
		if(document.frmEmpleado.telefono.value == ""){
			alert("Ingrese su telefono")
			document.frmEmpleado.telefono.focus()
			return false;
		}
		if(document.frmEmpleado.TextField.value != ""){
			var s = theElement.value;
			var filter=/^[A-Za-z]+\.[A-Za-z0-9_]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/;
			if (s.length == 0 ) return true;
			if (filter.test(s))	return true;
			else{
				var filter2=/^[A-Za-z][A-Za-z0-9_]*@[A-Za-z0-9_]+\.[A-Za-z0-9_.]+[A-za-z]$/;
				if (s.length == 0 ) return true;
				if (filter2.test(s))	return true;
				else{
			alert("Ingrese una dirección de correo válida");
			theElement.focus();
			return false;}
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
<%@ include file="cabecera.jsp"%>
<form method="post" action="empleado" name="frmEmpleado"><input
	type="hidden" name="accion" value="ingresar">
<table border="1">
	<tr>
		<td>Nombre</td>
		<td><input type="text" name="nombre" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Apellido</td>
		<td><input type="text" name="apellido" maxlength="30"></td>
	</tr>
	<tr>
		<td>Direccion</td>
		<td><input type="text" name="direccion" maxlength="30"></td>
	</tr>
	<tr>
		<td>E-mail</td>
		<td><input type="text" name="TextField" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Telefono</td>
		<td><input type="text" name="telefono" maxlength="10" onkeyup="numero()"></td>
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