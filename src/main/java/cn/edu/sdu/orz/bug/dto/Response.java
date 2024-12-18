package cn.edu.sdu.orz.bug.dto;

import org.springframework.data.util.Pair;

public class Response {
    public boolean success;
    public String message;

    public boolean getSuccess() {
        return success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setStatus(boolean status) {
        this.success = status;
    }

    public String getMessage() {
        if (message == null)
            return "";
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response(Pair<Boolean, String> response) {
        this.success = response.getFirst();
        this.message = response.getSecond();
    }

    public Response(boolean success) {
        this.success = success;
    }

    public Response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
