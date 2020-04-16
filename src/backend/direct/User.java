package backend.direct;

public class User implements backend.interfaces.User {
	    String login;
	    String password;
	    Departments departmentCode;
	    
		public User(String login, String password, int departmentCode) {
			super();
			this.login = login;
			this.password = password;
			this.departmentCode = Departments.valueOf(departmentCode);
		}
		
                @Override
		public String getLogin() {
			return login;
		}
                
		public void setLogin(String login) {
			this.login = login;
		}
                
                @Override
		public String getPassword() {
			return password;
		}
                
		public void setPassword(String password) {
			this.password = password;
		}
                
                @Override
		public Departments getDepartmentCode() {
			return departmentCode;
		}
                
		public void setDepartmentCode(int departmentCode) {
			this.departmentCode = Departments.valueOf(departmentCode);
		}
	    
	    
}
