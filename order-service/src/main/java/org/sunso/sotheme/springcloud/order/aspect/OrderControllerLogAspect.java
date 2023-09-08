package org.sunso.sotheme.springcloud.order.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.sunso.keypoint.springboot2.controller.intercept.global.aspect.AbstractControllerLog;

/**
 * @title: ControllerAspect
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @created on 2019-07-0210:37
 */
@Aspect
@Component
@Order(0)
public class OrderControllerLogAspect extends AbstractControllerLog {
  // AOP || execution(* org.*..*.controller.*Controller.*(..))
  @Pointcut("execution(* org.*..*.controller..*Controller.*(..)) ")
  public void execute() {}

  @Around("execute()")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
    return doProceed(joinPoint);
  }
}
