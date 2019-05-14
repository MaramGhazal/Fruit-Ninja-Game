package model.fruit;


public class SpecialGrape implements Fruit{

	private boolean sliced = false;
	
	@Override
	public boolean isSliced() {
		return sliced;
	}

	@Override
	public int increaseScore() {
		return 10;
	}
	
	@Override
	public void setSliced(boolean sliced) {
		this.sliced = sliced;
	}

/*	@Override
	public final boolean isSpecial() {
		return true;
	}
*/
}
