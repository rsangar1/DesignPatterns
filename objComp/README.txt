CS542 Design Patterns
Spring 2015
PROJECT <5> README FILE

Due Date: Monday, May 4, 2015
Submission Date: Monday, May 4, 2015
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Ramesh Kumar Raju Sangaraju>
e-mail(s): <rsangar1@binghamton.edu>


PURPOSE:
[
	This project is to understand and implement java reflection on two java bean classes
	according to the given input file. The input file contains 3 lines related to each class.
	First line tell the fully qualified name of the class and the next two lines contains the
	type, method name and value so that the value can be set to particular method by invoking 
	that method on the instance of class.
	
	Objective of this project is to implement reflection and create new objects and calculate
	total number of objects and number of unique objects.
	
	Reflection is implemented
	Singleton pattern is used.
	Program to an interface not to an implementation //design principle
	Favour composition over inheritance //design principle
	
	How program works:
	* Read one line at a time from file
	* If it contains fully qualified name, extract class, number of variables in class and 
	  get instance of that class.
	* If it don't contain string "fqn", get method based on type, method name and signature
	  and invoke it.
	* Once entire file is read, the total number of First instances, total number of unique 
	  First objects, total number of Second objects, total number of unique Second objects
	  along with performance measured in milliseconds is printed on standard output (console)
		
    I have chosen HashMap to store the type and class related to particular type.
	I have chosen HashMaps to store the First and Second objects with their number of occurrences
	as key value pairs.
	
	Justification:
	- Required key value pair data structure to store objects and to count number of occurrences
	- HashMap to store key value pairs and for faster access
	- Easy to iterate and calculate the count of objects and unique objects.
  	- Thread safety is not required in this assignment, so HashTable is not required
  	
  In MyLogger class, I have variable called loggerLevel. Following values are applicable for logger level.
    0 -- No output is written into the file
	1 -- All the constructors that are called will be written to file
	2 -- All the methods that are called, will be written to file
	
  There is no output file. I am writing the output to standard out (console)
   
   If the input file is empty, values for all the counts will be 0.
   
   It is expected that input file is correct.
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
	PopulateObjectsInterface.java
	FileProcessorInterface.java
		
  Classes:
	Driver.java
	FileProcessor.java
	MyLogger.java
	First.java
	Second.java
	PopulateObjects.java
	
   Input file:
     input.txt //that you give as input while running
]

SAMPLE OUTPUT:

[
remote06:~/ramesh/DP/temp5/sangaraju_ramesh_assign5/objComp> ./run.sh inputbig.txt 10 0
ant run -buildfile src/build.xml -Darg0=inputbig.txt -Darg1=10 -Darg2=0
Buildfile: /import/linux/home/rsangar1/ramesh/DP/temp5/sangaraju_ramesh_assign5/objComp/src/build.xml

jar:

run:
     [java] Number of non-duplicate First objects: 237
     [java] Total number of First objects: 474
     [java] Number of non-duplicate Second objects: 263
     [java] Total number of Second objects: 526
     [java] Total time: 0.041 seconds
     [java] Java Result: 1

BUILD SUCCESSFUL
Total time: 1 second

]

TO COMPILE:

[
  Extract the files and then run following command in objComp directory
  
  ant -buildfile src/build.xml all
]

TO RUN:

[
  chmod +x run.sh (one time)

  ./run.sh inputbig.txt 5 0
  
]

EXTRA CREDIT:

[
  No extra credit
]


BIBLIOGRAPHY:

This serves as evidence that I am no way intending Academic Dishonesty.
<Ramesh Kumar Raju Sangaraju>

[
  I have referred to following resources on internet. 

  * https://docs.oracle.com/javase/tutorial/reflect/

  * https://docs.oracle.com/javase/tutorial/reflect/class/classMembers.html
]

ACKNOWLEDGEMENT:

[
  Document here your classmates, and/or other people who have helped you.
  DON'T ACKNOWLEDGE YOUR TEAMMATES.
  Here is a sample:

  During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

  Email discussion happened on ListServ CS542 helped me in clearing out the doubts
  regarding the problem statement. Thanking all of them who participated in discussion.

]