<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Security JWT Authentication</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            color: #333;
            line-height: 1.6;
            padding: 20px;
        }
        h1, h2, h3 {
            color: #0d6efd;
        }
        code {
            background: #eee;
            padding: 3px 6px;
            border-radius: 4px;
        }
        pre {
            background: #212529;
            color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            overflow-x: auto;
        }
        .box {
            background: #ffffff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.05);
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <h1>🔐 Spring Security JWT Authentication</h1>
    <p><b>Author:</b> Abhishek Khanai</p>
    <p><b>Technology:</b> Spring Boot, Spring Security, JWT, REST API</p>

    <div class="box">
        <h2>📌 Project Description</h2>
        <p>
            This project demonstrates how to implement <b>JWT (JSON Web Token) based authentication</b> 
            using <b>Spring Boot and Spring Security</b>. It provides secure login and registration APIs 
            and protects endpoints using JWT tokens.
        </p>
    </div>

    <div class="box">
        <h2>⚙️ Technologies Used</h2>
        <ul>
            <li>Java</li>
            <li>Spring Boot</li>
            <li>Spring Security</li>
            <li>JWT (JSON Web Token)</li>
            <li>RESTful APIs</li>
            <li>Maven</li>
        </ul>
    </div>

    <div class="box">
        <h2>📁 Project Structure</h2>
        <pre>
src/main/java
 └── com.example.jwt
     ├── controller
     ├── service
     ├── repository
     ├── config
     ├── model
     └── security
        </pre>
    </div>

    <div class="box">
        <h2>🔑 Features</h2>
        <ul>
            <li>User Registration</li>
            <li>User Login with JWT Token</li>
            <li>Role-based Authorization</li>
            <li>Secure REST APIs</li>
            <li>Password Encryption (BCrypt)</li>
        </ul>
    </div>

    <div class="box">
        <h2>🚀 How to Run the Project</h2>
        <ol>
            <li>Clone the repository</li>
            <li>Open project in Eclipse / IntelliJ</li>
            <li>Make sure JDK and Maven are configured</li>
            <li>Run the application as <b>Spring Boot App</b></li>
        </ol>
    </div>

    <div class="box">
        <h2>📡 API Endpoints</h2>
        <pre>
POST   /api/auth/register   -> Register new user
POST   /api/auth/login      -> Login and get JWT token
GET    /api/user/profile    -> Protected endpoint
        </pre>
    </div>

    <div class="box">
        <h2>🧪 Sample Login Request</h2>
        <pre>
POST /api/auth/login
Content-Type: application/json

{
  "username": "abhishek",
  "password": "password123"
}
        </pre>
    </div>

    <div class="box">
        <h2>🔒 Authorization Header</h2>
        <pre>
Authorization: Bearer your_jwt_token_here
        </pre>
    </div>

    <div class="box">
        <h2>📌 Notes</h2>
        <ul>
            <li>Token expiration is configurable</li>
            <li>Use Postman for API testing</li>
            <li>Do not share JWT secret key publicly</li>
        </ul>
    </div>

    <div class="box">
        <h2>📞 Contact</h2>
        <p>
            <b>Name:</b> Abhishek Khanai <br>
            <b>Email:</b> abhishekkhanai264@gmail.com <br>
            <b>GitHub:</b> <a href="https://github.com/Abhishekkhanai07" target="_blank">Abhishekkhanai07</a>
        </p>
    </div>

    <p>⭐ If you like this project, give it a star on GitHub!</p>

</body>
</html>
