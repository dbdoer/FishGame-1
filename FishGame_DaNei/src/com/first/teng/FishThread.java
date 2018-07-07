package com.first.teng;

public class FishThread extends Thread{
	public Fish fish;
	public FishThread(Fish f){
		this.fish = f;
	};
	public void run(){
		super.run();
		while(!fish.isCatch){
			fish.move();
			try {
				Thread.sleep(fish.timeThread);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
