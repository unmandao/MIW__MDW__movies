package usantatecla.movies;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	private final String CUSTOMER_NAME = "customerName";
	private final String MOVIE_NAME = "movieName";

	@Test
	public void withoutRentalsTest() {
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME)
				.totalAmount(0).frequentRenterPoints(0).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRental1DayTest() {
		Movie movie = new RegularMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void regularRental2DayTest() {
		Movie movie = new RegularMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRental3DayTest() {
		Movie movie = new RegularMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 3.5)
				.totalAmount(3.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental1DayTest() {
		Movie movie = new NewReleaseMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 3)
				.totalAmount(3).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental2DayTest() {
		Movie movie = new NewReleaseMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental3DayTest() {
		Movie movie = new NewReleaseMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental1DayTest() {
		Movie movie = new ChildrenMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental3DayTest() {
		Movie movie = new ChildrenMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental4DayTest() {
		Movie movie = new ChildrenMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, 6)
				.totalAmount(6).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new RegularMovie(regularMovieName);
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new NewReleaseMovie(newReleaseMovieName);
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new ChildrenMovie(childrensMovieName);
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();
		
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME)
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME)
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}
	
}
