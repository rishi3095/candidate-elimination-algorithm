/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concept_Learning;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sriram
 */
public class ReadFromFile {
    
    //FileInputStream in = null;
    File file = null;
    FileReader fr = null;
    BufferedReader br = null;
  public void initialize(){
    //FileInputStream in = new FileInputStream("/home/admin/Downloads/CoalImages/cameraData.txt");
       try{
           
           file = new File("C:\\Users\\Sriram\\Documents\\NetBeansProjects\\CandidateElimination\\TrainingData.txt");
           
           fr = new FileReader(file);
           
           br = new BufferedReader(fr);
       }catch(FileNotFoundException e){e.printStackTrace();}
   }
    String[] result;
    boolean takeNextValue(TrainingData ex)
    {  
     try{
       String str = br.readLine();
       if(str == null)
           return false;
       result = str.split(" ");
       int i;
       for(i=0;i<(result.length)-1;i++)
       {
        ex.attr.AttributeList[i]=result[i];
       }
       if(result[i].equals("yes"))
           ex.EnjoySport = true;
       else
           ex.EnjoySport = false;
    }catch(IOException e){e.printStackTrace();}
     return true;
    }
}
