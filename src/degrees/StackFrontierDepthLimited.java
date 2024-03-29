package degrees;

import java.util.ArrayList;

public class StackFrontierDepthLimited {
	public ArrayList<Node> frontier;
	public ArrayList<Node> explored;
	public int frontierSize;
	public int distance = 6;
	
	public StackFrontierDepthLimited(int distance) {
		this.distance = distance;
		this.frontier = new ArrayList<>();
		this.explored = new ArrayList<>();
	}
	
	public StackFrontierDepthLimited() {
		this.frontier = new ArrayList<>();
		this.explored = new ArrayList<>();
	}
	
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
	
	public boolean empty() {
		return this.frontier.size() == 0;
	}
	
	public Node remove() {
		if(this.empty()) {
			System.out.println("Empty frontier 1");
			return null;
		}
		this.frontierSize = frontier.size() - 1;
		int min = this.minDegree();
		System.out.println("frontierSize : "+frontierSize);
		for(int i=this.frontierSize;i>=0;i--) {
			if(this.frontier.get(i).degree - min <= this.distance) {
				Node element = frontier.get(i);
				int distance = this.frontier.get(i).degree - min;
				System.out.println("returned element of index :"+i+" distance :"+ distance);
				this.frontier.remove(i);
				return element;
			}
		}
		System.out.println("return here 3:");
		return null;
	}
		
	public int minDegree() {
		int min = Integer.MAX_VALUE;
		for(Node n : frontier) {
			min = Math.min(min, n.degree);
		}
		return min;
	}
	
	public void addExplored(Node n ) {
		this.explored.add(n);
	}
	
}
