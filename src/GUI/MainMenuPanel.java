package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import University.University;

public class MainMenuPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Action addStudentAction = new AddStudentAction();
	private University uni;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel(University uni) {
		
		this.uni = uni;
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblCoventryUniversity = new JLabel("Coventry University");
		lblCoventryUniversity.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblCoventryUniversity, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCoventryUniversity, 180, SpringLayout.WEST, this);
		add(lblCoventryUniversity);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setAction(addStudentAction);
		springLayout.putConstraint(SpringLayout.NORTH, btnAddStudent, 33, SpringLayout.SOUTH, lblCoventryUniversity);
		springLayout.putConstraint(SpringLayout.WEST, btnAddStudent, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnAddStudent, -37, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblCoventryUniversity, 0, SpringLayout.EAST, btnAddStudent);
		add(btnAddStudent);
		
		JButton btnEditStudent = new JButton("Edit Student");
		springLayout.putConstraint(SpringLayout.NORTH, btnEditStudent, 49, SpringLayout.NORTH, btnAddStudent);
		springLayout.putConstraint(SpringLayout.SOUTH, btnAddStudent, -25, SpringLayout.NORTH, btnEditStudent);
		springLayout.putConstraint(SpringLayout.WEST, btnEditStudent, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnEditStudent, 128, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnEditStudent, -37, SpringLayout.EAST, this);
		add(btnEditStudent);
		
		JButton btnViewStudent = new JButton("View Student");
		springLayout.putConstraint(SpringLayout.NORTH, btnViewStudent, 19, SpringLayout.SOUTH, btnEditStudent);
		springLayout.putConstraint(SpringLayout.WEST, btnViewStudent, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnViewStudent, -37, SpringLayout.EAST, this);
		add(btnViewStudent);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		springLayout.putConstraint(SpringLayout.NORTH, btnDeleteStudent, 30, SpringLayout.SOUTH, btnViewStudent);
		springLayout.putConstraint(SpringLayout.WEST, btnDeleteStudent, 180, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnDeleteStudent, -37, SpringLayout.EAST, this);
		add(btnDeleteStudent);

	}
	
	private class AddStudentAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public AddStudentAction() {
			putValue(NAME, "Add Student");
			putValue(SHORT_DESCRIPTION, "Pess to add student");
		}
		public void actionPerformed(ActionEvent e) {
			MainGUI.mainToAddNewCustomer();
		}
	}
}
