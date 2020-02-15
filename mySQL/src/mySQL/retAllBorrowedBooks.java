
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class retAllBorrowedBooks {

	private JFrame frmRetrieveAllBorrowed;
	private JTextField borrowerID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void retAllBorrowedBooksMeth() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retAllBorrowedBooks window = new retAllBorrowedBooks();
					window.frmRetrieveAllBorrowed.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public retAllBorrowedBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRetrieveAllBorrowed = new JFrame();
		frmRetrieveAllBorrowed.setTitle("Retrieve all borrowed books");
		frmRetrieveAllBorrowed.setResizable(false);
		frmRetrieveAllBorrowed.setBounds(100, 100, 679, 357);
		frmRetrieveAllBorrowed.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		frmRetrieveAllBorrowed.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterYourId = new JLabel("Enter your ID");
		panel.add(lblEnterYourId);
		
		borrowerID = new JTextField();
		panel.add(borrowerID);
		borrowerID.setColumns(10);
		
		JButton btnNewButton = new JButton("Retrieve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn1=DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/LIBRARY","root","");
					
					String borrowerId = "'" + borrowerID.getText() +"'";
					String join = "select * from BORROW where borrowerID=" + borrowerId;

					PreparedStatement ps = myConn1.prepareStatement(join);

					ResultSet rs = ps.executeQuery();

					System.out.println("BookISBN\tborrowerID");

					int counter=0;
					while (rs.next()) {
						String BookISBN = rs.getString("BookISBN");
						String borrowerId2 = rs.getString("borrowerID");
						System.out.println(BookISBN + "\t" + borrowerId2);
						counter++;}

					retAllBorrowedBooksTable model = new retAllBorrowedBooksTable(counter,borrowerId);
					table.setModel(model);
					
					myConn1.close();
					
					}catch(Exception E) {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
	}
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		frmRetrieveAllBorrowed.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
