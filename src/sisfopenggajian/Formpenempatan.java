/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfopenggajian;

/**
 *
 * @author Husen
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;



public class Formpenempatan extends JInternalFrame{
    private JPanel jpTempat = new JPanel();
    /*Deklarasi Objek Label Ke Formpenempatan */
    private JLabel lblCatatgol = new JLabel ("Catat Penempatan"),
            lblnip = new JLabel ("Nip"),
            lblnamapeg = new JLabel ("Nama Pegawai"),
            lblnogol = new JLabel ("Nomor Gol"),
            lblgapok = new JLabel ("Gaji POkok");
    /*Deklarasi Objek Text Ke form Penempatan */
    
    private JTextField txtnip = new JTextField(),
            txtnamapeg = new JTextField (),
            txtnogol = new JTextField (),
            txtgapok = new JTextField ();
    /*Deklarasi Objek Label Ke Rinci FormPenempatan */
    private JLabel lblsk = new JLabel ("SK"),
            lbltglmutasi = new JLabel ("Tanggal Mutasi");
    /*Deklarasi Objek Text ke Form Penempatan Rinco */
    private JTextField txtsk = new JTextField (),
            txttglmutasi = new JTextField ();
    /*Deklarasi Ojek Button ke FormPenempatan Rinci*/
    private JButton btnAddRinci = new JButton ("Add Rinci"),
            btnEditRinci = new JButton ("Edit Rinci"),
            btnDeleteRinci = new JButton ("Delete Rinci"),
            btnKosongRinci = new JButton ("Bersihkan"),
            btnExitRinci = new JButton ("Exit Rinci");
    /*Deklarasi Objek Array strJdl (Tabel)*/
    String[] strJdl = {"No.","SK","Tgl Mutasi"};
    DefaultTableModel tabModel;
    JTable tabel1 = new JTable();
    JScrollPane skrTabel1 = new JScrollPane();
    
    Formpenempatan()
    {
        /*super(Judul, UkuranFrame, TombolClose, TombolMaksimum, TombolMinimum)*/
        super("Form Penempatan", false, true, false, true);
        setSize(700, 700);
        jpTempat.setLayout (null);
        lblCatatgol.setHorizontalAlignment(JLabel.LEFT);
        /*Meletakan Objek Di Panel */
        lblCatatgol.setBounds(15, 15, 250, 30);
        lblnip.setBounds(70, 50, 100, 25);
        lblnamapeg.setBounds(70, 75, 100, 25);
        lblnogol.setBounds(70, 100, 120, 25);
        lblgapok.setBounds(70, 125, 120, 25);
        
        txtnip.setBounds(200, 50, 100, 25);
        txtnamapeg.setBounds(200, 75, 150, 25);
        txtnogol.setBounds(200, 100, 200, 25);
        txtgapok.setBounds(200, 125, 100, 25);
        
        lblsk.setBounds(50, 175, 150, 25);
        lbltglmutasi.setBounds(150, 175, 120, 25);
        
        txtsk.setBounds(50, 200, 90, 25);
        txttglmutasi.setBounds(150, 200, 170, 25);
        
        btnAddRinci.setBounds(570, 220, 110, 25);
        btnEditRinci.setBounds(570, 250, 110, 25);
        btnDeleteRinci.setBounds(570, 280, 110, 25);
        btnKosongRinci.setBounds(570, 310, 110, 25);
        btnExitRinci.setBounds(570, 340, 110, 25);
        
        /*Instansiasi Objek Tabel*/
        tabModel = new DefaultTableModel(null, strJdl);
        tabel1.setModel(tabModel);
        skrTabel1.getViewport().add(tabel1);
        tabel1.setEnabled(true);
        /*Batas Scroll Tabel */
        skrTabel1.setBounds(50, 225, 500, 150);
        /*Setting Listener Interaksi Terhadap Objek */
        focusLis fA1 = new focusLis();
        txtnip.addFocusListener(fA1);
        txtnogol.addFocusListener(fA1);
        actionLis aL1 = new actionLis();
        
        btnAddRinci.addActionListener (aL1);
        btnEditRinci.addActionListener(aL1);
        btnDeleteRinci.addActionListener(aL1);
        btnKosongRinci.addActionListener(aL1);
        btnExitRinci.addActionListener(aL1);
        /*Setting Kontrol Di Objek Panel */
        jpTempat.add(skrTabel1);
        jpTempat.add(lblCatatgol);
        jpTempat.add(lblnip);
        jpTempat.add(lblnamapeg);
        jpTempat.add(lblnogol);
        jpTempat.add(lblgapok);
        jpTempat.add(lblsk);
        jpTempat.add(lbltglmutasi);
        jpTempat.add(txtnip);
        jpTempat.add(txtnamapeg);
        jpTempat.add(txtnogol);
        jpTempat.add(txtgapok);
        jpTempat.add(txtsk);
        jpTempat.add(txttglmutasi);
        jpTempat.add(btnAddRinci);
        jpTempat.add(btnAddRinci);
        jpTempat.add(btnEditRinci);
        jpTempat.add(btnDeleteRinci);
        jpTempat.add(btnKosongRinci);
        jpTempat.add(btnExitRinci);
        
        getContentPane().add (jpTempat);
        AturAwal();
        setVisible (true);
    }
/*Metode lost focus utk objek txtnip*/
    class focusLis implements FocusListener{
        public void focusGained (FocusEvent fe)
        {
            
        }
        public void focusLost (FocusEvent fe)
        {
            if (fe.getSource()==txtnip)
            {
                if (txtnip.getText().equals(""))
                {
                    
                }
                else 
                {
                    CariPegawai();
                }
            }
            if (fe.getSource()==txtnogol)
            {
                if (txtnogol.getText().equals(""))
                {
                    
                }
                else 
                {
                    CariGolongan();
                }
            }
            if (fe.getSource()==txtsk)
            {
                if (txtsk.getText().equals(""))
                {
                    
                }
                else 
                {
                 CariTempat();   
                }
            }
        }
        
    }
    
/*Class Jika Klik tombol btton*/
    class actionLis implements ActionListener{
        public void actionPerformed (ActionEvent ae)
        {
            if (ae.getSource()== btnExitRinci)
            {
                AturAwal ();
            }
            if (ae.getSource()== btnAddRinci)
            {
                AddRinciTempat();
            }
            if (ae.getSource()== btnEditRinci)
            {
                EditRinciTempat ();
            }
            if (ae.getSource()== btnDeleteRinci)
            {
                DeleteRinciTempat ();
            }
            if (ae.getSource()== btnKosongRinci)
            {
                KosongRinci();   
            }
        }
    }
/*Mengatur awal Objek*/
    void AturAwal ()
    {
        /*Kosongkan Text*/
        txtnip.setText("");
        txtnamapeg.setText("");
        txtnogol.setText("");
        txtgapok.setText("");
        txtsk.setText("");
        txttglmutasi.setText("");
        txtnip.setEnabled(true);
        txtnamapeg.setEnabled(false);
        txtnogol.setEnabled(true);
        txtgapok.setEnabled(false);
        txtsk.setEnabled(true);
        txttglmutasi.setEnabled(true);
        
        /*Mengaktifkan Objek Button */
        btnAddRinci.setEnabled(true);
        btnEditRinci.setEnabled(true);
        btnDeleteRinci.setEnabled(true);
        btnKosongRinci.setEnabled(true);
        btnExitRinci.setEnabled(true);
        
        /*Bersihkan isi Tabel*/
        DeleteTabel();
        
        /*Memfokus ke Objek txtid */
        txtnip.requestFocus ();
    }
    /*Metode cari Pegawai diTabel Pegawai*/
    void CariPegawai ()
    {
        try {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "SELECT * FROM pegawai WHERE nip='"+txtnip.getText()+"'";
            ResultSet rs1 = st1.executeQuery(sql1);
            if(rs1.next())
            {
                txtnamapeg.setText (""+rs1.getString("namapeg"));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Pembeli Tidak Ada.");
            }
            rs1.close();
            con1.close();
        }
        catch (SQLException e)
        {
            
        }
    }
/*Metode Cari nogol di tabel Golongan*/
    void CariGolongan()
    {
        try {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "SELECT * FROM gol WHERE nogol='"+txtnogol.getText()+"'";
            ResultSet rs1 = st1.executeQuery(sql1);
            if (rs1.next())
            {
                txtgapok.setText(""+ rs1.getString("gapok"));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Golongan Tidak Ada.");
            }
            rs1.close();
            con1.close();
        }
        catch (SQLException e)
        {
            
        }
    }
    /*Metode Cari Penempatan Faktur di Tebel penempatan */
    void CariTempat()
    {
        try {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "SELECT * FROM penempatan WHERE sk ='"+txtsk.getText()+"'";
            ResultSet rs1 = st1.executeQuery(sql1);
            if(rs1.next())
            {
                txttglmutasi.setText(""+rs1.getString("tglmutasi"));
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Penempatan Tidak Ada");
            }
            rs1.close();
            con1.close();
            tampilketabel1();
        }
        catch (SQLException e)
        {
            
        }
    }
/*Metode Edit Data Tabel Penempatan */
    void EditRinciTempat()
    {
        try
        {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "UPDATE penempatan set tglmutasi='"+txttglmutasi.getText()+
                    "',nip='"+txtnip.getText()+"',nogol'"+txtnogol.getText()+
                    "',sk'"+txtsk.getText()+"' WHERE sk='"+txtsk.getText()+"' and nip ='"+
                    txtnip.getText()+"'";
            int rows1 = st1.executeUpdate(sql1);
            if (rows1 == 1)
                JOptionPane.showMessageDialog(this, "Rinci Penempatan Sudah di Edit.");
            con1.close();
            AktifRinci();
            tampilketabel1();
        }
        catch (SQLException e)
        {
            
        }
    }
     
    /*Metode Delete Di tabel Penempatan */
    void DeleteRinciTempat()
    {
        try 
        {
            Connect ObjKoneksi1 = new Connect();
            Connection con1 = ObjKoneksi1.OpenConnect();
            Statement st1 = con1.createStatement();
            String sql1 = "DELETE FROM penempatan WHERE tglmutasi='"+txttglmutasi.getText()+
                    "' and nip = '"+txtnip.getText()+"'";
            int rows1 = st1.executeUpdate(sql1);
            if (rows1 == 1)
                JOptionPane.showMessageDialog(this, "Rinci Sudah Dihapus");
            con1.close();
            tampilketabel1();
        }
        catch (SQLException e)
        {
            
        }
    }
    /*Metode Simpan Data Ke Tabel Penempatan */
    void AddRinciTempat()
    {
     try 
     {
         Connect ObjKoneksi1 = new Connect();
         Connection con1 = ObjKoneksi1.OpenConnect();
         Statement st1 = con1.createStatement();
         String sql1 = "INSERT INTO penempatan (tglmutasi, nip, nogol, sk) values ('"+txttglmutasi.getText()+
                 "','"+txtnogol.getText()+"','"+txtsk.getText()+"')";
         int rows1 = st1.executeUpdate(sql1);
         if (rows1 == 1)
             JOptionPane.showMessageDialog(this, "Data Tersimpan Ke Tabel Penempatan.");
         con1.close();
         tampilketabel1();
     }
     catch (SQLException e)
     {
         
     }
    }
/*Metode Mengaktifkan Objek Button Rinci*/
void AktifRinci()
{
btnAddRinci.setEnabled(true);
btnEditRinci.setEnabled(true);
btnDeleteRinci.setEnabled(true);
btnKosongRinci.setEnabled(true);
txttglmutasi.requestFocus();
}

/*Metode Menonaktifkan Objek Rinci */
void KosongRinci()
{
txttglmutasi.setText("");
txtnip.setText("");
txtnamapeg.setText("");
txtnogol.setText("");
txtgapok.setText("");
txtsk.setText("");
txttglmutasi.requestFocus();
}

/*Menampilkan Record Ke Tabel Penempatan */
void tampilketabel1()
{
try 
{ DeleteTabel();
Connect ObjKoneksi1 = new Connect();
Connection con1 = ObjKoneksi1.OpenConnect();
Statement st1 = con1.createStatement();
String sql1 = "SELECT penempatan.tglmutasi, penempatan.nip, penempatan.nogol, penempatan.sk from penempatan where tglmutasi='"+
txttglmutasi.getText()+"' and nip ='"+txtnip.getText()+"'";
ResultSet rs1 = st1.executeQuery(sql1);
while(rs1.next())
{
String sk = rs1.getString("sk");
String tglmutasi = rs1.getString("tglmutasi");
String [] data = {"",sk,tglmutasi};
tabModel.addRow(data);
resetNo();
}
rs1.close();
con1.close();
}
catch (Exception e)
{

}
}
/*Mengatur kembali penomoran tabel*/
void resetNo(){
    int brs1 = tabModel.getRowCount();
    for (int i=0;i<brs1;i++){
        String no1 = String.valueOf(i+1);
        tabModel.setValueAt(no1+".",i,0);
    }
}
/*Mengosongkan isi tabel */
void DeleteTabel()
{
    int brs1 = tabModel.getRowCount();
    for (int i=0; i<brs1; i++)
    {
        tabModel.removeRow(0);
    }
}
/*Metode Delete Di Tabel Penempatan */
void DeleteSemuaRinci()
{
    try
    {
        Connect ObjKoneksi1 = new Connect();
        Connection con1 = ObjKoneksi1.OpenConnect();
        Statement st1 = con1.createStatement();
        String sql1 = "DELETE from penempatan where tglmutasi='"+
                txttglmutasi.getText()+"' and nip ='"+txtnip.getText()+"'";
        int rows1 = st1.executeUpdate(sql1);
        if(rows1 == 1)
            JOptionPane.showMessageDialog(this, "Rinci Semua Penempatan Dihapus");
    con1.close();
    tampilketabel1();
    }
    catch (SQLException e)
    {
        
    }
}
}