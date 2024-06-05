# Cron String Parser

This command-line application parses a standard cron string and expands each field to show the times at which it will run. 
It considers the five standard time fields (minute, hour, day of month, month, and day of week) along with a command. 
Special time strings such as “@yearly” are not handled.

The cron string is passed to the application as a single argument.

The output is formatted as a table with the field name taking the first 14 columns and
the times as a space-separated list following it.

### Example
#### Sample Input: `*/15 0 1,15 * 1-5 /usr/bin/find`
#### Output:
```
minute        0 15 30 45
hour          0  
day of month  1 15  
month         1 2 3 4 5 6 7 8 9 10 11 12  
day of week   1 2 3 4 5  
command       /usr/bin/find
```

### How to Run
1. Clone the project
2. Downlaod and install Java 1.8 or later on your machine. 
   <br>Refernce link: https://www.java.com/download/ie_manual.jsp
3. Download and install maven.
   <br>Reference link: https://maven.apache.org/download.cgi
4. Open terminal and navigate to project location cloned in step #1. Your path should look like: `<Path_to_Cloned_Folder>\CronParser>`
5. Run `mvn clean install` in the terminal
6. Run `java -jar .\target\CronParser-1.0-SNAPSHOT.jar "<your_input>"` in the terminal
7. To run unit test execute `mvn test`






