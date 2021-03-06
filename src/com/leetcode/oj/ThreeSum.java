package com.leetcode.oj;

import java.util.*;

/**
 * Created by doliu on 9/12/14.
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		if (num == null || num.length < 3) return Collections.emptyList();
		Set<List<Integer>> result = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < num.length; i++) map.put(num[i], i);
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int sum = num[i] + num[j];
				if (map.containsKey(-sum) && map.get(-sum) != i && map.get(-sum) != j) {
					List<Integer> list  = Arrays.asList(num[i], num[j], -sum);
					Collections.sort(list);
					result.add(list);
				}
			}
		}
		return new ArrayList<>(result);
	}

	public List<List<Integer>> threeSumWithSort(int[] num) {
		if (num == null || num.length < 3) return Collections.emptyList();
		Arrays.sort(num);
		Set<List<Integer>> result = new HashSet<>();
		int target = 0;
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == target) {
					result.add(Arrays.asList(num[i], num[j], num[k]));
					j++;
					k--;
				} else if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return new ArrayList<>(result);
	}

	public ArrayList<ArrayList<Integer>> threeSumLint(int[] numbers) {
		// write your code here
		if (numbers == null || numbers.length < 3) return new ArrayList();
		Arrays.sort(numbers);
		Set<List<Integer>> result = new HashSet<>();
		for (int i = 0; i < numbers.length - 2; i++) {
			int j = i + 1, k = numbers.length - 1;
			while (j < k) {
				int sum = numbers[i] + numbers[j] + numbers[k];
				if (sum == 0) {
					result.add(Arrays.asList(numbers[i], numbers[j], numbers[k]));
					j++;
					k--;
				} else if (sum < 0)
					j++;
				else
					k--;
			}
		}
		ArrayList<ArrayList<Integer>> r = new ArrayList<>();
		for (List<Integer> l : result) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.addAll(l);
			r.add(temp);
		}
		return r;
	}
}
