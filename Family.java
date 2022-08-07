import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Family extends Human {
    private static DayOfWeek d;
    private static AnimalSpecies species;
    public Family(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        super(name, surname, year, mother, father);
    }
    static Pet p = new Pet();

    static ArrayList<Human> parents = new ArrayList<>();
    static ArrayList<Human> children = new ArrayList<>();
    static ArrayList<Pet> pets = new ArrayList<>();

    public Family(String name, String surname, int year, int iq, Human mother, Human father, String[][] schedule) {
        super();
    }

    public Family() {

    }

    public static void main(String[] args){
        Human mother = new Family();
        Human father = new Family();
        Human child = new Family();

        mother.setName("Tito");
        mother.setSurname("Karleone");
        mother.setYear(1960);
        mother.setIq(60);
        mother.setPet(new Pet());
        mother.setFather(new Human("Allahverdi", "Hajiyev"));
        mother.setMother(new Human("Allahverdi", "Hajiyev"));
        mother.setSchedule(new String[][]{{String.valueOf(d.Sunday)}, {Human.tasks[0]}});


        father.setName("Vito");
        father.setSurname("Karleone");
        father.setYear(1970);
        father.setIq(70);
        father.setPet(new Pet());
        father.setFather(new Human("Allahverdi", "Hajiyev"));
        father.setMother(new Human("Allahverdi", "Hajiyev"));
        father.setSchedule(new String[][]{{String.valueOf(d.Thursday)}, {Human.tasks[4]}});

        child.setName("Michael");
        child.setSurname("Karleone");
        child.setYear(1990);
        child.setIq(50);
        child.setPet(new Pet());
        child.setFather(new Human(father.getName(), father.getSurname()));
        child.setMother(new Human(mother.getName(), mother.getSurname()));
        child.setSchedule(new String[][]{{String.valueOf(d.Saturday)}, {Human.tasks[6]}});

        parents.add(new Family(mother.getName(), mother.getSurname(), mother.getYear(), mother.getIq(), mother.getMother(),mother.getFather(), mother.getSchedule()));
        parents.add(new Family(father.getName(), father.getSurname(), father.getYear(), father.getIq(), father.getMother(),father.getFather(), father.getSchedule()));
        children.add(new Family(child.getName(), child.getSurname(), child.getYear(), child.getIq(), child.getMother(),child.getFather(), child.getSchedule()));

        p.setAge(20);
        p.setNickname("wimel");
        p.setTrickLevel(80);
        p.setSpecies(String.valueOf(species.DOG));

        pets.add(new Pet(p.getSpecies(),p.getNickname(),p.getAge(),p.getTrickLevel(), new String[]{"eat", "drink", "sleep"}));

        HashMap<Integer, ArrayList<Human>> family = new HashMap<>();
        family.put(1, parents);
        family.put(2, children);
        // family.put(3, pets);

        System.out.println("number of children in the family: " + children.size());
        System.out.println("Add new child to the family");
        addChild(new Human("","",0, new Human("",""), new Human("","")));
        System.out.println("number of children in the family: " + children.size());

        // System.out.println("number of family member: " + (parents.size() + children.size()));

        countFamily(family);

        System.out.println(child.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
    }

    public static Human addChild(Human ch) {
        ch.setName("Child name");
        ch.setSurname("Child surname");
        ch.setYear(2000);
        ch.setIq(80);
        ch.setPet(pets.get(0));
        ch.setSchedule(new String[][]{{String.valueOf(d.Monday)}, {Human.tasks[1]}});

        ch = new Family(ch.getName(),
                        ch.getSurname(),
                        ch.getYear(),
                        ch.getIq(),
                        ch.getPet(),
                        new Human("Vito", "Karleone"),
                        new Human("Tito", "Karleone"),
                        ch.getSchedule());

        children.add(ch);
        System.out.println("Child was added");
        System.out.println(children.get(1).toString());
        return ch;
    }

    public static void deleteChild(int position) {
        children.remove(position);
        System.out.println(position + "th child was removed from family");
    }

    public static void countFamily(Map<Integer, ArrayList<Human>> fm) {
        System.out.println("number of family member: " + (fm.get(1).size() + fm.get(2).size()));
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() method was here :)");
    }
}