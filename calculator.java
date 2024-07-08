import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PercentageCalculator extends JFrame {
    private JTextField value1Field;
    private JTextField value2Field;
    private JComboBox<String> operationBox;
    private JLabel resultLabel;

    public PercentageCalculator() {
        setTitle("Percentage Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Initialize components
        JLabel value1Label = new JLabel("Value 1:");
        value1Field = new JTextField();
        JLabel value2Label = new JLabel("Value 2:");
        value2Field = new JTextField();
        JLabel operationLabel = new JLabel("Operation:");
        String[] operations = {"Calculate Percentage", "Percentage Increase", "Percentage Decrease", "Find Whole"};
        operationBox = new JComboBox<>(operations);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Result: ");

        // Add components to frame
        add(value1Label);
        add(value1Field);
        add(value2Label);
        add(value2Field);
        add(operationLabel);
        add(operationBox);
        add(new JLabel());  // empty cell
        add(calculateButton);
        add(new JLabel());  // empty cell
        add(resultLabel);

        // Add action listener to the button
        calculateButton.addActionListener(new CalculateButtonListener());
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double value1 = Double.parseDouble(value1Field.getText());
                double value2 = Double.parseDouble(value2Field.getText());
                String operation = (String) operationBox.getSelectedItem();
                double result = 0;

                switch (operation) {
                    case "Calculate Percentage":
                        result = (value1 / value2) * 100;
                        break;
                    case "Percentage Increase":
                        result = ((value2 - value1) / value1) * 100;
                        break;
                    case "Percentage Decrease":
                        result = ((value1 - value2) / value1) * 100;
                        break;
                    case "Find Whole":
                        result = (value1 / value2) * 100;
                        break;
                }

                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(PercentageCalculator.this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PercentageCalculator calculator = new PercentageCalculator();
            calculator.setVisible(true);
        });
    }
}
