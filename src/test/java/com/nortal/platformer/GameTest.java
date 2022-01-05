package com.nortal.platformer;

import org.junit.Test;

import com.nortal.platformer.exception.HandledException;

public class GameTest {
	
	@Test
	public void gameTest() throws HandledException {
		
		Game game = new Game("platforms.csv");
        game.run();
	}

}
