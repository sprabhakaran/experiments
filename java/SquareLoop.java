import turtles.*;

public class DrawSquareLoop extends TurtleProgram {
   public void run() {
      double sideLength;
      sideLength = this.readDouble();

      Turtle boxTurtle;
      boxTurtle = new Turtle(100 - sideLength / 2, 100 - sideLength / 2);
      int drawn; // counts how many sides are complete
      drawn = 0; // so far none are complete
      while(drawn < 4) {
         boxTurtle.forward(sideLength);
         drawn = drawn + 1; // we've completed one more side
         boxTurtle.right(90);
      }
      boxTurtle.hide();
   }
}
