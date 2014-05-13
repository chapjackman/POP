package deafult;



public class BoundedBufferM {
	    
		private Monitor monitor;
	    private int[] buf;
	    private int items;
	    private int size;

	    public BoundedBufferM(int bufferSize){
	    	size = bufferSize;
		    buf = new int[bufferSize];
	    	items = 0;
	    	monitor = new Monitor();
	    }
	    
	    public Object removeItem(){
	    	monitor.getAccess();
	    	
		    	while (items == 0) {
		    		monitor.makeWait();
		    	}
		    	int result = buf[items-1];
		    	System.out.println("Removed" + result);
		        items--;
		        
		        monitor.signalAll();

	        monitor.release();
	        return result;
	        
	    }
	    
	    public void additem(int item){
	    	monitor.getAccess();
	    	
		    	while (items == size) {
		    		monitor.makeWait();
		    	}
		    	
		    	buf[items] = item;
		    	System.out.println("Added" + item);
		    	items++;
		    	
		    	monitor.signalAll();
	    	monitor.release();
	    }
}