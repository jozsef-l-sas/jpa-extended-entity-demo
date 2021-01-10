package com.jozsef.erb.entity;

public enum AccountType {
    ACCOUNT(Values.ACCOUNT), SAVINGS(Values.SAVINGS);

    private AccountType (String type) {
        // force equality between name of enum instance, and value of constant
        if (!this.name().equals(type))
            throw new IllegalArgumentException("Incorrect use of AccountType");
    }

    public static class Values {
        public static final String ACCOUNT = "ACCOUNT";
        public static final String SAVINGS = "SAVINGS";
    }
}
