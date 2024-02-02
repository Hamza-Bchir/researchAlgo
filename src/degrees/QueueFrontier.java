package degrees;

public class QueueFrontier extends StackFrontier {
	
	@Override
	public void remove() {
		if(this.empty()) {
			throw new Error("Frontier is already empty !");
		}
		this.frontier.remove(0);
	}
}
