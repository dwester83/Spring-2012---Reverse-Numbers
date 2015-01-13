/*
Author: Daniel Wester

Date: 04.05.12

Course: 2243-01, Spring 2012

Assignment: PGM3 Part 1

Description: This program will input a string from the user, convert it to a
integer, then convert it back to a string removing the leading 0s. After that it'll
count the string length and use that length to check the characters and each spot.
It'll then rebuild the string in reverse and output it to the user.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseNumbers extends JFrame {

	JTextArea descriptionArea;
	JLabel inputLabel, outputLabel;
	JTextField inputField, outputField;
	JButton reverseButton, exitButton;
	JPanel southPanel, centerPanel;

	public ReverseNumbers() {
		
		//Setting labels
		descriptionArea = new JTextArea("Welcome,\nThis program will reverse any integer you put into it.\nThanks for using the program.");
		descriptionArea.setLineWrap(true);
		descriptionArea.setEditable(false);
		descriptionArea.setBackground(null);
		inputLabel = new JLabel("Input the number here: ", SwingConstants.RIGHT);
		outputLabel = new JLabel("The reverse number is: ", SwingConstants.RIGHT);
		inputField = new JTextField("", SwingConstants.LEFT);
		inputField.addActionListener(new ReverseButtonHandler());
		outputField = new JTextField("", SwingConstants.LEFT);
		outputField.setEditable(false);
		reverseButton = new JButton ("Reverse Numbers");
		reverseButton.addActionListener(new ReverseButtonHandler());
		exitButton = new JButton ("Exit");
		exitButton.addActionListener(new ExitButtonHandler());
		
		//Building panels
		Container pane = getContentPane();
		centerPanel = new JPanel(new GridLayout (2,2));
		southPanel = new JPanel(new GridLayout (1,2));
		centerPanel.add(inputLabel);
		centerPanel.add(inputField);
		centerPanel.add(outputLabel);
		centerPanel.add(outputField);
		southPanel.add(reverseButton);
		southPanel.add(exitButton);
		
		//Showing everything
		setLayout(new BorderLayout());
		setSize(300,200);
		setTitle("Reverse Numbers Program");
		add(descriptionArea, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	//Reverse numbers
	private class ReverseButtonHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			boolean loopReverse = true; 
			String theOutput = "", buildingOutput = "";
			int inputInt = 0, decreaseChar = 0;
			char inputChar = 0;
			
			inputInt = Integer.parseInt(inputField.getText());
			buildingOutput = buildingOutput + inputInt;
			decreaseChar = buildingOutput.length();
			decreaseChar--;
			
			do {
				if (decreaseChar < 0) {
					loopReverse = false;
				} else {
					inputChar = buildingOutput.charAt(decreaseChar);
					if (inputChar == '-') {
						theOutput =  inputChar + theOutput;
						decreaseChar--;
					} else {
						theOutput = theOutput + inputChar;
						decreaseChar--;
					}
				}
			} while (loopReverse);
			
			outputField.setText(theOutput);
			inputField.requestFocusInWindow();
			inputField.selectAll();
		}
	}
	
	//Exit button
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			System.exit(0);
		}
	}
	
	//Main
	public static void main (String [] args) {
		new ReverseNumbers();
	}
}

