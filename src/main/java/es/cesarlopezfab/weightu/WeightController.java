package es.cesarlopezfab.weightu;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/weights")
public class WeightController {
	
	private final WeightRepository repo;

	@Autowired
	WeightController(WeightRepository repo) {
		this.repo = repo;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Weight> references() {
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public void save(@RequestBody Weight weight) {
		if (weight.getCreated() == null) {
			weight.setCreated(new Date());
		}
		
		repo.save(weight);
	}

}
