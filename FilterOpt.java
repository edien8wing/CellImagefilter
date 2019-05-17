/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author Administrator
 */
public class FilterOpt {
      BufferedImage bi=null;
    public FilterOpt(Image img){
        BufferedImage bi=(BufferedImage)img;
        this.bi=bi;
    }
    public static double[][] OPT1={
        {0.0,0.0,0.0},
        {0.0,1.0,0.0},
        {0.0,0.0,0.0}
    };
     public static double[][] OPT2={
        {-1.0,0.0,1.0},
        {-2.0,0.0,2.0},
        {-1.0,0.0,1.0}
    };
   public static double[][] OPT22={
        {1.0,0.0,-1.0},
        {2.0,0.0,-2.0},
        {1.0,0.0,-1.0}
    };
     public static double[][] OPT3={
        {-1.0,-2.0,-1.0},
        {0.0,0.0,0.0},
        {1.0,2.0,1.0}
    };
     public static double[][] OPT33={
        {1.0,2.0,1.0},
        {0.0,0.0,0.0},
        {-1.0,-2.0,-1.0}
    };
     
    public static double[][] OPT11={
        {0.0,0.0,0.0},
        {0.0,1.0,0.0},
        {0.0,0.0,0.0}
    };
     public static double[][] OPT12={
        {-1.0,0.0,1.0},
        {-2.0,0.0,2.0},
        {-1.0,0.0,1.0}
    };
   public static double[][] OPT122={
        {1.0,0.0,-1.0},
        {2.0,0.0,-2.0},
        {1.0,0.0,-1.0}
    };
     public static double[][] OPT13={
        {-1.0,-2.0,-1.0},
        {0.0,0.0,0.0},
        {1.0,2.0,1.0}
    };
     public static double[][] OPT133={
        {1.0,2.0,1.0},
        {0.0,0.0,0.0},
        {-1.0,-2.0,-1.0}
    };

    
    
    /*对图像进行opt卷积核运算，
    对于小于0的位置和大于widht，height的位置进行反向运算
    so:bi.getrgb(-1,-1)=bi.getrgb(1,1);
    */
    public Image processByOpt(double[][] opt){
        BufferedImage answer = new BufferedImage(bi.getWidth(),bi.getHeight(),bi.TYPE_INT_RGB);
        Graphics g=answer.getGraphics();
       
        for(int i=0;i<bi.getWidth();i++){
            for(int j=0;j<bi.getHeight();j++){
                double nColor=calculate_opt(i,j,opt);
                g.setColor(new Color((int)nColor,(int)nColor,(int)nColor));
               // System.out.println(i+" "+j+" "+nColor);
                g.drawLine(i, j, i, j);
            }
        }
        g.dispose();
        return answer;
    }
    //计算函数
    private double calculate_opt(int current_width,int current_height,double[][] opt){
        int middle_opt=opt.length/2;
        double answer=0.0;
        double sum=0.0;
        for(int i=0;i<opt.length;i++){
            for(int j=0;j<opt[0].length;j++){
                sum=sum+opt[i][j]*getRGB(current_width-middle_opt+i,current_height-middle_opt+j,1);
            }
        }
        if(sum>254)
            sum=254;
        if(sum<0)
            sum=0;
        answer=sum;
        return answer;
    }
    /*
    type:R=1
    G=2
    B=3
    average=4
    */
    private double getRGB(int width,int height,int type){
        double answer=0.0;
        int width1=Math.abs(width);
        int height1=Math.abs(height);
        int width2=width1;
        int height2=height1;
        if(width1>=this.bi.getWidth()){
             width2=bi.getWidth()-(width1-bi.getWidth())-1;
        }
        if(height1>=this.bi.getHeight()){
             height2=bi.getHeight()-(height1-bi.getHeight())-1;
        }
        //System.out.println(width+" "+height);
        Color c=null;
        try{
        double rgb=this.bi.getRGB(width2, height2);
         c= new Color((int)rgb);
        }catch(Exception e){
         
         System.out.println("Excepiont:");
         System.out.println("上限数据:"+bi.getWidth()+" "+bi.getHeight());
         System.out.println("原数据:"+width+" "+height);
         System.out.println("最终"+width2+" "+height2);
        }

        
        double red=(double)c.getRed(); 
        
        double green=(double)c.getGreen();
        double blue=(double)c.getBlue();
        
        switch(type){
                case 1:answer=red; break;
                case 2:answer=green;break;
                case 3:answer=blue;break;
                case 4:answer=(red+green+blue)/3;break;
        }
       // System.out.println(width+" "+height+" "+answer);
        return answer;
    }
}
