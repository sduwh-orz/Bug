package cn.edu.sdu.orz.bug.dto;

import org.springframework.data.util.Pair;

/**
 * The type Response.
 */
@SuppressWarnings("unused")
public class Response {
    /**
     * The Success.
     */
    public boolean success;
    /**
     * The Message.
     */
    public String message;

    /**
     * Gets success.
     *
     * @return the success
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * Is success boolean.
     *
     * @return the boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(boolean status) {
        this.success = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        if (message == null)
            return "";
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Instantiates a new Response.
     *
     * @param response the response
     */
    public Response(Pair<Boolean, String> response) {
        this.success = response.getFirst();
        this.message = response.getSecond();
    }

    /**
     * Instantiates a new Response.
     *
     * @param success the success
     */
    public Response(boolean success) {
        this.success = success;
    }

    /**
     * Instantiates a new Response.
     *
     * @param success the success
     * @param message the message
     */
    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
