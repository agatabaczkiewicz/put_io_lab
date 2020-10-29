public class MyClass {
  // Static method
  static void myStaticMethod() {
    System.out.println("Niebo jest niebieskie");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Trawa jest zielona");
  }

  
  public void myPublicMethod2() {
    System.out.println("gruszka i pietruszka");
  }
  
  
  //komentarz


  // Main method
  public static void main(String[] args) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would compile an error

    MyClass dwaaaa = new MyClass(); // Create an object of MyClass
   // Call the public method on the object
	
  }
}