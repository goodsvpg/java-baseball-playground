package study.game_v1;

public class NumberBaseballGameInputView {

// > 1) 숫자를 입력해 주세요 : - core의  play를 호출    
    public void printInputNumber() {
        System.out.print("숫자를 입력해 주세요: ");
    }
// > 2) 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. 
    public void answerGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}