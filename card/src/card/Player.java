package card;

import java.util.ArrayList;

import java.util.List;

public class Player {
	List<Card> cards = new ArrayList<Card>(); //카드5장 null값 들어가있음. 
	String name;

	Player(String name) {
		this.name = name;
		
	}
	
	public String toString() {
		return name + ":" + cards;        
	}
}
