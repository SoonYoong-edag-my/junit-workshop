package com.example.demo.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUtilTest {

    @Test
    void isValidName() {
        assertTrue(ValidateUtil.isValidName("John"));
    }

    @Test
    void isValidName_empty() {
        assertFalse(ValidateUtil.isValidName(""));
    }

    @Test
    void isValidEmail() {
        assertTrue(ValidateUtil.isValidEmail("john.doe@gmail.com"));
    }

    @Test
    void isValidEmail_invalid() {
        assertFalse(ValidateUtil.isValidEmail("john.doe"));
    }
}