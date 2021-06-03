# Design Patterns Assignment

This module contains the redesign of a system based on the SOLID design principles by applying the appropriate design patterns. The assignment description can be found [here](https://edu.dmst.aueb.gr/pluginfile.php/19938/mod_resource/content/1/Lab-Assignment-4.pdf).

## Running the system

1. Build the executable Java application with: 
	mvn package jacoco:report

2. Run the executable by executing
	`java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4 were args` translate to:
	
	* arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	
	* arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	
	* arg2 = “SourceCodeLocationType” [local|web]
	
	* arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	
	* arg4 = “OutputFileType” [csv|json]
	
	Example:

	`java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv`
	
## Running tests

* __Run tests__ `mvn test`
* __Run tests and produce jacoco report__ `mvn test jacoco:report`

## System Class Diagram

<img src="media/UMLDiagram.png" width="1200"/>

## Design Patterns

### Strategy Patterns

The strategy pattern was used twice with the creation of the interfaces and their subclasses that add functionality. In detail, it is used with the interface `MetricsExporter` and its subclass `CsvExporter` and `JsonExporter` (which are connected to `Facade`) and the interface `SourceFileReader` and its subclasses `WebFileReader` and `LocalFileReader` (which are connected to `SourceCodeAnalyzer`). The main reason it was used was because of  the future requirements plan to introduce new types of MetricsExporters and SourceFileReaders. By using this pattern, these dimensions are easy to be extended and changes are minimized in other dimensions. The benefits of this pattern as said, is the interface's subclasses are interchangeable and extensible with less need for changes in the class connected to the interface. However, the class connected to the inteface is still slightly coupled to the interface and its subclasses implementations.

## Bridge Pattern

The bridge pattern was used between the abstract class `SourceCodeAnalyzer`, its subclasses `RegexAnalyzer` and `StrcompAnalyzer`, the interface `SourceFileReader`and its subclasses and the class `FactoryAnalyzer`. One of the most important roles has the `SourceCodeAnalyzer` abstract class that basically connects the `FactoryAnalyzer`with the `SourceFileReader` interface and acts as a bridge. The benefits of this pattern is that different subclasses of `SourceCodeAnalyzer` and `SourceFileReader` can vary independently. In fact, adding new types of source file readers does not affect the source code analyzers and adding new code analyzers requires minimal changes in the
source file readers hierarchy. Also, the single responsibility princliple is implemented in all those classes now. However, the overall complexity of the system might have increased but that is a fair trade-off.

## Factory Pattern 

The factory pattern was also used between the class `FactoryAnalyzer`, the abstract class `SourceCodeAnalyzer`, its subclasses `RegexAnalyzer` and `StrcompAnalyzer`. The motivation behind this pattern was to create an interface to refer to all objects of source code analyzer and to hide extra functionality from the `Facade` class. If it was not for the factory pattern, the `Facade` class would violate the single responsibility princliple of a class. On the other hand, adding more classes increases the complexity of the system.

## Facade Pattern

The facade pattern includes all classes apart from `DemoClient`. The most important classes are `Facade`, interface `MetricsExporter` and `FactoryAnalyzer`. The facade pattern was used in order to create a simple interface to a complex system and to separate the client from different sub-systems. In fact, the facade interface  promotes subsystem
independence and portability. In other words, it connects the metrics exporter with the factory analyzer and thus the source code analyzers and the file readers. Lastly, the client becomes independent from different sub-systems and only depends on the facade, making it much simpler and easier to communicate.

