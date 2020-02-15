
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

public class insertBorrower {

	private JFrame frmInsertBorrower;
	private JTextField borID;
	private JTextField borName;
	private JTextField phoneNum;
	private JTextField BookIsbn;
	private JTextField dateOfBor;
	private JTextField dateOfExp;

	/**
	 * Launch the application.
	 */
	public static void insertBorrowerMethod() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertBorrower window = new insertBorrower();
					window.frmInsertBorrower.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public insertBorrower() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertBorrower = new JFrame();
		frmInsertBorrower.getContentPane().setBackground(new Color(240, 248, 255));
		frmInsertBorrower.setTitle("Insert borrower");
		frmInsertBorrower.setBounds(100, 100, 450, 300);
		frmInsertBorrower.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInsertBorrower.getContentPane().setLayout(null);
		
		JLabel lblBorrowerId = new JLabel("Borrower ID");
		lblBorrowerId.setBounds(6, 16, 88, 16);
		frmInsertBorrower.getContentPane().add(lblBorrowerId);
		
		JLabel lblBorrowerName = new JLabel("Borrower Name");
		lblBorrowerName.setBounds(6, 44, 107, 16);
		frmInsertBorrower.getContentPane().add(lblBorrowerName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(6, 73, 114, 16);
		frmInsertBorrower.getContentPane().add(lblPhoneNumber);
		
		JLabel lblBookIsbn = new JLabel("Book ISBN");
		lblBookIsbn.setBounds(6, 114, 114, 16);
		frmInsertBorrower.getContentPane().add(lblBookIsbn);
		
		JLabel lblDateOfBorrowing = new JLabel("Date of borrowing");
		lblDateOfBorrowing.setBounds(6, 142, 123, 16);
		frmInsertBorrower.getContentPane().add(lblDateOfBorrowing);
		
		JLabel lblDateOfExpiration = new JLabel("Date of expiration");
		lblDateOfExpiration.setBounds(6, 170, 123, 16);
		frmInsertBorrower.getContentPane().add(lblDateOfExpiration);
		
		borID = new JTextField();
		borID.setBounds(133, 11, 175, 26);
		frmInsertBorrower.getContentPane().add(borID);
		borID.setColumns(10);
		
		borName = new JTextField();
		borName.setColumns(10);
		borName.setBounds(133, 39, 175, 26);
		frmInsertBorrower.getContentPane().add(borName);
		
		phoneNum = new JTextField();
		phoneNum.setColumns(10);
		phoneNum.setBounds(133, 68, 175, 26);
		frmInsertBorrower.getContentPane().add(phoneNum);
		
		BookIsbn = new JTextField();
		BookIsbn.setColumns(10);
		BookIsbn.setBounds(133, 109, 175, 26);
		frmInsertBorrower.getContentPane().add(BookIsbn);
		
		dateOfBor = new JTextField();
		dateOfBor.setColumns(10);
		dateOfBor.setBounds(133, 137, 175, 26);
		frmInsertBorrower.getContentPane().add(dateOfBor);
		
		dateOfExp = new JTextField();
		dateOfExp.setColumns(10);
		dateOfExp.setBounds(133, 165, 175, 26);
		frmInsertBorrower.getContentPane().add(dateOfExp);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				
		        Connection myConn1=DriverManager.getConnection(  
		        "jdbc:mysql://localhost:3306/LIBRARY","root","");
				
				Statement myStmt4 = myConn1.createStatement();
				ResultSet myRs4 = myStmt4.executeQuery("select * from BORROWER");
				Statement stmt4 = myConn1.createStatement();
				String SQLinsretBorrower = "insert into BORROWER " + "( borrowerID,Name,PhoneNo )"+ "values ( '"+borID.getText()+"','"+borName.getText()+"','"+phoneNum.getText()+"')";
				stmt4.executeUpdate(SQLinsretBorrower);
				
				Statement myStmt5 = myConn1.createStatement();
				ResultSet myRs5 = myStmt5.executeQuery("select * from BORROW");
				Statement stmt5 = myConn1.createStatement();
				String SQLinsretBorrow = "insert into BORROW " + "( BookISBN,borrowerID,DateOfBorrowing,DateOfExpiration )"+ "values (  '"+BookIsbn.getText()+"' , '"+borID.getText()+"','"+dateOfBor.getText()+"','"+dateOfExp.getText()+"')";
				stmt5.executeUpdate(SQLinsretBorrow);
				
				JOptionPane.showMessageDialog (btnNewButton, "Inserted successfully");
				myConn1.close();
		        }catch(Exception E) {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton.setBounds(162, 203, 117, 29);
		frmInsertBorrower.getContentPane().add(btnNewButton);
	}
}
