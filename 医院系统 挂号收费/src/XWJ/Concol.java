package XWJ;
import java.util.*;
public class Concol {
		
		//private String Name;
		//private boolean  Sex;
		//private int Years;
		//private String Tel;
		//Patient_info [] list1=new  Patient_info[50];
		//Appointment[] list2=new  Appointment[50];
		//Case[] list3=new  Case[50];
		//Office[] list4=new  Office[50];
		
	    private boolean F;
	    private boolean T;
	    static ArrayList<Case> list1 = new ArrayList<Case>();
        public static void add_list1(Case case1){
        	list1.add(case1);
        }
        
	    static ArrayList<Appointment> list2= new ArrayList<Appointment>();
        public static void add_list2(Appointment appointment){
        	list2.add(appointment);
        }
        
        static ArrayList<Office> list3 = new ArrayList<Office>();
        public static void add_list3(Office office){
        	list3.add(office);
        }
        
        static ArrayList<Patient_info> list4 = new ArrayList<Patient_info>();
        public static void add_list4(Patient_info patient_info){
        	list4.add(patient_info);
        }
        
		public  void  produce() //预约
		  {  
		 	 //list1[0]=new Patient_info("李四",F,1996,"187") ;
			 //System.out.println(list1[0].getName());
			 //Boolean T;
			
			 Office office=new Office("精神科","李",3);
			 Appointment appointment=new Appointment("11.3",setApp_office(office),true);
			 Patient_info patient_info=new Patient_info("ZHANG",true,12,"123");
			 Case  case1=new Case(setPi(patient_info),setApp(appointment),setCharge());
			 
			 Case.setPi();
		     System.out.println("输入病人选择科室");
		     Scanner S2= new Scanner(System.in);
		     String S3=S2.next();
		     office.setOffice_name(S3);
		     
		     System.out.println("输入病人选择科室医生");
		     Scanner S4= new Scanner(System.in);
		     String S5=S4.next();
		     //ArrayList<String> S5=S4.next();
		     office.setDoctor(S5);
		     office.setCharge(4);
			 //Appointment  appointment=new  Appointment("张三",, T);
			 list3.add(office);	
			 //String first = (String) list11.getFirst();  
		      //  System.out.println("<--list中第一个元素为 ：" + first + "-->");  
			 for ( int i=0 ; i <list3.size(); i++) 
			    {
			 System.out.println(list3.get(i).getOffice_name());}
}

		private Office setApp_office(Office office) {
			// TODO Auto-generated method stub
			return null;
		}
}