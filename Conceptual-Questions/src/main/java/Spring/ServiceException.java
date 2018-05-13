/**
 * ServiceException.java
 */
package Spring;

public class ServiceException extends Exception {

    // =================================================
    // Class Variables
    // =================================================

    private static final long serialVersionUID = 1L;

    public static enum ServiceErrorCode {

        /**
         * Internal server error
         */
        INTERNAL_SERVER_ERROR,

        /**
         * Error thrown by External service
         */
        EXTERNAL_SERVICE_ERROR,
        
        /**
         * Error thrown when no data found in database
         */
        NO_DATA_FOUND

    }

    // =================================================
    // Constructors
    // =================================================

    public ServiceException(ServiceErrorCode iServiceErrorCode) {
        serviceErrorCode = iServiceErrorCode;
    }

    // =================================================
    // Instance Variables
    // =================================================

    private final ServiceErrorCode serviceErrorCode;

    // =================================================
    // Accessors
    // =================================================

    public ServiceErrorCode getErrorCode() {
        return serviceErrorCode;
    }
}
