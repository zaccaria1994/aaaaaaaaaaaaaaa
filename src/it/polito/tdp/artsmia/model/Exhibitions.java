package it.polito.tdp.artsmia.model;

public class Exhibitions {
	private int exhibition_id;
	private String exhibition_department;
	private String exhibition_title;
	private int begin;
	private int end;
	public int getExhibition_id() {
		return exhibition_id;
	}
	public void setExhibition_id(int exhibition_id) {
		this.exhibition_id = exhibition_id;
	}
	public String getExhibition_department() {
		return exhibition_department;
	}
	public void setExhibition_department(String exhibition_department) {
		this.exhibition_department = exhibition_department;
	}
	public String getExhibition_title() {
		return exhibition_title;
	}
	public void setExhibition_title(String exhibition_title) {
		this.exhibition_title = exhibition_title;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public Exhibitions(int exhibition_id, String exhibition_department, String exhibition_title, int begin, int end) {
		super();
		this.exhibition_id = exhibition_id;
		this.exhibition_department = exhibition_department;
		this.exhibition_title = exhibition_title;
		this.begin = begin;
		this.end = end;
	}
	@Override
	public String toString() {
		return ""+ exhibition_id + " " + exhibition_department
				+ " " + exhibition_title + " " + begin + " " + end ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + begin;
		result = prime * result + end;
		result = prime * result + ((exhibition_department == null) ? 0 : exhibition_department.hashCode());
		result = prime * result + exhibition_id;
		result = prime * result + ((exhibition_title == null) ? 0 : exhibition_title.hashCode());
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
		Exhibitions other = (Exhibitions) obj;
		if (begin != other.begin)
			return false;
		if (end != other.end)
			return false;
		if (exhibition_department == null) {
			if (other.exhibition_department != null)
				return false;
		} else if (!exhibition_department.equals(other.exhibition_department))
			return false;
		if (exhibition_id != other.exhibition_id)
			return false;
		if (exhibition_title == null) {
			if (other.exhibition_title != null)
				return false;
		} else if (!exhibition_title.equals(other.exhibition_title))
			return false;
		return true;
	}
	
	
	

}
