package Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller Based Exception Handling
 * A controller advice allows you to declare exception handling techniques across the whole application
 * Such methods can :
 * 1. Build a totally custom error response
 * 2. Handle exceptions without the @ResponseStatus annotation
 * 3. Redirect the user to a dedicated error view
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    private static final String ERROR_TYPE_VALIDATION = "Validation.Error.Type";
    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
    // =================================================
    // Public methods
    // =================================================

    //1. Build a totally custom error response
    @ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(Exception.class) // Some exception
    public void conflict() {
        // Nothing to do
    }

    /**
     * Method to handle IllegalStateException.
     * @param iException
     * @return {@link ExceptionHandlerResponse}
     */
    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionHandlerResponse handleIllegalStateException(IllegalStateException iException) {
        return new ExceptionHandlerResponse(iException.getMessage(), ERROR_TYPE_VALIDATION);
    }


    // 2. Handle exceptions without the @ResponseStatus annotation
    /**
     * Method to handle ServiceException.
     * @param iServiceException
     * @param iResponse
     * @return {@link ExceptionHandlerResponse}
     */
    @ExceptionHandler(value = ServiceException.class)
    public void handleServicesException(ServiceException iServiceException, HttpServletResponse iResponse) {
        if(iServiceException.getErrorCode() == ServiceException.ServiceErrorCode.NO_DATA_FOUND) {
            iResponse.setStatus(204);
        } else {
            iResponse.setStatus(500);
        }
    }


    //3. Redirect the user to a dedicated error view

    /**
     * Be careful when adding exceptions to the model. Users do not want to see web-pages containing Java exception details and stack-traces.
     * So please log complete exception stack trace to assist support people
     * @param req
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
