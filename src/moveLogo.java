import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class moveLogo extends JPanel implements ActionListener {
    private int x;      //x coordinates
    private int y;      //y coordinates

    private int xspeed; //x velocity
    private int yspeed; //y velocity

    private int delay = 100;
    private Timer timer;


    //size of the window
    private int width = 800;
    private int height = 600;

    //size of the dvd image
    private int imgWidth;
    private int imgHeight;

    //counters
    private int counter = 0;
    private int wallCounter = 0;

    //variable to store image
    BufferedImage img = null;


    public moveLogo() {
        //random starting position for x and y
        x = new Random().nextInt(700);
        y = new Random().nextInt(500);
        //velocity
        xspeed = 10;
        yspeed = 10;

        setFocusable(true);
        timer = new Timer(delay, this);
        timer.start();

        try {
            img = ImageIO.read(new File("/Users/ssk12/Google Drive/Computer/Java/TestProject/dvd_logo/src/dvd2.png"));
        } catch(IOException e) {
            System.out.println("Image not found!");
            System.exit(0);
        }

        imgHeight = img.getHeight();
        imgWidth = img.getWidth();
    }

    @Override
    public void paint(Graphics g) {

        //background
        g.setColor(Color.BLACK);
        g.fillRect(1,1,800, 600);

        //dvd logo
        //g.setColor(Color.BLUE);
        //g.fillRect(x, y, 80, 60);
        g.drawImage(img, x, y, null);


        //border
        g.fillRect(0,0, 3, 592);
        g.fillRect(0, 0, 800, 3);

        x = x + xspeed;
        y = y + yspeed;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Times Roman", Font.BOLD, 5));
        g.drawString("Number of edge hits: " +counter, 300, 10);
        g.drawString("Number of wall hits: "+wallCounter, 400, 10);

        if ((x <= 0 && y <= 0) || (x >= width && y <= 0))
            counter++;
        else if((x <= 0 && y >= height+20) || (x >= width && y >= height+20))
            counter++;

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(x+ imgWidth  >= width) {
            xspeed = -xspeed;
            wallCounter++;
            //x = width - imgWidth;
        }
        else if(x <= 0) {
            xspeed = -xspeed;
            wallCounter++;
            //x = 0;
        }

        if(y + imgHeight + 20 >= height) {
            yspeed = -yspeed;
            wallCounter++;
            //y = height - imgHeight;
        }
        else if(y <= 0) {
            yspeed = -yspeed;
            wallCounter++;
            //y = 0;
        }

        repaint();
    }
}
