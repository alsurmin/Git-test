import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
	private static ArrayBlockingQueue<Object> list = new ArrayBlockingQueue<Object>(1000);

	public static void main(String[] args) {

		addObjects();
		proceed();
	}

	private static void proceed() {
		System.out.println(list.size());
		
		for(Object element: list) {
		list.remove(element);
		
		System.out.println(list.size());
		}
	}
	private static void addObjects() {
		for (int i = 0; i < 5; i++) {
			list.add(new Object());
		}
	}

}
