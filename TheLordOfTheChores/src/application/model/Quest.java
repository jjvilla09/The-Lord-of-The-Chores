/**
 * Author: Nikhil Kapoor (yct482)
 * File: Quest.java
 * Purpose: this class is the Quest object, that will be created via an ArrayList of quests
 */
package application.model;

public class Quest {
	private String qName; // -qName: String
	private String qDiff; // qDiff: String
	private int qReward; // qReward: int
	
	// Quest Constructor
	public Quest(String qName, String qDiff, int qReward) {
		this.qName = qName;
		this.qDiff = qDiff;
		this.qReward = qReward;
	}
	// end of Quest Constructor

	// Getters and Setters
	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getqDiff() {
		return qDiff;
	}

	public void setqDiff(String qDiff) {
		this.qDiff = qDiff;
	}

	public int getqReward() {
		return qReward;
	}

	public void setqReward(int qReward) {
		this.qReward = qReward;
	}
	// end of Getters and Setters

	@Override
	public String toString() {
		return qName + " " + qDiff + " " + qReward;
	}
	
	
	
} // end of Quest class
