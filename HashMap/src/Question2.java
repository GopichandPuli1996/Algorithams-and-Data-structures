import java.util.*;


class Quest2 {
	public int uniqueElementCounter(int[] nums1) {

		System.out.println("The length of the array is " + nums1.length);

		// TODO implement your code here
		// Insert in a hash map, where the key are the numbers of nums1 and value is their frequency
		// iterate through the hash map to count the keys with a frequency of only 1
		if(nums1.length>1) {
			HashMap<Integer,Integer> hmap = new HashMap<>();
			for(int i=0;i<nums1.length-1;i++) {
				for(int j=i+1;j<nums1.length;j++) {
					if(nums1[i] > nums1[j]) {
						int temp = nums1[i];
						nums1[i] = nums1[j];
						nums1[j] = temp;
					}
				}
			}
			
			for(int i=0;i<nums1.length;i++) {
				System.out.print(nums1[i]+" ");
			}
			System.out.println();
			/*int flag =0;
			int temp =0;
			for(int i=0;i<nums1.length-1;i++) {
				count=1;
				if(flag ==1) {
					if(nums1[i] == nums1[i+1]) {
						continue;
					}
					if(nums1[i-1] == nums1[i]) {
						i++;
					}
				}
				for(int j=i+1;j<nums1.length;j++) {
					if(nums1[i] == nums1[j]) {
						count++;
						flag =1;
					}
					else {
						continue;
					}
				}
				hmap.put(nums1[i],count);
				/*if(count == 1) {
					System.out.println(nums1[i]);
					temp++;
				}
			}*/
			//updated code
			int count = 1;
			int temp =0;
			for(int i=0;i<nums1.length-1;i++) {
				count = 1;
				for(int j=i+1;j<nums1.length;j++) {
					if(nums1[i] == nums1[j]) {
						count++;
					}else {
						i =j-1;
						break;
					}
				}
				hmap.put(nums1[i],count);
				//System.out.println(nums1[i]+" "+count);
				if(i==nums1.length-1) {
					if(count==1) {
						hmap.put(nums1[temp], count);
						break;
					}
				}
			}

			
			System.out.println("Using hash map");
			for(Map.Entry<Integer,Integer> en : hmap.entrySet()) {
				//System.out.println(en.getKey()+" "+en.getValue());
				if(en.getValue()==1) {
					//System.out.println(en.getKey());
					temp++;
				}
			}
			return temp;	
		}else
			return -1;
	            
        }

public static void main(String []args) 
{
	Quest2 s = new Quest2();
	int[] intArray0 = new int[]{5,1,2,3,4,5,1,1,1};
	//The answer should be 3 (corresponding to 2, 3 and 4)
	long startTime1 = System.nanoTime();
	System.out.println("Number of unique elements " + s.uniqueElementCounter(intArray0));
	long endTime1 = System.nanoTime();
	long executionTime1 = endTime1 - startTime1;
	System.out.println("The execution time for 1st array = "+executionTime1);

	int[] intArray1 = new int[]{1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245};
	long startTime2 = System.nanoTime();
	System.out.println("Number of unique elements " + s.uniqueElementCounter(intArray1));
	long endTime2 = System.nanoTime();
	long executionTime2 = endTime2 - startTime2;
	System.out.println("The execution time for 2nd array = "+executionTime2);
	
	int[] intArray2 = new int[]{10,20,30,40,50,60,70,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245};
	long startTime3 = System.nanoTime();
	System.out.println("Number of unique elements " + s.uniqueElementCounter(intArray2));
	long endTime3 = System.nanoTime();
	long executionTime3 = endTime3 - startTime3;
	System.out.println("The execution time for 3rd array = "+executionTime3);
	
	int[] intArray3 = new int[]{1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,1,4,5,6,7,8,9,11,12,13,14,15,16,17,18,20,21,22,55,56,1000,10001,1000001,10000002,32,44,999,10000,123,1245,12456789,1,2,3,4,5,99,2222,22234,23456,76543,1111,1202,109};
	long startTime4 = System.nanoTime();
	System.out.println("Number of unique elements " + s.uniqueElementCounter(intArray3));
	long endTime4 = System.nanoTime();
	long executionTime4 = endTime4 - startTime4;
	System.out.println("The execution time for 4th array = "+executionTime4);
}

}
