package com.anz.wholesale.datasource;

import org.hibernate.dialect.H2Dialect;

public class AnzCustomH2Dialect extends H2Dialect {
    @Override
    public String getDropSequenceString(String sequenceName) {
        return "drop sequence if exists " + sequenceName;
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }
}
