CO1 JAVA ASSIGNMENT 1 — TASKS 1–12

Each task has its own folder and standalone Java source file.
Compile and run from the relevant folder.

Examples:
  cd Task03
  javac ParkingFacility.java
  java ParkingFacility

  cd Task08
  javac FeeDemo.java
  java FeeDemo

Task 10 uses package parking.app. From the Task10 folder, compile/run from the parent folder:
  javac -d . Task10Encapsulation.java
  java parking.app.Task10Encapsulation
(If your IDE expects package folders, place the file under parking/app/Task10Encapsulation.java.)

Recommended Java version: Java 8+; Task 8 uses instanceof casting for broad compatibility.

Tasks included:
01 Problem analysis/object model demonstration
02 Data representation and jagged arrays
03 ParkingFacility allocation/release (matches assignment expected output)
04 Constructors and copy constructor
05 Static ticket counter/object life cycle
06 Inheritance and constructor order
07 Method overriding, equals/hashCode/toString
08 Polymorphism and Chargeable (matches assignment expected output)
09 Abstract class and interface
10 Encapsulation and validation
11 Working smart-parking entry/exit demonstration
12 Adapted design challenge: e-bike, delivery van, one-day pass, five unequal floors

Important:
These are educational starter implementations for each task. The assignment also asks for written analysis,
pseudocode, UML, complexity analysis, tests/screenshots, README and GitHub commits. Add those report
items separately and test the code in your own Java environment before submission.
