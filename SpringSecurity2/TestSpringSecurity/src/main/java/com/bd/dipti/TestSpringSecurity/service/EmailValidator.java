package com.bd.dipti.TestSpringSecurity.service;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return false;
    }
}
