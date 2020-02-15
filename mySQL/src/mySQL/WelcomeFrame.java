
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class WelcomeFrame {

	private JFrame frmLibraryDatabase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame window = new WelcomeFrame();
					window.frmLibraryDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibraryDatabase = new JFrame();
		frmLibraryDatabase.getContentPane().setBackground(new Color(240, 248, 255));
		frmLibraryDatabase.setResizable(false);
		frmLibraryDatabase.setTitle("Library Database System");
		frmLibraryDatabase.setBounds(100, 100, 392, 169);
		frmLibraryDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLibraryDatabase.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToOur = new JLabel("Welcome to our library database");
		lblWelcomeToOur.setFont(new Font("AirArabia", Font.BOLD, 15));
		lblWelcomeToOur.setBounds(75, 21, 251, 16);
		frmLibraryDatabase.getContentPane().add(lblWelcomeToOur);
		
		JLabel lblEnterAs = new JLabel("Enter as:");
		lblEnterAs.setFont(new Font("AirArabia", Font.PLAIN, 15));
		lblEnterAs.setBounds(158, 38, 80, 16);
		frmLibraryDatabase.getContentPane().add(lblEnterAs);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLibraryDatabase.hide();
				EmployeeView EmployeeViewFrame = new EmployeeView();
				EmployeeViewFrame.NewEmpScreen();
			}
		});
		btnEmployee.setBounds(75, 66, 117, 29);
		frmLibraryDatabase.getContentPane().add(btnEmployee);
		
		JButton btnBorrower = new JButton("Borrower");
		btnBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLibraryDatabase.hide();
				BorrowerView borrowerViewFrame = new BorrowerView();
				borrowerViewFrame.NewBorrScreen();
				
			}
		});
		btnBorrower.setBounds(196, 66, 117, 29);
		frmLibraryDatabase.getContentPane().add(btnBorrower);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/emp.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(17, 43, 56, 70);
		frmLibraryDatabase.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/cus.png")).getImage();
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(316, 49, 56, 64);
		frmLibraryDatabase.getContentPane().add(label_1);
	}
}

