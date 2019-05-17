/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefilter;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author Administrator
 */
public class ImageTool {
    public static Image plus(Image a,Image b){
     BufferedImage a1 =(BufferedImage)a;
     BufferedImage b1 =(BufferedImage)b;
     //定义新图片
     BufferedImage bi=new BufferedImage(a1.getWidth(null),a1.getHeight(null),BufferedImage.TYPE_INT_RGB);
     Graphics g = bi.getGraphics();
     for(int i=0;i<a1.getWidth(null);i++){
         for(int j=0;j<a1.getHeight(null);j++){
             Color ac=new Color(a1.getRGB(i, j));
             Color bc=new Color(b1.getRGB(i, j));
             int sum=ac.getRed()+bc.getRed();
             if(sum>254)sum=254;
             if(sum<0)sum=0;
             Color sumColor=new Color(sum,sum,sum);
             g.setColor(sumColor);
             g.drawLine(i,j,i,j);
         }
     }
     
     return bi;
    }
    
     public static Image minus(Image a,Image b){
        BufferedImage a1 =(BufferedImage)a;
        BufferedImage b1 =(BufferedImage)b;
        //定义新图片
        BufferedImage bi=new BufferedImage(a1.getWidth(null),a1.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        for(int i=0;i<a1.getWidth(null);i++){
            for(int j=0;j<a1.getHeight(null);j++){
                Color ac=new Color(a1.getRGB(i, j));
                Color bc=new Color(b1.getRGB(i, j));
                int sum=ac.getRed()-bc.getRed();
                if(sum>254)sum=254;
                if(sum<0)sum=0;
                Color sumColor=new Color(sum,sum,sum);
                g.setColor(sumColor);
                g.drawLine(i,j,i,j);
            }
        }

        return bi;
    }
     public static Image image255(int width,int height){
         BufferedImage a= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
         Graphics g = a.getGraphics();
         for(int i=0;i<width;i++){
             for(int j=0;j<height;j++){
                 g.setColor(new Color(255,255,255));
                 g.drawLine(i,j,i,j);
             }
         }
         return a;
     }
     public static Image image0(int width,int height){
          BufferedImage a= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
          Graphics g = a.getGraphics();
         for(int i=0;i<width;i++){
             for(int j=0;j<height;j++){
                 g.setColor(new Color(0,0,0));
                 g.drawLine(i,j,i,j);
             }
         }
          return a;
     }
}
