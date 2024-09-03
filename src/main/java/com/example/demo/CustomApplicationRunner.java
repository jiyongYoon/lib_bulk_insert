package com.example.demo;

import com.example.demo.bulk.*;
import com.example.demo.entity.wcm.domain.*;
import com.example.demo.entity.wcm.domain.enumeration.ContractStatus;
import com.example.demo.entity.wcm.domain.enumeration.ContractStepType;
import com.example.demo.entity.wcm.domain.enumeration.ReviewOption;
import com.example.demo.entity.wcm.domain.enumeration.UserRole;
import com.example.demo.entity.wcm.domain.util.WorkSpaceCodeGenerator;
import com.example.demo.repository.wcm.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class CustomApplicationRunner implements ApplicationRunner {

    private final BulkInsert bulkInsert;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final DeptRepository deptRepository;
    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceUserDeptRepository workspaceUserDeptRepository;
    private final TemplateContractRepository templateContractRepository;
    private final CompanyRepository companyRepository;

    String userName2 = "유저2";
    String testUserPassword1 = "테스트패스워드1";
    String testEmail1 = "test1@email";
    String adminName1 = "유저1&관리자";
    String adminPassword1 = "관리자비밀번호1";
    String adminEmail1 = "admin1@email";
    String userName1 = "유저1";
    String userName3 = "유저3";
    String userName4 = "유저4";
    String userPassword1 = "유저비밀번호1";
    String userEmail3 = "user3@email";
    String userEmail4 = "user4@email";
    String templateName1 = "탬플릿 이름1";
    String templateName2 = "탬플릿 이름2";
    String templateChangeName1 = "탬플릿 이름수정1";
    String contractName1 = "계약서 이름1";

    public User admin;
    public List<User> userList = new ArrayList<>();
    public Workspace savedWorkspaceEntity;
    public TemplateContract savedTemplateContractEntity;
    public Company savedCompanyEntity;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initData();
        System.out.println("---------initData() finished!!---------");
        saveTemplate();
        System.out.println("---------saveTemplate() finished!!---------");

        List<Contract> contractList = new ArrayList<>();

        int dataCount = 1000000;
        String contractSuffix = "_계약서";

        for (int i = 0; i < dataCount; i++) {
            Contract contract = Contract.builder()
                    .contractName(RandomStringUtils.generateRandomString(10) + contractSuffix)
                    .contractDetails(RandomStringUtils.generateRandomString(100))
                    .status(RandomEnumUtils.getRandomEnum(ContractStatus.class).getStatus())
                    .customStatus(RandomStringUtils.generateRandomString(7))
                    .deadLine(RandomIntUtils.getRandomInteger(72))
                    .createDate(RandomInstantUtils.getRandomInstant("2023-01-01", "2024-09-03"))
                    .startDate(RandomInstantUtils.getRandomInstant("2023-01-01", "2024-01-01"))
                    .endDate(RandomInstantUtils.getRandomInstant("2025-01-01", "2025-12-31"))
                    .totalCost(String.valueOf(RandomIntUtils.getRandomInt(100000000)))
                    .salesProfit(String.valueOf(RandomIntUtils.getRandomInt(100000000)))
                    .contractStepType(RandomEnumUtils.getRandomEnum(ContractStepType.class))
                    .workspaceCode(savedWorkspaceEntity.getId())
                    .build();
            contractList.add(contract);
        }

        bulkInsert.bulkInsertContractList(
                contractList, savedTemplateContractEntity, userList, savedCompanyEntity);

        System.out.printf("insert finished!! workspace code: %s, adminId: %s, adminPassword: %s%n",
                savedWorkspaceEntity.getId(), adminEmail1, adminPassword1);

//        List<User> userList = new ArrayList<>();

//        for (int i = 0; i < 50000; i++) {
//            User user = User.builder()
//                    .userName("username_" + i)
//                    .userEmail("string_" + i + "@email.com")
//                    .build();
//            userList.add(user);
//        }
//
//        bulkInsert.saveAll(userList);
    }

    private void initData() {
        // 유저 저장
        User user1 = User.builder()
                .userName(adminName1)
                .userEmail(adminEmail1)
                .userPassword(passwordEncoder.encode(adminPassword1))
                .userRole(UserRole.ADMIN)
                .build();
        User savedUser1 = userRepository.save(user1);

        admin = savedUser1;

        User user2 = User.builder()
                .userName(userName2)
                .userEmail(testEmail1)
                .userPassword(passwordEncoder.encode(testUserPassword1))
                .userRole(UserRole.USER)
                .build();
        User savedUser2 = userRepository.save(user2);

        User user3 = User.builder()
                .userName(userName3)
                .userEmail(userEmail3)
                .userPassword(passwordEncoder.encode(userPassword1))
                .userRole(UserRole.USER)
                .build();
        User savedUser3 = userRepository.save(user3);

        User user4 = User.builder()
                .userName(userName4)
                .userEmail(userEmail4)
                .userPassword(passwordEncoder.encode(userPassword1))
                .userRole(UserRole.USER)
                .build();
        User savedUser4 = userRepository.save(user4);
        userList.addAll(Arrays.asList(savedUser1, savedUser2, savedUser3, savedUser4));

        Dept dept1 = Dept.builder()
                .deptName("user3 리뷰어인 부서")
                .deptReviewer(user3)
                .build();
        Dept dept2 = Dept.builder()
                .deptName("user4 리뷰어인 부서")
                .deptReviewer(user4)
                .build();
        deptRepository.saveAll(Arrays.asList(dept1, dept2));

        Workspace workspace = Workspace.builder()
                .id("W001" + WorkSpaceCodeGenerator.makeUuid(false))
                .name("워크스페이스1")
                .isDeleted(false)
                .build();
        Workspace savedWorkspace = workspaceRepository.save(workspace);
        savedWorkspaceEntity = savedWorkspace;

        WorkspaceUserDept workspaceUserDept1 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace)
                .user(savedUser1)
                .build();
        WorkspaceUserDept workspaceUserDept2 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace)
                .user(savedUser2)
                .build();
        WorkspaceUserDept workspaceUserDept3 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace)
                .user(savedUser3)
                .build();
        WorkspaceUserDept workspaceUserDept4 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace)
                .user(savedUser4)
                .build();
        WorkspaceUserDept workspaceUserDept5 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace)
                .dept(dept1)
                .build();
        WorkspaceUserDept workspaceUserDept6 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace)
                .dept(dept2)
                .build();
        workspaceUserDeptRepository.saveAll(Arrays.asList(
                workspaceUserDept1, workspaceUserDept2, workspaceUserDept3, workspaceUserDept4, workspaceUserDept5, workspaceUserDept6));

        Company company = Company.builder()
                .companyName(RandomStringUtils.generateRandomString(10))
                .build();
        savedCompanyEntity = companyRepository.save(company);
    }

    private void saveTemplate() {
        TemplateContract templateContract = TemplateContract.builder()
                .createUser(admin)
                .templateName("test_template")
                .reviewOption(ReviewOption.CUSTOM)
                .deadLine(12)
                .workspaceCode(savedWorkspaceEntity.getId())
                .build();
        savedTemplateContractEntity = templateContractRepository.save(templateContract);
    }

}
