import java.util.*;
public class SentenceSort{
  public static void main(String[] args)
{
  String ip="Givi3ng I1 a2m 5Test Deloi4tte";
    System.out.println("Input String Before Filter:"+ip);

  System.out.printl(arrangesent(ip));
}
  public static String arrangesent(String a)
  {
    String[] words=a.split("");
    String[] op=new String[words.length];
    for(String word : words)
      {
        int position =-1;
        StringBuilder newword= new StringBuilder();
        for(char ch : word.toCharArray())
          {
            if(Character.isDigit(ch))
            {
              position= ch-'0';
            }
            else{
              newword.append(ch);
            }
          }
        op[position -1]= newword.toString();
      }
    return String.join(" ", op);
  }
}
