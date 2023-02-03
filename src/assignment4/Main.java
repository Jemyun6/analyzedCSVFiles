package assignment4;

import java.io.*;
import java.lang.reflect.Array;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import java.util.*;

public class Main {
	static List<measurement> measurement1 = new ArrayList<>();
	static String[] cols = null;

	public static void main(String[] args) {
		// open hly3723.csv
		File csv = new File("D:\\eclipse\\S2\\Assignment4-Xinyi Yun\\assignment4\\hly3723.csv");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "gbk"));

		} catch (Exception e) {
			// handle exception
		}
		String line = "";
		String everyLine = "";
		ArrayList<String> allString = new ArrayList<String>();
       // create a List to accept the dataset
		int low = 0;
		try {
			while ((line = br.readLine()) != null) {
				allString.add(line);
				// allString contains the full content of hly3723.csv
				if (allString.size() > low && low > 23) {// sikps lines 1-24
					everyLine = line;
					cols = everyLine.split(",");//Array cols[] collects each data that  split by ","
					
					String date = cols[0];
					DateTimeFormatter df = new DateTimeFormatterBuilder()
							// case insensitive to parse JAN and FEB
							.parseCaseInsensitive()
							// add pattern
							.appendPattern("dd-MMM-yyyy HH:mm")
							// create formatter (use English Locale to parse month names)
							.toFormatter(Locale.ENGLISH);

					LocalDateTime day = LocalDateTime.parse(date, df);

					//parse string to double 
					double temp = Double.parseDouble(cols[4]);
					double rain = Double.parseDouble(cols[2]);
					double wetb = 0;
					//There are some empty  wetb data in hly3723.csv
					if (cols[6].isEmpty()) {
						  wetb = 0;
                    if (!cols[6].isEmpty()) {
						  wetb = Double.parseDouble(cols[6]);
					}
					}
					
					double dewpt = Double.parseDouble(cols[7]);
					double vappr = Double.parseDouble(cols[8]);
					double rhum = Double.parseDouble(cols[9]);
					double msl = Double.parseDouble(cols[10]);
					double wdsp = Double.parseDouble(cols[12]);
					double wddir = Double.parseDouble(cols[14]);
					double sun = Double.parseDouble(cols[17]);
					//create an instance m
                    measurement m = new measurement(day, temp, rain, wetb, dewpt, vappr, rhum, msl, wdsp, wddir, sun);
					measurement1.add(m);//add m to the list
				}
				low++;
			}
			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 1. The maximum temperature ever recorded in the dataset
		double maxTemp = measurement1.stream().mapToDouble(measurement::getTemp).max().getAsDouble();
		System.out.println("Q1 Maximun temperature all data points: " + maxTemp);

		// 2. The average amount of sunshine per hour in the dataset
		double aveSun = measurement1.stream().mapToDouble(measurement::getSun).average().getAsDouble();
		System.out.println("Q2 Average sunshine hours all datapoints: " + aveSun);

		// 3. The total amount of rainfall over all the datapoints
		double sumRain = measurement1.stream().mapToDouble(measurement::getRain).sum();
		System.out.println("Q3 Total rainfall all datapoints: " + sumRain);

		// 4. Total number of hours of sunshine in November 2001
		List<measurement> sunFilter = measurement1.stream().filter(str -> str.toString().contains("2001-11-"))
				.collect(Collectors.toList());//List sunFilter contains the data of Nov 2001
		double sumSun = sunFilter.stream().mapToDouble(measurement::getSun).sum();
		System.out.println("Q4 Total sunshine hours in November 2001: " + sumSun);

		// 5. The number of datapoints where rainfall was greater than 5mm
		List<measurement> rainFilter = measurement1.stream().filter(r -> r.getRain() > 5).collect(Collectors.toList());
		System.out.println("Q5 The number of hours where rainfalls was greater than 5mm : " + rainFilter.size());

		// 6. The list of dates and times when Mean Sea level pressure exceeded 1047.2
		// hPa
		List<measurement> mslFilter = measurement1.stream().filter(p -> p.getMsl() > 1047.2)
				.collect(Collectors.toList());
		System.out.println("Q6 The list of times when MSL pressure exceeded 1047.2 hPa: ");
		mslFilter.forEach(t -> System.out.print(" " + t.getDateTime()));
		System.out.println();

		System.out.println("total line in the dataset:" + allString.size());

	};

}
