package XWJ;

public class Patient_info {
		private String Name;
		private boolean  Sex;
		private int Years;
		private String Tel;
		
		public Patient_info(String Name,boolean  Sex,int Years,String  Tel)
		
		{   
			this.Name=Name;
			this.setSex(Sex);
			this.setYears(Years);
			this.setTel(Tel);
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public boolean isSex() {
			return Sex;
		}
		public void setSex(boolean sex) {
			Sex = sex;
		}
		public int getYears() {
			return Years;
		}
		public void setYears(int years) {
			Years = years;
		}
		public String getTel() {
			return Tel;
		}
		public void setTel(String tel) {
			Tel = tel;
		}
	}


