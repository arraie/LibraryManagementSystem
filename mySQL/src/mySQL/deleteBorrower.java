
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

public class deleteBorrower {

	private JFrame frmDeleteBorrower;
	private JTextField borrowerID;

	/**
	 * Launch the application.
	 */
	public static void deleteBorrowerMeth() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteBorrower window = new deleteBorrower();
					window.frmDeleteBorrower.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deleteBorrower() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteBorrower = new JFrame();
		frmDeleteBorrower.getContentPane().setBackground(new Color(240, 248, 255));
		frmDeleteBorrower.setTitle("Delete Borrower");
		frmDeleteBorrower.setBounds(100, 100, 450, 300);
		frmDeleteBorrower.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmDeleteBorrower.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the borrower ID");
		lblNewLabel.setBounds(6, 18, 142, 16);
		frmDeleteBorrower.getContentPane().add(lblNewLabel);
		
		borrowerID = new JTextField();
		borrowerID.setBounds(6, 46, 142, 26);
		frmDeleteBorrower.getContentPane().add(borrowerID);
		borrowerID.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection myConn1=DriverManager.getConnection(  
		        "jdbc:mysql://localhost:3306/LIBRARY","root","");
		        
				Statement myStmt6 = myConn1.createStatement();
				String sql2 = "delete from BORROWER where borrowerID = " + "'"+borrowerID.getText()+"'";
				int rowsAffected = myStmt6.executeUpdate(sql2);
		        
				myConn1.close();
				String sql="";
				if(rowsAffected>0)
					JOptionPane.showMessageDialog (btnNewButton, "Updated successfully");
					else
						JOptionPane.showMessageDialog (btnNewButton, "was not deleted",sql, JOptionPane.ERROR_MESSAGE);
	
				
				}catch(Exception E) {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		btnNewButton.setBounds(154, 46, 117, 29);
		frmDeleteBorrower.getContentPane().add(btnNewButton);
	}

}
