package usantatecla.movies;

public class MovieBuilder {

	private String title;
	private Price price;
	private Movie movie;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}

	public MovieBuilder childrens() {
		this.movie = new ChildrenMovie(title, price);
		return this;
	}
	
	public MovieBuilder regular() {
		this.movie = new RegularMovie(title, price);
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.movie = new NewReleaseMovie(title, price);
		return this;
	}
	
	public Movie build() {
		return this.movie;
	}
}
