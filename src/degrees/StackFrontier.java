package degrees;

import java.util.ArrayList;

public class StackFrontier {
	public ArrayList<Person> frontier = new ArrayList<>();
	
	
	public void remove() throws Exception {
		if(this.empty()) {
			throw new Exception("Frontier is already empty !");
		}
		int last_element = this.frontier.size() - 1;
		this.frontier.remove(last_element);
	}
	
	public boolean empty() {
		return this.frontier.size() == 0;
	}
	
	public boolean containsState(Person person) {
		for(Person p : frontier) {
			if(person.getId() == p.getId())
				return true;
		}
		return false;
	}
	
}
