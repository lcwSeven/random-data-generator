package com.seven.random.data.parse;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucaiwen
 * @date 2020/3/16
 */
public class SqlParse {

    public void parseSql(String sql) {

        try {
            CreateTable createTable = (CreateTable) CCJSqlParserUtil.parse(sql);

            SqlParseBean sqlParseBean = new SqlParseBean();
            List<ColumnProperties> columnProperties = new ArrayList<>();

            Table table = createTable.getTable();
            //设置表名称
            sqlParseBean.setTableName(table.getName());
            List<ColumnDefinition> columnDefinitions = createTable.getColumnDefinitions();
            for (ColumnDefinition columnDefinition : columnDefinitions) {
                ColumnProperties column = new ColumnProperties();
                //设置字段名称
                column.setColumnName(columnDefinition.getColumnName().replace("`",""));
                //
                columnProperties.add(column);
            }

            System.out.println(sqlParseBean.toString());

        } catch (JSQLParserException e) {
            e.printStackTrace();
        }

    }
}
