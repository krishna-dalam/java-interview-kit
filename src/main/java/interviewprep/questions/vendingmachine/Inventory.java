package interviewprep.questions.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private Map<T, Integer> inventory = new HashMap<>();

    public int getQuantity(T item){
        Integer value = inventory.get(item);
        return value == null ? 0 : value;
    }

    public void add(T item){
        inventory.put(item, inventory.get(item)+1);
    }

    public void deduct(T item){
        if(hasItem(item)){
            inventory.put(item, inventory.get(item) - 1);
        }
    }

    public boolean hasItem(T item){
        return getQuantity(item) > 0;
    }

    public void clear(){
        inventory.clear();
    }

    public void put(T item, int quantity){
        inventory.put(item, quantity);
    }
}
