package com.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CriticalPathMethod {

	public static void main(String[] args) {

		CriticalPathMethod obj = new CriticalPathMethod();
		obj.runCPM();

	}

	public void runCPM() {

		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("parallelJobScheduling.txt").getFile());
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			int n = Integer.parseInt(bufferedReader.readLine());

			int source = 2 * n;
			int sink = 2 * n + 1;

			DirectedEdgeWeightedGraph graph = new DirectedEdgeWeightedGraph(2 * n + 2);

			for (int i = 0; i < n; i++) {

				String[] a = bufferedReader.readLine().split("\\s");
				double duration = Double.parseDouble(a[0]);

				graph.addEdge(new DirectedEdge(source, i, 0));
				graph.addEdge(new DirectedEdge(i + n, sink, 0));
				graph.addEdge(new DirectedEdge(i, i + n, duration));

				for (int j = 1; j < a.length; j++) {

					int successor = Integer.parseInt(a[j]);
					graph.addEdge(new DirectedEdge(i + n, successor, 0));
				}

			}

			AcyclicLP longPath = new AcyclicLP(graph, source);
			for (int i = 0; i < n; i++)
				System.out.println(i + " " + longPath.distanceTo(i));

			System.out.println("Finish time: " + longPath.distanceTo(sink));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
