package Misc;

import java.util.*;

public class PathResolution {
   public static String resolvePath(String path) {
      if (path == null || path.charAt(0) != '/') {
         throw new IllegalArgumentException();
      }
      
      String[] comps = path.split("/");
      StringBuilder buffer = new StringBuilder();
      Deque<Integer> stk = new ArrayDeque<Integer>();
      
      for (String s : comps) {
         if (s.isEmpty())
            continue;
         
         if (!s.equals("..")) {
            buffer.append("/" + s);
            stk.addLast(s.length() + 1);
         } else if ( !stk.isEmpty()) {
            int lastDirNameLen = stk.removeLast();
            buffer.delete(buffer.length() - lastDirNameLen, buffer.length());
         }
      }
      
      if (buffer.length() == 0) {
         return "/";
      }
      
      return buffer.toString();
   }
   
   public static void main(String args[]) {
      System.out.println(resolvePath("/A/blah/../quick/brown/foo/bar/../../fox/baz/foo/bar/../../../jumped"));
      System.out.println(resolvePath("/A/blah/../quick/brown/foo/../../../../../../"));
      System.out.println(resolvePath("/"));
      System.out.println(resolvePath("/../../../A/blah/../../../../A/quick/brown/foo/bar/../../fox/baz/foo/bar/../../../jumped"));
      System.out.println(resolvePath("foo/bar"));
   }
}
