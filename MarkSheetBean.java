/*Code Rajat Sharma
*/
package advance.jdbc;

public class MarkSheetBean {
	//Veritable Declare
	
	private int id = 0;
	private String roll_no = null;
	private String fname = null;
	private String lname = null;
	private int phy_mrs = 0;
	private int che_mrs = 0;
	private int math_mrs = 0;
	
	//Default Constructor
	
	public MarkSheetBean() {}

	//Getters And Setters
	
	public int getId() {return id;}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoll_no() {return roll_no;}
	
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}

	public String getFname() {return fname;}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {return lname;}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getPhy_mrs() {return phy_mrs;}

	public void setPhy_mrs(int phy_mrs) {
		this.phy_mrs = phy_mrs;
	}

	public int getChe_mrs() {return che_mrs;}

	public void setChe_mrs(int che_mrs) {
		this.che_mrs = che_mrs;
	}

	public int getMath_mrs() {return math_mrs;}

	public void setMath_mrs(int math_mrs) {
		this.math_mrs = math_mrs;
	}

	//Override To String For Print
	
	@Override
	public String toString() {
		return 	"id=" + id+"\n"
				+"roll_no = " + roll_no+"\n"
				+"fname = "+fname+"\n"
				+"lname = "+lname+"\n"
				+"phy_mrs = "+ phy_mrs + "\n"
				+"che_mrs = " + che_mrs + "\n"
				+"math_mrs = " + math_mrs ;
		}
}