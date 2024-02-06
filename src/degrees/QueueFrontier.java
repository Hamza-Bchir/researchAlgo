package degrees;

public class QueueFrontier extends StackFrontier {
	
	@Override
	public Node remove() {
		if(this.empty()) {
			throw new Error("Frontier is already empty !");
		}
		Node element = frontier.remove(0);
		this.frontier.remove(0);
		return element;
	}
}
