package com.java.mini;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MiniProject {
	private static String rootPath = System.getProperty("user.dir") + "\\file\\";
	private static String filename = rootPath + "PhoneDB.txt";
	private static String target = rootPath + "PhoneDB-filtered.txt";
	private static String copy = rootPath + "PhoneDB-copy.txt";

	public static void main(String[] args) {

		List<Mini> rlist = new ArrayList<Mini>();
		File file = new File(filename);
		String[] mySplit;
		try 
			{
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
				Iterator<Mini> it = list.iterator();
				while (it.hasNext()) {
					it.next().draw();
				}
				System.out.println();
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "2":
				aadd(list);
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "3":
				rremove(list);
				System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
				System.out.print(">메뉴번호: ");
				i = sc.next();
				System.out.println();
				break;
			case "4":

				System.out.println("<4.필터>");
				System.out.print("이름: ");
				String name = sc.next();
				it = list.iterator();
				while (it.hasNext()) {
				
				if (list.contains(name)) {
					
				}
				}
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


	public static void aadd(List<Mini> list) {
//		try
//		(
//				// 스트림 열고
//				Writer writer = new FileWriter(filename);)
//		{
			
		
		Scanner sc = new Scanner(System.in);
		System.out.println("<2.등록>");
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("휴대전화: ");
		String phone = sc.next();
		System.out.print("회사전화: ");
		String home = sc.next();
		Mini line = new Mini(name, phone, home);
		list.add(line);
		System.out.println(list.toString());
//		writer.write(line.toString());
//		writer.write(name + "," + phone + "," + home);
//		
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
	}

	public static void rremove(List<Mini> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("<3.삭제>");
		int line = sc.nextInt();
		list.remove(line - 1);
	}

	public static void filter(List<Mini> list) {

	}
}
