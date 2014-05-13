package deafult;

class Monitor {
	
	BinarySemaphore accessed;
	BinarySemaphore waitingThreads;
	int waitingThreadCount = 0;
	
	public Monitor() {
		accessed = new BinarySemaphore(1);
		waitingThreads = new BinarySemaphore(0);
		waitingThreadCount = 0;
	}
	
	public void getAccess() {
		accessed.waitForNotify();
	}
	
	public void release() {
		accessed.notifyToWakeup();
	}
	
	public void makeWait() {
		waitingThreadCount += 1;
		accessed.notifyToWakeup();
		waitingThreads.waitForNotify();
		accessed.waitForNotify();
		waitingThreadCount -= 1;
		waitingThreads.notifyToWakeup();
		
	}
	
	public void signal() {
		waitingThreads.notifyToWakeup();
		waitingThreadCount -= 1;
	}
	
	public void signalAll() {
		for (int i = waitingThreadCount; i > 0; i --) {
			signal();
		}
	}
	
}