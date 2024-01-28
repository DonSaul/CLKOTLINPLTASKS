fun main() {
    val myAccount = BankAccount("010101", "rodrigo")

    println(myAccount.accountNumber)
    println(myAccount.accountHolder)
    println(myAccount.getBalance())
    println(myAccount.deposit(1000.0))
    println(myAccount.getBalance())
    println(myAccount.withdraw(1200.0))
    println(myAccount.getBalance())
}

class BankAccount(val accountNumber: String, val accountHolder: String) {

    private var balance: Double = 0.0

    fun withdraw(amount: Double): Double {
        if(amount <= 0) {
            throw Exception("The amount to withdraw must be positive")
        }

        if(amount > balance) {
            throw Exception("Not enough funds to withdraw $$amount")
        }

        balance -= amount
        return balance
    }

    fun deposit(amount: Double): Double {
        if(amount <= 0) {
            throw Exception("The amount to withdraw must be positive")
        }

        balance += amount
        return balance
    }

    fun getBalance(): Double {
        return balance
    }

}