package org.zzz.jobtest.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@NamedEntityGraph(
		name = "user-info-entity-graph", 
		attributeNodes = { @NamedAttributeNode("sectors")}
)

@Entity 
@Table(name = "user_info") 
public class UserInfo {
	
	public UserInfo(){
		sectors = new HashSet<Sector>();
	}
	
	@Id 	  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false) 
	Integer id;
	
	@Column(name="name")
	String name;	
	
	@Column(name="agreed")
	Boolean agreed;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "user_sector", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "sector_id"))
	Set<Sector> sectors;

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

	public Boolean getAgreed() {
		return agreed;
	}

	public void setAgreed(Boolean agreed) {
		this.agreed = agreed;
	}

	public Set<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(Set<Sector> sectors) {
		this.sectors = sectors;
	}
	
	
	
	
}
