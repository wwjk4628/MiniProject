package com.java.mini.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MiniProject {
	private static String rootPath = System.getProperty("user.dir") + "\\file\\";
	private static String filename = rootPath + "PhoneDB.txt";
	private static String target = rootPath + "PhoneDB-filtered.txt";
	
	
	public static void main(String[] args) {
		List<String> lst = new LinkedList<>();
		
		String[] mySplit;
		Scanner sc = new Scanner(System.in);
		
		lst.add("고길동,010-8788-8881,032-8890-2974");
		lst.add("둘리,010-1212-3434,02-5678-8765");
		lst.add("마이콜,010-7102-6327,02-9192-5069");
		lst.add("또치,010-6514-5113,02-7976-9368");
		lst.add("홍길동,010-7777-7777,02-3333-3333");
		
		System.out.println("*********************************");
		System.out.println("*\t전화번호 관리 프로그램\t*");
		System.out.println("*********************************");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println(">메뉴번호: ");
		
		String i = sc.next();
		System.out.println();
		while (!i.equals("5")) {
			Iterator<String> it = lst.iterator();
			switch (i) {
			case "1":
				int a = 1;
				
				while(it.hasNext()) {	//	뒤에 더 있음?
					String item = it.next();	//	요소 추출 후 다음으로 이동
					mySplit = item.split(",");
					Mini ar = new Mini(mySplit[0], mySplit[1], mySplit[2]);
					ar.setName(mySplit[0]);
					ar.setPhone(mySplit[1]);
					ar.setHp(mySplit[2]);
					ar.toString();
					System.out.print(a++ + " " + ar.getName() + " " + ar.getPhone() + " " + ar.getHp());
					System.out.println();
					
				}
				
				System.out.println();
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "2":
				
				System.out.println("<2.등록>");
				System.out.print("이름: ");
				String name = sc.next();
				
				System.out.print("휴대전화: ");
				String phone = sc.next();
				
				System.out.print("회사전화: ");
				String home = sc.next();
				
				String tmp = name + "," + phone + "," + home ;
				lst.add(tmp);
				
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "3":
				int n = sc.nextInt();
				lst.remove(n);
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "4":
				filter();
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;

			default:
				System.out.println("1~5의 숫자를 입력해주세요.");
				i = sc.next();
				System.out.println();
				break;
			}
		}
		sc.close();
		System.out.println("*********************************");
		System.out.println("*\t    감사합니다    \t        *");
		System.out.println("*********************************");

	}
	public static void filter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<2.등록>");
		System.out.print("이름: ");
		String name = sc.next();
		try ( // 주스트림 연결
				Reader fr = new FileReader(filename);
				Writer fw = new FileWriter(target);
				// 보조 스트림 연결
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);
		// 라인단위 문자열 작업 -> Buffer 기능 사용
		) {
			// 한줄 단위로 읽고 쓰는데 특화
			String line = "";

			while ((line = br.readLine()) != null) {
//				System.out.println(line);
				// leaf, leaves가 들어있는 라인만 필터링
				if (line.toLowerCase().contains(name)) {
//					System.out.println(line);
					// 필터링된 라인만 별도 저장
					bw.write(line);
					bw.newLine();
				}

			}

		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (
				// 스트림 열기
				Reader fr = new FileReader(target); // filename을 읽어들임
				BufferedReader br = new BufferedReader(fr); // fr
		) {
			String line; // 한 줄을 읽어오기 위한 변수
			int i = 1;
			while ((line = br.readLine()) != null) {
				// 토크나이징
				StringTokenizer st = new StringTokenizer(line, ",");
				System.out.print(i++);
				while (st.hasMoreTokens()) { // 뒤에 토큰이 더 있는가?
					String token = st.nextToken();
					System.out.printf(" %s", token);
				}
				System.out.println();
			}

			br.close(); // 보조 스트림을 닫으면 주스트림도 닫힌다.

		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		
	}

