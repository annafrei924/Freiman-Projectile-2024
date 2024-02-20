package freiman.projectile;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectileFrame extends JFrame {
    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        JLabel yLabel = new JLabel("Y");
        JLabel x = new JLabel();
        JLabel y = new JLabel();
        JLabel peakYLabel = new JLabel("PeakY");
        JLabel interceptXLabel = new JLabel("InterceptX");
        JLabel peakY = new JLabel();
        JLabel interceptX = new JLabel();

        JTextField velocityField = new JTextField();
        JTextField secondsField = new JTextField();
        JSlider anglesSlider = new JSlider(0, 90);

        anglesSlider.setMajorTickSpacing(10);
        anglesSlider.setMinorTickSpacing(2);
        anglesSlider.setPaintTicks(true);
        anglesSlider.setPaintLabels(true);

        JButton calculateButton = new JButton("Calculate");

        add(velocityLabel);
        add(velocityField);
        add(angleLabel);
        add(anglesSlider);
        add(secondsLabel);
        add(secondsField);
        add(xLabel);
        add(x);
        add(yLabel);
        add(y);
        add(peakYLabel);
        add(peakY);
        add(interceptXLabel);
        add(interceptX);
        add(new JLabel());

        add(calculateButton);

        anglesSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                Projectile projectile = new Projectile(anglesSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projectile projectile = new Projectile(anglesSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                Projectile projectile = new Projectile(anglesSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                Projectile projectile = new Projectile(anglesSlider.getValue(), Double.parseDouble(velocityField.getText()));
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));

                x.setText(Double.toString(projectile.getX()));
                y.setText(Double.toString(projectile.getY()));
                peakY.setText(Double.toString(projectile.getPeakY()));
                interceptX.setText(Double.toString(projectile.getInterceptX()));
            }
        });
    }
}
