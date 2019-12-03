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
public interface FavoritesDao {

	public void addFavorites(Long userId, Long movieId);

	public List<Movie> getAllFavorites(Long userId)
			throws FavoritesEmptyException;

	public void removeFavorites(Long userId, Long movieId);

}
