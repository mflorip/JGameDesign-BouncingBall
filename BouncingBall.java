import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class BouncingBall extends JPanel{

    //variables for ball 1
    int x = 0, y = 0;
    int dx = 20,  dy = 20;

    //variables for ball 2
    int x2 = 5, y2 = 0;
    int dx2 = 5, dy2 = 5;
    //variables for ball3
    int x3 = 38, y3 = 29;
    int dx3 = 22, dy3 = 22;

    //fonts (optional)
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
    //method to move the ball (will be called in the main method)
    public void move() {
        //ball 1
        if (x + dx < 0){
            dx = 20;
        } else if (x + dx > getWidth() - 25){
            dx = -20;
        } else if (y + dy < 0){
            dy = 20;
        } else if (y + dy > getHeight() - 25){
            dy = -20;
        }

        //ball2
        if (x2 + dx2 < 0){
            dx2 = 5;
        } else if (x2 + dx2 > getWidth() - 25){
            dx2 = -5;
        } else if (y2 + dy2 < 0){
            dy2 = 5;
        } else if (y2 + dy2 > getHeight() - 25){
            dy2 = -5;
        }

        //ball3
        if (x3 + dx3 < 0){
            dx3 = 22;
        } else if (x3 + dx3 > getWidth() - 25){
            dx3 = -22;
        } else if (y3 + dy3 < 0){
            dy3 = 22;
        } else if (y3 + dy3 > getHeight() - 25){
            dy3 = -22;
        }

        //moves ball 1
        x += dx;
        y += dy;
        //moves ball2
        x2 += dx2;
        y2 += dy2;
        //moves ball3
        x3 += dy3;
        y3 += dy3;
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(font);
        g.drawString("Bouncing Ball", getWidth()/4, getHeight()/4);
        //ball 1
        g.setColor(Color.blue);
        g.fillOval(x, y, 50, 50);
        //ball 2
        g.setColor(Color.green);
        g.fillOval(x2, y2, 50, 50);
        //ball 3
        g.setColor(Color.red);
        g.fillOval(x3, y3, 50, 50);


    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall ball = new BouncingBall();
        frame.add(ball);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //while loop to run the ball
        while(true){
            ball.move();
            ball.repaint();
            Thread.sleep(15);
        }


    }

}