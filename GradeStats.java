/*
 * Aarav Goyal
 * 1/17/2025
 * GradeStats.java
 */ 
import java.util.Scanner;
public class GradeStats
{
	int[] grades;
	public GradeStats()
	{
	}
	
	public static void main (String[] args)
	{
		GradeStats gs = new GradeStats();
		gs.calculateIt();
	}
	
	public void calculateIt()
	{
		int numScores, min, max, avg, median = 0;
		getInput();
		bubbleSort();
		printData();
	}
	
	public void getInput()
	{
		Scanner in = new Scanner (System.in);
		for (int x = 0; !x.equalsIgnoreCase("quit"); x++)
		{
			System.out.print("\n\n\nType in the score. Type “Quit” to end the program --> ");
			String temp  = in.nextLine;
			temp.parseInt();
		}
	}
	
	public static void bubbleSort() 
	{
		int n = grades.length;
		int temp = 0;
		for (int i = 0; i < n; i++) 
		{
			for (int j = 1; j < (n - i); j++) 
			{
				if (grades[j - 1] > grades[j]) 
				{
					temp = grades[j - 1];
					grades[j - 1] = arr[j];
					grades[j] = temp;
				}
			}
		}
	}
	
	public static void printData()
	{
		for (int i = 0; i < grades.length; i++)
			System.out.println("Student " + (i+1) + "'s score: " + grades[i]);
	}
}
