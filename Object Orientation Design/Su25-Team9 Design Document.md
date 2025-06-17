# Class Connect - Software Design 

Version 1  
Prepared by Trey  Lemons & \
Eve Online Marketplace\
June 4th, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: User ](#221-actor-User)
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  Trey L  | 06/04   |Design Doc.      |    1      |
|   Siming   | 06/04        |  Design Doc.                   |      1     |
|  Trey L    |    06/17     |     Updated OOD                |     2      |
|  Siming   |    06/17     |    Updated OOD               |     2      |

## 1. Product Overview
Eve Online Marketplace is a web application based off the game Eve Online. In this marketplace a user will sign up and then sign in to have access to the application. From there a user can either buy or sell orders of items from the game. This platform was made to help private buyers and sellers connect in the Eve Online game and make transactions using the in game currency ISK.

## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/nomekop65/su25-team9/blob/main/Object%20Orientation%20Design/usercasediagram.jpg?raw=true)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: User
##### 2.2.1.1 Sign Up
The user has the ability to Sign Up to access the application and use the buy and sell features.
##### 2.2.1.2 Log In
The user must log in to have access to the app at all. We do this to ensure no fraudulent buy or sell orders are made.
##### 2.2.1.3 Update Profile
The user has the ability to modify their profile, mainly a username or other information.
##### 2.2.1.4 Create Buy Order
The user has the ability to buy orders from the application and receive the items in game via trading in game currency for items.
##### 2.2.1.5 Create Sell Order
The user has the ability to sell orders from the application and receive the asking amount in game via trading the items to the buyer. 
##### 2.2.1.6 Post a Comment
The user has the ability to create a comment of another user on the website.
##### 2.2.1.7 Reply To Comments
The user has the ability to create and post a reply to another user on the website, and reply to their comment.
##### 2.2.1.8 View Orders
The user has the ability to view ALL orders on the entire application.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/nomekop65/su25-team9/blob/main/Object%20Orientation%20Design/UML%20Diagram.jpg?raw=true)
## 4. Database Schema
![Database Schema](https://github.com/nomekop65/su25-team9/blob/main/Object%20Orientation%20Design/UPDATEDSCHEMA2.png?raw=true)
