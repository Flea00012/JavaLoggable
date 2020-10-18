# JavaLoggable  

A banking application for logging transactions through the console written in Java

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

The user can select one of these numbers and navigate to the desired options to achieve the tasks allowed. The user is requested to enter transactions in a required format such as "DD/MM/YY" for the date of transaction, and the transaction cost cannot be zero. Failure to specify this correctly will terminate the session.

## Features

The application can show existing transactions that have been added to the application in previous sessions. This show option allows selection of only income or only expenses, should the user desire it.

The application takes in additional transactions and the user can add to these are desired in multiple sessions or in the same session. Please note that upon initial startup a file must be created and hence the user will be informed of this. The file will be stored in the "Resources/" directory.

The user may also edit and remove transactions when required. The user should specify the task required by selecting the option number that is associated with the task.

The user may furthermore select to terminate and exit the application. The selection to end the session will result in the saving of the session information, such as added and removed transactions. Restarting the application will see the user resume at the point where the previous session ended.

## Use Case Diagram

![alt text](https://github.com/Flea00012/JavaLoggable/blob/master/Diagrams/BankApp%20(1).pdf)

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

MIT

## Disclaimer

This is a refactored project, previously used for logging pets by the developer, and now is used for logging Banking data.
