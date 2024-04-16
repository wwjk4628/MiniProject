package com.java.realproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.java.minixxxxxxxxx.Mini;

public class MiniApp {
	private static String rootPath = System.getProperty("user.dir") + "\\file\\";
	private static String fileName = rootPath + "PhoneDB.txt";

	public static void main(String[] args) {
		List<Mini> rlist = new ArrayList<Mini>();
		File file = new File(fileName);
		String[] mySplit;
		try {
			Scanner sc = new Scanner(file);
			Mini hum;
			String line;
			String name;
			String phone;
			String hp;
			while (sc.hasNext()) {
				line = sc.next();
				mySplit = line.split(",");
				name = mySplit[0];
				phone = mySplit[1];
				hp = mySplit[2];
				hum = new Mini(name, phone, hp);
				rlist.add(hum);
			}
			console(rlist);

		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}

	}

	public static void console(List<Mini> list) {
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
				View(list);
				System.out.println();
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "2":
				add(list);
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "3":
				remove(list);
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "4":

				
				filter(list);
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
		System.out.println("*           감사합니다             *");
		System.out.println("*********************************");

	}

	
	public static void View(List<Mini> list) {
		File file = new File(fileName);
		String[] mySplit;
		int i = 1;
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			String hum;
			while (sc.hasNext()) {
				hum = sc.next();
				mySplit = hum.split(",");
				Mini line = new Mini(mySplit[0], mySplit[1], mySplit[2]);
				System.out.print(i++ + " ");
				line.draw();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static void add(List<Mini> list) {

		try (

				Writer fw = new FileWriter(fileName);
				BufferedWriter bw = new BufferedWriter(fw);) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("<2.등록>");
			System.out.print("이름: ");
			String name = scanner.next();
			System.out.print("휴대전화: ");
			String phone = scanner.next();
			System.out.print("회사전화: ");
			String home = scanner.next();
			Mini line = new Mini(name, phone, home);
			list.add(line);
			for (Mini n : list) {
				bw.write(n.toString());
				bw.newLine();
			}
		} catch (Exception e) {

		}
	}

	public static void remove(List<Mini> list) {

		try (

				Writer fw = new FileWriter(fileName);
				BufferedWriter bw = new BufferedWriter(fw);) {
			Scanner sc = new Scanner(System.in);
			System.out.println("<3.삭제>");
			int line = sc.nextInt();
			list.remove(line-1);
			for (Mini n : list) {
				bw.write(n.toString());
				bw.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void filter(List<Mini> list) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("<4.필터>");
		System.out.print("이름: ");
		String name = scanner.next();
		for (Mini n : list) {
			if (n.getName().contains(name)) {
				n.draw();
			}
		}

	}
}
