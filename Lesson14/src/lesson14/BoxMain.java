package lesson14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoxMain {
	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.setItem("양말");
		System.out.println(box.getItem());
		
		Box<Integer> box2 = new Box<>();
		box2.setItem(10);
		
		Comparator<Integer>	comp = (a,b) -> 0;  //comparator가 sort에 들어갈 수 있는가
		List<Integer> list = new ArrayList<Integer>();
		list.sort(comp);
	}
}
class Box<T> {  //결정 미루는게 제네릭. (호출 당시 타입을 너가써라?)
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	public static <T> void sm(T t) {  //static없으면 돔      //학생util에서 호출하는거 함
		System.out.println(t);
	}
	
}
