package com.seven.random.data.parse;

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
    private String columnLength;
    /**
     * 字段注释
     */
    private String columnComment;

    /**
     * 字段默认值
     */
    private String columnDefaultValue;

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

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnDefaultValue() {
        return columnDefaultValue;
    }

    public void setColumnDefaultValue(String columnDefaultValue) {
        this.columnDefaultValue = columnDefaultValue;
    }

    @Override
    public String toString() {
        return "ColumnProperties{" +
                "columnName='" + columnName + '\'' +
                ", columnJavaType='" + columnJavaType + '\'' +
                ", columnSqlType='" + columnSqlType + '\'' +
                ", columnLength='" + columnLength + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", columnDefaultValue='" + columnDefaultValue + '\'' +
                '}';
    }
}
