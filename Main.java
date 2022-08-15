public class Main {
    private static DayOfWeek d;

    public static void main(String[] args) {
        Human child = new Human();
        child.setName("Michael");
        child.setSurname("Karloene");
        child.setYear(20);
        child.setIq(51);
        child.setSchedule(new String[][]{{String.valueOf(d.Monday)}, {Human.tasks[1]}});

        Pet p = new Pet();
        p.setSpecies(String.valueOf(AnimalSpecies.DOG));
        p.setAge(5);
        p.setNickname("wimel");
        p.setTrickLevel(75);
        p.setHabits(new String[]{"eat", "play"});

        Family fmly = new Family();
        Human father = new Human("Vito","Karleone");
        Human mother = new Human("Jane", "Karloane");
        fmly.setMother(mother);
        fmly.setFather(father);
        fmly.setPet(p);
        fmly.setChildren(new Human[]{new Human()});

        Human child1 = new Human("Allahverdi", "Hajiyev");
        Human child2 = new Human("Allahverdi2", "Hajiyev2");
        Human child3 = new Human("Allahverdi3", "Hajiyev3");
        fmly.countFamily();
        System.out.println("");
        fmly.addChild(child1);
        fmly.countFamily();
        System.out.println("");
        fmly.addChild(child2);
        fmly.countFamily();
        System.out.println("");
        fmly.addChild(child3);
        fmly.countFamily();
        System.out.println("");


        fmly.countFamily();
        System.out.println("");
        fmly.deleteChild(child2);
        fmly.countFamily();
        System.out.println("");
        fmly.deleteChild(1);
        fmly.countFamily();
    }
}