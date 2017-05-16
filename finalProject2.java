import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class finalProject2 {
	
	public static void printHeading()
	{
		System.out.println("Michael Livingston");
		System.out.println("CMSC401 Final Project");
		System.out.println("Put FileName as command line argument");

	}

	//Program takes one command line argument of file input
    //output file: out.cpn.txt
		public static void main(String args[]) throws FileNotFoundException 
		{
			printHeading();
			try{
				BufferedWriter bw = null;

			FileWriter fw = new FileWriter("cnp.out.txt"); //change to command line 
			bw = new BufferedWriter(fw);
		
			// Scanner in = new Scanner(new FileReader("cpnIn.txt"));
			Scanner in = new Scanner(new FileReader(args[0])); //change to command line argument 
			String firstLine = in.nextLine().trim();
			
			//collect info from first line
			String [] splitFirst= firstLine.split(" ");
			int nodes = Integer.parseInt(splitFirst[0]); 
			int edges = Integer.parseInt(splitFirst[1]);
			int k = Integer.parseInt(splitFirst[2]);
			
			//initialize arrays to collect data
			ArrayList<ArrayList<Integer>> t2darr = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> firstColumn = new ArrayList<Integer>();
			ArrayList<Integer> secondColomn= new ArrayList<Integer>();
			String [] splitRest={};
			String nextLine="";
		    int [][] nodeDegreeArr = new int [nodes+1][2]; 
			ArrayList<Integer> degrees = new ArrayList<Integer>();

			//go through file and get the degrees/number of occurrences of the vertex number
			while(in.hasNextLine())
			{
				nextLine = in.nextLine().trim();
				splitRest= nextLine.split(" ");
				int firstRow = Integer.parseInt(splitRest[0]);
				int secondRow = Integer.parseInt(splitRest[1]);
				//add to single arrays to add to 2-d array
				firstColumn.add(firstRow);
				secondColomn.add(secondRow);
				
				//find degrees of each vertex
				nodeDegreeArr[firstRow][1] += 1;
				nodeDegreeArr[secondRow][1] += 1;				
			}
			//add to 2d array list for later 
			  t2darr.add(firstColumn);
			  t2darr.add(secondColomn);
			  
			  	//calculate the max degrees
				int max = 0;
				for(int i=1;i<nodeDegreeArr.length;i++)
				{

					nodeDegreeArr[i][0] = i; 
					if(nodeDegreeArr[i][1]>max)
					{
						max = nodeDegreeArr[i][1];
					}
					if(!(degrees.contains(nodeDegreeArr[i][1])))
					{
						  degrees.add(nodeDegreeArr[i][1]);
					}
					
				}
				
				//sort degrees from least to most 
				Collections.sort(degrees);
				int tempk1 =1;
				ArrayList<Integer> maxNodes = new ArrayList<Integer>();

				//adding the nodes with the max degrees
				for(int i=1;i<nodeDegreeArr.length;i++)
				{	

					if(nodeDegreeArr[i][1]== degrees.get(degrees.size()-1)&& tempk1<=k)
					{
						maxNodes.add(nodeDegreeArr[i][0]);
						tempk1= tempk1+1;
					}
				
				}
				
				//if there were less than given k nodes , look at the second most degree vertices
				//look at top 5 max degrees nodes if necessary 
				if(tempk1<k)
				{
					for(int i=1;i<nodeDegreeArr.length;i++)
					{	
						if(nodeDegreeArr[i][1]== degrees.get(degrees.size()-2)&& tempk1<=k)
						{
							maxNodes.add(nodeDegreeArr[i][0]);
							tempk1= tempk1+1;
						}
					
					}
				}
				
				if(tempk1<k)
				{
					for(int i=1;i<nodeDegreeArr.length;i++)
					{	
						if(nodeDegreeArr[i][1]== degrees.get(degrees.size()-3)&& tempk1<=k)
						{
							maxNodes.add(nodeDegreeArr[i][0]);
							tempk1= tempk1+1;
						}
					
					}
				}
				if(tempk1<k)
				{
					for(int i=1;i<nodeDegreeArr.length;i++)
					{	
						if(nodeDegreeArr[i][1]== degrees.get(degrees.size()-4)&& tempk1<=k)
						{
							maxNodes.add(nodeDegreeArr[i][0]);
							tempk1= tempk1+1;
						}
					
					}
				}
				if(tempk1<k)
				{
					for(int i=1;i<nodeDegreeArr.length;i++)
					{													//
						if(nodeDegreeArr[i][1]== degrees.get(degrees.size()-5)&& tempk1<=k)
						{
							maxNodes.add(nodeDegreeArr[i][0]);
							tempk1= tempk1+1;
						}
					
					}
				}
				
				
				
				//remove/change max degrees vertices -1
			       for(int i= 0; i<t2darr.get(1).size();i++)
			 	  {			    	  
			 		  if(maxNodes.contains(t2darr.get(0).get(i)))
			 		  {
			 			 t2darr.get(0).set(i, -1);
			 			t2darr.get(1).set(i, -1);
			 			 
			 		  }
			 		 
			 		  else if(maxNodes.contains(t2darr.get(1).get(i)))
					  {
			 			t2darr.get(0).set(i, -1);
				 		t2darr.get(1).set(i, -1);
						
					  }
					 	
			 		 		  
			 	  }
			       
			       //count the new graph Gs edges to calc min pairwise connectivity 
			       int minPairwiseConne =0; 
			       for(int i= 0; i<t2darr.get(0).size();i++)
			       {
			    	   if(!(t2darr.get(0).get(i).equals(-1)))
			    	   {
			    		   minPairwiseConne = minPairwiseConne+1; 
			    	   }
			       }
			       
			       
			       //output 
			       System.out.println("\nMinimum pair-wise connectivity: "+minPairwiseConne);
    		       System.out.println("(k) Critical Nodes: "+maxNodes);

			       
			       bw.write("Minimum pair-wise connectivity: "+minPairwiseConne);
			       bw.newLine();
			       bw.write("(k) Critical Nodes: "+maxNodes);
			       
			       
			//	System.out.println("Max degree: "+max);
				in.close();
				bw.close();
			}
			catch(IOException e) {

				e.printStackTrace();

			}
				
		}
		}

