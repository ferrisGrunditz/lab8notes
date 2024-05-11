package weekEight.movie_gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MovieGUI extends JFrame{
    private JTextField movieTitleTextField1;
    private JSlider ratingSlider;
    private JCheckBox wouldSeeAgainCheckBox;
    private JPanel mainPanel;
    private JLabel sliderValueLabel;
    private JLabel movieOpinionLabel;

    MovieGUI(){
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        configureEventHandlers();
    }
    private void configureEventHandlers(){
        ratingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateOpinion();
            }
        });
        wouldSeeAgainCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateOpinion();
            }
        });
    }

    private void updateOpinion(){
        String movieName = movieTitleTextField1.getText();
        int rating = ratingSlider.getValue();
        boolean seeAgain = wouldSeeAgainCheckBox.isSelected();

        String template = "You rated %s %d stars. You %s see again.";
        String seeAgainString = "would";
        if(!seeAgain){
            seeAgainString = "would not";
        }
        String opinion = String.format(template, movieName, rating, seeAgainString);
        movieOpinionLabel.setText(opinion);

    }
}
