package dev.glick.asteroids;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;							//an array of all keys
	public boolean up,w, left,a, right,d, space;			//all the keys this program cares about
	
	public KeyManager() {
		keys = new boolean[256];					//sets the size of the keys array
	}

	public void tick() {													//this method is run many times per second (dependent on the fps)
		up = keys[KeyEvent.VK_UP] | keys[KeyEvent.VK_W];					//sets the up boolean to whatever the entery in keys is at the "up arrow" key code
		left = keys[KeyEvent.VK_LEFT] | keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] | keys[KeyEvent.VK_D];
		space = keys[KeyEvent.VK_SPACE];

	}
	@Override
	public void keyPressed(KeyEvent e) {			//sets the key code of that key pressed to true in the keys array
		keys[e.getKeyCode()] =true;
	}

	@Override
	public void keyReleased(KeyEvent e) {			//sets it to false 
		keys[e.getKeyCode()] =false;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
