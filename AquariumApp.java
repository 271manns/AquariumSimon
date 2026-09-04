import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class AquariumApp {

    public static void main(String[] args) throws InvalidCreatureException, FileNotFoundException {

        ArrayList<SeaCreature> tank = new ArrayList<SeaCreature>();
        try{
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            return;
        }
        try
        {
            Scanner sc = new Scanner(new File("Input.txt"));

            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }

                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                String type = lineScanner.next();
                String name = lineScanner.next();
                if ("null".equalsIgnoreCase(name)) {
                    name = null;
                }
                int position = lineScanner.nextInt();
                int speed = lineScanner.nextInt();
                int direction = lineScanner.nextInt();
                String pattern = lineScanner.next();

                if (type.equals("Fish")) {
                    tank.add(new Fish(name, position, speed, direction, pattern));
                } else if (type.equals("Shark")) {
                    tank.add(new Shark(name, position, speed, direction, pattern));
                } else if (type.equals("Crab")) {
                    tank.add(new Crab(name, position, speed, direction, pattern));
                } else {
                    throw new InvalidCreatureException("Unknown creature type: " + type);
                }

                lineScanner.close();
            }

    
        }catch(InvalidCreatureException e) {
            System.out.println("Invalid creature in input file: " + e.getMessage());
            return;
        }
       
        
        
        // =====================================================
        
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);

        Aquarium aquarium1 = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium1.display();
                    break;

                case "2":
                    aquarium1.advanceTurn();
                    aquarium1.display();
                    break;

                case "3":
                    aquarium1.listCreatureDetails();
                    break;

                case "4":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;
                case "5":
                    aquarium1.feed();
                    break;


                default:
                    System.out.println("Please choose 1, 2, 3, 4, or 5.");
            }
        }

    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. View Creature Details");
        System.out.println("4. Quit");
        System.out.println("5. Feed Fish");
    }
}
