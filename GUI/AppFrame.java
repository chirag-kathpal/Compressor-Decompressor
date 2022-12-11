/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.mycompany.compressordecompressor.CompDecom.Compressor;
import com.mycompany.compressordecompressor.CompDecom.Decompressor;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author chira
 */
public class AppFrame extends JFrame implements ActionListener {
    JButton compressbutton;
    JButton decompressbutton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressbutton=new JButton("Select File to Compress");
        compressbutton.addActionListener(this);
        compressbutton.setBounds(135,50,200,30);
        
        decompressbutton=new JButton("Select File to Decompress");
        decompressbutton.addActionListener(this);
        decompressbutton.setBounds(135,150,200,30);
        
        this.add(compressbutton);
        this.add(decompressbutton);
        this.setSize(500,300);
        this.setTitle("Compressor-Decompressor");
        this.getContentPane().setBackground(new Color(123,50,250));
        this.setVisible(true);
        this.setResizable(false);
        
        ImageIcon image=new ImageIcon("logo.png");
        this.setIconImage(image.getImage());
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressbutton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
            
        }
        
        if(e.getSource()==decompressbutton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }
}
