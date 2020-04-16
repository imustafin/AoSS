package backend.direct;

public class User {
	    String login;
	    String password;
	    Departments departmentCode;
	    
		public User(String login, String password, int departmentCode) {
			super();
			this.login = login;
			this.password = password;
			this.departmentCode = Departments.valueOf(departmentCode);
		}
		
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Departments getDepartmentCode() {
			return departmentCode;
		}
		public void setDepartmentCode(int departmentCode) {
			this.departmentCode = Departments.valueOf(departmentCode);
		}
	    
	    
}
