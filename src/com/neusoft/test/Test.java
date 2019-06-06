package com.neusoft.test;

import java.util.Scanner;

import com.neusoft.tuling.TuLingTest;
import com.neusoft.until.TuLintUntil;

public class Test {

	public static void main(String[] args) {
		while(true) {
		Scanner scanner=new Scanner(System.in);
		String message=scanner.nextLine();
		//将图灵工具类实例化
		TuLintUntil until=new TuLintUntil();
		String result=until.getResult(message);
		System.out.println(result);
		}
	}

}
