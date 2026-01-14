package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse {
 
	private String id;
	private String name;
	private Data data;
	private String createdAt;
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Data getData() {
		return data;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
}
