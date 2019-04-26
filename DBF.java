import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class DBF {
	Frame f;
	ResultSet Rs;
	Button b1;
	TextField T1,T2, T3, T4, T5;
	Label L1,L2,L3,L4,L5;
	
	public DBF() {
		T1=new TextField(10);
		T2=new TextField(10);
		T3=new TextField(10);
		T4=new TextField(10);
		T5=new TextField(10);
		b1=new Button("Next");
		L1=new Label("Regno");
		L2=new Label("Name");
		L3=new Label("marks");
		L4=new Label("Percentage");
		L5=new Label("Results");
		f=new Frame();
		f.setLayout(new GridLayout(6,2));
		f.add(L1);
		f.add(T1);
		f.add(L2);
		f.add(T2);
		f.add(L3);
		f.add(T3);
		f.add(L4);
		f.add(T4);
		f.add(L5);
		f.add(T5);
		f.add(new Label());
		f.add(b1);
		f.setSize(400,400);
		f.setVisible(true);
		
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/QA","root","");
			Statement st = con.createStatement();
			Rs = st.executeQuery("select * from school");
			
			if(Rs.next()) {
				showRecords();
			}
		}
		catch (Exception E) {
			System.out.println(E.toString());
		}
		
	
	b1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent x) {
					
					try {
					if(Rs.next()) {
						showRecords();
					}
					}
					catch(Exception E) {
						System.out.println(E.toString());
					}
			}
			});
}
	public void showRecords() {
		int RegNo=0, marks=0;
		float Per=0;
		String name="", Results="";
		try {
			RegNo= Rs.getInt(1);
			marks= Rs.getInt(3);
			name=Rs.getString(2);
			
			Per=(float) marks*150/100;
			if (Per>=60) {
				Results="pass";
			}
			else {
				Results="fail";
				
			}
		}
		catch (Exception E) {
			System.out.println(E.toString());
		}
		T1.setText(Integer.toString(RegNo));
		T2.setText(name);
		T3.setText(Integer.toString(marks));
		T4.setText(Float.toString(Per));
		T5.setText(Results);
	}
	

}

