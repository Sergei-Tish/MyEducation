//копипаста для изучения SF_Mod270604_Strategy

public class StrategyRunner {
    public static void main(String[] args) {
        // создаем контекст
        Context context = new Context();

        context.setStrategy(new FirstStrategy());//назначаем контексту конкретную стратегию
        context.executeStrategy("Запускаем стратегию");// запускам стратегию

        context.setStrategy(new SecondStrategy());//назначаем контексту другую конкретную стратегию
        context.executeStrategy("Запускаем стратегию");// запускам стратегию
    }
}

//Абстрактная стратегия
interface Strategy{
    void run(String string);// определяем метод, который будет вызывать конкретный алгоритм (стратегию)
}
//Первая стратегия
class FirstStrategy implements Strategy{
    @Override
    public void run(String string) { // переопределяем метод run()
        System.out.println("Первый вариант решения "+ string);
        // здесь ещё код с алгоритмом...
    }
}
//Вторая стратегия
class SecondStrategy implements Strategy{
    @Override
    public void run(String string) { // переопределяем метод run()
        System.out.println("Второй вариант решения "+ string);
        // здесь ещё код с алгоритмом...
    }
}
//Класс контекста, работает со стратегиями через общий интерфейс
class Context{
    private Strategy strategy; // ссылка на общий интерфейс
    void setStrategy(Strategy strategy){
        this.strategy=strategy;// сеттер стратегии
    }
    void executeStrategy(String string){
        strategy.run(string);// вызываем стратегию
    }
}
