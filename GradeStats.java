
import java.util.Scanner;

public class GradeStats 
{
	int[] grades = new int[1000];
	public static void main(String[] args) 
	{
		GradeStats gs = new GradeStats();
		gs.calculateIt();
	}

	public void calculateIt()
	{	
		int numScores = 0;
		Scanner in = new Scanner(System.in);
		boolean next = true;
		System.out.println("\n\n\n");
		int counter = 1;
		for (int i = 0; next; i++)
		{
			System.out.print("\nType in the score. Type \"Quit\" to end the program --> ");
			String input = in.next();

			if (input.equalsIgnoreCase("Quit")) 
			{
				next = false;
			}
			else
			{
				int score = Integer.parseInt(input);
				if (score < 75)
				{
					counter++;
				}
				if (numScores < grades.length) 
				{
					grades[numScores] = score;
					numScores++;
				} 
				else 
				{
					System.out.println("Maximum score limit reached.\n\n\n");
					next = false;
				}
			}

		}

		if (numScores == 0) 
		{
			System.out.println("No scores entered.\n\n\n");
		}
		else
		{
			printStudents(numScores, counter);
			sort(numScores);
			printData(numScores);
		}
	}

	public void printStudents(int numScores, int count)
	{
		System.out.println("\nHere is the data you entered:");
		for (int i = 0; i < numScores; i++) 
		{
			System.out.println("Student " + (i + 1) + ": " + grades[i]);
		}

		System.out.print("\nThere were " + (count-1) + " student(s) who scored below 75%:");

		int i = 0;
		for (i = 0; i < numScores; i++) 
		{
			if (grades[i] < 75) 
			{
				if (i == 0)
				{
					System.out.print(" student " + (i + 1));
				}
				else
				{
					System.out.print(", student" + (i + 1));
				}

			}
		}
		if (i!=0)
		{
			System.out.print(".");
		}

	}

	public void printData(int numScores)
	{
		int min = grades[0];
		int max = grades[numScores - 1];
		int sum = 0;
		double median;
		if (numScores%2==1)
			median = grades[numScores/2];
		else
			median = (grades[numScores/2] + grades[(numScores/2)-1])/2;
		for (int i = 0; i < numScores; i++) 
			sum += grades[i];

		double avg = sum / (double) numScores;
		System.out.println("\n\nMin score: " + min);
		System.out.println("Max score: " + max);
		System.out.printf("Median score: %.1f\n", median);
		System.out.printf("Average score: %.1f\n\n\n", avg);	
	}

	public void sort(int numScores)
	{
		for (int i = 0; i < numScores - 1; i++) 
		{
			for (int j = 0; j < numScores - 1 - i; j++)
			{
				if (grades[j] > grades[j + 1]) 
				{
					int temp = grades[j];
					grades[j] = grades[j + 1];
					grades[j + 1] = temp;
				}
			}
		}
	}
}

