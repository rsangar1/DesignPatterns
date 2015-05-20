CS542 Design Patterns
Spring 2015
PROJECT <4> README FILE

Due Date: Wednesday, April 22, 2015
Submission Date: Wednesday, April 22, 2015
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Ramesh Kumar Raju Sangaraju>
e-mail(s): <rsangar1@binghamton.edu>


PURPOSE:
[
	This project is to implement Visitor pattern and to achieve better performance
	while reading and counting the number of words, unique words and characters from
	a file.
	
	Visitor pattern is implemented
	Singleton pattern is used.
	Program to an interface not to an implementation //design principle
	Favor composition over inheritance //design principle
	
	How program works:
	* Element is created in Driver and to its accept method, PopulateTreeVisitor and 
	  WordCountVisitor objects are passed.
	* PopulateTreeVisitor receives the tree and populates the tree with strings read
	  from input file.
	* On the same tree, WordCountVisitor counts number of words, number of unique words
	  and number of characters by traversing through each node in the tree.
	
    I have chosen TreeMap that is available in java.util package. This is useful in storing the
	the string in key value pairs. I have used hash code of String as key and value as TreeNode 
	object. This is useful in storing only unique words and if a word is repeated, I am 
	incrementing he count(frequency) of word maintained in TreeNode object. 
	
	Reasons:
	- TreeMap is implemented as Red Black tree in java.
	- Insertion time in red black tree is always O(log (n)).
	- Red black is self balancing tree.
	
	I have tried with my own BST implementation and the performance was better with TreeMap than my
  
  In Debug class, I have variable called debugLevel. Following values are applicable for debug value.
    0 -- No output is written into the file
	1 -- All the constructors that are called will be written to file
	2 -- All the methods that are called, will be written to file
	
   The output file contains result with number of words, number of unique words and number of characters.
   
   I am writing the output to output.txt file.
   
   If the input file is empty, number of characters will be 0.
   I am ignoring white spaces, I am not inserting it into tree, so it will not be counted.
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
	DataTreeInterface.java
	FileProcessorInterface.java
	Visitor.java
	
  Classes:
	Driver.java
	DataTree.java
	DataTreeInterface.java
	
   Input file:
     input.txt //that you give as input while running
]

SAMPLE OUTPUT:

[
ant run -buildfile src/build.xml -Darg0=input1M.txt -Darg1=output.txt -Darg2=5 -Darg3=0
Buildfile: /import/linux/home/rsangar1/ramesh/DP/assignment4/wordCount/src/build.xml

jar:

run:
     [java] Time per each iteration: 831

BUILD SUCCESSFUL
Total time: 5 seconds

]

TO COMPILE:

[
  Extract the files and then run following command in wordCount directory
  
  ant -buildfile src/build.xml all
]

TO RUN:

[
  remote05:~/ramesh/DP/assignment4/wordCount> chmod +x run.sh

  remote05:~/ramesh/DP/assignment4/wordCount> ./run.sh input1M.txt output.txt 5 0
  
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

  * http://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html
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