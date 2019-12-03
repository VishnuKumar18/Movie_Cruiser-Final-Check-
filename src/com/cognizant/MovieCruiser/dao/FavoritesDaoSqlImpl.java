/**
 * 
 */
package com.cognizant.MovieCruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.MovieCruiser.model.Favorites;
import com.cognizant.MovieCruiser.model.Movie;

/**
 * @author VishnuKumar
 *
 */
public class FavoritesDaoSqlImpl implements FavoritesDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.MovieCruiser.dao.FavoritesDao#addFavorites(java.lang.Long,
	 * java.lang.Long)
	 */
	@Override
	public void addFavorites(Long userId, Long movieId) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("insert into favorites values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.MovieCruiser.dao.FavoritesDao#getAllFavorites(java.lang
	 * .Long)
	 */
	@Override
	public List<Movie> getAllFavorites(Long userId)
			throws FavoritesEmptyException {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<Movie> movie1 = new ArrayList<Movie>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;

		Movie movie = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Favorites favorites = new Favorites(movie1, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT movie.mo_id, movie.mo_title ,movie.mo_box_office ,movie.mo_active,movie.mo_date_of_launch,movie.mo_genre,movie.mo_has_teaser FROM movie ")
						.append("INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id WHERE favorites.fa_us_id = ?");
				System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());

				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int movieId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					float boxOffice = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					Date date_of_launch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);

					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movie = new Movie(movieId, title, (long) boxOffice,
							activeFlag, date_of_launch, genre, hasTeaserFlag);
					movie1.add(movie);
				}
				favorites.setMovieList(movie1);
				favorites.setTotal(getCount(userId, connection));
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (movie1.size() == 0)
			throw new FavoritesEmptyException("Cart is Empty");

		return movie1;

	}

	private long getCount(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		long count = 0;
		List<Movie> movie1 = new ArrayList<Movie>();
		try {
			if (conn != null) {
				Favorites favorites = new Favorites(movie1, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT COUNT(*) FROM movie INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id")
						.append("WHERE favorites.fa_us_id = ?");
				System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = conn.prepareStatement(sqlBuffer.toString());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					count = resultSet.getLong(1);
				}
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.MovieCruiser.dao.FavoritesDao#removeFavorites(java.lang
	 * .Long, java.lang.Long)
	 */
	@Override
	public void removeFavorites(Long userId, Long movieId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from favorites where fa_us_id=? and  fa_mo_id =?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
