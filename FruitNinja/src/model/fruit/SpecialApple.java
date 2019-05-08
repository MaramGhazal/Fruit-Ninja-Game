package model.fruit;

public class SpecialApple implements Fruit{

	private boolean sliced = false;
	
	@Override
	public boolean isSliced() {
		return sliced;
	}

	@Override
	public int increaseScore() {
		return 5;
	}
	
	@Override
	public void setSliced(boolean sliced) {
		this.sliced = sliced;
	}
}