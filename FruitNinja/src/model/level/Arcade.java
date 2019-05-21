package model.level;

import java.util.ArrayList;

import model.Element.Element;
import model.fruit.FruitFactory;

public class Arcade implements LevelStrategy{

	@Override
	public ArrayList<Element> elementThrow(){
		
		ArrayList<Element> elements = new ArrayList<Element>();
		FruitFactory fruitFactory = new FruitFactory();

		elements.add(fruitFactory.getFruit("Apple"));
		elements.add(fruitFactory.getFruit("Strawberry"));
		elements.add(fruitFactory.getFruit("Pear"));
		elements.add(fruitFactory.getFruit("SpecialApple"));
		elements.add(fruitFactory.getFruit("Orange"));
		elements.add(fruitFactory.getFruit("Pear"));
		elements.add(fruitFactory.getFruit("SpecialGrape"));
		elements.add(fruitFactory.getFruit("Strawberry"));
		elements.add(fruitFactory.getFruit("Pineapple"));
		elements.add(fruitFactory.getFruit("Orange"));
		elements.add(fruitFactory.getFruit("Banana"));
		elements.add(fruitFactory.getFruit("SpecialApple"));
		elements.add(fruitFactory.getFruit("Apple"));
		elements.add(fruitFactory.getFruit("Strawberry"));
		elements.add(fruitFactory.getFruit("Pear"));
		elements.add(fruitFactory.getFruit("SpecialApple"));
		elements.add(fruitFactory.getFruit("Orange"));
		elements.add(fruitFactory.getFruit("Strawberry"));
		elements.add(fruitFactory.getFruit("Banana"));
		elements.add(fruitFactory.getFruit("SpecialGrape"));
		elements.add(fruitFactory.getFruit("Banana"));
		elements.add(fruitFactory.getFruit("Orange"));
		elements.add(fruitFactory.getFruit("SpecialApple"));
		elements.add(fruitFactory.getFruit("Apple"));
		elements.add(fruitFactory.getFruit("Strawberry"));
		elements.add(fruitFactory.getFruit("Mango"));
		
		return elements;
	}
	
	

}
