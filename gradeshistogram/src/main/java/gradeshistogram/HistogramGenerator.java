package gradeshistogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * This program reads a text file inputed as a cmd argument and
 * creates a histogram for the counts of values in that file
 * @author stef4k
 * @version 1.0
 * @since 2021-04-01
 */
public class HistogramGenerator {

	int excellence_grade = 10; //defines the best grade a student can get in the system
	
	/**
	 * Method that gets an Arraylist as input and creates a histogram of the grades count
	 * @param dataValues
	 */
	public void generateChart(ArrayList<Integer> dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");
		
		// the @counts array will contain the times each grade appears
		int[] counts = new int[excellence_grade + 1];
		/*
		 * Filling the counts array so that e.g. k element of counts will 
		 * contain the times that the k grade has been achieved
		 */
		for (int i = 0; i < dataValues.size(); i++) {
			counts[dataValues.get(i)]++;
		}
		
		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < counts.length; i++) {
			data.add(i, counts[i]);
		}
		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createHistogram("Grades Histogram", "Grade", "Counts", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

	/**
	 * Method that reads a file, line by line and 
	 * creates an ArrayList of integers with all the integers found in the file
	 * @param readFromFile
	 * @return ArrayList<Integer>
	 */
	public static ArrayList<Integer> readfile(Scanner readFromFile) {
		String line = null;
		ArrayList<Integer> dataValues = new ArrayList<Integer>();
		// keeps looping if file has more lines..
		while (readFromFile.hasNextLine()) {
			// get a line of text..
			line = readFromFile.nextLine();
			// append the integer found in the line to the ArrayList
			dataValues.add(Integer.parseInt(line));
		}
		return dataValues;
	}

	public static void main(String[] args) {
		// ArrayList used for the values of the text file
		ArrayList<Integer> dataValues = new ArrayList<Integer>();
		
		// initialize variables used for reading file from cmd
		File file = null;
		Scanner readFromFile = null;
		
		/*
		 * Error Checking For Command Line Arguments.. If no command line arguments are
		 * entered, the size of the String array args is zero (0)
		 */
		if (args.length == 0) {
			System.out.println("ERROR: Please enter the file name as the first commandline argument!");
			// end the program
			System.exit(1);
		}
		// connect to a file (does NOT create a new file)
		file = new File(args[0]);
		try {
			// create a Scanner object to read from the file
			readFromFile = new Scanner(file);
		} catch (FileNotFoundException exception) {
			/*
			 * Print error message. In order to print double quotes("), the escape sequence
			 * for double quotes (\") must be used.
			 */
			System.out.print("ERROR: File not found for \"");
			System.out.println(args[0] + "\"");
			// end the program
			System.exit(1);
		}
		// if made connection to file, read from file
		System.out.print("Reading from file \"" + args[0] + "\":\n");
		
		// call method readfile() to read integers and create an ArrayList
		dataValues = readfile(readFromFile);

		// create a new instance of HistogramGenerator
		HistogramGenerator demo = new HistogramGenerator();
		// design a new histogram for the ArrayList created
		demo.generateChart(dataValues);
	}
}