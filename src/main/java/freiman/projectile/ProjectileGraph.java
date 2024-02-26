package freiman.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight());

        projectile.setSeconds(0);
        double prevX = projectile.getX();
        double prevY = -projectile.getY();

        for (int s = 0; s <= projectile.getApexTime()*2 + 1; s++) {
            projectile.setSeconds(s);
            g.drawLine((int) prevX, (int) prevY,
                    (int) projectile.getX(), (int) -projectile.getY());
            prevX = projectile.getX();
            prevY = -projectile.getY();
        }

        g.setColor(Color.BLUE);
        g.fillOval((int) (projectile.getInterceptX() / 2 - 2),
                (int) -projectile.getPeakY() - 2, 4, 4);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        //tells the operating system to call paintComponent() again
        repaint();
    }

}
