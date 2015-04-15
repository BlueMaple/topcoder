package com.srm144.div1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottery_stivencyj {
	Map<Double, List<String>> rulesByOdds = new HashMap<Double, List<String>>();
	double[] factorial = new double[101];

	public String[] sortByOdds(String[] rules) {
		String[] result = new String[rules.length];
		List<String> orderedRules = new ArrayList<String>();

		for (String rule : rules) {
			String[] nameAndRule = rule.split(":");
			String name = nameAndRule[0];
			String[] ruleParts = nameAndRule[1].trim().split(" ");
			int choices = Integer.parseInt(ruleParts[0]);
			int blanks = Integer.parseInt(ruleParts[1]);
			boolean sorted = ruleParts[2].equals("T");
			boolean unique = ruleParts[3].equals("T");

			if (!sorted) {
				if (!unique) {
					insertRuleByOdds(Math.pow(choices, blanks), name);
				} else {
					insertRuleByOdds(cFacOverCMinusBFac(choices, blanks), name);
				}
			} else {
				if (!unique) {
					insertRuleByOdds(
							cFacOverCMinusBFac(choices + blanks - 1, blanks)
									/ factorial[blanks], name);
				} else {
					insertRuleByOdds(cFacOverCMinusBFac(choices, blanks)
							/ factorial[blanks], name);
				}
			}
		}
		List<Double> orderedOdds = new ArrayList<Double>(rulesByOdds.keySet());
		Collections.sort(orderedOdds);
		for (Double odds : orderedOdds) {
			orderedRules.addAll(rulesByOdds.get(odds));
		}

		return orderedRules.toArray(result);
	}

	private double cFacOverCMinusBFac(int c, int b) {
		loadFactorials();
		return factorial[c] / factorial[c - b];
	}

	private void loadFactorials() {
		if (factorial[0] != 1) {
			factorial[0] = 1;
			for (int i = 1; i <= 100; i++) {
				factorial[i] = i * factorial[i - 1];
			}
		}
	}

	private void insertRuleByOdds(Double odds, String rule) {
		List<String> allRules = rulesByOdds.get(odds);
		if (allRules == null) {
			allRules = new ArrayList<String>();
		}
		allRules.add(rule);
		Collections.sort(allRules);
		rulesByOdds.put(odds, allRules);
	}
}
