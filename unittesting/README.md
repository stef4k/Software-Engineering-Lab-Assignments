# Unit Testing Assignment

This module contains various unit tests for classes with arithmetic functions like factorial, divide, multiply etc. The assignment description can be found [here](https://edu.dmst.aueb.gr/pluginfile.php/19733/mod_resource/content/1/Lab-Assignment-3.pdf).

### Prerequisites
In order to runt the unit tests, you must have firstly implemented the [building of the project](https://github.com/stef4k/Software-Engineering-Lab-Assignments/blob/development/README.md) (Building section)

## Running the tests
To run all the unit tests, execute the command from cmd `mvn test`

## Travis Continuous Integration service
This module uses TravisCI services in other to test and build the application upon each git-push in the remote repository. The `.travis.yml` file contains information on how to build the application.
After every build, the badge is updated with the corresponding build status. In detail, green for `passes` and red for `failures`.
