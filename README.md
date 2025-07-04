# 🛒 Fawry Full Stack Internship Challenge

This project is my solution to the **Fawry Rise Journey - Full Stack Development Internship Challenge**. It simulates a simple e-commerce system with core functionalities such as managing products, handling carts, processing checkout, and calculating shipping.

---

## ✅ Features

- **Product Management**
  - Products can be expirable (e.g., cheese, biscuits)
  - Products can be shippable (e.g., TV, cheese)
  - Supports combinations (e.g., shippable & expirable)

- **Customer & Cart**
  - Customers have a balance
  - Can add products to a cart (with stock and expiry checks)
  - View cart contents and subtotal

- **Checkout Process**
  - Validates cart, stock, expiry, and balance
  - Reduces product quantities after successful checkout
  - Calculates shipping for shippable products
  - Prints detailed receipt and shipping summary

---

## 📦 Classes Overview

| Package       | Class                     | Description                                      |
|---------------|---------------------------|--------------------------------------------------|
| `model`       | `Product`, `ShippableProduct`, `ExpirableProduct`, `ShippableExpirableProduct`, `Shippable` | Product types and shipping interface             |
| `cart`        | `Cart`, `CartItem`        | Handles adding/viewing items and subtotal        |
| `Users`       | `Customer`                | Stores customer info and balance logic           |
| `service`     | `CheckoutService`         | Coordinates validation, deduction, shipping, receipt |
| `service`     | `ShippingService`         | Calculates and prints shipping notice            |
| *(root)*      | `Main`                    | Demo use case with test products                 |

---

## 🚀 How to Run

1. Clone the repo
2. Open in any Java IDE (e.g., IntelliJ, NetBeans)
3. Make sure you're using **Java 17 or later**
4. Run `Main.java` to simulate a sample checkout process

---

## 📋 Sample Output

** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
1x TV 10000g
Total package weight: 11.10 kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x TV 300
1x Mobile Scratch Card 50
Subtotal 700.0
Shipping 45.0
Amount 745.0
💰 Current balance: 255.0

---

## 🧠 Notes

- ❌ No exceptions were used — error handling is done through console messages.
- ✅ Validations include:
  - Expired products
  - Insufficient stock
  - Empty cart
  - Insufficient customer balance
- 📦 Shipping cost is flat-rate per shippable item type (e.g., Cheese + TV = 2 item types = 30 shipping).

---

## 🧪 Test Cases Covered

- Empty cart
- Expired product
- Insufficient stock
- Insufficient customer balance
- Non-shippable items
- Shippable + Expirable combo products

---

## 👨‍💻 Author

**[Your Full Name]**  
GitHub: [@yourusername](https://github.com/yourusername)

---

## 📝 License

This project is submitted as part of the Fawry Internship Challenge. Feel free to use it for learning purposes.
