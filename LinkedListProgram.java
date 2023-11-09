import java.util.LinkedList;

class LinkedListProgram {
  public static void main(String[] args) {
    LinkedList<String> languages = new LinkedList<>();

    languages.add("Java");
    languages.add("Python");
    languages.add("JavaScript");
    languages.add("CPP");
    System.out.println("LinkedList: " + languages);

    String str = languages.remove(1);
    System.out.println("Removed Element: " + str);

    System.out.println("Updated LinkedList: " + languages);
  }
}



