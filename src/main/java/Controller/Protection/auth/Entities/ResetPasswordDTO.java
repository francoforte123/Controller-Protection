package Controller.Protection.auth.Entities;

public class ResetPasswordDTO {

    private String newPassword;
    private String resetPassword;

    public ResetPasswordDTO(String newPassword, String resetPassword) {
        this.newPassword = newPassword;
        this.resetPassword = resetPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(String resetPassword) {
        this.resetPassword = resetPassword;
    }
}
