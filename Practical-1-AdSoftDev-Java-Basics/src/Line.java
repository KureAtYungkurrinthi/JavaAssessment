public class Line {
    private String text;
    private int seqNum;

    public String getText() {
        return text;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    @Override
    public String toString() {
        return seqNum + ": " + text;
    }
}
