class BankAccount(
    var accountNumber: String,
    var accountHolder: String,
    private var balance: Double
) {
    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("You withdraw $${amount.toInt()} of your balance")
        } else {
            println("Not enough balance! you need to deposit")
        }
    }

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("You have added: $${amount.toInt()} to your balance")
        }
    }

    fun getBalance(): Double {
        println("Your current balance is: $${balance.toInt()}")
        return balance
    }
}

fun main() {
    val account = BankAccount("Rafael", "30", 210.0)
    account.getBalance()
    account.deposit(300.0)
    account.withdraw(50.0)
    account.getBalance()
}
