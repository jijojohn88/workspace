
public class Seggregate0sAnd1s {
	
	public static void swap(int[] array,int i,int j) {
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
	}
	
	public static void print(int[] array) { 
		for(int a : array) {
			System.out.print(a + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		
		int[] array = {0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1};
		//int[] array = {};
		
		int left=0;
		int right=array.length-1;
		print(array);
		while(left < right) {
			
			if(array[left] == 1 && array[right] == 0) {
				swap(array,left,right);
			}
			
			if(array[left] == 0) {
				left++;
			}
			if(array[right] == 1) {
				right--;
			}
			
			
		}
		
		print(array);
	}

}
