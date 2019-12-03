package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.MovieDao;
import com.cognizant.MovieCruiser.dao.MovieDaoSqlImpl;
import com.cognizant.MovieCruiser.model.Movie;

/**
 * Servlet implementation class ShowEditMovieServlet
 */
@WebServlet("/ShowEditMovieServlet")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieServlet() {
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
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		String movieId = request.getParameter("movieId");
		long movieId1 = Long.parseLong(movieId);
		Movie movie = movieDao.getMovie((long) movieId1);
		System.out.println("Movie=" + movie);

		// List<MenuItem> menuItemList=menuItemDao.getMenuItemListCustomer();
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("edit-movie.jsp").forward(request,
				response);
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
