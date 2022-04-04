//interface to implement
interface MyWrapper {
   public void printType();
}

// class implementing the interface
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

//factory class for creating the object of classes
class MyFactory{

    public MyWrapper createWrapper(String s){
         if(s.equalsIgnoreCase("true")||s.equalsIgnoreCase("false"))
        return new MyBoolean();
        
        else if(s.length()==1&&Character.isLetter(s.charAt(0)))
        return new MyCharacter();


        else if(checkDigit(s))
        return new MyInteger();
        
        else if(Character.isDigit(s.charAt(0))&&Character.isDigit(s.charAt(s.length()-1))&&checkDuble(s))
        return new MyDouble();

        else
        throw new IllegalArgumentException("Unknown data type: " +s);
    }

    //checking digits
    public  boolean checkDigit(String s){
        //checking for all digits
        for(int i=0;i<s.length();i++)
          if(!Character.isDigit(s.charAt(i)))
          return false;

          return true;
    }

   //checking double
    public  boolean checkDuble(String s){        
        for(int i=0;i<s.length();i++)
          if(!(Character.isDigit(s.charAt(i))||s.charAt(i)=='.'))
          return false;
          
          return true;
    }
}



class FactoryDesignPatter{
    //main method
public static void main(String[] args) {
    //creating the factory object
    MyFactory f=new MyFactory();

    try{
     //getting the object from factory asper the data type provided   
    MyWrapper mw=f.createWrapper("k");
    //caalling the print type method
    mw.printType();
    }catch(Exception ex)
      {
          System.out.println("Exception : "+ex.toString());
      }
  }

}
