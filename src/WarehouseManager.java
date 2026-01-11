import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WarehouseManager {

    private List<Cargo> inventory = new ArrayList<>();

    public void addCargo(Cargo cargo){
        inventory.add(cargo);
        System.out.println("Груз успешно добавлен на склад!");
    }

    public void showAllCargo(){
        if(inventory.isEmpty()){
            System.out.println("На складе пока пусто.");
        } else {
            System.out.println("--- Список грузов на складе ---");
            for(Cargo c : inventory){
                System.out.println(c);
            }
        }
    }

    public void saveToFile(){
        String fileName = "inventory.txt";

        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            for(Cargo c : inventory){
                pw.println(c.getWeight() + "," + c.getDistance() + "," + c.getDeliveryType());
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    public void loadFromFile(){
        String inventoryFileName = "inventory.txt";
        File file = new File("inventory.txt");
        if(!file.exists()){
            System.out.println("Файл базы данных не найден. Начинаем с чистого листа.");
            return;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(inventoryFileName))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] part = line.split(",");

                Cargo cargo = new Cargo(Double.parseDouble(part[0]),
                        Double.parseDouble(part[1]),
                        DeliveryType.valueOf(part[2]));

                inventory.add(cargo);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public void findHeavyCargo(double threshold){
        System.out.println("--- Грузы выше указанного порога ---");
        for(Cargo c : inventory){
            if(c.getWeight() > threshold){
                System.out.println(c);
            }
        }
    }

    public void clearInventory(){
        inventory.clear();
    }
}
