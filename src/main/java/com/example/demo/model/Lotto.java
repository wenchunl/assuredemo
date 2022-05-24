package com.example.demo.model;

public class Lotto {

	private int lottoId;

	private int[] winningNumbers;

	private Winner[] winnerList;

	public int getLottoId() {
		return lottoId;
	}

	public void setLottoId(int lottoId) {
		this.lottoId = lottoId;
	}

	public int[] getWinningNumbers() {
		return winningNumbers;
	}

	public void setWinningNumbers(int[] winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public Winner[] getWinnerList() {
		return winnerList;
	}

	public void setWinnerList(Winner[] winnerList) {
		this.winnerList = winnerList;
	}

}
