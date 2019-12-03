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
public class FavoritesDaoCollectionImplTest {
	public static void main(String[] args) throws FavoritesEmptyException {
		// TODO Auto-generated method stub

		testAddFavorites();
		testRemoveFavorites();
		testGetAllFavorites();

	}

	static void testAddFavorites() throws FavoritesEmptyException {

		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.addFavorites((long) 2, (long) 4);
		favoritesDao.addFavorites((long) 2, (long) 3);
		List<Movie> movieList = favoritesDao.getAllFavorites((long) 2);
		System.out.println("Movie Item list :" + movieList);

	}

	static void testGetAllFavorites() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		List<Movie> movieList = favoritesDao.getAllFavorites((long) 2);
		System.out.println("MovieItem list :" + movieList);
	}

	static void testRemoveFavorites() throws FavoritesEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;

		try {
			favoritesDao.removeFavorites((long) 2, (long) 4);
			List<Movie> movieList = favoritesDao.getAllFavorites((long) 2);
			System.out.println("MovieItem list after removed:" + movieList);
		} catch (Exception e) {
			throw new FavoritesEmptyException("Favourites  is empty");
		}

	}

}
