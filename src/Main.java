public class Main extends javax.swing.JFrame {
    public static BuyProduct bp;
    public static TransactionList tl;
    public static ManageProducts mp;
    public static ManageUsers mu;
    public static Cart ct;
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Main Form");
        if(Control.isStaff){
            Manage_Menu.setVisible(true);
            Manage_Menu.setEnabled(true);
        }else{
            Manage_Menu.setVisible(false);
            Manage_Menu.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        Transaction_Menu = new javax.swing.JMenu();
        Buy_Product = new javax.swing.JMenuItem();
        View_Transaction = new javax.swing.JMenuItem();
        Manage_Menu = new javax.swing.JMenu();
        Manage_User = new javax.swing.JMenuItem();
        Manage_Product = new javax.swing.JMenuItem();
        Logout_Menu = new javax.swing.JMenu();
        Logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(desktopPane.getBackground());
        desktopPane.setPreferredSize(new java.awt.Dimension(960, 540));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N

        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Transaction_Menu.setMnemonic('f');
        Transaction_Menu.setText("Transaction");

        Buy_Product.setMnemonic('o');
        Buy_Product.setText("Buy Product");
        Buy_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buy_ProductActionPerformed(evt);
            }
        });
        Transaction_Menu.add(Buy_Product);

        View_Transaction.setMnemonic('s');
        View_Transaction.setText("View Transaction");
        View_Transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_TransactionActionPerformed(evt);
            }
        });
        Transaction_Menu.add(View_Transaction);

        menuBar.add(Transaction_Menu);

        Manage_Menu.setMnemonic('e');
        Manage_Menu.setText("Manage");

        Manage_User.setMnemonic('t');
        Manage_User.setText("User");
        Manage_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manage_UserActionPerformed(evt);
            }
        });
        Manage_Menu.add(Manage_User);

        Manage_Product.setMnemonic('y');
        Manage_Product.setText("Product");
        Manage_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manage_ProductActionPerformed(evt);
            }
        });
        Manage_Menu.add(Manage_Product);

        menuBar.add(Manage_Menu);

        Logout_Menu.setMnemonic('h');
        Logout_Menu.setText("Logout");

        Logout.setMnemonic('c');
        Logout.setText("Logout");
        Logout.setActionCommand("");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Logout_Menu.add(Logout);

        menuBar.add(Logout_Menu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void View_TransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_TransactionActionPerformed
        if(desktopPane.isAncestorOf(bp)){
            bp.dispose();
        }
        if(desktopPane.isAncestorOf(mp)){
            mp.dispose();
        }
        if(desktopPane.isAncestorOf(ct)){
            ct.dispose();
        }
        if(desktopPane.isAncestorOf(mu)){
            mu.dispose();
        }
        tl = new TransactionList();
        desktopPane.add(tl);
        tl.setVisible(true);
    }//GEN-LAST:event_View_TransactionActionPerformed

    private void Buy_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buy_ProductActionPerformed
        if(desktopPane.isAncestorOf(tl)){
            tl.dispose();
        }
        if(desktopPane.isAncestorOf(mp)){
            mp.dispose();
        }
        if(desktopPane.isAncestorOf(ct)){
            ct.dispose();
        }
        if(desktopPane.isAncestorOf(mu)){
            mu.dispose();
        }
        bp = new BuyProduct();
        desktopPane.add(bp);
        bp.setVisible(true);
    }//GEN-LAST:event_Buy_ProductActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Control.username = null;
        Control.userID = null;
        Control.isStaff = false;
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void Manage_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manage_ProductActionPerformed
        if(desktopPane.isAncestorOf(tl)){
            tl.dispose();
        }
        if(desktopPane.isAncestorOf(bp)){
            bp.dispose();
        }
        if(desktopPane.isAncestorOf(ct)){
            ct.dispose();
        }
        if(desktopPane.isAncestorOf(mu)){
            mu.dispose();
        }
        if(Control.isStaff){
            mp = new ManageProducts();
            desktopPane.add(mp);
            mp.setVisible(true);
        }
    }//GEN-LAST:event_Manage_ProductActionPerformed

    private void Manage_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manage_UserActionPerformed
        if(desktopPane.isAncestorOf(tl)){
            tl.dispose();
        }
        if(desktopPane.isAncestorOf(bp)){
            bp.dispose();
        }
        if(desktopPane.isAncestorOf(ct)){
            ct.dispose();
        }
        if(desktopPane.isAncestorOf(mp)){
            mp.dispose();
        }
        if(Control.isStaff){
            mu = new ManageUsers();
            desktopPane.add(mu);
            mu.setVisible(true);
        }
    }//GEN-LAST:event_Manage_UserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Buy_Product;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenu Logout_Menu;
    private javax.swing.JMenu Manage_Menu;
    private javax.swing.JMenuItem Manage_Product;
    private javax.swing.JMenuItem Manage_User;
    private javax.swing.JMenu Transaction_Menu;
    private javax.swing.JMenuItem View_Transaction;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
