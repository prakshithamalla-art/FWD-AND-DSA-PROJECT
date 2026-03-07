public class Trade {
    private int id;
    private String fromUser;
    private String toUser;
    private String requestedItem;
    private String offeredItem;
    private String status;
    
    public int getId() { return id; }
    public String getFromUser() { return fromUser; }
    public String getToUser() { return toUser; }
    public String getRequestedItem() { return requestedItem; }
    public String getOfferedItem() { return offeredItem; }
    public String getStatus() { return status; }
    
    public void setId(int id) { this.id = id; }
    public void setFromUser(String fromUser) { this.fromUser = fromUser; }
    public void setToUser(String toUser) { this.toUser = toUser; }
    public void setRequestedItem(String requestedItem) { this.requestedItem = requestedItem; }
    public void setOfferedItem(String offeredItem) { this.offeredItem = offeredItem; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s wants %s from %s", 
            status, fromUser, requestedItem, toUser);
    }
}