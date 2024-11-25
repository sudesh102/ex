import java.awt.event.*;
import javax.swing.*;

public class KeyMouseEventDemo extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
    private JLabel label;

    public KeyMouseEventDemo() {
        // Set up the frame
        setTitle("Key and Mouse Events Demo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize the label to display messages
        label = new JLabel("Press a key or click/move the mouse");
        label.setBounds(50, 50, 400, 30);
        add(label);

        // Add key and mouse listeners
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        // Set the frame to be focusable to receive key events
        setFocusable(true);
        setVisible(true);
    }

    // KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        label.setText("Key Typed: " + e.getKeyChar());
    }

    // MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse Entered the window");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse Exited the window");
    }

    // MouseMotionListener methods
    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("Mouse Dragged at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        label.setText("Mouse Moved at (" + e.getX() + ", " + e.getY() + ")");
    }

    public static void main(String[] args) {
        new KeyMouseEventDemo();
    }
}
