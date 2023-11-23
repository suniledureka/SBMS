package com.modeln.rest.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Endpoint(id = "modeln", enableByDefault = true)
public class MyCustomEndPoint {
 @ReadOperation	
 public MyEndPointResponse features() {	 
	 MyEndPointResponse response = new MyEndPointResponse();
	 response.setId(112345);
	 response.setName("Model N Technologies");
	 response.setAddress("Hyderabad, India");
	 
	return response;
 }
}


@Data
class MyEndPointResponse{
	private Integer id;
	private String name;
	private String address;
}
