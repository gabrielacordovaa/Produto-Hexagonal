package com.Produto.Domain.ValueObjects;

public class Id {
	
	private int id;
	
	public Id(int id) {
		setId(id);
	}
	public boolean equals(Id id) {
		if(this.id == id.getId()) {
			return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id <= 0)
			id = 0;
		this.id = id;
	}

}
