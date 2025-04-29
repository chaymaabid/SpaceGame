
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Game extends JPanel{
    
    private ImageIcon background_icon1;
    

	private Image background_img1;
   

    private Alien alien1;
    private Alien alien2;
    private Alien alien3;
    private Alien alien4;
    private Alien alien5;
    private Alien alien6;
    private Alien alien7;
    private Alien alien8;

    public Spaceship spaceship;
    public boolean endgame=false;

    public int score;

    public int x_fond=0;

    public int x_alien;

    Random random;
    Font font;

    public Game(){
        super();
        this.score=0;
        this.background_icon1 = new ImageIcon(getClass().getResource("/images/3.png"));
		this.background_img1 = this.background_icon1.getImage();
       

        this.x_alien=700;
        random=new Random();
        this.font=new Font("Helvetica", Font.BOLD, 24);

        //50=distance entre deux nuages
        alien1=new Alien(this.x_alien, 5);
        alien2=new Alien(this.alien1.get_x()+200+this.alien1.get_largeur(), 180);
        alien3=new Alien(this.alien2.get_x()+200+this.alien2.get_largeur(), 300);

        alien4=new Alien(this.alien1.get_x(),this.alien1.get_y()+ this.alien1.get_hauteur()+this.alien1.get_distance_between_aliens());
        alien5=new Alien(this.alien3.get_x(), this.alien3.get_y()+this.alien3.get_hauteur()+this.alien1.get_distance_between_aliens());
        alien6=new Alien(this.alien2.get_x(), this.alien2.get_y()+this.alien2.get_hauteur()+this.alien2.get_distance_between_aliens());
        alien7=new Alien(this.alien3.get_x(),this.alien6.get_y()+100);
        alien8=new Alien(this.alien1.get_x(), this.alien4.get_y()+ this.alien1.get_hauteur()+this.alien1.get_distance_between_aliens());

        spaceship=new Spaceship(100,50);

        this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Spaceship_move());

        Run runnable=new Run();
        Thread thread =new Thread(runnable);
             thread.start();  
        
    }

    private void move_backround(Graphics g){
        
       /*  if(this.x_fond==-100)
        {x_fond=0;}*/
        x_fond=0;
        g.drawImage(background_img1, x_fond, 0, null);
      
        
    }
    private void move_alien(Graphics g){
        
        this.alien1.set_x(this.alien1.get_x() - 1);
        this.alien4.set_x(this.alien1.get_x());
        this.alien8.set_x(this.alien1.get_x());
        
		if(this.alien1.get_x() == -100){
            this.alien1.set_x(this.alien3.get_x()+200+this.alien3.get_largeur());
	    	this.alien1.set_y(5+ 20* this.random.nextInt(140));
            //while(this.alien1.get_y()<20|| this.alien1.get_y()>200)
            //{ this.alien1.set_y(5+ 30* this.random.nextInt(10));}
            this.alien4.set_x(this.alien1.get_x());
            if(alien1.get_y()>220)
            {this.alien4.set_y(this.alien1.get_y()-this.alien1.get_distance_between_aliens());
                this.alien8.set_y(this.alien4.get_y()-this.alien4.get_distance_between_aliens());
            }
            else
            {
                this.alien4.set_y(this.alien1.get_y()+this.alien1.get_hauteur()+this.alien1.get_distance_between_aliens());
                this.alien8.set_y(this.alien4.get_y()+this.alien4.get_distance_between_aliens());
            }
            System.out.println("alien1 "+alien1.get_y());
            System.out.println("alien4 "+alien4.get_y());
	    }		
		g.drawImage(this.alien1.get_image(), this.alien1.get_x(),this.alien1.get_y(), null);
        g.drawImage(this.alien4.get_image(), this.alien4.get_x(), this.alien4.get_y(), null);
        g.drawImage(this.alien8.get_image(), this.alien8.get_x(), this.alien8.get_y(), null);
		 
		
		// alien2
        this.alien2.set_x(this.alien2.get_x() - 1);
        this.alien6.set_x(this.alien2.get_x());
			
		if(this.alien2.get_x() == -100){
            this.alien2.set_x(this.alien1.get_x()+200+this.alien1.get_largeur());
	    	this.alien2.set_y(5+ 40* this.random.nextInt(9));
            //while(this.alien2.get_y()<20|| this.alien2.get_y()>200)
            //{ this.alien2.set_y(5+ 30* this.random.nextInt(10));}

            System.out.println(alien2.get_y());

            this.alien6.set_x(this.alien2.get_x());
            if(alien2.get_y()>220)
            {this.alien6.set_y(this.alien2.get_y()-this.alien2.get_distance_between_aliens());}
            else
            this.alien6.set_y(this.alien2.get_y()+this.alien2.get_hauteur()+this.alien2.get_distance_between_aliens());

            System.out.println("alien2 "+alien2.get_y());
            System.out.println("alien6 "+alien6.get_y());
	    }		
		g.drawImage(this.alien2.get_image(), this.alien2.get_x(),this.alien2.get_y(), null);
        g.drawImage(this.alien6.get_image(), this.alien6.get_x(), this.alien6.get_y(), null);
		
		// alien 3
        this.alien3.set_x(this.alien3.get_x() - 1);
        this.alien5.set_x(this.alien3.get_x());
        this.alien7.set_x(this.alien3.get_x());
        
		if(this.alien3.get_x() == -100){
    
            this.alien3.set_x(this.alien2.get_x()+200+this.alien3.get_largeur());
            this.alien3.set_y( 10* this.random.nextInt(37));

           // while(this.alien3.get_y()<20|| this.alien3.get_y()>200)
            //{ this.alien3.set_y(5+ 20* this.random.nextInt(10));}

            this.alien5.set_x(this.alien3.get_x());
            this.alien7.set_x(this.alien3.get_x());
            if(alien3.get_y()>220)
            {this.alien5.set_y(this.alien3.get_y()-this.alien3.get_distance_between_aliens());}
            else
            this.alien5.set_y(this.alien3.get_y()+this.alien3.get_hauteur()+this.alien3.get_distance_between_aliens());

            System.out.println("alien 3 "+alien3.get_y());
            System.out.println("alien5 "+alien5.get_y());
            this.alien7.set_x(this.alien3.get_x());
            if(alien5.get_y()>0&&alien5.get_y()<200)
            this.alien7.set_y(this.alien5.get_y()+100);
            else
            this.alien7.set_y(this.alien5.get_y()+100);
	    }		
        
        
		g.drawImage(this.alien3.get_image(), this.alien3.get_x(),this.alien3.get_y(), null);
    
        g.drawImage(this.alien5.get_image(), this.alien5.get_x(),this.alien5.get_y(), null);
        g.drawImage(this.alien7.get_image(), this.alien7.get_x(),this.alien7.get_y(), null);
     
	}

    public boolean collision(){
        if(this.spaceship.collision_spaceship(alien1)||this.spaceship.collision_spaceship(alien2)||
        this.spaceship.collision_spaceship(alien3)||this.spaceship.collision_spaceship(alien4)||this.spaceship.collision_spaceship(alien5)
        ||this.spaceship.collision_spaceship(alien6)||this.spaceship.collision_spaceship(alien7)||this.spaceship.collision_spaceship(alien8))
        return true;
        else
        return false;
    }
    
    public void score(){
        if(this.spaceship.get_x()==this.alien1.get_x()+this.alien1.get_largeur()) 
        this.score++;
        if( this.spaceship.get_x() == this.alien2.get_x()+this.alien1.get_largeur())
        this.score++;
        if(this.spaceship.get_x() == this.alien3.get_x()+this.alien1.get_largeur())
        this.score++;
        if(this.spaceship.get_x() == this.alien4.get_x()+this.alien1.get_largeur())
        this.score++;
        if(this.spaceship.get_x() == this.alien5.get_x()+this.alien1.get_largeur())
        this.score++;

    }

    public void paintComponent(Graphics g){
        
        this.move_backround(g);
       this.move_alien(g);
       g.drawImage(spaceship.get_image(), spaceship.get_x(), spaceship.get_y(), null);
       this.score();
       
       //g.setForeground(Color.BLUE);
        g.setFont(font);
        g.drawString("Score="+score, 300, 50);
      
          
    }

}
