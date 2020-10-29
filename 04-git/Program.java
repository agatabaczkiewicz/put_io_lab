public class MyClass {
  // Static method
  static void myStaticMethod() {
    System.out.println("Niebo jest niebieskie");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Trawa jest zielona");
  }

  // Main method
  public static void main(String[] args) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would compile an error

    MyClass myObj = new MyClass(); // Create an object of MyClass
    myObj.myPublicMethod(); // Call the public method on the object
  }
}