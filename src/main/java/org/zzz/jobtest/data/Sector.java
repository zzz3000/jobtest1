package org.zzz.jobtest.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sector")
public class Sector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	Integer id;

	@Column(name = "name")
	String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	Sector parent;

	
	
	public Sector getParent() {
		return parent;
	}

	public void setParent(Sector parent) {
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getNameWithSpaces() {
		String res = getName();
		Sector parent = getParent();
		
		while(parent!=null) {
			res = "&nbsp;&nbsp;&nbsp;&nbsp;" + res;
			parent = parent.getParent();
		}
		
		return res + "--"+ getId();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() +   "[" + ((getParent()!= null)? getParent().getName(): "null") + "]" +" - " + getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		Sector second = (Sector) obj;
		if(this.getId() !=null && this.getId() !=0 && second.getId() !=null && second.getId() !=0) {
			return this.getId().equals(second.getId());
		}
		return this == second;
	}
}
