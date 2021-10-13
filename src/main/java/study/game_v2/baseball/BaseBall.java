package study.game_v2.baseball; 

public class BaseBall {
    private final int value;
    private final int position;

	public BaseBall(int value, int position) {
        this.value = value;
        this.position = position;
    }
    
    private boolean isSameValue(int value) {
        if(this.value == value) return true;
        return false;
    }

	public BaseBallStatus play(BaseBall compareBaseBall) {
        if(this.equals(compareBaseBall)) return BaseBallStatus.STRIKE;

        if(isSameValue(compareBaseBall.value)) return BaseBallStatus.BOWL;

        return BaseBallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof BaseBall)) return false;

        BaseBall compareBaseBall = (BaseBall)o;
        if(this.value == compareBaseBall.value && this.position == compareBaseBall.position) return true;
        
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + value;
        result = 31 * result + position;
        return result;

    }
    
}