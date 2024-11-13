This project is a Spring Web MVC application developed as an exercise to practice building a web application using the MVC (Model-View-Controller) design pattern. The application simulates a scenario where the fictional business seeks to sell smartphones online.
Features:
  - Order Form Page: An HTML page (index.html) designed with Thymeleaf, featuring an "Online Smart Phone Order Request" form. This page allows users to select phone brands (e.g., iPhone, Samsung, Google, BlackBerry) and models, input personal information, and submit their order. The design includes basic HTML input validations and user-friendly controls to ensure a smooth experience.

  - JavaScript for Dynamic Form Interaction: The application uses JavaScript to dynamically update the phone model options based on the selected brand. Additionally, it populates the product number and ensures real-time interaction for a more user-friendly experience.

  - Model Class: The Order.java bean class handles the data structure for user input from the order form, including fields for customer details, phone brand, model, price, and quantity.

  - Controller Class: The OrderController.java processes form submissions, handles POST requests, and passes the data to be displayed on the order confirmation view (show-order.html).

  - Order Summary Page: The show-order.html page displays the order summary, including customer details, phone information, and the total price of the order based on the quantity.

  - Maven Integration: The project is managed using Maven (pom.xml), ensuring proper dependency management and build automation.

Key Technologies:
  - Spring Framework (Spring Web MVC)
  - Thymeleaf for dynamic HTML rendering
  - JavaScript for dynamic form handling and real-time updates
  - Java for backend logic
  - CSS for styling and formatting


**Disclaimer**

This project is intended solely as an educational exercise to practice building a web application using the MVC design pattern with the Spring Framework. Please note that this application is not a fully functional e-commerce platform and does not process actual transactions or store data persistently. It serves as a demonstration of form handling, data binding, and dynamic form interactions using Spring MVC, Thymeleaf, and JavaScript.
