package es.cesarlopezfab.weightu;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.spring.security.api.authentication.AuthenticationJsonWebToken;

@RestController
@RequestMapping(value = "/api/weights")
public class WeightController {

	private final WeightRepository repo;

	@Autowired
	WeightController(WeightRepository repo) {
		this.repo = repo;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Weight> references() {
		String principal = getLoggedUserId();
		return repo.findByUserId(principal);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void save(@RequestBody Weight weight) {
		if (weight.getCreated() == null) {
			weight.setCreated(new Date());
		}
		
		weight.setUserId(getLoggedUserId());

		repo.save(weight);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public void delete(@RequestBody Weight reference) {
		repo.delete(reference);
	}
	
	private String getLoggedUserId() {
		AuthenticationJsonWebToken authentication = (AuthenticationJsonWebToken) SecurityContextHolder.getContext().getAuthentication();
		return (String) authentication.getPrincipal();
	}

}
