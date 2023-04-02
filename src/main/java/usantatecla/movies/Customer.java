package usantatecla.movies;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

	private String name;
	private List<Rental> rentals;
	
	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<>();
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}
	
	public String getName() {
		return name;
	}
	
	public String statement() {
		return statementTitle() +
				statementListOfRentals() +
				statementTotalCharge() +
				statementTotalFrequentRenterPoints();
	}

	String statementTitle() {
		return "Rental Record for " + this.getName() + "\n";
	}

	String statementListOfRentals() {
		return rentals.stream()
				.map(rental -> "\t" + rental.getTitle() + "\t" + rental.getCharge() + "\n")
				.collect(Collectors.joining(""));
	}

	String statementTotalCharge() {
		return "Amount owed is " + this.getTotalCharge() + "\n";
	}

	String statementTotalFrequentRenterPoints() {
		return "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
	}

	private double getTotalCharge() {
		return rentals.stream()
				.mapToDouble(Rental::getCharge)
				.sum();
	}

	private int getTotalFrequentRenterPoints() {
		return rentals.stream()
				.mapToInt(Rental::getFrequentRenterPoints)
				.sum();
	}

}
