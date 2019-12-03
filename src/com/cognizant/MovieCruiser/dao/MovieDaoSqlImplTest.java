/**
 * 
 */
package com.cognizant.MovieCruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.MovieCruiser.model.Movie;
import com.cognizant.MovieCruiser.util.DateUtil;

/**
 * @author VishnuKumar
 *
 */
public class MovieDaoSqlImplTest {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	  testGetMovieItemListAdmin();
		testGetMovieItemListCustomer();
		testModifyMovieItem();

	}

	public static void testGetMovieItemListAdmin() {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		System.out.println("Movie Item List:\n"
				+ movieDaoSqlImpl.getMovieAdmin());
		List<Movie> movies = movieDaoSqlImpl.getMovieAdmin();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}

	}

	public static void testGetMovieItemListCustomer() {
		MovieDaoSqlImpl movieDaoCollectionImpl = new MovieDaoSqlImpl();
		System.out.println("Movie Item List:"
				+ movieDaoCollectionImpl.getMovieCustomer());
		List<Movie> movies = movieDaoCollectionImpl.getMovieCustomer();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}

	}

	public static void testModifyMovieItem() throws ParseException {
		Movie movie = new Movie(2, "Cake", 1265757l, true,
				DateUtil.convertToDate("11/12/2019"), "Main course", false);

		MovieDaoSqlImpl movieCollection = new MovieDaoSqlImpl();

		MovieDao movieDao = movieCollection;

		movieDao.modifyMovie(movie);
		System.out.println("Modification details are: "
				+ movieDao.getMovie((long) 2));

	}

	public void testGetMenuItem() {

	}

}

