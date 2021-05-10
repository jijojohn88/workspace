
public class RotateArray {

	public static void printArray(int[] array) {

		for (int a : array) {
			System.out.print(a + " ,");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int offset = 6;

		printArray(array);

		for (int i = 1; i <= offset; i++) {

			int temp = array[0];

			for (int k = 1; k < array.length; k++) {
				array[k - 1] = array[k];
			}
			array[array.length - 1] = temp;
			printArray(array);
		}

	}

}
