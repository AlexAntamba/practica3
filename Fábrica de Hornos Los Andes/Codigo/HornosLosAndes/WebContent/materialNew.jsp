<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="verificaSesion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hornos Los Andes :: Nuevo Material</title>
<script language="JavaScript" type="text/javascript">
	function cancelar(){
		location.href="material";	
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
for (i = 0; i < document.frmMaterial.stock.value.length; i++){
	if (document.frmMaterial.stock.value.charCodeAt(i) < 48 || document.frmMaterial.stock.value.charCodeAt(i) > 57)
	{
	document.frmMaterial.stock.value = document.frmMaterial.stock.value.slice(0, i);
	}
	}
}
</script>
<script language="javascript">
	function campos(){
		if(document.frmMaterial.nombre.value == ""){
			alert("Ingrese Nombre")
			document.frmMaterial.nombre.focus()
			return false;
		}
		if(document.frmMaterial.durabilidad.value == ""){
			alert("Ingrese Durabilidad")
			document.frmMaterial.durabilidad.focus()
			return false;
		}
		if(document.frmMaterial.detuso.value == ""){
			alert("Ingrese detalle de Uso")
			document.frmMaterial.detuso.focus()
			return false;
		}
		if(document.frmMaterial.stock.value == ""){
			alert("Ingrese Stock")
			document.frmMaterial.stock.focus()
			return false;
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
<form method="post" action="material" name="frmMaterial"><input
	type="hidden" name="accion" value="ingresar">

<table border="1">
	<tr>
		<td>Nombre</td>
		<td><input type="text" name="nombre" maxlength="30" onkeypress="return validar(event,'letra')"></td>
	</tr>
	<tr>
		<td>Tipo</td>
		<td><select name="tipo">
						<option value="Madera" >Madera</option>
						<option value="Metal" >Metal</option>
						<option value="Otro" >Otro</option>
					</select></td>
	</tr>
	<tr>
		<td>Durabilidad</td>
		<td><input type="text" name="durabilidad" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Detalle de Uso</td>
		<td><input type="text" name="detuso" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><input type="text" name="stock" maxlength="5" onkeyup="numero()"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Grabar" onclick="return campos()"></td>
		<td><input type="button" value="Cancelar" onclick="cancelar()"></td>
	</tr>
</table> 
</form>
<%@ include file="footer.jsp"%>
</body>
</html>