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
        JLabel labelX = new JLabel("X");
        add(labelX);
        JLabel x = new JLabel();
        add(x);
        JLabel labelY = new JLabel("Y");
        add(labelY);
        JLabel y = new JLabel();
        add(y);
        JLabel peakLabelY = new JLabel("PeakY");
        add(peakLabelY);
        JLabel peakY = new JLabel();
        add(peakY);
        JLabel interceptLabelX = new JLabel("InterceptX");
        add(interceptLabelX);
        JLabel interceptX = new JLabel();
        add(interceptX);
        add(new JLabel());

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        anglesSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent ce) {
                calculate(anglesSlider, velocityField, secondsField, x, y, peakY, interceptX);
            }
        });

        calculateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calculate(anglesSlider, velocityField, secondsField, x, y, peakY, interceptX);
            }


        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                calculate(anglesSlider, velocityField, secondsField, x, y, peakY, interceptX);
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                calculate(anglesSlider, velocityField, secondsField, x, y, peakY, interceptX);
            }
        });

    }

    private void calculate(JSlider anglesSlider, JTextField velocityField, JTextField secondsField,
                           JLabel x, JLabel y, JLabel peakY, JLabel interceptX) {
        Projectile projectile = new Projectile(anglesSlider.getValue(),
                Double.parseDouble(velocityField.getText()));
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        x.setText(Double.toString(projectile.getX()));
        y.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
    }

}
