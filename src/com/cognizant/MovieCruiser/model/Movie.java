/**
 * 
 */
package com.cognizant.MovieCruiser.model;

import java.util.Date;

/**
 * @author VishnuKumar
 *
 */
public class Movie {
	private long id;
	private String Title;
	private long boxOffice;
	private boolean active;
	private Date dateofLaunch;
	private String genre;
	private boolean hasTeaser;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		Title = title;
	}

	/**
	 * @return the boxOffice
	 */
	public long getBoxOffice() {
		return boxOffice;
	}

	/**
	 * @param boxOffice
	 *            the boxOffice to set
	 */
	public void setBoxOffice(long boxOffice) {
		this.boxOffice = boxOffice;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the dateofLaunch
	 */
	public Date getDateofLaunch() {
		return dateofLaunch;
	}

	/**
	 * @param dateofLaunch
	 *            the dateofLaunch to set
	 */
	public void setDateofLaunch(Date dateofLaunch) {
		this.dateofLaunch = dateofLaunch;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the hasTeaser
	 */
	public boolean isHasTeaser() {
		return hasTeaser;
	}

	/**
	 * @param hasTeaser
	 *            the hasTeaser to set
	 */
	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (int) (boxOffice ^ (boxOffice >>> 32));
		result = prime * result
				+ ((dateofLaunch == null) ? 0 : dateofLaunch.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (hasTeaser ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		if (active != other.active)
			return false;
		if (boxOffice != other.boxOffice)
			return false;
		if (dateofLaunch == null) {
			if (other.dateofLaunch != null)
				return false;
		} else if (!dateofLaunch.equals(other.dateofLaunch))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (hasTeaser != other.hasTeaser)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie [id=" + id + ", Title=" + Title + ", boxOffice="
				+ boxOffice + ", active=" + active + ", dateofLaunch="
				+ dateofLaunch + ", genre=" + genre + ", hasTeaser="
				+ hasTeaser + "]";
	}

	/**
	 * @param id
	 * @param title
	 * @param boxOffice
	 * @param active
	 * @param dateofLaunch
	 * @param genre
	 * @param hasTeaser
	 */
	public Movie(long id, String title, long boxOffice, boolean active,
			Date dateofLaunch, String genre, boolean hasTeaser) {
		super();
		this.id = id;
		Title = title;
		this.boxOffice = boxOffice;
		this.active = active;
		this.dateofLaunch = dateofLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	/**
	 * 
	 */
	public Movie() {
		super();
	}

}
