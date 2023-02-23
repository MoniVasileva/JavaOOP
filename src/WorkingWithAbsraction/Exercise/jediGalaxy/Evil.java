package WorkingWithAbsraction.Exercise.jediGalaxy;

public class Evil {

    public void moveEvil(int rowEvil, int colEvil, StarsField starsField) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (starsField.isInBounds(rowEvil, colEvil)) {
                starsField.setValue(rowEvil, colEvil, 0);
            }
            rowEvil--;
            colEvil--;
        }
    }
}
