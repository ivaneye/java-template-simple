package com.webapp.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Created by ivan on 15-1-15.
 */
public class AppDataSource extends BasicDataSource {
    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return -1;
    }
}
