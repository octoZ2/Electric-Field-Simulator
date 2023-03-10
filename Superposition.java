import java.util.*;

public class Superposition{


public static final double testCharge = 1; 
/* The test charge is located at (0.5,0.5,0.5) and has a charge of positive 1. 
   Since the test charge is 1 this value will be equivalent to the electric field at (0.5,0.5,0.5). 
*/
public static final double k = 8.99 * Math.pow(10,9);
public static final double sumX = 0;
public static final double sumY = 0;
public static final double sumZ = 0;

   public static void main(String[] args) {
   
   System.out.println(generateField());
      
      
         
   }
   
   public static String generateField() {         // This method will create a forloop to generate 1000 point charges and then call the add methods to add them up. 
   double newX = 0;                              
   double newY = 0;                               // Setting these values to 0 allows me to make a cumulative algorithm and add all of the x,y,z vector components in the forloop.
   double newZ = 0;
   
      for (int i = 1; i <= 1000; i++) {
         
  /* Math.random() generates a random real number between 0 and 1, so by setting the cube's boundries as x = 1, y = 1, z = 1 and defining a test 
     charge at the center of the cube (0.5,0.5,0.5) with test charge positive 1 (this is so the value is equal to the electric field), I can generate
     random point charges within the boundries using the Math.random() function. */
     
         double x = Math.random();
         double y = Math.random();        
         double z = Math.random();
         double q = Math.round(10*Math.random());
         if (Math.random() > 0.5) {                  // This conditional statement allows the source charge q to be negative 50% of the time to make the distribution of point charges truly random. 
            q = -1 * q;
         }
         else if (Math.random() < 0.5) {
            q = q;
         }
         
         double addVectorsX = addX(x,y,z,q);
         double addVectorsY = addY(x,y,z,q);
         double addVectorsZ = addZ(x,y,z,q);
         
         newX = sumX + addVectorsX;
         newY = sumY + addVectorsY;                 
         newZ = sumZ + addVectorsZ;
         
         /* 
            These terms are generated by the cumalitive algorithm so each time a new point charge is created by the forloop it's electric field vector is added to all of the previous points.
         */
         
         
         
         
      }
      return (newX + "i + " + newY + "j + " + newZ + "k"); // Since the point charges are randomly generated within the cube the electric field will come out to be pretty large. 
      
      /* 
         This return value returns a vector with the x,y,z components being the superposition of the electric field vectors from all of the point
         charges evaluated on the center of the cube (0.5,0.5,0.5). 
      */
   }
   
   public static double addX(double x, double y, double z, double q) {
      double rSquared = Math.pow(0.5-x,2) + Math.pow(0.5-y,2) + Math.pow(0.5-z,2);         // These methods use Coulomb's Law to add up the electric field vectors. 
      double r = Math.pow(rSquared, 0.5);                                                  // Here I am taking the square root of r squared, this has nothing to do with the center point being at (0.5,0.5,0.5). 
      double vectComponentScalar = (k*testCharge*q)/(rSquared);
      double vectAdd = (1/r)*x;                                                           //  This line finds r-hat by multiplying the x component by 1/sqrt(r). 
      double vectX = vectComponentScalar*vectAdd;                                         //  The final answer is r-hat multiplied by the "Coulombs law" coefficient. 
      
      return vectX;
   }
      /* 
         The following methods are identical to the previous method but for the y and z components
         of the electric field vectors.
         
      */
   
   public static double addY(double x, double y, double z, double q) {
      double rSquared = Math.pow(0.5-x,2) + Math.pow(0.5-y,2) + Math.pow(0.5-z,2);  // This method adds up the y components, with the vector form of coloumbs law. 
      double r = Math.pow(rSquared, 0.5);
      double vectComponentScalar = (k*testCharge*q)/(rSquared);
      double vectAdd = (1/r)*y;
      double vectY = vectComponentScalar*vectAdd;
      
      
      return vectY;
   }
   
   public static double addZ(double x, double y, double z, double q) {
      double rSquared = Math.pow(0.5-x,2) + Math.pow(0.5-y,2) + Math.pow(0.5-z,2);  // This method adds up the z components. 
      double r = Math.pow(rSquared, 0.5);
      double vectComponentScalar = (k*testCharge*q)/(rSquared);
      double vectAdd = (1/r)*z;
      double vectZ = vectComponentScalar*vectAdd;
      
      
      return vectZ;
   }
      
}