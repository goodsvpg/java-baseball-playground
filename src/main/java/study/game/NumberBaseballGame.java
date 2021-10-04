package study.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class NumberBaseballGame {

    private static NumberBaseballGameCore core;

    private static NumberBaseballGameInputView inputView;

    private static NumberBaseballGameResultView resultView;

    public NumberBaseballGame() {
        core = new NumberBaseballGameCore();
        inputView = new NumberBaseballGameInputView();
        resultView = new NumberBaseballGameResultView();
    }

    static void play() throws IOException {

        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputView.printInputNumber();
            String input = br.readLine();
            System.out.println(input);
            if (core.isValidLength(input) == false) {
                resultView.printInvalidLength();
                continue;
            }
            if (core.isValidNumber(input) == false) {
                resultView.printInvalidNumber();
                continue;
            }

            Map<Rule, Integer> resultMap = core.getMatchResult(input);
            resultView.printResult(resultMap);
            
            if(core.isSuccess() == false) continue;
                
            inputView.answerGameEnd();  
            
            if(core.isGameEnd(br.read()) == false) {
                br.close();
                break;
            }
        }
        resultView.printGameEnd();
    }

    public static void main(final String[] args) {
        NumberBaseballGame game = new NumberBaseballGame();
        try {
            game.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}