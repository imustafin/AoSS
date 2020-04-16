package backend.direct;

public enum Departments {
	ADMIN_DEPT (0), 
	ORDERS_DEPT (1), 
	INVENTORY_DEPT (2), 
	SHIPPING_DEPT (3),
	UNDEFINED_DEPT (-1);
	
	
	private int deptCode;
	
	Departments(int value) {
		this.deptCode = value;
	}
	
	public int getDetpCode() {
		return this.deptCode;
	}
	
	public static Departments valueOf(int value) {
		switch (value) {
		case 0: 
			return ADMIN_DEPT;
		case 1:
			return ORDERS_DEPT;
		case 2:
			return INVENTORY_DEPT;
		case 3:
			return SHIPPING_DEPT;
		}
		return UNDEFINED_DEPT;
	}
}
