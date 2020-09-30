import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

public class ManageUsers extends javax.swing.JInternalFrame {
    public static ArrayList<String> p = new ArrayList<>();
    public ManageUsers() {
        initComponents();
        this.setTitle("Manage User");
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jPasswordField1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        for(int i=1; i<=31; i++){
            jComboBox1.addItem(""+i); //combo box day
        }
        for(int i=2019; i>=1900; i--){
            jComboBox3.addItem(""+i); //combo box year
        }
        setTbl();
    }
    
    public boolean Alphanumeric(String str) { //untuk memeriksa apakah sebuah string mengandung karakter dan angka
        boolean isAlphabet = false;
        boolean isNumeric = false;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                isAlphabet = true;
            }
            if(c >= '0' && c <= '9'){
                isNumeric = true;
            }
        }
        if(isAlphabet && isNumeric){
            return true;
        }else{
            return false;
        }
    }
    public boolean dateValidity(int date, String month, int year){ //untuk mengecek tanggal
        if(date==31 && (month.equals("February") || month.equals("April") || month.equals("June")
                || month.equals("September") || month.equals("November"))){
            return false;
        }else if(date==30 && month.equals("February")){
            return false;
        }else if(year%4!=0 && month.equals("February") && date==29){
            return false;
        }else{
            return true;
        }
    }
    
    private void setTbl(){ //untuk mengambil data dari database ke tabel
        DefaultTableModel tabelModel1;
        tabelModel1 = new DefaultTableModel();
        tabelModel1.setColumnIdentifiers(new String[]{
                "UserID", "UserName", "UserEmail", "UserPassword", "UserGender", "UserDOB", "UserPhoneNumber", "UserAddress"
            });
        String sql = "SELECT * FROM user";
        p.clear();
        try{
            PreparedStatement statement3 = Connector.openConnection().prepareStatement(sql);
            ResultSet rs3 = statement3.executeQuery();
            while(rs3.next()){
                Object[] o =new Object[8];
                o[0] = rs3.getString(1);
                o[1] = rs3.getString(2);
                o[2] = rs3.getString(3);
                p.add(rs3.getString(4));
                String a = "";
                for(int i=0; i<rs3.getString(4).length(); i++){
                    a = a+"*";
                }
                o[3] = a;
                o[4] = rs3.getString(5);
                o[5] = rs3.getDate(6);
                o[6] = rs3.getLong(7);
                o[7] = rs3.getString(8);
                tabelModel1.addRow(o);
            }
            statement3.close();
        }catch(SQLException e){
            Logger.getLogger(sql).log(Level.SEVERE, null, e);
        }
        jTable1.setModel(tabelModel1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("User ID:");

        jLabel11.setText("User name:");

        jLabel12.setText("User email:");

        jLabel13.setText("User password:");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("User gender:");

        jLabel3.setText("User date of birth:");

        jLabel4.setText("User phone number:");

        jLabel5.setText("User address:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));

        jRadioButton1.setLabel("Male");

        jRadioButton2.setLabel("Female");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(417, 417, 417)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField1)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13))
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jRadioButton1)
                            .addGap(36, 36, 36)
                            .addComponent(jRadioButton2))
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        jPasswordField1.setEnabled(true);
        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox3.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(jTable1.getSelectedRow() != -1){
            if(jTextField1.getText().equals("admin")){
                JOptionPane.showMessageDialog(rootPane, "Cannot delete user who is staff!");
            }else if(jTextField1.getText().equals(Control.userID)){
                JOptionPane.showMessageDialog(rootPane, "Cannot delete current logged in user!");
            }else{
                String sql = "DELETE FROM user WHERE UserID=?";
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
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "No data is selected!");
        }
        jButton5.setEnabled(true);
        jButton5.doClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String pass = new String (jPasswordField1.getPassword());
        long phone = 0;
        boolean onlyNumber = true;
        try{
            phone = Long.parseLong(jTextField4.getText());
        }catch(NumberFormatException e){
            onlyNumber=false;
        }
        if(jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Username must be filled!");
        }else if(jTextField3.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Email must be filled!");
        }else if(pass.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Password must be filled!");
        }else if(!jRadioButton1.isSelected() && !jRadioButton2.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Please choose gender!");
        }else if(jComboBox1.getSelectedItem().toString().equals("Day")){
            JOptionPane.showMessageDialog(rootPane, "Please choose date!");
        }else if(jComboBox2.getSelectedItem().toString().equals("Month")){
            JOptionPane.showMessageDialog(rootPane, "Please choose date!");
        }else if(jComboBox2.getSelectedItem().toString().equals("Year")){
            JOptionPane.showMessageDialog(rootPane, "Please choose date!");
        }else if(jTextField4.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Phone number must be filled!");
        }else if(jTextField5.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Address must be filled!");
        }else{
            int date = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            String month = jComboBox2.getSelectedItem().toString();
            int year = Integer.parseInt(jComboBox3.getSelectedItem().toString());;
            if(jTextField2.getText().length() < 5 || jTextField1.getText().length() > 20){
                JOptionPane.showMessageDialog(rootPane, "Username lenght must be between 5 and 20 characters!");
            }else if(jTextField3.getText().length() < 14){
                JOptionPane.showMessageDialog(rootPane, "Email must not be under 14 characters!");
            }else if(!jTextField3.getText().contains("@")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Does not contain @)");
            }else if(!jTextField3.getText().contains(".")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Does not contain .)");
            }else if(jTextField3.getText().indexOf("@") > jTextField3.getText().indexOf(".")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Character @ exists after character .)");
                //Memeriksa apakah karakter @ ada setelah karakter .
            }else if(jTextField3.getText().startsWith("@") || jTextField3.getText().startsWith(".")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Starts with @ or .)");
            }else if(jTextField3.getText().indexOf("@", (jTextField3.getText().indexOf("@"))+1) > -1){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Contains more than one @)");
                //Memeriksa apakah karakter @ hanya ada satu
            }else if(jTextField3.getText().indexOf(".", (jTextField3.getText().indexOf("."))+1) > -1){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Contains more than one .)");
                //Memeriksa apakah karakter . hanya ada satu
            }else if(!jTextField3.getText().endsWith(".com")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Does not end with .com)");
            }else if(!Alphanumeric(pass)){
                JOptionPane.showMessageDialog(rootPane, "Password must be alphanumeric!");
            }else if(pass.length()<10){
                JOptionPane.showMessageDialog(rootPane, "Password must be at least 10 characters!");
            }else if(!dateValidity(date, month, year)){
                JOptionPane.showMessageDialog(rootPane, "Invalid date!");
                //Memeriksa validasi tanggal, contoh: 30 February
            }else if(!onlyNumber){
                JOptionPane.showMessageDialog(rootPane, "Invalid phone number (may only contains numbers)!");
            }else if(jTextField4.getText().length() != 12){
                JOptionPane.showMessageDialog(rootPane, "Invalid phone number (must be 12 digits)!");
            }else if(jTextField5.getText().length()<6 || jTextField5.getText().length()>30){
                JOptionPane.showMessageDialog(rootPane, "Address length must be between 6 and 30 characters!");
            }else if(!jTextField5.getText().endsWith("Street")){
                JOptionPane.showMessageDialog(rootPane, "Invalid address (must ends with Street)!");
            }else{
                boolean ulang = true;
                do{
                    JPasswordField yField = new JPasswordField(20);
                    JPanel myPanel = new JPanel(new BorderLayout(5,5));
                    JPanel label = new JPanel(new GridLayout(0,1,2,2));
                    label.add(new JLabel("Enter confimation password:"));

                    JPanel controls = new JPanel(new GridLayout(0,1,2,2));
                    controls.add(label);
                    controls.add(yField);
                    myPanel.add(controls, BorderLayout.CENTER);

                    int result = JOptionPane.showConfirmDialog(null, myPanel, 
                           "Message", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        String confirmpass = new String(yField.getPassword());
                        if(confirmpass.equals("")){
                            JOptionPane.showMessageDialog(null, "Confirmation password must be entered", "Uh-oh...", JOptionPane.WARNING_MESSAGE);
                            yField.requestFocus();
                        }else{
                            if(confirmpass.equals(pass)){
                                String gender = "";
                                if(jRadioButton1.isSelected()){
                                    gender = "Male";
                                }else if(jRadioButton2.isSelected()){
                                    gender = "Female";
                                }
                                String sql = "UPDATE user SET UserName=?, "
                                        + "UserEmail=?, "
                                        + "UserPassword=?, "
                                        + "UserGender=?, "
                                        + "UserDOB=?, "
                                        + "UserPhoneNumber=?, "
                                        + "UserAddress=? "
                                        + "WHERE USerID=?";
                                try{
                                    SimpleDateFormat dt = new SimpleDateFormat("yyyy MMMM dd");
                                    java.util.Date udt = dt.parse(jComboBox3.getSelectedItem().toString()+" "+
                                            jComboBox2.getSelectedItem().toString()+" "+jComboBox1.getSelectedItem().toString());
                                    java.sql.Date sqldt = new java.sql.Date(udt.getTime());
                                    PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
                                    statement.setString(1, jTextField2.getText());
                                    statement.setString(2, jTextField3.getText());
                                    statement.setString(3, pass);
                                    statement.setString(4, gender);
                                    statement.setDate(5, sqldt);
                                    statement.setString(6, jTextField4.getText());
                                    statement.setString(7, jTextField5.getText());
                                    statement.setString(8, jTextField1.getText());

                                    int row = statement.executeUpdate();
                                    statement.close();
                                }catch(Exception e){
                                    Logger.getLogger(sql).log(Level.SEVERE, null, e);
                                    System.out.println(e);
                                }
                                ulang=false;
                                jButton5.doClick();
                            }else{
                                JOptionPane.showMessageDialog(null, "Confirmation password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
                                ulang=true;
                            }
                        }
                    }else{
                        ulang=false;
                    }
                }while(ulang);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        buttonGroup1.clearSelection();
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jPasswordField1.setEnabled(false);
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        setTbl();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jTextField4.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
        jTextField5.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
        jPasswordField1.setText(p.get(jTable1.getSelectedRow()));
        switch(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()){
            case "Male":
                jRadioButton1.setSelected(true);
                break;
            case "Female":
                jRadioButton2.setSelected(true);
                break;
        }
        int month = 0;
        try{
            month = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString().substring(5, 7));
        }catch(NumberFormatException e){
            month = 0;
        }
        jComboBox1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString().substring(9));
        jComboBox2.setSelectedIndex(month);
        jComboBox3.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString().substring(0, 4));
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
