# My Maven Project

This is a sample Maven project set up with Git version control.

# Structure

- `src/` - Java source code
- `pom.xml` - Maven configuration
- `doc/` - Contains deliverables and documentation

# Deliverables

- [Deliverable 1 PDF](doc/Deliverable1.pdf)

# Project Description

- In this zoo system, Users are stored within the system and play different roles. For example, 
visitors will be able to browse a list of various animals, and view their characteristics, such as the animals
nickname, age and even quality (furocious, shy, clumsy, etc.). The system will also be able to recommend to the
visitor a specific animal based on search parameters and tell the visitor what and where is this animal. 
Each visitor will be mapped to one animal in the system. Text IO will be used here to write down the username of
the visitor and the animal that they get paired up with. On the other hand, zookeepers can also register in the 
system, and their role is to go to the exhibit with the animal that is mapped to most visitors. Zookeepers will
be able to see all visitor animal recommendations, so that way they know where to go. 
- In this project, there are two hierarchies: the first one is Animal. Animal class is an abstract superclass which
will carry most of the animal characteristics, as well as a method called performAction(), which will apply 
run-time polymorphism. This method will be overridden in
the four animal subclasses, which are Lion, Elephant, Monkey and Penguin. A Comparator class will be implemented inside
of the Animal class, which will sort the animals by various filters. Next one is abstract User class, which has subclasses
Visitor and Zookeeper. User will implement an interface called UpdateAccountInterface, which will have two abstract methods:
one for updating password and one for updating age. In the Visitors class, a Comparable will be implemented which will sort
them by their animal. This is for the Zookeepers so that they can see the animal with the most pairs. 
- For deliverable 2, the entire Animal side of the project will be implemented.
