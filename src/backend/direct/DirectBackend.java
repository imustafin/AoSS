/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.direct;

import backend.interfaces.Backend;
import backend.interfaces.Order;
import backend.interfaces.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
            for (String type : types) {
                ans.add(type);
            }
        }
        
        return ans;
    }
    
    List<Product> eepsProductsByType(String type) throws SQLException, ClassNotFoundException {
        List<Product> ans = new ArrayList<>();
        
        Connection con = getDbConnection("inventory");
        
        String sql = "SELECT * FROM " + type;
        
        ResultSet res = con.createStatement().executeQuery(sql);

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
    
    List<Product> leaftechProductsByType(String type) throws SQLException, SQLException, ClassNotFoundException {
        List<Product> ans = new ArrayList<>();
        
        Connection con = getDbConnection("leaftech");
        
        String sql = "SELECT * FROM " + type;
        
        ResultSet res = con.createStatement().executeQuery(sql);
        
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
    public List<Order> getOrders(Boolean isShipped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
