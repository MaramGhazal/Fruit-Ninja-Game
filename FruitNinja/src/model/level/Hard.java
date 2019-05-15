package model.level;

import java.util.LinkedList;
import java.util.Queue;
import model.Element;
import model.bomb.BombFactory;
import model.fruit.FruitFactory;

public class Hard implements LevelStrategy {

	@Override
	public Queue<Element> gameQueue() {

		Queue<Element> queue = new LinkedList<Element>();
		FruitFactory fruitFactory = new FruitFactory();
		BombFactory bombFactory = new BombFactory();
		
		queue.add(fruitFactory.getFruit("Apple"));
		queue.add(fruitFactory.getFruit("Orange"));
		queue.add(bombFactory.getBomb("Dangerous"));
		queue.add(bombFactory.getBomb("Fatal"));
		queue.add(fruitFactory.getFruit("Pear"));
		queue.add(bombFactory.getBomb("Fatal"));
		queue.add(fruitFactory.getFruit("SpecialGrape"));
		queue.add(bombFactory.getBomb("Dangerous"));
		queue.add(fruitFactory.getFruit("Orange"));
		queue.add(bombFactory.getBomb("Dangerous"));
		queue.add(fruitFactory.getFruit("Strawberry"));
		queue.add(bombFactory.getBomb("Dangerous"));
		queue.add(fruitFactory.getFruit("SpecialGrape"));
		queue.add(bombFactory.getBomb("Dangerous"));
		queue.add(bombFactory.getBomb("Fatal"));
		queue.add(fruitFactory.getFruit("Orange"));
		queue.add(fruitFactory.getFruit("SpecialApple"));
		queue.add(fruitFactory.getFruit("Orange"));
		queue.add(fruitFactory.getFruit("Apple"));
		queue.add(bombFactory.getBomb("Fatal"));
		queue.add(fruitFactory.getFruit("Orange"));
		
		return queue;

	}

}
