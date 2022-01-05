package com.nortal.platformer.input;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.nortal.platformer.exception.HandledException;


public class CsvReaderTest {

		@Test
		public void csvReaderTest() throws HandledException {
			int expected = 6;
			ArrayList<String> fileData = CsvReader.readFile("platforms.csv");
			int actual = fileData.size();
			
			assertEquals(expected, actual);
			
		}

}
