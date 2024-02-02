package degrees;

import java.util.ArrayList;

public class Movie {
	private int id;
	private String title;
	private int year;
	private ArrayList<Person> persons = new ArrayList<>();

	public Movie(int id, String title, int year) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public ArrayList<Person> getPersons() {
		return persons;
	}
	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", persons=" + persons + "]";
	}
	
}
