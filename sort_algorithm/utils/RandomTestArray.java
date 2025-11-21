package data_structure;

public class RandomTestArray {

	public static int[] generateRandomArray(int size, int range1, int range2) {
		int[] arr = new int[size];
		
		int min = Math.min(range1, range2);
		int max = Math.max(range1, range2);
		for(int i = 0; i < arr.length; i++) {
		    arr[i] = (int)(Math.random() * (max - min + 1)) + min;
		}
		
		return arr;
	}

	public static int[] generateRandomArray(int size, int range) {
		int[] arr = new int[size];
		if(range>0) {
			range+=1;
		}else {
			range-=1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			
		    arr[i] = (int)(Math.random() * (range));
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = generateRandomArray(10,10,20);
		for(int i: arr) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		int[] arr1 = generateRandomArray(30,-30);
		for(int i: arr1) {
			if(i == -30) {
				System.out.println("found");
				break;
			}
			System.out.print(i+" ");
		}
	}
}
