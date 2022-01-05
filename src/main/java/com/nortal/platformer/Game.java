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

    public Game(String gameFile) {
        this.gameFile = gameFile;
    }

    public void run() throws HandledException {
        List<Platform> platforms = readPlatforms();

        // TODO: Implement your mighty algorithm and jump to oblivion.
//        activePlatform = platforms.get(0);
//        Platform nextPlatform = findNextPlatform(activePlatform);
//        jumpTo(nextPlatform);

    }

    /**
     * Reads platforms from csv file and returns the as list.
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
     * @param platform - Platform that you are going to jump to.
     */
    public void jumpTo(Platform platform) {
        activePlatform = platform;
    }
}
