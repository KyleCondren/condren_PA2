

import java.util.Scanner;

public class BMICalculator {
	
	private String measureSystem;
	private float meters;
	private int feet;
	private int inches;
	private int weight;
	private float BMI;
	
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}

	public void readUserData() {
		boolean goodMeasuringSystem = true;
		do
		{
			System.out.print("Will you be using the Metric or Imperial measuring system?\n");
			Scanner input = new Scanner(System.in);
			measureSystem = input.next();
			if(measureSystem.equalsIgnoreCase("Metric")) {
				System.out.print("\nWhat is your height in meters?\n");
				meters = input.nextFloat();
				System.out.print("\nWhat is your weight in Kilograms?\n");
				weight = input.nextInt();
				break;
			}
			else if(measureSystem.equalsIgnoreCase("Imperial")) {
				System.out.print("\nWhat is your height in Feet and Inches?\n");
				feet = input.nextInt();
				inches = input.nextInt();
				System.out.print("\nWhat is your weight in Pounds?\n");
				weight = input.nextInt();
				break;
			}
			else
				goodMeasuringSystem = false;
			input.close();
		} while (goodMeasuringSystem);
	}
	
	public void calculateBmi() {
		if(measureSystem.equalsIgnoreCase("Imperial")) {
			inches = (feet*12)+inches;
			BMI = (float)(703*weight)/(inches*inches);
		}
		if(measureSystem.equalsIgnoreCase("Metric")) 
			BMI = weight/(meters*meters);
	}

	public void displayBmi( ) { 
		String formatBMI = String.format("%.1f", BMI);
		System.out.print("Your calcualted BMI is: "+formatBMI);
	}
}
