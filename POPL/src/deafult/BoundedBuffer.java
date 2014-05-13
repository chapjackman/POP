package deafult;



public class BoundedBuffer {
	    
		private CountingSemaphore full, empty;
	    private BinarySemaphore mutex;
	    private int[] buf;
	    private int items;
	    private int size;

	    public BoundedBuffer(int bufferSize){
	    	size = bufferSize;
	    	empty = new CountingSemaphore(0);
		    mutex = new BinarySemaphore(1);
		    full = new CountingSemaphore(bufferSize);
		    buf = new int[bufferSize];
	    	items = 0;
	        
	    }
	    public Object removeItem(){
	      
	    	empty.waitForNotify();
	    	mutex.waitForNotify();
		    	int result = buf[items-1];
		    	System.out.println("Removed" + result);
		        items--;
	        mutex.notifyToWakeup();
	        full.notifyToWakeup();
	        
	        return result;
	        
	    }
	    public void additem(int item){
	    	
	    	full.waitForNotify();
	    	mutex.waitForNotify();
	    	buf[items] = item;
	    	System.out.println("Added" + item);
	    	items++;
	        mutex.notifyToWakeup();
	        empty.notifyToWakeup();
	    }
}