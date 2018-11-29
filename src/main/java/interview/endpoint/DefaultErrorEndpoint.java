package interview.endpoint;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import interview.system.exception.SystemException;

@Controller
public class DefaultErrorEndpoint implements ErrorController {

	@RequestMapping("/error")
	public String handleError() {
		// do something like logging
		throw new SystemException("error");
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
