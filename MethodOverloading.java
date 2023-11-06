class AreaOverload {

  //area of a rectangle
  public float area(float length, float width) {
    return (length * width);
  }

  // area of a circle
  public float area(float radius) {
    return (float) (radius * radius * 3.14);
  }
}

public class Test {

  public static void main(String args[]) {
    AreaOverload a = new AreaOverload();

    System.out.println("Area of rectangle: " + a.area(1.5f, 3.6f));
    System.out.println("Area of circle: " + a.area(2.5f));
  }
}
