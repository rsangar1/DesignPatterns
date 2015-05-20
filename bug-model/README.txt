CS542 Design Patterns
Spring 2015
PROJECT <1> README FILE

Due Date: Tuesday, February 17, 2015
Submission Date: Tuesday, February 17, 2015
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Ramesh Kumar Raju Sangaraju>
e-mail(s): <rsangar1@binghamton.edu>


PURPOSE:

[
  This project is simple introductory java program to implement first design principle
  that 'program to interfaces not to classes'.
  
  Bug movement codes:
	RIGHT - 1
	LEFT - 2
	UP - 3
	DOWN - 4
	UNDO - 0
  
    
  I have chosen ArrayList as the data structure in Results.java based on the following considerations:
	1. A bug could move just a few times or tens of millions of times
	2. In the future it may be required to provide animation for a subset of the moves (10,000th move to 50,000th move).
	3. The movement codes could change from integers to coordinates.
	
  I have used ArrayList as datastructure to store the bug movements. I found ArrayList is
  best data structure for the current scenario as it has better space and time complexity
  when compared with LinkedList, Vector. 
  
  A Vector defaults to doubling the size of its array, while the ArrayList increases its 
  array size by 50 percent. Keeping in mind of the future requirement that 

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
  Display.java
  FileLog.java
  StoreMovements.java
  AllDirectionsBug.java
  
  Classes:
  Bug.java  // this class implements all the movements of bug
  Results.java //this class contains the logic to maintain the movement details of bug
  Driver.java  //this class contains main method
  Debug.java  //this class contains the method to print the debug messages based on given debug level
  Movements.java //this class is generic type for bug movements
]

SAMPLE OUTPUT:

[
//command line arguments are passed through build.xml : 4 LogFile
remote11:~/ramesh/DP/assignment1/bug-model> ant -buildfile src/build.xml run
Buildfile: /import/linux/home/rsangar1/ramesh/DP/assignment1/bug-model/src/build.xml

jar:

run:
     [java] constructor is called: Results class
     [java] constructor is called: Bug class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] constructor is called : Movements class
     [java] Java Result: 1

BUILD SUCCESSFUL
Total time: 1 second

//command line arguments updated in the build.xml file as : 1 LogFile
remote11:~/ramesh/DP/assignment1/bug-model> ant -buildfile src/build.xml run
Buildfile: /import/linux/home/rsangar1/ramesh/DP/assignment1/bug-model/src/build.xml

jar:

run:
     [java] 2412213
     [java] Java Result: 1

BUILD SUCCESSFUL
Total time: 1 second


]

TO COMPILE:

[
Navigate to bug-model folder and run the following command:
ant -buildfile src/build.xml all
]

TO RUN:

[
Navigate to bug-model folder and run the following command:
ant -buildfile src/build.xml run
]

EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

This serves as evidence that I am no way intending Academic Dishonesty.
<Ramesh Kumar Raju Sangaraju>

[
  I have referred to following resources on internet:

  * http://en.wikipedia.org/wiki/Javadoc
  * http://www.oracle.com/technetwork/articles/java/index-137868.html
  * http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
  * http://docs.oracle.com/javase/7/docs/api/java/util/Vector.html
]

ACKNOWLEDGEMENT:

[
  Document here your classmates, and/or other people who have helped you.
  DON'T ACKNOWLEDGE YOUR TEAMMATES.

  During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

  Email discussion happened on ListServ CS542 helped me in clearing out the doubts
  regarding the problem statement.

]