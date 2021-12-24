package tk.apap.sibusiness.rest;

import java.util.HashMap;
import java.util.List;

public class BaseResponseT<T> {
    private int status;
    private String message;
    private List<HashMap> result;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<HashMap> getResult() {
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(List<HashMap> result) {
        this.result = result;
    }
}
