class BankAccount(
    val accountNumber: String,
    val accountHolder: String,
    private var balance: Double
) {
    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Your withdrawal was succesfully. Current balance: $balance.")
        } else {
            println("Insufficient funds.")
        }
    }

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Your deposit was succesfully. Current balance: $balance.")
        } else {
            println("Invalid deposit.")
        }
    }

    fun getAccountBalance(): Double {
        return balance
    }
}

fun main() {
    val account = BankAccount("0334034", "Thorin Oakenshield", 1231231.0)

    println("Account Holder: ${account.accountHolder}")
    println("Account Number: ${account.accountNumber}")
    println("Initial Balance: ${account.getAccountBalance()}")

    account.deposit(321123.0)
    account.withdraw(54390.0)
    account.withdraw(134500.0)

    println("Final Balance: ${account.getAccountBalance()}")
}