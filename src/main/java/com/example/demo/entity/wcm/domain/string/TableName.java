package com.example.demo.entity.wcm.domain.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableName {
    public static final List<String> allTableName = new ArrayList<>(
            Arrays.asList(
                    TableName.ADD_REVIEWER,
                    TableName.AUTHORITY,
                    TableName.BOOKMARK,
                    TableName.COMPANY,
                    TableName.CONTACT,
                    TableName.CONTRACT,
                    TableName.CONTRACT_LINK,
                    TableName.CONTRACT_COMMENT,
                    TableName.CONTRACT_HISTORY,
                    TableName.CONTRACT_MONEY_TRANSFER,
                    TableName.COST_ANALYSIS,
                    TableName.DEPT,
                    TableName.FILE,
                    TableName.MANAGER_HISTORY,
                    TableName.NOTIFICATION,
                    TableName.OPTION_DETAILS,
                    TableName.OPTION_LIST,
                    TableName.READER_HISTORY,
                    TableName.REVIEWER_HISTORY,
                    TableName.TEMPLATE_CONTRACT,
                    TableName.TEMPLATE_PERMISSION,
                    TableName.TEMPLATE_REVIEWER,
                    TableName.USER_CONTACT,
                    TableName.USER,
                    TableName.TEMPLATE_REVIEW_STEP,
                    TableName.TEMPLATE_REVIEW_META_INFO,
                    TableName.TEMPLATE_REVIEW_CUSTOM,
                    TableName.WORKSPACE,
                    TableName.WORKSPACE_USER_DEPT,
                    TableName.AUDIT
            )
    );
    public static final String ADD_REVIEWER = "wcm_tb_add_reviewer";
    public static final String AUTHORITY = "wcm_tb_authority";
    public static final String BOOKMARK = "wcm_tb_bookmark";
    public static final String COMPANY = "wcm_tb_company";
    public static final String CONTACT = "wcm_tb_contact";
    public static final String CONTRACT = "wcm_tb_contract";
    public static final String CONTRACT_LINK = "wcm_tb_contract_link";
    public static final String CONTRACT_COMMENT = "wcm_tb_contract_comment";
    public static final String CONTRACT_HISTORY = "wcm_tb_contract_history";
    public static final String CONTRACT_MONEY_TRANSFER = "wcm_tb_contract_money_transfer";
    public static final String COST_ANALYSIS = "wcm_tb_cost_analysis";
    public static final String DEPT = "wcm_tb_dept";
    public static final String FILE = "wcm_tb_file";
    public static final String MANAGER_HISTORY = "wcm_tb_manager_history";
    public static final String NOTIFICATION = "wcm_tb_notification";
    public static final String OPTION_DETAILS = "wcm_tb_optiondetails";
    public static final String OPTION_LIST = "wcm_tb_optionlist";
    public static final String READER_HISTORY = "wcm_tb_reader_history";
    public static final String REVIEWER_HISTORY = "wcm_tb_reviewer_history";
    public static final String TEMPLATE_CONTRACT = "wcm_tb_template_contract";
    public static final String TEMPLATE_PERMISSION = "wcm_tb_template_permission";
    public static final String TEMPLATE_REVIEWER = "wcm_tb_template_reviewer";

    public static final String USER_CONTACT = "wcm_tb_user_contact";
    public static final String USER = "wcm_tb_user";

    public static final String TEMPLATE_REVIEW_STEP = "wcm_tb_template_review_step";

    public static final String TEMPLATE_REVIEW_META_INFO = "wcm_tb_template_review_custom_meta";

    public static final String TEMPLATE_REVIEW_CUSTOM = "wcm_tb_template_review_custom";
    public static final String WORKSPACE = "wcm_tb_workspace";
    public static final String WORKSPACE_USER_DEPT = "wcm_tb_workspace_user_dept";

    public static final String AUDIT = "wcm_tb_audit";


}
