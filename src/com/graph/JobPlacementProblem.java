package com.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobPlacementProblem {

	public static void main(String[] args) {

		JobPlacementProblem obj = new JobPlacementProblem();
		obj.runCPM();

	}

	public void runCPM() {

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("job_placement.txt").getFile());
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			Map<String, Integer> jobsMap = new HashMap<String, Integer>();
			Map<String, Integer> studentsMap = new HashMap<String, Integer>();
			List<List<Integer>> studentJobs = new ArrayList<>();
			int studentsCount = 0;
			int jobCount = 0;
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				String[] nameAndJobs = line.split("\\s");
				studentsMap.put(nameAndJobs[0], studentsCount++);
				for (int i = 1; i < nameAndJobs.length; i++) {
					if (!jobsMap.containsKey(nameAndJobs[i])) {
						jobsMap.put(nameAndJobs[i], jobCount++);
					}

				}

			}
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			int totalCount = jobsMap.size() + studentsMap.size();
			int s = totalCount;
			int t = totalCount + 1;
			FlowNetwork flowNetwork = new FlowNetwork(totalCount + 2);
			boolean[] isJobToSourceEdgeAdded = new boolean[jobCount];
			while ((line = bufferedReader.readLine()) != null) {
				String[] nameAndJobs = line.split("\\s");
				int v = studentsMap.get(nameAndJobs[0]);
				flowNetwork.addEdge(new FlowEdge(s, v, 1));
				for (int i = 1; i < nameAndJobs.length; i++) {
					flowNetwork.addEdge(new FlowEdge(v, studentsMap.size() + jobsMap.get(nameAndJobs[i]), 1));
					if (!isJobToSourceEdgeAdded[jobsMap.get(nameAndJobs[i])]) {
						flowNetwork.addEdge(new FlowEdge(studentsMap.size() + jobsMap.get(nameAndJobs[i]), t, 1));
					}
				}

			}
			fileReader.close();

			FordFulkerson ff = new FordFulkerson(flowNetwork, s, t);
			System.out.println(ff.value);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
