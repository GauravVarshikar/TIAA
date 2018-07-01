public class TIAA_Main {

	public static void main(String[] args) {
		ProductMaker m1 = null;

		try {
			int countOfBolts = Integer.parseInt(args[0]), countofMachines = Integer.parseInt(args[1]),
					timeInSeconds = Integer.parseInt(args[2]);
			if(countOfBolts == 0  || countofMachines == 0 || timeInSeconds == 0){
				System.out.println("Invalid input supplied. Pass integers only greater than 0");
				return;
			}
			m1 = new ProductMaker(countOfBolts, countofMachines, timeInSeconds);
			m1.createUnfinishedItems();
		} catch (NumberFormatException num) {
			System.out.println("Invalid input supplied. Pass integers only greater than 0");
			return;
		}

		long startTime = System.nanoTime();

		Thread t1 = new Thread(m1);
		t1.setName("Worker 1");
		t1.start();

		Thread t2 = new Thread(m1);
		t2.setName("Worker 2");
		t2.start();

		Thread t3 = new Thread(m1);
		t3.setName("Worker 3");
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long estimatedTime = System.nanoTime() - startTime;
		double elapsedSeconds = (double) estimatedTime / 1000000000.0;

		// now we can print
		System.out.println("Total Products: " + m1.totalProducts);
		System.out.println("Total Time taken: " + elapsedSeconds);
	}

}
