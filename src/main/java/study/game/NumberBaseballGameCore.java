package study.game;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NumberBaseballGameCore {
    private static final int RESTART = 1;

    private static final int END = 2;

    private static final int MAX_INPUT_SIZE = 3;

    private char[] answerList;

    private char[] inputList;

    private Map<Rule, Integer> result;

    // 1) 숫자 범위 validation check
    // (1) 숫자의 범위는 1~9 - 정규식으로 0, 문자 등은 걸러 냄
    // (2) 숫자 입력 가능 개수는 3개 - size로 걸러냄
    // 2) 볼 / 스트라이크 / 포볼 체크
    // (1) 입력한 자리의 수와 정답 값의 자리의 수가 일치하는가? "스트라이크"의 수를 증가한다
    // (2) 입력한 자리의 수가 정답 값은 다른 자리의 수와 일치하는가? "볼"의 수를 증가한다
    // (3) "포볼"의 수를 증가한다
    // 3) 게임 결과 반환 - 결과값만 전달하고 실제 조합은 ui 에서
    // 4) 게임 재 시작 / 완전 종료 판단 - 1, 2에 따른 판단 - 상수나 enum ?
    public boolean isValidLength(String input) {
        if (input.length() == MAX_INPUT_SIZE)
            return true;
        return false;
    }

    public boolean isValidNumber(String input) {
        return Pattern.matches("^[1-9]*$", input);
    }

    public boolean isValueGameEndAnswer(int answer) {
        if(result.containsValue(answer)) return true;
        return false;
    }

    public Map<Rule, Integer> getMatchResult(String input) {
        init(input);
        judgeMatch(input);
        return result;
    }

    private void init(String input) {
        result = new HashMap<Rule, Integer>();
        // 1. Map.ofEntries()는 불변
        // 2. 익명클래스를 사용한 초기화는
        // enclosing object에 대한 숨겨진 reference를 보유하여
        // 메모리 누수 문제를 일으킬 수 있음으로 주의
        result.put(Rule.STRIKE, 0);
        result.put(Rule.BOWL, 0);

        answerList = new char[] { '5', '8', '2' };
        inputList = input.toCharArray();
    }

    private void judgeMatch(String input) {
        compareAnswerAndInputList(inputList, 0);
    }

    private void compareAnswerAndInputList(char[] inputList, int inputListIndex) {
        if (inputListIndex == MAX_INPUT_SIZE)
            return;
        for (int answerListIndex = 0; answerListIndex < MAX_INPUT_SIZE; answerListIndex++) {
            renewalMatchResult(inputList, answerListIndex, inputListIndex);
        }

        compareAnswerAndInputList(inputList, ++inputListIndex);
    }

    private void renewalMatchResult(char[] inputList, int answerListIndex, int inputListIndex) {
        if (answerList[answerListIndex] != inputList[inputListIndex])
            return;
        if (answerListIndex == inputListIndex) {
            increaseMatchResult(Rule.STRIKE);
            return;
        }
        increaseMatchResult(Rule.BOWL);
    }

    private void increaseMatchResult(Rule rule) {
        int value = result.get(rule);
        result.put(rule, ++value);
    }

    public boolean isSuccess() {
        if (result.get(Rule.STRIKE) == MAX_INPUT_SIZE)
            return true;
        return false;
    }

    public boolean isGameEnd(int answer) {
        if(Character.getNumericValue(answer) == RESTART) return true;
        if(Character.getNumericValue(answer) == END) return false;
        return false;
    }
}   