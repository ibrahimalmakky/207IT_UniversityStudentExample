package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import University.University;

public class MainGUI {

	private static JFrame frame;
	private University uni;
	
//	Panels
	private static MainMenuPanel mainMenuPanel; 
	private static AddNewStudentPanel addNewStudentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(University uni) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(uni);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI(University uni) {
		initialize();
		this.uni = uni;
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    mainMenuPanel = new MainMenuPanel(uni);
	    addNewStudentPanel = new AddNewStudentPanel(uni);
	    
	    frame.setContentPane(mainMenuPanel);
		frame.setVisible(true);
	}
	
	public static void mainToAddNewCustomer(){
		mainMenuPanel.setVisible(false);
		frame.setContentPane(addNewStudentPanel);
		addNewStudentPanel.setVisible(true);
	}
	
	public static void addToMain(){
		addNewStudentPanel.setVisible(false);
		frame.setContentPane(mainMenuPanel);
		mainMenuPanel.setVisible(true);
	}

}
