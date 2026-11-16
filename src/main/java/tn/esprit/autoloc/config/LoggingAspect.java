package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component

public class LoggingAspect {
    //Advice exécuté avant chaque méthode de la couche service
    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        // afficher
        log.info("Before - Méthode appelée : "+ methodName);

    }
}
