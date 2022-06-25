
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class HAASolution {
    public static int linearSearch(int totalLines, String[] compilationStatuses) {
        long startTime = System.nanoTime();
        // TODO Implement the search using linear search
        int count=1;
        for(int i=0;i<totalLines;i++) {
        	//System.out.println(compilationStatuses[i]);
        	if(compilationStatuses[i].equals("pass")) {
        		count++;
        	}
        	else {
        		System.out.println("The linear search fail = "+count);
        		break;
        	}
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Linear search took: " + executionTime + " nanoseconds.");
        return 0;
    }
    public static int binarySearch(int totalLines, String[] compilationStatuses) {
        long startTime = System.nanoTime();
        // TODO Implement the search using binary search
        int count = 1;
        int mid = (totalLines/2);
        //System.out.println("mid value = "+mid);
        if(mid==0) { 									//if the input value is 1 then it executes this condition
        	if(compilationStatuses[mid].equals("pass")) {
        		System.out.println("Compilation success");
        	}
        	else {
        		System.out.println("The binary search fail = "+count);
        	}
        }
        else if(compilationStatuses[mid-1].equals("fail") && compilationStatuses[mid-2].equals("pass")) {  //if the compilation error(fail) starts from middle of the given list then it executes this condition
        	System.out.println("The binary search fails = "+mid);
        }
        
        else {
	        if(compilationStatuses[mid-1].equals("fail")) {
	        	//System.out.println("entered");
	        	for(int i=0;i<mid;i++) {
	        		if(compilationStatuses[i].equals("pass")) {
	            		count++;
	            	}
	        		else {
	            		System.out.println("The binary search fail = "+count);
	            		break;
	            	}
	        	}
	        }else {
	        	count = mid;
	        	for(int i=mid;i<totalLines;i++) {
	        		if(compilationStatuses[i].equals("pass")) {
	        			count++;
	        		}
	        		else {
	        			count++;
	        			System.out.println("The binary search fail = "+count);
	        			break;
	        		}
	        	}
	        }
        } 
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Binary search took: " + executionTime + " nanoseconds.");
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Enter the relative path of the test case file, e.g.: HelpAnAlgorithmist/test_cases/input_1.txt
        System.out.print("Enter the file path of the test case: ");
        String inputFilePath = scanner.nextLine();
        int lineCount = 0, totalLines = 0;
        ArrayList<String> statuses = new ArrayList<String>();
        try {
            Scanner fileScanner = new Scanner(new File(inputFilePath));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (lineCount == 0) {
                    totalLines = Integer.parseInt(line);
                    //System.out.println(totalLines);
                } else {
                    statuses.add(line);
                    //System.out.println(line);
                }
                lineCount++;
            }
            String[] compilationStatuses = statuses.toArray(new 
String[statuses.size()]);
            linearSearch(totalLines, compilationStatuses);
            binarySearch(totalLines, compilationStatuses);
            fileScanner.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
