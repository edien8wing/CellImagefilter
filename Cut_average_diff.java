/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefilter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Administrator
 */
public class Cut_average_diff {
    BufferedImage img;
    Graphics g;
    int per_width;
    int per_height;
    BufferedImage backImg;
    int sumWhite=0;
    public Cut_average_diff(Image img){
        this.img=(BufferedImage)img;
        backImg=new BufferedImage(this.img.getWidth(),this.img.getHeight(),BufferedImage.TYPE_INT_RGB);
        g=this.backImg.getGraphics();
        
    }
    public BufferedImage process(int x,int y,double percent){
        per_width=this.img.getWidth()/x;
        per_height=this.img.getHeight()/y;
        
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                 //System.out.println(i+" " +j);
                processlittleImage(i,j,percent);
               
            }
        }
        int sum=this.img.getWidth()*this.img.getHeight();
        System.out.println("计算完成：");
        System.out.println("所有点:"+sum);
        System.out.println("记录点:"+this.sumWhite);
        System.out.println("点概率:"+(this.sumWhite+0.0)/sum);
        return backImg;
    }
    private void processlittleImage(int x,int y, double percent){
        //所有红色合计数
        double sumCol=0.0;
         for(int i=0;i<this.per_width;i++){
             for(int j=0;j<this.per_height;j++){
                 int width=this.per_width*x+i;
                 int height= this.per_height*y+j;
                //System.out.println(width+" "+height);
                 sumCol=sumCol+new Color(this.img.getRGB(width, height)).getRed();
             }
         }
         double average =sumCol/per_width/per_height;
         //System.out.println(average);
         for(int i=0;i<this.per_width;i++){
             for(int j=0;j<this.per_height;j++){
                 int width=this.per_width*x+i;
                 int height= this.per_height*y+j;
                 int c=new Color(this.img.getRGB(width, height)).getRed();
                   // 
                    if(c*percent>average){
                        //System.out.println(width+" "+height+" "+c+" "+average);
                        this.sumWhite++;
                        g.setColor(Color.white);
                        g.drawLine(width, height, width, height);
                    }
             }
         }
    }
}
