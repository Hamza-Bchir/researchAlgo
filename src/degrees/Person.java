package degrees;

import java.util.ArrayList;

public class Person {
		private int id;
		private String name;
		private int birth;
		private ArrayList<Integer> movie_ids;
		
		
		
		public Person(int id, String name, int birth) {
			super();
			this.id = id;
			this.name = name;
			this.birth = birth;
			this.movie_ids = new ArrayList<>();
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getBirth() {
			return birth;
		}
		public void setBirth(int birth) {
			this.birth = birth;
		}

		


		public ArrayList<Integer> getMovie_ids() {
			return movie_ids;
		}

		public void setMovie_ids(ArrayList<Integer> movie_ids) {
			this.movie_ids = movie_ids;
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", birth=" + birth + ", movies=" + movie_ids + "]";
		}
		
		public boolean equals(Person p) {
			if(p != null) {
				if(p.getId() == this.id ) {
					return true;
				}
			}
			return false;
		}
		
	
	
	
	
}
