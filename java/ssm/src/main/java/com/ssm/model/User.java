package com.ssm.model;

public class User {

    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
                + userEmail + "]";
    }
}
