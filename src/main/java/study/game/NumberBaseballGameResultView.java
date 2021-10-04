package study.game;

import java.util.Map;

public class NumberBaseballGameResultView {
    
    public void printInvalidLength() {
        System.out.println("숫자의 자리수가 초과하였습니다.");
    }

    public void printInvalidNumber() {
        System.out.println("숫자의 범위가 잘못되었습니다.");
    }

    public void printResult(Map<Rule, Integer> resultMap) {
        StringBuilder result = new StringBuilder();
        
        int bowl = resultMap.get(Rule.BOWL); 
        int strike = resultMap.get(Rule.STRIKE);

        if(bowl > 0) result.append(bowl+"볼 ");
        if(strike > 0) result.append(strike+"스트라이크 ");
        if(result.length() == 0) result.append("낫싱");
        System.out.println(result.toString());
    }
    
    public void printGameEnd() {
        System.out.println("게임이 종료되었습니다. 이용해주셔서 감사합니다.");
    }
}