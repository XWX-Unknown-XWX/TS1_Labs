package hw05_eshop.storage;

public class NoItemInStorage extends Exception{
    public NoItemInStorage() {
        super("No item in storage");
    }
}
