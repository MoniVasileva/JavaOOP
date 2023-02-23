package football.entities.player;

public class Men extends BasePlayer {

    private static final double KILOGRAMS = 60;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength()+145);
    }
}
