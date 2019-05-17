/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefilter;
import imagefilter.arc.*;
import imagefilter.FilterARC;
import javax.imageio.*;
import java.net.URL;
import java.awt.*;
import java.io.*;
/**
 *
 * @author Administrator
 */
public class ImageFilter_Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Image img=null;
        try{
            img=ImageIO.read(new File("c:\\r1.jpg"));
       
        }catch(Exception e){
            e.printStackTrace();
        }
        Cut_average_diff cad=new Cut_average_diff(img);
        
        Image im=cad.process(10,10, 0.9);
        ImageFrame imFrame=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,im,"1");
        

        FilterOpt fopt = new FilterOpt(img);
    
        
        
     double[][] testOPT={
        {1.0/9,  1.0/9,    1.0/9},
        {1.0/9,  1.0/9,    1.0/9},
        {1.0/9,  1.0/9,    1.0/9}
    };
     double[][] testOPT2={
            {0.0,   0.0,    0.0,    0.0,    0.0 },
             {0.0,   0.0,    0.0,    0.0,    0.0},
             {0.0,   0.0,    1.0,    0.0,    0.0},
             {0.0,   0.0,    0.0,    0.0,    0.0},
             {0.0,   0.0,    0.0,    0.0,    0.0}
     };
           Image outputOpt=fopt.processByOpt(testOPT);//红灰
     
           ImageFrame imFrame1=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputOpt,"测试opt");
      
     
       /*
        Image outputOpt1=fopt.processByOpt(FilterOpt.OPT2);
        Image outputOpt2=fopt.processByOpt(FilterOpt.OPT3);
        Image outputOpt3=ImageTool.plus(outputOpt1, outputOpt2);
        Image outputOpt4=fopt.processByOpt(FilterOpt.OPT22);
        Image outputOpt5=ImageTool.plus(outputOpt3, outputOpt4);
        Image outputOpt6=fopt.processByOpt(FilterOpt.OPT33);
        Image outputOpt7=ImageTool.plus(outputOpt5, outputOpt6);
        
        FilterARC farc=new FilterARC(outputOpt);
        Image outputARCImage=farc.processbyARC(new ARC_gradient(125), 1);//用
        
        FilterARC farc2=new FilterARC(outputOpt7);
        Image outputARCImage2=farc2.processbyARC(new ARC_gradient(40), 1);
        
        Image Image1_2 = ImageTool.plus(outputARCImage, outputARCImage2);

*/
        
        
// Image img255=ImageTool.image255(outputOpt.getWidth(null), outputOpt.getHeight(null));
        
       // Image outputOpt8=ImageTool.minus(img255, outputOpt7);
      //  Image outputOpt8=ImageTool.plus(outputARCImage2, outputOpt);
        
       // ImageFrame imFrame=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,img,"原图像");
 
    //  ImageFrame imFrame2=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputOpt,"红色灰度");
/* 
         //ImageFrame imFrame6=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputARCImage,"红色灰度");
       // ImageFrame imFrame3=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputOpt3,"单次求和1");
       // ImageFrame imFrame4=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputOpt5,"高等求和2");
      //  ImageFrame imFrame5=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputOpt7,"高等求和3");
       ImageFrame imFrame6=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputARCImage,"arc图像");
       ImageFrame imFrame7=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,outputARCImage2,"outputARCImage2");
       ImageFrame imFrame8=new ImageFrame(img.getWidth(null)/2,img.getHeight(null)/2,Image1_2,"Image1_2");
*/
    }
    
}
