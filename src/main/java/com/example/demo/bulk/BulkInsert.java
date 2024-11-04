package com.example.demo.bulk;

import com.example.demo.entity.wcm.domain.*;
import com.example.demo.entity.wcm.domain.string.TableName;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BulkInsert {

    private final JdbcTemplate jdbcTemplate;

    private final int batchSize = 1000;

    private int batchCount;

    public void bulkInsertReviewHistoryList(List<ReviewerHistory> reviewerHistoryList) {
        batchCount = 0;
        List<ReviewerHistory> items = new ArrayList<>();
        for (int i = 0; i < reviewerHistoryList.size(); i++) {
            items.add(reviewerHistoryList.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchInsertReviewerHistory(items);
            }
        }
        if (!items.isEmpty()) {
            batchCount = batchInsertReviewerHistory(items);
        }
        System.out.println("batchCount = " + batchCount);
    }

    private int batchInsertReviewerHistory(List<ReviewerHistory> reviewerHistoryList) {
        jdbcTemplate.batchUpdate("INSERT INTO " + TableName.REVIEWER_HISTORY + "(" +
                "user_id, " +
                "contract_history_id, " +
                "is_checked, " +
                "checked_time, " +
                "review_comment, " +
                "origin_type, " +
                "review_step_type, " +
                "review_status, " +
                "review_type, " +
                "step_order, " +
                "review_order) " +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ReviewerHistory reviewerHistory = reviewerHistoryList.get(i);
                    ps.setLong(1, RandomIntUtils.getRandomNaturalInt(4));
                    ps.setLong(2, RandomIntUtils.getRandomNaturalInt(reviewerHistoryList.size()));
                    ps.setBoolean(3, reviewerHistory.getIsChecked());
                    ps.setTimestamp(4, Timestamp.from(reviewerHistory.getCheckedTime()));
                    ps.setString(5, reviewerHistory.getReviewComment());
                    ps.setString(6, reviewerHistory.getOriginType().toString());
                    ps.setString(7, reviewerHistory.getReviewStepType().toString());
                    ps.setString(8, reviewerHistory.getReviewStatus().toString());
                    ps.setString(9, reviewerHistory.getReviewType().toString());
                    ps.setInt(10, reviewerHistory.getStepOrder());
                    ps.setInt(11, reviewerHistory.getReviewOrder());
                }

                @Override
                public int getBatchSize() {
                    return reviewerHistoryList.size();
                }
            }
        );
        reviewerHistoryList.clear();
        batchCount++;
        System.out.println("insert count: " + batchCount);
        return batchCount;
    }

    public void bulkInsertContractHistoryList(List<ContractHistory> contractHistoryList) {
        batchCount = 0;
        List<ContractHistory> items = new ArrayList<>();
        for (int i = 0; i < contractHistoryList.size(); i++) {
            items.add(contractHistoryList.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchInsertContractHistory(items);
            }
        }
        if (!items.isEmpty()) {
            batchCount = batchInsertContractHistory(items);
        }
        System.out.println("batchCount = " + batchCount);
    }

    private int batchInsertContractHistory(List<ContractHistory> contractHistoryList) {
        jdbcTemplate.batchUpdate("INSERT INTO " + TableName.CONTRACT_HISTORY + "(" +
                "contract_id, " +
                "history_version, " +
                "history_status, " +
                "is_deleted, " +
                "is_latest, " +
                "current_step_order, " +
                "total_step_order, " +
                "current_review_order)" +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?)",
            new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ContractHistory contractHistory = contractHistoryList.get(i);
                    ps.setLong(1, i + 1);
                    ps.setString(2, contractHistory.getHistoryVersion());
                    ps.setString(3, contractHistory.getHistoryStatus().name());
                    ps.setBoolean(4, contractHistory.getIsDeleted());
                    ps.setBoolean(5, contractHistory.getIsLatest());
                    ps.setInt(6, contractHistory.getCurrentStepOrder());
                    ps.setInt(7, contractHistory.getTotalStepOrder());
                    ps.setInt(8, contractHistory.getCurrentReviewOrder());
                }

                @Override
                public int getBatchSize() {
                    return contractHistoryList.size();
                }
            }
        );
        contractHistoryList.clear();
        batchCount++;
        System.out.println("insert count: " + batchCount);
        return batchCount;
    }


    public void bulkInsertContractList(List<Contract> contractList,
                                       TemplateContract templateContract,
                                       List<User> createUserList,
                                       Company company) {
        batchCount = 0;
        List<Contract> items = new ArrayList<>();
        for (int i = 0; i < contractList.size(); i++) {
            items.add(contractList.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchInsertContract(items, templateContract, createUserList, company);
            }
        }
        if (!items.isEmpty()) {
            batchCount = batchInsertContract(items, templateContract, createUserList, company);
        }
        System.out.println("batchCount: " + batchCount);
    }

    private int batchInsertContract(List<Contract> contractList,
                                    TemplateContract templateContract,
                                    List<User> createUserList,
                                    Company company) {
        jdbcTemplate.batchUpdate("INSERT INTO " + TableName.CONTRACT + "(" +
                        "contract_name, " +
                        "contract_details, " +
                        "status, " +
                        "custom_status, " +
                        "dead_line, " +
                        "create_date, " +
                        "start_date, " +
                        "end_date, " +
                        "total_cost, " +
                        "sales_profit, " +
                        "is_deleted, " +
                        "contract_step_type, " +
                        "workspace_code, " +
                        "template_id, " +
                        "company_id, " +
                        "user_id) " +
                        "VALUES " +
                        "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        // TODO set value
                        Contract currentContract = contractList.get(i);
                        ps.setString(1, currentContract.getContractName());
                        ps.setString(2, currentContract.getContractDetails());
                        ps.setString(3, currentContract.getStatus());
                        ps.setString(4, currentContract.getCustomStatus());
                        ps.setInt(5, currentContract.getDeadLine());
                        ps.setTimestamp(6, Timestamp.from(currentContract.getCreateDate()));
                        ps.setTimestamp(7, Timestamp.from(currentContract.getStartDate()));
                        ps.setTimestamp(8, Timestamp.from(currentContract.getEndDate()));
                        ps.setString(9, currentContract.getTotalCost());
                        ps.setString(10, currentContract.getSalesProfit());
                        ps.setBoolean(11, false);
                        ps.setString(12, currentContract.getContractStepType().toString());
                        ps.setString(13, currentContract.getWorkspaceCode());
                        ps.setLong(14, templateContract.getId());
                        ps.setLong(15, company.getId());
                        ps.setLong(16, createUserList.get(RandomIntUtils.getRandomInt(3)).getId());
                    }

                    @Override
                    public int getBatchSize() {
                        return contractList.size();
                    }
                }
        );
        contractList.clear();
        batchCount++;
        System.out.println("insert count: " + batchCount);
        return batchCount;
    }

    public void saveAll(List<User> items) {
        batchCount = 0;
        List<User> subItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            subItems.add(items.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchInsertUser(subItems);
            }
        }
        if (!subItems.isEmpty()) {
            batchCount = batchInsertUser(subItems);
        }
        System.out.println("batchCount: " + batchCount);
    }

    private int batchInsertUser(List<User> subItems) {
        jdbcTemplate.batchUpdate("INSERT INTO wcm_tb_user (user_name, user_email) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, subItems.get(i).getUserName());
                        ps.setString(2, subItems.get(i).getUserEmail());
                    }
                    @Override
                    public int getBatchSize() {
                        return subItems.size();
                    }
                });
        subItems.clear();
        batchCount++;
        return batchCount;
    }
}
