package com.sq.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.algorithms.*;
import com.leetcode.*;

class Test {
	static {
		System.out.println("父类static 块 1  执行");
	}
	static Sample staticSam1 = new Sample("父类 静态成员staticSam1初始化");
	Sample sam1 = new Sample("父类 sam1成员初始化");
	static Sample staticSam2 = new Sample("父类 静态成员staticSam2初始化");
	static {
		System.out.println("父类 static 块 2  执行");
	}

	Test() {
		System.out.println("父类 Test默认构造函数被调用");
	}

	Sample sam2 = new Sample("父类 sam2成员初始化");

}

class Sample {
	Sample(String s) {
		System.out.println(s);
	}

	Sample() {
		System.out.println("Sample默认构造函数被调用");
	}
}

public class MainTest extends Test {
	static Sample staticSamSub = new Sample("子类 静态成员staticSamSub初始化");

	MainTest() {
		System.out.println("子类 TestSub 默认构造函数被调用");
	}

	Sample sam1 = new Sample("子类 sam1成员初始化");
	static Sample staticSamSub1 = new Sample("子类 静态成员staticSamSub1初始化");

	static {
		System.out.println("子类 static 块  执行");
	}
	Sample sam2 = new Sample("子类 sam2成员初始化");
	
	public void myMethod(int a) {
		System.err.println("int");
	}
	public void myMethod(Test t) {
		System.err.println("Integer");
	}

	public void myMethod(Object obj) {
		System.err.println("object");
	}

	public static void main(String[] args) {		
		System.out.println(12-11.75 == 0.25);
		// Integer a1 = 127;
		// Integer a2 = 127;
		// System.out.println(a1 == a2);
		//
		// Integer b1 = 128;
		// Integer b2 = 128;
		// System.out.println(b1 == b2);
		// Integer b3 = 100;
		// Integer b4 = 100;
		// Integer b5 = 130;
		// System.out.println(b3 == b4 + 0);
		// System.out.println(b5 == b4 + 30);
		//
		// Double c1 = 120.0;
		// Double c2 = 120.0;
		// System.out.println(c1 == c2);
		// double c3 = 120.0;
		// double c4 = 120.0;
		// System.out.println(c3 == c4);
		//
		// String d1 = "aaa";
		// String d2 = "aaa";
		// System.out.println(d1 == d2);
		// String d3 = new String("aaa");
		// String d4 = new String("aa");
		// System.out.println(d3.equals(d4 + "a"));
	}
}
