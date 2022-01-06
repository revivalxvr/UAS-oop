import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
 
public boolean databaru;
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    databaru=true;
    
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    
}
private void GetData(){ 
    try {
        Connection conn =(Connection)delta.koneksi.koneksiDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet sql = stm.executeQuery("select * from handphone");
        jTable1.setModel(DbUtils.resultSetToTableModel(sql));
    }
    catch (SQLException | HeadlessException e) {
    }
}
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    if (databaru == true) { 
        try {
            String sql = "insert into phone values('"+jTextField1.getText()+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"')";
            java.sql.Connection conn = (java.sql.Connection)delta.App();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } else {
        try {
            String sql = "update phone SET id ='"+jTextField2.getText()+"',Nama ='"+jTextField3.getText()+"',Harga='"+jTextField4.getText()+"';
            java.sql.Connection conn = (java.sql.Connection)delta.App();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    GetData();
}
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    try { 
        String sql ="delete from phone where id ='"+jTextField1.getText()+"'";
        java.sql.Connection conn = (java.sql.Connection)delta.App();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Data akan dihapus?");
        databaru=true;
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        
    } catch (SQLException | HeadlessException e) {}
    
    GetData();
}
public FrmUtama() {
    initComponents();
    GetData(); // tampilkan ke grid
    databaru=true;
}
private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
    // TODO add your handling code here:
    databaru = false; 
    try {
        int row =jTable1.getSelectedRow();
        String tabel_klik=(jTable1.getModel().getValueAt(row, 0).toString());
        java.sql.Connection conn =(java.sql.Connection)delta.App();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet sql = stm.executeQuery("select * from phone where id ='"+tabel_klik+"'");
        if(sql.next()){
            String id = sql.getString("id");
            jTextField1.setText(id);
            String nama = sql.getString("nama");
            jTextField2.setText(nama);
            String nik = sql.getString("harga");
            jTextField3.setText(harga);
           
        }
    } catch (Exception e) {}
}
private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
    System.exit(0); 
}
