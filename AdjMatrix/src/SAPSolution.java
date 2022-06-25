import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SAPSolution {


    public static int[][] getAdjacencyMatrix(int n, int m, int[][] edgeList) {
        /*
         * Return two-dimensional integer array representing the adjacency matrix from the given edge list. Remember that the graph is undirected.
         * Parameters
         * ----------
         * n: number of vertices
         * m: number of edges
         * edgeList: two-dimensional integer array representing the edge list
         * */
        // TODO Complete the method
    	System.out.println("lis"
    			+ "t length "+edgeList.length);
    	int k=0;
    	
    	for(int i=0;i<m-1;i++) {
    		if(edgeList[i][0]==edgeList[i+1][0]) {
    			if(edgeList[i][1]>edgeList[i+1][1]) {
    				int temp=edgeList[i][1];
    				edgeList[i][1] = edgeList[i+1][1];
    				edgeList[i+1][1] = temp;
    			}
    		}
    	}
    	
    	System.out.println("After sorting");
    
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<edgeList[i].length;j++) {
    			System.out.print(edgeList[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
        int[][] adjacencyMatrix = new int[n][n];
        k=0;
        int t=0, q=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(i==edgeList[t][k]) {
        			if(j==edgeList[t][k+1])
        			{
        				adjacencyMatrix[i][j]=1;
        				if(t<m-1) {
        					t++;
        				}
        				else
        					t=m-1;
        			}
        			else {
        				adjacencyMatrix[i][j]=0;
        			}
        			
        		}
        	}
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(j==edgeList[q][k+1]) {
        			if(i==edgeList[q][k]) {
        				adjacencyMatrix[j][i]=1;
        				if(q<m-1) {
        					q++;
        				}
        				else
        					q=m-1;
        			}
        		}
        	}
        }
        
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		System.out.print(adjacencyMatrix[i][j]+" ");
        	}
        	System.out.println();
        }
        
        
        return adjacencyMatrix;
    }

    public static boolean isEulerian(int n, int[][] adjacencyMatrix) {
        /*
         * Return true if the adjacencyMatrix has 0 or 2 odd degree. Otherwise, return false
         * Parameters
         * ----------
         * n: number of vertices
         * adjacencyMatrix: two-dimensional integer array representing the adjacency matrix
         * */
        // TODO Complete the method
    	int count =0, oddcount =0;
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(adjacencyMatrix[i][j]==1) {
    				count++;
    			}
    		}
    		if(count%2!=0) {
    			oddcount++;
    		}
    		count =0;
    	}
    	
    	if(oddcount==1 || oddcount>2) {
    		System.out.println("odd count "+oddcount);
    		return false;
    	}
    	System.out.println("odd count "+oddcount);
    	
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Enter the relative path of the test case file, e.g.: SolveAPuzzle/test_cases/input_1.txt
        System.out.print("Enter the file path of the test case: ");
        String inputFilePath = scanner.nextLine();
        try {
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            Scanner fileScanner = new Scanner(new File(inputFilePath));
            int lineCount = 0, numberOfNodes = 0, numberOfEdges = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (lineCount == 0) {
                    numberOfNodes = Integer.parseInt(line);
                } else if (lineCount == 1) {
                    numberOfEdges = Integer.parseInt(line);
                } else {
                    ArrayList<Integer> row = new ArrayList<Integer>();
                    for (String value : line.split(" ")) {
                        row.add(Integer.parseInt(value));
                    }
                    edges.add(row);
                }
                lineCount++;
            }
            int[][] edgeList = new int[edges.size()][];
            for (int i = 0; i < edges.size(); i++) {
                ArrayList<Integer> currentRow = edges.get(i);
                Integer[] record = new Integer[currentRow.size()];
                
                record = currentRow.toArray(record);
                
                int[] row = new int[record.length];
                for (int j = 0; j < record.length; j++) {
                    row[j] = record[j];
                    System.out.print(row[j]+" ");
                }
                System.out.println();
                edgeList[i] = row;
            }
            	            
            int[][] adjacencyMatrix = getAdjacencyMatrix(numberOfNodes, numberOfEdges, edgeList);
            System.out.println(inputFilePath);
            System.out.println(isEulerian(numberOfNodes, adjacencyMatrix));
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}