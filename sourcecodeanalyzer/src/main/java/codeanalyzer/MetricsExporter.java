package codeanalyzer;

import java.util.Map;

public interface MetricsExporter {
	public void writeFile(Map<String, Integer> metrics, String filepath);

}
