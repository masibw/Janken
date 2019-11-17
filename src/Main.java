import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main {

	public static final int TIMES = 100;
	public static final String FILE1 = "Player1.txt";
	public static final String FILE2 = "Player2.txt";

	public static void main(String[] args) throws FileNotFoundException {
		int ninzu=Integer.parseInt(args[0]);
		int gWin=0;
		int tWin=0;
		int pWin=0;
		int draw = 0;
		Random rand = new Random();
		//Judge

		for (int i = 0; i < TIMES; i++) {
			HashSet<Integer> set = new HashSet<>();
			for(int j=0;j<ninzu;j++) {
				if(set.size()>2)break;
				set.add(rand.nextInt(3));
			}
			if(set.size()==1 || set.size()==3) {
				draw++;
				continue;
			}
			ArrayList<Integer> array = new ArrayList<>(set);
			int t1=array.get(0);
			int t2=array.get(1);
			if(t1==t2) {
				draw++;
			}else if(t1==0 && t2==1) {
				gWin++;
			}else if(t1==0 && t2==2) {
				pWin++;
			}else if(t1==1 && t2==2) {
				tWin++;
			}else if(t1==1 && t2==0) {
				gWin++;
			}else if(t1==2 && t2==0) {
				pWin++;
			}else if(t1==2 && t2==1) {
				tWin++;
			}else {
				System.out.println(t1+"error"+t2);

			}
		}
		//Judge終了
		System.out.println(ninzu + "  " +"人" + "グー" + gWin + "勝、パー" + pWin + "勝、チョキ"
				+ tWin + "勝"+"引き分け"+draw);
	}
}
