/**
 * 
 */
package com.cognizant.MovieCruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.MovieCruiser.model.Favorites;
import com.cognizant.MovieCruiser.model.Movie;

/**
 * @author VishnuKumar
 *
 */
public class FavoritesDaoCollectionImpl implements FavoritesDao {
	private static HashMap<Long, Favorites> userFavorites;

	/**
    * 
     */
	public FavoritesDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			try {
				List<Movie> movieList = new ArrayList<Movie>();
				Favorites favorites = new Favorites(movieList, 0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#addCartItem(java.lang.Long,
	 * java.lang.Long)
	 */

	public void addFavorites(Long userId, Long movieId) {
		List<Movie> movieList;
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		Long userid = new Long(userId);
		Movie movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			movieList = favorites.getMovieList();
			movieList.add(movie);
			favorites.setMovieList(movieList);
			// cart.setTotal(cart.getTotal() + menuItem.getPrice());
			userFavorites.put(userId, favorites);

		} else {
			movieList = new CopyOnWriteArrayList<Movie>();
			movieList.add(movie);

			Favorites favorites = new Favorites(movieList,
					(long) movie.getBoxOffice());
			userFavorites.put(userId, favorites);

		}

	}

	/**
	 * @return the userCarts
	 */
	public HashMap<Long, Favorites> getUserFavorites() {
		return userFavorites;
	}

	/**
	 * @param userCarts
	 *            the userCarts to set
	 */
	public void setUserFavorites(HashMap<Long, Favorites> userFavorites) {
		this.userFavorites = userFavorites;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#getAllCartItems(java.lang.Long)
	 */
	public List<Movie> getAllFavorites(Long userId)
			throws FavoritesEmptyException {
		Favorites favorites = userFavorites.get(new Long(userId));
		if (favorites == null) {
			throw new FavoritesEmptyException("Cart is Empty");
		}
		List<Movie> movieList = favorites.getMovieList();
		if (movieList == null || movieList.size() == 0) {
			throw new FavoritesEmptyException("Cart is Empty");
		}

		long total = 0;
		for (Movie movie : movieList) {
			total = total + movie.getBoxOffice();
		}

		favorites.setTotal(total);
		return movieList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.CartDao#removeCartItem(java.lang.Long,
	 * java.lang.Long)
	 */

	public void removeFavorites(Long userId, Long movieId) {

		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			List<Movie> movieList = favorites.getMovieList();
			for (Movie movie : movieList) {
				if (movie.getId() == movieId) {
					movieList.remove(movie);
				}
			}
			favorites.setMovieList(movieList);
			userFavorites.put(userId, favorites);

		}

	}
}
