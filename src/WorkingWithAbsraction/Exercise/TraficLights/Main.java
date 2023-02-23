package workingWithAbsraction.Exercise.TraficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> colors = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<TraficLight> traficLights = new ArrayList<>();

        for (String color : colors) {
            Color currentColor = Color.valueOf(color);
            TraficLight currentTraficLight = new TraficLight(currentColor);
            traficLights.add(currentTraficLight);
        }
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (TraficLight traficLight : traficLights) {
                traficLight.changeColor();
                System.out.print(traficLight.getCurrentColor()+" ");
            }
            System.out.println();
        }
    }
}
