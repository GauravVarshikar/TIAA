public class TIAA_Main {

	public static void main(String[] args) {

		ProductMaker m1 = new ProductMaker(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
				Integer.parseInt(args[2]));
		m1.createUnfinishedItems();
		
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
		double elapsedSeconds = (double)estimatedTime / 1000000000.0;

		// now we can print
		System.out.println("Total Products: " + m1.totalProducts);
		System.out.println("Total Time taken: " + elapsedSeconds);
	}

}
