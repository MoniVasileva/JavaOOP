package football.entities.player;

public class Women extends BasePlayer {

    private static final double KILOGRAMS = 60;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 115);
    }
}
