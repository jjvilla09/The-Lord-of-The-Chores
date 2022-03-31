/**
 * Class: QuestBoard.java
 * Purpose: holds functions that the Quest class will be involved in
 */
package application.model;

import java.io.IOException;
import java.util.*;

public class QuestBoard {
	
	// +getRandNum(): int
	public int getRandNum() throws IOException {
		return new Random().nextInt() * 100; // returns a random number from 1 to 100
	} // end of getRandNum

} // end of QuestBoard class
