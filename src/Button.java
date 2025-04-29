import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.Border;

public class Button extends JButton {
    private int cornerRadius = 30;

    public Button(String text) {
        super(text);
        Border lineBorder = BorderFactory.createLineBorder(Color.RED);
        setBorder(lineBorder);
        setBackground(Color.WHITE);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setBackground(Color.black);
        /*setFocusPainted(false);
        setBorderPainted(false);

        setOpaque(true);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setForeground(Color.getHSBColor(254, 254, 226));
        this.setBackground(Color.black);*/
    }

   
   
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2.setColor(getBackground());
        g2.fill(shape);
        g2.setColor(getForeground());
        g2.drawString(getText(), (int) ((getWidth() - g2.getFontMetrics().stringWidth(getText())) / 2),
                (int) ((getHeight() - g2.getFontMetrics().getHeight()) / 2) + g2.getFontMetrics().getAscent());
        g2.dispose();
    }
    
}
