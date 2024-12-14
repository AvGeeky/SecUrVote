# SecUrVote: A Blockchain-Based E-Voting System

## Overview

SecUrVote is a cutting-edge electronic voting system that leverages blockchain technology and advanced cryptographic techniques to ensure secure, transparent, and tamper-proof online voting. Built with a Java Spring Boot backend, React frontend, and MongoDB database, the system provides a robust platform for conducting various types of elections while maintaining the highest standards of security and voter privacy.
Demo: https://drive.google.com/file/d/1o-OrEEliwhJl7gPpQgYXuzMsC7AlFPWB/view?usp=drive_link

## Key Features

* Blockchain-based vote storage for immutability and transparency
* **Triple** user authentication during login(Secret-ID, EMail and EMail OTP) for enhanced security
* **Triple** authentication of votes during result tallying - (Signature of User on vote (HMAC), User HASH-ID uniqueness across votes, Decryption of an Encrypted Vote using RSA)
* User-friendly React frontend with interactive voting panel and an intuitive UX.
* Backend powered by Spring Boot
* RESTful powered API
* MongoDB integration for efficient data management
* CORS (Cross-Origin Resource Sharing) support for secure cross-origin requests
* Real-time voted status fetched from the blockchain tracking with unique hash IDs that keep users anonymous while taking trust & transparency to a new level
* Easy publishing of results directly to the Email-IDs of the voters

## Architecture

### Database Structure

The system utilizes a three-tier MongoDB database architecture along with a locally stored Blockchain file for vote storage:

1. **Primary Database (Database 1)**
    * Handles user authentication and basic operations (secret codes and user credentials).
    * Methods include:
        * User verification
        * Password management
        * Basic CRUD operations (Create, Read, Update, Delete)

2. **Transaction Database (Database 2)**
    * Manages voting transactions and user details (hash operations and vote status).
    * Key features:
        * Public key management
        * Vote status tracking
        * Hash verification

3. **Election Database (Database 3)**
    * Controls election-specific operations (candidate information).
    * Supports:
        * Election creation and management
        * Candidate registration
        * Result tabulation

4. **Blockchain FIle**
    * Contains the votes in an encrypted format, along with user signature and hash-ids
        * Election results tallying and verification
        * Stored locally on server and deleted once election is over

### Security Layer

The system implements multiple security measures:

1. **Encryption Module**
    * Key pair generation for asymmetric encryption (RSA)
    * Hash-ID generation from public key using admin password and verification (HMAC)
    * String encryption/decryption using public/private keys
    * Secure data transmission

2. **Administrative Control**
    * Centralized election management
    * User detail administration
    * 3FA based login (Secret ID, Email verification against records and OTP verification)
    * 3-Stage Vote verification before tally
    * Live System monitoring and control

3. **Blockchain Integration**
    * Immutable vote records
    * Completely encrypted content, even to the Admin (verification of voter details is completely automated and gets deleted during result tally)

4. **CORS Configuration**
    * Secure cross-origin resource sharing
    * Prevents unauthorized access from different domains



## Tech Stack

### Backend

* Java 17
* Spring Boot 3.2.0
* Spring Security (authentication and authorization)
* MongoDB (database management)
* Apache Maven (dependency management)
* Blockchain Implementation (vote storage)
* JWT (secure token-based authentication)
* CORS configuration (secure cross-origin requests)

### Frontend

* React.js with modern hooks and context
* Tailwind CSS (styling)
* Framer Motion (animations)
* lucide-react (icons with React)
* Axios (API communication)

### Database

* MongoDB (flexible NoSQL document storage)
* Locally (server) stored user private keys and blockchain vote file
## Setup Instructions

### Prerequisites
- Java JDK 17+
- Node.js 14+
- MongoDB 4.4+
- Maven 3.6+
- Git

### Backend Setup

1. *Clone the Repository*
   bash
   git clone https://github.com/AvGeeky/SecUrVote_1.0.git
   cd SecUrVote_1.0


2. *Configure MongoDB*

1. Create three databases as per the architecture
2. Update connection strings in application.properties


3. *Configure CORS*

1. Open src/main/java/com/securvote/config/WebConfig.java
2. Update allowed origins, methods, and headers as needed


4. *Build and Run*

shellscript
cd backend
mvn clean install
mvn spring-boot:run



### Frontend Setup

1. *Install Dependencies*

shellscript
cd [Directory where the project is installed]
npm install




2. *Configure Environment*

1. Create .env file with necessary variables
2. Set API endpoints

3. *Start Development Server*
   Press the localhost:5197 link in Webstrom terminal

shellscript
npm run dev



## API Documentation

### Authentication Endpoints

- POST /api/auth/register
- POST /api/auth/login
- POST /api/auth/verify-secret-code

### Election Management

- POST /api/election/create
- GET /api/election/list
- POST /api/election/vote
- GET /api/election/results

### User Management

- GET /api/user/profile
- PUT /api/user/update-profile-picture
- PUT /api/user/update
- DELETE /api/user/delete

### Voting Panel

- GET /api/voting/panel
- POST /api/voting/submit-vote


## Development Team

**Saipranav M**

- Backend Development
- Encryption and Blockchain Implementation
- Database Management
- API Integration


**Rahul V S**

- Frontend Development
- UI/UX Design
- API Integration

**Pragatheesh**

- Security Implementation
- Testing
- Documentation
- API Integration


## Future Enhancements

1. *Scalability*

1. Distributed database system
2. Load balancing
3. Caching implementation
4. Multi THreading Features


2. *Security*

1. Advanced encryption methods
2. Audit logging


3. *Features*

1. Real-time result visualization
2. Web Application
3. Multiple election types support


## Contributing

1. Fork the repository
2. Create your feature branch (git checkout -b feature/AmazingFeature)
3. Commit your changes (git commit -m 'Add some AmazingFeature')
4. Push to the branch (git push origin feature/AmazingFeature)
5. Open a Pull Request


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contact

For technical queries:

- Email:
    - Saipranav M-sai.saip2005@gmail.com
    - Rahul V S- vsrahul2006@gmail.com
    - Pragatheesh J- jpragatheesh8@gmail.com

- GitHub:
    - Saipranav M - [AvGeeky](https://github.com/AvGeeky)
    - Rahul V S - [techieRahul17](https://github.com/techieRahul17)
    - Pragatheesh - [pragatheesh08](https://github.com/pragatheesh08)

- Project Link: [SecUrVote 1.0](https://github.com/AvGeeky/SecUrVote_1.0)



## Acknowledgements

- Spring Boot Team
- MongoDB Team
- React Development Community
- Open Source Contributors
- Java Team
