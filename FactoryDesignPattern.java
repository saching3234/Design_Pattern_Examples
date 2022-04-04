import java.util.Scanner;

//interface to implement
interface MyWrapper {
 public void printType();
}


//classes implementing the above interface

class MyInteger implements MyWrapper{

  @Override
  public void printType() {
      System.out.println("The value is of type: MyInteger");
      
  }
  
}

class MyDouble implements MyWrapper{

  @Override
  public void printType() {
      System.out.println("The value is of type: MyDouble");
      
  }
  
}

class MyBoolean implements MyWrapper{

  @Override
  public void printType() {
      System.out.println("The value is of type: MyBoolean");
      
  }
  
}

class MyCharacter implements MyWrapper{

  @Override
  public void printType() {
      System.out.println("The value is of type: MyCharacter");
      
  }
  
}

//factory class for creating the object
class MyFactory{

  public MyWrapper createWrapper(String s){
	  //checking for boolean
       if(s.equalsIgnoreCase("true")||s.equalsIgnoreCase("false"))
      return new MyBoolean();
      
      //checking for character 
      else if(s.length()==1&&Character.isLetter(s.charAt(0)))
      return new MyCharacter();

      //checking for Integer
      else if(checkInteger(s))
      return new MyInteger();
      
       //checking for double
      else if(Character.isDigit(s.charAt(0))&&Character.isDigit(s.charAt(s.length()-1))&&checkDuble(s))
      return new MyDouble();

      //Throwing the exception
      else
      throw new IllegalArgumentException("Unknown data type: " +s);
  }

  //checking Integer string
  public  boolean checkInteger(String s){
	   try {
    	   int d=Integer.parseInt(s);
    	   return true;
      }catch(Exception e)  {
    	  return false;
      }
  }

 //checking double string
  public  boolean checkDuble(String s){        
      try {
    	   Double d=Double.parseDouble(s);
    	   return true;
      }catch(Exception e)  {  	  return false;}
      
  }
}



class FactoryDesignPatter{
  //main method
  public static void main(String[] args) {
  //creating the factory object
  MyFactory f=new MyFactory();

  try{
   //getting the object from factory asper the data type provided 
	  Scanner sc=new Scanner(System.in);	 
	  System.out.println("Enter The some text to chech the data type :\n");
	  String s=sc.nextLine();
      MyWrapper mw=f.createWrapper(s);
      //calling the print type method
      mw.printType();
      }catch(Exception ex)
       {
        System.out.println("Exception : "+ex.toString());
         }
  }

}
