<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="verificaSesion.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hornos Los Andes :: Nuevo Horno</title>
<script language="JavaScript" type="text/javascript">
	function cancelar(){
		location.href="horno";	
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
	for (i = 0; i < document.frmHorno.stock.value.length; i++){
		if (document.frmHorno.stock.value.charCodeAt(i) < 48 || document.frmHorno.stock.value.charCodeAt(i) > 57)
		{
		document.frmHorno.stock.value = document.frmHorno.stock.value.slice(0, i);
		}
		}
	}
</script>
<script language="javascript">
	function campos(){
		if(document.frmHorno.modelo.value == ""){
			alert("Ingrese el Modelo")
			document.frmHorno.modelo.focus()
			return false;
		}
		if(document.frmHorno.garantia.value == ""){
			alert("Ingrese la Garantia")
			document.frmHorno.garantia.focus()
			return false;
		}
		if(document.frmHorno.descripcion.value == ""){
			alert("Ingrese Descripcion")
			document.frmHorno.descripcion.focus()
			return false;
		}
		if(document.frmHorno.dimensiones.value == ""){
			alert("Ingrese sus Dimensiones")
			document.frmHorno.dimensiones.focus()
			return false;
		}
		if(document.frmHorno.stock.value == ""){
			alert("Ingrese Stock")
			document.frmHorno.stock.focus()
			return false;
		}
		if(document.frmHorno.precio.value == ""){
			alert("Ingrese Precio")
			document.frmHorno.precio.focus()
			return false;
		}
		return true;
	}
	function validar2(e,txt){
		tecla = (document.all) ? e.keyCode : e.which;
		if (tecla==8) return true;
		if (tecla==46 && txt.indexOf('.') != -1) return false;
		patron = /[\d\.]/;
		te = String.fromCharCode(tecla);
		return patron.test(te); }
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
<form method="post" action="horno" name="frmHorno"><input
	type="hidden" name="accion" value="ingresar">
<table border="1">
	<tr>
		<td>Modelo</td>
		<td><input type="text" name="modelo" maxlength="30" onkeypress="return validar(event,'letra')"></td>
	</tr>
	<tr>
		<td>Garantía</td>
		<td><input type="text" name="garantia" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Descripción</td>
		<td><input type="text" name="descripcion" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Dimensiones</td>
		<td><input type="text" name="dimensiones" maxlength="30" ></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><input type="text" name="stock" maxlength="5" onkeyup="numero()"></td>
	</tr>
	<tr>
		<td>Precio</td>
		<td><input type="text" name="precio" maxlength="7" onkeypress="return validar2(event,this.value)"></td>
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