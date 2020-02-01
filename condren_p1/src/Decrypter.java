

public class Decrypter {
	private static void swap(int[] array, int i, int j) {
	  int temp = array[i];
	  array[i] = array[j];
	  array[j] = temp;
	}
	public static int[] decrypt(int[] encrypted) {
		swap(encrypted, 2, 0); 
		swap(encrypted, 3, 1);
		int[] decrypted = new int[4];
		for(int i = 0; i < 4; i++) {
			decrypted[i] = (encrypted[i] + 3) % 10;
		}
		return decrypted;
		}
}
