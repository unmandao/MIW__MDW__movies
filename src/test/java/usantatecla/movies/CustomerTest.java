package usantatecla.movies;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

	@ParameterizedTest
	@CsvSource({
			"1, 2, 1",
			"2, 2, 1",
			"3, 3.5, 1",
	})
	void regularRentalTest(int days, double amount, int frequentRenterPoints) {
		Movie movie = new RegularMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(days).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, amount)
				.totalAmount(amount).frequentRenterPoints(frequentRenterPoints).build();
		assertEquals(result, statement);
	}

	@ParameterizedTest
	@CsvSource({
			"1, 3, 1",
			"2, 3, 2",
			"3, 3, 2",
	})
	void newReleaseRentalTest(int days, double amount, int frequentRenterPoints) {
		Movie movie = new NewReleaseMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(days).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, amount)
				.totalAmount(amount).frequentRenterPoints(frequentRenterPoints).build();
		assertEquals(result, statement);
	}

	@ParameterizedTest
	@CsvSource({
			"1, 1.5, 1",
			"3, 1.5, 1",
			"4, 6, 1",
	})
	void childrenRentalTest(int days, double amount, int frequentRenterPoints) {
		Movie movie = new ChildrenMovie(MOVIE_NAME);
		Rental rental = new RentalBuilder().movie(movie).daysRented(days).build();
		Customer customer = new CustomerBuilder().name(CUSTOMER_NAME).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(CUSTOMER_NAME).movie(MOVIE_NAME, amount)
				.totalAmount(amount).frequentRenterPoints(frequentRenterPoints).build();
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
