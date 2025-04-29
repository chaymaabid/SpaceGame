
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Spaceship_move implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
			{
                if(App.game.spaceship.get_y()>-220)
                App.game.spaceship.move(-10);
            }
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(App.game.spaceship.get_y()<150)
            App.game.spaceship.move(10);  
        }
        }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}