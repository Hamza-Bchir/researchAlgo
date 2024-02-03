package degrees;


public class Action {

	public Movie movie;
	public Person person;
	
	public Action(Movie movie, Person person) {
		this.movie = movie;
		this.person = person;
	}
	
	public String toString() {
		return "Action [movie=" + movie + ", person=" + person + "]";
	}
	
}
