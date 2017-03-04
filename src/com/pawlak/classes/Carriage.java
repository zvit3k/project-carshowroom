package com.pawlak.classes;

import java.util.List;

public class Carriage {
	private COLOR color;
	private CARRIAGETYPE type;
	private List<EQUIPMENT> equipment;
	
	public COLOR getColor() {
		return color;
	}
	public void setColor(COLOR color) {
		this.color = color;
	}
	public CARRIAGETYPE getType() {
		return type;
	}
	public void setType(CARRIAGETYPE type) {
		this.type = type;
	}
	
	public List<EQUIPMENT> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<EQUIPMENT> equipment) {
		this.equipment = equipment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carriage other = (Carriage) obj;
		if (color != other.color)
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Carriage [color=" + color + ", type=" + type + ", equipment=" + equipment + "]";
	}
	
	
	
}
