/**
 * Class: QuestBoard.java
 * Purpose: holds functions that the Quest class will be involved in
 */
package application.model;

public class QuestBoard {
	
	public Quest createQuest(String[] metadata) {
		String title = metadata[0];
		String diff = metadata[1];
		int rwd = 0;
		
		switch (metadata[1]) {
		case "Easy":
			rwd = 100;
			break;
		case "Normal":
			rwd = 250;
			break;
		case "Hard":
			rwd = 500;
			break;
		}
		return new Quest(title, diff, rwd);
	}

} // end of QuestBoard class
