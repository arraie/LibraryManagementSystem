
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class retBooksForSpecAuthByNameTable extends AbstractTableModel {
private String authFname;
private String authLname;

	private int RowCount;
	
	private static final int BOOKISBN_COL = 0;
	private static final int BORROWERID_COL = 1;

	private static final String[] columnNames = { "Title" };

	public retBooksForSpecAuthByNameTable(int counter,String authFname,String authLname) {
		this.authFname = authFname;
		this.authLname = authLname;
		RowCount = counter;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return RowCount;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn=DriverManager.getConnection(  
	        "jdbc:mysql://localhost:3306/LIBRARY","root","");
			
		String join = "select BOOK.Title from BOOK , AUTHOR , WRITEE where AUTHOR.Fname=" + authFname + " AND AUTHOR.Lname=" + authLname + " AND WRITEE.AuthorID=Author.AuthorID AND WRITEE.BookISBN=BOOK.ISBN";
		PreparedStatement ps = myConn.prepareStatement(join);
		ResultSet rs = ps.executeQuery();
for(int i = 0; i<=row &&rs.next() ; i++) {
if(i==row) {
		//switch (col) {
	//	case 0:
	//		return rs.getString("Title");
		//default:
			return rs.getString("Title");
		//}
}

}
}
		catch(Exception E) {
System.out.println("ERROR");
		}
	return new String();}	

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
