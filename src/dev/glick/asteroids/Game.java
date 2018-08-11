package dev.glick.asteroids;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.glick.asteroids.display.Display;

public class Game implements Runnable{

	public int width,height;
	public String title;
	private boolean running = false;
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	public Game(String title,int width, int height) {
		this.width = width;
		this.height= height;
		this.title=title;
		
	}
	
	public synchronized void start() {
		if(running)
			return;
		
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();
		
		while(running) {
			tick();
			render();	
		}
		
		stop();
	}
	
	private void init() {
		display = new Display(title,width,height);

	}
	
	private void tick() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.fillRect(0, 0, width, width);
		
		bs.show();
		g.dispose();
		
		
		
	}
}
