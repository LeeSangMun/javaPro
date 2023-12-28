package days12;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

import days10.Ex06_04;


/**
 * @author sangmun
 * @date 2023. 7. 28. - 오후 2:42:22
 * @subject
 * @content
 */
public class Ex05 {
	public static void main(String[] args) throws IOException {
		// 1~3반 30명 학생 이름,국,영,수,총점,평점,반등수,전교등수
		final int STUDENT_COUNT = 30;
		final int CLASS_COUNT 	 = 3;
		
		String[][] names = new String[CLASS_COUNT][STUDENT_COUNT];
		int[][][] infos = new int[CLASS_COUNT][STUDENT_COUNT][6];
		
		double[][] avgs = new double[CLASS_COUNT][STUDENT_COUNT];
	
		char con = 'y';
		int[] counts = new int[CLASS_COUNT];
		
		String name;
		int kor, eng, mat, tot, rank, wrank;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		int ban;
		
		do {
			// 1. 반 입력
			System.out.print("> 반 입력 ? ");
			ban = sc.nextInt();
			// 2. 그 반의 학생 정보 입력
			System.out.printf("> %d반의 [%d]번 학생의 이름 국어 영어 수학 입력 ? ",
					ban, counts[ban-1] + 1);
			name = Ex06_04.getName();
			kor = Ex06_04.getScore();
			eng = Ex06_04.getScore();
			mat = Ex06_04.getScore();
			
			tot = kor + eng + mat;
			avg = (double)tot / 3;
			wrank = rank = 1;
			
			names[ban-1][counts[ban-1]] = name;
			infos[ban-1][counts[ban-1]][0] = kor;
			infos[ban-1][counts[ban-1]][1] = eng;
			infos[ban-1][counts[ban-1]][2] = mat;
			infos[ban-1][counts[ban-1]][3] = tot;
			infos[ban-1][counts[ban-1]][4] = rank;
			infos[ban-1][counts[ban-1]][5] = wrank;
			avgs[ban-1][counts[ban-1]] = avg;
			
			counts[ban-1]++;
			
			System.out.print("> 입력 계속 ? ");
			con = (char)System.in.read();
			System.in.skip(System.in.available());
		} while(Character.toUpperCase(con) == 'Y');
		
		procRank(infos, counts);
		printRank(names, infos, avgs, counts);
		// 학생 정보 출력(7명)
		// [1반 학생 : 4명]
		// 1
		// 2
		// 3
		// 4
		// [2반 학생 : 2명]
	}

	private static void procRank(int[][][] infos, int[] counts) {
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				infos[i][j][4] = 1;
				infos[i][j][5] = 1;
				
				for (int i2 = 0; i2 < counts.length; i2++) {
					for (int j2 = 0; j2 < counts[i2]; j2++) {
						if(infos[i][j][3] < infos[i2][j2][3]) {
							infos[i][j][5]++;
							if(i == i2) {
								infos[i][j][4]++;
							}
						}
					} // for
					
				} // for
			} // for
		} // for
	}

	private static void printRank(String[][] names, int[][][] infos, double[][] avgs, int[] counts) {
		System.out.println();
		int countSum = IntStream.of(counts).sum();
		System.out.printf("\t\t학생 정보 출력(%d명)\n", countSum);
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("[%d반 학생 : %d명]\n", i+1, counts[i]);
			for (int j = 0; j < counts[i]; j++) {
				System.out.printf("%d. %s\t%d\t%d\t%d\t%d\t%.2f\t\t%d\t%d\n",
						j+1, names[i][j], infos[i][j][0], infos[i][j][1], infos[i][j][2],
						infos[i][j][3], avgs[i][j], infos[i][j][4],infos[i][j][5]);
			} // for
		} // for
	}
}
