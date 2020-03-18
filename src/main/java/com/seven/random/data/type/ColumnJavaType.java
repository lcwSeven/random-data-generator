package com.seven.random.data.type;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import static com.seven.random.data.contant.SqlTypeContent.*;

/**
 * @author liucaiwen
 * @date 2020/3/16
 */
public class  ColumnJavaType {

    public static String getColumnJavaTypeBySqlType(String sqlType) {
        if (VARCHAR.equals(sqlType) || CHAR.equals(sqlType)) {
            return "java.lang.String";
        } else if (TIMESTAMP.equals(sqlType)) {
            return "java.sql.Timestamp";
        } else if (DECIMAL.equals(sqlType)) {
            return "java.math.BigDecimal";
        }else if (DATE.equals(sqlType)){
            return "java.sql.Date";
        }else if (INT.equals(sqlType) || BIGINT.equals(sqlType)){
            return "java.lang.Integer";
        }
        return "java.lang.String";
    }
}
