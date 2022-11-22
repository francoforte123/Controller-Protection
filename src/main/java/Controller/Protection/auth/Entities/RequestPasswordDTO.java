package Controller.Protection.auth.Entities;

public class RequestPasswordDTO {

    private String email;

    public RequestPasswordDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
