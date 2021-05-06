package com.lab.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class CalculateDinasaur {

	public static List<String> readFile(String fileName) throws IOException {
		File file = new File(fileName);
		List<String> lines = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return lines;
	}

	public static void main(String[] args) throws IOException {

		List<String> file1 = readFile("/Users/jjijo/eclipse-workspace/workspace/dataset1.csv");
		List<String> file2 = readFile("/Users/jjijo/eclipse-workspace/workspace/dataset2.csv");
		Set<Dinasaur> dinasaurs = new TreeSet<Dinasaur>();
		Map<String, Dinasaur> map = new HashMap<>();
		for (String str : file1) {
			String[] split = str.split(",");
			Dinasaur d = new Dinasaur();
			d.name = split[0];
			if (d.name.equals("NAME")) {
				continue;
			}
			d.length = Float.parseFloat(split[1]);
			map.put(d.name, d);

		}

		for (String str : file2) {
			String[] split = str.split(",");
			Dinasaur d = new Dinasaur();
			d.name = split[0];
			if (d.name.equals("NAME")) {
				continue;
			}
			if (map.containsKey(d.name)) {
				Dinasaur existing = map.get(d.name);
				existing.stride = Float.parseFloat(split[1]);
			}
		}

		for (Entry<String, Dinasaur> entry : map.entrySet()) {
			float value = (entry.getValue().stride / entry.getValue().length) - 1;
			float value1 = (float) Math.sqrt(entry.getValue().length * 9.8);
			entry.getValue().result = value * value1;
			dinasaurs.add(entry.getValue());
		}

		for (Dinasaur d : dinasaurs) {
			System.out.println(d.name + ":" + d.result);
		}

	}

}

class Dinasaur implements Comparable<Dinasaur> {
	String name;
	float stride;
	float length;
	Float result;

	
	@Override
	public int compareTo(Dinasaur o) {
		return result.compareTo(o.result);
	}
}
