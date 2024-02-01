class BankAccount(accountNumber: String, accountHolder: String) {
    var balance: Double = 0.0

    fun withdraw(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("Withdraw: $$amount")
        } else {
            println("You can't withdraw $$amount, you have $$balance available")
        }
    }

    fun deposit(amount: Double) {
        balance += amount
        println("Deposit: $$amount")
    }

    fun getBalance() {
        println("Balance: $$balance")
    }
}

fun main() {
    val myAccount = BankAccount("1234", "Jane Doe")
    myAccount.getBalance()
    myAccount.deposit(20.0)
    myAccount.withdraw(50.5)
    myAccount.deposit(100.0)
    myAccount.getBalance()
    myAccount.withdraw(50.5)
    myAccount.getBalance()
}