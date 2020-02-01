

import java.util.Scanner;

public class BMICalculator {
	
	private Scanner input;
	private String measureSystem;
	private float meters;
	private int feet;
	private int inches;
	private int weight;
	private float BMI;
	private String BMIcategory;
	
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}

	private void readUserData() {
		readUnitType();
		readMeasurementData();
	}
	
	private void readUnitType() {
		System.out.print("Will you be using the Metric or Imperial measuring system?\n");
		input = new Scanner(System.in);
		measureSystem = input.next();
	}
	
	public void readMeasurementData() {
		if(measureSystem.equalsIgnoreCase("Metric")) {
			readMetricData();
		}
		else if(measureSystem.equalsIgnoreCase("Imperial")) {
			readImperialData();
		}
		else
			readUnitType();
		input.close();
	}
	
	private void readMetricData() {
		getWeight();
		getHeight();
	}
	
	public void getHeight(){
		if(measureSystem.equalsIgnoreCase("Metric"))
			System.out.print("\nWhat is your height in meters?\n");
		else
			System.out.print("\nWhat is your height in Feet and Inches?\n");
		setHeight();
	}
	public void getWeight() {
		if(measureSystem.equalsIgnoreCase("Metric"))
			System.out.print("\nWhat is your weight in Kilograms?\n");
		else
			System.out.print("\nWhat is your weight in Pounds?\n");
		setWeight();
	}
	private void setHeight() {
		if(measureSystem.equalsIgnoreCase("Metric")) {
			meters = input.nextFloat();
			if(meters < 0)
				System.exit(0);
		}
		else {
			feet = input.nextInt();
			inches = input.nextInt();
			if (feet < 0 || inches < 0)
				System.exit(0);
		}
	}
	
	private void setWeight() {
		weight = input.nextInt();
	}
	
	private void readImperialData() {
		getWeight();
		getHeight();
	}
	
	public void calculateBmi() {
		if(measureSystem.equalsIgnoreCase("Imperial")) {
			inches = (feet*12)+inches;
			BMI = (float)(703*weight)/(inches*inches);
		}
		if(measureSystem.equalsIgnoreCase("Metric")) 
			BMI = weight/(meters*meters);
		calculateBmiCategory();
	}

	private void calculateBmiCategory() {
		if(BMI <= 18.5)
			BMIcategory = "Underweight";
		else if(18.5 < BMI && BMI < 24.9)
			BMIcategory = "Normal Weight";
		else if(25 < BMI && BMI < 29.9)
			BMIcategory = "Overweight";
		else
			BMIcategory = "Obesity";
	}
	public void displayBmi( ) { 
		String formatBMI = String.format("%.1f", BMI);
		System.out.print("\nYour calcualted BMI is: "+formatBMI);
		System.out.print("\nYour BMI category is: "+BMIcategory);
	}
}
