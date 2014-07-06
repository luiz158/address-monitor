package com.address.service;

import com.address.model.Address;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * User: jules
 * Date: 7/6/14
 */
@Aspect
@Component
public class AddressLogger {

    @Autowired
    @Qualifier("changeLogService")
    private ChangeLogService changeLogService;

    @Autowired
    private EmailSenderService emailSenderService;

    Logger logger = LoggerFactory.getLogger("com.address");


    @Pointcut("execution(* com.address.service.AddressServiceImpl+.saveAddress*(..))")
    public void onSave() {
    }

    @Around(value = "onSave()")
    public void logChage(final ProceedingJoinPoint pjp) throws Throwable {
        logger.info("[AROUND:Before] " + pjp.toString());
        Object[] arguments = pjp.getArgs();
        String user = (String) arguments[1];
        logger.info("[AROUND:Before] user doing the change: " + user);
        Object result = pjp.proceed();
        if (result instanceof Address) {
          changeLogService.addLog((Address) result, user);
        }
        emailSenderService.sendEmail();
    }
}
