package deafult;
public class BinarySemaphore {
  public boolean locked = false;
 
  BinarySemaphore(int initial) {
    locked = (initial == 0);
  }
 
  public synchronized void waitForNotify(){
	    while (locked) {
	      try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    locked = true;
	  }
 
	  public synchronized void notifyToWakeup() {
	    if (locked) {
	      notify();
	    }
	    locked = false;
	  }
	}