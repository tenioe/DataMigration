
Data Migration

Project description:
- The aim of this project was to develop a Data migration program to insert CSV (Comma Separated Values) files of sizes 10k and 65k into a MYSQL Database using a Java SQL library to run queries with and without using concurrency.
- Maven was utilised to do performance tests on the speeds on the threads created.

- How to use:
1. In package directory : com.sparta.teni.Controllers.Starter.start; 
   - Make sure that choose file input is uncommented and comment out the other.
   - There is the option to choose the 10k or 65k file.
2. In package directory : com.sparta.teni.Controllers.Starter.start;
   Make sure that choose insertion is uncommented and comment out the other. 
   There is the option to choose the normal data migration "employeeManager.insertDataFromFile();" and the data migration with threads "employeeManager.insertWithThreads(10);"

Performance results :
- Testing 10K file without threads...
The data migration took 0.784 without threads.

- Testing 10K file with 10 threads...
The data migration took 0.742 without threads.

- Testing 65K file without threads...
The data migration took 0.5598 without threads.

- Testing 65K file with threads...
The data migration took 0.2257 without threads.

Technologies:
- IntelliJ
- Java JDK 11
- Java Sql library
- Maven
- JUNIT
- Log4j

Future Developments/Improvements:
- More tests with threads increased.
- Larger Files.
- Functional Programming.
- More User friendly interface to choose file and with or without threads and analytics on performance
- Graphical User Interface or Command line interface.


