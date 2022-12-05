import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList <Integer> Calories = new ArrayList<Integer>();
		int count=0; //count of calories for given elf in iteration below
		File day_1 = new File("Day_1.txt");
		Scanner myReader;
		
		try {
			myReader = new Scanner(day_1);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				if (data.isBlank()) { //if we have hit a blank line, then the count for that elf ends
					Calories.add(count);
					count=0; //reset the count for that elf back to 0
				}
				else {
					count+=Integer.parseInt(data);
				}
			}
			int total=0;
			for (int i=0; i<3; i++) {
				total+=Collections.max(Calories);
				Calories.remove(Collections.max(Calories));
			}
			System.out.println("The total carried by the three elves is: "+total);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
