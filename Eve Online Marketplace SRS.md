# Software Requirements Specification
## For EVE Online Marketplace

Version 0.1  
Prepared by Siming Jia and Trey Lemons  
CSC340  
May 27, 2025 

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)


## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|Siming| 5/25    | Initial SRS         |    1.0    |
| Trey     |   5/25      |      Initial SRS               |    1.0       |
|  Siming    |   6/17      |         Completed Project            |     2.0      |
|  Trey    |   6/17      |         Completed Project            |     2.0      |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Document (SRD) is to describe the client-view and developer-view requirements for the Class Connect application.  
Client-oriented requirements describe the system from the client’s perspective.  These requirements include a description of the different types of users served by the system.  
Developer-oriented requirements describe the system from a software developer’s perspective.  These requirements include a detailed description of functional, data, performance, and other important requirements.

### 1.2 Product Scope
The product specified in this Software Requirements Specification (SRS) document is the EVE Online Marketplace, Revision 1.0. This software component is designed to support the in-game economic activities of the EVE Online universe by providing a robust, user-friendly, and efficient digital marketplace for players to buy, sell, and manage virtual assets. The marketplace enables players to trade ships, modules, blueprints, resources, and other in-game items in real-time, with features such as price tracking, order management, historical data analysis, and customizable search filters. This SRS focuses on the backend and user interface functionalities of the marketplace subsystem rather than the entire game platform. The primary objective of the EVE Online Marketplace is to enhance the player-driven economy, increase engagement, and provide a seamless trading experience. This aligns with the corporate goal of maintaining EVE Online as a dynamic, immersive sandbox experience that fosters complex interactions and long-term player investment.

### 1.3 Definitions, Acronyms and Abbreviations
| Reference  | Definition                                                                                                                                                                         |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java       | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build Class Connect.                                           |
| Postgresql | Open-source relational database management system.                                                                                                                                 |
| SpringBoot | An open-source Java-based framework used to create a micro Service. This will be used to create and run our application.                                                           |
| Spring MVC | Model-View-Controller. This is the architectural pattern that will be used to implement our system.                                                                                |
| Spring Web | Will be used to build our web application by using Spring MVC. This is one of the dependencies of our system.                                                                      |
| API        | Application Programming Interface. This will be used to interface the backend and the fronted of our application.                                                                  |
| HTML       | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                         |
| CSS        | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                                  |
| JavaScript | An object-oriented computer programming language commonly used to create interactive effects within web browsers.Will be used in conjuction with HTML and CSS to make the web app. |
| VS Code    | An integrated development environment (IDE) for Java. This is where our system will be created.|     
|EVE online| A large MMORPG set in the distance past space.|
|            |                                                                                                                                                                                    |

### 1.4 References
https://spring.io/guides\
https://www.eveonline.com/

### 1.5 Document Overview
Section 1 is a general introduction to the document, intended for any readers. Section 2 is focused on the product and its features. This section is for customers and business stakeholders. Section 3 specifies the requirements and constraints for the product and development process. This section is intended for all stakeholders, especially the development team.

## 2. Product Overview
The EVE Online Marketplace operates within the larger context of the EVE Online game universe, where a complex, player-driven economy plays a central role. Its requirements are influenced by in-game mechanics, user behavior, and the need for real-time performance and data accuracy. 

### 2.1 Product Functions
The EVE Online Marketplace will support several key functions that enable players to engage in a dynamic, player-driven economy. Users will be able to authenticate using their EVE Online credentials and access marketplace features based on their account status. The system will allow players to create, edit, and cancel buy and sell orders for a wide range of in-game items, including ships, modules, and resources. Players can search for and browse items using filters such as item type, price range, and location. The marketplace will handle secure transaction processing, ensuring proper item delivery and updating player wallets accordingly. It will also provide real-time and historical market data, allowing users to view pricing trends, analyze activity, and make informed trading decisions.

### 2.2 Product Constraints
At this point, the program will only run on a computer with Java jdk 21 installed. The full scope of the project is hopefully realized, however the team has a deadline of a few weeks, which could lead to feature cuts. The program would have a challenge scaling, as the current plan is to use a free version of a Postgresql database to store the information.

### 2.3 User Characteristics
Our website application does not expect our users to have any prior knowledge of a computer, apart from using a web browser. As long as users know what classes they are interested in, they should be epxert level within several uses of the application.

### 2.4 Assumptions and Dependencies
We will be using Java, with our program being dependent on Spring & SpringBoot, and RestAPI to connect to external APIs and developed with VS Code. The application will also use the World Time API (http://worldtimeapi.org/) that will help filter classes within the timezone of the user.

## 3. Requirements

### 3.1 Functional Requirements 
- FR0: The system shall authenticate users using their existing EVE Online credentials.
Each session shall be securely authorized with user role-based access (e.g., regular player, admin, moderator).

- FR1: The system shall allow users to create new buy and sell orders by specifying item type, quantity, price, and duration.
Each order shall be uniquely identified and stored in the regional market database.

- FR2: The system shall allow users to browse and search marketplace listings using filters such as item name, price range, and category.
Search results shall be sortable by relevance, price, and date listed.

- FR3: The system shall process transactions automatically when a buy order matches a sell order.
Both item delivery and currency transfers shall be completed securely and logged.

- FR4: Users shall be able to view real-time and historical market data, including price charts and trade volumes for specific items.
Graphs shall be filterable by date range and region.

- FR5: The system shall allow users to cancel or modify active orders before they are fulfilled.
Changes shall be reflected immediately across all relevant interfaces.

- FR6: Users shall be able to access their personal trade history, including completed transactions, active orders, and cancelled listings.
#### 3.1.1 User interfaces
Web pages using HTML, CSS, and JavaScript.

#### 3.1.2 Hardware interfaces
Devices that have web browser capabilities.

#### 3.1.3 Software interfaces
- Java jdk 21
- PostgreSQL 17
- SpringBoot 3.4.5

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
- NFR0: The EVE Online Marketplace system will consume less than 100 MB of memory
- NFR1: The novice user will be able to place buy and sell order in less than 5 minutes.
- NFR2: The expert user will be able to place buy and sell order in less than 1 minute.

#### 3.2.2 Security
- NFR3: The system is going to be available only to authorized users, using their username and password.

#### 3.2.3 Reliability

#### 3.2.4 Availability
- NFR4: Class Connect will be available 24/7. Scheduled Maintenance should be initialized during scheduled low activity hours to minimize conflict with user’s using the app.

#### 3.2.5 Compliance

#### 3.2.6 Cost
- NFR5: We expect to spend zero dollars on this project. 

#### 3.2.7 Deadline
- NFR6: The final product must be delivered on June 18th.
