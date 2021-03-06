# Software-Engineering-Lab-Assignments
[![Build Status](https://travis-ci.com/stef4k/Software-Engineering-Lab-Assignments.svg?token=pzCJyJVszWoX8cqVKtdc&branch=development)](https://travis-ci.com/github/stef4k/Software-Engineering-Lab-Assignments)
[![codecov](https://codecov.io/gh/stef4k/Software-Engineering-Lab-Assignments/branch/development/graph/badge.svg?token=NEHRPAG0BE)](https://codecov.io/gh/stef4k/Software-Engineering-Lab-Assignments)

Lab Assignments for the uni course Applied Software Engineering of the 4th year spring semester. In detail, more information about the assignments:
* [Assignment on Build Automation Tools](https://github.com/stef4k/Software-Engineering-Lab-Assignments/tree/development/gradeshistogram)
* [Assignment on Unit Testing & Continuous Integration](https://github.com/stef4k/Software-Engineering-Lab-Assignments/tree/development/unittesting)
* [Assignment on Design Patterns](https://github.com/stef4k/Software-Engineering-Lab-Assignments/tree/development/sourcecodeanalyzer)


## Purposes
- Get familiar with using git, github and a java library
- Use Maven to package your application and the aforementioned library into a standalone executable
- Learn how to execute unit testing and implement continuous integration with Travis
- Learn how to refactor code while using the appropriate design patterns
- Get familiar with UML diagrams

## Prerequisites
* Version 1.8 of JDK
* IDE installed, e.g. eclipse
* Maven (how to install [Maven](https://mkyong.com/maven/how-to-install-maven-in-windows/))

## Building
1. __Fork__ the repository.

2. __Clone__ the forked repository.
 `git clone <url>`, where _url_ is the url of your forked repository.

3. __Execute__ `mvn install`
4. __Run tests__ `mvn test`
5. __Run tests and produce jacoco report__ `mvn test jacoco:report`

***Important:*** In order to execute any Maven command, you will need to be in a directory with a pom.xml file.


## Built with
* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse](https://www.eclipse.org/) - IDE for Java
* [Travic CI](https://travis-ci.com/) - Continuous Integration Tool
* [Codecov](https://about.codecov.io/) - Code Coverage Reporting

## Author
* [Stefanos Kypritidis](https://github.com/stef4k)

## License
This project runs under the [MIT License](https://github.com/stef4k/Software-Engineering-Lab-Assignments/blob/development/LICENSE)


