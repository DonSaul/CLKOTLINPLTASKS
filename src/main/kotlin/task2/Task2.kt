package task2

fun main() {
    println("Task2")

    val account=BankAccount("123","Edgar",10000.0)

    account.getBalance()

    account.withdraw(10001.0)

    account.withdraw(5000.0)

    account.deposit(1000.0)

    account.getBalance()

    //Characters
    println("RPG:")
    val rat= Character("Rat",10,1)
    val wizard= Wizard("Wizard",25,2,50)

    wizard.attack(rat)
    rat.attack(wizard)

    //println(wizard.name)




}