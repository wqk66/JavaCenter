package com.java.Thread;

public class ProduceConsume {

	public static void main(String[] args) {
		
		SynStack ss = new SynStack();
		Producer p = new Producer(ss);
		Consume c = new Consume(ss);
		Thread tp = new Thread(p);
		Thread tc = new Thread(c);
		tp.start();
		tc.start();
	}
}


//馒头类
class SteamBread{
	int id;//馒头编号
	SteamBread(int id){
		this.id = id;
	}
	public String toString(){
		return "steamBread:"+id;
	}
}

//栈类
class SynStack{
	int index = 0;
	SteamBread[] stb = new SteamBread[6];
	public synchronized void push(SteamBread sb){
		
		while(index == stb.length){
			try{
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		stb[index] = sb;
		this.index++;
	}
	public synchronized SteamBread pop(){
		while(index == 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		this.index--;
		return stb[index];
	}
}

class Producer implements Runnable{
	SynStack ss = null;
	Producer(SynStack ss){
		this.ss = ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			SteamBread stb = new SteamBread(i);
			ss.push(stb);
			System.out.println("生产了"+stb);
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class Consume implements Runnable{
	SynStack ss = null;
	public Consume(SynStack ss){
		super();
		this.ss = ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			SteamBread stb = ss.pop();
			System.out.println("消费了"+stb);
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
