package Factory;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if(Factory.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			Factory.game.pressA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			Factory.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			Factory.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			Factory.game.pressW();
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(Factory.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			Factory.game.releaseA();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			Factory.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			Factory.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_W) {
			Factory.game.releaseW();
		}
	}
	
}
