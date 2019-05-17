/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefilter;

import imagefilter.arc.ARC;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Administrator
 */
public class FilterARC {
    BufferedImage img=null;
    public FilterARC(Image img){
        this.img=(BufferedImage)img;
    }
    
   /*
    arc是实现了arc.process的曲线算法
    type是计算通道 灰度图所有通道都一样
    type:R=1
    G=2
    B=3
    */
    public Image processbyARC(ARC arc,int type){
        BufferedImage bi = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        for(int i=0;i<img.getWidth();i++){
            for(int j=0;j<img.getHeight();j++){
                int col=0;
                switch (type){
                    case 1:col=new Color(img.getRGB(i, j)).getRed();break;
                    case 2:col=new Color(img.getRGB(i, j)).getGreen();break;
                    case 3:col=new Color(img.getRGB(i, j)).getBlue();break;
                }
                
                double backCol=arc.process(col);
                Color c=new Color((int)backCol,(int)backCol,(int)backCol);
                g.setColor(c);
                g.drawLine(i, j, i, j);
            }
        }
        return bi;
    }

}
