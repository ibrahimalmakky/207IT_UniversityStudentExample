package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.Component;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.xml.bind.JAXBException;

import University.*;

public class AddNewStudentPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField firstNameTextBox;
	private JTextField lastNameTextBox;
	private JTextField cityTextBox;
	private final Action addNewStudentAction;
	private JTextField dayTextBox;
	private JTextField monthTextField;
	private JTextField yearTextField;
	private final Action backAction = new BackAction();
	private University uni;

	/**
	 * Create the panel.
	 */
	public AddNewStudentPanel(University uni) {
		
		this.uni = uni;
		
		addNewStudentAction = new AddNewStudent(uni);
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblAddNewStudent = new JLabel("Add New Student");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddNewStudent, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblAddNewStudent, 185, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblAddNewStudent, -181, SpringLayout.EAST, this);
		add(lblAddNewStudent);
		
		JLabel lblFirstName = new JLabel("First Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 36, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 30, SpringLayout.WEST, this);
		add(lblFirstName);
		
		firstNameTextBox = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, firstNameTextBox, 9, SpringLayout.SOUTH, lblAddNewStudent);
		springLayout.putConstraint(SpringLayout.EAST, lblFirstName, -6, SpringLayout.WEST, firstNameTextBox);
		add(firstNameTextBox);
		firstNameTextBox.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 29, SpringLayout.SOUTH, lblFirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 30, SpringLayout.WEST, this);
		add(lblLastName);
		
		lastNameTextBox = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblLastName, -6, SpringLayout.WEST, lastNameTextBox);
		springLayout.putConstraint(SpringLayout.NORTH, lastNameTextBox, 26, SpringLayout.SOUTH, firstNameTextBox);
		springLayout.putConstraint(SpringLayout.WEST, lastNameTextBox, 130, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lastNameTextBox, -169, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, firstNameTextBox, 0, SpringLayout.EAST, lastNameTextBox);
		springLayout.putConstraint(SpringLayout.WEST, firstNameTextBox, 0, SpringLayout.WEST, lastNameTextBox);
		add(lastNameTextBox);
		lastNameTextBox.setColumns(10);
		
		JLabel lblDot = new JLabel("DoT (dd/mm/yyyy):");
		springLayout.putConstraint(SpringLayout.WEST, lblDot, 30, SpringLayout.WEST, this);
		add(lblDot);
		
		dayTextBox = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, dayTextBox, 165, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, dayTextBox, -250, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblDot, -31, SpringLayout.EAST, dayTextBox);
		springLayout.putConstraint(SpringLayout.NORTH, dayTextBox, 22, SpringLayout.SOUTH, lastNameTextBox);
		dayTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		add(dayTextBox);
		dayTextBox.setColumns(10);
		
		monthTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, monthTextField, 5, SpringLayout.EAST, dayTextBox);
		add(monthTextField);
		monthTextField.setColumns(10);
		
		yearTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, yearTextField, 255, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, yearTextField, -150, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, monthTextField, -50, SpringLayout.EAST, yearTextField);
		springLayout.putConstraint(SpringLayout.NORTH, yearTextField, 0, SpringLayout.NORTH, lblDot);
		add(yearTextField);
		yearTextField.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCity, 23, SpringLayout.SOUTH, lblDot);
		springLayout.putConstraint(SpringLayout.WEST, lblCity, 30, SpringLayout.WEST, this);
		add(lblCity);
		
		cityTextBox = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, monthTextField, -14, SpringLayout.NORTH, cityTextBox);
		springLayout.putConstraint(SpringLayout.NORTH, cityTextBox, 17, SpringLayout.SOUTH, dayTextBox);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDot, -20, SpringLayout.NORTH, cityTextBox);
		springLayout.putConstraint(SpringLayout.EAST, lblCity, -6, SpringLayout.WEST, cityTextBox);
		springLayout.putConstraint(SpringLayout.WEST, cityTextBox, 0, SpringLayout.WEST, firstNameTextBox);
		springLayout.putConstraint(SpringLayout.EAST, cityTextBox, -169, SpringLayout.EAST, this);
		add(cityTextBox);
		cityTextBox.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(backAction);
		springLayout.putConstraint(SpringLayout.WEST, btnBack, 127, SpringLayout.WEST, this);
		add(btnBack);
		
		JButton btnAdd = new JButton("Add");
		springLayout.putConstraint(SpringLayout.NORTH, btnBack, 0, SpringLayout.NORTH, btnAdd);
		springLayout.putConstraint(SpringLayout.EAST, btnBack, -107, SpringLayout.WEST, btnAdd);
		btnAdd.setAction(addNewStudentAction);
		springLayout.putConstraint(SpringLayout.WEST, btnAdd, 289, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAdd, -35, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnAdd, -110, SpringLayout.EAST, this);
		add(btnAdd);

	}
	
	public JPanel getPanel() {
		return this;
	}
	
	private class AddNewStudent extends AbstractAction {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private University uni;
		
		public AddNewStudent(University uni) {
			
			this.uni = uni;
			
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			Student newStudent = new Student(firstNameTextBox.getText(),
					lastNameTextBox.getText(),
					Integer.parseInt(dayTextBox.getText()),
					Integer.parseInt(monthTextField.getText()),
					Integer.parseInt(yearTextField.getText()),
					cityTextBox.getText()
					);
			
			uni.addStudent(newStudent);
			uni.saveNewStudent(newStudent);

		}
	}
	private class BackAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public BackAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Press to go back to main menu");
		}
		public void actionPerformed(ActionEvent e) {
			
			MainGUI.addToMain();
			
		}
	}
}
