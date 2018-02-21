package com.ibm.registrationsvc.dto;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"Id","Name","Age","Skill"})
public class User {

	@JsonProperty("Id")
	int Id;
	
	@JsonProperty("Name")
	String Name;
	
	@JsonProperty("Age")
	String Age;
	
	@JsonProperty("Skill")
	String Skill;
	
	public User()
	{
		
	}
	
	public User(int Id, String Name, String Age, String Skill)
	{
		this.Id = Id;
		this.Name = Name;
		this.Age = Age;
		this.Skill = Skill;
	}

	@JsonProperty("Id")
	public int getId() {
		return Id;
	}

	@JsonProperty("Id")
	public void setId(int id) {
		Id = id;
	}

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		Name = name;
	}

	@JsonProperty("Age")
	public String getAge() {
		return Age;
	}

	@JsonProperty("Age")
	public void setAge(String age) {
		Age = age;
	}

	@JsonProperty("Skill")
	public String getSkill() {
		return Skill;
	}

	@JsonProperty("Skill")
	public void setSkill(String skill) {
		Skill = skill;
	}

}
