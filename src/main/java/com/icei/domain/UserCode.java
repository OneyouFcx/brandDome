package com.icei.domain;

public class UserCode {

    private Integer userId;

    private String userCode;

    private String password;



    private String phone;



    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.getUserCode()+"8d78869f470951332959580424d4bf4f";
    }
}