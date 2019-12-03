package com.cognizant.MovieCruiser.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.MovieCruiser.dao.MovieDao;
import com.cognizant.MovieCruiser.dao.MovieDaoSqlImpl;
import com.cognizant.MovieCruiser.model.Movie;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean activeFlag;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// request.getAttribute("menuItem");
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao menuItemDao = movieDaoSqlImpl;
		String title = request.getParameter("itemName");
		String id = request.getParameter("movieid");
		long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
		String active = request.getParameter("active");
		if (active.equals("Yes")) {
			activeFlag = true;
		} else {
			activeFlag = false;
		}
		String date = request.getParameter("date");
		String itemType = request.getParameter("itemType");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		Movie movie = new Movie();
		movie.setGenre(itemType);
		;
		movie.setId(Long.parseLong(id));
		movie.setTitle(title);
		movie.setHasTeaser(hasTeaser);
		movie.setBoxOffice(boxOffice);
		Date dateOfLaunch;
		try {
			dateOfLaunch = sdf.parse(date);
			movie.setDateofLaunch(dateOfLaunch);
			menuItemDao.modifyMovie(movie);
			System.out.println(movie);
			response.sendRedirect("edit-movie-status.jsp");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
