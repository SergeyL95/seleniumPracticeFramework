package ClassActivity;

public class ArrayMathcing {
	public static void main(String[] args) {
		
		int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] nums2 = {5, 11, 34, 21, 2, 7};
		String[] names = {"Omar", "Mark", "Zack"};
		
		//System.out.println(mathcingNums);
		//taskTwo(nums1);
		//task3(names);
		fibonacciNums();
		
	}
	
	public static int mathcingNums(int[] nums1, int[] nums2) {
		
		int numsMatched = 0;
		
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j <nums2.length; j++) {
				if (nums1[i]==nums2[j]) {
					numsMatched++;
					break;
				}
			}
		}
		
		return numsMatched;
		
	}
	
	public static void taskTwo(int[] nums1) {
		
		System.out.println("Even numbers:");
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i]%2==0) {
				System.out.println(nums1[i]);
				continue;
			}
		}
		
		System.out.println("Odd numbers:");
		for (int i = 0; i < nums1.length; i++) {
			if (nums1[i]%2!=0) {
				System.out.println(nums1[i]);
				continue;
			}
		}
		
	}
	
	public static void task3(String[] names) {
		
		char[] reversedName = null;
				
		for (int i = 0; i < names.length; i++) {
			char[] name = names[i].toCharArray();
			for (int j = name.length; j <= 0; j--) {
				reversedName[j] = name[j];
			}
		System.out.println(reversedName);
		}
		
	}
	
	public static void fibonacciNums() {
		int prevNumb = 0;
		int currNumb = 0;
		for (int i=0; i<=10; i++) {
			prevNumb+=i;
			for (int j=0; j<=10; j++)
			currNumb=+prevNumb;
			System.out.println(currNumb);
			}
	}
}
