
public class Run implements Runnable{

    @Override
    public void run() {
        while(App.game.collision()==false)
        {
            App.game.x_fond--;
            App.game.repaint();
            
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            if(App.game.collision())
            {
                App.frame.dispose();
                new Gameover();
                return;
            }
        }
       

        
    }
    
}
