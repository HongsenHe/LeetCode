/*
Design and implement a TwoSum class. It should support the following 
operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal 
to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/

public class TwoSum {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    
	public void add(int number) {
	    list.add(number);    
	}

	public boolean find(int value) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < list.size(); i++) {
	        int temp = value - list.get(i);
	        if (map.containsKey(temp)) {
	            return true;
	        } else {
	            map.put(list.get(i), i);
	        }     
	    }
	    return false;
	}
}