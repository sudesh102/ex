import java.awt.*;
import javax.swing.*;

public class BouncingBall extends JFrame {
    private BallPanel ballPanel;

    public BouncingBall() {
        // Set up the frame
        setTitle("Bouncing Ball");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the ball panel
        ballPanel = new BallPanel();
        add(ballPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BouncingBall::new);
    }
}

class BallPanel extends JPanel implements Runnable {
    private int ballX = 50, ballY = 50; // Initial position of the ball
    private int ballDiameter = 30; // Diameter of the ball
    private int ballXSpeed = 5, ballYSpeed = 5; // Speed of the ball in the X and Y directions

    private Thread ballThread;

    public BallPanel() {
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        // Start the ball animation in a new thread
        ballThread = new Thread(this);
        ballThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void run() {
        // Animation loop
        while (true) {
            // Update ball position
            ballX += ballXSpeed;
            ballY += ballYSpeed;

            // Check for collision with the panel borders and reverse direction if needed
            if (ballX <= 0 || ballX >= getWidth() - ballDiameter) {
                ballXSpeed = -ballXSpeed;
            }
            if (ballY <= 0 || ballY >= getHeight() - ballDiameter) {
                ballYSpeed = -ballYSpeed;
            }

            // Repaint the panel
            repaint();

            // Pause the thread for a short period to control animation speed
            try {
                Thread.sleep(20); // Adjust the sleep time to control speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
