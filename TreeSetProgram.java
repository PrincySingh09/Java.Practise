import java.util.TreeSet;

class TreeSetProgram {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);

        System.out.println("Using higher: " + numbers.higher(4));

        System.out.println("Using lower: " + numbers.lower(4));

        System.out.println("Using ceiling: " + numbers.ceiling(4));

        System.out.println("Using floor: " + numbers.floor(3));

    }
}






