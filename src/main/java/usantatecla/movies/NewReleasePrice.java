package usantatecla.movies;

public class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

}
