CS542 Design Patterns
Spring 2015
PROJECT <3> README FILE

Due Date: Friday, April 3, 2015
Submission Date: Friday, April 3, 2015
Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <Ramesh Kumar Raju Sangaraju>
e-mail(s): <rsangar1@binghamton.edu>


PURPOSE:

[
	This project focus on the implementation of Observer pattern. In this
project, DashboardSubject acts as Subject that filters the input string from 
file, based on the starting string in each line. The filtered string is passed
to the appropriate observer where the string is processed to print to the 
dashboard output file.

SAMPLE INPUT FILE:

Performance:2058364:1949304:109060:1539620:94.8:4.4:0.6*
Users:(unknown):inactive-jakyuz1:active-jakyuz1:active-root:inactive-bsendir1:inactive-jakyuz1:active-jakyuz1:active-tbarten1:active-jbelles1:active-spinho1:active-thung1:active-bsendir1:active-awiesin1:active-jakyuz1:active-hpittin1:active-rashong1:active-egarbad1:active*Processes:3492:Xorg:root:0.0:0.1-4078:getty:root:0.0:0.0-4079:getty:root:0.0:0.0-4080:getty:root:0.0:0.0-4081:getty:root:0.0:0.0-4082:getty:root:0.0:0.0-4083:getty:root:0.0:0.0-6130:tcsh:thung1:0.0:0.2-8030:tcsh:egarbad1:0.0:0.1-8526:tcsh:jakyuz1:0.0:0.1-8614:tcsh:bsendir1:0.0:0.1-10189:tcsh:hpittin1:0.0:0.1-10191:bash:hpittin1:0.0:0.1-10986:tcsh:jakyuz1:0.0:0.1-11008:tcsh:jakyuz1:0.0:0.1-11018:tcsh:jakyuz1:0.0:0.1-11548:tcsh:rashong1:0.0:0.1-13269:gdb:thung1:0.0:0.7-13367:bomb:thung1:0.0:0.0-14215:make:jakyuz1:0.0:0.1-14216:gdb:jakyuz1:0.0:0.7-15430:gdb:rashong1:0.0:0.7-15726:bomb:awiesin1:0.0:0.0-16632:bomb:jakyuz1:0.0:0.0-17866:tcsh:tbarten1:0.0:0.1-17992:gedit:tbarten1:0.4:1.9-18003:dbus_launch:tbarten1:0.0:0.1-18005:gdb:jbelles1:0.0:0.7-18012:bomb:jbelles1:0.0:0.0-19231:gedit:tbarten1:0.0:0.5-19254:tcsh:bsendir1:0.2:0.1-19317:python:bsendir1:0.8:0.4-19380:sh:bsendir1:0.0:0.0-19381:ps:bsendir1:0.0:0.1-19954:tcsh:spinho1:0.0:0.1-26390:edit:jakyuz1:0.0:0.2-26392:sh:jakyuz1:0.0:0.0-26393:vim:jakyuz1:0.0:0.7-26552:bash:root:0.0:0.1-26699:edit:jakyuz1:0.0:0.2-26701:sh:jakyuz1:0.0:0.0-26702:vim:jakyuz1:0.0:0.7-26721:watch:root:0.0:0.1-27017:tcsh:awiesin1:0.0:0.1-27104:gdb:awiesin1:0.0:0.7-27221:tcsh:jakyuz1:0.0:0.1-27362:make:jakyuz1:0.0:0.1-27363:gdb:jakyuz1:0.0:0.7-27449:tcsh:jbelles1:0.0:0.1-30589:bomb:jakyuz1:0.0:0.0*
Performance:2058364:1951168:107196:1539620:94.8:4.4:0.6*


Explanation:
There are three tabs.
1. Performance tab
2. Users tab
3. Processes tab

SAMPLE OUTPUT FILE:

---TAB(s) BEGIN---
---TAB(s) END---
---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1949304  Memory  Free: 109060  Memory  Cached: 1539620
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6

---TAB(s) END---
---TAB(s) BEGIN---
---USERS---
User: (unknown)  Status: inactive
User: jakyuz1  Status: active
User: jakyuz1  Status: active
User: root  Status: inactive
User: bsendir1  Status: inactive
User: jakyuz1  Status: active
User: jakyuz1  Status: active
User: tbarten1  Status: active
User: jbelles1  Status: active
User: spinho1  Status: active
User: thung1  Status: active
User: bsendir1  Status: active
User: awiesin1  Status: active
User: jakyuz1  Status: active
User: hpittin1  Status: active
User: rashong1  Status: active
User: egarbad1  Status: active

---PROCESSES---
  PID COMMAND         USER     %CPU %MEM
 3492 Xorg            root      0.0  0.1
 4078 getty           root      0.0  0.0
 4079 getty           root      0.0  0.0
 4080 getty           root      0.0  0.0
 4081 getty           root      0.0  0.0
 4082 getty           root      0.0  0.0
 4083 getty           root      0.0  0.0
 6130 tcsh            thung1    0.0  0.2
 8030 tcsh            egarbad1  0.0  0.1
 8526 tcsh            jakyuz1   0.0  0.1
 8614 tcsh            bsendir1  0.0  0.1
10189 tcsh            hpittin1  0.0  0.1
10191 bash            hpittin1  0.0  0.1
10986 tcsh            jakyuz1   0.0  0.1
11008 tcsh            jakyuz1   0.0  0.1
11018 tcsh            jakyuz1   0.0  0.1
11548 tcsh            rashong1  0.0  0.1
13269 gdb             thung1    0.0  0.7
13367 bomb            thung1    0.0  0.0
14215 make            jakyuz1   0.0  0.1
14216 gdb             jakyuz1   0.0  0.7
15430 gdb             rashong1  0.0  0.7
15726 bomb            awiesin1  0.0  0.0
16632 bomb            jakyuz1   0.0  0.0
17866 tcsh            tbarten1  0.0  0.1
17992 gedit           tbarten1  0.4  1.9
18003 dbus_launch     tbarten1  0.0  0.1
18005 gdb             jbelles1  0.0  0.7
18012 bomb            jbelles1  0.0  0.0
19231 gedit           tbarten1  0.0  0.5
19254 tcsh            bsendir1  0.2  0.1
19317 python          bsendir1  0.8  0.4
19380 sh              bsendir1  0.0  0.0
19381 ps              bsendir1  0.0  0.1
19954 tcsh            spinho1   0.0  0.1
26390 edit            jakyuz1   0.0  0.2
26392 sh              jakyuz1   0.0  0.0
26393 vim             jakyuz1   0.0  0.7
26552 bash            root      0.0  0.1
26699 edit            jakyuz1   0.0  0.2
26701 sh              jakyuz1   0.0  0.0
26702 vim             jakyuz1   0.0  0.7
26721 watch           root      0.0  0.1
27017 tcsh            awiesin1  0.0  0.1
27104 gdb             awiesin1  0.0  0.7
27221 tcsh            jakyuz1   0.0  0.1
27362 make            jakyuz1   0.0  0.1
27363 gdb             jakyuz1   0.0  0.7
27449 tcsh            jbelles1  0.0  0.1
30589 bomb            jakyuz1   0.0  0.0

---TAB(s) END---
---TAB(s) BEGIN---
---PERFORMANCE---
Memory Total: 2058364  Memory Used: 1951168  Memory  Free: 107196  Memory  Cached: 1539620
CPU Idle: 94.8  CPU User Level: 4.4  CPU System Level: 0.6

---TAB(s) END---

In performance tab, we have 

	
	How program flows:
	* Create file processor object to read contents from file
	* Create Subject, Observers and corresponding filters and register them with subject
	* Subject passes the input string to filter of each observer
    * Input string is passed to respective observer from Subject after filtering.
	* Observer processes the string and print to the output file
	
	How program works:
	* Reading line from input file.
	* Based on the initial string, corresponding observer is notified.
	* String manipulations and formatting are done as required for output file.
	* All the content is wrote to output file.
	
     
  I have chosen ArrayList as the data structure in Observers to store the objects of tabs based on the following considerations:
	1. We have unlimited number of objects of each type of observer.
	2. ArrayList can grow dynamically
	3. ArrayList doubles its size once it is half filled
	4. We have not selected Vector as we are not dealing with threads.
	
  
  In MyLogger class, I have variable called LOGGER_LEVEL. Following values are applicable for debug value.
    0 -- No output is written into the file. Errors are written to stdout
	1 -- The whole dashboard output is written to file
	2 -- All the constructors that are called will be written to file
	3 -- All the methods and constructors related to all the files will be written to file.
	
  If invalid logger level is entered (greater than 3) no logs will be printed as I am setting the level to 0.
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
	DisplayFile.java
	DashboardFilter.java
	Observer.java
	Subject.java
	FileProcessorInterface.java
	
  Classes:
	Driver.java
	MyLogger.java
	ProcessTab.java
	ProcessTabFilterImpl.java
	UsersTab.java
	UsersTabFilterImpl.java
	PerformanceTab.java
	PerformanceTabFilterImpl.java
	DashboardSubject.java
	FileProcessor.java
	User.java
	Process.java
	Performance.java
]

SAMPLE OUTPUT:

[
	remote03:~/ramesh/DP/assignment3/taskManager> ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=2
Buildfile: /import/linux/home/rsangar1/ramesh/DP/assignment3/taskManager/src/build.xml

jar:
    [mkdir] Created dir: /import/linux/home/rsangar1/ramesh/DP/assignment3/taskManager/BUILD/jar
      [jar] Building jar: /import/linux/home/rsangar1/ramesh/DP/assignment3/taskManager/BUILD/jar/taskManager.jar

run:

BUILD SUCCESSFUL
Total time: 2 seconds

]

TO COMPILE:

[
  Extract the files and then run following command in taskManager directory
  ant -buildfile src/build.xml all
]

TO RUN:

[
  Run below command from directory where this README is present
  
  ant -buildfile src/build.xml run -Darg0=<input-file> -Darg1=<output-file> -Darg2=<logger-level>

  logger-level should be between 0 to 4 :
	0 -- No output is written into the file. Errors are written to stdout
	1 -- The whole dashboard output is written to file
	2 -- All the constructors that are called will be written to file
	3 -- All the methods and constructors related to all the files will be written to file.

The output is stored into output file. Run diff command to compare with the expected output. I have verified with all the given inputs.

]

EXTRA CREDIT:

[
  Professor did not specify any extra credit.
]


BIBLIOGRAPHY:

This serves as evidence that I am no way intending Academic Dishonesty.
<Ramesh Kumar Raju Sangaraju>

[
  I have referred to Head First Design Patterns text book to verify the Observer pattern. I have also referred to Oracle docs to check the String.format() method.

http://docs.oracle.com/javase/7/docs/api/java/lang/String.html

]

ACKNOWLEDGEMENT:

[
  Document here your classmates, and/or other people who have helped you.
  DON'T ACKNOWLEDGE YOUR TEAMMATES.
  Here is a sample:

  During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

  Email discussion happened on ListServ CS542 helped me in clearing out the doubts regarding the problem statement.

]
