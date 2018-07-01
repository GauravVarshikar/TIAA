import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProductMaker implements Runnable {

	Queue<String> conveyor = new ConcurrentLinkedQueue<>();
	volatile int totalProducts = 0;
	int countOfBolts, countofMachines, timeInSeconds;

	public ProductMaker(int countOfBolts, int countofMachines, int timeInSeconds) {
		this.countOfBolts = countOfBolts;
		this.countofMachines = countofMachines;
		this.timeInSeconds = timeInSeconds;
	}

	public void createUnfinishedItems() {

		for (int i = 0; i < countOfBolts; i++) {
			conveyor.add("bolt");
		}

		for (int i = 0; i < countofMachines; i++) {
			conveyor.add("machine");
		}

		System.out.println(conveyor);
	}

	public synchronized String pickUnfinishedGood() {
		String item = null;
		if (!conveyor.isEmpty()) {
			item = conveyor.remove();
		}
		return item;
	}

	@Override
	public void run() {
		int bolts = 0, machine = 0, products = 0;
		String item;

		while (!conveyor.isEmpty()) {
			item = pickUnfinishedGood();
			if (null != item && item.equals("bolt")) {
				bolts++;
			} else {
				machine++;
			}
		}

		while (bolts != 0 && machine != 0) {
			//System.out.println(Thread.currentThread().getName() + "while making products bolts -- " + bolts + " mc-- " + machine);
			try {
				Thread.sleep(this.timeInSeconds * 1000);
				if (bolts >= 2 && machine >= 1) {
					bolts = bolts - 2;
					machine--;
					products++;
				} else {
					break;
				}

				System.out.println(Thread.currentThread().getName() + " --- products = " + products);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		totalProducts += products;

	}
}