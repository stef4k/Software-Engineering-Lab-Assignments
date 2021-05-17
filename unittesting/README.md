# Unit Testing Assignment

This module contains various unit tests for classes with arithmetic functions like factorial, divide, primes etc. In detail, assertions, rules, parameterized tests, test suites and mocking were used to get a practical view on unit testing. The assignment description can be found [here](https://edu.dmst.aueb.gr/pluginfile.php/19733/mod_resource/content/1/Lab-Assignment-3.pdf).

### Prerequisites
In order to runt the unit tests, you must have firstly implemented the [building of the project](https://github.com/stef4k/Software-Engineering-Lab-Assignments/blob/development/README.md) (Building section)

## Running the tests
To run all the unit tests, execute the command from cmd `mvn test`

## Code Coverage with JaCoCo
Jacoco was used to check the code coverage of this project. In order to run it, execute the Maven command `mvn package jacoco:report`. Then all the reports can be found under target/site/jacoco.

## Code Coverage with CodeCov
CodeCov was also integrated in this project in order to check the code coverage quicker. The results of CodeCov can be viewed by clicking on the following badge [![codecov](https://codecov.io/gh/stef4k/Software-Engineering-Lab-Assignments/branch/development/graph/badge.svg?token=NEHRPAG0BE)](https://codecov.io/gh/stef4k/Software-Engineering-Lab-Assignments)  which can also be found on the top of the main [README.md](https://github.com/stef4k/Software-Engineering-Lab-Assignments/blob/development/README.md)

## Travis Continuous Integration service
This module uses TravisCI services in other to test and build the application upon each git-push in the remote repository. The `.travis.yml` file contains information on how to build the application.
After every build, the badge is updated with the corresponding build status. In detail, green for `passes` and red for `failures`.
