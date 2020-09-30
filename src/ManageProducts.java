import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageProducts extends javax.swing.JInternalFrame {
    public static String operation = "";
    public ManageProducts() {
        initComponents();
        this.setTitle("Manage Product");
        jLabel9.setIcon(Control.def);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jSpinner1.setEnabled(false);
        jComboBox1.setEnabled(false);
        setTbl();
        //untuk data combo box genre
        jComboBox1.addItem("Select genre");
        String sql1 = "SELECT GenreName FROM genre";
        try{
            PreparedStatement statement1 = Connector.openConnection().prepareStatement(sql1);
            ResultSet rs1 = statement1.executeQuery();
            while(rs1.next()){
                jComboBox1.addItem(rs1.getString(1));
            }
            statement1.close();
        }catch(SQLException e){
            Logger.getLogger(sql1).log(Level.SEVERE, null, e);
        }
    }
    
    private void setTbl(){ //untuk mengambil data dari database ke tabel
        DefaultTableModel tabelModel1;
        tabelModel1 = new DefaultTableModel();
        tabelModel1.setColumnIdentifiers(new String[]{
                "Product ID", "Genre Name", "Product Name", "Product Price", "Product Quantity", "Product Image", "Product Rating"
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
    
    private void setIcon(File f) throws IOException{ //read file yang diimport user dan diset ke jLabel
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        jFileChooser1.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Product List");

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

        jLabel2.setText("Product ID");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Product Name");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Product Price");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Product Rating");

        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Product Stock");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel7.setText("Genre");

        jLabel8.setText("Product Image");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/no_img_200x200.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField5.setEnabled(false);

        jButton6.setText("Choose");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(5, 5, 5))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jButton6))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        operation = "insert";
        //generate productID
        String sql1 = "SELECT ProductID FROM product";
        String pID = "PD";
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
        String replace = id.replace("PD", "");
        try{
            i = Integer.parseInt(replace);
        }catch(NumberFormatException e){
            i = 0;
        }
        i++;
        if(i>99){
            pID = pID+i;
        }else if(i>9){
            pID = pID+"0"+i;
        }else{
            pID = pID+"00"+i;
        }
        jTextField1.setText(pID);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jSpinner1.setEnabled(true);
        jComboBox1.setEnabled(true);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jSpinner1.setValue(0);
        jLabel9.setIcon(Control.def);
        jComboBox1.setSelectedItem("Select genre");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        operation = "update";
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jSpinner1.setEnabled(true);
        jComboBox1.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        operation = "delete";
        if(jTable1.getSelectedRow() != -1){
            String sql = "DELETE FROM product WHERE ProductID=?";
            try{
                PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
                statement.setString(1, jTextField1.getText());
                int row = statement.executeUpdate();
                if(row>0){
                    JOptionPane.showMessageDialog(rootPane, "Delete Success");
                }
                statement.close();
            }catch(SQLException e){
                Logger.getLogger(sql).log(Level.SEVERE, null, e);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "No data is selected!");
        }
        setTbl();
        jButton5.setEnabled(true);
        jButton5.doClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int price = 0;
        int rating = 0;
        boolean isNumber1=true;
        boolean isNumber2=true;
        try{
            price = Integer.parseInt(jTextField3.getText());
        }catch(NumberFormatException e){
            isNumber1=false;
        }
        try{
            rating = Integer.parseInt(jTextField4.getText());
        }catch(NumberFormatException e){
            isNumber2=false;
        }
        if(jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Product name cannot be empty!");
        }else if(jTextField3.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Product price cannot be empty!");
        }else if(!isNumber1){
            JOptionPane.showMessageDialog(rootPane, "Product price must be a number!");
        }else if(jTextField4.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Product rating cannot be empty!");
        }else if(!isNumber2){
            JOptionPane.showMessageDialog(rootPane, "Product rating must be a number!");
        }else if((int)jSpinner1.getValue() < 1){
            JOptionPane.showMessageDialog(rootPane, "Minimum product stock is 1!");
        }else if(jComboBox1.getSelectedItem().toString().equals("Select genre")){
            JOptionPane.showMessageDialog(rootPane, "Genre must be selected!");
        }else if(jTextField5.getText().equals("Invalid picture!") || jTextField5.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Product image must be selected!");
        }else{
            if(operation.equals("insert")){
                String sql = "INSERT INTO product values (?, ?, ?, ?, ?, ?, ?)";
                try{
                    PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
                    statement.setString(1, jTextField1.getText());
                    statement.setString(2, genre("GenreName", jComboBox1.getSelectedItem().toString()));
                    statement.setString(3, jTextField2.getText());
                    statement.setInt(4, price);
                    statement.setInt(5, (int)jSpinner1.getValue());
                    statement.setString(6, jTextField5.getText());
                    statement.setInt(7, rating);
                    int row = statement.executeUpdate();
                    statement.close();
                }catch(SQLException e){
                    Logger.getLogger(sql).log(Level.SEVERE, null, e);
                }
            }else if(operation.equals("update")){
                String sql = "UPDATE product SET GenreID=?, "
                        + "ProductName=?, "
                        + "ProductPrice=?, "
                        + "ProductQuantity=?, "
                        + "ProductImage=?, "
                        + "ProductRating=? "
                        + "WHERE ProductID=?";
                try{
                    PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
                    statement.setString(1, genre("GenreName", jComboBox1.getSelectedItem().toString()));
                    statement.setString(2, jTextField2.getText());
                    statement.setInt(3, price);
                    statement.setInt(4, (int)jSpinner1.getValue());
                    statement.setString(5, jTextField5.getText());
                    statement.setInt(6, rating);
                    statement.setString(7, jTextField1.getText());
                    int row = statement.executeUpdate();
                    statement.close();
                }catch(SQLException e){
                    Logger.getLogger(sql).log(Level.SEVERE, null, e);
                }
            }
            operation="";
            setTbl();
            jButton5.doClick();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jLabel9.setIcon(Control.def);
        if((!(jTextField5.getText().equals("") || jTextField5.getText().equals("Invalid picture!"))) && 
                (operation.equals("insert") || operation.equals("delete"))){
            try{ 
                Files.deleteIfExists(Paths.get(Control.dir+jTextField5.getText()));
            }
            catch(IOException e){ 
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, e);
            } 
        }
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jSpinner1.setValue(0);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jSpinner1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox1.setSelectedItem("Select genre");
        setTbl();
        operation = "";
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jFileChooser1.showOpenDialog(null);
        File f = jFileChooser1.getSelectedFile();
        File g = null;
        String fname = f.getName();
        String fpath = f.getAbsolutePath();
        if(operation.equals("update")){
            try{ 
                Files.deleteIfExists(Paths.get(Control.dir+jTextField5.getText()));
            }
            catch(IOException e){ 
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if(fname.endsWith("png") || fname.endsWith("jpg")){
            try {
                OutputStream os = new FileOutputStream(Control.dir+fname);
                Path p = Paths.get(fpath);
                Files.copy(p, os);
                os.close();
                g = new File(Control.dir+fname);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextField5.setForeground(Color.black);
            jTextField5.setText(fname);
            try {
                setIcon(g);
            } catch (IOException ex) {
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
                jLabel9.setIcon(Control.def);
            }
        }else{
            jTextField5.setForeground(Color.red);
            jTextField5.setText("Invalid picture!");
            jLabel9.setIcon(Control.def);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(operation.equals("insert")){
            
        }else{
            String pid = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String sql = "SELECT ProductImage FROM product WHERE productID='"+pid+"'";
            String di = null;
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
            jTextField1.setText(pid);
            jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            jSpinner1.setValue(jTable1.getValueAt(jTable1.getSelectedRow(), 4));
            jComboBox1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 1));
            jTextField5.setText(di);
            File g = new File(Control.dir+di);
            try {
                setIcon(g);
            } catch (IOException ex) {
                Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
                jLabel9.setIcon(Control.def);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
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
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".png" and ".jpg" extension
            return file.isDirectory() || (file.getAbsolutePath().endsWith(".png") || file.getAbsolutePath().endsWith(".jpg"));
        }
        @Override
        public String getDescription() {
            return "Pictures (*.png, *.jpg)";
        }
    } 
}
