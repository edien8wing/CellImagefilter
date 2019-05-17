/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagefilter;
import java.awt.*;
/**
 *
 * @author Administrator
 */
public class ImageFrame extends Frame{
    private int height=0;
    private int width=0;
    Image img=null;
    ImgCanvas can=null;
    public ImageFrame(int width,int height,Image img,String title){
        super();
        this.setTitle(title);
        this.setVisible(true);
        this.width=width;
        this.height=height;
        this.img=img;
        
        init();
    }
    private void init(){
        this.setBounds(10,10, width, height);
        can=new ImgCanvas(width,height,img);
        can.setSize(width,height);
        this.add(can);
        Graphics g= this.getGraphics();
        can.paint(g);
       

    }
    class ImgCanvas extends Canvas{
        private int width=0;
        private int height=0;
        private Image img=null;
        public ImgCanvas(int width,int height,Image img){
            super();
            this.width=width;
            this.height=height;
            this.img=img;

        }
        public void paint(Graphics g2){
            //System.out.println(img.toString());
            g2.drawImage(img, 0, 0, width, height, this);
        }
    }
    
}
