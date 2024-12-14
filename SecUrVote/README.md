# SecUrVote Backend

## Overview
This is the backend code for the SecUrVote system, located in:
```
SecUrVote\login\src\main\java\com\securvote
```

## Prerequisites
Before running the project, ensure you have the following:

1. **MongoDB Database**
   - Create a MongoDB database with a specific format.
   - For details about the required database schema, contact:
     **sai.saip2005@gmail.com**

2. **Gmail Address for Mail Services**
   - Create a Gmail account.
   - Generate an app password for the account.

3. **Environment File (`apiee.env`)**
   - Create a file named `apiee.env` in the project directory.
   - Add the following keys to the file:
     ```plaintext
     MAIL_ID=your_gmail_address
     MAIL_PASSKEY=your_app_password
     API_KEY=your_api_key (if applicable)
     ```

## Setup and Run
1. Clone the repository.
2. Navigate to the backend directory:
   ```bash
   cd SecUrVote/login/src/main/java/com/securvote
   ```
3. Install the required dependencies.
4. Add the `.env` file to the project directory with the correct values.
5. Run the application using your preferred IDE or build tool.

## Contact
For any questions or assistance with setting up the MongoDB database, feel free to reach out:
- **Email**: sai.saip2005@gmail.com

## Note
Ensure your `.env` file is never committed to the repository to protect sensitive information.
