package lesson13;

import java.util.List;
import java.util.Vector;
import java.util.LinkedList;

public class ListEx2 {
	public static void main(String[] args) {
		Vector<String> list = new Vector<String>();
		list.add("홍길동");
		list.add("새똥이");
		list.add("개똥이");
		list.addElement("고길동");
		
		list.remove(0);
		list.add("말똥이");
		list.remove("개똥이");
		list.set(0, "소똥이");
		list.add(0, "개똥이");
		
		
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println(list);
		System.out.println(list.size());
	}
	
}
