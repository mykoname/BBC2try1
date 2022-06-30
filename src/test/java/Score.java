class Score {
    public int result1;
    public int result2;

    public Score(int lhs, int rhs) {
       result1 = lhs;
       result2 = rhs;
    }

    @Override
    public boolean equals(Object otherObject) {
        // check for reference equality.
        if (this == otherObject) {
            return true;
        }
        if (otherObject instanceof Score) {
            Score other = (Score) otherObject;
            boolean b = (result1 == (other.result1) & result2 == (other.result2));
            return b;
        }
        return false;
    }
}