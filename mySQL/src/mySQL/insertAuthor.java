
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class insertAuthor {

	private JFrame frmInsertAuthor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void insertAuthorMeth() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertAuthor window = new insertAuthor();
					window.frmInsertAuthor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public insertAuthor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertAuthor = new JFrame();
		frmInsertAuthor.getContentPane().setBackground(new Color(240, 248, 255));
		frmInsertAuthor.setResizable(false);
		frmInsertAuthor.setTitle("Insert Author");
		frmInsertAuthor.setBounds(100, 100, 450, 206);
		frmInsertAuthor.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInsertAuthor.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Enter author ID");
		label.setBounds(6, 32, 156, 16);
		frmInsertAuthor.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Enter author first name");
		label_1.setBounds(6, 60, 156, 16);
		frmInsertAuthor.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Enter author last name");
		label_2.setBounds(6, 90, 156, 16);
		frmInsertAuthor.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(169, 27, 196, 26);
		frmInsertAuthor.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 55, 196, 26);
		frmInsertAuthor.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 85, 196, 26);
		frmInsertAuthor.getContentPane().add(textField_2);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn1=DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/LIBRARY","root","");
					
				Statement myStmt2 = myConn1.createStatement();
				ResultSet myRs2 = myStmt2.executeQuery("select * from AUTHOR");
				Statement stmt2 = myConn1.createStatement();
			    String SQLinsretAuth = "insert into AUTHOR " + "( AuthorID,Fname,Lname )"
				+ "values ( '"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"')";
				stmt2.executeUpdate(SQLinsretAuth);
				
				JOptionPane.showMessageDialog (btnInsert, "Inserted successfully");					
				myConn1.close();
				
				
				}
				catch(Exception E) {
					JOptionPane.showMessageDialog(btnInsert, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInsert.setBounds(207, 123, 117, 29);
		frmInsertAuthor.getContentPane().add(btnInsert);
	}

}
