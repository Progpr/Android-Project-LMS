
# BookSphere - A library Management App

  ![booksphere](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/62b65334-49fa-4c27-ab84-615060cdc1b6)


The Library Management App is a comprehensive Android-based application developed for university use. It caters to both students and administrators, offering streamlined library operations and an enhanced user experience. The key features include distinct interfaces for students and administrators, QR code integration for seamless entry, and efficient management of student data, book information, and entry records through Firebase Realtime Database and Authentication.
## Contents

+ [Development](#Development)
+ [TechStack](#TechStack)
+ [Features](#Features)
+ [Screenshots](#Screenshots)
## Development

In the development of the Library Management App, a carefully chosen set of languages, integrated development environments (IDEs), tools, and technologies played a pivotal role in bringing this 
project to life. This section provides an overview of the various components that were employed in 
the implementation of the application. 

**Programming Language** - The primary programming language utilized for developing the Library Management App is Java. Java, known for its portability, object-oriented nature, and robust libraries, was the ideal choice for creating an Android application. It allowed for efficient code 
development and provided compatibility with the Android operating system.

**Integrated Development Environment (IDE) Android Studio** - An official IDE for Android app development, was the chosen platform for crafting the application. With its comprehensive suite of tools, including a code editor, debugger, and layout designer, Android Studio simplified the development process. Moreover, it offers seamless integration with the Android SDK, making it the preferred IDE for Android app developers.

**Database Technology** - For data storage, we employed Firebase Realtime Database, a cloud-based NoSQL database provided by Google. Firebase Realtime Database is capable of storing structured data in real-time and offers synchronization across multiple clients. This proved to be an optimal choice for managing student information, book details, and entry records. The use of Firebase ensured data consistency and facilitated real-time updates.

**Authentication Mechanism** - Authentication is a critical aspect of the application, especially for 
user and administrator logins. For this purpose, we relied on Firebase Authentication. Firebase Authentication is a secure and easy-to-implement identity verification solution, enabling students 
and administrators to access their respective interfaces securely. It offers a variety of authentication methods, including email and password, phone number, and even third-party providers, ensuring the safety of user credentials.

**QR Code Integration** - The unique QR code integration, a standout feature of the Library Management App, required the use of QR code generation and scanning library, [ZXhing (Zebra Crossing)](https://www.geeksforgeeks.org/how-to-read-qr-code-using-zxing-library-in-android/) These libraries were seamlessly integrated into the app, allowing students to generate 
QR codes for entry and administrators to scan these codes to verify user access. This feature 
enhances convenience by eliminating manual sign-in processes.

**Additional Libraries and Frameworks** - Throughout the development process, additional libraries and frameworks were employed to enhance the functionality and user experience of the app. These include libraries for UI design, user navigation, and data manipulation, ensuring a smooth and visually appealing experience for both students and administrators.


## TechStack

+ [Android Studio Giraffe 2022.3.1 Patch 4 for Windows](https://developer.android.com/studio/): Developed for Android devices.

+ [Firebase Realtime Database](https://console.firebase.google.com/u/0/project/library-management-4c3e8/database/library-management-4c3e8-default-rtdb/data/~2F?fb_utm_source=studio): Secures storage of student data, book information, and entry records.
+ [Firebase Authentication](#https://firebase.google.com/docs/auth/): Ensures secure user and administrator logins.

+ [ZXing (Zebra Crossing) Framework](https://www.geeksforgeeks.org/how-to-read-qr-code-using-zxing-library-in-android/)
## Features
- **User Interfaces:** Separate interfaces for students and administrators.
- **Student Features:** Browse library collections, borrow books, and utilize QR code integration for quick entry.
- **Firebase Integration:** Utilizes Firebase Realtime Database for secure storage and Firebase Authentication for login integrity.

## Screenshots

+ Opening Page:
  
   ![Opening Page](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/45525b34-c174-477b-8616-bc7c60bb7a4a)



+ User Signup Page:
  
  ![user signup page](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/e92e208d-9c76-4c27-b31f-19ed0f929b88)



+ Admin Signup Page:
  
  ![admin sign up page](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/94ae38eb-14d9-42c3-abd0-bcb856a07d59)



+ User Home Page:
  
  ![user home page](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/c7c394c8-03cf-493b-b253-e6446a3cd52c)



+ Admin Home Page:
  
  ![Admin home page](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/e8f47527-5188-44fb-b97d-b82861a6cad2)



+ Signing into the library page (QR Code Scanner):
  
  ![QR code page](https://github.com/Progpr/BookSphere-Library-Management-System/assets/95381092/2d56b9f7-3a96-4cda-87eb-0977ee878030)

