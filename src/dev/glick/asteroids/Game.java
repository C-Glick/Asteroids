package dev.glick.asteroids;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
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
	private KeyManager keyManager;
	private Ship ship;
	
	public Game(String title,int width, int height) {
		this.width = width;
		this.height= height;
		this.title=title;
		this.keyManager = new KeyManager();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
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
		
		int fps =60;										//frames per second to draw the screen
		double timePerTick = 1e9 / fps;						//calculates the time allowed per frame, 1e9 = 1000000000ms or 1s
		double delta =0;									//delta is difference in time from last drawn frame to now
		long now;
		long lastTime = System.nanoTime();					//the last time this loop was ran
		
		while(running) {									//game loop
			now= System.nanoTime();
			delta += (now-lastTime) /timePerTick;			//adds to the delta the differenece devided by time per tick
			lastTime =now;
		
			
			if(delta >=1) {									//if delta is above or 1, it is time to draw to the screen
				tick();										//update all variables and objects
				render();									//draw to the screen to display to the user
				delta--;									//take one away from delta to reset the sensing
			}
		}
		stop();												//when running is false stop the game
	}
	
	private void init() {										//initiates the game 
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);			//adds a key listener to the display to sense key presses
		Assets assets = new Assets(this);						//creates the assets object
		assets.init();											//initiates the assets
		this.ship = Assets.ship;								//sets the game ship to the same as the assets ship to make it easier to reference later


	}
	private void tick() {									//update all variables and objects the game uses
		keyManager.tick();									//updates key presses
		ship.tick();										//updates the ships variables

		if(ship.globX>width) {								//senses if the ship has gone off the edge of the screen
			ship.globX = 0;									//puts the ship on the opposite side of screen
		}else if(ship.globX<0) {
			ship.globX = width;
		}
		
		if(ship.globY>height) {
			ship.globY = 0;
		}else if(ship.globY<0) {
			ship.globY = height;
		}

	}
	
	private void render() {									//draws graphics to the screen for user
		bs = display.getCanvas().getBufferStrategy();		//gets buffer strat from canvas, if non exists set it
		if(bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();							//get the graphics drawer from the buffer strat
		g.clearRect(0, 0, width, height);
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.white);
		Polygon p = ship.polygon;
		g.drawPolygon(p);
		
		
		bs.show();											//advance the drawn frame in the buffers eventually to the canvas
		g.dispose();										//get rid of the graphics object to keep things clean in memory
	}
}
