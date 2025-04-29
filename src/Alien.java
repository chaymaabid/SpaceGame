import java.awt.Image;

import javax.swing.ImageIcon;

public class Alien {

    private int largeur;
	private int hauteur;
	private int x;
	private int y;
    private int distance_between_aliens;
	private ImageIcon alien_Icon;
	private Image alien_img;

    public Alien(int x, int y){
        this.largeur = 55;
		this.hauteur = 35;
		this.x = x;
		this.y = y;
		distance_between_aliens=100;
       
		this.alien_Icon = new ImageIcon(getClass().getResource("/images/alien.png"));
		this.alien_img = this.alien_Icon.getImage();
    }

    public int get_distance_between_aliens(){return this.distance_between_aliens;}
    public int get_x(){return this.x;}
    public int get_y(){return this.y;}
    public Image get_image(){return this.alien_img;}
    public int get_hauteur(){return this.hauteur;}
    public int get_largeur(){return this.largeur;}

    public void set_x(int x){this.x=x;}
    public void set_y(int y){this.y=y;}

    
}
