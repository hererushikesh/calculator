package com.Brocode;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, subButton, divButton, multiButton, decButton, equalButton;
	JButton clButton, delButton;

	JTextField textFields;

	Font myFont = new Font("TIMESNEWROMAN", Font.BOLD, 25);

	double num1 = 0;
	double num2 = 0;
	double result = 0;

	char operator;

	Calculator() {
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(400, 550);

		textFields = new JTextField();
		textFields.setBounds(50, 25, 300, 50);
		textFields.setFont(myFont);
		textFields.setBackground(Color.CYAN);
	//	textFields.setEditable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		multiButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equalButton = new JButton("=");
		clButton = new JButton("C");
		delButton = new JButton("Del");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = multiButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equalButton;
		functionButtons[6] = clButton;
		functionButtons[7] = delButton;

		for (int i = 0; i < 8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}

		clButton.setBounds(50, 430, 145, 50);
		delButton.setBounds(200, 430, 145, 50);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.CYAN);

		panel.add(numberButtons[9]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[7]);
		panel.add(multiButton);

		panel.add(numberButtons[6]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[4]);
		panel.add(subButton);

		panel.add(numberButtons[3]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[1]);
		panel.add(addButton);
		

		panel.add(decButton);

		panel.add(numberButtons[0]);
		panel.add(equalButton);
		panel.add(divButton);

		frame.add(panel);
		frame.add(clButton);
		frame.add(delButton);
		frame.add(textFields);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textFields.setText(textFields.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textFields.setText(textFields.getText().concat("."));
		}
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textFields.getText());
			operator = '+';
			textFields.setText("");
		}
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textFields.getText());
			operator = '-';
			textFields.setText("");
		}
		if (e.getSource() == multiButton) {
			num1 = Double.parseDouble(textFields.getText());
			operator = '*';
			textFields.setText("");
		}
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textFields.getText());
			operator = '/';
			textFields.setText("");
		}
		if (e.getSource() == equalButton) {
			num2 = Double.parseDouble(textFields.getText());
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textFields.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clButton) {
			textFields.setText("");
		}
		if (e.getSource() == delButton) {
			String string = textFields.getText();
			textFields.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textFields.setText(textFields.getText() + string.charAt(i));
			}
		}

	}

	public static void main(String[] args) {
		new Calculator();

	}

}
