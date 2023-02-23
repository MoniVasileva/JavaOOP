package WorkingWithAbsraction.Exercise.jediGalaxy;

public class Galaxy {
    private StarsField starsField;
    private Jedi jedi;
    private Evil evil;

    public Galaxy(StarsField starsField) {
        this.starsField = starsField;
        this.jedi = new Jedi();
        this.evil=new Evil();
    }

    public long moveJedi(int row, int col) {
        return jedi.moveJedi(row, col, this.starsField);
    }
    public void moveEvil(int row, int col) {
        evil.moveEvil(row, col, this.starsField);
    }




}
