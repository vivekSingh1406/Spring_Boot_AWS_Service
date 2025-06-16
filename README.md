# Spring Boot AWS S3 File Upload Project

This project demonstrates how to upload files directly to Amazon S3 using a Spring Boot application. The application allows users to upload files through a web interface, and those files are then stored in an S3 bucket.

## Features
- Upload files directly to AWS S3 from a web interface.
- Spring Boot integration with AWS SDK.
- No need to store files locally; files are streamed directly to S3.

## Prerequisites
- Java 17 (or higher)
- AWS S3 Account with appropriate permissions
- Gradle

## Project Setup

### 1. Set Up AWS S3
1. **Create an S3 Bucket**:
    - Log in to your [AWS Management Console](https://aws.amazon.com/console/).
    - Navigate to **S3** and create a new bucket.
    - Make sure to note down the **bucket name** and the **region** where the bucket is created.

2. **IAM User & Credentials**:
    - Create an IAM user with `AmazonS3FullAccess` permissions or a custom policy that allows uploading files to S3.
    - Obtain the **AWS Access Key ID** and **AWS Secret Access Key** for the IAM user.

### 2. Configure the Project
You need to provide your AWS credentials and bucket information to the application. You can do this by modifying the `application.properties` file.

#### 2.1 Open `src/main/resources/application.properties` and configure it as follows:

```properties
# AWS S3 Configuration
cloud.aws.credentials.access-key=your-access-key-id
cloud.aws.credentials.secret-key=your-secret-key
```

Replace the values with:
- `your-access-key-id`: Your AWS Access Key.
- `your-secret-key`: Your AWS Secret Key.
- `your-region`: The AWS region where your S3 bucket is located (e.g., `us-east-1`).

### 3. Run the Project

#### Maven
```bash
mvn spring-boot:run
```

#### Gradle
```bash
./gradlew bootRun
```



--------------------------------------------------------------------

# JWT Authentication with MySql

This project implements a signup and login flow using JWT (JSON Web Tokens) for authentication. It connects to a mysql database to manage user roles and user data.

## Requirements

To run this project, you will need to set up a MongoDB cluster and configure the application. Follow the steps below:

1. **Create a database in mysql
   - connect your application with database connection

2. **Insert Initial Documents into the `roles` Collection:**
   - Insert the data into the `roles` 
     ```
     {"name":"ROLE_USER"}
     {"name":"ROLE_ADMIN"}
     {"name":"ROLE_MODERATOR"}
     ```

## Running the Project

To run this project, use the following commands in your terminal or command prompt:
```bash
mvn install
mvn spring-boot:run
