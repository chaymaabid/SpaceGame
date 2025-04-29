import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;

public class Gameover extends JFrame {

    public static Game game;
    private Button restartButton;
    private Image backgroundImage;
    private JLabel background ;
    private JLabel gameover;
    private JLabel highestJLabel;

    private int highestScore = 0;
    
    public Gameover(){
        super("space game gameover!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,450);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        

        ImageIcon backgroundIcon = new ImageIcon(this.getClass().getResource("/images/3.png"));
        background = new JLabel(backgroundIcon);
        background.setSize(700, 450);


        // Create the quit button
        restartButton = new Button("Go back to the menu");
        restartButton.setBounds(250, 250, 200, 50);


        // Add the buttons to the frame
        background.add(restartButton);

        highestScore = readHighestScore();
        if (App.game.score> highestScore) {
            highestScore = App.game.score;
            gameover=new JLabel("<html>GAME OVER !<br> score="+App.game.score+"</html>");
            //gameover=new JLabel("GAME OVER !"+System.lineSeparator()+" Gongrat you have the highestScore"+System.lineSeparator()+ "score="+App.game.score);
            highestJLabel=new JLabel("Congratulations, you've achieved a new high score!");
            highestJLabel.setOpaque(false);
            // gameover.setBackground(new Color(253, 253, 150));
            highestJLabel.setForeground(new Color(253, 253, 150));
            highestJLabel.setFont(new Font("Arial", Font.BOLD, 24));
            highestJLabel.setBounds(50, 200, highestJLabel.getPreferredSize().width, highestJLabel.getPreferredSize().height);
            background.add(highestJLabel, BorderLayout.CENTER);
            writeHighestScore(highestScore);

        }
        else {
            gameover=new JLabel("<html>GAME OVER !<br> score="+App.game.score+"</html>");
            
        }
        gameover.setOpaque(false);
       // gameover.setBackground(new Color(253, 253, 150));
        gameover.setForeground(new Color(253, 253, 150));
        gameover.setFont(new Font("Arial", Font.BOLD, 24));
        gameover.setBounds(250, 100, gameover.getPreferredSize().width, gameover.getPreferredSize().height);
        
        background.add(gameover, BorderLayout.CENTER);
        //background.add(gameover);

        add(background);

        // Set the layout to null to allow absolute positioning of components
        setLayout(null);
        this.setVisible(true);
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new App();
                //Gameover.this.add(game);
            }
        });
        
    }
    static int readHighestScore() {
        // Read the highest score from the file or the database
        // and return it as an int
        // If there's an error, return 0 as the default value
        int highestScore = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("highestscore.txt"))) {
            highestScore = Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return highestScore;
    }
    private void writeHighestScore(int highestScore) {
        // Write the highest score to the file or the database
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("highestscore.txt"))) {
            writer.write(Integer.toString(highestScore));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  public void paint(Graphics g){
        
    g.setFont(new Font("Arial", Font.BOLD, 24));
    g.setColor(new Color(253, 253, 150));
    g.drawString("votre Score="+App.game.score, 300, 300);
      
          
    }*/
}
