fun main(args: Array<String>) {
    val wordString = "Rose kivuva ndunge"           //QN.1
    val result = randomString(wordString)
    println("First character: ${result.first}")
    println("Last character: ${result.second}")
    println("Length: ${result.third}")

    val password="rose6w7kivuva"                    //QN.2
    val valid = isValidPassword(password)
    println("is $password valid? :  it is $valid")

    val detail=CurrentAccount("Rose Kivuva", "43457485646", 20000.00)  //QN.3
    detail.deposit(300.00)
    detail.withdraw(1000.00)
    detail.details()

    val moreDetails=savingAccount("Mumo kaka", "53267236", 100000.00) //QN.4
    moreDetails.deposit(604743.00)
    moreDetails.withdraw(4356.00)
    moreDetails.details()

    longestString(arrayOf("Ityaku", "Clever", "Reddiet", "MumoMjera"))
}
//1.Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not. (6pts)
fun randomString(word: String): Triple<Char, Char, Int> {
    val firstChar = word.first()
    val lastChar = word.last()
    val length = word.length
    val beginsWithVowel = word.first().let { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }

    return Triple(firstChar, lastChar, length)
}

//2.Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//1. Must be at least 8 characters long
//2. Must be at most 16 characters long
//3. Must not be “password”
//4. Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false (7pts)


fun isValidPassword(password:String):Boolean{
    if(password.length <8 || password.length>16 ||password =="password"){
        return false
    }
    var hasNums=false
    for(char in password){
        if(char.isDigit()){
            hasNums=true
            break
        }
    }
    return hasNums
}

//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z” (6

data class CurrentAccount(var accountName:String, var accountNumber:String, var balance:Double ){
    open  fun deposit(amount: Double):Double{
        balance+=amount
        return balance

    }

    fun withdraw(amount: Double):Double{
        balance-=amount
        return balance
    }
    open  fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}

//Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal (6pts)

class savingAccount(var accountName:String, var accountNumber:String, var balance:Double ,val withdrawals:Int = 0 ){
     fun deposit(amount: Double):Double {
         balance += amount
         return balance
     }
     fun withdraw(amount: Double){
         if(withdrawals<4){
             balance -=amount
         }
         else{
             println("Sorry, you have exceeded the maximum number of withdrawals")
         }

     }
    fun details(){
        println("Account number $accountNumber owned by $accountName with balance $balance is open")
    }
}


//Write a function that accepts an array of strings and returns the longest string in the array.
fun longestString(names:Array<String>){
    val longW=names.maxByOrNull { it.length } //lamda {it.length} defines the lentgth of each word
    println(longW)
}




















