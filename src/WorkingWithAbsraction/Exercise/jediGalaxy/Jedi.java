package WorkingWithAbsraction.Exercise.jediGalaxy;

public class Jedi {

    public long moveJedi( int rowJedi, int colJedi,StarsField starsField) {
        long sum = 0;
        while (rowJedi >= 0 && colJedi < starsField.getColLength()) {
            if (starsField.isInBounds( rowJedi, colJedi)) {
                sum += starsField.getValue(rowJedi, colJedi);
            }

            colJedi++;
            rowJedi--;
        }
        return sum;
    }
}
