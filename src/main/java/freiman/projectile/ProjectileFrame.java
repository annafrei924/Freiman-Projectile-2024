package freiman.projectile;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ProjectileFrame extends JFrame {
    private JSlider anglesSlider;
    private JTextField velocityField;
    private JTextField secondsField;
    private JLabel labelX;
    private JLabel labelY;
    private JLabel peakY;
    private JLabel interceptX;

    public ProjectileFrame() {

        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        velocityField = new JTextField();
        add(velocityField);
        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);

        anglesSlider = new JSlider(0, 90);
        anglesSlider.setMajorTickSpacing(10);
        anglesSlider.setMinorTickSpacing(2);
        anglesSlider.setPaintTicks(true);
        anglesSlider.setPaintLabels(true);
        add(anglesSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        secondsField = new JTextField();
        add(secondsField);
        JLabel labelX = new JLabel("X");
        add(labelX);
        labelX = new JLabel();
        add(labelX);
        JLabel labelY = new JLabel("Y");
        add(labelY);
        labelY = new JLabel();
        add(labelY);
        JLabel peakLabelY = new JLabel("PeakY");
        add(peakLabelY);
        peakY = new JLabel();
        add(peakY);
        JLabel interceptLabelX = new JLabel("InterceptX");
        add(interceptLabelX);
        interceptX = new JLabel();
        add(interceptX);
        add(new JLabel());

        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        anglesSlider.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent ce) {
                calculate();
            }
        });

        calculateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }

        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
        });

        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener() {

            @Override
            public void update(DocumentEvent e) {
                calculate();
            }
        });

    }

    private void calculate() {
        Projectile projectile = new Projectile(anglesSlider.getValue(),
                Double.parseDouble(velocityField.getText()));
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        labelX.setText(Double.toString(projectile.getX()));
        labelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
    }

}
