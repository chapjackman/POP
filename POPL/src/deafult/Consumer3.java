package deafult;
public class Consumer3 extends Thread {
	private BoundedBufferM buffer;
 
	public Consumer3(BoundedBufferM buffer) {
		this.buffer = buffer;
	}
 
	public void run() {
			while (true) {
				buffer.removeItem();
 
	}
}
}
