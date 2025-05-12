# My Maven Project

This is a sample Maven project set up with Git version control.

# Structure

- `src/` - Java source code
- `pom.xml` - Maven configuration
- `doc/` - Contains deliverables and documentation

# Deliverables

- [Deliverable 1 PDF](doc/Deliverable1.pdf)
- [Deliverable 4 PDF](doc/Deliverable4.pdf)

# Project Description

- In this zoo management app, Users are stored within a system and play different roles. For example, Visitors will be 
able to browse a list of various animals, view their characteristics, search for an animal based on a characteristic
(using a stream) and view their history of visited animals. On the other hand, zookeepers can also register in the 
system, and they can browse a list of visitors, visit the most popular animal amongst visitors and even recommend a new 
animal to add to the zoo. TextIO will be used to write the recommendation on a csv file. A map will be used to show the 
most popular animal. An interactive menu will be implemented which will allow a User to log in and perform actions 
based on the type of User(Visitor or Zookeeper).

- In this project, there are two hierarchies: the first one is Animal. Animal class is an abstract superclass which
will carry basic animal characteristics, such as nickname, age, gender and quality (ferocious, shy, clumsy, etc.), 
as well as a method called makeNoise(), which will apply run-time polymorphism. This method will be overridden in
the four animal subclasses, which are Lion, Elephant, Monkey and Penguin. A Comparator class will be implemented inside
the Animal class, which will sort the animals by various filters. Next one is abstract User class, which has subclasses
Visitor and Zookeeper. User will have attributes name, age and password. IDs for Visitor and Zookeeper will be 
different. User will implement an interface called UpdateAccountInterface, which will have two abstract methods:
one for updating password and one for updating age. In the Visitors class, a Comparable will be implemented which will 
sort the visitors by their age.
