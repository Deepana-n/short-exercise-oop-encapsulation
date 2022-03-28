# Encapsulation Exercise Solution

##  1. Run the  `main`  method on the  `Main`  class, what is it doing? What is being outputted to the console?

The main() method in the Main class, creates a DodgyBankAccount object and a SecureBankAccount object. Using the objects, it is trying to access the methods within the DodgyBankAccount and SecureBankAccount classes.

#### Console output :
```
--- DODGY BANK ACCOUNT ---

Mmm...I spot a dodgy bank account! Let's make one!
What is my current balance?
Your account balance is 0
Let's deposit an amount of 30
Your account balance is 80
Wow! Looks like we get a reward of 50 when we deposit an amount
Let's be naughty and add rewards without depositing!
Your account balance is 230
Wow! We're rich!
Let's make a lot of money right now! Let's change the account balance directly!
Your account balance is 1000000
😻 Weeeeee!!!!

--- SECURE BANK ACCOUNT ---

Mmm...let's make a secure bank account!
What is my current balance?
Your account balance is 0
Let's deposit an amount of 30
Your account balance is 80
Wow! Looks like we get a reward of 50 when we deposit an amount
Let's be naughty and add rewards without depositing!
Oh no :( It looks like we can't do this - it's too secure!
Your account balance is 80
Let's make a lot of money right now! Let's change the account balance directly!
Oh no :( It looks like we can't do this - it's too secure!
Your account balance is 80
😹 Well I guess that's secure!

Process finished with exit code 0
```

## 2. Look at the  `DodgyBankAccount`, this class is not well-encapsulated. Can you note down the problems with how the class is designed, and the ways it is being misused?

Problem with DodgyBankAccount Class:

- The access modifier of the data members *accountNumber*, *accountBalance* and *rewardAmount* and the method *addReward()* is *public*. It should be *private* - this would prevent direct access of the variables and methods from outside the class.
- The variable *rewardAmount* is also not *final*. This means that its value can be changed from outside the class which is not ideal.

Ways DodgyBankAccount have been misused:

- Since the data members are public, the main() method in the Main class is able to access the *accountBalance* variable in the DodgyBankAccount class and increase the amount of it. However, *accountBalance* should be increased only via the *depositAmount*() method.
- Due to the addReward() method being public, the main() method in the Main class is able to directly add reward to the account. However, rewards should only be added when an amount is deposited into the account. This should only be done in the *depositAmount()* method. However, DodgyBankAccount class is not able to enforce that requirement since it's method is visible and accessible by the Main class.
- The *rewardAmount* variable can be directly accessed from the main() method in the Main class and so the value of the reward which should be constant could be changed from outside the class.

## 3. Compare and contrast the  `DodgyBankAccount`  and the  `SecureBankAccount`, how is the  `SecureBankAccount`different to the  `DodgyBankAccount`? How is it designed to prevent it from being misused? Are there instances of better method names for clearer abstraction?
Differences in SecureBankAccount Class:
- Data members in SecureBankAccount class are all private - this means that it cannot be directly accessed from outside the class.
- The variables *ACCOUNTNUMBER* and *REWARDAMOUNT* are also denoted with the final keyword - this means that the values of these variables cannot change within the class and outside of the class.
- The access modifier of *addReward()* method is denoted as private - this means that the method cannot be accessed from outside the class. The method is only called by the *depositAmount()* method in the SecureBankAccount class;

How is it designed to prevent it from being misused?

SecureBankAccount class is designed using encapsulation principles. Due to this, it is able to prevent unauthorised access to its data members and private methods. SecureBankAccount unlike the DodgyBankAccount,

- Does not allow amount changes to be made to the account balance from outside the class.
- It also does not allow rewards to be added without deposits being made.
- Classes outside of it are also not allowed to change the account number and therefore make unauthorised transactions.
- The only functionality outside of its class is to display the account balance and make deposits. All other functions are done within its class.



Are there instances of better method names for clearer abstraction?

To view the account balance in SecureBankAccount, the method is called *displayAccountBalance()*. The method name clearly states that it is called to display the account balance - a print function. Whereas, in DodgyBankAccount the method to display account balance is called *getAccountBalance()*, one would need to see the details in order to understand the functionality. 
