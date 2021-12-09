package tk.apap.sibusiness.rest;

public class BaseResponse {
    private int status;
    private String message;
    private CabangDetail result;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public CabangDetail getResult() {
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(CabangDetail result) {
        this.result = result;
    }
}
