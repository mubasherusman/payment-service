package com.mubasher.assignment.commons.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Mubasher Usman.
 */
@Aspect
@Component
@Slf4j
public class LoggingAdvice {

	@Before("execution(* com.mubasher.assignment.payment.controller.*.*(..))")
	public void beforeController(JoinPoint joinPoint) {

		logBeforeMethodExecution(joinPoint, "Controller");
	}

	@AfterReturning(pointcut = "execution(* com.mubasher.assignment.payment.controller.*.*(..))", returning = "result")
	public void afterController(JoinPoint joinPoint, Object result) {

		logAfterMethodExecution(joinPoint, result, "Controller");
	}

	private void logBeforeMethodExecution(JoinPoint joinPoint, String layerName) {
		log.info("--- At {} Layer ---", layerName);
		log.info("Entering in Method : {}", joinPoint.getSignature().getName());
		log.info("Class Name : {}", joinPoint.getSignature().getDeclaringTypeName());
		log.info("Arguments : {}", Arrays.toString(joinPoint.getArgs()));
	}

	private void logAfterMethodExecution(JoinPoint joinPoint, Object result,
			String layerName) {
		log.info("--- At {} Layer ---", layerName);
		log.info("Leaving from Method : {}", joinPoint.getSignature().getName());
		log.info("Class Name : {}", joinPoint.getSignature().getDeclaringTypeName());
		log.info("Return Value : {}", result);
	}

}
