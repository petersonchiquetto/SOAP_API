# SOAP_API

> This project demonstrates how to integrate with SOAP-based web services. It includes practical examples of making requests, handling authentication, and processing responses. The goal is to provide a solid foundation for working with SOAP APIs in various scenarios, while implementing basic CRUD operations.

---

## 🚀 What is SOAP?

**SOAP (Simple Object Access Protocol)** is a protocol used for exchanging structured information in the implementation of web services. It relies on XML messages to define its request and response formats, ensuring that systems, often from different platforms, can communicate over the internet.

### Key Features of SOAP:
- **Protocol-Based**: SOAP defines a strict messaging structure based on XML.
- **Platform-Independent**: SOAP can work on top of protocols such as HTTP, SMTP, and more, making it suitable for a variety of use cases.
- **Standardized**: SOAP is highly standardized, with well-defined rules for request and response formatting.
- **Built-in Security**: It supports WS-Security standards for message encryption and authentication.

This project focuses on using SOAP for integrating with an API and demonstrating the implementation of CRUD operations.

---

## 📌 CRUD Operations

In this project, we will perform **CRUD** (Create, Read, Update, Delete) operations on a SOAP-based API. Below is a description of each operation and its SOAP request format:

1. **Create** - Sends a request to create a new resource (e.g., adding a new user or entry to the database).
2. **Read** - Retrieves information from the server (e.g., fetching user details).
3. **Update** - Modifies an existing resource on the server (e.g., updating user information).
4. **Delete** - Removes a resource from the server (e.g., deleting a user or entry).

Each operation will be executed by sending appropriate SOAP requests to the server and processing the response.

---

## 🚀 Getting Started

To get started with this project, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/petersonchiquetto/SOAP_API.git
   cd SOAP_API
   ```

2. **Install necessary Python packages**:

   This project requires `requests` and `xml` modules. Install them using pip if they are not already installed:

   ```bash
   pip install requests
   ```

3. **Setup your SOAP API endpoint and authentication**:

   Edit the `api_integration.py` file to include your SOAP API endpoint and any required authentication details.

---

## 🧑‍💻 Usage

### SOAP CRUD Operations Example

Below is an example of how to implement each CRUD operation using SOAP requests.

#### 1. **Create Operation** (Adding a New User)

```python
import requests

# URL of the SOAP API endpoint
url = "https://example.com/soap-endpoint"

# Define the SOAP request body for creating a new user
headers = {'Content-Type': 'text/xml; charset=utf-8'}
body = '''<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <web:AddUser>
         <web:userName>JohnDoe</web:userName>
         <web:userEmail>johndoe@example.com</web:userEmail>
      </web:AddUser>
   </soapenv:Body>
</soapenv:Envelope>'''

# Make the SOAP request
response = requests.post(url, data=body, headers=headers)

# Output the response
print(response.text)
```

#### 2. **Read Operation** (Fetching User Information)

```python
body = '''<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <web:GetUserInfo>
         <web:userID>12345</web:userID>
      </web:GetUserInfo>
   </soapenv:Body>
</soapenv:Envelope>'''

response = requests.post(url, data=body, headers=headers)
print(response.text)
```

#### 3. **Update Operation** (Updating User Information)

```python
body = '''<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <web:UpdateUser>
         <web:userID>12345</web:userID>
         <web:newEmail>john.doe_updated@example.com</web:newEmail>
      </web:UpdateUser>
   </soapenv:Body>
</soapenv:Envelope>'''

response = requests.post(url, data=body, headers=headers)
print(response.text)
```

#### 4. **Delete Operation** (Removing a User)

```python
body = '''<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <web:DeleteUser>
         <web:userID>12345</web:userID>
      </web:DeleteUser>
   </soapenv:Body>
</soapenv:Envelope>'''

response = requests.post(url, data=body, headers=headers)
print(response.text)
```

---

## 🎨 Example of SOAP Response

A sample response for a **Read** operation (fetching user details) might look like this:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.example.com/webservice">
   <soapenv:Header/>
   <soapenv:Body>
      <web:GetUserInfoResponse>
         <web:userName>JohnDoe</web:userName>
         <web:userEmail>johndoe@example.com</web:userEmail>
      </web:GetUserInfoResponse>
   </soapenv:Body>
</soapenv:Envelope>
```

---

## 📚 Learning Objectives

By working with this project, you will learn to:

- Understand SOAP requests and responses.
- Implement basic CRUD operations (Create, Read, Update, Delete) with SOAP APIs.
- Interact with SOAP-based web services.
- Handle authentication and manage headers for secure communication.
- Parse and process SOAP responses to integrate into your applications.

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](https://github.com/petersonchiquetto/SOAP_API/blob/main/LICENSE) file for more details.

---

## 💬 Contributing

Feel free to contribute to this project by opening issues or submitting pull requests. Contributions are always welcome!

---
