/*Code Rajat Sharma
*/
package advance.jdbc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestMarkSheetModel {
	
	public static void main(String[] args) throws Exception {
		//Use Scanner For User Input And Call Methods
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter A Number");
		System.out.println("1 For Insert");
		System.out.println("2 For Update");
		System.out.println("3 For Delete");
		System.out.println("4 For Select By Roll no");
		System.out.println("5 For Merit List");
		System.out.println("6 For Show All Record");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			//Call TestAdd Method
			testadd();
			break;
		
		case 2:
			//Call TestUpdate Method
			testupdate();
			break;
				
		case 3:
			//Call TestDelete Method
			testdelete();
			break;

		case 4:
			//Call TestGet Method
			testget();
			break;
			
		case 5:
			//Call TestGetMeritList Method
			testgetMeritList();
			break;

		case 6:
			//Call TestSearch Method
			testsearch();
			break;

			
		default:
			break;
		}
		sc.close();
	}


	private static void testadd() throws Exception {
		MarkSheetBean bean = new MarkSheetBean();
		Scanner sc = new Scanner(System.in);
		
		/*System.out.println("Enter Id");
		bean.setId(sc.nextInt());*/
		
		System.out.println("Enter Roll No");
		bean.setRoll_no(sc.next());
		
		System.out.println("Enter First Name");
		bean.setFname(sc.next());
		
		System.out.println("Enter Last Name");
		bean.setLname(sc.next());
		
		System.out.println("Enter Physics Marks");
		bean.setPhy_mrs(sc.nextInt());
		
		System.out.println("Enter Chemestry Marks");
		bean.setChe_mrs(sc.nextInt());
		
		System.out.println("Enter Maths Marks");
		bean.setMath_mrs(sc.nextInt());
		
		MarkSheetModel mstadd = new MarkSheetModel();
		mstadd.add(bean);
		sc.close();
	}
	
	private static void testupdate() throws Exception {
		MarkSheetBean bean = new MarkSheetBean();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter What You Want To Update");
		System.out.println("1 For First Name");
		System.out.println("2 For Last Name");
		System.out.println("3 For Physicse Marks");
		System.out.println("4 For Physicse Marks");
		System.out.println("5 For Physicse Marks");
		int ch = sc.nextInt();
		String colum = null;
		switch (ch) {
		case 1:
			System.out.println("Enter Roll No");
			bean.setRoll_no(sc.next());
			
			System.out.println("Enter First Name");
			bean.setFname(sc.next());
			colum = "Fname";
			break;
		case 2:
			System.out.println("Enter Roll No");
			bean.setRoll_no(sc.next());
			
			System.out.println("Enter Last Name");
			bean.setLname(sc.next());
			colum = "Lname";
			break;
		case 3:
			System.out.println("Enter Roll No");
			bean.setRoll_no(sc.next());
			
			System.out.println("Enter Physics Marks");
			bean.setPhy_mrs(sc.nextInt());
			colum = "Phy_mrs";
			break;
		case 4:
			System.out.println("Enter Roll No");
			bean.setRoll_no(sc.next());
			
			System.out.println("Enter Chemesrty Marks");
			bean.setChe_mrs(sc.nextInt());
			colum = "Che_mrs";
			break;
		case 5:
			System.out.println("Enter Roll No");
			bean.setRoll_no(sc.next());
			
			System.out.println("Enter Maths Marks");
			bean.setMath_mrs(sc.nextInt());
			colum = "Math_mrs";
			break;
		default:
			break;
	}
		MarkSheetModel mst = new MarkSheetModel();
		mst.update(bean,colum);
		sc.close();
	}
	
	private static void testdelete() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roll No");
		String roll_no = sc.next();
		MarkSheetModel mst = new MarkSheetModel();
		System.out.println(mst.delete(roll_no));
		sc.close();
 	}
	
	private static void testget() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roll No");
		String roll_no = sc.next();
		MarkSheetModel mst = new MarkSheetModel();
		System.out.println(mst.get(roll_no));
		sc.close();
 	}
	
	private static void testgetMeritList() throws Exception {
		MarkSheetModel mst = new MarkSheetModel();
		ArrayList<MarkSheetBean> al = mst.getMeritList();
		Iterator<MarkSheetBean> e= al.iterator();
		
		int k=1;
		int l=0;
		while(e.hasNext()){
			System.out.println("Rank "+k);
			int i = al.get(l).getPhy_mrs()+ al.get(l).getChe_mrs()+ al.get(l).getMath_mrs();
			System.out.println(e.next());
			System.out.println("Totel Marks = "+i);
			System.out.println("Parsenteg = "+i/3);
			System.out.println("");
			l++;
			k++;
		}
		//System.out.println(mst.idgen());
 	}
	
	private static void testsearch() throws Exception {
		MarkSheetBean ms = new MarkSheetBean();
		MarkSheetModel mst = new MarkSheetModel();
		mst.search(ms);
	}
}
