package task2

class BankAccount (
    val accountNumber:String,
    val accountHolder:String,
    private var balance:Double,
) {



    fun withdraw(amount:Double){

        if (balance>=amount){
            balance-=amount
            println("Withdraw sucessful, current balance:$$balance")

        }else{
            println("Not enough balance.")
        }

    }

    fun deposit(amount: Double){
        balance+=amount
        println("Deposited $$amount, current balance:$$balance")
    }

    fun getBalance():Double{
        println("Current balance:$$balance")
        return balance

    }


}