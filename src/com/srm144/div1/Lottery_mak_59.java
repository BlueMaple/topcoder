package com.srm144.div1;

import java.util.Arrays;

public class Lottery_mak_59 {
	public String[] sortByOdds(String[] rules) {
		long[][] both = new long[101][9];
		long[][] uniq = new long[101][9];
		long[][] sort = new long[101][9];
		long[][] none = new long[101][9];
		
		both[10] = new long[]{0,10,45,120,210,252,210,120,45};
		uniq[10] = new long[]{0,10,90,720,5040,30240,151200,604800,1814400};
		sort[10] = new long[]{0,10,55,220,715,2002,5005,11440,24310};
		none[10] = new long[]{0,10,100,1000,10000,100000,1000000,10000000,100000000};
		
		for(int i = 11 ; i < both.length ; i++){
			both[i][1] = uniq[i][1] = sort[i][1] = none[i][1] = i;
		}
		for(int i = 11 ; i < both.length ; i++){
			for(int j = 2 ; j <= 8 ; j++){
				both[i][j] = both[i-1][j-1]+both[i-1][j];
				uniq[i][j] = uniq[i-1][j-1]*j+uniq[i-1][j];
				sort[i][j] = sort[i-1][j]+sort[i][j-1];
				none[i][j] = none[i][j-1]*none[i][1];
			}
		}
		Item[] items = new Item[rules.length];
		int inc = 0;
		for(String s : rules){
			String name = s.substring(0, s.indexOf(":"));
			String[] sp = s.substring(s.indexOf(":")+2 , s.length()).split(" ");
			int i = Integer.parseInt(sp[0]);
			int j = Integer.parseInt(sp[1]);
			boolean sorted = sp[2].equals("T");
			boolean unique = sp[3].equals("T");
			if(sorted && unique){
				items[inc] = new Item(name , both[i][j]);
			}else if(sorted && !unique){
				items[inc] = new Item(name , sort[i][j]);
			}else if(!sorted && unique){
				items[inc] = new Item(name , uniq[i][j]);
			}else if(!sorted && !unique){
				items[inc] = new Item(name , none[i][j]);
			}
			inc++;
		}

		Arrays.sort(items);
		String[] ret = new String[rules.length];
		for(int i = 0 ; i < ret.length ; i++)
			ret[i] = items[i].name;
		
		return ret;
	}
	
	class Item implements Comparable<Item>{
		public String name;
		public double prob;
		
		public Item(String name, long val){
			this.name = name;
			this.prob = 1.0/val;
		}
		
		public int compareTo(Item o) {
			// TODO Auto-generated method stub
			if(this.prob < o.prob)
				return 1;
			if(this.prob > o.prob)
				return -1;
			return this.name.compareTo(o.name);
		}
	}
}
