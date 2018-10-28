package edu.gatech.cs6310.plazel01.hw5.entitites;

public abstract class SimObject {
	protected Integer id;

	public SimObject(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
