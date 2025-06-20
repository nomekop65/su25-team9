## Title
EVE Online Marketplace

## Team Members
Siming Jia
Trey Lemons

## Description
EVE Online Marketplace (EOM) is a simplified version of what would be a marketplace in the game, adapted to better fit the scope of this course. This marketplace allows customers to list products they want, and providers are able to fulfill those orders. Conversely, providers can also list products for customers to purchase. In cases where a customer and provider list matching orders, the transaction is processed simultaneously in both directions to enhance efficiency. The user also has the ability to create a comment of another user on the app, along with reply to other user's comments.

## How to Run the app
You can run Eve Online Marketplace by cloning this repository to  your VS Code with JDK 21 set as your primary Java. Then Navigate into backend-api/src/main/java and you should see a java class named "BackendApiApplication.java". Run this class in your VS code and everything should work fine and as intended as long as you also set up spring and neon in the application.properties file in /backend-api/src/resources. Then you have a functioning app where you can make transactions for items you want or need to sell in Eve Online!

## App Functions
1. Customer (Buyer)
    1. Create/modify customer profile – Register as a Buyer.
    2. View available services – Browse orders listed by Providers.
    3. List an order you want filled – Create your own order request.
    4. Write reviews – Evaluate providers based on response time, fulfillment accuracy, and communication.
    
2. Provider (Order Filler)
    1. Create/modify/delete provider profile – Register as a Provider.
    2. Create orders – List products or services to be shown to Buyers.
    3. View a list of Orders - Be able to see orders that need filled
    4. Reply to customers – Comment and respond to Buyers who have purchased from you.


