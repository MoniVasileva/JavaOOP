package workingWithAbsraction.Exercise.cards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Card Suits:");
//        Arrays.stream(Cards.values())
//                .forEach(cards -> System.out.printf("Ordinal value: %d; Name value: %s\n",cards.ordinal(),cards.name()));
//
//        System.out.println("Card Ranks:");
//        for (CardRanks cardRank :
//                CardRanks.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s\n",cardRank.ordinal(),cardRank.name());
//        }

        Scanner scanner = new Scanner(System.in);
        CardRanks cardRanks = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuits = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card( cardSuits,cardRanks);

        System.out.printf("Card name: %s of %s; Card power: %d\n",card.getCardRanks(),card.getCardSuits(),card.getPower());
    }
}
