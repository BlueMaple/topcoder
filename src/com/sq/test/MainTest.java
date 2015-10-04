package com.sq.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.algorithms.*;
import com.leetcode.*;

public class MainTest {
	public static void main(String[] args) {
		char test = 'a';
		int haha = test ^ 256;
		int hehe = haha ^ 256;
		
		System.out.println((char)haha);
		System.out.println((char)hehe);
	}
}