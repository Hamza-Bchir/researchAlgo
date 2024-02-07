package degrees;

import java.util.ArrayList;

public class Movie {
	private int id;
	private String title;
	private int year;
	private ArrayList<Integer> person_ids;



	public Movie(int id, String title, int year) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.year = 0;
		this.person_ids = new ArrayList<>();
	}
	
	public Movie(Integer id, String title) {
		this.id = id;
		this.title = title;
		this.person_ids = new ArrayList<>();
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


	public ArrayList<Integer> getPerson_ids() {
		return person_ids;
	}

	public void setPerson_ids(ArrayList<Integer> person_ids) {
		this.person_ids = person_ids;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", person_ids=" + person_ids + "]";
	}


	
}
