package eshop.archive;

import eshop.shop.Item;
import eshop.shop.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


/**
 * Class for archive of the purchases
 */
public class PurchasesArchive {

    private HashMap<Integer, ItemPurchaseArchiveEntry> itemPurchaseArchive;
    private ArrayList<Order> orderArchive;
    private boolean isTrue = true;
    private String stats;
    private ItemPurchaseArchiveEntry purchaseArchiveEntry;

    public PurchasesArchive() {
        itemPurchaseArchive = new HashMap();
        orderArchive = new ArrayList();
    }

    public void setOrderArchive(ArrayList<Order> orderArchive) {
        this.orderArchive = orderArchive;
    }

    public ArrayList<Order> getOrderArchive() {
        return orderArchive;
    }

    public void setItemPurchaseArchive(HashMap<Integer, ItemPurchaseArchiveEntry> itemPurchaseArchive) {
        this.itemPurchaseArchive = itemPurchaseArchive;
    }

    // Added to the main program for ItemPurchaseArchiveEntry test
    public HashMap<Integer, ItemPurchaseArchiveEntry> getItemPurchaseArchive() {
        return itemPurchaseArchive;
    }

    public boolean getIsTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        this.isTrue = aTrue;
    }

    public ItemPurchaseArchiveEntry getPurchaseArchiveEntry() {
        return purchaseArchiveEntry;
    }

    public void setPurchaseArchiveEntry(ItemPurchaseArchiveEntry purchaseArchiveEntry) {
        this.purchaseArchiveEntry = purchaseArchiveEntry;
    }

    public PurchasesArchive(HashMap<Integer, ItemPurchaseArchiveEntry> itemArchive, ArrayList<Order> orderArchive) {
        this.itemPurchaseArchive = itemArchive;
        this.orderArchive = orderArchive;
    }

    public String printItemPurchaseStatistics(String stats) {
        Collection<ItemPurchaseArchiveEntry> itemEntries = itemPurchaseArchive.values();
        for (ItemPurchaseArchiveEntry e : itemEntries) {
            System.out.println(e.toString());
        }
        return stats;
    }

    public int getHowManyTimesHasBeenItemSold(Item item) {
        if (itemPurchaseArchive.containsKey(item.getID())) {
            return itemPurchaseArchive.get(item.getID()).getCountHowManyTimesHasBeenSold();
        }
        return 0;
    }

    public boolean putOrderToPurchasesArchive(Order order, boolean result) {
        orderArchive.add(order);
        ArrayList<Item> orderItems = order.getItems();
        for (Item i : orderItems) {
            if (itemPurchaseArchive.containsKey(i.getID())) {
                purchaseArchiveEntry = itemPurchaseArchive.get(i.getID());
                purchaseArchiveEntry.increaseCountHowManyTimesHasBeenSold(1);
                result = true;
            } else {
                itemPurchaseArchive.put(i.getID(), new ItemPurchaseArchiveEntry(i));
                result = false;
            }
        }
        return result;
    }
}

