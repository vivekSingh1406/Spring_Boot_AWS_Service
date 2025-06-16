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

### 1. Clone the Repository
Clone the project to your local machine:
```bash
git clone https://github.com/rihabalyasiri/s3-spring-boot.git
cd s3-spring-boot
```

### 2. Set Up AWS S3
1. **Create an S3 Bucket**:
    - Log in to your [AWS Management Console](https://aws.amazon.com/console/).
    - Navigate to **S3** and create a new bucket.
    - Make sure to note down the **bucket name** and the **region** where the bucket is created.

2. **IAM User & Credentials**:
    - Create an IAM user with `AmazonS3FullAccess` permissions or a custom policy that allows uploading files to S3.
    - Obtain the **AWS Access Key ID** and **AWS Secret Access Key** for the IAM user.

   You can also configure the credentials using the AWS CLI:
   ```bash
   aws configure
   ```

### 3. Configure the Project
You need to provide your AWS credentials and bucket information to the application. You can do this by modifying the `application.properties` file.

#### 3.1 Open `src/main/resources/application.properties` and configure it as follows:

```properties
# AWS S3 Configuration
cloud.aws.credentials.access-key=your-access-key-id
cloud.aws.credentials.secret-key=your-secret-key
```

Replace the values with:
- `your-access-key-id`: Your AWS Access Key.
- `your-secret-key`: Your AWS Secret Key.
- `your-region`: The AWS region where your S3 bucket is located (e.g., `us-east-1`).

### 4. Build the Project

Use Gradle to build the project.

#### Gradle
```bash
./gradlew build
```

### 5. Run the Project

You can now run the project using the following command:

#### Maven
```bash
mvn spring-boot:run
```

#### Gradle
```bash
./gradlew bootRun
```

### 6. Access the Application

Once the application is running, open your browser and navigate to:
```
http://localhost:8080/
```

You should see a file upload interface. Choose a file and click "Upload" to upload the file to your configured S3 bucket.

## Testing the File Upload
1. Open your browser and go to `http://localhost:8080/`.
2. Select a file to upload using the form.
3. After uploading, the file will be stored in your S3 bucket.
4. Check your S3 bucket to verify that the file has been uploaded.

## Project Structure

- `S3Controller.java`: The controller that handles file upload requests.
- `S3Service.java`: The service responsible for interacting with AWS S3.
- `S3Config.java`: Configuration class that sets up the S3 client using AWS credentials.
- `application.properties`: Configuration file to set up AWS credentials and other application settings.



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
