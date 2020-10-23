# JavaLoggable  

A banking application for logging transactions through the console written in Java


[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)
[![made-with-java 14](https://img.shields.io/badge/Made%20with-Java-1f425f.svg)](https://www.java.com/en/)

## Brief Summary

The application takes user input through the console and logs this information to the file directories specified internally in the application. If access to these files in required, it can be found in the "Resources/" directory for the project.


# Usage

The application can be launched from the Main class via the main method:

```java
public static void main (String[]args)
```

In the console, the Welcome message is displayed and the user is requested to choose from options present in numbered order. This in shown in the code below:

```bash

Welcome to the Banking Application 

Please choose an option below: 

(1) Show items 

(2) Add items 

(3) Edit items 

(4) Save and Exit. 

```

The user can select one of these numbers and navigate to the desired options to achieve the tasks allowed. The user is requested to enter transactions in a required format such as "MM/DD/YY" for the date of transaction, and the transaction cost cannot be zero. Failure to specify dates in the correct format, or numbers instead of words for the title of the Transaction, will require the user to re-enter the correct information until it is correct in format. A brief description of the program will now be given to demonstrate the operation.

Should the user choose to add items (the first step in the use of the application), the user will have to select the number ``` 2 ``` from the console menu. The console will then require the user to select the type of transaction to enter.

```bash
You chose to add items. Please select from the given options. 

(1) Add expense(s)
(2) Add income(s)

```
Should the user choose to enter an expense, the user will have to press ``` 1 ```.

The user will then be requested to enter further data as follows:

```bash

You chose to add expense(s). Please insert the date in format (MM/DD/YYYY), followed by title (eg. jeans), followed by cost of item.

```
Assuming the user enters the transaction in the correct format, the item will be added to the list of transactions. Should the user desire to edit the information, this can be done on the main welcome menu. Should the user desire to save the information and exit, this can also be selected on the main welcome menu.

## Features

The application can show existing transactions that have been added to the application in previous sessions. This show option allows selection of only income or only expenses, should the user desire it.

The application takes in additional transactions and the user can add to these are desired in multiple sessions or in the same session. Please note that upon initial startup a file must be created and hence the user will be informed of this. The file will be stored in the "Resources/" directory.

The user may also edit and remove transactions when required. The user should specify the task required by selecting the option number that is associated with the task.

The user may furthermore select to terminate and exit the application. The selection to end the session will result in the saving of the session information, such as added and removed transactions. Restarting the application will see the user resume at the point where the previous session ended.

## Class Diagram

![alt text](https://github.com/Flea00012/JavaLoggable/blob/master/Diagrams/Class%20Diagram-final.png)

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

MIT license applied to this project. Please view the link for further details.

![alt text](https://github.com/Flea00012/JavaLoggable/blob/master/LICENSE)

## Disclaimer

This is a refactored project, previously used for logging pets by the developer, and now is used for logging Banking data.
