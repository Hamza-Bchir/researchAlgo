package degrees;


public class Node {
	private Person state;
	private Node parent;
	private Action action;
	public Integer degree = -1;
	
	
	public Node(Person state, Node parent, Action action) {
		super();
		this.state = state;
		this.parent = parent;
		this.action = action;
		
	}


	public Person getState() {
		return state;
	}


	public void setSate(Person state) {
		this.state = state;
	}


	public Node getParent() {
		return parent;
	}


	public void setParent(Node parent) {
		this.parent = parent;
	}


	public Action getAction() {
		return action;
	}


	public void setAction(Action action) {
		this.action = action;
	}

	public boolean equals(Node n) {
		if(this.getState().equals(n.getState())) {
			return true;
		}

	    return false;
	}


	@Override
	public String toString() {
		return "Node [state=" + state.getId() + ", parent=" + parent + ", action=" + action + ", degree=" + degree + "]";
	}
	
	
	
}
