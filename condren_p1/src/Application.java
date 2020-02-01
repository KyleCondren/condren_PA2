

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the 4 digits you wish to encrypt with a space separating each number: \n");
		int[] original = new int[4];
		for(int i = 0; i < 4; i++) {
			original[i] = input.nextInt();
		}
		int[] encrypted = Encrypter.encrypt(original);
		System.out.print("Your encrpted number is: \n");
        for (int i = 0; i < 4; i++) {
        	System.out.print(encrypted[i]+" ");
        }
		System.out.print("\nEnter the 4 digits you wish to decrypt with a space separating each number: \n");
		int[] userEncrypted = new int[4];
		for(int i = 0; i < 4; i++) {
			userEncrypted[i] = input.nextInt();
		}
		int[] decrypted = Decrypter.decrypt(userEncrypted);
		System.out.print("Your decrypted number is: \n");
        for (int i = 0; i < 4; i++) {
        	System.out.print(decrypted[i]+" ");
        }
        input.close();
	}

}
