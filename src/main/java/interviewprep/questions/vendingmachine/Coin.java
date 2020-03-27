package interviewprep.questions.vendingmachine;

public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUATER(25);

    private int denomination;

    private Coin(int denomination){
        this.denomination = denomination;
    }
    public int getDenomination(){
        return denomination;
    }
}
