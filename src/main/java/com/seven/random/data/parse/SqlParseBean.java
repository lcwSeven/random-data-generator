package com.seven.random.data.parse;

import java.util.List;

/**
 * @author liucaiwen
 * @date 2020/3/16
 */
public class SqlParseBean {

    private String tableName;

    private List<ColumnProperties> columnProperties;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnProperties> getColumnProperties() {
        return columnProperties;
    }

    public void setColumnProperties(List<ColumnProperties> columnProperties) {
        this.columnProperties = columnProperties;
    }

    @Override
    public String toString() {
        return "SqlParseBean{" +
                "tableName='" + tableName + '\'' +
                ", columnProperties=" + columnProperties +
                '}';
    }
}
