package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawClass extends JPanel {

  public void paint(Graphics g) {
    Image img = createImage();
    g.drawImage(img,20,20,this);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new DrawClass());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    ImageIcon img = new ImageIcon("src\\main\\resources\\xmas.png");
    frame.setIconImage(img.getImage());
    frame.setVisible(true);
  }
  
  private Image createImage(){
    BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
    Graphics g = bufferedImage.getGraphics();
    g.drawString("TEST", 20,20);
    g.drawRect(25, 25, 10, 10);
    g.setColor(Color.green);
    g.fillRect(40, 40, 10, 10);
    
    return bufferedImage;
  }
}

