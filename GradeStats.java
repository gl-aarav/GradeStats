import java.util.Scanner;

public class GradeStats 
{
	int[] grades = new int[500];
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
		while (next) 
		{
			System.out.print("\nEnter a score (or type 'Quit' to stop): ");
			String input = in.next();

			if (input.equalsIgnoreCase("Quit")) 
			{
				next = false;
			}
			else
			{
				int score = Integer.parseInt(input);
				if (numScores < grades.length) 
				{
					grades[numScores] = score;
					numScores++;
				} 
				else 
				{
					System.out.println("Maximum score limit reached.");
					next = false;
				}
			}

		}

		if (numScores == 0) 
		{
			System.out.println("No scores entered.");
		}
		else
		{
			sort(numScores);
			printData(numScores);
		}
	}

	public void printData(int numScores)
	{
		System.out.println("\nScores:");
		for (int i = 0; i < numScores; i++) 
		{
			System.out.println("Student " + (i + 1) + ": " + grades[i]);
		}

		int min = grades[0];
		int max = grades[numScores - 1];
		int sum = 0;
		int median = grades[numScores/2];
		for (int i = 0; i < numScores; i++) 
		{
			sum += grades[i];
		}
		double avg = sum / (double) numScores;
		System.out.println("\n\nMin score: " + min);
		System.out.println("Max score: " + max);
		System.out.println("Median score: " + median);
		System.out.printf("Average score: %.2f\n\n\n", avg);	
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

