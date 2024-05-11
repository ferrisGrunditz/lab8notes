package weekEight.hello_gui_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloGUI extends JFrame {

    private JPanel mainPanel;
    private JButton clickMeButton;
    private JLabel firstLabel;
    private JCheckBox coolChampagneJustInCheckBox;
    private JCheckBox makeSureToHaveCheckBox;
    private JCheckBox vaccuumFloorCheckBox;
    private JCheckBox getSpongebobPuzzleFromCheckBox;

    HelloGUI() {
        setContentPane(mainPanel);

        setPreferredSize(new Dimension(300,500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code here - this runs when button clicked
                firstLabel.setText("Good job!");
            }
        });
        coolChampagneJustInCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coolChampagneJustInCheckBox.setBackground(Color.RED);
            }
        });
        vaccuumFloorCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaccuumFloorCheckBox.setBackground(Color.magenta);
            }
        });
    }

}
