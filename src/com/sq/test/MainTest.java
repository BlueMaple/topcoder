package com.sq.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.srm145.div1.Bonuses;
import com.srm145.div2.ExerciseMachine;

public class MainTest {
	public static void main(String[] args) {
//		System.out.print((int)'A');
		ExerciseMachine b = new ExerciseMachine();
		int result = b.getPercentages("00:19:16");
		System.out.println(result);
	}
	
	private void MSTest(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			String input = reader.readLine();
			int cases = Integer.parseInt(input);
			for (int i = 0; i < cases; i++) {
				String NMStr = reader.readLine();
				String[] temp = NMStr.split(" ");
				int[] NM = new int[2];
				NM[0] = Integer.parseInt(temp[0]);
				NM[1] = Integer.parseInt(temp[1]);

				String initStr = reader.readLine();
				temp = initStr.split(" ");
				int[] init = new int[NM[1]];
				for (int index = 0; index < NM[1]; index++) {
					init[index] = Integer.parseInt(temp[index]);
				}

				Map<Integer, int[]> moduleMap = new HashMap<Integer, int[]>();
				
				readMap(moduleMap, NM[0], reader);
				
				calModules(init , moduleMap);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void calModules(int[] init, Map<Integer, int[]> moduleMap) {
		int[][] matrix = new int[moduleMap.size()][moduleMap.size()];
		for(int i = 0 ; i < moduleMap.size() ; i++){
			for(int j = 0 ; j < moduleMap.size() ; j++){
				if(i == j)
					matrix[i][j] = 0;
				else
					matrix[i][j] = calMatrix(i , j , moduleMap);
			}
		}
		
		int[] result = new int[moduleMap.size()];
		addExecution(init , matrix , result , moduleMap);
//		for(int index = 0 ; index <result.length ; index++)
//			System.out.println(result[index]+" ");
	}

	private static void addExecution(int[] init, int[][] matrix, int[] result,
			Map<Integer, int[]> moduleMap) {
		for(int i = 0 ; i < moduleMap.size() ; i++){
			for(int j = 0 ; j < moduleMap.size() ; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int calMatrix(int i, int j, Map<Integer, int[]> moduleMap) {
		int[] iOut = moduleMap.get(i);
		int jIn = moduleMap.get(j)[0];
		for(int index = 1 ; index < iOut.length ; index++){
			if(iOut[index] == jIn)
				return 1;
		}
		
		return 0;
	}

	private static void readMap(Map<Integer, int[]> moduleMap, int row,
			BufferedReader reader) throws IOException {
		for(int i = 0 ; i < row ; i++){
			String module = reader.readLine();
			String[] temp = module.split(" ");
			int in = Integer.parseInt(temp[0]);
			int outNumb = Integer.parseInt(temp[1]);
			int[] out = new int[outNumb+1];
			out[0] = in;
			for(int index = 1 ; index < outNumb+1 ; index++){
				out[index] = Integer.parseInt(temp[index+1]);
			}
			
			moduleMap.put(row, out);
		}
	}

}
