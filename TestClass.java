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

public class TestClass {
    
    
    public static void main(String[] args){
       
        CandidateElimination ce = new CandidateElimination();
        TrainingData ex = new TrainingData();
        ReadFromFile rff = new ReadFromFile();
        rff.initialize();
        while(rff.takeNextValue(ex))
        {
            if(ex.EnjoySport==true)
                ce.positiveEncounter(ex);
            else
                ce.negativeEncounter(ex);
        }
        try{
        rff.br.close();
        }catch(Exception e){e.printStackTrace();}
        ce.display();
        System.out.println("the version space is : ");
        ce.getVersionSpace();
    }
}
