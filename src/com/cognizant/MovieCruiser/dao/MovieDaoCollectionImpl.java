/**
 * 
 */
package com.cognizant.MovieCruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.MovieCruiser.model.Movie;
import com.cognizant.MovieCruiser.util.DateUtil;

/**
 * @Gokul
 *
 */
public class MovieDaoCollectionImpl implements MovieDao {

	private static List<Movie> movieList;

	/**
                * 
                 */
	public MovieDaoCollectionImpl() {

		if (movieList == null) {
			movieList = new ArrayList<Movie>();
			try {
				movieList.add(new Movie(1, "Avatar", 2787965087l, true,
						DateUtil.convertToDate("15/03/2017"), "ScienceFiction",
						true));

				movieList.add(new Movie(2, "The Avengers", 1518812988l, true,
						DateUtil.convertToDate("23/12/2017"), "Superhero",
						false));

				movieList
						.add(new Movie(3, "Titanic", 21874639444l, true,
								DateUtil.convertToDate("07/02/2017"),
								"Romance", false));

				movieList.add(new Movie(4, "Jurassic World", 1671713208l,
						false, DateUtil.convertToDate("09/02/2017"),
						"ScienceFiction", true));

				movieList.add(new Movie(5, "Avengers:End Game", 2750760348l,
						true, DateUtil.convertToDate("25/01/2022"),
						"Superhero", true));
			} catch (ParseException e) {
				System.out.println("Parse Exception: " + e.getMessage());
			}
		}
	}

	/**
	 * @return the movieList
	 */
	public List<Movie> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#getMovieListAdmin()
	 */
	@Override
	public List<Movie> getMovieAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#getMovieListCustomer()
	 */
	@Override
	public List<Movie> getMovieCustomer() {
		// TODO Auto-generated method stub
		List<Movie> movieListCustomer = new ArrayList<Movie>();
		Date today = new Date();
		for (Movie movie : movieList) {
			if (movie.getDateofLaunch().getTime() <= today.getTime()
					&& movie.isActive()) {
				movieListCustomer.add(movie);
			}
		}
		return movieListCustomer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#modifyMovie(com.cognizant.
	 * moviecruiser.model.Movie)
	 */
	@Override
	public void modifyMovie(Movie movie) {

		for (Movie movieForModification : movieList) {
			if (movie.getId() == movieForModification.getId()) {
				movieForModification.setTitle(movie.getTitle());
				movieForModification.setGenre(movie.getGenre());
				movieForModification.setDateofLaunch(movie.getDateofLaunch());
				movieForModification.setHasTeaser(movie.isHasTeaser());
				movieForModification.setBoxOffice(movie.getBoxOffice());
				movieForModification.setActive(movie.isActive());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieDao#getMovie(java.lang.Long)
	 */
	@Override
	public Movie getMovie(Long movieId) {

		for (Movie movieForFetching : movieList) {
			if (movieId == movieForFetching.getId()) {
				return movieForFetching;
			}
		}
		return null;
	}

}
