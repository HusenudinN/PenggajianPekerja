/*
 * Program untuk menjalankan form pegawai 
 * Dipanggil dari menu utama 
 * Data Pegawai
 */
package sisfopenggajian;

/**
 *
 * @author Husen
 */
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pegawai extends JInternalFrame implements ActionListener, 
        FocusListener{
    private JPanel jpPegawai1 = new JPanel();
    private JLabel lblNIP = new JLabel ("NIP"),
            lblNama = new JLabel ("Nama Pegawai"),
            lblAlt = new JLabel ("Alamat"),
            lblJk = new JLabel ("Jenis Kelamin"),
            lblAgama = new JLabel ("Agama"),
            lblStatus = new JLabel ("Status Pernikahan");
    private JTextField txtNIP = new JTextField (),
            txtNama = new JTextField (),
            txtAlt = new JTextField ();
    private JComboBox cmbJK = new JComboBox (),
            cmbAgama = new JComboBox (),
            cmbStatus = new JComboBox ();
    private JButton btnAdd = new JButton ("Add"),
            btnEdit = new JButton ("Edit"),
            btnDelete = new JButton ("Delete"),
            btnReset = new JButton ("Reset");
    Pegawai (){
        /* super(Judul, UkuranFrame, TombolClose, TombolMaksimum,
                TombolMinimum)*/
        super ("Form Pegawai", false, true, false, true);
        setSize (500,300);
        jpPegawai1.setLayout (null);
        
    // Input Jenis Kelamin
    cmbJK.addItem("");
    cmbJK.addItem("Laki-Laki");
    cmbJK.addItem("Perempuan");
    
    // Input Data Agama
    cmbAgama.addItem ("");
    cmbAgama.addItem("Islam");
    cmbAgama.addItem("Kristen");
    cmbAgama.addItem("Protestan");
    cmbAgama.addItem("Hindu");
    cmbAgama.addItem("Budha");
    
    // Input Status Perkawinan
    cmbStatus.addItem("");
    cmbStatus.addItem("Menikah");
    cmbStatus.addItem("Belum Menikah");
    
    /*Mengatur letak objek Label di Container */
    lblNIP.setBounds(15, 20, 100, 25);
    lblNama.setBounds(15, 55, 150, 25);
    lblAlt.setBounds(15, 90, 100, 25);
    lblJk.setBounds(15, 125, 100, 25);
    lblAgama.setBounds(15, 160, 100, 25);
    lblStatus.setBounds(15, 195, 150, 25);
                
    /*Mengatur letak objek Text Di Container */
    txtNIP.setBounds(165, 20, 110, 25);
    txtNama.setBounds(165, 55, 205, 25);
    txtAlt.setBounds(165, 90, 205, 25);
    cmbJK.setBounds(165, 125, 150, 25);
    cmbAgama.setBounds(165, 160, 150, 25);
    cmbStatus.setBounds(165, 195, 150, 25);
    
    /*Mengatur letak objek Button di Container*/
    btnAdd.setBounds(385, 20, 85, 25);
    btnEdit.setBounds(385, 55, 85, 25);
    btnDelete.setBounds(385, 90, 85, 25);
    btnReset.setBounds(385, 125, 85, 25);
    
    /*Objek Button di Non Aktifkan dan diAkrifkan */
    btnAdd.setEnabled(false);
    btnEdit.setEnabled(false);
    btnDelete.setEnabled(false);
    btnReset.setEnabled(true);
    
    /*Mengatur objek untuk dapat berinterkasi*/
    txtNIP.addFocusListener(this);
    btnAdd.addFocusListener(this);
    btnEdit.addFocusListener(this);
    btnDelete.addFocusListener(this);
    btnReset.addFocusListener(this);
    
    //Meletakan seluruh kontrol pada objek panel */
    jpPegawai1.add (lblNIP);
    jpPegawai1.add (txtNIP);
    jpPegawai1.add (lblNama);
    jpPegawai1.add (txtNama);
    jpPegawai1.add (lblAlt);
    jpPegawai1.add (txtAlt);
        jpPegawai1.add (lblJk);
        jpPegawai1.add (cmbJK);
        jpPegawai1.add (lblAgama);
        jpPegawai1.add (cmbAgama);
        jpPegawai1.add (lblStatus);
        jpPegawai1.add (cmbStatus);
    jpPegawai1.add (btnAdd);
    jpPegawai1.add (btnEdit);
    jpPegawai1.add (btnDelete);
    jpPegawai1.add (btnReset);
    
    /*Menambahkan objek panel (jpPegawai1) ke container frame */
    getContentPane().add (jpPegawai1);
    /*Menampilkan frame ke layar monitor */
    setVisible (true);
    }
    
    /*Fungsi untuk memeriksa kursor saat meninggalkan objek txtNIP*/
    public void focusGained (FocusEvent fe){}
    public void focusLost (FocusEvent fe){
        if (txtNIP.getText().equals ("")){}
        else{
            Cari();
        }
    }
    
    /*Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed (ActionEvent ae){
        Object obj = ae.getSource();
        if(obj == btnAdd)
        {
            Add();
        }
        if(obj == btnEdit)
        {
            Edit();
        }
        if(obj == btnDelete)
        {
            Delete();
        }
        Reset();
    }
    
    /*Fungsi untuk mencari NIP Pegawai ke tabel Pegawai*/
    void Cari(){
        try {
            Connect ObjKoneksi = new Connect();
            Connection con1 = ObjKoneksi.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "SELECT * FROM pegawai WHERE nip ='"+txtNIP.getText()+"'";
            ResultSet rs1 = st1.executeQuery(sql1);
            if(rs1.next())
            {
    /*Jika NIP Pegawai Ditemukan di Tabel Pegawai*/
                txtNIP.setText(rs1.getString("nip"));
                txtNama.setText(rs1.getString("namapeg"));
                txtAlt.setText(rs1.getString("altpeg"));
                cmbJK.setSelectedItem(rs1.getString("jkpeg"));
                cmbAgama.setSelectedItem(rs1.getString("agama"));
                cmbStatus.setSelectedItem(rs1.getString("statuspeg"));
                btnAdd.setEnabled(false);
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
                txtNama.requestFocus();
            }
            else 
            {
    /*Jika NIP Pegawai tidak ditemukan di tabel Pegawai */
                btnAdd.setEnabled(true);
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                txtNama.requestFocus();
            }
            rs1.close();
            con1.close();
        }
        catch(SQLException e)
        {
            
        }
    }
    
    // Fungsi Untuk menambah data ke tabel Pegawai 
    void Add()
    {
        try
        {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 ="insert into pegawai(nip, namapeg, altpeg, jkpeg, agama, statuspeg)"
                    +"values ('"+txtNIP.getText()+"','"+txtNama.getText()+"','"+
                    txtAlt.getText()+"','"+cmbJK.getSelectedItem()+"','"+
                    cmbAgama.getSelectedItem()+"','"+cmbStatus.getSelectedItem()+
                    "')";
            int rows1 = st1.executeUpdate(sql1);
            if(rows1 == 1)
                JOptionPane.showMessageDialog(this,"Berhasil Ditambahkan");
            con1.close();
        }
        catch (SQLException e)
        {
            
        }
        
    }
    // Fungsi untuk mengedit data tabel pegawai */
    void Edit()
    {
        try
        {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "UPDATE pegawai set namapeg='"+txtNama.getText()+
                    "',altpeg='"+txtAlt.getText()+"',jkpeg'"+cmbJK.getSelectedItem()
                    +"'statuspeg='"+cmbStatus.getSelectedItem()+"' WHERE nip = '"+txtNIP.getText()+"' ";
            int rows1 = st1.executeUpdate(sql1);
            if (rows1 == 1)
                JOptionPane.showMessageDialog(this, "Perubahan Berhasil Dilakukan");
            con1.close();
        }
        catch (SQLException e)
        {
            
        }
    }
    // Fungsi untuk meghapus record ditabel pegawai
    void Delete()
    {
        try
        {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 ="DELETE from pegawai where nip='"+txtNIP.getText()+"'";
            int rows1 = st1.executeUpdate(sql1);
            if (rows1 == 1)
            JOptionPane.showMessageDialog(this, "Berhasil Dihapus");
            con1.close();
        }
        catch(SQLException e)
        {
            
        }
    }
    
// Fungsi untuk mereset objek masukan 
    void Reset()
    {
        txtNIP.setText("");
        txtNama.setText("");
        txtAlt.setText("");
            cmbJK.setSelectedItem("");
            cmbAgama.setSelectedItem("");
            cmbStatus.setSelectedItem("");
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        txtNIP.requestFocus();
    }
    }
            
            
    

