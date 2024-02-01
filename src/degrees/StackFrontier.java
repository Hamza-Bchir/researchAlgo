package degrees;

import java.util.ArrayList;

public class StackFrontier {
	public ArrayList<Node> frontier = new ArrayList<Node>();
	
	
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
	
}
