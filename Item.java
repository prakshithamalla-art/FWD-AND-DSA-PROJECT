public class Item {
    private int id;
    private String title;
    private String category;
    private int price;
    private String description;
    private String ownerId;
    private String condition;
    
    public Item(int id, String title, String category, int price, 
                String description, String ownerId, String condition) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.description = description;
        this.ownerId = ownerId;
        this.condition = condition;
    }
    
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public int getPrice() { return price; }
    public String getDescription() { return description; }
    public String getOwnerId() { return ownerId; }
    public String getCondition() { return condition; }
    
    @Override
    public String toString() {
        return String.format("%s [%s] - ₹%d (%s)", title, category, price, condition);
    }
}