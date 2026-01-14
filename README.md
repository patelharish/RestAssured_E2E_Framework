# 🚀 Hybrid Automation Framework

A hybrid automation testing framework built using Java to perform end-to-end CRUD operations with API chaining and UI automation.  
The framework uses REST Assured for API testing and Selenium WebDriver for UI testing with TestNG.

---

## 🛠 Tech Stack

- Java  
- Selenium WebDriver  
- REST Assured  
- TestNG  
- Jackson Library (Serialization & Deserialization)  
- Maven  
- GitHub Actions (CI/CD)

---

## ✨ Features

- End-to-End CRUD operations (POST, GET, PUT, DELETE)
- API chaining with dynamic response handling
- Hybrid framework (API + UI automation)
- POJO classes for request and response mapping
- Serialization and deserialization using Jackson
- Priority-based test execution using TestNG
- Automated execution using GitHub Actions

---

## 🧪 Test Coverage

**API Testing**
- Create resource using POST
- Retrieve resource using GET
- Update resource using PUT
- Delete resource using DELETE
- Response validation and assertions

**UI Testing**
- Selenium-based UI validations
- UI verification using API test data

---

## 🔄 API Execution Flow

POST → GET → PUT → DELETE

---

## 🔁 CI/CD with GitHub Actions

- Triggered on every push and pull request
- Executes Maven build and TestNG tests
- Validates end-to-end API automation
- Displays pipeline status and logs in GitHub Actions

---

## ⭐ Support

If you find this project useful, please give the repository a star ⭐

