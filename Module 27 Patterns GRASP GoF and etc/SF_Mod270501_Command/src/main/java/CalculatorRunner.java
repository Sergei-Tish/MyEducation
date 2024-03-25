// клиент, который будет работать с калькулятором через объекты команд
public class CalculatorRunner{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();// создаем калькулятор
        // создаем приемник команд
        //в качестве параметров передаем новые объекты-команды
        CalculatorInvoker calculatorInvoker = new CalculatorInvoker(
                new AdditionCommand(calculator),// в качестве параметра передаем объект калькулятора
                new SubstractionCommand(calculator)// в качестве параметра передаем объект калькулятора
        );

        calculatorInvoker.getSum(20, 30);// выводим сумму чисел
        calculatorInvoker.getDifference(10, 20);// выводим разность чисел
    }
}

// На схеме обозначен Receiver. Реализуем 2 метода, которые будут выводить на экран сумму и разность двух чисел.
class Calculator {
    public void addition(int a, int b){
        System.out.println(a + b);
    }
    public void substraction(int a, int b){
        System.out.println(a - b);
    }
}
// Создадим общий интерфейс для команд. На схеме - Command. Содержит единственный метод execute().
interface CalculatorCommand{
    void execute(int a, int b);
}
// AdditionCommand и SubstractionCommand конкретные реализации интерфейса CalculatorCommand.
class AdditionCommand implements CalculatorCommand{
    private Calculator calculator;// Ссылка на класс калькулятора
    // конструктор с параметром Calculator
    public AdditionCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override //Переопределяем execute()
    public void execute(int a, int b) {
        calculator.addition(a, b);// вызываем addition() у калькулятора
    }
}
class SubstractionCommand implements CalculatorCommand {
    private Calculator calculator;
    // конструктор с параметром Calculator
    public SubstractionCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override //Переопределяем execute()
    public void execute(int a, int b) {
        calculator.substraction(a, b);// вызываем substraction() у калькулятора
    }
}
// Создаем приемник команд
class CalculatorInvoker{
    private CalculatorCommand addition; // Ссылка на интерфейс CalculatorCommand
    private CalculatorCommand substraction; // Ссылка на интерфейс CalculatorCommand
    // конструктор с параметрами
    public CalculatorInvoker(CalculatorCommand addition, CalculatorCommand substraction) {
        this.addition = addition;
        this.substraction = substraction;
    }
    // считаем сумму
    public void getSum(int a, int b){
        addition.execute(a, b);// Вызываем execute(a, b) у реализации интерфейса CalculatorCommand
    };
    // считаем разность
    public void getDifference(int a, int b){
        substraction.execute(a, b);// Вызываем execute(a, b) у реализации интерфейса CalculatorCommand
    }
}
