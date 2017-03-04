package com.pawlak.classes;

public class Wheel {
	private String producer;
	private int size;
	private TIRETYPE tire;
	
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public TIRETYPE getTire() {
		return tire;
	}
	public void setTire(TIRETYPE tire) {
		this.tire = tire;
	}
	@Override
	public String toString() {
		return "Wheel [producer=" + producer + ", size=" + size + ", tire=" + tire + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		result = prime * result + size;
		result = prime * result + ((tire == null) ? 0 : tire.hashCode());
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
		Wheel other = (Wheel) obj;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		if (size != other.size)
			return false;
		if (tire != other.tire)
			return false;
		return true;
	}
	
	
}
