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

    String adminEmail1 = "admin1@email";
    String adminName1 = "유저1&관리자";
    String adminPassword1 = "관리자비밀번호1";
    String userEmail2 = "user2@email";
    String userName2 = "유저2";
    String userEmail3 = "user3@email";
    String userName3 = "유저3";
    String userEmail4 = "user4@email";
    String userName4 = "유저4";
    String userCommonPassword = "유저비밀번호";

    String templateName1 = "탬플릿 이름1";
    String templateName2 = "탬플릿 이름2";
    String templateChangeName1 = "탬플릿 이름수정1";
    String contractName1 = "계약서 이름1";

    public User admin;
    public List<User> userList = new ArrayList<>();
    public Workspace savedWorkspaceEntity1; // 유저 1, 2, 3
    public Workspace savedWorkspaceEntity2; // 유저 1, 2, 4
    public Workspace savedWorkspaceEntity3; // 유저 1, 3, 4
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
                    .workspaceCode(savedWorkspaceEntity1.getId())
                    .build();
            contractList.add(contract);
        }

        bulkInsert.bulkInsertContractList(
                contractList, savedTemplateContractEntity, userList, savedCompanyEntity);

        System.out.printf("insert finished!! workspace code1: %s, workspace code2: %s, workspace code3: %s%n, " +
                        "adminId: %s, adminPassword: %s%n" +
                        "user2: %s, user2Password: %s%n" +
                        "user3: %s, user3Password: %s%n" +
                        "user4: %s, user4Password: %s%n",
                savedWorkspaceEntity1.getId(), savedWorkspaceEntity2.getId(), savedWorkspaceEntity3.getId(),
                adminEmail1, adminPassword1,
                userEmail2, userCommonPassword,
                userEmail3, userCommonPassword,
                userEmail4, userCommonPassword
        );

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
                .userEmail(userEmail2)
                .userPassword(passwordEncoder.encode(userCommonPassword))
                .userRole(UserRole.USER)
                .build();
        User savedUser2 = userRepository.save(user2);

        User user3 = User.builder()
                .userName(userName3)
                .userEmail(userEmail3)
                .userPassword(passwordEncoder.encode(userCommonPassword))
                .userRole(UserRole.USER)
                .build();
        User savedUser3 = userRepository.save(user3);

        User user4 = User.builder()
                .userName(userName4)
                .userEmail(userEmail4)
                .userPassword(passwordEncoder.encode(userCommonPassword))
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

        Workspace workspace1 = Workspace.builder()
                .id("W001" + WorkSpaceCodeGenerator.makeUuid(false))
                .name("워크스페이스1")
                .isDeleted(false)
                .build();
        Workspace savedWorkspace1 = workspaceRepository.save(workspace1);
        savedWorkspaceEntity1 = savedWorkspace1;

        Workspace workspace2 = Workspace.builder()
                .id("W001" + WorkSpaceCodeGenerator.makeUuid(false))
                .name("워크스페이스2")
                .isDeleted(false)
                .build();
        Workspace savedWorkspace2 = workspaceRepository.save(workspace2);
        savedWorkspaceEntity2 = savedWorkspace2;

        Workspace workspace3 = Workspace.builder()
                .id("W001" + WorkSpaceCodeGenerator.makeUuid(false))
                .name("워크스페이스3")
                .isDeleted(false)
                .build();
        Workspace savedWorkspace3 = workspaceRepository.save(workspace3);
        savedWorkspaceEntity3 = savedWorkspace3;

        // workspace1
        WorkspaceUserDept workspaceUserDept1 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace1)
                .user(savedUser1)
                .build();
        WorkspaceUserDept workspaceUserDept2 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace1)
                .user(savedUser2)
                .build();
        WorkspaceUserDept workspaceUserDept3 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace1)
                .user(savedUser3)
                .build();
        // workspace2
        WorkspaceUserDept workspaceUserDept4 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace2)
                .user(savedUser1)
                .build();
        WorkspaceUserDept workspaceUserDept5 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace2)
                .user(savedUser2)
                .build();
        WorkspaceUserDept workspaceUserDept6 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace2)
                .user(savedUser4)
                .build();
        // workspace3
        WorkspaceUserDept workspaceUserDept7 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace3)
                .user(savedUser1)
                .build();
        WorkspaceUserDept workspaceUserDept8 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace3)
                .user(savedUser3)
                .build();
        WorkspaceUserDept workspaceUserDept9 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace3)
                .user(savedUser4)
                .build();

        // workspace1 dept
        WorkspaceUserDept workspaceUserDept10 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace1)
                .dept(dept1)
                .build();
        WorkspaceUserDept workspaceUserDept11 = WorkspaceUserDept.builder()
                .workspace(savedWorkspace1)
                .dept(dept2)
                .build();

        workspaceUserDeptRepository.saveAll(Arrays.asList(
                    workspaceUserDept1,
                    workspaceUserDept2,
                    workspaceUserDept3,
                    workspaceUserDept4,
                    workspaceUserDept5,
                    workspaceUserDept6,
                    workspaceUserDept7,
                    workspaceUserDept8,
                    workspaceUserDept9,
                    workspaceUserDept10,
                    workspaceUserDept11
                )
        );

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
                .workspaceCode(savedWorkspaceEntity1.getId())
                .build();
        savedTemplateContractEntity = templateContractRepository.save(templateContract);
    }

}
