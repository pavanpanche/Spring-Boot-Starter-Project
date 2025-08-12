# 🚀 Spring Boot Starter Project

A Spring Boot starter boilerplate that includes **JWT Authentication**, **Spring Security**, **Role-Based Access Control**, **Spring Data JPA**, and a fully configured **environment-based setup** — ready to use out of the box.

- This repository is created for my personal practice and to save time on authentication setup and configuration. It is open for anyone to explore and learn from.  
- To use it, simply clone the repository, connect it to your own Git repository, and start adding new features.

📂 **Public repository** — [Spring Boot Starter Project](https://github.com/pavanpanche/Spring-Boot-Starter-Project)

 ## What's Already Configured?
- ✅ JWT Authentication
- ✅ Spring Security
- ✅ Role Based Access Controlled (User, Admin)
- ✅ Spring Data JPA
- ✅ Environment-based configuration (application-dev.yml, application-prod.yml)
- ✅ Database setup (H2/MySQL/PostgreSQL-ready) 
- ✅ Secret keys and token configuration (easily customizable)

 **Note : Just Changes Your own Api Key And Db Credential and token session time according to your requirments.**


## 🧱 Technologies Used
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Maven 
- MySQL 
- Lombok
- Environment Configs
- swagger for API documentation

## 💡 Ideal For
- Starting new backend projects quickly
- Teams who want a common base project
- Avoiding repetitive auth and config setup


## 🔐 Authentication
### User Registration:
### Users can create an account using:

- Email

- Username

- Password

### Example Request:
```json
  
POST /api/auth/register
{
  "email": "user@example.com",
  "username": "pavank",
  "password": "StrongP@ssw0rd"
}

```

### Example Response 
```
"Registraion Successfully"
```

---

### User Login:
- Users can log in using either:

- Username + Password, or

- Email + Password

### Example Requests:
```json

POST /api/auth/login
// Using Email
{
  "identifier": "user@example.com",
  "password": "StrongP@ssw0rd"
}

// Using Username
{
  "identifier": "pavank",
  "password": "StrongP@ssw0rd"
}

```

### Login Response:
- On successful authentication, returns a JWT token and basic user details.
```json
  {
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "username": "pavank",
  "roles": "user"   //admin or user 
}

```

---

## 🔮 Future Implementations

Planned features for upcoming versions:

- **Advanced Role-Based Access Control**  
  Roles such as:
  - `User`
  - `Admin`
  - `Moderator`
  - `Super Admin`

- **Multiple Login Options**  
  Login using:
  - Email  
  - Username  
  - Mobile Number  

- **Refresh Token Support**  
  Secure token renewal without requiring full re-login.

---

  ## 📬 Contact

- **Email:** [pavanpanche2@gmail.com](mailto:pavanpanche2@gmail.com)  
- **LinkedIn:** [pavanpanche](https://www.linkedin.com/in/pavanpanche)



---

