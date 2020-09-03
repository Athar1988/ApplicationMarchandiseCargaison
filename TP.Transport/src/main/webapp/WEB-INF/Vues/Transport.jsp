<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Ajouter  marchandises a partier Cargaison-->
<!-- formulaire 1 -->
<form action="marchandiseParCarg.do" method="get" >
<select name="refCarg">
<forEach items="cargaisons" var="car">
<option value="${car.ref }">${car.ref }</option>
</forEach>
</select>
<input type="submit"  value="OK" >
</form>
<!-- Ajouter mot cle pour chercher les marchandises-->
<form action="cherche.do" method="get" >
Mot cle <input type="text" name="motcle" >
<input type="submit"  value="OK" >
</form>


<table>
<th>Num</th><th>Nom</th><th>poid</th><th>volume</th><th>Cargaison</th><th></th>
<c:forEach items="${marchandises}" var="m">
<td>${m.idMarchandise }</td>
<td>${m.nomMarchandise }</td>
<td>${m.poidMarchandise }</td>
<td>${m.volumeMarchandise }</td>
<td>${m.cargaison.ref }</td>
<td><a href="supprimer.do?idMarch=${m.idMarchandise}">Supprimer</a></td>
</c:forEach>
</table>
</body>
</html>