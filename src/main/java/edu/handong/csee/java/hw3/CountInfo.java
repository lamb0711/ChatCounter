package edu.handong.csee.java.hw3;

public class CountInfo {
	int rank;
	int number;
	
	public CountInfo() {
		this.rank = 0;
		this.number = 0;
	}
	public CountInfo(int rank, int number) {
		this.rank = rank;
		this.number = number;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
