package com.mmall.core;


public class TimerTiker extends Thread{
	
	int waitTime;
	public boolean isDone;
	public int now;
	boolean isRuning;
	public boolean isRuning() {
		return isRuning;
	}
	public void setRuning(boolean isRuning) {
		this.isRuning = isRuning;
	}
	public TimerTiker(int second, boolean islimitless)
	{
		isRuning=true;
		now=second;
		isDone=false;
		waitTime=second;
		
	}
	public void run() {
		try {
			for (int i = 0; i < waitTime; i++) {
				if (isRuning) {
//					System.out.println("waitTime:"+waitTime);
//					System.out.println("i:"+i);

					Thread.sleep(1000);
					now--;
				}else {
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		isDone=true;
	}
}
