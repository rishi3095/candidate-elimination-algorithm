/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concept_Learning;

/**
 *
 * @author Sriram
 */
public class Hypothesis {
    public String[] AttributeList = {"Sky","AirTemp","Humidity","Wind","Water","ForeCast"};
    String[] Sky_values = {"Sunny","Cloudy","Rainy"};
    String[] AirTemp_values = {"Warm","Cold"};
    String[] Humidity_values = {"Normal","High"};
    String[] Wind_values = {"Strong","Weak"};
    String[] Water_values = {"Warm","Cool"};
    String[] ForeCast_values = {"Same","Change"};
    String[][] Values = {Sky_values, AirTemp_values,Humidity_values,Wind_values,Water_values,ForeCast_values};
  
    boolean consistent(TrainingData ex)
    {
     int flag = 0;
    
     for(int i=0;i<AttributeList.length;i++)
     {
      if(ex.EnjoySport==true)
      {
      if( !AttributeList[i].equals("all")&& !AttributeList[i].equals(ex.attr.AttributeList[i]))
          return false;
     }
     else
      {
          if( (AttributeList[i].equals("all")|| AttributeList[i].equals(ex.attr.AttributeList[i])))
          {
              flag++;
          }
     
      }
       
    }if(flag==AttributeList.length)
          return false;
     
     return true;
     }
    boolean moreGeneralThan(Hypothesis attr)
    {
    	
     int flag=0;
     
     for(int i=0;i<AttributeList.length;i++)
      {
       if(this.AttributeList[i].equals(attr.AttributeList[i]))
           flag++;
      }
     if(flag==AttributeList.length)
         return false;

     if(attr.AttributeList[0].equals("null"))
         return true;
     
     flag=0;
     
     for(int i=0;i<AttributeList.length;i++)
     {   
        
      if((this.AttributeList[i].equals("all") && !(this.AttributeList[i].equals(attr.AttributeList[i]))))
            flag++;//System.out.printf("%d ",++flag);
      else if(this.AttributeList[i].equals(attr.AttributeList[i]))
            flag++;//System.out.printf("%d ",++flag);
     }
    
     if(flag==AttributeList.length){
    	 return true; 
     }
     else 
    	 {
    	 	return false;
    	 }
    }
    public boolean isEqualTo(Hypothesis h)
    {
        boolean equal = true;
        for(int i=0;i<this.AttributeList.length;i++)
        {
            if(!this.AttributeList[i].equals(h.AttributeList[i]))
            {
                equal = false;
                break;
            }
        }
        return equal;
    }
}