package com.example.demo.entity.wcm.domain.util;

import java.util.UUID;

/**
 * Workspace 코드 생성기 <br>
 * 총 16자리: 예시 - W001C030E0811E97 <br>
 * prefix: W (workspace의 w) <br>
 * 첫 세자리: 회사 숫자 (ex, 위즈코어 - 001, 비잉테크 - 002 ...) <br>
 * 나머지 열두자리: UUID에서 추출 및 2, 4, 6, 8번째 자리에 pk값 추가 <br>
 */
public class WorkSpaceCodeGenerator {

    // 23-09-22 불필요하다고 판단하여 사용하지 않음

    /**
     * Workspace row 갯수를 code에 추가하여 겹치는 Code가 없도록 generate
     *
     * @param pk service 에서 서버가 시작될 때 row 값을 한번 불러와서 atomic으로 +1씩 증가시켜 static으로 메모리에 보관하여 사용
     * @return
     */
    private static String generateWorkspaceCode(String pk) {
        StringBuilder baseUuid = new StringBuilder(makeUuid(false));
        char[] charArray = pk.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            baseUuid.insert((i * 2) + 1, c);
        }
        return baseUuid.toString();
    }

    /**
     * uuid의 마지막 8자리 사용하여 Uuid를 만드는 메서드.
     *
     * @param includeHyphen 하이픈을 사용할지 말지. false면 하이픈 없이 문자만 붙여서 사용
     * @return 숫자가 3개 이하인 8자리의 대문자 UUID
     */
    public static String makeUuid(boolean includeHyphen) {

        String result = "";

        int digitCount = 8;
        while (digitCount > 3) {
            digitCount = 0;
            if (includeHyphen) {
                result = UUID.randomUUID().toString();
            } else {
                result = UUID.randomUUID().toString().replace("-", "");
            }

            result = extractLast8Digits(result);

            for (char c : result.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
        }

        return result;
    }

    private static String extractLast8Digits(String uuid) {
        return uuid.substring(uuid.length() - 8).toUpperCase();
    }
}
