package com.pt.mercadolivre.exception;

public class UserNotPermission extends RuntimeException {

        public UserNotPermission(String message) {
            super(message);
        }

}
