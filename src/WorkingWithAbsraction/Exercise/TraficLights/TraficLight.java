package workingWithAbsraction.Exercise.TraficLights;

public class TraficLight {
    private  Color currentColor;

    public TraficLight(Color currentColor) {
        this.currentColor = currentColor;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void  changeColor(){
        switch (currentColor){
            case RED:
                this.currentColor=Color.GREEN;
                break;
            case GREEN:
                this.currentColor=Color.YELLOW;
                break;
            case YELLOW:
                this.currentColor=Color.RED;
                break;
        }
    }
}
