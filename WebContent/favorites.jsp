<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.MovieCruiser.model.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><!doctype html>
<html>
<head>
<title>Favorites</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<c:set var="sum" value="${0}" />
	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img src="image/image1.png"> <a class="header-itemright"
			href="ShowMovieCustomerServlet">Movies</a>
	</header>
	<br>
	<br>
	<section class="body-main">
		<h1>Favorites</h1>
		<c:if test="${removeFavoritesStatus}">
			<h2 style="color: #00cc88">Item Removed From Favorites
				Successfully</h2>
		</c:if>
		<table style="width: 100%" id="movie">
			<tr>
				<th style="width: 200px" class="th-text-align-left">Title</th>
				<th>Has Teaser</th>
				<th class="th-text-align-right">Box Office</th>
				<th></th>
			</tr>
			<c:forEach var="item" items="${favorites}">
				<tr>
					<td class="td-text-align-left">${item.title}</td>
					<td>${item.hasTeaser? 'Yes' : 'No'}</td>
					<td class="td-text-align-right"><fmt:setLocale value="en_US" />
						<fmt:formatNumber type="currency" value="${item.boxOffice}" /></td>
					<c:set var="sum" value="${sum+1}" />
					<td>${item.genre}</td>
					<td><a href="RemoveFavoritesServlet?movieId=${item.id }">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td class="th-text-align-left"><b>No.of Favorites:</b>${sum}</td>

			</tr>
		</table>
	</section>
	<footer>Copyrightę2019</footer>

</body>
</html>