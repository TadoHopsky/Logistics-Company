import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
                pw.println(c.toString());
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }
}
