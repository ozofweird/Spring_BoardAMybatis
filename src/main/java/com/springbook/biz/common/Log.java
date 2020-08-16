package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class Log {

	@Around("PointcutCommon.allPointcut()")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		// �޼���� ����
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object obj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println(method + "() �޼��� ���࿡ �ɸ� �ð� : "
				+ stopwatch.getTotalTimeMillis() + "(ms)��");
		return obj;
	}
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		// �޼���� ����
		String method = jp.getSignature().getName();
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println(method + "() �޼��� ���� : �������� ��");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println(method + "() �޼��� ���� : ���� ���� ���� �ƴ� ��");
		} else if(exceptObj instanceof Exception) {
			System.out.println(method + "() �޼��� ���� : ���� �߻�");
		}
	}
}
