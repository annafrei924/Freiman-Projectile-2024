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
        add(velocityLabel);
        JTextField velocityField = new JTextField();
        add(velocityField);
        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);

        JSlider anglesSlider = new JSlider(0, 90);
        anglesSlider.setMajorTickSpacing(10);
        anglesSlider.setMinorTickSpacing(2);
        anglesSlider.setPaintTicks(true);
        anglesSlider.setPaintLabels(true);
        add(anglesSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        JTextField secondsField = new JTextField();
        add(secondsField);
        JLabel xLabel = new JLabel("X");
        add(xLabel);
        JLabel x = new JLabel();
        add(x);
        JLabel yLabel = new JLabel("Y");
        add(yLabel);
        JLabel y = new JLabel();
        add(y);
        JLabel peakYLabel = new JLabel("PeakY");
        add(peakYLabel);
        JLabel peakY = new JLabel();
        add(peakY);
        JLabel interceptXLabel = new JLabel("InterceptX");
        add(interceptXLabel);
        JLabel interceptX = new JLabel();
        add(interceptX);
        add(new JLabel());

        JButton calculateButton = new JButton("Calculate");
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
