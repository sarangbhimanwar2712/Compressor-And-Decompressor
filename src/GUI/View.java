/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import CodeFiles.Compress ;
import CodeFiles.Decompress ;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class View extends JFrame implements ActionListener {
    
    JButton CompressButton ;
    JButton DecompressButton ;
    
    View(){
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);
      
      CompressButton = new JButton("Select to Compress");
      CompressButton.setBounds(20,200,200,30) ;
      CompressButton.addActionListener(this);

      DecompressButton = new JButton("Select to Decompress");
      DecompressButton.setBounds(250,200,200,30) ;
      DecompressButton.addActionListener(this);

      
      this.add(CompressButton) ;
      this.add(DecompressButton) ;
      
      this.setSize(500,300);
      this.getContentPane().setBackground(Color.DARK_GRAY);
    }
    
    public static void main(String [] args)
    {
        View view = new View () ;
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== CompressButton) 
        {
             JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Compress.compressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());

                }
            }
        }
        if(e.getSource()== DecompressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    Decompress.decompressFunction(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
}