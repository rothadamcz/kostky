/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kostky.kostky.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author rotha
 */
public class ImagePanel extends JPanel {
    
    private int diceValue;
    private boolean selected;
    
    public ImagePanel() {
        this.setPreferredSize(new Dimension(250, 250));
        diceValue = 0;
        selected = false;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(diceValue == 0) {
            g2d.drawString("Hoď kostkou", 10, 20);
        } else {
            try {
                Image image = ImageIO.read(new File("C:\\Users\\rotha\\OneDrive\\Plocha\\" + diceValue + ".png"));

                g2d.drawImage(image, 0, 0, null);
                g2d.drawString(diceValue + "", 10, 20);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(!this.isEnabled()) {
            g2d.setColor(Color.GRAY);
            g2d.fillRect(0, 0, 250, 250);
        }
        
        if(this.selected) {
            g2d.setColor(Color.ORANGE);
            g2d.fillOval(240, 0, 10, 10);
        }
    }
    
    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
        this.repaint();
    }
    
    public int getDiceValue() {
        return this.diceValue;
    }
    
    public void setSelected(boolean selected) {
        if(this.diceValue == 0) return;
        if(!this.isEnabled()) return;
        this.selected = selected;
        this.repaint();
    }
    
    public boolean isSelected() {
        return this.selected;
    }
    
}
