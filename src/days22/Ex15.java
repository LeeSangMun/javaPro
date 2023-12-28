package days22;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * @author sangmun
 * @date 2023. 8. 11. - 오후 4:30:47
 * @subject	로또 게임
 * @content
 */
public class Ex15 {

	public static void main(String[] args) {
		//HashSet lotto = new HashSet();
		LinkedHashSet lotto = new LinkedHashSet();
		fillLotto(lotto);
		dispLotto(lotto);
	}

	public static void fillLotto(HashSet lotto) {
		Random rnd = new Random();
		int n;
		while(lotto.size() < 6) {
			n = rnd.nextInt(45) + 1;
			lotto.add(n);
		}
	}

	public static void dispLotto(HashSet lotto) {
		Iterator ir = lotto.iterator();
		
		while (ir.hasNext()) {
			int n = (int) ir.next();
			System.out.printf("[%d]", n);
		}
		System.out.println();
	}
	
}
