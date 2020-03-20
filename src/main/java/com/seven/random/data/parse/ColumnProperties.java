package com.seven.random.data.parse;

import java.util.List;

/**
 * @author liucaiwen
 * @date 2020/3/16
 */
public class ColumnProperties {

    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 字段类型 java 类型
     */
    private String columnJavaType;

    /**
     * 字段sql类型
     */
    private String columnSqlType;

    /**
     * 字段长度
     */
    private List<String> columnArgs;
    /**
     * 字段注释
     */
    private String columnComment;


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnJavaType() {
        return columnJavaType;
    }

    public void setColumnJavaType(String columnJavaType) {
        this.columnJavaType = columnJavaType;
    }

    public String getColumnSqlType() {
        return columnSqlType;
    }

    public void setColumnSqlType(String columnSqlType) {
        this.columnSqlType = columnSqlType;
    }

    public List<String> getColumnArgs() {
        return columnArgs;
    }

    public void setColumnArgs(List<String> columnArgs) {
        this.columnArgs = columnArgs;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


    @Override
    public String toString() {
        return "ColumnProperties{" +
                "columnName='" + columnName + '\'' +
                ", columnJavaType='" + columnJavaType + '\'' +
                ", columnSqlType='" + columnSqlType + '\'' +
                ", columnArgs=" + columnArgs +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }
}
