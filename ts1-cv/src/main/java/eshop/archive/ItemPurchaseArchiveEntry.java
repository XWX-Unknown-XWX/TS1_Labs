package eshop.archive;

import eshop.shop.Item;

public class ItemPurchaseArchiveEntry {
    private final Item refItem;
    private int soldCount;

    public ItemPurchaseArchiveEntry(Item refItem) {
        this.refItem = refItem;
        soldCount = 1;
    }

    void increaseCountHowManyTimesHasBeenSold(int x) {
        soldCount += x;
    }

    public int getCountHowManyTimesHasBeenSold() {
        return soldCount;
    }

    Item getRefItem() {
        return refItem;
    }

    @Override
    public String toString() {
        return "ITEM  " + refItem.toString() + "   HAS BEEN SOLD " + soldCount + " TIMES";
    }
}
