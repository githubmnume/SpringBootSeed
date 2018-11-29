package interview.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import interview.system.util.Result;
import interview.system.util.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"Healthcheck"}, description="healthcheck point")
@RestController
@RequestMapping("/healthcheck")
public class HealthcheckEndpoint {

	@ApiOperation(value="health check", notes="healthcheck for interview resource")
	@GetMapping
	public Result isUp() {
		return ResultGenerator.genSuccessResult().setData("Service up");
	}

}
