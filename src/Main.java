import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java CircleMatic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel drawingPanel = new JPanel() {
            java.util.List<Circle> circles = new java.util.ArrayList<>();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Circle circle : circles) {
                    g.drawOval(circle.x - circle.radius, circle.y - circle.radius, circle.radius * 2, circle.radius * 2);
                }
            }

            {
                // Mouse listener
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int x = e.getX();
                        int y = e.getY();

                        // Radius dialogue
                        String radiusStr = JOptionPane.showInputDialog("Enter the radius of the circle:");
                        if (radiusStr != null) {
                            try {
                                int radius = Integer.parseInt(radiusStr);
                                circles.add(new Circle(x, y, radius));
                                repaint();
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                            }
                        }
                    }
                });
            }
        };
        frame.add(drawingPanel);
        frame.setVisible(true);
    }
}

class Circle {
    int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}