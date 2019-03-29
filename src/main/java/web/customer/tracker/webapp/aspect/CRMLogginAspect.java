package web.customer.tracker.webapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLogginAspect
{
	private Logger logger = Logger.getLogger(CRMLogginAspect.class.getName());

	@Pointcut("execution(* web.customer.tracker.webapp.controller.*.*(..))")
	private void forControllerPackage()
	{
	}

	@Pointcut("execution(* web.customer.tracker.webapp.dao.*.*(..))")
	private void forDaoPackage()
	{
	}

	@Pointcut("execution(* web.customer.tracker.webapp.service.*.*(..))")
	private void forServicePackage()
	{
	}

	@Pointcut("forServicePackage() || forDaoPackage() || forControllerPackage()")
	private void forAppFlow()
	{
	}

	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint)
	{
		String name = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		logger.info("=====>>> in @Before name: calling method: " + name);
		for (Object arg : args)
		{
			logger.info("=====>>> argument: " + arg);
		}
	}

	@AfterReturning(
		pointcut = "forAppFlow()",
		returning = "result"
	)
	public void afterReturning(JoinPoint joinPoint, Object result)
	{
		String name = joinPoint.getSignature().toShortString();
		logger.info("=====>>> in @AfterReturning name: calling method: " + name);

		logger.info("=====>>> result: " + result);
	}
}
