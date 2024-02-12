package freiman.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void getPeakY() {
        Projectile projectile = new Projectile(31, 65);
        //when
        double actual = projectile.getPeakY();
        //then
        assertEquals(57.18, actual, 0.01);
    }

    @Test
    public void getInterceptX() {
        Projectile projectile = new Projectile(31, 65);
        //when
        double actual = projectile.getInterceptX();
        //then
        assertEquals(380.65, actual, 0.01);
    }
}
