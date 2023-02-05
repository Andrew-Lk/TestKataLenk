class Arg {
    private int arg;
    private boolean rim;

    public Arg(int arg, boolean rim) {
        this.arg = arg;
        this.rim = rim;
    }

    public void setArgRim(int arg, boolean rim) {
        this.arg = arg;
        this.rim = rim;
    }

    public int getArg() {
        return arg;
    }

    public boolean getIsRim() {
        return rim;
    }
}
