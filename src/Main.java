import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShippingCalculator sc = new ShippingCalculator();
        sc.getFirstInfoForUser();

        while (true){
            try{
                double cargo = sc.getCargoFromUser(scanner);
                double distance = sc.getDistanceFromUser(scanner);

                if(cargo <= 0 || distance <= 0){
                    System.err.println("Ошибка: данные должны быть положительными");
                    continue;
                }
                Cargo cargoModel = new Cargo(cargo, distance);

                System.out.println("Расчет для " + cargoModel + ": " + sc.calculatePrice(cargoModel));
            }catch (NumberFormatException e){
                System.err.println("Ошибка вода от пользователя\nОжидается число\n" + e);
            }

            System.out.println("Хотите рассчитать еще одну доставку? (yes/no)");
            String userInput = scanner.nextLine();

            if(!userInput.equalsIgnoreCase("yes")){
                break;
            }
        }
        scanner.close();
    }
}

/// Твой план на Day 4 (Углубляемся в Коллекции)
/// Давай реализуем ту самую статистику, о которой я говорил. Клиент хочет видеть "итого" в конце сессии.
/// Что нужно сделать:
/// Список в Main:
/// Добавь List<Cargo> history = new ArrayList<>(); перед началом цикла while.
/// Накопление данных:
/// Внутри цикла, после того как ты вывел цену на экран, добавь объект в историю: history.add(cargoModel);.
/// Финальный аккорд (после выхода из цикла):
/// Когда юзер нажал no, выведи красивый отчет:
/// Используй for-each, чтобы вывести все грузы из history.
/// Посчитай общую сумму (тебе придется еще раз прогнать список через sc.calculatePrice).
/// Выведи количество оформленных доставок.
/// Небольшой вызов (Advanced):
/// Сможешь сделать так, чтобы в конце выводилась еще и средняя стоимость одной доставки? (Сумма / Количество).
/// Жду обновленный код с импортом java.util.List и java.util.ArrayList.
/// Как думаешь, стоит ли нам добавить в класс Cargo поле calculatedPrice, чтобы не пересчитывать её заново в конце программы?
