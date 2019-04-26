import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class Front {
	public static void main(String az[]){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/QA","root","");
			Statement st = con.createStatement();
				st.executeUpdate("insert into school values(23,'Ali',99)");
				
		}
		catch (Exception E) {
			System.out.println(E.toString());
		}
	}

}

class AddToDatabase implements ActionListener{
	TextField screen;
	Panel p1,p2;
	Button breg, bname, bmark, bsave;
	
	public AddToDatabase() {
		Frame f = new Frame("Records");
		p1 = new Panel();
		p2 = new Panel();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}