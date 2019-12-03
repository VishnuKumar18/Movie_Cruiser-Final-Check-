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
public class MovieDaoCollectionImplTest {
	// private static MenuItemDaoCollectionImpl menuItemDao;
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	  testGetMovieItemListAdmin();
		testGetMovieItemListCustomer();
		testModifyMovieItem();

	}

	public static void testGetMovieItemListAdmin() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		System.out.println("Movie Item List:\n"
				+ movieDaoCollectionImpl.getMovieAdmin());
		List<Movie> movies = movieDaoCollectionImpl.getMovieAdmin();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}

	}

	public static void testGetMovieItemListCustomer() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
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

		MovieDaoCollectionImpl movieCollection = new MovieDaoCollectionImpl();

		MovieDao movieDao = movieCollection;

		movieDao.modifyMovie(movie);
		System.out.println("Modification details are: "
				+ movieDao.getMovie((long) 2));

	}

	public void testGetMenuItem() {

	}

}
