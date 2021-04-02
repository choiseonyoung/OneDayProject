package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;

	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}

	public void menu() {
		String strSelect = null;
		Integer intSelect;
		System.out.println(Lines.dLine(100));
		System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
		while (true) {
			System.out.println(Lines.dLine(100));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println(Lines.dLine(100));
			System.out.println("업무선택 >> ");
			strSelect = scan.nextLine();
			if (strSelect.equals("QUIT")) {
				return;
			}
			try {
				intSelect = Integer.valueOf(strSelect); // string형 점수를 int형 점수로 변환
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("메뉴 선택 오류");
				System.out.println("!! 메뉴는 1, 2, QUIT만 입력 가능 !!");
				continue;
			}
			if (intSelect == 1) {
				inputName();
			} else if (intSelect == 2) {
				printScore();
			} else {
				System.out.println("메뉴는 1, 2, QUIT만 입력 가능");
			}
			
		}
	}

	public void inputName() {
		String name = null; // 사용자가 입력한 사용자 이름 담을 변수
		ScoreVO sv = new ScoreVO();
		System.out.println(Lines.dLine(100));
		System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
		System.out.println(Lines.dLine(100));
		System.out.println("이름 >> ");
		name = scan.nextLine(); // 사용자가 이름 입력
		if (name.equals("QUIT")) { // 입력을 중단
			menu(); // 입력을 중단해서 처음 menu 화면 나타남
		} else {
			sv.setName(name); 
		}
		inputScore(sv);
		menu();
	}

	public void inputScore(ScoreVO sv) { // 학생 이름을 전달받기 위해 매개변수로 sv 객체 전달받음
		String strScore;
		
		System.out.println(Lines.dLine(100));
		System.out.printf("%s 학생의 성적을 입력하세요 (성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)\n", sv.getName()); // 전달받은 sv 객체의 이름 추출
		System.out.println(Lines.dLine(100));
		
		while (true) {
			System.out.print("국어 >> ");
			strScore = scan.nextLine(); // 점수 입력 받음
			if (strScore.equals("QUIT")) { // QUIT가 입력되면 다시 메뉴로 돌아감
				return;
			}
			Integer intScore = null; // string형으로 받은 점수를 int형으로 변환하기 위한 변수 생성
			try {
				intScore = Integer.valueOf(strScore); // string형 점수를 int형 점수로 변환
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("점수 입력 오류");
				System.out.println("!! 점수는 0 ~ 100, QUIT만 입력 가능!! ");
				continue;
			}
			if (intScore >= 0 && intScore <= 100) {  // 점수 유효성 검사
				sv.setKor(intScore);
			} else {
				System.out.println("성적 범위는 0 ~ 100 입니다");
				continue;
			}
			
			System.out.print("영어 >> ");
			strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return;
			}
			try {
				intScore = Integer.valueOf(strScore);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("점수 입력 오류");
				System.out.println("점수는 0 ~ 100, QUIT만 입력 가능");
				continue;
			}
			if (intScore >= 0 && intScore <= 100) {  // 점수 유효성 검사
				sv.setEng(intScore);
			} else {
				System.out.println("성적 범위는 0 ~ 100 입니다");
				continue;
			}
			
			System.out.print("수학 >> ");
			strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return;
			}
			try {
				intScore = Integer.valueOf(strScore);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("점수 입력 오류");
				System.out.println("점수는 0 ~ 100, QUIT만 입력 가능");
				continue;
			}
			if (intScore >= 0 && intScore <= 100) {  // 점수 유효성 검사
				sv.setMath(intScore);
			} else {
				System.out.println("성적 범위는 0 ~ 100 입니다");
				continue;
			}
			
			System.out.print("과학 >> ");
			strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return;
			}
			try {
				intScore = Integer.valueOf(strScore);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("점수 입력 오류");
				System.out.println("점수는 0 ~ 100, QUIT만 입력 가능");
				continue;
			}
			if (intScore >= 0 && intScore <= 100) {  // 점수 유효성 검사
				sv.setSci(intScore);
			} else {
				System.out.println("성적 범위는 0 ~ 100 입니다");
				continue;
			}
			
			System.out.print("역사 >> ");
			strScore = scan.nextLine();
			if (strScore.equals("QUIT")) {
				return;
			}
			try {
				intScore = Integer.valueOf(strScore);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("점수 입력 오류");
				System.out.println("점수는 0 ~ 100, QUIT만 입력 가능");
				continue;
			}
			if (intScore >= 0 && intScore <= 100) {  // 점수 유효성 검사
				sv.setHis(intScore);
			} else {
				System.out.println("성적 범위는 0 ~ 100 입니다");
				continue;
			}
			
			int total = 0;
			float avg = 0.0F;

			total = sv.getKor() + sv.getEng() + sv.getMath() + sv.getSci() + sv.getHis();
			avg = (float)total / 5;
			
			sv.setTotal(total);
			sv.setAvg(avg);
			
			scoreList.add(sv);
			
			break;
		}
		System.out.println(Lines.dLine(100));
		System.out.printf("%s 학생의 성적이 추가 되었습니다\n", sv.getName());
		System.out.println(Lines.dLine(100));
		System.out.printf("국어 : %3d\n", sv.getKor());
		System.out.printf("영어 : %3d\n", sv.getEng());
		System.out.printf("수학 : %3d\n", sv.getMath());
		System.out.printf("과학 : %3d\n", sv.getSci());
		System.out.printf("역사 : %3d\n", sv.getHis());
	}

	public void printScore() {
		
		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		int totalSci = 0;
		int totalHis = 0;
		int total = 0;
		float avg1 = 0.0f;
		float avg2 = 0.0f;
		
		ScoreVO sv = new ScoreVO(); 
		System.out.println(Lines.dLine(100));
		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println(Lines.sLine(100));
		for (int i = 0; i < scoreList.size(); i++) {
			sv = scoreList.get(i);
			System.out.printf("%3d\t%s\t%3d\t%3d\t%3d\t%3d\t%3d\t%3d\t%3.2f\n", i+1, sv.getName(), sv.getKor(), sv.getEng(), sv.getMath(), sv.getSci(), sv.getHis(), sv.getTotal(), sv.getAvg() );
			totalKor += sv.getKor();
			totalEng += sv.getEng();
			totalMath += sv.getMath();
			totalSci += sv.getSci();
			totalHis += sv.getHis();
			total += sv.getTotal();
			avg1 += sv.getAvg();
		}
		
		avg2 = (float)avg1 / scoreList.size();
		
		System.out.println(Lines.dLine(100));
		System.out.printf("총점\t\t%3d\t%3d\t%3d\t%3d\t%3d\t%3d\t%3.2f\n", totalKor, totalEng, totalMath, totalSci, totalHis, total, avg2);
	}
}