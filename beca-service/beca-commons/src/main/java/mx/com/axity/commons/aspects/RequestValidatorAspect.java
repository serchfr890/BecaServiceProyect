package mx.com.axity.commons.aspects;

import mx.com.axity.commons.exceptions.BusinessException;
import mx.com.axity.commons.to.ErrorTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class RequestValidatorAspect {

    static final Logger LOG = LogManager.getLogger(RequestValidatorAspect.class);

    @Around(value = "execution(* mx.com.axity.web.rest.*.*(..))  && args(..)")
    public ResponseEntity execute(ProceedingJoinPoint joinPoint) {
        ResponseEntity result;
        try {
            LOG.info("Access");
            LOG.info(String.format("Execution: %s", joinPoint.getSignature()));
            result = (ResponseEntity) joinPoint.proceed();
            return result;
        }catch (Throwable e) {
            LOG.info("Exception Ocurred");
            LOG.info("Execution: {}", joinPoint.getSignature());
            LOG.info("Exception: {}", e.getMessage());
            LOG.info("***************************");
            LOG.info(e.toString());
            //throw new BusinessException("Error", e);

            ErrorTO errorTO = new ErrorTO();
            if(e instanceof NoSuchElementException ){
                errorTO.setErroCode((long) 1);
                errorTO.setErroMessage("No se encontró el id");
            }else{
                errorTO.setErroCode((long) 2);
                errorTO.setErroMessage("Otro Erro");
            }

            return new ResponseEntity<ErrorTO>(errorTO, HttpStatus.NOT_FOUND);

        }
    }
}
