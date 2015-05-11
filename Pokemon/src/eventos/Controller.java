package eventos;

import java.util.Scanner;

public class Controller {
	private EventSet es = new EventSet();
	Scanner scan = new Scanner(System.in);

	public void addEvent(Event c) {
		es.add(c);
	}

	public void run() {
		Event e = es.getNext();
		while (e != null) {
			e.action();
			System.out.println(e.description());
			es.removeCurrent();
			e = es.getNext();
		}

	}
}
