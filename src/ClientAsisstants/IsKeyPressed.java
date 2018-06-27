package ClientAsisstants;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class IsKeyPressed implements KeyListener{
    private static volatile String pressed = "-1";
    public static String   currentKey() {
            return pressed;
    }

    public static void main(String[] args) {
        	
    		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
				
				@Override
				public boolean dispatchKeyEvent(KeyEvent e) {
					
					pressed = e.getKeyChar() + "";
					
					return false;
				}
			});
    				
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
