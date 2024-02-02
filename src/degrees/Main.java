package degrees;
import java.io.*;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args){
		
		
		String starsPath = "C:\\Users\\bchir\\Documents\\IT\\Harvard courses\\CS for AI\\Course\\Practice\\degrees\\small\\stars.csv";
		String moviesPath = "C:\\Users\\bchir\\Documents\\IT\\Harvard courses\\CS for AI\\Course\\Practice\\degrees\\small\\movies.csv";
		String peoplePath = "C:\\Users\\bchir\\Documents\\IT\\Harvard courses\\CS for AI\\Course\\Practice\\degrees\\small\\people.csv";
		
		ArrayList<Person> people = new ArrayList<>();
		ArrayList<Movie> movies = new ArrayList<>();
		ArrayList<String[]> stars = new ArrayList<>();

		
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(peoplePath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				Person newPerson = new Person(Integer.valueOf(row[0]), row[1], Integer.valueOf(row[2]));
				people.add(newPerson);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			reader = new BufferedReader(new FileReader(moviesPath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				Movie newMovie = new Movie(Integer.valueOf(row[0]), row[1], Integer.valueOf(row[2]));
				movies.add(newMovie);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			reader = new BufferedReader(new FileReader(starsPath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				stars.add(row);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		// Setting up the list of movies in which each person starred in 
		for(Person p : people) {
			ArrayList<Movie> personMovies = new ArrayList<>();
			for(String[] r : stars) {
				if(p.getId() == Integer.valueOf(r[0])){
					personMovies.add(searchMovie(movies, Integer.valueOf(r[1])));
				}
			}
			p.setMovies(personMovies);
		}*/
		
		// Setting up the list of persons that starred in each movie
		for(Movie m : movies) {
			ArrayList<Person> movieActors = new ArrayList<>();
			for(String[] r : stars) {
				if(m.getId() == Integer.valueOf(r[1])){
					movieActors.add(searchPerson(people, Integer.valueOf(r[0])));
				}
			}
			m.setPersons(movieActors);
		}
		
		for(Movie m : movies) {
			System.out.println(m.toString()+"\n");
		}
		
		
		
	
	
	}// From source ID to target ID : Each iteration will look at the movies where the person starred in 
	// and the actors who played in that movie A state is a movie_id with the actors who played in it
	// Keep iterating until the target ID is found 
	
	
	private static Movie searchMovie(ArrayList<Movie> list, int id) {
		for(Movie m : list) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	private static Person searchPerson(ArrayList<Person> list, int id) {
		for(Person p : list) {
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	
}
