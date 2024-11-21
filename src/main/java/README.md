SER502-Skyload-Team18
Team:-

Chandan Krishna Yalavarthy
Shrinidhi Mane
Sugato Mukhopadhyay
Trushant Gautam
Name of the Language:- Skyload

Overview
Skyload is a custom-designed programming language created as part of a team project for a compiler and virtual machine course. The language is designed to include basic programming constructs such as boolean operators, numeric and string data types, loops, conditionals, and a print function. It supports simple arithmetic, relational operations, and control flow using a syntax similar to C++ like languages. This project involves building a full compilation pipeline, from lexical analysis and parsing to the execution of code through a virtual machine runtime environment.

Language Features:-
1.Boolean Operators: and, or, not
2.Numeric and String Assignments
3.Arithmetic Operators: +, -, *, /, %
4.Relational Operators: <, <=, >, >=, ==, !=
5.Conditional Constructs: if, else (decide (condition) otherwise {statement})
6.Looping Constructs: for( perform(expr; cond; expr) {}) , while(do {})
7.Ternary Operator: condition ? expr1 ..: expr2
8.Print Construct: show

System Support Provided to:- Windows

Tools & Technologies
To build the compiler and virtual machine for Skyload, we will use the following tools:

EBNF (Extended Backus-Naur Form): To define the grammar and create the parser for the language.
ANTLR: For lexical analysis to tokenize source code into meaningful symbols.
ANTLR: To generate the parser for interpreting the grammar of the language.
Java: To develop the runtime environment that executes the parsed code.

Build and Run Instructions (Using ANTLR with IntelliJ and Maven)
Step 1:Configure ANTLR in IntelliJ with Maven

Add ANTLR Dependency: In our pom.xml, we have added the following dependency for ANTLR:

  <dependencies>

     <dependency>
   
        <groupId>org.antlr</groupId>

        <artifactId>antlr4</artifactId>

        <version>4.9.2</version>

     </dependency>

   </dependencies>
Enable ANTLR Plugin in IntelliJ:

a. Install the ANTLR v4 plugin from IntelliJ’s Plugin Marketplace if you haven’t already.

b. Once installed, you can right-click on your grammar file (e.g., Skyload.g4) and select Generate ANTLR Recognizer to automatically create lexer and parser files.

Step 2: Generate Lexer and Parser Files

Use the Plugin to Generate Recognizers:

a. Right-click on the Skyload.g4 grammar file and select Generate ANTLR Recognizer.

b. The plugin will automatically place the generated files in the appropriate directory within src/main/java.

Step 3: Build the Project

Clean Previous Builds and Package the Project: Run a Maven clean command to remove old build files and Compile the project and create a JAR file:

     "mvn clean package"
The output JAR, typically named SKYLOAD-1.0-SNAPSHOT.jar, will be in the target directory.

Step 4: Run the Parser

Prepare Your Skyload Source File: Place the .sky file you want to test in the specified directory:

     "src/main/java/data/yourfilename.sky"
Execute the Skyload File: Run the following command from the command line/terminal:

     "java -jar target/SKYLOAD-1.0-SNAPSHOT.jar src/main/java/data/yourfilename.sky"
