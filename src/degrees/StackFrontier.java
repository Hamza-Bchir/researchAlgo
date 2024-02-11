package degrees;

import java.util.ArrayList;

public class StackFrontier {
	public ArrayList<Node> frontier = new ArrayList<>();
	public ArrayList<Node> explored = new ArrayList<>();
	
	

	public void addFrontier(Node n) {
		for(Node node : frontier) {
			if(node.equals(n))
				return;
		}
		for(Node node : explored) {
			if(node.equals(n)) {
				return;
			}
		}
		frontier.add(n);
	}

	public void addExplored(Node n ) {
		this.explored.add(n);
	}


	public Node remove() throws Exception {
		if(this.empty()) {
			throw new Exception("Frontier is already empty !");
		}
		
		
		int last_element = this.frontier.size() - 1;
		Node element = frontier.get(last_element);
		this.frontier.remove(last_element);
		return element;
	}
	
	public boolean empty() {
		return this.frontier.size() == 0;
	}
	

	
}
