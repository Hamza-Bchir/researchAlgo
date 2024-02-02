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
		
		
		
		
		// Setting up the list of movies in which each person starred in 
		for(Person p : people) {
			ArrayList<Integer> movie_list = new ArrayList<>();
			for(String[] r : stars) {
				if(p.getId() == Integer.valueOf(r[0])) {
					movie_list.add(Integer.valueOf(r[1]));
				}
			}
			p.setMovie_ids(movie_list);
		}
		
	
		for(Movie m : movies) {
			ArrayList<Integer> actors_list = new ArrayList<>();
			for(String[] r : stars) {
				if(m.getId() == Integer.valueOf(r[1])) {
					actors_list.add(Integer.valueOf(r[0]));
				}
			}
			m.setPerson_ids(actors_list);
		}
		
		
		
	
	
	}// From source ID to target ID : Each iteration will look at the movies where the person starred in 
	// and the actors who played in that movie A state is a movie_id with the actors who played in it
	// Keep iterating until the target ID is found 
	
}
