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
			 Charge_info charge_info=new Charge_info(6.0,7.0,8.0,9.0,true);
			 Case  case1=new Case(setPi(patient_info),setApp(appointment),setCharge(charge_info));
			 
			
			 //Appointment  appointment=new  Appointment("张三",, T);
			 list1.add(case1);	
			 //String first = (String) list11.getFirst();  
		      //  System.out.println("<--list中第一个元素为 ：" + first + "-->");  
			 for ( int i=0 ; i <list1.size(); i++) 
			    { 
				 //patient_info.setName("Zhang");
			 //System.out.println(list1.get(i).getPi().getName()); 
			 }
//}
			 System.out.println(list1.size());}

		

		private Object getName() {
			// TODO Auto-generated method stub
			return null;
		}

		private Object setPi(Patient_info patient_info) {
			// TODO Auto-generated method stub
			return null;
		}

		private Object setCharge(Charge_info charge_info) {
			// TODO Auto-generated method stub
			return null;
		}

		private Object setApp(Appointment appointment) {
			// TODO Auto-generated method stub
			return null;
		}

		private Office setApp_office(Office office) {
			// TODO Auto-generated method stub
			return null;
		}
}