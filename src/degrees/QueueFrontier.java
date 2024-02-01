package degrees;

public class QueueFrontier extends StackFrontier {
	
	@Override
	public void remove() {
		this.frontier.remove(0);
	}
}
