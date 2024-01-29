class BankAccount(
    val accountNumber: String,
    val accountHolder: String,
    private var balance: Double
) {
    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrawal of $amount successful. New balance: $balance")
        } else {
            println("Insufficient funds for withdrawal.")
        }
    }

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposit of $amount successful. New balance: $balance")
        } else {
            println("Invalid deposit amount.")
        }
    }

    fun getAccountBalance(): Double {
        return balance
    }
}

fun main() {
    // Example usage
    val account = BankAccount("2343255", "Gabriel Urbina", 20000.0)

    println("Account Holder: ${account.accountHolder}")
    println("Account Number: ${account.accountNumber}")
    println("Initial Balance: ${account.getAccountBalance()}")

    account.deposit(5030.0)
    account.withdraw(2040.0)
    account.withdraw(150000.0) // This should fail due to insufficient funds

    println("Final Balance: ${account.getAccountBalance()}")
}