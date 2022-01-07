package com.nortal.platformer.input;

import java.util.ArrayList;
import java.util.List;

import com.nortal.platformer.Platform;

public class CsvParser {

	public static final int HEADER_LINE_NUMBER = 0;

	public static List<Platform> parseFile(List<String> dataList) {
		
		ArrayList<Platform> parsedData = new ArrayList<Platform>();
	
		dataList.remove(HEADER_LINE_NUMBER);
		for (String line : dataList) {
			String[] splitLine = line.split(", ");
			parsedData.add(Platform.builder()
			.index(Integer.parseInt(splitLine[0]))
			.cost(Integer.parseInt(splitLine[1])).build());
		}
		
		return parsedData;
		
	}

}
