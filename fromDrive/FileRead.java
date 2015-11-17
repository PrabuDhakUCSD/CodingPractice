package Misc;

import java.io.*;

public class FileRead {
   public static void readAllLines(String fileFullPath) {
      try {
         BufferedReader br = new BufferedReader(new FileReader(fileFullPath));
         String line;
         
         while((line = br.readLine())!= null) {
            System.out.println(line);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void writeAllLines(String[] lines, String fileFullPath) {
      
      BufferedWriter bw;
      try {
         bw = new BufferedWriter(new FileWriter(fileFullPath));
         for(String s : lines) {
            bw.write(s + "\r\n");
         }
         
         bw.flush();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void writeInt(int n, BufferedOutputStream bos) throws Exception {
      for (int i=0; i<4; i++) {
         bos.write((n>>(i*8)) & 0xFF);
      }
   }
   
   public static void writeChar(char c, BufferedOutputStream bos) throws Exception {
      bos.write(c & 0xFF);
      bos.write((c >> 8) & 0xFF);
   }
   
   public static int readInt(BufferedInputStream bis) throws Exception {
      int n = 0;
      for (int i=0; i<4; i++) {
         n = n | (bis.read() << (i*8));
      }
      return n;
   }
   
   public static char readChar(BufferedInputStream bis) throws Exception {
      char c = 0;
      c = (char) (c | bis.read());
      c = (char) (c | (bis.read() << 8));
      
      return c;
   }
   
   public static void main(String args[]) throws Exception {
      String[] input =  {
                           "This is line one.",
                           "A quick brown fox jumped over the bush",
                           "This is supposed to be line three"
                        };
      
      String fileFullPath = "C:\\Users\\prdhaksh\\Documents\\Coding\\CodingPractice\\src\\Misc\\testfiles\\filereadwrite.txt";
      writeAllLines(input, fileFullPath);
      readAllLines(fileFullPath);
      
      fileFullPath = "C:\\Users\\prdhaksh\\Documents\\Coding\\CodingPractice\\src\\Misc\\testfiles\\fileintchar.txt";
      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileFullPath));
      
      writeInt(353, bos);
      writeInt(20, bos);
      writeChar('f', bos);
      writeChar('o', bos);
      writeChar('o', bos);
      writeInt(100, bos);
      
      bos.flush();
      bos.close();
      
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileFullPath));
      int n = readInt(bis);
      System.out.println(n);
      n = readInt(bis);
      System.out.println(n);
      
      char c = readChar(bis);
      System.out.println(c);
      c = readChar(bis);
      System.out.println(c);
      c = readChar(bis);
      System.out.println(c);
      
      n = readInt(bis);
      System.out.println(n);
      
      bis.close();
   }
}