import java.util.ArrayList;

class ArrayListProgram {
  public static void main(String[] args) {
    ArrayList<String> animals = new ArrayList<>();

    animals.add("Cat");
    animals.add("Dog");
    animals.add("Cow");
    System.out.println("ArrayList: " + animals);

    String str = animals.get(1);
    System.out.print("Element at index 1: " + str);
  }
}


