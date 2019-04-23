package com.smi;

import java.util.Scanner;

public class CabinetsPartitioning {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCases = Integer.parseInt(scanner.nextLine().trim());
		for (int t = 0; t < testCases; t++) {
			String[] workersAndJobs = scanner.nextLine().trim().split(" ");
			int numberOfJobs = Integer.parseInt(workersAndJobs[0]);
			int numberOfWorkers = Integer.parseInt(workersAndJobs[1]);
			String[] jobTime = scanner.nextLine().trim().split(" ");
			int[] job = new int[numberOfJobs];
			long totalTimeForJob = 0;
			int max = 0;
			for (int i = 0; i < numberOfJobs; i++) {
				int eachJob = Integer.parseInt(jobTime[i]);
				job[i] = eachJob;
				totalTimeForJob += eachJob;
				if (eachJob > max) {
					max = eachJob;
				}
			}

			long lo = max, hi = totalTimeForJob;
			long mid = 0;
			long ans = 0;
			while (lo <= hi) {
				mid = lo + (hi - lo) / 2;
				if (isValid(mid, job, numberOfWorkers)) {
					ans = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			System.out.println(ans);

		}
	}

	public static boolean isValid(long time, int[] job, int numberOfWorkers) {
		if(time == 38) {
		}
		int workersCount = 0;
		long eachWorkerTimeCount = 0;
		for (int i = 0; i < job.length; i++) {
			eachWorkerTimeCount += job[i];
			if (eachWorkerTimeCount > time) {
				eachWorkerTimeCount = job[i];
				workersCount++;
			} else if (eachWorkerTimeCount == time) {
				eachWorkerTimeCount = 0;
				if(i != job.length-1) {
					workersCount++;
				}
			} 

		}
		return workersCount < numberOfWorkers;
	}
}
