package tn.esprit.autoloc.config;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
import java.util.Arrays;


@Slf4j
@Aspect
@Component
public class LoggingAspect {
    // Advice exécuté avant chaque méthode de la couche service
    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] parameters = joinPoint.getArgs();
        log.info("Before - Méthode appelée : " + methodName);
        log.info("Paramètres : " + Arrays.deepToString(parameters));
    }
    // Advice exécuté après chaque méthode de la couche service
    @After("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("After - Fin d'exécution de la méthode : " + methodName);
    }

}