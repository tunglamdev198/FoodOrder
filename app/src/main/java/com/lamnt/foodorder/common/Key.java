package com.lamnt.foodorder.common;

public interface Key {
    interface SimpleKey{
        String TITLE = "title";
        String PHONE_NUMBER = "phone_number";
        String MESSAGE = "message";
        String BUTTON_ACTION = "button_action";
        String TYPE = "type";
    }

    interface Action {
        String REGISTER = "register";
        String LOGIN = "login";
    }
}
