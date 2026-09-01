public class ReferenceLab {

    public static void main(String[] args) throws InvalidCreatureException {

        // ==================================================
        // EXPERIMENT A: ALIASING
        // ==================================================

        SeaCreature nemo = new Fish("Nemo", 5, 3, 1, "><>");
        SeaCreature copy = nemo;

        // PREDICT BEFORE RUNNING:
        // What will copy.getPosition() return after nemo.setPosition(25)?
        //copy.getPosition() will return 25, the same value as the position of the
        // nemo object. This is because it is an alias and refers to the same place in memory. 
        nemo.setPosition(25);

        System.out.println("Experiment A - Aliasing");
        System.out.println("nemo position: " + nemo.getPosition());
        System.out.println("copy position: " + copy.getPosition());


        // ==================================================
        // EXPERIMENT B: TWO DIFFERENT OBJECTS
        // ==================================================

        SeaCreature fish1 = new Fish("Fish", 10, 2, 1, "><>");
        SeaCreature fish2 = new Fish("Fish", 10, 2, 1, "><>");

        // PREDICT BEFORE RUNNING:
        // Will fish1 == fish2 be true or false?
        //fish1== fish2 will return a false value. This is because both objects were instantiated
        //as new objects, meaning they point to different memory locations no matter if their attributes
        //are equivalent. These memory locations will not be equal and therefore the statement will return false.

        System.out.println();
        System.out.println("Experiment B - Separate Objects");
        System.out.println("fish1 == fish2: " + (fish1 == fish2));


        // ==================================================
        // EXPERIMENT C: ARRAY REFERENCES
        // ==================================================

        SeaCreature[] tank = new SeaCreature[5];
        tank[0] = new Fish("Bubbles", 8, 1, 1, "><((('>");

        SeaCreature selected = tank[0];

        // PREDICT BEFORE RUNNING:
        // What happens to tank[0] if selected is modified?
        //If selected is modified, the value of tank[0] will also be modified. Because the selected variable was
        //created as a reference to the tank object, they both point to the same tank[0] object. This means if one of them is changed, 
        //the other will follow in suit as they reference the same value in memory. 
        selected.setPosition(35);

        System.out.println();
        System.out.println("Experiment C - Array References");
        System.out.println("selected position: " + selected.getPosition());
        System.out.println("tank[0] position: " + tank[0].getPosition());
    }
}
