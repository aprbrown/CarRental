# CarRental

This is the first project in CSC8002 - Advanced Programming at Newcastle University. This project involved a number of different design patterns. The full brief for this project is below.

## Brief

1 - Aim
=====

The aim of this coursework is for you to practice the design principles covered in lectures. You
will develop interfaces and classes to demonstrate that you have learned and understood
module material, including:

* appropriate overriding of Object class methods, including overriding toString and providing a static valueOf method when appropriate
* design of interface-based hierarchies, programming through interfaces and late binding
* the use of factories to control instantiation of objects, including guaranteeing the instantiation of unique instances
* defensive programming including the use of immutability
* the use of appropriate interfaces and classes from the Collections framework
* appropriate use of Javadocs to document your interfaces and classes
* the use of testing

The coursework is **not** algorithmically challenging. The focus is on good design and good
practice.

The coursework is **not** about development of an end-user application. You are developing
interfaces and classes that could be used for the development of an application. You should not
develop a graphical user interface or a command line interface. They are not necessary and you
will be given no credit for doing so. You should provide test cases for your interfaces and
classes. To do this you can use the simple test framework and Assertions class provided.
Alternatively, you can use the JUnit test framework facilities in Eclipse. In either case, you
should submit both your solution and the classes that you use to test the solution.

**Note** the car rental system specified below is a deliberate simplification. It is not an accurate
model of real world car rental. Your solution should correspond to the simplicity of the
specification. You risk losing marks if you attempt to provide a more realistic model of car
rental or provide a solution that is more complicated than necessary.

2 - System Overview
=====

A car rental company needs a set of interfaces and classes to manage car rentals.

The company rents cars from its fleet of 30 small cars and 20 large cars. For this coursework, the significant difference between small cars and large cars is that they consume fuel at different rates (see Section 3).

When all cars of a particular type have been rented out, no more cars of that type can be issued by the company until one of the rented cars is returned.

A car can only be rented out to one person at a time. So, a car that is out for rent cannot be rented out again until after it has been returned and the existing rental contract terminated. Once a car has been returned, it is available for rent again. Another way of expressing this guarantee is that a car that is not rented or has been returned cannot be driven. That is, the status of any given car is either rented to one person (in which case it can be driven and the driver can add fuel to the car) or not rented (in which case it cannot).

A person can only rent out one car at a time.

The rental company needs to maintain a record of who has rented a given car (associating a person's driving licence details with the car they have rented). In addition, they need to be able to issue cars for rent and terminate rental contracts on return of cars. They also require information on cars currently out to rent. The following provides more detail on the required functionality:
```Java
availableCars(typeOfCar)
```
This method returns the number of cars of the specified type that are available to rent.

``` Java
getRentedCars()
```
This method returns a collection of all the cars currently rented out (if any)

``` Java
getCar(drivingLicence)
```
Given a person's driving licence, this method returns the car they are currently renting (if any)

``` Java
issueCar(drivingLicence, typeOfCar)
```
Given a person's driving licence and a specification of the type of car required (small or large), this method determines whether the person is eligible to rent a car of the specified type and, if there is a car available, issues a car of the specified type. The car must have a full tank of petrol at the start of the rental. The method associates the car with the person's driving licence (so that the company has a record of cars out for rent and the people renting them). If a car cannot be issued, the method returns an appropriate indication of the failure to issue a car. Note, this does not have to indicate why a car cannot be issued, it simply indicates that a car cannot be issued. The rules for determining whether or not a car can be issued are given below.

``` Java
terminateRental(drivingLicence)
```
This method terminates the rental contract associated with the given driving licence. In effect, the driver is returning the car. The car is then available for rent by someone else. The method removes the record of the rental from the company's records (disassociating the car from the licence) and returns the amount of fuel in Litres required to fill the car's tank. The driver returning the car must either have returned the car with a full tank or will be liable for the number of Litres required to fill the tank. This terminateRental method is not responsible for managing charges for the required fuel. It just reports the amount of fuel required to fill the tank. This method changes the status of the returned car to not rented.Terminating a non-existent contract has no effect.

When issuing a car, the following rules must be observed.

* the person renting the car must have a full driving licence
* they cannot rent more than one car at a time
* to rent a small car, they must be at least 21 years old and must have held their licence for at least 1 year
* to rent a large car, they must be at least 25 years old and must have held their licence for at least 5 years

Note, you can assume that people renting cars have pre-paid vouchers for all rental costs except
fuel. You are **not** concerned with the management of the vouchers.

3 - Implementation
===

To complete the car rental system outlined in Section 2 you will need to provide interfaces and classes for the functionality described in this section. You must also implement test classes to unit test your solution.

## Cars

All cars have the following public functionality:

* a method to get the car's registration number
* a method to get the capacity in whole Litres of the car's fuel tank, which is 49 Litres for a small car and 60 Litres for a large car
* a method to get the amount of fuel in whole Litres currently in the fuel tank
* a method that indicates whether the car's fuel tank is full or not
* a method that indicates whether the car is rented or not
* a method to add a given number of whole Litres to the fuel tank (up to the tank's capacity) and which, after execution, indicates how much fuel was added to the tank (which will be 0 if the car is not rented or its tank is already full)
* a method to "drive" the car for a given number of whole Kilometres that returns the number of whole Litres of fuel consumed during the journey 

The following rules determine the meaning and functionality of the drive method (and of the method to get the capacity of a car's tank).

* A car cannot be driven if it is not currently rented.
* A car cannot be driven if it has 0 or less Litres of fuel in its tank.
* A small car consumes fuel at the rate of 20 Kilometres/Litre.
* A large car consumes fuel at the rate of 10 Kilometres/Litre for the first 50 Kilometres of a journey and then at the rate of 15 Kilometres/Litre for the remainder of the journey.
* The drive method calculates the amount of fuel consumed during a journey, deducts that amount from the fuel in the tank, and returns the amount of fuel consumed. If the car cannot be driven the method should provide an appropriate indication that no journey has been undertaken.

To reduce the complexity of calculations considerably, you can apply the following simplifications.

* All journeys are either for 0 Kilometres (the car cannot be driven) or for the full distance specified as a parameter to the drive method.
* A single journey is allowed to consume more fuel than is available in the tank. So, at the end of a journey the fuel in the tank may be a negative amount of Litres. As noted above, a car cannot be driven when its tank is empty (or less than empty!). This means a journey cannot be started when the tank has 0 or less Litres available. More fuel will have to be added before starting the journey.
* All calculations are for whole Litres and whole kilometres. Use integer arithmetic in calculations. If the rate of consumption for a given journey means that a fraction of a Litre would be consumed in the real world, in this simplified model of driving a whole Litre is consumed. So, for example, a small car will consume 1 whole Litre for any journey up to and including 20 Kilometres. There are no fractions of Litres consumed.

You must provide an appropriate hierarchy for cars. Your car rental class issues a car of the
appropriate type when requested (and according to the rules set out in Section 2).

## Car registration number

A car registration number has two components - a single letter followed by a four digit number. For example:

* a1234

You must provide access to each component and an appropriate string representation of the registration number.

Registration numbers are unique. You must guarantee that no two cars have the same registration number.

## Driving licence

A driving licence has the driver's name (comprising a first and last name), the date of birth of
the driver, a unique licence number, a date of issue, and an indication whether the licence is a
full driving licence or not.

The licence number has three components. The first component is the concatenation of the initial of the first name of the driver with the initial of the last name of the driver. The second component is the year of issue of the licence. The third component is an arbitrary serial number. For example, the string representation of the licence number for a licence issued to Mark Smith in 1990 would have the form:

* MS-1990-10

where the 10 is a serial number that, with the initials and year, guarantees the uniqueness of the licence number as a whole.

Your driving licence must provide methods to access the driver's name, the driver's date of birth, the licence number, the date of issue of the licence and whether it is a full licence or not.

You should provide appropriate classes for a person's name and for a licence number.

You must guarantee the uniqueness of licence numbers.

You should use the java.util.Date class to represent dates. However, you must not use deprecated methods of the Date class. So, for example, in your test classes use java.util.Calendar to construct dates of birth and dates of issue of licences. You can assume default time zone and locale.

4 - Deliverable
====

Your solution should include your interfaces and classes that comprise the implementation of the system and types outlined in Sections 2 and 3. You should annotate your code with appropriate Javadocs. In addition, you should provide separate test classes that demonstrate testing of your solution.

5 - Assessment
====

In this coursework you should demonstrate:

* the sensible use of Java inheritance mechanisms,
* an understanding of how to declare and use interfaces,
* the ability to handle collections of objects,
* the use of late binding,
* the use of defensive programming, including use of immutability and appropriate error handling,
* an understanding of when and how to override Object methods,
* the implementation of object factories,
* the ability to implement simple algorithms,
* the ability to write Javadoc comments, and
* the ability to test your code.

Marks will be allocated for

* overall structure and implementation of the solution (e.g. interfaces, classes and their relationships)
* correct implementation of rules specified in Sections 2 and 3
* choice and use of maps and collections
* following good practice guidance: maintenance of invariants and defensive programming, use of immutability, appropriate overriding of Object methods, some use of Javadoc comments, etc.
* evidence of testing by implementation of appropriate test classes that test the normal case, boundary conditions, and exceptional cases

6 - Style guidelines
===

Adopt a consistent style, do not violate naming conventions (e.g. when to use upper/lower case letters in class, method and variable names) and make appropriate use of whitespace
(indentation and other spacing).

7 - Further notes
===
Break the coursework down into separate tasks. Start with the simpler classes first (e.g. RegistrationNumber, Name, LicenceNumber and DrivingLicence) but leave the imposition of
uniqueness until we cover object factories. You can implement the different types of car before implementing the rental manager. Unit test classes as you progress through the coursework.

For each class you implement you should consider:

* whether to override Object methods (equals, toString etc.),
* whether to use an interface-based hierarchy, and
* whether the class should be immutable.

You may have to defer parts of the coursework (or the implementation of certain aspects of a class) until we have covered material in lectures. In which case, you can make a start with a simpler solution that can be extended later. For example, we have not covered the Collections framework yet. To make a start, you can just use a single instance of a class.