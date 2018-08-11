package dev.glick.asteroids;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.glick.asteroids.display.Display;

// the main class for running the game,
//this handles starting the game thread and rendering to the screen
public class Game implements Runnable{

	public int width,height;
	public String title;
	private boolean running = false;
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;			//buffer strat is the number of buffers between drawing and displaying
	private Graphics g;					//the object that does the drawing
	
	public Game(String title,int width, int height) {
		this.width = width;
		this.height= height;
		this.title=title;
		
	}
												//starts the separate thread for the game to run on, calls the run method 
	public synchronized void start() {
		if(running)								//if the game is already running ignore this code
			return;
		
		running=true;							
		thread = new Thread(this);
		thread.start();
	}
												//safely stops the code, similar logic to the start method
	public synchronized void stop() {
		if(!running)
			return;
		
		running=false;
		try {
			thread.join();						//waits for the thread to end safely before closing it
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();
		
		while(running) {						//game loop
			tick();								//update all variables and objects
			render();							//draw to the screen to display to the user
		}
		
		stop();									//when running is false stop the game
	}
	
	private void init() {									//initiates the game 
		display = new Display(title,width,height);

	}
	
	private void tick() {									//update all variables and objects the game uses
		
	}
	
	private void render() {									//draws graphics to the screen for user
		bs = display.getCanvas().getBufferStrategy();		//gets buffer strat from canvas, if non exists set it
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();							//get the graphics drawer from the buffer strat
		
		g.fillRect(0, 0, width, width);
		
		bs.show();											//advance the drawn frame in the buffers eventually to the canvas
		g.dispose();										//get rid of the graphics object to keep things clean in memory
		
		
		
	}
}
