/**
 * 
 */
package com.cognizant.MovieCruiser.dao;

import java.util.List;

import com.cognizant.MovieCruiser.model.Movie;

/**
 * @author VishnuKumar
 *
 */
public interface MovieDao {
	public List<Movie> getMovieAdmin();

	public List<Movie> getMovieCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(Long movieId);

}
