public class User {
    private String username;
    private String password;
    private String name;
    private String city;
    private int itemsListed;
    private int tradesCompleted;
    
    public User(String username, String password, String name, String city) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.city = city;
        this.itemsListed = 0;
        this.tradesCompleted = 0;
    }
    
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public int getItemsListed() { return itemsListed; }
    public int getTradesCompleted() { return tradesCompleted; }
    
    public void setItemsListed(int itemsListed) { this.itemsListed = itemsListed; }
    public void setTradesCompleted(int tradesCompleted) { this.tradesCompleted = tradesCompleted; }
    
    @Override
    public String toString() {
        return String.format("👤 %s (%s) - %s | Listed: %d | Trades: %d", 
            name, username, city, itemsListed, tradesCompleted);
    }
}