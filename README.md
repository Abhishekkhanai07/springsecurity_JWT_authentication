<h1>🔐 Spring Security JWT Authentication</h1>

<p>
A secure <b>Spring Boot based JWT Authentication System</b> developed using 
<b>Spring Security</b>.  
This project demonstrates user authentication, authorization and secure REST APIs 
using JSON Web Tokens (JWT).
</p>

<h2>📄 Project Overview</h2>

<p>
A complete authentication and authorization system with:
</p>

<ul>
    <li>JWT based stateless authentication</li>
    <li>Spring Security configuration</li>
    <li>Role based access control</li>
    <li>Secure REST APIs</li>
    <li>Password encryption using BCrypt</li>
</ul>

<hr>

<h2>📌 Project Objectives</h2>

<ul>
    <li>Implement secure login and registration</li>
    <li>Protect APIs using JWT tokens</li>
    <li>Handle authentication & authorization properly</li>
    <li>Follow clean layered architecture</li>
    <li>Ensure secure password storage</li>
</ul>

<hr>

<h2>🛠️ Tools & Technologies</h2>

<ul>
    <li><b>Language:</b> Java</li>
    <li><b>Framework:</b> Spring Boot</li>
    <li><b>Security:</b> Spring Security</li>
    <li><b>Authentication:</b> JWT (JSON Web Token)</li>
    <li><b>Database:</b> MySQL / H2</li>
    <li><b>Build Tool:</b> Maven</li>
    <li><b>IDE:</b> Eclipse</li>
</ul>

<hr>

<h2>📂 Project Structure</h2>

<pre>
springsecurity_JWT_authentication/
│── src/
│   └── main/
│       └── java/
│           └── org/jcode/spring_security/
│               ├── controller/        # REST Controllers
│               ├── entity/            # JPA Entities
│               ├── repo/              # Repository Interfaces
│               ├── security/          # JWT & Security Config
│               ├── service/           # Business Logic
│               ├── JWTUtil.java        # JWT Utility Class
│               └── SpringSecurityApplication.java  # Main Class
└── README.html
</pre>

<hr>

<h2>⚙️ Methodology</h2>

<ol>
<li><b>User Authentication</b></li>
<ul>
    <li>Login API validates credentials</li>
    <li>JWT token generated on success</li>
    <li>Token returned to client</li>
</ul>

<li><b>JWT Validation</b></li>
<ul>
    <li>Custom filter intercepts requests</li>
    <li>Validates token before processing</li>
    <li>Sets authentication in context</li>
</ul>

<li><b>Spring Security Configuration</b></li>
<ul>
    <li>CSRF disabled for APIs</li>
    <li>Session management set to stateless</li>
    <li>Endpoints secured using roles</li>
</ul>

<li><b>Password Encryption</b></li>
<ul>
    <li>Passwords encrypted using BCrypt</li>
    <li>Prevents storing plain text passwords</li>
</ul>
</ol>

<hr>

<h2>🚀 How to Run</h2>

<ol>

<li><b>Clone the Repository</b></li>
<ul>
    <li>git clone https://github.com/Abhishekkhanai07/springsecurity_JWT_authentication.git</li>
</ul>

<li><b>Open in Eclipse</b></li>
<ul>
    <li>File → Import → Existing Maven Project</li>
</ul>

<li><b>Configure Database</b></li>
<ul>
    <li>Update application.properties</li>
</ul>

<li><b>Run Application</b></li>
<ul>
    <li>Run as Spring Boot App</li>
</ul>

</ol>

<hr>

<h2>📡 API Endpoints</h2>

<pre>
POST   /api/auth/register   -> Register new user
POST   /api/auth/login      -> Login and get JWT token
GET    /api/user/profile    -> Protected endpoint
</pre>

<hr>

<h2>🔑 Sample Login Request</h2>

<pre>
POST /api/auth/login
Content-Type: application/json

{
  "username": "abhishek",
  "password": "password123"
}
</pre>

<hr>

<h2>🔒 Authorization Header</h2>

<pre>
Authorization: Bearer your_jwt_token_here
</pre>

<hr>

<h2>🙋‍♂️ Author</h2>

<p>
<b>Abhishek Khanai</b><br>
Java Full Stack Developer<br>
GitHub: 
<a href="https://github.com/Abhishekkhanai07">Abhishekkhanai07</a>
</p>

