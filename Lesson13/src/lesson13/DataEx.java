package lesson13;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DataEx {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");        //insert
		stack.push("C");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());     //remove
		System.out.println(stack.pop());
		
		Queue<String> queue = new LinkedList<String>();
		queue.add("가");
		queue.add("나");
		queue.add("다");
				
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		Deque<String> deque = new LinkedList<String>();              //양방향으로 처리한다.
		deque.add("1");  //add -위쪽으로 넣는다
		deque.add("2"); //뒤쪽으로 넣는다
		deque.addFirst("3"); 
		System.out.println(deque);
		
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
	}
}
