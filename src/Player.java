import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	private int winCount = 0;
	private int[] hand = new int[3];
//	private static String FILENAME = "";

//	Player(String fileName) {
//		this.FILENAME = fileName;
//	}

	private List<Integer> hands = new ArrayList<>();

	public int getHand(int i) {
		int num = hands.get(i);
		return num;
	}

	public void loadHands() {
			File file = new File(FILENAME);
			Scanner sc = new Scanner(FILENAME);
			for(int i=0;i<)

	}
}
