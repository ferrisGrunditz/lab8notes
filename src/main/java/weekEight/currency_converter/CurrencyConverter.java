package weekEight.currency_converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CurrencyConverter extends JFrame{
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JLabel eurosResultLabel;
    private JPanel mainPanel;
    private JComboBox<String> currencyComboBox1;
    private final String EUROS = "Euros";
    private final String POUNDS = "Pounds";
    private Map<String, Double> exchangeRates = Map.of(EUROS, 0.84, POUNDS, 0.75);

    CurrencyConverter() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getRootPane().setDefaultButton(convertButton);
        //make it automatically select the button so user can press it by hitting enter

        currencyComboBox1.addItem(EUROS);
        currencyComboBox1.addItem(POUNDS);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // what was typed in the JTextField dollarsTextField?
                String dollarString = dollarsTextField.getText();

                try {
                    //convert to int
                    double dollars = Double.parseDouble(dollarString);
                    String toCurrency = (String) currencyComboBox1.getSelectedItem();
                    double exchangeRate = exchangeRates.get(toCurrency);
                    //convert to target currency
                    //convert to euros
                    double convertedValue = dollars * exchangeRate;
                    //display result in eurosResultLabel JLabel
                    String resultString = String.format("%.2f Dollars is equivalent to %.2f %s.", dollars, convertedValue, toCurrency);
                    eurosResultLabel.setText(resultString);
                }catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(CurrencyConverter.this,
                            "Please enter a number without any other symbols.");
                }
            }
        });
    }
}
