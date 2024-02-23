package freiman.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileFrame extends JFrame {
    private JSlider anglesSlider;
    private JTextField velocityField;
    private JTextField secondsField;
    private JLabel labelX;
    private JLabel labelY;
    private JLabel peakY;
    private JLabel interceptX;
    private ProjectileGraph graph;

    public ProjectileFrame() {

        setSize(800, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        //setting this layout only on the west JPanel
        //west.setLayout(new GridLayout(8, 2));
        west.setLayout(new GridLayout(7, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        velocityField = new JTextField();
        west.add(velocityField);
        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);

        anglesSlider = new JSlider(0, 90);
        anglesSlider.setMajorTickSpacing(10);
        anglesSlider.setMinorTickSpacing(2);
        anglesSlider.setPaintTicks(true);
        anglesSlider.setPaintLabels(true);
        west.add(anglesSlider);

        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField();
        west.add(secondsField);
        JLabel titleX = new JLabel("X");
        west.add(titleX);
        labelX = new JLabel();
        west.add(labelX);
        JLabel titleY = new JLabel("Y");
        west.add(titleY);
        labelY = new JLabel();
        west.add(labelY);
        JLabel peakLabelY = new JLabel("PeakY");
        west.add(peakLabelY);
        peakY = new JLabel();
        west.add(peakY);
        JLabel interceptLabelX = new JLabel("InterceptX");
        west.add(interceptLabelX);
        interceptX = new JLabel();
        west.add(interceptX);

        anglesSlider.addChangeListener(ce -> calculate());

        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> calculate());

        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) e -> calculate());

        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);

    }

    private void calculate() {
        Projectile projectile = new Projectile(anglesSlider.getValue(),
                Double.parseDouble(velocityField.getText()));
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        labelX.setText(Double.toString(projectile.getX()));
        labelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }

}
