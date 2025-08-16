# UI Test Automation Framework

A robust and scalable **UI Test Automation Framework** built using **Selenium**, **Java**, and **TestNG**, designed to provide maintainable, reusable, and efficient automated test execution for web applications.

---

## 📌 Features
- ✅ **Selenium WebDriver** for browser automation
- ✅ **Java** as the core programming language
- ✅ **TestNG** for test orchestration and reporting
- ✅ **Page Object Model (POM)** for better code maintainability
- ✅ **Data-Driven Testing** using Excel/CSV
- ✅ **Maven** for build and dependency management
- ✅ **Logging** using Log4j (or SLF4J)
- ✅ **Reporting** using Extent Reports / Allure Reports
- ✅ **Cross-browser Testing** support (Chrome, Firefox, Edge)
- ✅ **Continuous Integration Ready** (Jenkins/GitHub Actions)

---

## 📂 Project Structure
UI-Automation-Framework
```
│
├── src/
│ ├── main/java/
│ │ ├── base/ # Base classes (WebDriver setup, hooks)
│ │ ├── pages/ # Page Object Model classes
│ │ ├── utils/ # Utilities (Excel reader, Config reader)
│ │ ├── config/ # Configuration files (properties)
│ │
│ ├── test/java/
│ ├── tests/ # Test classes
│
├── testng.xml # TestNG suite configuration
├── pom.xml # Maven dependencies
├── README.md # Project documentation
└── reports/ # Test reports (Extent / Allure)
```

## ⚙️ Prerequisites
- **Java JDK** (11 or higher)
- **Maven** (latest version)
- **IDE** (IntelliJ IDEA / Eclipse)
- **Browsers** (Chrome, Firefox, Edge)
- **Driver binaries** (or WebDriverManager for auto download)

---

▶️ How to Run Tests
Run all tests via Maven:
mvn clean test

Run a specific suite using TestNG XML:
mvn clean test -DsuiteXmlFile=testng.xml

Run tests on a specific browser:
mvn clean test -Dbrowser=chrome


🧪 Test Reports
Extent Report: reports/ExtentReport.html

Allure Report: Generate with:
allure serve reports/

✅ CI/CD Integration
This framework can be integrated with:

Jenkins
GitHub Actions
Azure DevOps
GitLab CI

📖 Best Practices Followed
Page Object Model (POM)
Reusable utility classes
Parameterization for test flexibility
Separation of concerns (tests, pages, configs)
Parallel execution support

🛠️ Technologies Used
Selenium WebDriver
Java
TestNG
Maven
Log4j / SLF4J

Extent Reports / Allure Reports

