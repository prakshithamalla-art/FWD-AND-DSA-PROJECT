# Your Old Thing Is Someone's New Treasure

## 🚀 Overview
**Your Old Thing Is Someone's New Treasure** is a web-based trading platform that allows users to exchange their unused everyday items with others. No money is involved—just pure value exchange. The platform focuses on sustainability, community building, and reducing waste by giving old items a new life with someone who needs them.

This project demonstrates the implementation of all core web development concepts (HTML, CSS, JavaScript) alongside various data structures and algorithms in Java. It serves as a complete demonstration of both frontend and backend development skills.

---

## ✨ Key Features

### Frontend (FWD)
- **🔐 Multi-Role Authentication:** Separate login portals for Customers and Admins
- **📦 Item Browsing:** Browse all available items with category filtering
- **🔍 Smart Search:** Search items by name, description, or category
- **💰 Price Filtering:** Filter items by price ranges
- **❤️ Wishlist:** Save favorite items for later
- **🤝 Trade Requests:** Send and receive trade proposals
- **📊 User Dashboard:** Personalized dashboard showing user stats
- **🛠️ Admin Panel:** Store management interface for admins
- **🎨 Modern UI/UX:** Clean design with CSS animations, gradients, and responsive layouts
- **📱 Mobile-Ready:** Fully responsive design for all devices

### Backend (DSA)
- **🔑 Hash Table:** O(1) user authentication and session management
- **📋 Linked Lists:** Doubly linked list for item storage and traversal
- **🔄 Circular Linked List:** Recently viewed items with wrap-around
- **📚 Stack:** Search history management (LIFO)
- **📨 Queue:** Trade request processing (FIFO)
- **🎯 Priority Queue:** Urgent trades with higher priority
- **🌲 Binary Search Tree:** Category organization for O(log n) search
- **📊 Binary Heap:** Price-based filtering and sorting
- **⚡ Sorting Algorithms:** Quick Sort, Merge Sort, Bubble Sort for item organization

---

## 🛠️ Technology Stack

| Component | Technology |
|-----------|------------|
| **Frontend** | HTML5, CSS3, JavaScript (ES6) |
| **Backend** | Java (Console Application) |
| **Typography** | System fonts (Segoe UI, -apple-system) |
| **Icons** | Font Awesome 6 |
| **Design System** | Fully custom CSS with CSS variables |
| **Data Structures** | Hash Table, Linked Lists, Stack, Queue, BST, Heap |

---

## 📂 Project Structure

```
your-old-thing-treasure/
│
├── FWD/                             # Frontend Web Development
│   ├── index.html                   # Landing page
│   ├── style.css                    # Main stylesheet
│   ├── script.js                     # Main JavaScript
│   ├── login.html                    # Login page
│   └── login-style.css               # Login page styles
│
└── DSA/                              # Data Structures & Algorithms
    ├── Main.java                      # Entry point
    ├── User.java                       # User class
    ├── Item.java                       # Item class
    ├── Trade.java                      # Trade class
    ├── LinkedList.java                 # Singly Linked List
    ├── DoublyLinkedList.java           # Doubly Linked List
    ├── CircularLinkedList.java         # Circular Linked List
    ├── Stack.java                       # Stack implementation
    ├── Queue.java                       # Queue implementation
    ├── CircularQueue.java               # Circular Queue
    ├── Deque.java                       # Deque implementation
    ├── PriorityQueue.java               # Priority Queue (Heap)
    ├── BinaryHeap.java                   # Binary Heap
    ├── HashTable.java                    # Hash Table with chaining
    ├── BinarySearchTree.java             # Binary Search Tree
    └── SearchingSorting.java             # Search & Sort algorithms
```

---
Frontend Features (FWD)

Authentication System
- Login page with email and password fields
- Demo credentials pre-filled for easy testing
- Session persistence using browser localStorage
- Redirect to profile page after successful login
- Logout functionality to clear session

User Profile Dashboard
- Personal dashboard displaying user information
- Cart section showing items added with remove option
- Wishlist section to view saved favorite items
- Trade history tracking all proposals and status
- Cart total calculation for items added

Item Marketplace
- Grid display with 6 sample items
- Category filter buttons for Kitchen, Tech, Clothing, Books, Tools, Misc
- Search bar for real-time item filtering
- Sort options including Price Low to High, Price High to Low, and Name A-Z
- Item cards showing emoji, title, price, and usage meter
- Seeking tags displaying what items the owner wants
- Details button for more information about each item

Shopping Features
- Add to Wishlist functionality with heart icon
- Add to Cart functionality with shopping cart icon
- Propose Trade option for each item
- Remove items from cart and wishlist
- Checkout process that creates trade records

---

## Backend Features (DSA)

Linked List Implementations
- Singly Linked List in LinkedList.java for trade history storage
- Doubly Linked List in DoublyLinkedList.java for bidirectional item traversal
- Circular Linked List in CircularLinkedList.java for wrap-around recently viewed items

Stack and Queue Implementations
- Stack in Stack.java for LIFO search history management
- Queue in Queue.java for FIFO trade request processing
- Circular Queue in CircularQueue.java for fixed-size recent items buffer
- Deque in Deque.java for double-ended wishlist operations

Heap and Priority Queue Implementations
- Priority Queue in PriorityQueue.java for urgent trades with O(log n) operations
- Binary Heap in BinaryHeap.java for price filtering and min-heap operations

Tree and Hash Table Implementations
- Hash Table in HashTable.java with separate chaining for O(1) user authentication
- Binary Search Tree in BinarySearchTree.java for O(log n) category search

Searching Algorithms
- Linear Search with O(n) time complexity
- Binary Search with O(log n) time complexity for sorted data

Sorting Algorithms
- Bubble Sort with O(n²) time complexity
- Insertion Sort with O(n²) time complexity
- Selection Sort with O(n²) time complexity
- Merge Sort with O(n log n) time complexity
- Quick Sort with O(n log n) average time complexity

---

## Technologies Used

Frontend (FWD)
- HTML5 for page structure
- CSS3 for styling and animations
- JavaScript ES6 for functionality
- LocalStorage for data persistence

Backend (DSA)
- Java JDK for programming
- VS Code as development environment
- No external libraries - pure Java implementations

---

## How to Run

Frontend (FWD)
1. Go to the fwd folder
2. Open index.html in any browser (Chrome, Firefox, Edge)
3. Use the login page to access profile

Backend (DSA)
1. Go to the dsa folder in terminal
2. Compile all files: javac *.java
3. Run the program: java Main
4. Follow menu options to test data structures

---

## Login Credentials

User Account 1
- Email: praks@demo.com
- Password: praks123

User Account 2
- Email: bomm@demo.com
- Password: bomm123

---

## CO-Wise Implementation

FWD (Frontend Web Development)

CO1: Internet Fundamentals, HTML & CSS
- HTML5 document structure with semantic tags
- CSS styling with responsive design
- Flexbox and Grid layouts
- CSS variables for theming

CO2: Forms, Semantic Tags & Advanced CSS
- Login forms with input fields
- CSS animations and hover effects
- Media queries for mobile responsiveness
- Glass morphism design

CO3: JavaScript Programming Essentials
- Arrays and objects for data storage
- Functions and arrow functions
- Array methods (map, filter, forEach)
- Conditional logic and loops

CO4: JavaScript Interactivity, DOM & Events
- Event handling for button clicks
- DOM manipulation for dynamic content
- LocalStorage for data persistence
- JSON parsing and stringifying

CO5: Advanced Web Development & Deployment
- Form validation for user inputs
- GitHub repository management
- Static site deployment ready


## 📊 CO-Wise Implementation

### CO1: Internet Fundamentals, HTML & Introductory CSS
- Complete HTML5 document structure with semantic tags
- CSS variables for consistent theming
- Flexbox and Grid layouts for responsive design
- Typography hierarchy and color schemes
- Padding, margin, and border properties

### CO2: HTML Forms, Semantic Tags & Comprehensive CSS Layouts
- Login and signup forms with validation
- CSS animations and transitions
- Media queries for mobile responsiveness
- CSS custom properties for theme management

### CO3: JavaScript Programming Essentials
- Arrays and objects for data storage
- Arrow functions and callback functions
- Array methods (map, filter, forEach)
- Conditional logic and loops

### CO4: JavaScript Interactivity, DOM & Async
- Dynamic DOM manipulation
- Event handling for user interactions
- Modal popups for item details
- LocalStorage for user preferences

### CO5: Advanced Web Development & Deployment
- SEO meta tags implementation
- Form validation with JavaScript
- GitHub repository management
- Static site deployment ready

### DSA Implementations
- **Hash Table:** User authentication (O(1) average lookup)
- **Doubly Linked List:** Item storage (O(n) traversal, O(1) insert)
- **Stack:** Search history (O(1) push/pop)
- **Queue:** Trade requests (O(1) enqueue/dequeue)
- **Priority Queue:** Urgent trades (O(log n) operations)
- **Binary Search Tree:** Category search (O(log n) average)
- **Binary Heap:** Price filtering (O(log n) extract)
- **Quick/Merge Sort:** Item sorting (O(n log n))

---

## 🚀 How to Run

### Frontend (Website):
1. Navigate to the `FWD` folder
2. Open `index.html` in any modern browser (Chrome, Firefox, Edge)
3. Use demo credentials:
   - **Customer:** `user@demo.com` / `demo123`
   - **Admin:** `admin@store.com` / `admin123`

### Backend (DSA Console App):
1. Navigate to the `DSA` folder
2. Compile all Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java Main
   ```
4. Follow the menu options to test each data structure

---

## 🔮 Future Scope

### Short-term Enhancements
- **User Authentication:** Real backend with JWT tokens
- **Image Upload:** Allow users to upload item photos
- **Real-time Chat:** Direct messaging between traders
- **Rating System:** User reviews and trust scores

### Medium-term Features
- **Mobile App:** React Native or Flutter implementation
- **AI Recommendations:** Smart item matching algorithm
- **Location-based:** Find traders in your area
- **Push Notifications:** Real-time trade alerts

### Long-term Vision
- **Global Network:** Cross-city trading platform
- **Blockchain:** Item provenance and history
- **Corporate Partnerships:** Business surplus trading
- **Circular Economy Metrics:** Track environmental impact

---

## 👨‍💻 Author

**Solo Project**

- **Name:** [Prakshitha Malla]
- **Roll Number:** [2520030342]
- **Course:** FWD AND DSA
- **Trimester:** II, Academic Year 2025-26

---

## 📅 Date

March 2026

---

## 📜 Conclusion

This project successfully demonstrates the implementation of all core web development concepts along with various data structures and algorithms. The platform effectively solves the real-world problem of unused household items by connecting people who want to trade, promoting sustainability and community engagement.

The project showcases:
- ✅ Complete frontend development with HTML, CSS, and JavaScript
- ✅ All 5 COs of the Web Development course
- ✅ 10+ data structure implementations in Java
- ✅ Multiple sorting and searching algorithms
- ✅ Clean, responsive, and professional UI/UX design

---

## 📄 License

This project is open-source and available for educational purposes.

---

**🌟 Your Old Thing Is Someone's New Treasure**  
*Where every item has a story, and every story deserves a second chapter.*

