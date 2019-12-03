package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.FavoritesDao;
import com.cognizant.MovieCruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.MovieCruiser.dao.FavoritesEmptyException;
import com.cognizant.MovieCruiser.model.Movie;

/**
 * Servlet implementation class ShowFavoritesServlet
 */
@WebServlet("/ShowFavoritesServlet")
public class ShowFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		FavoritesDao favoritesDao = favoritesDaoSqlImpl;
		try {
			List<Movie> movie = favoritesDao.getAllFavorites(userId);
			request.setAttribute("favorites", movie);
			request.getRequestDispatcher("favorites.jsp").forward(request,
					response);
		} catch (FavoritesEmptyException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("favorites-empty.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
