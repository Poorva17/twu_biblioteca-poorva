package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Section {

    private ArrayList<Item> availableItemList;
    private HashMap<Item, User> checkedoutList;

    public Section(ArrayList<Item> availableItemList, HashMap<Item, User> checkedoutList) {
        this.availableItemList = availableItemList;
        this.checkedoutList = checkedoutList;
    }

    public Item itemCheckout(String itemNameToCheckout, User currentUser) {
        for (Item item : availableItemList) {
            if (item.hasTitle(itemNameToCheckout)) {
                System.out.print("this is available");
                addItemToCheckoutList(item, currentUser);
                return item;
            }
        }
        System.out.print("this is not available");
        Item noItem = new Item("");
        return noItem;
    }

    private void addItemToCheckoutList(Item item, User currentUser) {
        availableItemList.remove(item);
        checkedoutList.put(item, currentUser);
    }

    public ArrayList<Item> getAvailableItemList() {
        return availableItemList;
    }

    public Item itemCheckin(String itemNameToCheckin, User currentUser) {
        for (Item item : checkedoutList.keySet()) {
            if (item.hasTitle(itemNameToCheckin)) {
                if (checkedoutList.get(item).equals(currentUser)) {
                    addItemToAvailableList(item);
                    return item;
                }
            }
        }
        Item noItem = new Item("");
        return noItem;
    }

    private void addItemToAvailableList(Item item) {
        availableItemList.add(item);
        checkedoutList.remove(item);
    }

    public HashMap<Item, User> getCheckoutList() {
        return checkedoutList;
    }
}
