CS542 Design Patterns
Spring 2015
PROJECT <2> README FILE

Due Date: Wednesday, March 9, 2015
Submission Date: Wednesday, March 9, 2015
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Ramesh Kumar Raju Sangaraju>
e-mail(s): <rsangar1@binghamton.edu>


PURPOSE:

[
	This project makes us familiar to the multi threaded programming.
	We are also using the design principles learnt till now.
	Singleton pattern is used.
	
	Single client and multiple client architecture is implemented.
	
	How program works:
	* Server is started
	* Client is started
	* Client send name and query integer
	* Server stores the client information
	* If client ask for response, server responds if entered number is prime or not
	* Server can print current client and its queries
	* Server can print all client names and respective queries
	* A client can exit at any time
	* If server exits, then client exits with error if it tries to access server socket
     
  I have chosen ConcurrentHashMap as the data structure in AllPrimeQueries.java based on the following considerations:
	1. We are dealing with multi threaded architecture.
	2. ConcurrentHashMap is synchronized like Hashtable.
	3. Concurrent Hash Map is better than Hashtable in terms of performance.
	4. Concurrent Hash Map is new implementation of java.
	
  As I am storing multiple values for a signle client, I am storing them in LinkedList data structure.
  Reasons:
	1. In java Linked List is implemented as Doubly Linked List.
	2. Time complexity of inserting and deletion is O(1).
	3. As we are not bothered about so many values, space complexity is also reduced.
	4. One node at a time is created, which gives better performance than ArrayList and Vector.
  
  In Debug class, I have variable called debugLevel. Following values are applicable for debug value.
    0 -- No output is written into the file
	1 -- All the methods that are called, will be written to file
	2 -- All the constructors that are called will be written to file
	3 -- All the methods and constructors related to client that are called will be written to file
	4 -- All the methods and constructors related to server that are called will be written to file
	
  In the client menu, I am taking inputs as a string and response is given as string.
  
  If the entered number is prime, I am responding as 'Yes it is prime'
  If the entered number is not prime, I am responding as 'Not prime'
  If the entered number is less than THRESHOLD, I am responding as 'Not valid'

]

PERCENT COMPLETE:

[
  I believe I have completed 100% of the project
]

PARTS THAT ARE NOT COMPLETE:

[
  I believe there are no incomplete parts in the project.
]

BUGS:

[
  I did not find any bugs as of my knowledge.
]

FILES:

[
  Following are the files neccessary for the project to run:
  
  build.xml
  
  Interfaces:
	ClientDriverInterface.java
	ClientMenuInterface.java
	AllPrimeQueriesInterface.java
	ServerDriverInterface.java
	ServerMenuInterface.java
	PrimeClientSocketInterface.java
	PrimeClientWorkerInterface.java
	PrimeServerSocketInterface.java
	PrimeServerWorkerInterface.java
	CheckPrimeInterface.java
	
  Classes:
	ClientDriver.java 
	ClientMenu.java
	PrimeDriver.java
	AllPrimeQueries.java
	ServerDriver.java
	ServerMenu.java
	PrimeClientSocket.java
	PrimeClientWorker.java
	PrimeServerSocket.java
	PrimeServerWorker.java
	CheckPrime.java
	Debug.java
	
]

SAMPLE OUTPUT:

[
Server output:
----------------

$ ant -buildfile src/build.xml run -Darg0=server -Darg1=56777 -Darg2=1

run:
     [java] ===============Server Menu================
     [java] 
     [java] [1] Client name
     [java] [2] All Client queries
     [java] [3] Quit
2
     [java] ashish 1 7 
     [java] anna 1 4 
     [java] neel 45 
     [java] ===============Server Menu================
     [java] 
     [java] [1] Client name
     [java] [2] All Client queries
     [java] [3] Quit
1
     [java] ashish 7
     [java] ===============Server Menu================
     [java] 
     [java] [1] Client name
     [java] [2] All Client queries
     [java] [3] Quit
1 
     [java] ashish 7
     [java] ===============Server Menu================
     [java] 
     [java] [1] Client name
     [java] [2] All Client queries
     [java] [3] Quit
3
     [java] Problem accepting client connection Socket closed
     [java] Java Result: 1

BUILD SUCCESSFUL
Total time: 4 minutes 7 seconds



Client:
---------
ant -buildfile src/build.xml run -Darg0=client -Darg1=localhost -Darg2=56777 -Darg3=3

run:
     [java] ============Client Menu============
     [java] 
     [java] [1] Set Client name
     [java] [2] Enter number to query for prime
     [java] [3] What is the server response
     [java] [4] Quit
1       
ashish
     [java] ============Client Menu============
     [java] 
     [java] [1] Set Client name
     [java] [2] Enter number to query for prime
     [java] [3] What is the server response
     [java] [4] Quit
2
1
     [java] ============Client Menu============
     [java] 
     [java] [1] Set Client name
     [java] [2] Enter number to query for prime
     [java] [3] What is the server response
     [java] [4] Quit
3
     [java] Not valid
     [java] ============Client Menu============
     [java] 
     [java] [1] Set Client name
     [java] [2] Enter number to query for prime
     [java] [3] What is the server response
     [java] [4] Quit
2 
7
     [java] ============Client Menu============
     [java] 
     [java] [1] Set Client name
     [java] [2] Enter number to query for prime
     [java] [3] What is the server response
     [java] [4] Quit
3
     [java] Yes it is prime
     [java] ============Client Menu============
     [java] 
     [java] [1] Set Client name
     [java] [2] Enter number to query for prime
     [java] [3] What is the server response
     [java] [4] Quit
4
     [java] Java Result: 1

BUILD SUCCESSFUL
Total time: 19 seconds

]

TO COMPILE:

[
  Extract the files and then run following command in primeService directory
  ant -buildfile src/build.xml all
]

TO RUN:

[
  Run below command from directory where this README is present
  For server - 
  ant -buildfile src/build.xml run -Darg0=server -Darg1=<port number> -Darg2=<debug value>

  For client -
  ant -buildfile src/build.xml run -Darg0=client -Darg1=<hostname> -Darg2=<port number>
   -Darg3=<debug value>

  Debug value should be between 0 to 4 :
	0 -- No output is written into the file
	1 -- All the methods that are called, will be written to file
	2 -- All the constructors that are called will be written to file
	3 -- All the methods and constructors related to client that are called will be written to file
	4 -- All the methods and constructors related to server that are called will be written to file

]

EXTRA CREDIT:

[
  As explained by professor, I might get extra points as I am doing with Ant.
]


BIBLIOGRAPHY:

This serves as evidence that I am no way intending Academic Dishonesty.
<Ramesh Kumar Raju Sangaraju>

[
  I have referred to following resources on internet.  

  * http://stackoverflow.com/questions/12646404/concurrenthashmap-and-hashtable-in-java
  
  I have used the code in the following link to make multi threaded client and server
  
  * http://www.oracle.com/technetwork/java/socket-140484.html
  * http://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
]

ACKNOWLEDGEMENT:

[
  Document here your classmates, and/or other people who have helped you.
  DON'T ACKNOWLEDGE YOUR TEAMMATES.
  Here is a sample:

  During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

  Email discussion happened on ListServ CS542 helped me in clearing out the doubts
  regarding the problem statement.

]