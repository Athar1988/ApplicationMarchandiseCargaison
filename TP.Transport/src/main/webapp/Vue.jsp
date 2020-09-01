<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<script language="javascript"> function liste(TYPE) {
	document.location.href="Vue.jsp?typecargaison="+TYPE.list.selectedIndex+1
}
</SCRIPT>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<form action="controleur.php" method="post" name="TYPE">
<tr><td>Type Cargaison:</td>
<td><select name="type_carg">
<OPTION value="Aerienne">Aerienne</OPTION>
<OPTION value="Routiere">Routiere</OPTION>
</SELECT></td></tr>
<tr><td>Reference:</td><td><input type="text" name="ref" ></td></tr>
<tr><td>Date: </td><td><input type="date" name="date" ></td></tr>
<tr><td>Distance:</td><td><input type="text" name="distance" ></td></tr>
<tr><td>Poid maximal:</td><td><input type="text" name="poid" ></td></tr>
 <tr><td></td><td><input type="submit"  value="Ajouter" name="ajouterCargaison"></td></tr>
</form>
</table>
</body>
</html>