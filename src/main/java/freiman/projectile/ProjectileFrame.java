package freiman.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileFrame extends JFrame {
    private JSlider velocitySlider;
    private JLabel velocityValue;
    private JLabel angleValue;
    private JSlider anglesSlider;
    private JTextField secondsField;
    private JLabel labelX;
    private JLabel labelY;
    private JLabel peakY;
    private JLabel interceptX;
    private ProjectileGraph graph;
    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");




    public ProjectileFrame() {

        setSize(800, 598);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        //setting this layout only on the west JPanel
        west.setLayout(new GridLayout(9, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        velocitySlider = new JSlider(0, 100, 65);
        west.add(velocitySlider);

        JLabel empty = new JLabel();
        west.add(empty);
        velocityValue = new JLabel(Integer.toString(velocitySlider.getValue()));
        west.add(velocityValue);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);

        anglesSlider = new JSlider(0, 90, 31);
        angleValue = new JLabel(String.valueOf(anglesSlider.getValue()));
        west.add(anglesSlider);

        empty = new JLabel();
        west.add(empty);
        angleValue = new JLabel(Integer.toString(anglesSlider.getValue()));
        west.add(angleValue);



        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField("2.7");
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

        velocitySlider.addChangeListener(ce -> calculate());

        anglesSlider.addChangeListener(ce -> calculate());

        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) e -> calculate());

        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);
        calculate();

    }

    private void calculate() {
        Projectile projectile = new Projectile(anglesSlider.getValue(),
                velocitySlider.getValue());
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));

        labelX.setText(FORMAT.format(projectile.getX()));
        labelY.setText(FORMAT.format(projectile.getY()));

        velocityValue.setText(Integer.toString(velocitySlider.getValue()));
        angleValue.setText(Integer.toString(anglesSlider.getValue()));

        peakY.setText(FORMAT.format(projectile.getPeakY()));
        interceptX.setText(FORMAT.format(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }

}
