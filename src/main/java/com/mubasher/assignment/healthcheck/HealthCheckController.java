package com.mubasher.assignment.healthcheck;

import com.mubasher.assignment.commons.exceptions.ValidationException;
import com.mubasher.assignment.commons.exceptions.errortypes.GenericApiErrorType;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Mubasher Usman.
 */
@Api(tags = { "Health Check Controller" })
@Slf4j
@RestController
@RequestMapping("health-check")
public class HealthCheckController {

	@Value("${dnow.config.app-ver:1}")
	private Long appVersion;

	/**
	 * Simple health check service
	 * @return an instance of {@link String}
	 */
	@GetMapping
	public String healthCheck(@RequestParam("version") @Valid @NotNull Long version) {
		log.info("Health check service called");
		if (!appVersion.equals(version)) {
			log.error("Application Version mismatched.");
			throw new ValidationException(GenericApiErrorType.APP_VERSION_MISMATCHED);
		}
		return "OK";
	}

}
