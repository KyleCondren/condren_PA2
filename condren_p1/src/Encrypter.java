

public class Encrypter {
	private static void swap(int[] array, int i, int j) {
		  int temp = array[i];
		  array[i] = array[j];
		  array[j] = temp;
	}
	public static int[] encrypt(int[] original) {
		int[] encrypted = new int[4];
		for(int i = 0; i < 4; i++) {
			encrypted[i] = (original[i] + 7) % 10;
		}
        swap(encrypted, 0, 2); 
        swap(encrypted, 1, 3);
        return encrypted;
	}
}