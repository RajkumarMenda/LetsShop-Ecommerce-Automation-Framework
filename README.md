# 🛒 LetsShop E-commerce Automation Framework

<p align="center">
  <b>🚀 Hybrid Selenium Automation Framework for E-commerce Application</b><br>
  Built with Java, TestNG, Cucumber, Maven & Jenkins
</p>

---

## 🔖 Overview

This project is a **Hybrid Test Automation Framework** designed for an E-commerce application.
It follows industry best practices like **Page Object Model (POM)**, **Data-Driven Testing**, and **CI/CD integration**.

---

## 🚀 Key Features

✔ Hybrid Framework (TestNG + Cucumber BDD)
✔ Page Object Model (POM) Design Pattern
✔ Data-Driven Testing using JSON
✔ Reusable Components & Utilities
✔ Retry Mechanism for Failed Tests
✔ Extent Reports Integration
✔ Jenkins CI/CD Integration
✔ Maven Build Management

---

## 🧰 Tech Stack

| Category        | Tools Used             |
| --------------- | ---------------------- |
| Language        | Java                   |
| Automation      | Selenium WebDriver     |
| Testing         | TestNG, Cucumber (BDD) |
| Build Tool      | Maven                  |
| CI/CD           | Jenkins                |
| Reporting       | Extent Reports         |
| Version Control | Git, GitHub            |

---

## 📂 Project Structure

```
src/main/java
 ┣ pages
 ┣ utils
 ┗ AbstractReusableComponents

src/test/java
 ┣ tests
 ┣ stepDefinitions
 ┣ Cucumber_Wrapper
 ┗ DataJson
```

---

## 🔥 Framework Highlights

### 🔹 Page Object Model

Encapsulates UI elements and actions → improves maintainability and reusability.

### 🔹 Hybrid Framework

Combines **TestNG + Cucumber** → supports both BDD and standard testing.

### 🔹 Data-Driven Testing

Uses **JSON-based test data** → flexible and scalable.

### 🔹 Reusable Components

Includes:

* Base WebDriver setup
* Utility methods (waits, actions)

### 🔹 Reporting

Integrated **Extent Reports** for detailed execution insights.

---

## 🧪 Test Scenarios Covered

* Login Functionality
* Product Selection
* Add to Cart
* Checkout Process
* Order Confirmation
* Error Validation

---

## ⚙️ How to Run the Project

### ▶ Run all tests

```
mvn test
```

### ▶ Run specific TestNG suite

```
mvn test -DsuiteXmlFile=testng.xml
```

---

## 🔗 Jenkins Integration

✔ Automated build execution
✔ CI/CD pipeline support
✔ Scheduled test runs

---

## 📸 Execution Reports

<img width="1910" height="961" alt="image" src="https://github.com/user-attachments/assets/af62cfcd-8972-4c9d-a446-4c35c30e7ace" />


Example:

```
Reports/LoginErrorValdation.png
Reports/ProductErrorValidation.png
Reports/submitOrderEndToEnd.png
```

---

## 👨‍💻 Author

**Rajkumar Menda**
Selenium Automation Tester
Java | Selenium | TestNG | Cucumber | Jenkins

---
