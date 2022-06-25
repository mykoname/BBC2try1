public class matchResults {
    public String teamLeft;
    public String teamRight;
    public int scoreLeft;
    public int scoreRight;

    public matchResults(String teamLeft, String teamRight, int scoreLeft, int scoreRight) {
        this.teamLeft = teamLeft;
        this.teamRight = teamRight;
        this.scoreLeft = scoreLeft;
        this.scoreRight = scoreRight;
    }
    @Override
    public boolean equals(Object otherObject) {
        // check for reference equality.
        if (this == otherObject) {
            return true;
        }
        if (otherObject instanceof matchResults) {
            matchResults that = (matchResults) otherObject;
            // Check for name equality.
            boolean b = (teamLeft == null && that.teamLeft == null)
                    || (teamLeft.equals(that.teamLeft) & teamRight.equals(that.teamRight)
                    & scoreLeft == (that.scoreLeft) & scoreRight == (that.scoreRight));
            return b;
        }
        return false;
    }
}


