<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.cognizant.MovieCruiser.model.Movie"%>
<!doctype html>
<html>
<head>
<title>Movie ListCustomers</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img src="image/image1.png"> <a class="header-itemright"
			href="ShowFavoritesServlet">Favorites</a> <a class="header-itemright"
			href="ShowMovieCustomerServlet">Movies</a>
	</header>
	<br>
	<br>
	<section class="body-main">
		<h2>Movies</h2>
		<c:if test="${addFavoritesStatus}">
			<h2 style="color: green">Item added to Favorites Successfully</h2>
		</c:if>
		<table style="width: 100;" id="movie">
			<tr>
				<th class="th-text-align-left">Title</th>
				<th class="td-text-align-right">Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${customerMovie}">
				<tr>
					<td class="td-text-align-left">${item.title}</td>
					<td class="td-text-align-right"><fmt:formatNumber
							type="currency" value="${item.boxOffice }" /></td>
					<td>${item.genre}</td>
					<td>${item.hasTeaser ? 'yes' : 'No' }</td>
					<td><a href="AddToFavoritesServlet?movieId=${item.id}">Add
							to Favorite</a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>