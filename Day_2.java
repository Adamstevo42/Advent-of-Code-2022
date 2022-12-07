import java.io.File;
import java.util.Scanner;

public class Day_2 {
	
	// A/X = Rock and gets 1 point
	// B/Y = Paper and gets 2 points
	// C/Z = Scissors and gets 3 points
	// 3 points for win, 1 point for draw
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int score_part1=0;
		int score_part2=0;
		
		File file = new File("Day_2.txt");
		Scanner myReader;
		
		//loop through each row and add the score for the player depending if win, draw or loss
		myReader = new Scanner(file);
		while(myReader.hasNextLine()) {
			String data = myReader.nextLine();
			//Part 1
			if (data.charAt(2)=='X') {score_part1+=1;} else if (data.charAt(2)=='Y') {score_part1+=2;} else {score_part1+=3;}
			
			if (data.charAt(0)=='A') { //if player 1 plays rock
				if (data.charAt(2)=='X') {score_part1+=3;} else if (data.charAt(2)=='Y') {score_part1+=6;}
			}
			else if (data.charAt(0)=='B') {
				if (data.charAt(2)=='Y') {score_part1+=3;} else if (data.charAt(2)=='Z') {score_part1+=6;}
			}
			else {
				if (data.charAt(2)=='Z') {score_part1+=3;} else if (data.charAt(2)=='X') {score_part1+=6;}
			}
			
			
			//Part 2
			if (data.charAt(2)=='X') {//lose
				if (data.charAt(0)=='A') {score_part2+=3;}// if player 1 plays rock, then we must play scissors
				else if (data.charAt(0)=='B') {score_part2+=1;}// if player 1 plays paper, then we must play rock
				else {score_part2+=2;} //by elimination, we must play paper against player 1's scissors.
			}
			else if (data.charAt(2)=='Y') {//draw
				score_part2+=3;
				if (data.charAt(0)=='A') {score_part2+=1;}// if player 1 plays rock, we must also play rock
				else if (data.charAt(0)=='B') {score_part2+=2;}// if player 1 plays paper, we must also play paper
				else {score_part2+=3;}//by elimination, we must play scissors against player 1's scissors.
			}
			else {//win
				score_part2+=6;
				if (data.charAt(0)=='A') {score_part2+=2;}// if player 1 plays rock, we must play paper
				else if (data.charAt(0)=='B') {score_part2+=3;}// if player 1 plays paper, we must play scissors
				else {score_part2+=1;}//by elimination, we must play rock against player 1's scissors.
			}
		}
		System.out.println("The total score for part 1 is: "+score_part1);
		System.out.println("The total score for part 2 is: "+score_part2);

	}

}
