
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class RetBookTable extends AbstractTableModel {
private String AuthorID;
	private int RowCount;
	
	private static final int TITLE_COL = 0;
	private static final int AUTHOR_ID_COL = 1;

	private static final String[] columnNames = { "Title", "Author ID" };

	public RetBookTable(int counter,String AuthorID) {
		this.AuthorID = AuthorID;
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
		Connection 	myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY","root","");
		String join = "select Title,AuthorID  from WRITEE , BOOK WHERE WRITEE.BookISBN = BOOK.ISBN AND AuthorID = " + AuthorID;
		PreparedStatement ps = myConn.prepareStatement(join);
		ResultSet rs = ps.executeQuery();
for(int i = 0; i<=row &&rs.next() ; i++) {
if(i==row) {
		switch (col) {
		case 0:
			return rs.getString("Title");
		default:
			return rs.getString("AuthorID");
		}
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

