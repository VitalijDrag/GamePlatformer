package com.nortal.platformer.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.nortal.platformer.exception.HandledException;

public class CsvReader {

	public static ArrayList<String> readFile(String fileName) throws HandledException {
		InputStream is = CsvReader.class.getClassLoader().getResourceAsStream(fileName);

		try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {
			
			ArrayList<String> fileData = new ArrayList<String>();

			String line;
			while ((line = reader.readLine()) != null) {
				fileData.add(line);
			} 
			return fileData;

		} catch (IOException e) {
			throw new HandledException("Can't read file: " + fileName, e);
		}

	}

}
