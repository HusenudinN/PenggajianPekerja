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
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
import javax.swing.Timer;

/**
 *
 * @author Husen
 */
public class MenuUtama extends JFrame implements ActionListener{
    private JDesktopPane desktop1 = new JDesktopPane();
    /* Menu Pulldown */
    private JMenuBar barMenu1 = new JMenuBar();
    private JMenu mnuFileMaster = new JMenu("File Master"),
            mnuFileTransaksi = new JMenu("File Transaksi"),
            mnuReport = new JMenu("Laporan"),
            mnuExit = new JMenu("Keluar");
    private JMenuItem mnuFMPegawai = new JMenuItem("Data Pegawai", new ImageIcon ("image/pegawai.png")),
        mnuFMGol = new JMenuItem("Data Golongan", new ImageIcon ("image/gol.png")),
            mnuReturn1 = new JMenuItem("Kembali", new ImageIcon ("image/Back.png")),
            mnuFTPenempatan = new JMenuItem("Penempatan Golongan", new ImageIcon ("image/penempatan.png")),
            mnuFTGaji = new JMenuItem("Penggajian Pegawai", new ImageIcon("image/gaji.png")),
            mnuReturn2 = new JMenuItem("Kembali", new ImageIcon("image/Back.png")),
            mnuReportPegawai = new JMenuItem("Report Data Pegawai", new ImageIcon("image/rpegawai.png")),
            mnuReportGol = new JMenuItem("Report Data Golongan", new ImageIcon("image/rgol.png")),
            mnuReportGaji = new JMenuItem("Report Penggajian", new ImageIcon("image/rgaji.png")),
            mnuReturn3 = new JMenuItem("Kembali", new ImageIcon("image/Back.png")),
            mnuExit1 = new JMenuItem("Keluar", new ImageIcon("image/exit.png"));
    /* Menu PopUp */
    private JPopupMenu popMenu1 = new JPopupMenu();
    private JMenuItem mnuPopUp_FMPegawai = new JMenuItem("Data Pegawai", new ImageIcon ("image/pegawai.png")),
            mnuPopUp_FMGol = new JMenuItem("Data Golongan", new ImageIcon("image/gol.png")),
            mnuPopUp_FMReturn = new JMenuItem("Return", new ImageIcon("image/Back.png"));
    /* Menu ToolBar */
    private JToolBar toolBar1 = new JToolBar();
    private JPanel ToolbarPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT)),
                   ToolbarPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JButton mnuBtnFMPegawai = new JButton(new ImageIcon("image/pegawai.png")),
                    mnuBtnFMGol = new JButton(new ImageIcon("image/gol.png")),
                    mnuBtnFTPenempatan = new JButton(new ImageIcon("image/penempatan.png")),
                    mnuBtnFTGaji = new JButton(new ImageIcon("image/gaji.png")),
                    mnuBtnExit = new JButton(new ImageIcon("image/exit.png"));
    private JLabel lblwaktu1 = new JLabel();
    /* Pengakturan Waktu dan Tanggal */
    private Date tglsekarang = new Date();
    private SimpleDateFormat smpdfmt = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    private String tanggal1 = smpdfmt.format(tglsekarang);
    /* Pengaturan Status Bar */
    private JPanel StatusBar1 = new JPanel();
    private JLabel lblExit1 = new JLabel(" "+ "CopyRight Husenudin Nurdiansyah 2016",JLabel.LEFT),
            lblTgl1 = new JLabel(" "+tanggal1+" ",JLabel.RIGHT);
    /* Construktor Menu Utama */
    public MenuUtama()
    {
        /* Judul dan Icon Frame */
        super("Penggajian Pegawai");
        setIconImage(getToolkit().getImage("image/penggajian.png"));
        /* Pengaturan dan Lokasi frame di Layar */
        setSize(800, 600);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        /* Memberi Listener Untuk Tombol close isinya memanggil methode keluar */
        addWindowListener (new WindowAdapter(){
            public void windowClosing (WindowEvent we)
            {
                Keluar();
            }
        });
        /* Mengatur Tombol Hotkey (Alt+huruf */
        /* Hotkay Pada Menu Utama */
         mnuFileMaster.setMnemonic('M');
         mnuFileTransaksi.setMnemonic('T');
         mnuReport.setMnemonic('R');
         mnuExit.setMnemonic('X');
         
         /* Hot Key di Sub Menu File Master */
         mnuFMPegawai.setMnemonic ('P');
         mnuFMGol.setMnemonic('G');
         mnuReturn1.setMnemonic('u');
         
         /* Hot Key di Sub Menu File Transaksi */
         mnuFTPenempatan.setMnemonic ('T');
         mnuFTGaji.setMnemonic('A');
         mnuReturn2.setMnemonic('u');
         
         mnuReportPegawai.setMnemonic('P');
         mnuReportGol.setMnemonic ('G');
         mnuReportGaji.setMnemonic('A');
         mnuReturn3.setMnemonic('u');
         
         /* Shortcut di File master */
         mnuFMPegawai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
         mnuFMGol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, Event.CTRL_MASK));
         mnuReturn1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
         
         /* Shortcut di file transaksi */
         mnuFTPenempatan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
         mnuFTGaji.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
         mnuReturn2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
         
         /* Shortcut di Report */
         mnuReportPegawai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
         mnuReportGol.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, Event.CTRL_MASK));
         mnuReportGaji.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
         mnuReturn3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
         
         /* Shortcut di Exit */
         mnuExit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
         
         /* Mengatur Action Listener Pulldown Menu */
         mnuFMPegawai.addActionListener (this);
         mnuFMGol.addActionListener(this);
         mnuReturn1.addActionListener(this);
         mnuFTPenempatan.addActionListener(this);
         mnuFTGaji.addActionListener(this);
         mnuReturn2.addActionListener(this);
         mnuReportPegawai.addActionListener(this);
         mnuReportGol.addActionListener(this);
         mnuReportGaji.addActionListener(this);
         mnuReturn3.addActionListener(this);
         mnuExit1.addActionListener(this);
         
         /* Mengatur Sub Menu */
         mnuFileMaster.add (mnuFMPegawai);
         mnuFileMaster.add (mnuFMGol);
         mnuFileMaster.addSeparator();
         mnuFileMaster.add (mnuReturn1);
         mnuFileTransaksi.add (mnuFTPenempatan);
         mnuFileTransaksi.add (mnuFTGaji);
         mnuFileTransaksi.addSeparator();
         mnuFileTransaksi.add (mnuReturn2);
         mnuReport.add (mnuReportPegawai);
         mnuReport.add (mnuReportGol);
         mnuReport.add (mnuReportGaji);
         mnuFileMaster.addSeparator();
         mnuReport.add (mnuReturn3);
         mnuExit.add (mnuExit1);
         
         /* Mengatur bar Menu */
         setJMenuBar (barMenu1);
         
         /* Menambah Baris ke Menu bar */
         barMenu1.add (mnuFileMaster);
         barMenu1.add (mnuFileTransaksi);
         barMenu1.add (mnuReport);
         barMenu1.add (mnuExit);
         
         /* Mengatur Action Listener Pop-Up Menu */
         mnuPopUp_FMPegawai.addActionListener(this);
         mnuPopUp_FMGol.addActionListener(this);
         mnuPopUp_FMReturn.addActionListener(this);
         
         /* Menambah Sub menu PopUp ke Objek OpoUp */
         popMenu1.add (mnuPopUp_FMPegawai);
         popMenu1.add (mnuPopUp_FMGol);
         popMenu1.add (mnuPopUp_FMReturn);
         
         /*Mengatur addMouseListener pada waktu klik kanan popUp */
         addMouseListener(new MouseAdapter(){
             public void mousePressed  (MouseEvent me) {checkMouseTrigger (me);}
             public void mouseReleased (MouseEvent me) {checkMouseTrigger (me);}
             private void checkMouseTrigger (MouseEvent me){
                 if(me.isPopupTrigger())
                     popMenu1.show (me.getComponent(), me.getX(), me.getY());
         }
         });
         
         /*Mengatur ToolTip Mouse diatas objek */
         mnuBtnFMPegawai.setToolTipText("Data Pegawai");
         mnuBtnFMGol.setToolTipText("Data Golongan");
         mnuBtnFTPenempatan.setToolTipText("Penempatan Golongan");
         mnuBtnFTGaji.setToolTipText("Penggajian Pegawai");
         mnuBtnExit.setToolTipText("Exit");
         
         /*Mengatur AddActionListener sehingga Objek saat diklik mengerti*/
         mnuBtnFMPegawai.addActionListener (this);
         mnuBtnFMGol.addActionListener (this);
         mnuBtnFTPenempatan.addActionListener (this);
         mnuBtnFTGaji.addActionListener (this);
         mnuBtnExit.addActionListener (this);
         
         /*Meletakan Obek TollbarPanell, ToolbarPanel2 diletakan di Toolbar */
         toolBar1.add (ToolbarPanel1);
         toolBar1.add (ToolbarPanel2);
         
         /*Mengatur Baris Status */
         StatusBar1.setLayout (new BorderLayout());
         StatusBar1.setFont (new Font("Arial", Font.BOLD,10));
         
         /*Meletakan objek label ke baris status */
         StatusBar1.add (lblExit1, BorderLayout.WEST);
         StatusBar1.add(lblTgl1, BorderLayout.EAST);
         
         /*Mengatur Warna Latar Belakang*/
         desktop1.setBackground(Color.gray);
         
         /*Menambah isi container dengan objek toolbar, desktop dan statusBar*/
         getContentPane().add (toolBar1, BorderLayout.NORTH);
         getContentPane().add (desktop1, BorderLayout.CENTER);
         getContentPane().add (StatusBar1, BorderLayout.SOUTH);
         
         /*Memanggil (menjalankan) jam */
         setJam();
         
         /*Menampilkan Menu Utama ke Layar*/
         show();
    }

        /*Metode memeriksa objek yang mendapat Listener "addActionListener" */
        public void actionPerformed (ActionEvent ae){
            Object obj = ae.getSource();
            if(obj == mnuFMPegawai || obj == mnuPopUp_FMPegawai || obj == mnuBtnFMPegawai){
                Pegawai FMPegawai = new Pegawai();
                desktop1.add(FMPegawai);
                FMPegawai.show();
            }
            if(obj == mnuFMGol || obj == mnuPopUp_FMGol || obj == mnuBtnFMGol){
                /*Gol FMGol = new Gol();
                desktop.add(FMGol);
                FMGol.show();
                */
            }
            if (obj == mnuFTPenempatan || obj == mnuBtnFTPenempatan){
                /*belum diisi*/
            }
            if (obj == mnuFTGaji || obj == mnuBtnFTGaji){
                /*belum diis*/
            }
            if (obj == mnuReportPegawai){
                /*belum diisi*/
            }
            if (obj == mnuReportGol){
                /*belum diisi*/
            }
            if (obj == mnuReportGaji){
                /*belum diisi*/
            }
            if (obj == mnuReturn1 || obj == mnuReturn2 || obj == mnuReturn3 ||
                    obj == mnuPopUp_FMReturn){
                new MenuUtama();
            }
            if (obj == mnuExit1 || obj == mnuBtnExit){
                Keluar();
            }
        }
        /*Methode keluar dari sistem*/
        private void Keluar(){
            try {
                int reply = JOptionPane.showConfirmDialog (this,"Apakah Anda Yakin ?",
                        "Sistem Informasi - Terimakasih ", JOptionPane.YES_NO_CANCEL_OPTION, 
                        JOptionPane.PLAIN_MESSAGE);
                if (reply == JOptionPane.YES_OPTION){
                    setVisible(false);
                dispose();
                System.out.println("Terimakasih");
                System.out.println("HusenudinN");
                System.out.println("\n2016");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
                }
            }
            catch (Exception e){
                }    
            }
        /*Metode Setting Waktu System*/
        public void setJam(){
            ActionListener taskPerformer = new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    String nol_jam = "", nol_menit = "",nol_detik = "";
                    
                    Date dateTime = new Date();
                    int nilai_jam = dateTime.getHours();
                    int nilai_menit = dateTime.getMinutes();
                    int nilai_detik = dateTime.getSeconds();
                    
                    if (nilai_jam <= 9) nol_jam ="0";
                    if (nilai_menit <= 9) nol_menit ="0";
                    if (nilai_detik <= 9) nol_detik ="0";
                    
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                
                lblwaktu1.setText(jam + ":"+ menit +":"+detik +"");
                }
            };
            new Timer(1000, taskPerformer).start();   
            }
}
