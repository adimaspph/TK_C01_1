package tk.apap.sibusiness.rest;

public class BaseResponse {
    private int status;
    private String message;
    private CabangDTO result;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public CabangDTO getResult() {
        return result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(CabangDTO result) {
        this.result = result;
    }
}
