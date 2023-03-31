package usantatecla.movies;

public abstract class Movie {

	private static final int FREQUENT_RENTER_POINTS = 1;

	private String title;
	private Price price;
	
	public Movie(String title, Price price) {
		this.title = title;
		this.price = price;
	}

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return Movie.FREQUENT_RENTER_POINTS;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
}
