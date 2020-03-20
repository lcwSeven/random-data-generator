package com.seven.random.data.parse;

import com.seven.random.data.type.ColumnJavaType;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucaiwen
 * @date 2020/3/16
 */
public class SqlParse {

    public static SqlParseBean parseSql(String sql) {
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
                column.setColumnName(columnDefinition.getColumnName().replace("`", ""));
                //设置字段sql类型
                ColDataType colDataType = columnDefinition.getColDataType();
                String sqlType = colDataType.getDataType();
                column.setColumnSqlType(sqlType);
                //设置字段java类型
                String javaType = ColumnJavaType.getColumnJavaTypeBySqlType(sqlType);
                column.setColumnJavaType(javaType);
                //设置字段参数
                List<String> argumentsStringList = colDataType.getArgumentsStringList();
                column.setColumnArgs(argumentsStringList);
                List<String> columnSpecStrings = columnDefinition.getColumnSpecStrings();
                if (!CollectionUtils.isEmpty(columnSpecStrings)) {
                    for (int i = 0; i < columnSpecStrings.size(); i++) {
                        String columnSpecString = columnSpecStrings.get(i);
                        if ("COMMENT".equalsIgnoreCase(columnSpecString)) {
                            column.setColumnComment(columnSpecStrings.get(i + 1));
                        }
                    }
                }
                columnProperties.add(column);
            }
            sqlParseBean.setColumnProperties(columnProperties);
            return sqlParseBean;

        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
        return null;
    }
}
