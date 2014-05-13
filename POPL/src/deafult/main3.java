package deafult;

public class main3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int bufferSize = 2;
		
		BoundedBufferM b = new BoundedBufferM(bufferSize);

		Consumer3 c1 = new Consumer3(b);
		Producer3 p1 = new Producer3(b);
		Consumer3 c2 = new Consumer3(b);
		Producer3 p2 = new Producer3(b);
		
		c1.start();
		p1.start();
		c2.start();
		p2.start();
	}
	
}