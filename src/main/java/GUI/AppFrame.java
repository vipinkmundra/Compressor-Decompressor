/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Compressor.Compressor;
import Compressor.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author VIPIN
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //setting a default operation performed when we click on close
        this.setLayout(null);                                   //setting the layout of frame
        this.setTitle("Compressor and Decompressor");            //setting the title of frame
        ImageIcon icon = new ImageIcon("blog.jpg");           //converting the image into icon
        this.setIconImage(icon.getImage());                     //setting the icon in the frame
        
        compressButton = new JButton("Select File To Compress"); //setting the title of button
        compressButton.addActionListener(this);                    //adding the event listener on button 
        compressButton.setBounds(20,100,200,30);      //setting the boundry of button
        
        decompressButton = new JButton("Select File To Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,500);
        this.getContentPane().setBackground(new Color(20,100,55)); //setting the background color of frame
        this.setVisible(true);                                          //setting the visibility of frame to true
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compressor.method(file);
                }catch(Exception excp1){
                    JOptionPane.showMessageDialog(null,excp1.toString());
                }
            }
        }
        
        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                try{
                    Decompressor.method(file);
                }catch(Exception excp2){
                    JOptionPane.showMessageDialog(null,excp2.toString());
                }
            }
        }
    }
    
}
