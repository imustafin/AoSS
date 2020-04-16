/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.direct;

import backend.interfaces.Backend;
import backend.interfaces.Order;
import backend.interfaces.OrderProduct;
import backend.interfaces.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ilgiz
 */
public class DirectBackend implements Backend {
    String host;
    String user;
    String password;
    
    public DirectBackend(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }
    
    Connection getDbConnection(String database) throws SQLException, ClassNotFoundException {
        Class.forName( "com.mysql.jdbc.Driver" );
        
        String url = "jdbc:mysql://" + host + ":3306/" + database;
        
        return DriverManager.getConnection(url, user, password);
    }
    
    final String[] EEPS_PRODUCT_TYPES = {
        "seeds", "shrubs", "trees"
    };
    
    final String[] LEAFTECH_PRODUCT_TYPES = {
        "cultureboxes", "genomics", "processing", "referencematerials"
    };
    
    final String[][] PRODUCT_TYPE_ARRAYS = {
        EEPS_PRODUCT_TYPES, LEAFTECH_PRODUCT_TYPES 
    };
    
    @Override
    public List<String> getProductTypes() {
        List<String> ans = new ArrayList<>();
        
        for (String[] types : PRODUCT_TYPE_ARRAYS) {
            ans.addAll(Arrays.asList(types));
        }
        
        return ans;
    }
    
    List<Product> parseEepsProducts(String type, ResultSet res) throws SQLException {
        List<Product> ans = new ArrayList<>();
        
        while (res.next()) {
            ans.add(new backend.direct.Product(
                    type,
                    res.getString("product_code"),
                    res.getString("description"),
                    res.getInt("quantity"),
                    res.getFloat("price")
            ));
        }

        return ans;
    }
    
    List<Product> parseLeaftechProducts(String type, ResultSet res) throws SQLException {
        List<Product> ans = new ArrayList<>();

        while (res.next()) {
            ans.add(new backend.direct.Product(
                    type,
                    res.getString("productid"),
                    res.getString("productdescription"),
                    res.getInt("productquantity"),
                    res.getFloat("productprice")
            ));
        }

        return ans;
    }
    
    List<Product> eepsProductsByType(String type) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("inventory");
        
        String sql = "SELECT * FROM " + type;
        
        return parseEepsProducts(type, con.createStatement().executeQuery(sql));
    }
    
    List<Product> leaftechProductsByType(String type) throws SQLException, SQLException, ClassNotFoundException {
        Connection con = getDbConnection("leaftech");
        
        String sql = "SELECT * FROM " + type;
        
        return parseLeaftechProducts(type, con.createStatement().executeQuery(sql));
    }
    
    boolean isEepsType(String type) {
        return Arrays.asList(EEPS_PRODUCT_TYPES).contains(type);
    }
    
    boolean isLeaftechType(String type) {
        return Arrays.asList(LEAFTECH_PRODUCT_TYPES).contains(type);
    }
    
    @Override
    public List<Product> getProductsByType(String type) throws SQLException, ClassNotFoundException {
        if (isEepsType(type)) {
            return eepsProductsByType(type);
        } else {
            if (isLeaftechType(type)) {
                return leaftechProductsByType(type);
            }
        }
        
        return new ArrayList<>();
    }

    @Override
    public List<Order> getOrders(Order order) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("orderinfo");
        
        String sql = "SELECT * FROM orders";
        if (order.isShipped() != null || order.getId() != null) {
            List<String> wheres = new ArrayList<>();
            
            if (order.isShipped() != null) {
                wheres.add("shipped = " + order.isShipped());
            }
            if (order.getId() != null) {
                wheres.add("order_id = " + order.getId());
            }
            
            sql += " WHERE " + String.join(" AND ", wheres);
        }
        
        sql += ";";

        ResultSet res = con.createStatement().executeQuery(sql);
        
        List<Order> ans = new ArrayList<>();
        
        while (res.next()) {
            String orderTable = res.getString("ordertable");
            
            sql = "SELECT * FROM " + orderTable;
               
            ResultSet prodRs = con.createStatement().executeQuery(sql);
            
            List<OrderProduct> products = new ArrayList<>();
            while (prodRs.next()) {
                products.add(new backend.direct.OrderProduct(
                        prodRs.getInt("item_id"),
                        prodRs.getString("product_id"),
                        prodRs.getString("description"),
                        prodRs.getFloat("item_price")
                ));
            }
            
            ans.add(new backend.direct.Order(
                    res.getInt("order_id"),
                    res.getString("first_name"),
                    res.getString("last_name"),
                    res.getString("phone"),
                    res.getString("address"),
                    res.getFloat("total_cost"),
                    res.getBoolean("shipped"),
                    res.getString("order_date"),
                    products));
        }
        
        return ans;
    }
    
    void addLeaftechProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("leaftech");
        
        String sql = "INSERT INTO " + product.getType()
                + "(productid, productdescription, productquantity, productprice)"
                + " VALUES ("
                + "'" + product.getId() + "', "
                + "'" + product.getDescription() + "', "
                + product.getQuantity() + ", "
                + product.getPrice()
                + ");";
        
        con.createStatement().execute(sql);
    }
    
    void addEepsProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("inventory");
        
        String sql = "INSERT INTO " + product.getType()
                + "(product_code, description, quantity, price)"
                + " VALUES ("
                + "'" + product.getId() + "', "
                + "'" + product.getDescription() + "', "
                + product.getQuantity() + ", "
                + product.getPrice()
                + ");";
        
        con.createStatement().execute(sql);
    }
    
    @Override
    public void addProduct(Product product) throws SQLException, ClassNotFoundException {
        if (isEepsType(product.getType())) {
            addEepsProduct(product);
        } else {
            if (isLeaftechType(product.getType())) {
                addLeaftechProduct(product);
            }
        }
    }
    
    Integer deleteEepsProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("inventory");
        
        String sql = "DELETE FROM " + product.getType()
                + " WHERE product_code = '" + product.getId() + "';";
        
        return con.createStatement().executeUpdate(sql);
    }
    
    Integer deleteLeaftechProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("leaftech");
        
        String sql = "DELETE FROM " + product.getType()
                + " WHERE productid = '" + product.getId() + "';";
        
        return con.createStatement().executeUpdate(sql);
    }
    
    @Override
    public Integer deleteProduct(Product product) throws SQLException, ClassNotFoundException {
        if (isEepsType(product.getType())) {
            return deleteEepsProduct(product);
        } else {
            if (isLeaftechType(product.getType())) {
                return deleteLeaftechProduct(product);
            }
        }
        
        return null;
    }

    List<Product> decrementEepsProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("inventory");
        
        String sql = "UPDATE " + product.getType()
                + " SET quantity=(quantity - 1) "
                + "WHERE product_code = '" + product.getId() + "';";
        
        con.createStatement().execute(sql);
        
        sql = "SELECT * FROM " + product.getType()
                + " WHERE product_code='" + product.getId() + "';";
        
        return parseEepsProducts(product.getType(), con.createStatement().executeQuery(sql));
    }
    
    List<Product> decrementLeaftechProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("leaftech");
        
        String sql = "UPDATE " + product.getType()
                + " SET productquantity=(productquantity - 1) "
                + "WHERE productid='" + product.getId() + "';";
        
        con.createStatement().execute(sql);
        
        sql = "SELECT * FROM " + product.getType()
                + " WHERE productid='" + product.getId() + "';";
        
        return parseLeaftechProducts(product.getType(), con.createStatement().executeQuery(sql));
    }
    
    @Override
    public List<Product> decrementProduct(Product product) throws SQLException, ClassNotFoundException {
        if (isEepsType(product.getType())) {
            return decrementEepsProduct(product);
        } else {
            if (isLeaftechType(product.getType())) {
                return decrementLeaftechProduct(product);
            }
        }
        
        return new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) throws Exception {
        Calendar rightNow = Calendar.getInstance();

        int TheHour = rightNow.get(rightNow.HOUR_OF_DAY);
        int TheMinute = rightNow.get(rightNow.MINUTE);
        int TheSecond = rightNow.get(rightNow.SECOND);
        int TheDay = rightNow.get(rightNow.DAY_OF_WEEK);
        int TheMonth = rightNow.get(rightNow.MONTH);
        int TheYear = rightNow.get(rightNow.YEAR);
        
        String dateTimeStamp = TheMonth + "/" + TheDay + "/" + TheYear + " "
                + TheHour + ":" + TheMinute + ":" + TheSecond;
        
        // Create order table
        
        String orderTableName = "order" + String.valueOf(rightNow.getTimeInMillis());

        String sql = "CREATE TABLE " + orderTableName
                + "(item_id int unsigned not null auto_increment primary key, "
                + "product_id varchar(20), description varchar(80), "
                + "item_price float(7,2) );";
        
        Connection con = getDbConnection("orderinfo");
        
        con.createStatement().execute(sql);
        // Add new order
        
        sql = "INSERT INTO orders (order_date, " + "first_name, "
                + "last_name, address, phone, total_cost, shipped, "
                + "ordertable) VALUES ( '" + dateTimeStamp + "', "
                + "'" + order.getFirstName() + "', " + "'" + order.getLastName() + "', "
                + "'" + order.getAddress() + "', " + "'" + order.getPhoneNumber()+ "', "
                + order.getTotalCost() + ", " + false + ", '" + orderTableName + "' );";
        
        con.createStatement().execute(sql);
        
        // Fill new orders table
        
        List<String> values = new ArrayList<>();
        for (OrderProduct p : order.getProducts()) {
            values.add("('" + p.getProductId() + "', " + "'"
              + p.getDescription() + "', " + p.getPrice() + " )");
        }
        
        sql = "INSERT INTO " + orderTableName
              + " (product_id, description, item_price) "
              + "VALUES " + String.join(", ", values) + ";";
        
        con.createStatement().execute(sql);
    }

    @Override
    public void setShipped(Order order) throws SQLException, ClassNotFoundException {
        Connection con = getDbConnection("orderinfo");
        
        String sql = "UPDATE orders SET shipped=" + true + " WHERE order_id=" + order.getId();
        
        con.createStatement().execute(sql);
    }
    
    public User userLogin(String login, String password) throws ClassNotFoundException, SQLException {    	
    	Connection con = getDbConnection("users_db");
    	
    	String sql = "SELECT * FROM users u WHERE u.login = '" + login + "' AND u.password = '" + password + "';";
    	ResultSet res = con.createStatement().executeQuery(sql);
    	User user = null;
    	if (res.next()) {
        	user = new User(res.getString("login"), res.getString("password"), res.getInt("department_code"));
        	logUserLogin(user);
    	}
    			
		return user;
	}
    
    public boolean logUserLogin(User user) {
    	boolean result = false;
    	
		try {
	    	Connection con = getDbConnection("users_db");
	    	
	    	String sql = "INSERT INTO registry "
	                + " (login, time, action) "
	                + "VALUES ('" + user.login + "', '" + Timestamp.valueOf(LocalDateTime.now()) + "', 'IN')" + ";";
	          
	        con.createStatement().execute(sql);
	        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    	return result;
    }
    
    public boolean logUserLogout(User user) {
    	boolean result = false;
    	
		try {
	    	Connection con = getDbConnection("users_db");
	    	
	    	String sql = "INSERT INTO registry "
	                + " (login, time, action) "
	                + "VALUES ('" + user.login + "', '" + Timestamp.valueOf(LocalDateTime.now()) + "', 'OUT')" + ";";
	          
	        con.createStatement().execute(sql);
	        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    	return result;
    }
}
