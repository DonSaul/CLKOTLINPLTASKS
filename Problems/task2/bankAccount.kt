class BankAccount(
    val accountHolder: String, 
    val accountNumber: String, 
    private var balance: Double,){
        
    fun withdraw(amount: Double): Double  {
        if (this.balance >= amount) {
            this.balance -= amount
            println("Whitdrawn: $amount")
            return amount
        } else {
            println("Not enough balance to withdraw $$amount")
            return 0.0
        }
    }

    fun deposit(amount: Double) {
        this.balance += amount
        println("Added $$amount")
    }
    
    fun getBalance(): Double { 
        println("Current balance: $${this.balance}")
        return this.balance 
    }
}

fun main() {
    val myAccount: BankAccount = BankAccount("Saul", "42", 100.0)
    myAccount.getBalance()
    myAccount.withdraw(42.5)
    myAccount.deposit(22.0)
    myAccount.getBalance()
}