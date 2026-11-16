package tn.esprit.autoloc.config;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    // Advice exécuté autour de chaque méthode de la couche service
    @Around("execution(* tn.esprit.autoloc.service.*.*(..))")
    public Object calculerTempsExecution(ProceedingJoinPoint joinPoint)
            throws Throwable {
        long debut = System.currentTimeMillis();
        Object resultat = joinPoint.proceed();
        long fin = System.currentTimeMillis();
        long temps = fin - debut;
        String methodName = joinPoint.getSignature().getName();
        log.info("Temps d'exécution de " + methodName + " : " + temps + " ms");
        if (temps > 1000) {
            log.warn("La méthode " + methodName + " dépasse 1000 ms !");
        }
        return resultat;
    }
}
