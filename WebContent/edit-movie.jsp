<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.cognizant.MovieCruiser.model.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<title>Edit Movie</title>
<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="style/vishnu.css">
<script src="js/javascript.js"></script>
</head>
<body>
	<c:set var="categories"
		value="Superhero,Science Fiction,Romance,Comedy,Adventure,Thriller"
		scope="application" />
	<c:set var="selected" value="${movie.genre}" scope="application" />


	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img src="image/image1.png"> <a class="header-itemright"
			href="ShowMovieAdminServlet">Movies</a>
	</header>
	<section class="body-main">
		<h1 style="padding: 06px">Edit Movie</h1>
		<form name="editMovieForm" action="EditMovieServlet" method="post"
			onsubmit="return validateMovieForm()">
			<table style="width: 100%">
				<tr>
					<th colspan="4" style="padding-top: 25px"><label for="mname">Title</label></th>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="mname" name="itemName"
						style="width: 86%" value="${movie.title}"></td>
				<tr>
					<th style="padding-top: 25px"><label for="mprice">Gross
							($)</label></th>
					<th style="padding-top: 25px"><label for="mavailability">Active</label></th>
					<th style="padding-top: 25px"><label for="mdate">Date
							of Launch</label></th>
					<th style="padding-top: 25px"><label for="mcategory">Genre</label></th>
				</tr>
				<tr>
					<td><input type="text" name="boxOffice" id="mprice"
						value="${movie.boxOffice}"></td>
					<c:choose>
						<c:when test="${movie.active}">
							<td><input type="radio" name="active" value="yes" checked>
								Yes <input type="radio" name="active" value="no"> No</td>
						</c:when>
						<c:otherwise>
							<td><input type="radio" name="active" value="yes">
								Yes <input type="radio" name="active" value="no" checked>
								No</td>
						</c:otherwise>
					</c:choose>
					<td><input type="date" name="date" id="mdate"
						value=<fmt:formatDate pattern="dd/MM/yyyy" value="${movie.dateofLaunch}"/>></td>
					<td><select name="itemType">
							<option value="${selected}" selected>${selected}</option>
							<c:forEach items="${categories}" var="genre">
								<c:if test="${genre!= selected}">
									<option value="${genre}">${genre}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td style="padding-top: 25px"><input type="checkbox"
						name="hasTeaser" value="${movie.hasTeaser}"
						<c:if test="${movie.hasTeaser}">checked="checked"</c:if> /> <label>Has
							Teaser</label></td>
				</tr>
				<tr>
					<td><input type="hidden" id="movieid" name="movieid"
						value="${movie.id}"></td>
				</tr>
				<tr>
					<td style="padding-top: 25px"><input type="submit"
						class="button" name="save" value="Save"></td>
				</tr>
			</table>
		</form>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>