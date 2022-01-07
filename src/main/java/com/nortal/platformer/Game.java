package com.nortal.platformer;

import java.util.*;

import com.nortal.platformer.exception.HandledException;
import com.nortal.platformer.input.CsvParser;
import com.nortal.platformer.input.CsvReader;

public class Game {

	public static void main(String[] args) throws HandledException {
		Game game = new Game("platforms.csv");
		game.run();
	}

	private Integer points = 500;
	private Platform activePlatform;
	private final String gameFile;
	private List<Platform> platforms;
	private int numberOfSteps = 0;

	public Game(String gameFile) {
		this.gameFile = gameFile;
	}

	public void run() throws HandledException {
		platforms = readPlatforms();

		// Start of the game at platform 0
		activePlatform = platforms.get(0);
		activePlatform.setVisited(true);

		Platform lastPlatform = platforms.get(platforms.size() - 1);
		while (activePlatform.getIndex() != lastPlatform.getIndex()) {
			Platform nextPlatform = findNextPlatform();
			jumpTo(nextPlatform);
		}

		System.out.println("Congratulations! You have rached the final platform " + lastPlatform.getIndex() + " in "
				+ numberOfSteps + " steps.");
	}

	private Platform findNextPlatform() throws HandledException {
		Platform followingPlatform = getPlatform(activePlatform.getIndex() + 1);

		if (followingPlatform.isVisited()) {
			points = points + followingPlatform.getCost();
			return followingPlatform;
		} else if (followingPlatform.getCost() <= points) {
			points = points - followingPlatform.getCost();
			followingPlatform.setVisited(true);
			return followingPlatform;
		} else {
			Platform previousPlatform = getPlatform(activePlatform.getIndex() - 1);
			points = points + previousPlatform.getCost();
			return previousPlatform;
		}
	}

	private Platform getPlatform(int index) throws HandledException {
		try {
			return platforms.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new HandledException("Platform doesn't exist, index " + index);
		}
	}

	/**
	 * Reads platforms from csv file and returns the as list.
	 * 
	 * @return platforms - Platforms as list
	 * @throws HandledException
	 */
	private List<Platform> readPlatforms() throws HandledException {
		List<String> list = CsvReader.readFile(gameFile);
		List<Platform> parsedList = CsvParser.parseFile(list);
		return parsedList;
	}

	/**
	 * Invoke this function to jump to next platform.
	 * 
	 * @param platform - Platform that you are going to jump to.
	 */
	public void jumpTo(Platform platform) {
		numberOfSteps++;
		activePlatform = platform;
	}
}
