package study.game_v1;

enum GameEndingChoice {
    RESTART(1), END(2);

    private int choiceNumber;

    private GameEndingChoice(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }

    public int getChoiceNumber() {
        return this.choiceNumber;
    }

}