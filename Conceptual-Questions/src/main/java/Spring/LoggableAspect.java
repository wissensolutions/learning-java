package Spring;

import com.google.common.base.Stopwatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 */
@Aspect
public class LoggableAspect {

    private Logger logger = LoggerFactory.getLogger("LoggableAspect");

    @Around("@annotation(Spring)")
    public Object printMe(ProceedingJoinPoint iJoinPoint) throws Throwable{
        Object returnValue = null;
        Stopwatch watch = Stopwatch.createStarted();
        try{
            returnValue = iJoinPoint.proceed();

        } catch (Throwable throwable){
            throw throwable;
        } finally {
            logger.info("Method={}, Time={}ms", ((MethodSignature) iJoinPoint.getSignature()).getName(), watch.elapsed(TimeUnit.MILLISECONDS));
        }
        return returnValue;
    }
}
