package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Log4jAdvice {
  
  @Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
  public void allPointcut() {
    System.out.println("[공통로그-Log4j] 비즈니스 로직 수행 전 동작");
  }
  
  @Before("allPointcut()")
  public void getPointcut() {
    System.out.println("[공통로그-Log4j] 어노테이션");
  }
}
