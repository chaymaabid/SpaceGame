import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class App extends JFrame{

    public static JFrame frame;
    public static Game game;
    private Button startButton;
    private Button quitButton;
    private JLabel background ;
    private Button HighestscoreButton;

    public App(){
        super("space game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,450);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        
        ImageIcon backgroundIcon = new ImageIcon(this.getClass().getResource("/images/3.png"));
        //backgroundImage = backgroundIcon.getImage();
        background = new JLabel(backgroundIcon);
        background.setSize(700, 450);
        // Create the start button
        startButton = new Button("Start Game");
        
        startButton.setBounds(250,100, 200, 50);

        // Create the quit button
        quitButton = new Button("Quit Game");
        quitButton.setBounds(250, 200, 200, 50);
        HighestscoreButton=new Button("High Score");
        HighestscoreButton.setBounds(250, 300, 200, 50);

        // Add the buttons to the frame
        background.add(startButton);
        background.add(quitButton);
        background.add(HighestscoreButton);
        add(background);

        // Set the layout to null to allow absolute positioning of components
        setLayout(null);
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App.this.dispose();
                game=new Game();
                frame=new JFrame("space game");
                frame.add(game);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700,450);
                frame.setAlwaysOnTop(true);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                frame.setVisible(true);        
            }
        });
        HighestscoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                App.this.dispose();
                new Highestscore();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
               
        new App();
        
    }
}