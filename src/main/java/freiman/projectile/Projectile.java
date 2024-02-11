package freiman.projectile;

public class Projectile {
    private final double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private static final double GRAVITY = 9.8;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds - (.5 * GRAVITY * seconds * seconds);
    }

    /**
     * @return the time when the projectile is at its highest point
     */
    public double getApexTime() {
        return (velocity * Math.sin(radians)) / GRAVITY;
    }

    /**
     * @return the maximum height of the projectile
     */
    public double getPeakY() {
        return (velocity * Math.sin(radians) * velocity * Math.sin(radians)) / (2 * GRAVITY);
    }
}
