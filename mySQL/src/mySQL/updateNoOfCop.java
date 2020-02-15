
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class updateNoOfCop {

	private JFrame frmUbdateNumberOf;
	private JTextField BookISBN;
	private JTextField noOfCop;

	/**
	 * Launch the application.
	 */
	public static void updateNoOfCopMet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateNoOfCop window = new updateNoOfCop();
					window.frmUbdateNumberOf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateNoOfCop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUbdateNumberOf = new JFrame();
		frmUbdateNumberOf.getContentPane().setBackground(new Color(240, 248, 255));
		frmUbdateNumberOf.setResizable(false);
		frmUbdateNumberOf.setTitle("Update Number of copies");
		frmUbdateNumberOf.setBounds(100, 100, 450, 177);
		frmUbdateNumberOf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmUbdateNumberOf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Book ISBN");
		lblNewLabel.setBounds(6, 16, 131, 16);
		frmUbdateNumberOf.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterTheNew = new JLabel("Enter the new number of copies");
		lblEnterTheNew.setBounds(6, 44, 199, 16);
		frmUbdateNumberOf.getContentPane().add(lblEnterTheNew);
		
		BookISBN = new JTextField();
		BookISBN.setBounds(213, 11, 152, 26);
		frmUbdateNumberOf.getContentPane().add(BookISBN);
		BookISBN.setColumns(10);
		
		noOfCop = new JTextField();
		noOfCop.setColumns(10);
		noOfCop.setBounds(213, 39, 152, 26);
		frmUbdateNumberOf.getContentPane().add(noOfCop);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn1=DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/LIBRARY","root","");
					
					Statement myStmt3 = myConn1.createStatement();
					String sql = "update BOOK set NumberOfCopies = " + "'"+noOfCop.getText()+"'"+" where ISBN =" + "'"+BookISBN.getText()+"' ";
					int rowsAffected = myStmt3.executeUpdate(sql);
										
					myConn1.close();
					if(rowsAffected>0)
					JOptionPane.showMessageDialog (btnNewButton, "Updated successfully");
					else
						JOptionPane.showMessageDialog (btnNewButton, "was not updated",sql, JOptionPane.ERROR_MESSAGE);
	

					}catch(Exception E) {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(233, 77, 117, 29);
		frmUbdateNumberOf.getContentPane().add(btnNewButton);
	}

}
