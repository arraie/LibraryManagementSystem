
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

public class insertBook {

	private JFrame frmInsertBook;
	private JTextField isbn;
	private JTextField title;
	private JTextField ppdate;
	private JTextField noCop;
	private JTextField authorId;
	private JTextField category;

	/**
	 * Launch the application.
	 */
	public static void insertbook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertBook window = new insertBook();
					window.frmInsertBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public insertBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertBook = new JFrame();
		frmInsertBook.getContentPane().setBackground(new Color(240, 248, 255));
		frmInsertBook.setTitle("Insert book");
		frmInsertBook.setBounds(100, 100, 450, 338);
		frmInsertBook.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInsertBook.getContentPane().setLayout(null);
		
		JLabel lblEnterIsbn = new JLabel("Enter ISBN");
		lblEnterIsbn.setBounds(18, 19, 83, 16);
		frmInsertBook.getContentPane().add(lblEnterIsbn);
		
		JLabel lblEnterTitle = new JLabel("Enter publish date");
		lblEnterTitle.setBounds(18, 76, 134, 16);
		frmInsertBook.getContentPane().add(lblEnterTitle);
		
		JLabel label = new JLabel("Enter Title");
		label.setBounds(18, 48, 111, 16);
		frmInsertBook.getContentPane().add(label);
		
		JLabel lblEnterNumberOf = new JLabel("Enter number of copies");
		lblEnterNumberOf.setBounds(18, 109, 156, 16);
		frmInsertBook.getContentPane().add(lblEnterNumberOf);
		
		JLabel lblEnterAuthorId = new JLabel("Enter author ID");
		lblEnterAuthorId.setBounds(18, 170, 156, 16);
		frmInsertBook.getContentPane().add(lblEnterAuthorId);
		
		isbn = new JTextField();
		isbn.setBounds(181, 14, 196, 26);
		frmInsertBook.getContentPane().add(isbn);
		isbn.setColumns(10);
		
		title = new JTextField();
		title.setColumns(10);
		title.setBounds(181, 43, 196, 26);
		frmInsertBook.getContentPane().add(title);
		
		ppdate = new JTextField();
		ppdate.setColumns(10);
		ppdate.setBounds(181, 71, 196, 26);
		frmInsertBook.getContentPane().add(ppdate);
		
		noCop = new JTextField();
		noCop.setColumns(10);
		noCop.setBounds(181, 104, 196, 26);
		frmInsertBook.getContentPane().add(noCop);
		
		authorId = new JTextField();
		authorId.setColumns(10);
		authorId.setBounds(181, 165, 196, 26);
		frmInsertBook.getContentPane().add(authorId);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Class.forName("com.mysql.jdbc.Driver");  
			        Connection myConn1=DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/LIBRARY","root","");

					// insert a book (employee)
					Statement myStmt1 = myConn1.createStatement();
					ResultSet myRs1 = myStmt1.executeQuery("select * from BOOK");
					Statement stmt1 = myConn1.createStatement();
				    String SQLinsretB = "insert into BOOK " + "( ISBN,Title,PublishDate,NumberOfCopies )"
					+ "values ( '"+isbn.getText()+"',\""+title.getText()+"\",'"+ppdate.getText()+"',"+noCop.getText()+")";
					stmt1.executeUpdate(SQLinsretB);
					
					System.out.println("after book ins");

					/*Statement myStmt2 = myConn1.createStatement();
					ResultSet myRs2 = myStmt2.executeQuery("select * from AUTHOR");
					Statement stmt2 = myConn1.createStatement();
				    String SQLinsretAuth = "insert into AUTHOR " + "( AuthorID,Fname,Lname )"
					+ "values ( '"+authorId.getText()+"','"+fname.getText()+"','"+lname.getText()+"')";
					stmt2.executeUpdate(SQLinsretAuth);*/
					
					Statement myStmt3 = myConn1.createStatement();
					ResultSet myRs3 = myStmt3.executeQuery("select * from WRITEE");
					Statement stmt3 = myConn1.createStatement();
				    String SQLinsretwtitee = "insert into WRITEE " + "( AuthorID,BookISBN )"
					+ "values ( '"+authorId.getText()+"','"+isbn.getText()+"')";
					stmt3.executeUpdate(SQLinsretwtitee);
					
					Statement myStmt4 = myConn1.createStatement();
					ResultSet myRs4 = myStmt4.executeQuery("select * from BOOK_CATEGORY ");
					Statement stmt4 = myConn1.createStatement();
					String SQInsertCat = "insert into BOOK_CATEGORY  " + "( BISBN  ,Category )"+ "values ( '"+isbn.getText()+"','"+category.getText()+"')";
					stmt4.executeUpdate(SQInsertCat);

					JOptionPane.showMessageDialog (btnInsert, "Inserted successfully");					
					myConn1.close();
	
				}
				catch(Exception E) {
					JOptionPane.showMessageDialog(btnInsert, "Invalid, kindly try again" , null, JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
			}
		});
		btnInsert.setBounds(216, 233, 117, 29);
		frmInsertBook.getContentPane().add(btnInsert);
		
		JLabel lblNewLabel = new JLabel("Enter category");
		lblNewLabel.setBounds(18, 137, 123, 16);
		frmInsertBook.getContentPane().add(lblNewLabel);
		
		category = new JTextField();
		category.setColumns(10);
		category.setBounds(181, 132, 196, 26);
		frmInsertBook.getContentPane().add(category);
	}
}
