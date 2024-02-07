package degrees;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static String starsPath = "C:\\Users\\bchir\\Documents\\IT\\Harvard courses\\CS for AI\\Course\\Practice\\degrees\\large\\stars.csv";
	private static String moviesPath = "C:\\Users\\bchir\\Documents\\IT\\Harvard courses\\CS for AI\\Course\\Practice\\degrees\\large\\movies.csv";
	private static String peoplePath = "C:\\Users\\bchir\\Documents\\IT\\Harvard courses\\CS for AI\\Course\\Practice\\degrees\\large\\people.csv";
	/*
	private static ArrayList<Person> people = new ArrayList<>();
	private static ArrayList<Movie> movies = new ArrayList<>();
	private static ArrayList<String[]> stars = new ArrayList<>();
	*/
	
	private static HashMap<Integer, Person> people = new HashMap<>();
	private static HashMap<Integer, Movie> movies = new HashMap<>();
	
	
	public static void main(String[] args) throws Exception{
		System.out.println("Loading data ...");
		loadData();
		System.out.println("Data loaded successfully");
		
		StackFrontier frontier = new QueueFrontier();		
		Scanner scanner = new Scanner(System.in);
		List<Action> solution = new ArrayList<>();
		Integer states_explored = 0;
		
		System.out.println("Enter a source id and a target id:\n");
		
		//Person source = getPerson(scanner.nextInt());
		Person source = people.get(scanner.nextInt());
		Person target = people.get(scanner.nextInt());
		
		frontier.addFrontier(new Node(source, null, null));
		states_explored++;
		
		//displayPeople();
		
		
		
		while(true) {
			if(frontier.empty()) {
				System.out.println("Frontier empty there is no solution");
				break;
			}
			
			Node node = frontier.remove();
			states_explored++;
			if(node.degree > 6) {
				System.out.println("There is no solution");
				break;
			}
			System.out.println(states_explored);
			node.degree++;

			
			if(node.getState().equals(target)) {
				
				while(node.getParent() != null) {
					solution.add(node.getAction());
					node = node.getParent();
				}
				Collections.reverse(solution);
				break;
			}
			
			ArrayList<Node> neighbors = neighbors(node);
			for(Node n : neighbors) {
				frontier.addFrontier(n);
			}
			frontier.addExplored(node);
		}
		System.out.printf("States explored : %-5s\n",states_explored.toString());
		for(Action a :solution) {
			System.out.printf("(%d,%d)",a.movie.getId(),a.person.getId());
		}	
	}
	

	/*
	public static  ArrayList<Action> actions(Person p) {
		ArrayList<Action> actions = new ArrayList<>();
		for(int movie_id : p.getMovie_ids()) {
			Movie movie = getMovie(movie_id);
			for(int person_id : movie.getPerson_ids()) {
				actions.add(new Action(movie, getPerson(person_id)));
			}
		}
		return actions;
	}*/
	
	public static ArrayList<Action> actions1(Person p){
		ArrayList<Action> actions = new ArrayList<>();
		for(int movie_id : p.getMovie_ids()) {
			Movie movie = movies.get(movie_id);
			for(int person_id : movie.getPerson_ids()) {
				actions.add(new Action(movie, people.get(person_id)));
			}
		}
		return actions;
	}

	public static ArrayList<Node> neighbors(Node n){
		ArrayList<Node> neighbors = new ArrayList<>();
		for(Action a : actions1(n.getState())) {
			neighbors.add(new Node(a.person ,n ,a));
		}
		return neighbors;
	}
	
	/*
	public static Movie getMovie(int id) {
		for(Movie m : movies.) {
			if(m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	public static Person getPerson(int id) {
		for(Person p : people) {
			if(p.getId() == id)
				return p;
		}
		return null;
	}
	*/
	
	
 	public static void readPeopleData1(String path) {
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(peoplePath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				Person newPerson;
				if(row.length >= 3) {
					newPerson = new Person(Integer.valueOf(row[0]), row[1], Integer.valueOf(row[2]));
				}
				else {
					newPerson = new Person(Integer.valueOf(row[0]), row[1]);
				}
				people.put(newPerson.getId(), newPerson);;	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
 	}
 	
 	public static void readMoviesData1(String path) {
 		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(moviesPath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				Movie newMovie;
				if(row.length >= 3) {
					newMovie = new Movie(Integer.valueOf(row[0]), row[1]);
				}
				else {
					newMovie = new Movie(Integer.valueOf(row[0]), row[1], Integer.valueOf(row[2]));

				}
				movies.put(newMovie.getId(), newMovie);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
 	}
	
	
	public static void readStarsData1(String path) {
		BufferedReader reader = null;
		String line = "";
	
		try {
			reader = new BufferedReader(new FileReader(starsPath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				System.out.println(row[0]);
				Integer actor_id = Integer.valueOf(row[0]);
				Integer movie_id = Integer.valueOf(row[1]);
				if(people.containsKey(actor_id) && movies.containsKey(movie_id)) {
					people.get(actor_id).movie_ids.add(Integer.valueOf(movie_id));
					movies.get(movie_id).person_ids.add(actor_id);
				}
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void loadData() {
		readPeopleData1(starsPath);
		readMoviesData1(moviesPath);
		readStarsData1(starsPath);
		//setUpMoviesList();
		//setUpPersonsList();
	}
	
	/*
	public static void setUpMoviesList() {
		for(Person p : people) {
			ArrayList<Integer> movie_list = new ArrayList<>();
			for(String[] r : stars) {
				if(p.getId() == Integer.valueOf(r[0])) {
					movie_list.add(Integer.valueOf(r[1]));
				}
			}
			p.setMovie_ids(movie_list);
		}
	}
	
	public static void setUpPersonsList() {
		for(Movie m : movies) {
			ArrayList<Integer> actors_list = new ArrayList<>();
			for(String[] r : stars) {
				if(m.getId() == Integer.valueOf(r[1])) {
					actors_list.add(Integer.valueOf(r[0]));
				}
			}
			m.setPerson_ids(actors_list);
		}
	}
	
	public static void displayPeople() {
		for(Person p : people) {
			System.out.println(p.toString()+"\n");

		}
	}

	public static void displayMovies() {
		for(Movie m : movies) {
			System.out.println(m.toString()+"\n");	
		}
	}

	public static void readStarsData(String path) {
		BufferedReader reader = null;
		String line = "";
	
		try {
			reader = new BufferedReader(new FileReader(starsPath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				System.out.println(row[0]);
				stars.add(row);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readMoviesData(String path) {
		BufferedReader reader = null;
		String line = "";
		
		
		try {
			reader = new BufferedReader(new FileReader(moviesPath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				Movie newMovie;
				if(row.length >= 3) {
					newMovie = new Movie(Integer.valueOf(row[0]), row[1]);
				}
				else {
					newMovie = new Movie(Integer.valueOf(row[0]), row[1], Integer.valueOf(row[2]));

				}
				movies.add(newMovie.getId(), newMovie);	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
 	public static void readPeopleData(String path) {
		BufferedReader reader = null;
		String line = "";
		
		try {
			reader = new BufferedReader(new FileReader(peoplePath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] row = line.split(",");
				Person newPerson;
				if(row.length >= 3) {
					newPerson = new Person(Integer.valueOf(row[0]), row[1], Integer.valueOf(row[2]));
				}
				else {
					newPerson = new Person(Integer.valueOf(row[0]), row[1]);
				}
				people.add(newPerson.getId(), newPerson);;	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
 */
}

