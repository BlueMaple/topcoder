package com.srm144.div2;

/*
 * Problem Statement
 * Computers tend to store dates and times as single numbers which represent the number of 
 * seconds or milliseconds since a particular date. 
 * Your task in this problem is to write a method whatTime, 
 * which takes an int, seconds, representing the number of seconds since midnight on some day, 
 * and returns a String formatted as "<H>:<M>:<S>". 
 * Here, <H> represents the number of complete hours since midnight, 
 * <M> represents the number of complete minutes since the last complete hour ended, 
 * and <S> represents the number of seconds since the last complete minute ended. 
 * Each of <H>, <M>, and <S> should be an integer, with no extra leading 0's. 
 * Thus, if seconds is 0, you should return "0:0:0", while if seconds is 3661, 
 * you should return "1:1:1".
 */
/*
Class:Time
Method:whatTime
Parameters:int
Returns:String
Method signature:String whatTime(int seconds)
 */
public class Time {
	
	public String whatTime(int seconds){
		int tempSeconds = 0;
		int hour = seconds/3600;
		tempSeconds = seconds%3600;
		int minute = tempSeconds/60;
		tempSeconds = tempSeconds%60;
		int second = tempSeconds;
		
		return hour+":"+minute+":"+second;
	}
}
