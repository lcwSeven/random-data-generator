package com.seven.random.data.config;

import com.seven.random.data.type.ColumnJavaType;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParser;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author liucaiwen
 * @date 2020/3/16
 */
public class Main {

    public static void main(String[] args) {
        String sql = "CREATE TABLE `pr_inst_control`(\n" +
                "  `id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '主键ID',\n" +
                "  `state` CHAR(1) NOT NULL DEFAULT 1 COMMENT '0 - 失效；1 - 生效',\n" +
                "  `institution_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `sub_institution_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `country_code` CHAR(3) NOT NULL DEFAULT '',\n" +
                "  `issuer_billing_currency` CHAR(3) NOT NULL DEFAULT '',\n" +
                "  `issuer_billing_currency_exp` CHAR(11) NOT NULL DEFAULT '0',\n" +
                "  `mc_issuer_billing_markup` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `mc_issuer_member_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `mc_acquirer_local_bin` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `mc_acquirer_internation_bin` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `mc_acquirer_member_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `mc_ap_premium_dom` CHAR(1) NOT NULL DEFAULT '' COMMENT 'MasterCard AP premium Domestic Indi',\n" +
                "  `mc_region` CHAR(1) NOT NULL DEFAULT '' COMMENT 'MasterCard Region Codes: B - LATIN AMERICA;',\n" +
                "  `mc_cvc` CHAR(1) NOT NULL DEFAULT '' COMMENT 'Y - SUPPORTED; N - NOT SUPPORTED;',\n" +
                "  `mc_qps_id` CHAR(3) NOT NULL DEFAULT '',\n" +
                "  `mc_global_brand_ind` CHAR(1) NOT NULL DEFAULT '' COMMENT 'Y - IN EFFECT;',\n" +
                "  `mc_local_xborder_rate` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `mc_international_xborder_rate` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `visa_issuer_billing_markup` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `visa_proc_bin` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `visa_acquirer_local_bin` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `visa_acquirer_international_bin` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `visa_acquirer_prefix` CHAR(1) NOT NULL DEFAULT '' COMMENT 'ARN PREFIX',\n" +
                "  `visa_region` CHAR(1) NOT NULL DEFAULT '' COMMENT '3 - EUROPE; 4 - ASIA PACIFIC; 5 - ',\n" +
                "  `visa_ps2000` CHAR(1) NOT NULL DEFAULT '' COMMENT 'Y - SUPPORTED; N - NOT SUPPORTED;',\n" +
                "  `visa_local_isa_rate` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `visa_international_isa_rate` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `jcb_issuer_billing_markup` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `jcb_acquirer_licensee_id` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_issuer_licensee_id` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_rate_group1` CHAR(1) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_fee_licensee1` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_rate_group2` CHAR(1) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_fee_licensee2` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_rate_group3` CHAR(1) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_fee_licensee3` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_rate_group4` CHAR(1) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_fee_licensee4` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_rate_group5` CHAR(1) NOT NULL DEFAULT '',\n" +
                "  `jcb_special_fee_licensee5` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `jcb_agent_code` VARCHAR(25) NOT NULL DEFAULT '',\n" +
                "  `jcb_merch_agent_code1` VARCHAR(5) NOT NULL DEFAULT '',\n" +
                "  `jcb_merch_agent_code2` VARCHAR(5) NOT NULL DEFAULT '',\n" +
                "  `jcb_merch_agent_code3` VARCHAR(5) NOT NULL DEFAULT '',\n" +
                "  `jcb_merch_agent_code4` VARCHAR(5) NOT NULL DEFAULT '',\n" +
                "  `jcb_merch_agent_code5` VARCHAR(5) NOT NULL DEFAULT '',\n" +
                "  `jcb_arn_date_option` CHAR(1) NOT NULL DEFAULT '' COMMENT '0/Space - to generate ARN with',\n" +
                "  `amex_issuer_billing_markup` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `amex_pos_inst_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `amex_atm_inst_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `amex_issuer_inst_id` VARCHAR(11) NOT NULL DEFAULT '',\n" +
                "  `on_us_markup` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `jcb_fund_req_option` CHAR(1) NOT NULL DEFAULT '' COMMENT 'Y/N',\n" +
                "  `jcb_rtl_fee_rate` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `jcb_csh_fee_rate` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `jcb_atm_flat_fee` DECIMAL(18,5) NOT NULL DEFAULT '0.00000',\n" +
                "  `jcb_setl_type` CHAR(2) NOT NULL DEFAULT '' COMMENT '01 - FIXED; 02 - AGENT; 03 - FIFTY;',\n" +
                "  `jcb_setl_ccyt` CHAR(3) NOT NULL DEFAULT '',\n" +
                "  `itmx_arn_prefix` CHAR(1) NOT NULL DEFAULT '',\n" +
                "  `itmx_acquirer_bin` VARCHAR(6) NOT NULL DEFAULT '',\n" +
                "  `acquirer_issuer_ind` CHAR(1) NOT NULL DEFAULT '' COMMENT 'A - Acquirer; I - Issuer;',\n" +
                "  `visa_setl_currency` CHAR(3) NOT NULL DEFAULT '',\n" +
                "  `mc_setl_currency` CHAR(3) NOT NULL DEFAULT '',\n" +
                "  `create_by` VARCHAR(30) NOT NULL DEFAULT '',\n" +
                "  `create_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',\n" +
                "  `update_by` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '修改用户',\n" +
                "  `update_time` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',\n" +
                "  `version_number` INT NOT NULL DEFAULT '1' COMMENT '记录版本号',\n" +
                "  PRIMARY KEY(`id`)\n" +
                ") COMMENT = '机构参数配置表' DEFAULT CHARSET=utf8mb4 ENGINE=INNODB";

        try {
            CreateTable statement = (CreateTable) CCJSqlParserUtil.parse(sql);


            List<ColumnDefinition> columnDefinitions = statement.getColumnDefinitions();
            for (ColumnDefinition columnDefinition:columnDefinitions){
                String columnName = columnDefinition.getColumnName().replace("`","");
                ColDataType colDataType = columnDefinition.getColDataType();
                String sqlType = colDataType.getDataType();
                String javaType = ColumnJavaType.getColumnJavaTypeBySqlType(sqlType);
                List<String> argumentsStringList = colDataType.getArgumentsStringList();
                if (argumentsStringList != null){
                    String columnLength = argumentsStringList.toString();
                }




            }


        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
    }
}
