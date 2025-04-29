import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Spaceship {
    private int largeur;
	private int hauteur;
	private int x;
	private int y;
	private ImageIcon spaceship_Icon;
	private Image spaceship_img;



    public Spaceship(int x,int y){
        this.hauteur=35;
        this.largeur=75;
        this.x=x;
        this.y=y;
        this.spaceship_Icon=new ImageIcon(getClass().getResource("/images/spaceship.png"));
        this.spaceship_img=this.spaceship_Icon.getImage();
    }

    public void move(int dy){
        this.y=this.y+dy;
    }

    public int get_x(){return this.x;}
    public int get_y(){return this.y;}
    public Image get_image(){return this.spaceship_img;}
    public int get_hauteur(){return this.hauteur;}
    public int get_largeur(){return this.largeur;}

    public void set_x(int x){this.x=x;}
    public void set_y(int y){this.y=y;}
/* 
    public boolean collision_spaceship(Alien c){
        if(this.x < c.get_x()+c.get_largeur() && this.x+this.largeur>c.get_x()
            && this.y < c.get_y()+c.get_hauteur()-30 && this.y+this.hauteur>c.get_y()+30)
        return true;
        else 
        return false;
    }
*/

    public boolean collision_spaceship(Alien a){
        Rectangle alien=new Rectangle(a.get_x()+10, a.get_y(), a.get_largeur(), a.get_hauteur());
        Rectangle spaceship=new Rectangle(this.x+80, this.y+220, this.largeur, this.hauteur);
        if(alien.intersects(spaceship))
        return true;
        return false;
    }
    /*public void run() {
        while(true){
            this.move(dy);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }
        
    }*/
    
}
