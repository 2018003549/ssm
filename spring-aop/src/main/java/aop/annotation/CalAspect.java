package aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CalAspect {
    @Pointcut("execution(* aop.annotation.CalculatorPureImpl.*(..))")
    public void point(){ }
    @Before("point()")
    public void beforeActive(){
        System.out.println("前置通知");
    }

    @AfterReturning(value = "point()",returning = "result")
    public void afterReturningActive(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+"方法的返回值为"+result);
    }
    @Around("point()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知--前置,传入参数为"+args+"-->目标对象方法执行之前");
            //目标方法的执行，目标方法的返回值一定要返回给外界调用者
            result = joinPoint.proceed();
            System.out.println("环绕通知--返回"+result+"-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知--异常-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知--后置-->目标对象方法执行完毕");
        }
        return result;
    }
}
