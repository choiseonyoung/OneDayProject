package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV2 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;
	Integer intScore; // string형으로 받은 점수를 int형으로 변환하기 위한 변수

	public ScoreServiceV2() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
		intScore = null;
	}

	public void menu() {
		String strSelect = null; // 선택한 메뉴를 담을 변수
		Integer intSelect; // 선택한 메뉴를 int형으로 변환해서 담을 변수
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
				System.out.println("-끝-");
				return;
			}
			try {
				intSelect = Integer.valueOf(strSelect); // string형 메뉴를 int형으로 변환
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("### 메뉴는 1, 2, QUIT만 입력 가능 ###");
				continue;
			}
			if (intSelect == 1) {
				inputScore();
			} else if (intSelect == 2) {
				printScore();
			} else {
				System.out.println("### 메뉴는 1, 2, QUIT만 입력 가능 ###");
				continue;
			}
			
		}
	}

	public void inputScore() {
		ScoreVO sv = new ScoreVO();
		String name = null; // 사용자가 입력한 사용자 이름 담을 변수
		Integer score;
		
		System.out.println(Lines.dLine(100));
		System.out.println("학생이름을 입력하세요(입력을 중단하려면 QUIT)");
		System.out.println(Lines.dLine(100));
		while (true) {
			System.out.println("이름 >> ");
			name = scan.nextLine(); // 사용자가 이름 입력
			if (name.equals("QUIT")) { // 입력을 중단
				return; // 입력을 중단하면 처음 menu 화면 나타남
			} else if (name.equals("")) {
				System.out.println("이름은 반드시 입력해야 합니다");
				continue;
			} else {
				sv.setName(name);
				break;
			}
		}

		System.out.println(Lines.dLine(100));
		System.out.printf("%s 학생의 성적을 입력하세요 (성적범위 : 0 ~ 100, 입력을 중단하려면 QUIT)\n", sv.getName());
		System.out.println(Lines.dLine(100));

		while (true) {
			System.out.print("국어 >> ");
			score = inputS(sv);
			if (score == null) {
				return;
			} else {
				sv.setKor(score);
			}
			
			System.out.print("영어 >> ");
			score = inputS(sv);
			if (score == null) {
				return;
			} else {
				sv.setEng(score);
			}
			
			System.out.print("수학 >> ");
			score = inputS(sv);
			if (score == null) {
				return;
			} else {
				sv.setMath(score);
			}
			
			System.out.print("과학 >> ");
			score = inputS(sv);
			if (score == null) {
				return;
			} else {
				sv.setSci(score);
			}
			
			System.out.print("역사 >> ");
			score = inputS(sv);
			if (score == null) {
				return;
			} else {
				sv.setHis(score);
			}
			
			sv.setTotal(totalScore(sv)); // 이 학생의 총점 저장
			sv.setAvg(avgScore(sv)); // 이 학생의 평균 저장
			
			scoreList.add(sv); // 이 학생의 성적을 리스트에 추가
			
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
		
		return;
	}

	
	public Integer inputS(ScoreVO sv) { // 점수 입력 method
		String strScore;
		while (true) {
			strScore = scan.nextLine(); // 점수 입력 받음
			if (strScore.equals("QUIT")) { // QUIT가 입력되면 다시 메뉴로 돌아감
				return null; // ## Integer 쓰는 이유 : null을 리턴할 수 있음 -1을 입력할 경우도 생기니까
			}
			try {
				intScore = Integer.valueOf(strScore); // string형 점수를 int형 점수로 변환
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("점수 입력 오류");
				System.out.println("### 점수는 0 ~ 100, QUIT만 입력 가능 다시 입력하세요 ###");
				System.out.println(">> ");
				continue;
			}
			if (intScore >= 0 && intScore <= 100) { // 점수 유효성 검사
				return intScore;
			} else {
				System.out.println("### 성적 범위는 0 ~ 100 입니다 다시 입력하세요 ###");
				System.out.print(">> ");
				continue;
			}
		}
	}
	
	public Integer totalScore(ScoreVO sv) {
		return sv.getKor() + sv.getEng() + sv.getMath() + sv.getSci() + sv.getHis();
	}
	
	public float avgScore(ScoreVO sv) {
		return sv.getTotal() / (float)5;
	}

	public void printScore() { // ## 과목이름, total들 배열로

		ScoreVO sv = new ScoreVO();
		int[] totals = new int[7];
		System.out.println(Lines.dLine(100));
		System.out.println("순번\t이름\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println(Lines.sLine(100));
		
		
		for (int i = 0; i < scoreList.size(); i++) {
			sv = scoreList.get(i);
			System.out.printf("%3d\t%s\t%3d\t%3d\t%3d\t%3d\t%3d\t%3d\t%3.2f\n", i+1, sv.getName(), sv.getKor(), sv.getEng(), sv.getMath(), sv.getSci(), sv.getHis(), sv.getTotal(), sv.getAvg() );
			
			totals[0] += sv.getKor();
			totals[1] += sv.getEng();
			totals[2] += sv.getMath();
			totals[3] += sv.getSci();
			totals[4] += sv.getHis();
			totals[5] += sv.getTotal();
			totals[6] += sv.getAvg();
		}
		
		float avg = (float)totals[6] / scoreList.size();
		
		System.out.println(Lines.dLine(100));
		System.out.printf("총점\t\t");
		
		for(int i = 0 ; i < totals.length-1 ; i++)  {
			System.out.printf("%3d\t",totals[i]);
		}
		System.out.printf("%3.2f\n",avg);
		System.out.println(Lines.dLine(100));
		
		
	}
}