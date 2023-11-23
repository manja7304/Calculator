package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

public class PanelJ implements ActionListener {
	private int i;
	public static JPanel panel = new JPanel();
	private JTextField tb = new JTextField();
	private JButton button[] = new JButton[16];
	private double num1, num2, result;
	private String operator;
	Font font = new Font("TimesRoman", Font.BOLD, 14);
	Font font2 = new Font("TimesRoman", Font.BOLD, 18);
	Font font3 = new Font("TimesRoman", Font.BOLD, 20);
	JButton label = new JButton("Calculator");

	PanelJ() {
		panel.add(label);
		panel.add(tb);
		for (i = 0; i < 16; i++) {
			button[i] = new JButton(Integer.toString(i));
			button[i].setPreferredSize(new Dimension(100, 50));
			button[i].setFocusable(false);
			button[i].setFont(font2);
			panel.add(button[i]);
		}
		button[10].setText("+");
		button[11].setText("-");
		button[12].setText("*");
		button[13].setText("/");
		button[14].setText("=");
		button[15].setText("C");
		for (i = 0; i < 16; i++) {
			button[i].addActionListener(this);
		}

		tb.setPreferredSize(new Dimension(420, 50));
		tb.setFont(font3);
		label.setPreferredSize(new Dimension(420, 50));
		label.setFont(font3);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setFocusable(false);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setSize(500, 350);
		panel.setBackground(new ColorUIResource(245, 197, 66));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* Logic behind Calculations 
		 * it is simple calculation logic 
		 * it is highly optimized
		 * ******************* */
		String command = e.getActionCommand();
		if (Character.isDigit(command.charAt(0))) {
			tb.setText(tb.getText() + command);
		} else if (command.equals("C")) {
			tb.setText("");
		} else if (command.equals("=")) {
			num2 = Double.parseDouble(tb.getText());
			if (operator.equals("+")) {
				result = num1 + num2;
			} else if (operator.equals("-")) {
				result = num1 - num2;
			} else if (operator.equals("*")) {
				result = num1 * num2;
			} else if (operator.equals("/")) {
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					tb.setText("Error: Cannot divide by zero");
					return;
				}
			}
			tb.setText(String.valueOf(result));
			operator = "";
		} else {
			operator = command;
			num1 = Double.parseDouble(tb.getText());
			tb.setText("");
		}

	}

}
