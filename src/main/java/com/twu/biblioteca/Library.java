package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItem;
import com.twu.biblioteca.exceptions.SessionException;

import java.util.List;
import java.util.stream.Collectors;

public class Library<T extends Printable> implements Printable {
    Printer printer;

    private List<Node> nodes;

    private class Node implements Printable {
        private T item;
        boolean checkedOut;
        User user;

        public Node(T item) {
            this.item = item;
            this.checkedOut = false;
            this.user = null;
        }

        public boolean isCheckedOut() {
            return checkedOut;
        }

        public void checkoutNode (User user) {
            this.checkedOut = true;
            this.user = user;
        }

        public void returnNode () {
            this.checkedOut = false;
            this.user = null;
        }

        public String getUserHash () {
            return user.getHash();
        }

        @Override
        public String serialize() {
            if (user == null) return item.serialize();
            return item.serialize() + " - " + user.serialize();
        }
    }

    public Library(Printer printer, List<T> items) {
        this.printer = printer;

        this.nodes = items.stream().map(Node::new).collect(Collectors.toList());
    }

     public void checkoutItem (int printIndex, User user) throws InvalidItem, SessionException {
         if(user == null) throw new SessionException(Constants.ERROR_NOT_LOGGED_IN);
         if(isOutOfBounds(printIndex)) throw new InvalidItem(Constants.ERROR_INVALID_OPTION);

         int itemIndex = printIndex-1;

         Node node = nodes.get(itemIndex);
         if (node.isCheckedOut()) {
             printer.print(Constants.ERROR_ITEM_NOT_AVAILABLE);
             return;
         }

         node.checkoutNode(user);
         printer.print(Constants.SUCCESS_CHECKOUT_MESSAGE);
     }

     public void returnItem (int printIndex, User user) throws InvalidItem, SessionException {
         if(user == null) throw new SessionException(Constants.ERROR_NOT_LOGGED_IN);
         if(isOutOfBounds(printIndex)) throw new InvalidItem(Constants.ERROR_INVALID_OPTION);

         int itemIndex = printIndex-1;

         Node node = nodes.get(itemIndex);
         if (!node.isCheckedOut()) throw new InvalidItem(Constants.ERROR_RETURN_MESSAGE);
         if (!node.getUserHash().equals(user.getHash())) throw new SessionException(Constants.ERROR_INVALID_USER);

         node.returnNode();
         printer.print(Constants.SUCCESS_RETURN_MESSAGE);
     }

    @Override
    public String serialize() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nodes.size(); ++i) {
            Node node = nodes.get(i);

            if (node.isCheckedOut()) continue;

            int printIndex = i+1;
            result.append(printIndex).append(". ").append(node.serialize()).append("\n");
        }

        return result.toString();
    }

    public String getCheckedOutItems() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < nodes.size(); ++i) {
            Node node = nodes.get(i);

            if (!node.isCheckedOut()) continue;

            int printIndex = i+1;
            result.append(printIndex).append(". ").append(node.serialize()).append("\n");
        }

        return result.toString();
    }

    private boolean isOutOfBounds(int printIndex) {
        return (printIndex < 1 || printIndex > this.nodes.size());
    }
}
