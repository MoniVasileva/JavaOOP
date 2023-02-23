package workingWithAbsraction.Exercise.cards;

public class Card {
    private  CardSuits cardSuits;
    private  CardRanks cardRanks;

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public void setCardSuits(CardSuits cardSuits) {
        this.cardSuits = cardSuits;
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public void setCardRanks(CardRanks cardRanks) {
        this.cardRanks = cardRanks;
    }

    public Card(CardSuits cardSuits, CardRanks cardRanks) {
        this.cardSuits = cardSuits;
        this.cardRanks = cardRanks;
    }
    public int getPower(){
        return cardRanks.getRankPower()+cardSuits.getSuitPower();
    }

}
