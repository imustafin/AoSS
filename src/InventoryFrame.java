
import backend.direct.DirectBackend;
import backend.interfaces.Product;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/******************************************************************************
 * File:NewJFrame.java
 * Course: 17655
 * Project: Assignment 2
 * Copyright: Copyright (c) 2014 Carnegie Mellon University
 * Versions:
 *	1.0 January 2014 - Modification to assignment 2 (ajl).
 *
 * This class defines a GUI application that allows inventory to be added,
 * deleted, and inventory counts to be decremented from theleaftech database.
 * There are four tables in the leaftech database: cultureboxes,
 * genomics, processing, and referencematerials.
 *
 ******************************************************************************/
/*
 * AddInventoryMainFrame.java
 *
 * Created on Jan 20, 2014, 11:24:23 PM
 */

/**
 *
 * @author lattanze
 */
public class InventoryFrame extends javax.swing.JFrame {

    String versionID = "v2.10.11";

    /** Creates new form AddInventoryMainFrame */
    public InventoryFrame(DirectBackend backend) {
        this.backend = backend;

        initComponents();
        jLabel1.setText("Inventory Management Application " + versionID);
    }

    DirectBackend backend;

    ComboBoxModel<String> getProductTypeComboBoxModel() {
        List<String> typeList = backend.getProductTypes();
        String[] typeArray = new String[typeList.size()];

        for (int i = 0; i < typeArray.length; i++) {
            typeArray[i] = typeList.get(i);
        }

        return new DefaultComboBoxModel<>(typeArray);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        productTypeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Leaf Tech Inventory Management System");

        jLabel2.setText("Product ID");

        jLabel3.setText("Retail Price Each");

        jLabel4.setText("Quantity");

        jTextField1.setText("localhost");

        jButton1.setText("Add");
        jButton1.setActionCommand("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("Product Description");

        jLabel6.setText("Database Server IP");

        jButton2.setText("List Table Contents");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Add Item to database: Select a category above, Enter info below, Press Add to add to inventory.");

        jLabel8.setText("Edit Inventory (note that negative inventory counts indicate backorders)");

        jLabel9.setText("Database and Table");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setText("(select item below and click to delete)");

        jLabel11.setText("(select table above and click)");

        jButton4.setText("Decrement");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setText("(select item and click to decrement inventory by 1)");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        productTypeComboBox.setModel(getProductTypeComboBoxModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(44, 44, 44)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(83, 83, 83)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(productTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(productTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add item to inventory

        String description;             // Inventory item description
        String errString;        // String for displaying errors
        Boolean fieldError = false;     // Error flag
        String msgString;        // String for displaying non-error messages
        Integer quantity;               // Quantity of inventory item
        Float perUnitCost;              // Cost per unit item
        String productID;        // Product id of item

        jTextArea1.setText("");

        String selectedType = (String) productTypeComboBox.getSelectedItem();

        // Check to make sure a radio button is selected
        if (selectedType == null)
        {
            fieldError = true;
            msgString = "Must select a category from combo box.";
            jTextArea1.append("\n"+msgString);
        } else {

            //Make sure there is a product description
            if ( jTextField5.getText().length() == 0 )
            {
                fieldError = true;
                msgString = "Must enter a product description.";
                jTextArea1.append("\n"+msgString);
            } else {

                //Make sure there is a product ID
                if ( jTextField2.getText().length() == 0 )
                {
                    fieldError = true;
                    msgString = "Must enter a product ID.";
                    jTextArea1.append("\n"+msgString);
                } else {

                    //Make sure there is a price
                    if ( jTextField3.getText().length() == 0 )
                    {
                        fieldError = true;
                        msgString = "Must enter a product price.";
                        jTextArea1.append("\n"+msgString);
                    } else {

                        //Make sure there is a quantity
                        if ( jTextField4.getText().length() == 0 )
                        {
                            fieldError = true;
                            msgString = "Must enter a product quantity.";
                            jTextArea1.append("\n"+msgString);
                        }
                    }
                }
            }
        } // button

        if (!fieldError )
        {
            try
            {
                // get the data from the text fields
                description = jTextField5.getText();
                productID = jTextField2.getText();
                quantity = Integer.parseInt(jTextField4.getText());
                perUnitCost = Float.parseFloat(jTextField3.getText());

                backend.addProduct(new backend.direct.Product(
                        selectedType,
                        productID,
                        description,
                        quantity,
                        perUnitCost
                ));

                // let the user know all went well

                jTextArea1.setText("");
                jTextArea1.append("\nINVENTORY UPDATED... The following was added...\n");
                jTextArea1.append("\n DESCRIPTION:: " + description );
                jTextArea1.append("\n QUANTITITY::  " + quantity );
                jTextArea1.append("\n UNIT COST::   " + perUnitCost );
            } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
                errString =  "\nProblem with insert:: " + e;
                jTextArea1.append(errString);
            } // try
        } //execute SQL check
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // This button will list the inventory for the product selected

        String errString = null;        // String for displaying errors
        Boolean fieldError = true;      // Error flag
        String msgString = null;        // String for displaying non-error messages

        String selectedType = (String) productTypeComboBox.getSelectedItem();

        // Check to make sure a radio button is selected
        if (selectedType != null)
        {
            fieldError = false;
        } else {
            msgString = "Must select a category radio button.";
            jTextArea1.setText("\n"+msgString);
        }

        //Now, we try to connect to the inventory database.
        if (!fieldError)
        {
            //Clear the fields - they are not needed and may cause confusion
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextArea1.setText("");

            try {
                List<Product> products = backend.getProductsByType(selectedType);

                jTextArea1.setText("");
                for (Product p : products) {
                    jTextArea1.append("\n" + productToString(p));
                }

            } catch (ClassNotFoundException | SQLException e) {
                errString = "\nProblem getting products:: " + e;
                jTextArea1.append(errString);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    String productToString(Product p) {
        return p.getType()
                + ">>" + p.getId()
                + "::" + p.getDescription()
                + "::" + p.getQuantity()
                + "::" + p.getPrice();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // This button deletes the item from the database highlighed by the user
        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        String errString;            // String for displaying errors
        String inventorySelection;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found

        // this is the selected line of text
        inventorySelection = jTextArea1.getSelectedText();

        // make sure the selection is not blank
        if (inventorySelection != null) {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>", beginIndex);

            if (endIndex < 0) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex + 2; //skip past ">>"
            }

            if (!IndexNotFound) {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":", beginIndex);

                if (endIndex < 0) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex, endIndex);
                }
            }

            // Now we delete the inventory item indicated by the productID we
            // parsed out above from the indicated table.
            if (!IndexNotFound) {
                jTextArea1.setText("");
                jTextArea1.append("Deleting ProductID: " + productID);

                String selectedType = (String) productTypeComboBox.getSelectedItem();
                try {
                    int productsDeleted = backend.deleteProduct(new backend.direct.Product(
                            selectedType,
                            productID,
                            null,
                            null,
                            null));
                    // let the user know all went well

                    jTextArea1.append("\n\n" + productID + " deleted...");
                    jTextArea1.append("\n Number of items deleted: " + productsDeleted);

                } catch (ClassNotFoundException | SQLException e) {
                    errString = "\nProblem with delete:: " + e;
                    jTextArea1.append(errString);
                } // try
            } else {
                jTextArea1.setText("");
                jTextArea1.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
            }
        } else {
            jTextArea1.setText("");
            jTextArea1.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");
        } // Blank string check
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // This button decrements the inventory count in the database of the item highlighed by the user

        int beginIndex;                     // Parsing index
        int endIndex;                       // Parsing index
        String productID = null;            // Product ID pnemonic
        Boolean IndexNotFound;              // Flag indicating a string index was not found.
        String errString = null;            // String for displaying errors
        String inventorySelection = null;   // Inventory text string selected by user
        IndexNotFound = false;              // Flag indicating that a string index was not found

        // this is the selected line of text
        inventorySelection =  jTextArea1.getSelectedText();

        // make sure the selection is not blank
        if ( inventorySelection != null )
        {
            // get the product ID - here we get the leading index
            beginIndex = 0;
            endIndex = inventorySelection.indexOf(">>",beginIndex);

            if (endIndex < 0 ) {
                IndexNotFound = true;
            } else {
                beginIndex = endIndex+2; //skip past ">>"
            }

            if ( !IndexNotFound )
            {
                // Here we get the trailing index and parse out the productID
                endIndex = inventorySelection.indexOf(":",beginIndex);

                if (endIndex < 0 ) {
                    IndexNotFound = true;
                } else {
                    productID = inventorySelection.substring(beginIndex,endIndex);
                }
            }

            // Now we decrement the inventory count of item indicated by the productID we
            // parsed out above from the indicated table.

            if ( !IndexNotFound )
            {
                jTextArea1.setText("");
                jTextArea1.append( "Deleting ProductID: " + productID );

                try {
                    List<Product> ans = backend.decrementProduct(new backend.direct.Product(
                            (String) productTypeComboBox.getSelectedItem(),
                            productID,
                            null,
                            null,
                            null
                    ));

                    for (Product p : ans) {
                        jTextArea1.append("\n" + productToString(p));
                    }

                    jTextArea1.append("\n\n Number of items updated: " + ans.size());

                } catch (ClassNotFoundException | SQLException e) {

                    errString = "\nProblem with delete:: " + e;
                    jTextArea1.append(errString);

                } // try

            } else {

                jTextArea1.setText("");
                jTextArea1.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");

            }
        } else {

            jTextArea1.setText("");
            jTextArea1.append("\nNo items selected...\nSELECT ENTIRE INVENTORY LINE TO ADD ITEM TO ORDER\n(TRIPLE CLICK ITEM LINE)");

        } // Blank string check
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JComboBox<String> productTypeComboBox;
    // End of variables declaration//GEN-END:variables

}
