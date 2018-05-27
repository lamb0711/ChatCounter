package edu.handong.csee.java.hw3;


/**
 * CountInfo class is save person rank and number of chat message. it conclude haspMap
 * @author yangsujin
 *
 */
public class CountInfo {
	int rank;
	int number;

	/**
	 * It is constructor of ContInfo class. not input case.
	 * @return
	 */
	public CountInfo() {
		this.rank = 0;
		this.number = 0;
	}

	/**
	 * It is constructor of ContInfo class. exist input case.
	 * @return
	 */
	public CountInfo(int rank, int number) {
		this.rank = rank;
		this.number = number;
	}
	/**
	 * getRank method can use rank integer in other class
	 * @return
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * setRank method save rank number to input data
	 * @return
	 */

	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * getNumber method can use message number Integer in other class
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * setNumber method save message number to input data
	 * @return
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
