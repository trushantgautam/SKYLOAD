## Overview
Skyload is a custom-designed programming language created as part of a team project for a compiler and virtual machine course. The language is designed to include basic programming constructs such as boolean operators, numeric and string data types, loops, conditionals, and a print function. It supports simple arithmetic, relational operations, and control flow using a syntax similar to C++ like languages. This project involves building a full compilation pipeline, from lexical analysis and parsing to the execution of code through a virtual machine runtime environment.

**Language Features**:-\
1.Boolean Operators: and, or, not\
2.Numeric and String Assignments\
3.Arithmetic Operators: +, -, *, /, %\
4.Relational Operators: <, <=, >, >=, ==, !=\
5.Conditional Constructs: if, else  (decide (condition) otherwise {statement})\
6.Looping Constructs: for( perform(expr; cond; expr) {}) , while(do {})\
7.Ternary Operator: condition ? expr1 ..: expr2\
8.Print Construct: show

**System Support Provided to**:- Windows

**Tools & Technologies**

To build the compiler and virtual machine for Skyload, we will use the following tools:

EBNF (Extended Backus-Naur Form): To define the grammar and create the parser for the language.\
ANTLR: For lexical analysis to tokenize source code into meaningful symbols.\
ANTLR: To generate the parser for interpreting the grammar of the language.\
Java: To develop the runtime environment that executes the parsed code.

## Guide to Set Up, Build, and Run the SkyLoad Programming Language Using IntelliJ and ANTLR Plugin

This guide assumes you're starting from scratch and walks you through the entire process of installing Java, Maven, and IntelliJ, setting up the ANTLR plugin, and running a .sky program.

### **1. Prerequisite Tools**

**_1.1 Install Java JDK_**

1. Download the latest JDK: From Oracle or OpenJDK.
2. Install the JDK and configure the environment variables:

   On Windows:
   
       Add C:\Program Files\Java\jdk-<version>\bin to the Path system variable.
   
   Create a JAVA_HOME variable pointing to
     
       C:\Program Files\Java\jdk-<version>.
   
4. Verify the installation:
   
         java -version
5. Install and setup Maven : Download latest bin.zip file from their official website
https://maven.apache.org/download.cgi?.

6. Extract the zip file to any location and add the path to its bin folder to your PATH environment variables(Both User and System) as shown below

        C:\Program Files\Maven\apache-maven-3.9.9-bin\apache-maven-3.9.9\bin
   (Note: the exact location will be different based on where you have extracted your file)

7. Verify the installation

         mvn -version

###  ***Development Setup***

Step 1:Configure ANTLR in IntelliJ with Maven

1. Add ANTLR Dependency: In our pom.xml, we have added the following dependency for ANTLR:

         <dependencies>
       
            <dependency>
          
               <groupId>org.antlr</groupId>

               <artifactId>antlr4</artifactId>

               <version>4.9.2</version>

            </dependency>
    
          </dependencies>

3. Enable ANTLR Plugin in IntelliJ:

   a. Install the ANTLR v4 plugin from IntelliJ’s Plugin Marketplace if you haven’t already.
      For this navigate to File->Settings->Plugins
   ![Alt text](doc/IMG/ANTLR-Download.png?raw=true "Optional Title")

   b. Once installed, you can right-click on your grammar file (e.g., Skyload.g4) and select Generate ANTLR Recognizer to automatically create lexer and parser files.

   ![Alt text](doc/IMG/Antlr-generate.png?raw=true "Optional Title")

   c. For quick Debugging of your grammar you can right click on the Grammar entry point and run Test Rule Program as shown below

![Alt text](doc/IMG/ANTLR-PARSER.png?raw=true "Optional Title")

   it should display parse tree as shown below
![Alt text](doc/IMG/Factorial.png?raw=true "Optional Title")

Step 2: Generate Lexer and Parser Files

1. Use the Plugin to Generate Recognizers:

   a. Right-click on the Skyload.g4 grammar file and select Generate ANTLR Recognizer.

   b. The plugin will automatically place the generated files in the appropriate directory within src/main/java.

Step 3: Build the Project

1. Clean Previous Builds and Package the Project: Run a Maven clean command to remove old build files and Compile the project and create a JAR file:

            mvn clean package

   The output JAR, typically named SKYLOAD-1.0-SNAPSHOT.jar, will be in the target directory.

Step 4: Run the Parser

1. Prepare Your Skyload Source File: Place the .sky file you want to test in the specified directory:

            src/main/java/data/yourfilename.sky

2. Execute the Skyload File: Run the following command from the command line/terminal:

            java -jar target/SKYLOAD-1.0-SNAPSHOT.jar src/main/java/data/yourfilename.sky


### Alternate Testing Methods

The above instructions should work in general , if they are not working you can execute the files using java commands as mentioned below.(Note : these commands work in windows machine only!)

1. Download zip or clone the git repository

2. Navigate to `SKYLOAD/src/` folder 

3. Open **Command Prompt** at the location mentioned in point 2 above, Powershell doesn't work 

4. Compile the java programs 

         javac -cp .\out\Libraries\antlr-4.13.2-complete.jar -d out .\Grammar\*.java .\Runtime\*.java

This should generate class files within the `\out` folder in  `\src`
confirm if folders named **Grammar** and **Runtime** are generated with class files within.

5. Execute the java program 

         java -cp ./out/;./out/Libraries/*; Grammar.SkyLoadMain ..\data\While.sky

Here in the last part of the argument we pass the sample programs we have written in Skyload language as arguments, replace `While.sky` with any of the programs in the data folder
