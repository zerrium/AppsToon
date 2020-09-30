
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AppsToon extends javax.swing.JFrame {
    public AppsToon() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Apps Toon");
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        for(int i=2019; i>=1900; i--){
            jComboBox4.addItem(""+i); //combobox year
        }
        for(int i=1; i<=31; i++){
            jComboBox1.addItem(""+i); //combobox day
        }
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("APPS TOON");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Confirm Password");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gender");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("DOB");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Phone Number");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Address");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setToolTipText("");

        jTextField2.setToolTipText("");

        jRadioButton1.setText("Male");

        jRadioButton2.setText("Female");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Months", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));

        jTextField5.setToolTipText("");

        jTextField6.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(84, 84, 84))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRadioButton1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        buttonGroup1.clearSelection();
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        jComboBox1.setSelectedItem("Day");
        jComboBox3.setSelectedItem("Months");
        jComboBox4.setSelectedItem("Year");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String pass1 = new String (jPasswordField1.getPassword());
        String pass2 = new String (jPasswordField2.getPassword());
        long phone = 0;
        boolean onlyNumber = true;
        try{
            phone = Long.parseLong(jTextField5.getText());
        }catch(NumberFormatException e){
            onlyNumber=false;
        }
        if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Username must be filled!");
        }else if(jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Email must be filled!");
        }else if(pass1.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Password must be filled!");
        }else if(!jRadioButton1.isSelected() && !jRadioButton2.isSelected()){
            JOptionPane.showMessageDialog(rootPane, "Please choose gender!");
        }else if(jComboBox1.getSelectedItem().toString().equals("Day")){
            JOptionPane.showMessageDialog(rootPane, "Please choose date!");
        }else if(jComboBox3.getSelectedItem().toString().equals("Months")){
            JOptionPane.showMessageDialog(rootPane, "Please choose date!");
        }else if(jComboBox4.getSelectedItem().toString().equals("Year")){
            JOptionPane.showMessageDialog(rootPane, "Please choose date!");
        }else if(jTextField5.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Phone number must be filled!");
        }else if(jTextField6.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Address must be filled!");
        }else{
            int date = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            String month = jComboBox3.getSelectedItem().toString();
            int year = Integer.parseInt(jComboBox4.getSelectedItem().toString());;
            if(jTextField1.getText().length() < 5 || jTextField1.getText().length() > 20){
                JOptionPane.showMessageDialog(rootPane, "Username lenght must be between 5 and 20 characters!");
            }else if(jTextField2.getText().length() < 14){
                JOptionPane.showMessageDialog(rootPane, "Email must not be under 14 characters!");
            }else if(!jTextField2.getText().contains("@")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Does not contain @)");
            }else if(!jTextField2.getText().contains(".")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Does not contain .)");
            }else if(jTextField2.getText().indexOf("@") > jTextField2.getText().indexOf(".")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Character @ exists after character .)");
                //Memeriksa apakah karakter @ ada setelah karakter .
            }else if(jTextField2.getText().startsWith("@") || jTextField2.getText().startsWith(".")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Starts with @ or .)");
            }else if(jTextField2.getText().indexOf("@", (jTextField2.getText().indexOf("@"))+1) > -1){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Contains more than one @)");
                //Memeriksa apakah karakter @ hanya ada satu
            }else if(jTextField2.getText().indexOf(".", (jTextField2.getText().indexOf("."))+1) > -1){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Contains more than one .)");
                //Memeriksa apakah karakter . hanya ada satu
            }else if(!jTextField2.getText().endsWith(".com")){
                JOptionPane.showMessageDialog(rootPane, "Wrong email format! (Does not end with .com)");
            }else if(!Alphanumeric(pass1)){
                JOptionPane.showMessageDialog(rootPane, "Password must be alphanumeric!");
            }else if(pass1.length()<10){
                JOptionPane.showMessageDialog(rootPane, "Password must be at least 10 characters!");
            }else if(!pass2.equals(pass1)){
                JOptionPane.showMessageDialog(rootPane, "Confirmation Password does not match!");
            }else if(!dateValidity(date, month, year)){
                JOptionPane.showMessageDialog(rootPane, "Invalid date!");
                //Memeriksa validasi tanggal, contoh: 30 February
            }else if(!onlyNumber){
                JOptionPane.showMessageDialog(rootPane, "Invalid phone number (may only contains numbers)!");
            }else if(jTextField5.getText().length() != 12){
                JOptionPane.showMessageDialog(rootPane, "Invalid phone number (must be 12 digits)!");
            }else if(jTextField6.getText().length()<6 || jTextField6.getText().length()>30){
                JOptionPane.showMessageDialog(rootPane, "Address length must be between 6 and 30 characters!");
            }else if(!jTextField6.getText().endsWith("Street")){
                JOptionPane.showMessageDialog(rootPane, "Invalid address (must ends with Street)!");
            }else{
                String gender = "";
                if(jRadioButton1.isSelected()){
                    gender = "Male";
                }else if(jRadioButton2.isSelected()){
                    gender = "Female";
                }
                //generate USERID
                String UserID = "US";
                String sql2 = "SELECT UserID FROM user";
                int i = 0;
                try{
                    PreparedStatement statement2 = Connector.openConnection().prepareStatement(sql2);
                    ResultSet rs2 = statement2.executeQuery();
                    while(rs2.next()){
                        i++; //menghitung jumlah data
                    }
                    statement2.close();
                }catch(SQLException e){
                    Logger.getLogger(sql2).log(Level.SEVERE, null, e);
                }
                i++;
                if(i<10){
                    UserID = UserID+"00"+i;
                }else if(i<100){
                    UserID = UserID+"0"+i;
                }else{
                    UserID = UserID+i;
                }
                String sql = "INSERT INTO user values (?, ?, ?, ?, ?, ?, ?, ?)";
                try{
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy MMMM dd");
                    java.util.Date udt = dt.parse(jComboBox4.getSelectedItem().toString()+" "+
                            jComboBox3.getSelectedItem().toString()+" "+jComboBox1.getSelectedItem().toString());
                    java.sql.Date sqldt = new java.sql.Date(udt.getTime());
                    PreparedStatement statement = Connector.openConnection().prepareStatement(sql);
                    statement.setString(1, UserID);
                    statement.setString(2, jTextField1.getText());
                    statement.setString(3, jTextField2.getText());
                    statement.setString(4, pass2);
                    statement.setString(5, gender);
                    statement.setDate(6, sqldt);
                    statement.setString(7, jTextField5.getText());
                    statement.setString(8, jTextField6.getText());

                    int row = statement.executeUpdate();
                    if(row>0){
                        JOptionPane.showMessageDialog(rootPane, "Register success!");
                    }
                    statement.close();
                }catch(Exception e){
                    Logger.getLogger(sql).log(Level.SEVERE, null, e);
                    System.out.println(e);
                }
                new Login().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
