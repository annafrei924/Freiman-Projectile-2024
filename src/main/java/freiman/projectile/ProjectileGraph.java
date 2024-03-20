package freiman.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0, 0);
    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    private final int gridSpacing = 30;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        //set background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());


        g.translate(gridSpacing, getHeight() - gridSpacing);

        // vertical lines
        for (int x = -gridSpacing; x < getWidth(); x += gridSpacing) {
            if (x == 0) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.lightGray);
            }
            g.drawLine(x, gridSpacing, x, -getHeight());
        }
        // horizontal lines
        for (int y = gridSpacing; y >= -getHeight(); y -= gridSpacing) {
            if (y == 0) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.lightGray);
            }
            g.drawLine(-gridSpacing, y, getWidth(), y);
        }

        //draws red dot and label
        g.setColor(Color.RED);
        double seconds = projectile.getSeconds();
        int currOvalX = (int) projectile.getX() - 4;
        int currOvalY = (int) -projectile.getY() - 4;
        g.fillOval(currOvalX, currOvalY, 8, 8);

        String curr = "(" + FORMAT.format(projectile.getX()) + ", "
                + FORMAT.format(projectile.getY()) + ")";
        g.drawString(curr, currOvalX - 40, currOvalY - 10);

        //draws the graph
        g.setColor(Color.BLACK);
        projectile.setSeconds(0);
        double prevX = projectile.getX();
        double prevY = -projectile.getY();
        for (int s = 0; s <= projectile.getApexTime() * 2 + 1; s++) {
            projectile.setSeconds(s);
            g.drawLine((int) prevX, (int) prevY,
                    (int) projectile.getX(), (int) -projectile.getY());
            prevX = projectile.getX();
            prevY = -projectile.getY();
        }

        //draws blue dot and label
        g.setColor(Color.BLUE);
        int peakOvalX = (int) (projectile.getInterceptX() / 2 - 4);
        int peakOvalY = (int) -projectile.getPeakY() - 4;
        g.fillOval(peakOvalX, peakOvalY, 8, 8);

        String peak = "(" + FORMAT.format(projectile.getInterceptX() / 2) + ", "
                + FORMAT.format(projectile.getPeakY()) + ")";
        g.drawString(peak, peakOvalX - 40, peakOvalY - 25);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        //tells the operating system to call paintComponent() again
        repaint();
    }

}
