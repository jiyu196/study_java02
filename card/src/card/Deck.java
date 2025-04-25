package card;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
//	Card[] cards = new Card[52];  길이 조정 필요없음. 길이를 알 필요 없으면 count도 필요없음
	List<Card> cards = new ArrayList<Card>();
	
	{
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				cards.add (new Card(i, j)); //cards[i * 13 +j] 
			}
		}
	}
	
	Deck print() {
		for(Card c : cards) {
			System.out.println(c);			
		}
		return this;
	}
	Deck shuffle() {
//		for(int i = 0; i < cards.size(); i++) {
//			int r = (int)(Math.random() * 52);
//			Card tmp = cards.get(i);
//			cards.set(i, cards.get(r));
//			cards.set(r,  tmp);   //tmp => 카드타입 원래 Card tmp = cards[i]였음
//		}
	    Collections.shuffle(cards);   //간단하게 섞는 코드
		return this;
	}
	
	Card pick() {   //딜러가 카드 나눠주는
		return cards.remove(cards.size()-1); //52에서 
	}
	
	public static void main(String[]args) {
		new Deck().shuffle().print();
	}
}
