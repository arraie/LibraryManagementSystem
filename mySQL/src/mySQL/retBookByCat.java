
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class retBookByCat {

	private JFrame frmRetrieveBookBy;
	private JTextField category;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void retBookByCat() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retBookByCat window = new retBookByCat();
					window.frmRetrieveBookBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public retBookByCat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRetrieveBookBy = new JFrame();
		frmRetrieveBookBy.setResizable(false);
		frmRetrieveBookBy.setTitle("Retrieve book by category");
		frmRetrieveBookBy.setBounds(100, 100, 450, 300);
		frmRetrieveBookBy.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		frmRetrieveBookBy.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Enter book category");
		panel.add(label);
		
		category = new JTextField();
		category.setColumns(10);
		panel.add(category);
		
		JButton btnNewButton = new JButton("Retrieve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn1=DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/LIBRARY","root","");
					
					String Category = "'" + category.getText() +"'";
					String join = "select * from BOOK_CATEGORY , BOOK WHERE BOOK_CATEGORY.BISBN = BOOK.ISBN AND Category = " + Category;

					PreparedStatement ps = myConn1.prepareStatement(join);

					ResultSet rs = ps.executeQuery();

					System.out.println("BookISBN\tCategory");

					int counter=0;
					while (rs.next()) {
						String BookISBN = rs.getString("BISBN");
						String category2 = rs.getString("Category");
						System.out.println(BookISBN + "\t" + category2);
						counter++;}

					retBookByCatTable model = new retBookByCatTable(counter,Category);
					table.setModel(model);
					
					myConn1.close();
					
					}catch(Exception E) {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
	}
				
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		frmRetrieveBookBy.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
