package Spring;

/**
 */
public class ExceptionHandlerResponse {

    // =================================================
    // Class Methods
    // =================================================
    private static final long serialVersionUID = 1L;

    // =================================================
    // Instance Variables
    // =================================================

    private String message;
    private String errorKey;

    // =================================================
    // Constructor
    // =================================================

    public ExceptionHandlerResponse(String iMessage, String iErrorKey) {
        message = iMessage;
        errorKey = iErrorKey;
    }

    // =================================================
    // Accessors
    // =================================================

    public String getMessage() {
        return message;
    }

    public void setMessage(String iMessage) {
        message = iMessage;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public void setErrorKey(String iErrorKey) {
        errorKey = iErrorKey;
    }
}
