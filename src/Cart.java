
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cart extends javax.swing.JInternalFrame {
    public static LocalDate tgl = LocalDate.now();
    public Cart() {
        initComponents();
        this.setTitle("Cart");
        jLabel7.setText(Control.username);
        jLabel8.setText(Control.userID);
        jLabel9.setText(tgl.toString());
        //Data tabel
        DefaultTableModel tabelModel1;
        tabelModel1 = new DefaultTableModel();
        tabelModel1.setColumnIdentifiers(new String[]{
                "Product ID", "Name", "Price", "Quantity"
            });
        int total = 0;
        String sql = "SELECT * FROM cart WHERE UserID='"+Control.userID+"'";
        try{
            PreparedStatement statement3 = Connector.openConnection().prepareStatement(sql);
            ResultSet rs3 = statement3.executeQuery();
            while(rs3.next()){
                Object[] o = new Object[4];
                o[0] = rs3.getString(2);
                o[3] = rs3.getInt(3);
                String sql1 = "SELECT ProductName, ProductPrice FROM product WHERE ProductID='"+rs3.getString(2)+"'";
                PreparedStatement statement1 = Connector.openConnection().prepareStatement(sql1);
                ResultSet rs1 = statement1.executeQuery();
                while(rs1.next()){
                    o[1] = rs1.getString(1);
                    o[2] = rs1.getInt(2);
                }
                total = total + ((int)o[3] * (int)o[2]);
                tabelModel1.addRow(o);
                statement1.close();
            }
            statement3.close();
        }catch(SQLException e){
            Logger.getLogger(sql).log(Level.SEVERE, null, e);
        }
        jTable1.setModel(tabelModel1);
        jLabel6.setText(""+total);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cart");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("User ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Date :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Username :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Total Price :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Username ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("UserID ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Date");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Check out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //generate Transaction ID
        String sql1 = "SELECT TransactionID FROM headertransaction";
        String tID = "TR";
        String id = "";
        int i = 0;
        try{
            PreparedStatement statement1 = Connector.openConnection().prepareStatement(sql1);
            ResultSet rs1 = statement1.executeQuery();
            while(rs1.next()){
                id = rs1.getString(1);
            }
            statement1.close();
        }catch(SQLException e){
            Logger.getLogger(sql1).log(Level.SEVERE, null, e);
        }
        String replace = id.replace("TR", "");
        try{
            i = Integer.parseInt(replace);
        }catch(NumberFormatException e){
            i = 0;
        }
        i++;
        if(i>99){
            tID = tID+i;
        }else if(i>9){
            tID = tID+"0"+i;
        }else{
            tID = tID+"00"+i;
        }
        
        //insert ke table header transaction
        String sql3 = "INSERT INTO headertransaction values (?, ?, ?)";
        try{
            PreparedStatement statement3 = Connector.openConnection().prepareStatement(sql3);
            statement3.setString(1, tID);
            statement3.setString(2, Control.userID);
            Date a = Date.valueOf(tgl);
            statement3.setDate(3, a);
            int row = statement3.executeUpdate();
            statement3.close();
        }catch(SQLException e){
            Logger.getLogger(sql3).log(Level.SEVERE, null, e);
        }
        
        for(int k=0; k<jTable1.getRowCount(); k++){
            //insert ke detail transaction
            String sql2 = "INSERT INTO detailtransaction values (?, ?, ?)";
            try{
                PreparedStatement statement2 = Connector.openConnection().prepareStatement(sql2);
                statement2.setString(1, tID);
                statement2.setString(2, jTable1.getValueAt(k, 0).toString());
                statement2.setInt(3, (int)jTable1.getValueAt(k, 3));
                int row = statement2.executeUpdate();
                statement2.close();
            }catch(SQLException e){
                Logger.getLogger(sql2).log(Level.SEVERE, null, e);
            }
            
            //mengetahui stock barang
            int z = 0;
            String sql5 = "SELECT ProductQuantity FROM product WHERE ProductID='"
                    +jTable1.getValueAt(k, 0).toString()+"'";
            try{
                PreparedStatement statement5 = Connector.openConnection().prepareStatement(sql5);
                ResultSet rs5 = statement5.executeQuery();
                while(rs5.next()){
                    z = rs5.getInt(1);
                }
                statement5.close();
            }catch(SQLException e){
                Logger.getLogger(sql5).log(Level.SEVERE, null, e);
            }
            
            //update stock product
            String sql4 = "UPDATE product SET ProductQuantity=? WHERE ProductID=?";
            try{
                PreparedStatement statement4 = Connector.openConnection().prepareStatement(sql4);
                statement4.setInt(1, (z - (int)jTable1.getValueAt(k, 3)));
                statement4.setString(2, jTable1.getValueAt(k, 0).toString());
                int row = statement4.executeUpdate();
                statement4.close();
            }catch(SQLException e){
                Logger.getLogger(sql4).log(Level.SEVERE, null, e);
            }
        }
        //pembersihan table cart
        String sql6 = "DELETE FROM cart WHERE 1";
        try{
            PreparedStatement statement6 = Connector.openConnection().prepareStatement(sql6);
            statement6.execute();
            statement6.close();
        }catch(SQLException e){
            Logger.getLogger(sql6).log(Level.SEVERE, null, e);
        }
        
        JOptionPane.showMessageDialog(rootPane, "Thank you for shopping!");
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
