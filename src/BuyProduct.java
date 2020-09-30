import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BuyProduct extends javax.swing.JInternalFrame {
    public BuyProduct() {
        initComponents();
        this.setTitle("Buy Product");
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); //(initial value, min, max, step)
        jSpinner1.setEnabled(false);
        setTbl();
        jLabel9.setIcon(Control.def);
    }
    
    private void setTbl(){ //untuk mengambil data dari database ke tabel
        DefaultTableModel tabelModel1;
        tabelModel1 = new DefaultTableModel();
        tabelModel1.setColumnIdentifiers(new String[]{
                "Product ID", "Genre Name", "Product Name", "Product Price", "Product Stock", "Product Image", "Product Rating"
            });
        String sql = "SELECT * FROM product";
        try{
            PreparedStatement statement3 = Connector.openConnection().prepareStatement(sql);
            ResultSet rs3 = statement3.executeQuery();
            while(rs3.next()){
                Object[] o =new Object[7];
                o[0] = rs3.getString(1);
                o[1] = genre("GenreID", rs3.getString(2));
                o[2] = rs3.getString(3);
                o[3] = rs3.getInt(4);
                o[4] = rs3.getInt(5);
                o[5] = rs3.getString(6);
                o[6] = rs3.getInt(7);
                tabelModel1.addRow(o);
            }
            statement3.close();
        }catch(SQLException e){
            Logger.getLogger(sql).log(Level.SEVERE, null, e);
        }
        jTable1.setModel(tabelModel1);
    }
    
    private void setIcon(File f) throws IOException{ //set ke jLabel
        BufferedImage img1 = ImageIO.read(f);
        ImageIcon img2 = new ImageIcon(img1);
        if(img1 != null){
            Image img3 = img2.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon img4 = new ImageIcon(img3);
            jLabel9.setIcon(img4);
        }else{
            jLabel9.setIcon(Control.def);
        }
    }
    
    public String genre(String mode, String key){ //mengubah GenreName menjadi GenreID dan sebaliknya
        String result = null;
        String sql = "SELECT * FROM genre WHERE "+mode+"='"+key+"'";
        try{
            PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
            ResultSet rs1 = statement.executeQuery();
            while(rs1.next()){
                if(mode.equals("GenreID")){
                    result = rs1.getString(2);
                }else if(mode.equals("GenreName")){
                    result = rs1.getString(1);
                }
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(sql).log(Level.SEVERE, null, e);
            result = null;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Our Products");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("ProductID");

        jLabel3.setText("Product Name");

        jLabel5.setText("Product Price");

        jLabel6.setText("Product Genre");

        jLabel7.setText("Quantity");

        jLabel8.setText("Rating");

        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("-");

        jLabel11.setText("-");

        jLabel12.setText("-");

        jLabel13.setText("-");

        jLabel14.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(420, 420, 420))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jLabel4)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ArrayList<String> pID = new ArrayList<>();
        ArrayList<Integer> qty = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE UserID='"+Control.userID+"'";
        int jumlah = 0;
        boolean a = false;
        try{
            PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
            ResultSet rs1 = statement.executeQuery();
            while(rs1.next()){
                pID.add(rs1.getString(2));
                qty.add(rs1.getInt(3));
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(sql).log(Level.SEVERE, null, e);
        }
        if(!qty.isEmpty() && pID.contains(jLabel10.getText())){
            jumlah = qty.get(pID.indexOf(jLabel10.getText())) + (int)jSpinner1.getValue();
            a = true;
        }
        if(jLabel10.getText().equals("-")){
            JOptionPane.showMessageDialog(rootPane, "Please select a product!");
        }else if((int)jSpinner1.getValue() < 1){
            JOptionPane.showMessageDialog(rootPane, "Quantity must be at least 1!");
        }else if(jumlah > (int)jTable1.getValueAt(jTable1.getSelectedRow(), 4)){
            JOptionPane.showMessageDialog(rootPane, "Quantity cannot be more than available stock!");
        }else{
            if(a){
                String sql1 = "UPDATE cart SET Qty=? WHERE ProductID=?";
                try{
                    PreparedStatement statement1 = Connector.openConnection().prepareStatement(sql1);
                    statement1.setInt(1, jumlah);
                    statement1.setString(2, jLabel10.getText());
                    int row = statement1.executeUpdate();
                    statement1.close();
                }catch(SQLException e){
                    Logger.getLogger(sql1).log(Level.SEVERE, null, e);
                }
            }else{
                String sql3 = "INSERT INTO cart values (?, ?, ?)";
                try{
                    PreparedStatement statement3 = Connector.openConnection().prepareStatement(sql3);
                    statement3.setString(1, Control.userID);
                    statement3.setString(2, jLabel10.getText());
                    statement3.setInt(3, (int)jSpinner1.getValue());
                    int row = statement3.executeUpdate();
                    statement3.close();
                }catch(SQLException e){
                    Logger.getLogger(sql3).log(Level.SEVERE, null, e);
                }
            } 
            
            String[] options ={"Continue Shopping", "Go to Cart"};
            int x = JOptionPane.showOptionDialog(null, "Added to cart", "Message",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                    null, options, options[0]);
            switch(x){
                case 0:
                    jLabel9.setIcon(Control.def);
                    jLabel10.setText("-");
                    jLabel11.setText("-");
                    jLabel12.setText("-");
                    jLabel13.setText("-");
                    jLabel14.setText("-");
                    jSpinner1.setValue(0);
                    jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1)); //(initial value, min, max, step)
                    jSpinner1.setEnabled(false);
                    break;
                case 1:
                    Main.ct = new Cart();
                    Main.desktopPane.add(Main.ct);
                    Main.ct.setVisible(true);
                    this.dispose();
                    break;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jSpinner1.setEnabled(true);
        String pid = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String sql = "SELECT ProductImage FROM product WHERE productID='"+pid+"'";
        String di = null;
        int stock = (int)jTable1.getValueAt(jTable1.getSelectedRow(), 4);
        try{
            PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
            ResultSet rs1 = statement.executeQuery();
            while(rs1.next()){
                di = rs1.getString(1);
            }
            statement.close();
        }catch(SQLException e){
            Logger.getLogger(sql).log(Level.SEVERE, null, e);
        }
        jLabel10.setText(pid);
        jLabel11.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jLabel12.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jLabel14.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, stock, 1)); //(initial value, min, max, step)
        jLabel13.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        File g = new File(Control.dir+di);
        try {
            setIcon(g);
        } catch (IOException ex) {
            Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
            jLabel9.setIcon(Control.def);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
