package Misc;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;

public class NAry {
   
   private static class Node {
      String val;
      List<Node> children = new ArrayList<Node>();
      
      public Node(String val) {
         this.val = val;
      }
      
      public void addChild(Node child) {
         children.add(child);
      }
   }
   
   public static void serialize(Node n, BufferedOutputStream bos) throws Exception {
      if (n == null)
         return;
      
      String str = n.val;
      serializeInt(str.length(), bos);
      serializeString(str, bos);
      
      if (!n.children.isEmpty()) {
         for (Node child : n.children) {
            // Mark the presence of a child using a byte.
            serializeByte((byte)0x1, bos);
            serialize(child, bos);
         }
      }
      
      // No more child.
      serializeByte((byte) 0x0, bos);
   }
   
   public static Node deserialize(String filepath) throws Exception {
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filepath));
      return deserializeHelper(bis);
   }
   
   private static Node deserializeHelper(BufferedInputStream bis) throws Exception {
      int strLen = deserializeInt(bis);
      String strValue = deserializeString(strLen, bis);
      
      System.out.println("Deserialized: " + strValue);
      
      Node n = new Node(strValue);
      
      while (deserializeByte(bis) != 0) {
         n.addChild(deserializeHelper(bis));
         System.out.println("Added a child to: " + strValue);
      }
      
      System.out.println("No more child for: " + strValue);
      
      return n;
   }
   
   private static void serializeByte(Byte b, BufferedOutputStream bos) throws Exception {
      bos.write(b);
   }
   
   private static Byte deserializeByte(BufferedInputStream bis) throws Exception {
      int val = bis.read();
      
      if (val == -1)
         throw new RuntimeException("No more bytes found when expecting a byte.");
      
      return (byte) val;
   }
   
   private static void serializeInt(int val, BufferedOutputStream bos) throws Exception {
      for (int i=0; i<4; i++) {
         bos.write((byte) ((val & 0xFF000000) >>> 24));
         val = val << 8;
      }
   }
   
   private static int deserializeInt(BufferedInputStream bis) throws Exception {
      int retVal = 0;
      for (int i=0; i<4; i++) {
         retVal = ( retVal << 8 ) | deserializeByte(bis);
      }
      
      return retVal;
   }
   
   private static void serializeString(String str, BufferedOutputStream bos) throws Exception {
      for (char ch : str.toCharArray()) {
         serializeChar(ch, bos);
      }
   }
   
   private static String deserializeString(int len, BufferedInputStream bis) throws Exception {
      StringBuilder strBuilder = new StringBuilder();
      while (len-- > 0) {
         strBuilder.append(deserializeChar(bis));
      }
      
      return strBuilder.toString();
   }
   
   private static void serializeChar(char c, BufferedOutputStream bos) throws Exception {
      bos.write((byte) ((c & 0xFF00) >>> 8));
      bos.write((byte) c & 0x00FF);
   }
   
   private static char deserializeChar(BufferedInputStream bis) throws Exception {
      char c = 0x0;
      c = (char) (c | deserializeByte(bis));
      c = (char) (c << 8 | deserializeByte(bis));
      return c;
   }
   
   public static void main(String args[]) throws Exception {
      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Users/prdhaksh/Documents/Coding/CodingPractice/src/Misc/narytext"));
      
      Node fruits = new Node("fruits");
         Node banana = new Node("banana");
            Node green = new Node("green");
            Node small = new Node("small");
            Node big = new Node("big");
         Node grape = new Node("grape");
            Node white = new Node("white");
               Node seedless = new Node("seedless");
            Node red = new Node("red");
               Node seed = new Node("seed");
         Node guava = new Node("guava");
            Node country = new Node("country");
            Node hybrid = new Node("hybrid");
            
      fruits.addChild(banana);
      fruits.addChild(grape);
      fruits.addChild(guava);
      
      banana.addChild(green);
      banana.addChild(small);
      banana.addChild(big);
      
      grape.addChild(white);
      grape.addChild(red);
      
      white.addChild(seedless);
      red.addChild(seed);
      
      guava.addChild(country);
      guava.addChild(hybrid);
      
      try {
         serialize(fruits, bos);
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         bos.close();
      }
      
      deserialize("C:/Users/prdhaksh/Documents/Coding/CodingPractice/src/Misc/narytext");
   }
}
