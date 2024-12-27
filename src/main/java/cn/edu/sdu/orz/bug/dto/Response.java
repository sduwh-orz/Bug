package cn.edu.sdu.orz.bug.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.util.Pair;

/**
 * The type Response.
 */
@Getter
@Setter
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
     * Instantiates a new Response.
     *
     * @param response the response
     */
    public Response(Pair<Boolean, String> response) {
        this.success = response.getFirst();
        this.message = response.getSecond();
    }
}
