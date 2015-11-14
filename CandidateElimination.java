/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Concept_Learning;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class CandidateElimination {

    /**
     * @param args the command line arguments
     */   
   public ArrayList<Hypothesis> G;
   public ArrayList<Hypothesis> S;
   ArrayList<Hypothesis> minspec = null;
   Hypothesis mingen = null;
   ArrayList<Hypothesis> rvs;
   CandidateElimination(){
   
     G = new ArrayList<Hypothesis>();
     S = new ArrayList<Hypothesis>();
     rvs = new ArrayList<Hypothesis>();
     Hypothesis G0 = new Hypothesis();
     
    for(int i=0;i<G0.AttributeList.length;i++)
          G0.AttributeList[i] = "all";
        
        G.add(G0);
        Hypothesis S0 = new Hypothesis();
    for(int i=0;i<S0.AttributeList.length;i++)
        S0.AttributeList[i]="null";
        S.add(S0);
   }
public void positiveEncounter(TrainingData ex)
{
    Hypothesis attr = null;
    
   for(int i=0;i<G.size();i++)
   {
       attr = G.get(i);
       if(!attr.consistent(ex)){
    	   G.remove(attr);
    	   i--;
       }
           
   }
  
   
   for(int j=0;j<S.size();j++)
   {
      attr = S.get(j);
     if(!attr.consistent(ex))
      {
    	 minimalGeneralization(attr,ex);
    	 S.add(mingen);
    	 S.remove(attr);
      }
   }
}
public void negativeEncounter(TrainingData ex)
{
   Hypothesis attr = null;
   
  for(int i=0;i<S.size();i++)
  {
    attr = S.get(i);
   if(!attr.consistent(ex))
    {
     
        S.remove(attr); 
    }
  }
  for(int j=0;j<G.size();j++)
   {
      attr = G.get(j);
     
     if(!attr.consistent(ex))
      {
        minimalSpecialization(attr,ex);
        G.remove(attr);
       
        if(!minspec.isEmpty())
        {
        for(int k=0; k < minspec.size(); k++)
        {  
          G.add(minspec.get(k));
        }
        }
      }
   }
}
     
        
     
    

void minimalGeneralization(Hypothesis attr1,TrainingData ex1)
{
	mingen = new Hypothesis();
   for(int i=0;i<attr1.AttributeList.length;i++)
   {
    if(attr1.AttributeList[i].equals("null"))
        mingen.AttributeList[i] = ex1.attr.AttributeList[i];
    
    else if(!attr1.AttributeList[i].equals(ex1.attr.AttributeList[i]))
        mingen.AttributeList[i] = "all";
    else if(attr1.AttributeList[i].equals(ex1.attr.AttributeList[i]))
    		mingen.AttributeList[i] = ex1.attr.AttributeList[i];
    else if(attr1.AttributeList[i].equals("all"))
    		mingen.AttributeList[i] = "all";
    
   }
    
   for(int i=0;i<G.size();i++)
   {
      if(!mingen.moreGeneralThan(G.get(i)))
      {
    	  return;
      }
        
   }
   mingen = null;
}

void minimalSpecialization(Hypothesis attr, TrainingData ex)
{
  Hypothesis attr1 = null;
  minspec = new ArrayList<Hypothesis>();
  int flag=0;
  Hypothesis attr2;
  for(int i=0;i<attr.AttributeList.length;i++)
  {
	  if(attr.AttributeList[i].equals("all"))
	  {
		  for(int j=0;j<attr.Values[i].length;j++)
		  {
			  attr1 = new Hypothesis();
			  for(int k=0;k<attr1.AttributeList.length;k++)
			  {
				  attr1.AttributeList[k]=attr.AttributeList[k];
			  }
			  attr1.AttributeList[i]=attr1.Values[i][j];
			  if(attr1.consistent(ex))
			  {
				  for(int r = 0 ;r <S.size();r++)
			         {
					  	 flag=0;
			             attr2 = S.get(r);
			             if(attr1.moreGeneralThan(attr2))
			             {
			                 flag = 1;
			                 break;
			             }
			             
			             //System.out.println(flag);
			         }
			         //System.out.println(flag);
			         if(flag==1)
			             minspec.add(attr1);
			  }
			  
		  }
	  }
		  
  }
  
}
public void display()
{
    System.out.println("the general boundary is : ");
    //System.out.println(G.size());
   for(int i=0;i<G.size();i++)
   {
       for(int j=0;j<G.get(i).AttributeList.length;j++)
       {
           System.out.printf("%s  ",G.get(i).AttributeList[j]);
       }
       System.out.println();
   }
   
   System.out.println("the specific boundary is : ");
   for(int i=0;i<S.size();i++)
   {
       for(int j=0;j<S.get(i).AttributeList.length;j++)
       {
           System.out.printf("%s  ",S.get(i).AttributeList[j]);
       }
       System.out.println();
   }
}

public void getVersionSpace()
{
   Hypothesis obj =null;
   //ArrayList<Integer> atr = null;
  
   for(Hypothesis attr1 : G)
   {
       for(Hypothesis attr2 : S)
       {
           if(attr1.moreGeneralThan(attr2))
           {
               for(int i=0;i<attr1.AttributeList.length;i++)
               {
                  if (attr1.AttributeList[i].equalsIgnoreCase("all") &&  !(attr1.AttributeList[i].equalsIgnoreCase(attr2.AttributeList[i])) && !attr2.AttributeList[i].equalsIgnoreCase("null"))
                  {
                      obj = new Hypothesis();
                      for(int j=0;j<obj.AttributeList.length;j++)
                      {
                          if(j!=i)
                              obj.AttributeList[j]=attr1.AttributeList[j];
                          else
                              obj.AttributeList[j]=attr2.AttributeList[j];
                      }
                      rvs.add(obj);
                  }   
                 if(attr2.AttributeList[i].equalsIgnoreCase("null"))
                 {
                     for(int k = 0 ; k<attr2.Values[i].length;k++)
                     {
                      obj = new Hypothesis();
                      for(int j=0;j<obj.AttributeList.length;j++)
                      {
                          if(j!=i)
                              obj.AttributeList[j]=attr1.AttributeList[j];
                          else
                              obj.AttributeList[j]=attr2.Values[i][k];
                      }
                      rvs.add(obj);   
                     }
                 }
               }
           }
       }
   }
   for(int i=0;i<rvs.size();i++)
   {
    for(int j = 0;j<rvs.size();j++)
     {
         if(i != j)
         {
          if(rvs.get(i).isEqualTo(rvs.get(j)))
          {
             rvs.remove(rvs.get(i));
          }
         }
     }
   }
   for(Hypothesis h : rvs)
   {
       for(int i=0;i<h.AttributeList.length;i++)
           System.out.printf("%s ",h.AttributeList[i]);
       System.out.println();
   }
}
}


