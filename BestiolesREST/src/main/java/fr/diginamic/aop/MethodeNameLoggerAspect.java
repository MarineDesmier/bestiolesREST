package fr.diginamic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodeNameLoggerAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* fr.diginamic.controller..*(..))")
	public void logService(JoinPoint joinPoint) {
		logger.info("J'execute la méthode {}", joinPoint.getSignature().getName());
		System.out.println("Dans le joinPoint " + joinPoint);
	}

	// affiche mes methodes si GET -> findById et findAll dans mon PersonService
	@Before("execution(* fr.diginamic.service.PersonService.find*(..))")
	public void testGetOnly(JoinPoint joinPoint) {
		logger.info("Seulement les méthodes Get appelée {}", joinPoint.getSignature().getName());
	}

	// cibler toutes les méthodes publiques des controllers.
	@Before("execution(public * fr.diginamic.controller.*.*(..))")
	public void logPublicOnly(JoinPoint jp) {
		logger.info("Recherche toute les methodes public de mon application, j'utilise {}",
				jp.getSignature().getName());
	}

	// Sur la méthode save écrire un aspect qui va logger l’exception survenue
	@Before("execution(* fr.diginamic.service.PersonService.save*(..))")
	public void savePersonService(JoinPoint joinPoint) {
		logger.info("Méthodes save appelée {}", joinPoint.getSignature().getName());
	}

	@Around("execution(* fr.diginamic.service..*(..))")
	public Object dureeExecution(ProceedingJoinPoint pjp) throws Throwable {
		long startTimer = System.currentTimeMillis();
		Object result = pjp.proceed();
		long endTimer = System.currentTimeMillis();
		long executionTimer = endTimer - startTimer;

		logger.info("La méthode {} à été exécutée en {} ms", pjp.getSignature().getName(), executionTimer);
		
		return result;
	}
}
