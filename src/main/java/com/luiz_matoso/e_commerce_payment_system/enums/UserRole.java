package com.luiz_matoso.e_commerce_payment_system.enums;

public enum UserRole {

    ADMIN("Administrator"),
    CUSTOMER("Customer");


    private String userRole;

    UserRole(String role){
        this.userRole = role;
    }

    public String getUserRole(){
        return userRole;
    }

}
