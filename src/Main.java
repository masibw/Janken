import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static final int TIMES = 100;
	public static final String FILE1 = "Player1.txt";
	public static final String FILE2 = "Player2.txt";

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 0 && args[0].equals("newGame")) {
			try {
				File file1 = new File(FILE1);
				File file2 = new File(FILE2);
				FileWriter fw1 = new FileWriter(file1);
				FileWriter fw2 = new FileWriter(file2);
				Random rand = new Random();
				for (int i = 0; i < 100; i++) {
					fw1.write(rand.nextInt(3) + " ");
					int p2=rand.nextInt(4);
					if (p2 == 1 ||p2== 4) {
						fw2.write(1 + " ");//1/4でグーとチョキ、2/4でパーを出す
					} else {
						fw2.write(p2 + " ");
					}
				}
				fw1.close();
				fw2.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		int p1Win = 0;
		int p2Win = 0;
		int[] p1WinHands = new int[3];
		int[] p2WinHands = new int[3];
		int[] drawHands = new int[3];
		int draw = 0;
		File file1 = new File(FILE1);
		File file2 = new File(FILE2);
		Scanner sc1 = new Scanner(file1);
		Scanner sc2 = new Scanner(file2);
		//Judge
		for (int i = 0; i < TIMES; i++) {

			int p1 = sc1.nextInt();
			int p2 = sc2.nextInt();
			if (p1 == p2) {
				draw++;
				switch (p1) {
				case 0:
					drawHands[0] += 1;
					break;
				case 1:
					drawHands[1] += 1;
					break;
				case 2:
					drawHands[2] += 1;
					break;
				}
			} else if (p1 == 0 && p2 == 2) {
				p1WinHands[0] += 1;
				p1Win++;

			} else if (p1 == 1 && p2 == 0) {
				p1WinHands[1] += 1;

				p1Win++;

			} else if (p1 == 2 && p2 == 1) {
				p1WinHands[2] += 1;

				p1Win++;

			} else {
				switch (p2) {
				case 0:
					p2WinHands[0] += 1;
					break;
				case 1:
					p2WinHands[1] += 1;
					break;
				case 2:
					p2WinHands[2] += 1;
					break;
				}
				p2Win++;
			}
		}
		//Judge終了
		sc1.close();
		sc2.close();
		System.out.println("P1" + "  " + p1Win + "グー" + p1WinHands[0] + "勝、パー" + p1WinHands[1] + "勝、チョキ"
				+ p1WinHands[2] + "勝");
		System.out.println("P2" + "  " + p2Win + "グー" + p2WinHands[0] + "勝、パー" + p2WinHands[1] + "勝、チョキ"
				+ p2WinHands[2] + "勝");
		System.out.println("引分" +"  "+ draw + "グー" + drawHands[0] + "分、パー" + drawHands[1]
				+ "分、チョキ" + drawHands[2] + "分");
	}
}
