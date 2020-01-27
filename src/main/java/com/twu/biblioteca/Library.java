package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Library<T extends Printable> implements Printable {
    Printer printer;

    private List<T> items;
    private List<Boolean> checkedOut;

    public Library(Printer printer, List<T> items) {
        this.printer = printer;

        this.items = items;
        this.checkedOut = Arrays.asList(new Boolean[items.size()]);
        Collections.fill(checkedOut, Boolean.FALSE);
    }

     public void checkoutItem (int itemNumber) throws InvalidItem {
         checkIfIsOutOfBounds(itemNumber);

         int itemIndex = itemNumber-1;

         if (this.checkedOut.get(itemIndex)) {
             printer.print("Sorry, that item is not available");
             return;
         }

         this.checkedOut.set(itemIndex, Boolean.TRUE);
         printer.print("Thank you! Enjoy the item");
     }

     public void returnItem (int itemNumber) throws InvalidItem {
         checkIfIsOutOfBounds(itemNumber);

         int itemIndex = itemNumber-1;

         if (!this.checkedOut.get(itemIndex)) {
             printer.print("That is not a valid item to return");
             return;
         }

         this.checkedOut.set(itemIndex, Boolean.FALSE);
         printer.print("Thank you for returning the item");
     }

    @Override
    public String serialize() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items.size(); ++i){
            if (checkedOut.get(i)) continue;

            T item = items.get(i);
            result.append(i+1).append(". ").append(item.serialize()).append("\n");
        }
        return result.toString();
    }

    private void checkIfIsOutOfBounds(int itemNumber) throws InvalidItem {
        if (itemNumber < 1 || itemNumber > this.checkedOut.size()) {
            throw new InvalidItem("Invalid item number");
        }
    }
}
