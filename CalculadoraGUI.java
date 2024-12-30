import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI {
    private JFrame frame;
    private JTextField display;
    private StringBuilder currentInput = new StringBuilder();
    private double firstOperand = 0;
    private String operator = "";
    private boolean resetDisplay = false;

    public CalculadoraGUI() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "AC", "+/-", "ERR"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                if (resetDisplay) {
                    currentInput.setLength(0);
                    resetDisplay = false;
                }
                if (currentInput.length() < 8) {
                    currentInput.append(command);
                    display.setText(currentInput.toString());
                }
            } else if (".".equals(command)) {
                if (!currentInput.toString().contains(".")) {
                    currentInput.append(".");
                    display.setText(currentInput.toString());
                }
            } else if ("+/-".equals(command)) {
                toggleSign();
            } else if ("C".equals(command)) {
                currentInput.setLength(0);
                display.setText("0");
            } else if ("AC".equals(command)) {
                currentInput.setLength(0);
                operator = "";
                firstOperand = 0;
                display.setText("0");
            } else if ("=+*/-".contains(command)) {
                performOperation(command);
            }
        }

        private void toggleSign() {
            if (currentInput.length() > 0) {
                if (currentInput.charAt(0) == '-') {
                    currentInput.deleteCharAt(0);
                } else {
                    currentInput.insert(0, '-');
                }
                display.setText(currentInput.toString());
            }
        }

        private void performOperation(String command) {
            try {
                if (!operator.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput.toString());
                    switch (operator) {
                        case "+":
                            firstOperand += secondOperand;
                            break;
                        case "-":
                            firstOperand -= secondOperand;
                            break;
                        case "*":
                            firstOperand *= secondOperand;
                            break;
                        case "/":
                            if (secondOperand == 0) {
                                display.setText("ERR");
                                return;
                            }
                            firstOperand /= secondOperand;
                            break;
                    }
                    display.setText(formatResult(firstOperand));
                } else {
                    firstOperand = Double.parseDouble(currentInput.toString());
                }
                operator = command.equals("=") ? "" : command;
                resetDisplay = true;
            } catch (NumberFormatException ex) {
                display.setText("ERR");
            }
        }

        private String formatResult(double value) {
            String result = String.valueOf(value);
            if (result.length() > 8) {
                return "ERR";
            }
            return result;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculadoraGUI::new);
    }
}
