/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arc;

/**
 *
 * @author Administrator
 */


public class ARC_gradient implements ARC{
    //ps中测试的107 111阀值二值化代码实现
    int threshold=0;
     public ARC_gradient(int threshold){
        this.threshold=threshold;
     }
    @Override
    public double process(int num) {
        //To change body of generated methods, choose Tools | Templates.
        if(num<=threshold)
            num=0;
        if(num>=threshold)
            num=254;
        
        return num+0.0;
    }
    
}
