package interviewprep.questions.vendingmachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl(){
        initialize();
    }

    private void initialize(){
        for (Coin c: Coin.values())
            cashInventory.put(c, 5);
        for (Item i: Item.values())
            itemInventory.put(i, 5);
    }

    @Override
    public long selectItemAndGetPrice(Item item) throws SoldOutException{
        if(itemInventory.hasItem(item)){
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Sold out, please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance += coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    private boolean isFullPaid(){
        return currentBalance >= currentItem.getPrice();
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException{
        List<Coin> changes = Collections.EMPTY_LIST;

        if(amount > 0){
            changes = new ArrayList<>();
            long balance = amount;
            while(balance > 0){
                if(balance >= Coin.QUATER.getDenomination() && cashInventory.hasItem(Coin.QUATER)){
                    changes.add(Coin.QUATER);
                    balance = balance - Coin.QUATER.getDenomination();
                }else if(balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)){
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();
                }else if(balance >= Coin.NICKEL.getDenomination() && cashInventory.hasItem(Coin.NICKEL)){
                    changes.add(Coin.NICKEL);
                    balance = balance - Coin.NICKEL.getDenomination();
                }else if(balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)){
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();
                }else{
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }
        return changes;
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales += currentItem.getPrice();

        List<Coin> change = collectChange();
        return new Bucket<>(item, change);
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPaid()){
            if(hasSufficientChange()){
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("No sufficient change in the inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not fully paid, Remaining : ", remainingBalance);
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null; return change;
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    public void printStats(){
        System.out.println("Total sales: " + totalSales);
        System.out.println("Current Item Inventory: " + itemInventory);
        System.out.println("Current Cash Inventory: " + cashInventory);
    }

    private boolean hasSufficientChange(){
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }

    private boolean hasSufficientChangeForAmount(long amount){
        boolean hasChange = true;
        try{
            getChange(amount);
        }catch (NotSufficientChangeException ne){
            return hasChange = false;
        }
        return hasChange;
    }

    private void updateCashInventory(List<Coin> change){
        for(Coin c: change){
            cashInventory.deduct(c);
        }
    }

    public long getTotalSales(){
        return totalSales;
    }
}
