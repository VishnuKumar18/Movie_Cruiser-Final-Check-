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

import com.cognizant.MovieCruiser.model.Movie;
/**
 * @author VishnuKumar
 *
 */
public class MovieDaoSqlImpl implements MovieDao {

	/* (non-Javadoc)
	 * @see com.cognizant.MovieCruiser.dao.MovieDao#getMovieAdmin()
	 */
	@Override
	public List<Movie> getMovieAdmin() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<Movie> movie1 = new ArrayList<Movie>();
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select mo_id,mo_title,mo_active,mo_date_of_launch,mo_box_office,mo_genre,mo_has_teaser from movie");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt("mo_id");
					String title = resultSet.getString("mo_title");
					Date dateOfLaunch = resultSet.getDate("mo_date_of_launch");
					String active = resultSet.getString("mo_active");
					float boxOffice= resultSet.getFloat("mo_box_office");
					String genre = resultSet.getString("mo_genre");
					String hasTeaser = resultSet
							.getString("mo_has_teaser");
					if ( hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					Movie movie = new Movie(id, title,(long) boxOffice,
							activeFlag, dateOfLaunch, genre,
							hasTeaserFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(movie);
					movie1.add(movie);
				}
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

		return movie1;

	}


	/* (non-Javadoc)
	 * @see com.cognizant.MovieCruiser.dao.MovieDao#getMovieCustomer()
	 */
	@Override
	public List<Movie> getMovieCustomer() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<Movie> movie1 = new ArrayList<Movie>();
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where mo_active='Yes' and mo_date_of_launch <= now()");
				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					int movieId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					float boxOffice = resultSet.getFloat(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
					String genre= resultSet.getString(6);
					String hasTeaser= resultSet.getString(7);
					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					Movie movie= new Movie(movieId, title, (long)boxOffice,
							activeFlag, date_of_launch, genre,
							hasTeaserFlag);
					movie1.add(movie);
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
		return movie1;

	}


	/* (non-Javadoc)
	 * @see com.cognizant.MovieCruiser.dao.MovieDao#modifyMovie(com.cognizant.MovieCruiser.model.Movie)
	 */
	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		String sql = "update movie set mo_title=?,mo_box_office=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser=? where mo_id=?";
		try {
			if (connection != null) {
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				preparedStatement.setString(1, movie.getTitle());
				preparedStatement.setFloat(2, movie.getBoxOffice());
				if (movie.isActive())
					preparedStatement.setString(3, "Yes");
				else
					preparedStatement.setString(3, "No");
				preparedStatement.setDate(4, new java.sql.Date(movie
						.getDateofLaunch().getTime()));
				preparedStatement.setString(5, movie.getGenre());
				if (movie.isHasTeaser())
					preparedStatement.setString(6, "Yes");
				else
					preparedStatement.setString(6, "No");
				preparedStatement.setLong(7, movie.getId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
		

	/* (non-Javadoc)
	 * @see com.cognizant.MovieCruiser.dao.MovieDao#getMovie(java.lang.Long)
	 */
	@Override
	public Movie getMovie(Long movieId) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Movie movie = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where mo_id=?");
				preparedStatement.setLong(1, movieId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String title= resultSet.getString(2);
					float boxOffice= resultSet.getFloat(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
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
					movie = new Movie(movieId,title,(long)boxOffice,
							activeFlag, date_of_launch, genre,
							hasTeaserFlag);
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
		return movie;

	}

}
