package com.java.mini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MiniProject {
	private static String rootPath = System.getProperty("user.dir") + "\\file\\";
	private static String filename = rootPath + "PhoneDB.txt";
	private static String target = rootPath + "PhoneDB-filtered.txt";
	private static String copy = rootPath + "PhoneDB-copy.txt";

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("*********************************");
		System.out.println("*\t전화번호 관리 프로그램\t*");
		System.out.println("*********************************");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.print(">메뉴번호: ");
		String i = sc.next();
		System.out.println();

		while (!i.equals("5")) {
			switch (i) {
			case "1":
				token();
				System.out.println();
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "2":
				add();
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "3":

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

	public static void token() {
		try (
				// 스트림 열기
				Reader fr = new FileReader(filename); // filename을 읽어들임
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

	public static void add() {
		Scanner sc = new Scanner(System.in);
		System.out.println("<2.등록>");
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("휴대전화: ");
		String phone = sc.next();
		System.out.print("회사전화: ");
		String home = sc.next();
		String line = "";
		try ( // 주스트림 연결
				Reader fr = new FileReader(filename);
				Writer fw = new FileWriter(copy);
				// 보조 스트림 연결
				BufferedReader br = new BufferedReader(fr);
				BufferedWriter bw = new BufferedWriter(fw);
		// 라인단위 문자열 작업 -> Buffer 기능 사용
		) {
			while ((line = br.readLine()) != null) {
				line = br.readLine();
				bw.write(line);
				bw.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void remove() {

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
