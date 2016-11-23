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
import javax.swing.border.LineBorder;
        
public class Main extends JWindow{
    private Dimension dimensi1 = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel labelLogo1 = new JLabel(new ImageIcon("image/Main/Logo Utama.JPG"));
    private JProgressBar barisProgres1 = new JProgressBar();
    private int time1 = 0;
    private Timer timer1;
    
    
public Main ()
{
    Color Warna = Color.blue;
    barisProgres1.setValue(0);
    barisProgres1.setPreferredSize(new Dimension(100,15));
    barisProgres1.setBackground(Color.white);
    barisProgres1.setBackground(Color.cyan);
    barisProgres1.setStringPainted(true);
    barisProgres1.setBorder(new LineBorder(Warna,1));
    labelLogo1.setBorder(new LineBorder(Warna,1));
    getContentPane().add(labelLogo1,BorderLayout.NORTH);
    getContentPane().add(barisProgres1,BorderLayout.CENTER);
    timer1 = new Timer(50, new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            time1++;
            barisProgres1.setValue(time1);
            if(barisProgres1.getPercentComplete()==1.0)
            {
                timer1.stop();
                setVisible(false);
                new MenuUtama(); 
            }
        }
    });
    
    timer1.start();
    pack();
    setLocation(dimensi1.width / 2 - getWidth() / 2, dimensi1.height / 2 - getHeight() / 2);
    show();
}
public static void main (String args[]){
    new Main();
}
      
}
