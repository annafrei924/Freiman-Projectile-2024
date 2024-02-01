package freiman.projectile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectileTest {
    @Test
    public void getX() {
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);
        //when
        double actual = projectile.getX();
        //then
        assertEquals(46.28, actual, 0.01);
    }

    @Test
    public void getY() {
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);
        //when
        double actual = projectile.getY();
        //then
        assertEquals(-7.90, actual, 0.01);
    }

    @Test
    public void getApexTime() {
        Projectile projectile = new Projectile(31, 20);
        projectile.setSeconds(2.7);
        //when
        double actual = projectile.getApexTime();
        //then
        assertEquals(1.05, actual, 0.01);
    }
}
