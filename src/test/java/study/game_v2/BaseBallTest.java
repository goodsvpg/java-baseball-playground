package study.game_v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.junit.jupiter.api.Test;

import study.game_v2.baseball.BaseBall;
import study.game_v2.baseball.BaseBallStatus;

public class BaseBallTest {
    
    @Test
    public void testIsStrike() {
        BaseBall baseBall = new BaseBall(1, 2);
        BaseBallStatus gameResult = baseBall.play(new BaseBall(1, 2));
        assertThat(gameResult).isEqualTo(BaseBallStatus.STRIKE);
    }
}