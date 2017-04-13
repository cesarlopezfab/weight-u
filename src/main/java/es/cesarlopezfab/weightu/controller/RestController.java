package es.cesarlopezfab.weightu.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.cesarlopezfab.weightu.WeightBuilder;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api/weights")
public class RestController {
	
	final WeightBuilder builder = new WeightBuilder();
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public void weights(@RequestBody Map<String, String> body) {
		builder.from(body);
	}

}
