package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.MovieDao;
import com.cognizant.MovieCruiser.dao.MovieDaoSqlImpl;
import com.cognizant.MovieCruiser.model.Movie;

/**
 * Servlet implementation class ShowMovieCustomerServlet
 */
@WebServlet("/ShowMovieCustomerServlet")
public class ShowMovieCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMovieCustomerServlet() {
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
		MovieDaoSqlImpl menuItemDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = menuItemDaoSqlImpl;
		List<Movie> movie = movieDao.getMovieCustomer();
		request.setAttribute("customerMovie", movie);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(
				request, response);
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
