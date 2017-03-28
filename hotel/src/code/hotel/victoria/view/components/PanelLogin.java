/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.view.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author RolaQ
 */
public class PanelLogin extends JPanel{
    public Image imagenfondo;
    
    @Override
    public void paintComponent(Graphics g){
        Dimension dimen = getSize();
        ImageIcon imagen=new ImageIcon(new ImageIcon(getClass().
                getResource("/code/hotel/victoria/view/resources/Login.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, dimen.width,dimen.height,this);
    }
}
