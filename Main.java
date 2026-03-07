import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static User currentUser = null;
    
    // Data Structures
    private static HashTable<String, User> users;
    private static DoublyLinkedList<Item> allItems;
    private static LinkedList<Trade> tradeHistory;
    private static Stack<String> searchHistory;
    private static Queue<Trade> tradeRequests;
    private static CircularQueue<Item> recentlyViewed;
    private static Deque<Item> wishlist;
    private static BinarySearchTree<String> categories;
    
    public static void main(String[] args) {
        initializeData();
        showMainMenu();
    }
    
    private static void initializeData() {
        System.out.println("\n==================================================");
        System.out.println("  YOUR OLD THING IS SOMEONE'S NEW TREASURE");
        System.out.println("         DSA Implementation - Backend");
        System.out.println("==================================================\n");
        
        users = new HashTable<>(50);
        allItems = new DoublyLinkedList<>();
        tradeHistory = new LinkedList<>();
        searchHistory = new Stack<>(20);
        tradeRequests = new Queue<>(20);
        recentlyViewed = new CircularQueue<>(10);
        wishlist = new Deque<>();
        categories = new BinarySearchTree<>();
        
        // Add sample users
        users.put("user1", new User("user1", "pass123", "Priya Sharma", "Hyderabad"));
        users.put("user2", new User("user2", "pass123", "Anita Desai", "Secunderabad"));
        users.put("user3", new User("user3", "pass123", "Rajesh Kumar", "Hyderabad"));
        users.put("admin", new User("admin", "admin123", "Store Admin", "Hyderabad"));
        
        // Add sample items
        allItems.append(new Item(1, "French Press Coffee Maker", "kitchen", 1200, 
            "Stainless steel, 32oz capacity, used for 2 years", "user1", "Good"));
        allItems.append(new Item(2, "Wireless Earbuds", "electronics", 1500, 
            "Good condition, 5hr battery life, with charging case", "user1", "Good"));
        allItems.append(new Item(3, "Unused Yoga Mat", "sports", 500, 
            "Brand new, non-slip, 6mm thickness, includes strap", "user2", "Mint"));
        allItems.append(new Item(4, "Desk Lamp with USB", "electronics", 800, 
            "Adjustable arm, warm/cool light settings, 3 USB ports", "user2", "Good"));
        allItems.append(new Item(5, "Cast Iron Skillet", "kitchen", 900, 
            "Well-seasoned, 10-inch, perfect for cooking", "user3", "Good"));
        allItems.append(new Item(6, "Graphic Novel Collection", "books", 1200, 
            "12 volumes, various series, like new condition", "user3", "Like New"));
        allItems.append(new Item(7, "Denim Jacket", "clothing", 1500, 
            "Size M, dark wash, lightly worn", "user1", "Good"));
        allItems.append(new Item(8, "Basic Tool Set", "tools", 2000, 
            "Hammer, screwdrivers, pliers, tape measure", "user2", "Good"));
        
        // Add categories
        String[] cats = {"kitchen", "electronics", "clothing", "books", "tools", "sports"};
        for (String cat : cats) {
            categories.insert(cat);
        }
        
        System.out.println("✅ Data Structures Initialized");
        System.out.println("   • Hash Table: " + users.size() + " users");
        System.out.println("   • Doubly Linked List: " + allItems.size() + " items");
        System.out.println("   • Binary Search Tree: " + categories.size() + " categories\n");
    }
    
    private static void showMainMenu() {
        while (true) {
            System.out.println("\n═══════════════════════════════════════════");
            System.out.println("              MAIN MENU");
            System.out.println("═══════════════════════════════════════════");
            System.out.println("1. 👤 Customer Login");
            System.out.println("2. 👑 Admin Login");
            System.out.println("3. 📝 New User Registration");
            System.out.println("4. 📊 Browse All Items (Linked List)");
            System.out.println("5. 🔍 Search Items");
            System.out.println("6. 🏷️ Filter by Category (BST)");
            System.out.println("7. ❤️ Wishlist (Deque)");
            System.out.println("8. 🕒 Recently Viewed (Circular Queue)");
            System.out.println("9. 📋 DSA Overview");
            System.out.println("0. ❌ Exit");
            System.out.println("═══════════════════════════════════════════");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1: customerLogin(); break;
                case 2: adminLogin(); break;
                case 3: registerUser(); break;
                case 4: browseAllItems(); break;
                case 5: searchItems(); break;
                case 6: filterByCategory(); break;
                case 7: viewWishlist(); break;
                case 8: viewRecentlyViewed(); break;
                case 9: showDSAOverview(); break;
                case 0: 
                    System.out.println("\n👋 Thank you for using the system!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
    
    private static void customerLogin() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("              CUSTOMER LOGIN");
        System.out.println("═══════════════════════════════════════════");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        long startTime = System.nanoTime();
        User user = users.get(username);
        long endTime = System.nanoTime();
        
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("\n✅ Login successful! Welcome, " + user.getName() + "!");
            System.out.println("   [Hash Table Lookup: O(1) average - " + (endTime - startTime) + " ns]");
            showUserMenu();
        } else {
            System.out.println("\n❌ Invalid username or password!");
        }
    }
    
    private static void adminLogin() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("               ADMIN LOGIN");
        System.out.println("═══════════════════════════════════════════");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password) && username.equals("admin")) {
            currentUser = user;
            System.out.println("\n✅ Admin login successful!");
            showAdminMenu();
        } else {
            System.out.println("\n❌ Invalid admin credentials!");
        }
    }
    
    private static void registerUser() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("         NEW USER REGISTRATION");
        System.out.println("═══════════════════════════════════════════");
        System.out.print("Username: ");
        String username = sc.nextLine();
        
        if (users.get(username) != null) {
            System.out.println("❌ Username already exists!");
            return;
        }
        
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Full Name: ");
        String name = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        
        User newUser = new User(username, password, name, city);
        users.put(username, newUser);
        
        System.out.println("\n✅ Registration successful! [Hash Table Insert: O(1)]");
    }
    
    private static void showUserMenu() {
        while (true) {
            System.out.println("\n═══════════════════════════════════════════");
            System.out.println("     USER DASHBOARD - " + currentUser.getName());
            System.out.println("═══════════════════════════════════════════");
            System.out.println("1. 📦 Browse All Items");
            System.out.println("2. 🔍 Search Items");
            System.out.println("3. 🏷️ Filter by Category");
            System.out.println("4. ➕ Add New Item");
            System.out.println("5. 📋 View My Listings");
            System.out.println("6. 🤝 View Trade Requests");
            System.out.println("7. ❤️ Wishlist (" + wishlist.size() + " items)");
            System.out.println("8. 🕒 Recently Viewed (" + recentlyViewed.size() + ")");
            System.out.println("9. 🚪 Logout");
            System.out.println("═══════════════════════════════════════════");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1: browseAllItems(); break;
                case 2: searchItems(); break;
                case 3: filterByCategory(); break;
                case 4: addNewItem(); break;
                case 5: viewMyListings(); break;
                case 6: viewTradeRequests(); break;
                case 7: viewWishlist(); break;
                case 8: viewRecentlyViewed(); break;
                case 9: 
                    System.out.println("👋 Logged out!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
    
    private static void showAdminMenu() {
        while (true) {
            System.out.println("\n═══════════════════════════════════════════");
            System.out.println("            ADMIN DASHBOARD");
            System.out.println("═══════════════════════════════════════════");
            System.out.println("1. 📦 View All Items (" + allItems.size() + ")");
            System.out.println("2. 👥 View All Users (" + users.size() + ")");
            System.out.println("3. ➕ Add New Item");
            System.out.println("4. 🗑️ Remove Item");
            System.out.println("5. 🤝 View All Trade Requests");
            System.out.println("6. 📊 DSA Overview");
            System.out.println("7. 🚪 Logout");
            System.out.println("═══════════════════════════════════════════");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1: browseAllItems(); break;
                case 2: viewAllUsers(); break;
                case 3: addNewItem(); break;
                case 4: removeItem(); break;
                case 5: viewAllTradeRequests(); break;
                case 6: showDSAOverview(); break;
                case 7: return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
    
    private static void browseAllItems() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           ALL AVAILABLE ITEMS");
        System.out.println("═══════════════════════════════════════════");
        
        long startTime = System.nanoTime();
        
        if (allItems.isEmpty()) {
            System.out.println("📭 No items available.");
            return;
        }
        
        // FIXED: Convert Object[] to Item[]
        Object[] objArray = allItems.toArray();
        Item[] items = new Item[objArray.length];
        for (int i = 0; i < objArray.length; i++) {
            items[i] = (Item) objArray[i];
        }
        
        for (int i = 0; i < items.length; i++) {
            System.out.println((i+1) + ". " + items[i].getTitle() + 
                " [" + items[i].getCategory() + "] - ₹" + items[i].getPrice() + 
                " (" + items[i].getCondition() + ")");
            System.out.println("   " + items[i].getDescription());
            System.out.println("   Owner: " + items[i].getOwnerId());
            System.out.println();
        }
        
        long endTime = System.nanoTime();
        System.out.println("   [Doubly Linked List Traversal: O(n) - " + (endTime - startTime) + " ns]");
        
        System.out.print("\nEnter item number to view details (0 to go back): ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        if (choice > 0 && choice <= items.length) {
            viewItemDetails(items[choice-1]);
        }
    }
    
    private static void viewItemDetails(Item item) {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           ITEM DETAILS");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("📌 Title: " + item.getTitle());
        System.out.println("🏷️ Category: " + item.getCategory());
        System.out.println("💰 Price: ₹" + item.getPrice());
        System.out.println("📝 Description: " + item.getDescription());
        System.out.println("👤 Owner: " + item.getOwnerId());
        System.out.println("⭐ Condition: " + item.getCondition());
        System.out.println("═══════════════════════════════════════════");
        
        // Add to recently viewed
        recentlyViewed.enqueue(item);
        
        if (currentUser != null) {
            System.out.println("\nOptions:");
            System.out.println("1. ❤️ Add to Wishlist");
            System.out.println("2. 🤝 Request Trade");
            System.out.println("3. ↩️ Back");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    wishlist.addFront(item);
                    System.out.println("✅ Added to wishlist! [Deque addFront - O(1)]");
                    break;
                case 2:
                    requestTrade(item);
                    break;
            }
        }
    }
    
    private static void requestTrade(Item item) {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           REQUEST TRADE");
        System.out.println("═══════════════════════════════════════════");
        System.out.print("Enter item you want to offer: ");
        String offer = sc.nextLine();
        
        Trade trade = new Trade();
        trade.setId(tradeHistory.size() + 1);
        trade.setFromUser(currentUser.getUsername());
        trade.setToUser(item.getOwnerId());
        trade.setRequestedItem(item.getTitle());
        trade.setOfferedItem(offer);
        trade.setStatus("PENDING");
        
        long startTime = System.nanoTime();
        tradeRequests.enqueue(trade);
        long endTime = System.nanoTime();
        
        tradeHistory.append(trade);
        
        System.out.println("\n✅ Trade request sent!");
        System.out.println("   [Queue enqueue: O(1) - " + (endTime - startTime) + " ns]");
    }
    
    private static void searchItems() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           SEARCH ITEMS");
        System.out.println("═══════════════════════════════════════════");
        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine().toLowerCase();
        
        searchHistory.push(keyword);
        System.out.println("   [Stack push: O(1)]");
        
        long startTime = System.nanoTime();
        Object[] objArray = allItems.toArray();
        Item[] items = new Item[objArray.length];
        for (int i = 0; i < objArray.length; i++) {
            items[i] = (Item) objArray[i];
        }
        int count = 0;
        
        System.out.println("\n🔍 Search Results:");
        for (Item item : items) {
            if (item.getTitle().toLowerCase().contains(keyword) ||
                item.getDescription().toLowerCase().contains(keyword)) {
                count++;
                System.out.println(count + ". " + item.getTitle() + " - ₹" + item.getPrice());
            }
        }
        
        long endTime = System.nanoTime();
        
        if (count == 0) {
            System.out.println("No items found.");
        }
        
        System.out.println("\n   [Linear Search: O(n) - " + (endTime - startTime) + " ns]");
        System.out.println("   Search History: " + searchHistory.size() + " searches");
    }
    
    private static void filterByCategory() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           FILTER BY CATEGORY");
        System.out.println("═══════════════════════════════════════════");
        
        System.out.println("Available Categories:");
        categories.inOrderTraversal();
        
        System.out.print("\nEnter category: ");
        String category = sc.nextLine();
        
        long startTime = System.nanoTime();
        boolean categoryExists = categories.search(category);
        long endTime = System.nanoTime();
        
        System.out.println("   [BST Search: O(log n) - " + (endTime - startTime) + " ns]");
        
        if (!categoryExists) {
            System.out.println("❌ Category not found!");
            return;
        }
        
        startTime = System.nanoTime();
        Object[] objArray = allItems.toArray();
        Item[] items = new Item[objArray.length];
        for (int i = 0; i < objArray.length; i++) {
            items[i] = (Item) objArray[i];
        }
        int count = 0;
        
        System.out.println("\n📦 Items in " + category + ":");
        for (Item item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                count++;
                System.out.println(count + ". " + item.getTitle() + " - ₹" + item.getPrice());
            }
        }
        
        endTime = System.nanoTime();
        System.out.println("\n   [Linear Filter: O(n) - " + (endTime - startTime) + " ns]");
    }
    
    private static void addNewItem() {
        if (currentUser == null) {
            System.out.println("❌ Please login first!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           ADD NEW ITEM");
        System.out.println("═══════════════════════════════════════════");
        
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        System.out.print("Price (₹): ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("Description: ");
        String description = sc.nextLine();
        System.out.print("Condition (Mint/Good/Fair): ");
        String condition = sc.nextLine();
        
        Item newItem = new Item(
            allItems.size() + 1,
            title, category, price, description,
            currentUser.getUsername(), condition
        );
        
        long startTime = System.nanoTime();
        allItems.append(newItem);
        long endTime = System.nanoTime();
        
        System.out.println("\n✅ Item listed successfully!");
        System.out.println("   [Doubly Linked List append: O(1) - " + (endTime - startTime) + " ns]");
    }
    
    private static void viewMyListings() {
        if (currentUser == null) {
            System.out.println("❌ Please login first!");
            return;
        }
        
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           MY LISTINGS");
        System.out.println("═══════════════════════════════════════════");
        
        Object[] objArray = allItems.toArray();
        Item[] items = new Item[objArray.length];
        for (int i = 0; i < objArray.length; i++) {
            items[i] = (Item) objArray[i];
        }
        int count = 0;
        
        for (Item item : items) {
            if (item.getOwnerId().equals(currentUser.getUsername())) {
                count++;
                System.out.println(count + ". " + item.getTitle() + " - ₹" + item.getPrice());
            }
        }
        
        if (count == 0) {
            System.out.println("📭 You haven't listed any items yet.");
        }
    }
    
    private static void viewTradeRequests() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           TRADE REQUESTS");
        System.out.println("═══════════════════════════════════════════");
        
        long startTime = System.nanoTime();
        Trade next = tradeRequests.peek();
        long endTime = System.nanoTime();
        
        System.out.println("📥 Pending Requests: " + tradeRequests.size());
        System.out.println("   [Queue peek: O(1) - " + (endTime - startTime) + " ns]");
        
        if (next != null) {
            System.out.println("\n⏳ Next in queue:");
            System.out.println("   From: " + next.getFromUser());
            System.out.println("   Want: " + next.getRequestedItem());
            System.out.println("   Offering: " + next.getOfferedItem());
            
            System.out.println("\nOptions:");
            System.out.println("1. ✅ Accept");
            System.out.println("2. ❌ Decline");
            System.out.println("3. ↩️ Back");
            System.out.print("Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                Trade accepted = tradeRequests.dequeue();
                accepted.setStatus("ACCEPTED");
                System.out.println("✅ Trade accepted! [Queue dequeue - O(1)]");
            } else if (choice == 2) {
                Trade declined = tradeRequests.dequeue();
                declined.setStatus("DECLINED");
                System.out.println("❌ Trade declined!");
            }
        }
    }
    
    private static void viewAllTradeRequests() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("        ALL TRADE REQUESTS");
        System.out.println("═══════════════════════════════════════════");
        
        Trade[] trades = tradeHistory.toArray();
        for (int i = 0; i < trades.length; i++) {
            System.out.println((i+1) + ". " + trades[i].getFromUser() + 
                " wants " + trades[i].getRequestedItem() + 
                " from " + trades[i].getToUser() + 
                " [" + trades[i].getStatus() + "]");
        }
    }
    
    private static void viewWishlist() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           WISHLIST");
        System.out.println("═══════════════════════════════════════════");
        
        if (wishlist.isEmpty()) {
            System.out.println("❤️ Your wishlist is empty.");
            return;
        }
        
        System.out.println("Front (most recent): " + wishlist.getFront().getTitle());
        System.out.println("Rear (oldest): " + wishlist.getRear().getTitle());
        
        System.out.println("\nAll items:");
        int count = 1;
        for (Item item : wishlist) {
            System.out.println(count++ + ". " + item.getTitle() + " - ₹" + item.getPrice());
        }
        
        System.out.println("\nOptions:");
        System.out.println("1. ❤️ Remove from wishlist");
        System.out.println("2. ↩️ Back");
        System.out.print("Choice: ");
        
        int choice = sc.nextInt();
        sc.nextLine();
        
        if (choice == 1 && !wishlist.isEmpty()) {
            Item removed = wishlist.removeFront();
            System.out.println("✅ Removed: " + removed.getTitle() + " [Deque removeFront - O(1)]");
        }
    }
    
    private static void viewRecentlyViewed() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           RECENTLY VIEWED");
        System.out.println("═══════════════════════════════════════════");
        
        recentlyViewed.display();
        if (!recentlyViewed.isEmpty()) {
            System.out.println("Front: " + recentlyViewed.getFront().getTitle());
            System.out.println("Rear: " + recentlyViewed.getRear().getTitle());
        }
    }
    
    private static void viewAllUsers() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("           ALL USERS");
        System.out.println("═══════════════════════════════════════════");
        
        users.display();
    }
    
    private static void removeItem() {
        browseAllItems();
        System.out.print("\nEnter item ID to remove: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        long startTime = System.nanoTime();
        Object[] objArray = allItems.toArray();
        Item[] items = new Item[objArray.length];
        for (int i = 0; i < objArray.length; i++) {
            items[i] = (Item) objArray[i];
        }
        boolean removed = false;
        
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                allItems.remove(i);
                removed = true;
                break;
            }
        }
        
        long endTime = System.nanoTime();
        
        if (removed) {
            System.out.println("✅ Item removed!");
            System.out.println("   [Doubly Linked List removal: O(n) - " + (endTime - startTime) + " ns]");
        } else {
            System.out.println("❌ Item not found!");
        }
    }
    
    private static void showDSAOverview() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("     DATA STRUCTURES & ALGORITHMS");
        System.out.println("═══════════════════════════════════════════");
        
        System.out.println("\n📌 LINKED LISTS:");
        System.out.println("   • Singly Linked List: Trade History (append: O(1), search: O(n))");
        System.out.println("   • Doubly Linked List: Items Catalog (" + allItems.size() + " items)");
        System.out.println("   • Circular Linked List: (implemented but not used)");
        
        System.out.println("\n📌 STACKS & QUEUES:");
        System.out.println("   • Stack: Search History (" + searchHistory.size() + " searches) - O(1) push/pop");
        System.out.println("   • Queue: Trade Requests (" + tradeRequests.size() + " pending) - O(1) enqueue/dequeue");
        System.out.println("   • Circular Queue: Recently Viewed (" + recentlyViewed.size() + " items)");
        System.out.println("   • Deque: Wishlist (" + wishlist.size() + " items) - O(1) both ends");
        
        System.out.println("\n📌 TREES & HASHING:");
        System.out.println("   • Hash Table: Users (" + users.size() + " users) - O(1) average lookup");
        System.out.println("   • Binary Search Tree: Categories (" + categories.size() + ") - O(log n) search");
        
        System.out.println("\n📌 SEARCHING & SORTING:");
        System.out.println("   • Linear Search: O(n) - Used in search feature");
        System.out.println("   • Binary Search: O(log n) - Requires sorted data");
        System.out.println("   • Bubble/Insertion/Selection Sort: O(n²)");
        System.out.println("   • Merge/Quick Sort: O(n log n)");
        
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }
}
