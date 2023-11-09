import java.util.*; 
public class ListProgram {
  public static void main(String[] args) 
      { 
          String[] message = {"Welcome", "to", "Genpact"};
          List<String> messageList = Arrays.asList(message);
          System.out.println(messageList);

          List<String> myMessage = new ArrayList<>();
          for(String s:messageList){
              myMessage.add(s);
          }
          System.out.println(myMessage);
          myMessage.clear();
      } 
  }  
