package com.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrowserCaching {
	public void read(){
		Scanner sc = new Scanner(System.in);
		String[] factors = sc.nextLine().split(" ");
		int urls = Integer.parseInt(factors[0]);
		int pages = Integer.parseInt(factors[1]);
		Map<String , Boolean> cache = new HashMap<String, Boolean>();
		String res = "\n";
		for(int i = 0 ; i < urls ; i++){
			String url = sc.nextLine();
			System.out.println(url);
			if(cache.containsKey(url)){
				res += "Cache"+"\n";
				cache.remove(url);
			}else{
				res += "Interent"+"\n";
				cache.put(url, true);
			}
		}
		System.out.println(res);
		sc.close();
	}
}
