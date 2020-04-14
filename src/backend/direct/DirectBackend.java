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
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(host, user, password);
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
    public List<Product> getProductTypes() {
        List<Product> ans = new ArrayList<Product>();
        
        for (String[] types : PRODUCT_TYPE_ARRAYS) {
            for (String type : types) {
                ans.add(new backend.direct.Product(null, type, null, null, null, null));
            }
        }
        
        return ans;
    }

    @Override
    public List<Product> getProductsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getOrders(Boolean isShipped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
