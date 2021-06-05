package codeanalyzer;

import java.util.Map;

/**
 * Interface to declare the metrics exporters New metrics exporters can be a
 * added easily
 * 
 * @author stef4k
 *
 */
public interface MetricsExporter {
	public void writeFile(Map<String, Integer> metrics, String filepath);

}
