package freiman.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.translate(0, getHeight());
        g.drawArc(0, (int) -projectile.getPeakY(),
                (int) projectile.getInterceptX(), (int) projectile.getPeakY(),
                0, 180);
        g.setColor(Color.BLUE);
        g.fillOval((int) (projectile.getInterceptX()/2 - 2), (int) -projectile.getPeakY()-2, 4, 4);

    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        //tells the operating system to call paintComponent() again
        repaint();
    }

}
