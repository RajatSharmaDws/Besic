/*Code By Rajat Sharma
*/
package advance.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class MarkSheetModel {
	
	//Get Connection TO Mysql DataBase
	public static Connection addConnection()  {
		ResourceBundle rb = ResourceBundle.getBundle("advance.rb.app");
		Connection conn = null;
		try {
			Class.forName(rb.getString("driver")).newInstance();
			conn = DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return conn;
	}
	
	//Method For Insert Record In Marksheet Table 
	public void add(MarkSheetBean bean) throws Exception {
		Connection conn = addConnection();
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO Marksheet VALUES(?,?,?,?,?,?,?)");
		ps.setInt(1,idgen());
		ps.setString(2, bean.getRoll_no());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5,bean.getPhy_mrs());
		ps.setInt(6,bean.getChe_mrs());
		ps.setInt(7, bean.getMath_mrs());
		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i+" Insert SuccessFull");
		ps.close();
		conn.close();
	}
	
	//Method For Update Record In Marksheet Table 
	
	public void update(MarkSheetBean bean,String colum) throws Exception{
		Connection conn = addConnection();
		conn.setAutoCommit(false);
		
		PreparedStatement psmh = conn.prepareStatement("UPDATE MarkSheet SET "+colum+"= ? WHERE Roll_no = ?");	
		if(colum == "Fname"){
			psmh.setString(1, bean.getFname());
		}
		
		if(colum == "Lname"){
			psmh.setString(1, bean.getLname());
		}
		
		if(colum == "Phy_mrs"){
			psmh.setInt(1, bean.getPhy_mrs());
		}
		
		if(colum == "Che_mrs"){
			psmh.setInt(1, bean.getChe_mrs());
		}
		
		if(colum == "Math_mrs"){
			psmh.setInt(1, bean.getMath_mrs());
		}
		psmh.setString(2, bean.getRoll_no());
		psmh.executeUpdate();
		System.out.println("Update");
		conn.commit();
		psmh.close();
		conn.close();
	}
	
	//Method For Delete Record In Marksheet Table 
	public MarkSheetBean delete(String roll_no) throws Exception{
		Connection conn = addConnection();		
		conn.setAutoCommit(false);
		MarkSheetModel msm = new MarkSheetModel();
		MarkSheetBean msb = msm.get(roll_no);
		PreparedStatement ps = conn.prepareStatement("DELETE FROM Marksheet WHERE Roll_no = ?");
		ps.setString(1,roll_no);
		
		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i+" Delete SuccessFull");
		
		ps.close();
		conn.close();
		return msb;
		
	}
	
	//Method For Select Record By Marksheet Table Useing Roll No 
	public MarkSheetBean get(String roll_no) throws Exception{
		Connection conn = addConnection();		
		MarkSheetBean mst  = new MarkSheetBean();
		PreparedStatement ps = conn.prepareStatement("Select * from MarkSheet where roll_no = ?");
		ps.setString(1, roll_no);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			mst.setId(rs.getInt(1));
			mst.setRoll_no(rs.getString(2));
			mst.setFname(rs.getString(3));
			mst.setLname(rs.getString(4));
			mst.setPhy_mrs(rs.getInt(5));
			mst.setChe_mrs(rs.getInt(6));
			mst.setMath_mrs(rs.getInt(7));
		}
		rs.close();
		ps.close();
		conn.close();
		return mst;
	}
	
	//Method For Get MeritList By Marksheet
	public ArrayList<MarkSheetBean> getMeritList() throws Exception {
		Connection conn = addConnection();		
		MarkSheetBean mst = new MarkSheetBean();
		ArrayList<MarkSheetBean> al = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(
				"Select * from MarkSheet where "
				+"phy_mrs>33 and "
				+"che_mrs>33 and "
				+"math_mrs>33 "
				+"order by(phy_mrs+che_mrs+math_mrs)/3 desc "
				+"limit 0,10");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			mst = new MarkSheetBean();
			mst.setId(rs.getInt(1));
			mst.setRoll_no(rs.getString(2));
			mst.setFname(rs.getString(3));
			mst.setLname(rs.getString(4));
			mst.setPhy_mrs(rs.getInt(5));
			mst.setChe_mrs(rs.getInt(6));
			mst.setMath_mrs(rs.getInt(7));
			al.add(mst);
		}
		rs.close();
		ps.close();
		conn.close();
		return al;
	}
	
	//Method For Get All Record By Marksheet Table
	public void search(MarkSheetBean mst) throws Exception{
		Connection conn = addConnection();		
		ArrayList<MarkSheetBean> al = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement("Select * from MarkSheet");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			mst = new MarkSheetBean();
			mst.setId(rs.getInt(1));
			mst.setRoll_no(rs.getString(2));
			mst.setFname(rs.getString(3));
			mst.setLname(rs.getString(4));
			mst.setPhy_mrs(rs.getInt(5));
			mst.setChe_mrs(rs.getInt(6));
			mst.setMath_mrs(rs.getInt(7));
			al.add(mst);
		}
		Iterator<MarkSheetBean> e = al.iterator();
		while(e.hasNext()){
			System.out.println(e.next());
			System.out.println("");
		}
		rs.close();
		ps.close();
		conn.close();
	}
	//Generate Id For Insert 
	public static int idgen() throws Exception{
		Connection conn = addConnection();		
		PreparedStatement ps = conn.prepareStatement("Select id+1 from MarkSheet Where id = (Select count(*) from Marksheet)");
		ResultSet rs = ps.executeQuery();
		rs.next();
		int genId = rs.getInt(1); 
		rs.close();
		ps.close();
		conn.close();
		return genId;
	}
}
