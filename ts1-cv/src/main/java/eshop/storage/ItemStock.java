package eshop.storage;

import eshop.shop.Item;


/**
 * Auxiliary class for item storage
 */
public class ItemStock {
    private final Item refItem;
    private int count;

    public ItemStock(Item refItem) {
        this.refItem = refItem;
        count = 0;
    }

    @Override
    public String toString() {
        return "STOCK OF ITEM:  " + refItem.toString() + "    PIECES IN STORAGE: " + count;
    }

    public int IncreaseItemCount(int x) {
        return count += x;
    }

    public int decreaseItemCount(int x) {
        return count -= x;
    }

    public int getCount() {
        return count;
    }

    Item getItem() {
        return refItem;
    }
}