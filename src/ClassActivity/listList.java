package ClassActivity;

import java.util.ArrayList;

public class listList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(41);
		list.add(12);
		list.add(534);
		list.add(4);
		System.out.println(list);
		int index = listList.getListDataIndex(list, 41);
		System.out.println(index);
		
	}
	
	public static int getListDataIndex(ArrayList<Integer> list, int element) {
		return list.indexOf(element);
	}
}
