package deafult;

public class main{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int bufferSize = 2;
		
		BoundedBuffer b = new BoundedBuffer(bufferSize);

		Consumer c1 = new Consumer(b);
		Producer p1 = new Producer(b);
		Consumer c2 = new Consumer(b);
		Producer p2 = new Producer(b);
		
		c1.start();
		p1.start();
		c2.start();
		p2.start();
	}
	
}