import java.util.*;
import java.util.concurrent.ThreadLocalRandom;



class cs303HashMap {
		private static LinkedList<Integer> arrkey[];
		private static LinkedList<Integer> arrval[];
	    public cs303HashMap() {
	    	arrkey = new LinkedList[1000];
	    	arrval = new LinkedList[1000];
	    	
	    	for(int i=0;i<1000;i++) {
	    		arrkey[i] = new LinkedList<Integer>();
	    		arrval[i] = new LinkedList<Integer>();
	    	}
	    }
	        
	    public void put(int key, int value) {
			int num = key%1000;
			
			if(arrkey[num] == null) {
				arrkey[num].add(key);
				arrval[num].add(value);
			}
			else if(arrkey[num].contains(key) == true) {
				int index = arrkey[num].indexOf(key);
				arrval[num].set(index,value);
			}
			else {
				arrkey[num].add(key);
				arrval[num].add(value);
			}
	    }
		    
	    public int get(int key) {
	    	int num = key%1000;
	    	if(arrkey[num].contains(key) == true) {
	    		int index = arrkey[num].indexOf(key);
	    		int val = arrval[num].get(index);
	    		return val;
	    	}
	    	else
	    		return -1;		            
	    }
		        
	    public void remove(int key) {
	    	int num = key%1000;
	    	if(arrkey[num].contains(key) == true) {
	    		int index = arrkey[num].indexOf(key);
	    		arrval[num].remove(index);
	    		arrkey[num].remove(index);
	    	}
	    }

	    public int size(){
	    	int Lsize=0;
	    	for(int i=0;i<1000;i++) {
	    		if(arrkey[i]!=null) {
	    			Lsize = Lsize + arrkey[i].size();
	    		}
	    	}
	    	if(Lsize!=0) {
	    		return Lsize;
	    	}else {
	    		return -1;
	    	}
	    }

	    
	    public static void main(String []args) 
	    {
		    cs303HashMap hm = new cs303HashMap();

		    hm.put(1,1);
		    hm.put(1,2);
		    hm.put(1,3);
		    hm.put(1,7);
		    hm.put(1,9);
		    hm.put(1,10);
		    hm.put(1,10000);
		    hm.put(1,10002);
		    
		    hm.put(10000,91);
		    hm.put(1000,110);
		    hm.put(100,1123);
		    hm.put(10,1456);
		    hm.put(1,8765);

		    System.out.println(hm.get(1)); // should return 8765
		    System.out.println(hm.get(21)); // should return -1

		    System.out.println(hm.size()); // at this point it should return a size of 5 (corresponding to the keys: 1, 10, 100, 1000, 10000)

		    hm.remove(1);
		    System.out.println(hm.size()); // at this point it should return a size of 4 (corresponding to the keys:  10, 100, 1000, 10000)

		    for (int i=0; i < 1000; i++)
			    hm.put(ThreadLocalRandom.current().nextInt(0, 100000), ThreadLocalRandom.current().nextInt(0, 100000));

		   System.out.println(hm.size());
		

	    }
}


