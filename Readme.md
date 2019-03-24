# Observer Pattern Dojo

### Description
We have a Stock Exchange market that is represented by class StockExchange.
This StockExchange class have information about many share prices and stock market indices.
You shouldn't be worried about how this class gets information - this is delivered by third party. 
Your job in this kata is to implement three classes that represent displaying data from stock market 
in three different channels: **Tv Strip**, **Smartphone App**, **Website with chart**. This channels
have to react to changes in Stock Exchange and display fetched information in different ways. Also,
any other channel that will appear has to have possibility to get data from Stock Market without any 
changes to existing channels or Stock Market class.   
 

### Requirements
 * Maven (we will use JUnit 4 and Mockito)
 * JDK 8+ 


### How To start
This branch is just a starting point. To go to first step - checkout branch `observer-step1` and 
follow instructions in updated Readme.


### Step1
Run tests found in Tests.java. Tests will fail. 
Your job is to make tests pass. You cannot change implementation of tests, but you have to change
implementation of existing classes. In this step implement correct interfaces in classes
* StockExchange
* SmartphoneApp
* TvStrip
* WebsiteChart

### Step2
Tests are failing again. You have to use your knowledge about **observer pattern**
to implement required behaviour. Class StockExchange has now a collection that can keep information about all 
channels that are subscribed to receive its state changes. Your job is to implement methods that will 
allow subscribers to add themselves to this subscribers list as well as add possibility to get him out of it.

### Step 3
Now, your experience with Observer pattern is robust. 
Some third party now uses setters in StockExchange class to set new exchange rates. Your job is to notify all clients
of StockExchange that the state of this class is changed and the views should be updated. Do it by modifying only 
Subject class. Now you don't care about subscribers (as StockEchange does not care about who reads its data).  