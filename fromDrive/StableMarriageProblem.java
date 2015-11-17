package Misc;
import java.util.*;

class Person {
   String name;
   boolean gender;
   List<Person> preferenceList;
   
   Person(String name, boolean gender) {
      this.name = name;
      this.gender = gender;
      this.preferenceList = new ArrayList<Person>();
   }
}

class Pair {
   String man;
   String woman;
   
   Pair(String man, String woman) {
      this.man = man;
      this.woman = woman;
   }
}

public class StableMarriageProblem {
   
   private static class Man {
      Person p;
      Woman stableWoman;
      int currentWomanPreference;
      Map<String, Integer> preferenceMap;
      
      Man(Person p) {
         this.p = p;
         currentWomanPreference = Integer.MAX_VALUE;
         preferenceMap = new HashMap<String, Integer>();
         
         for(int i=0; i<p.preferenceList.size(); i++) {
            preferenceMap.put(p.preferenceList.get(i).name, i);
         }
         
         stableWoman = null;
      }
   }
   
   private static class Woman {
      Person p;
      boolean isCommitted;
      int nextPreferenceIndex;
      
      Woman(Person p) {
         this.p = p;
         nextPreferenceIndex = 0;
         isCommitted = false;
      }
   }
   
   public static List<Pair> findStablePairs(List<Person> people) {
      List<Woman> womenList = new ArrayList<Woman>();
      Map<String, Man> menMap = new HashMap<String, Man>();
      int singleWomanCount = 0;
      
      for(Person aPerson : people) {
         if (aPerson.gender) { //woman
            womenList.add(new Woman(aPerson));
            singleWomanCount++;
         } else {
            menMap.put(aPerson.name, new Man(aPerson));
         }
      }
      
      int iterCount=0;
      
      while(singleWomanCount > 0) {
         iterCount++;
         
         for(Woman aWoman : womenList) {
            if (aWoman.isCommitted)
               continue;
            
            Man preferredMan = menMap.get(aWoman.p.preferenceList.get(aWoman.nextPreferenceIndex).name);
            aWoman.nextPreferenceIndex++;
            
            if (preferredMan.preferenceMap.get(aWoman.p.name) < preferredMan.currentWomanPreference) {
               if (preferredMan.stableWoman != null) {
                  preferredMan.stableWoman.isCommitted = false;
                  singleWomanCount++;
               }
               preferredMan.currentWomanPreference = preferredMan.preferenceMap.get(aWoman.p.name);
               preferredMan.stableWoman = aWoman;
               aWoman.isCommitted = true;
               singleWomanCount--;
            }
         }
      }
      
      System.out.println("Num iterations required:" + iterCount);
      
      List<Pair> output = new ArrayList<Pair>();
      
      for(Map.Entry<String, Man> manEntry : menMap.entrySet()) {
         output.add(new Pair(manEntry.getKey(), manEntry.getValue().stableWoman.p.name));
      }
      
      return output;
   }
   
   private static String getRandomName(int len, Set<String> seen) {
      int maxVal = (int) Math.pow(10, len); 
      Random r = new Random();
      String ran;
      while (seen.contains(ran = Integer.toString(r.nextInt(maxVal))));         
      seen.add(ran);
      return ran;
   }
   
   public static void main(String args[]) {
    /*  Person charlotte = new Person("charlotte", true);
      Person elizabeth = new Person("elizabeth", true);
      Person jane = new Person("jane", true);
      Person lydia = new Person("lydia", true);
      
      Person bingley = new Person("bingley", false);
      Person collins = new Person("collins", false);
      Person darcey = new Person("darcey", false);
      Person wickham = new Person("wickham", false);
      
      charlotte.preferenceList.addAll(Arrays.asList(bingley, darcey, collins, wickham));
      elizabeth.preferenceList.addAll(Arrays.asList(wickham, darcey, bingley, collins));
      jane.preferenceList.addAll(Arrays.asList(bingley, wickham, darcey, collins));
      lydia.preferenceList.addAll(Arrays.asList(bingley, wickham, darcey, collins));
      
      bingley.preferenceList.addAll(Arrays.asList(jane, elizabeth, lydia, charlotte));
      collins.preferenceList.addAll(Arrays.asList(jane, elizabeth, lydia, charlotte));
      darcey.preferenceList.addAll(Arrays.asList(elizabeth, jane, charlotte, lydia));
      wickham.preferenceList.addAll(Arrays.asList(lydia, jane, elizabeth, charlotte));
      
      List<Person> people = Arrays.asList(charlotte, elizabeth, jane, lydia, bingley, collins, darcey, wickham);*/
      
      int count = 5000;
      Set<String> seen = new HashSet<String>();
      
      List<Person> menList = new ArrayList<Person>();
      List<Person> womenList = new ArrayList<Person>();
     
      for (int i=0; i<count; i++) {
         menList.add(new Person(getRandomName(7, seen), false));
         womenList.add(new Person(getRandomName(7, seen), true));
      }
      
      for(Person woman : womenList) {
         Collections.shuffle(menList);
         woman.preferenceList.addAll(menList);
      }
      
      for(Person man : menList) {
         Collections.shuffle(womenList);
         man.preferenceList.addAll(womenList);
      }
      
      menList.addAll(womenList);
      
      System.out.println("Input generation now complete.");
      
      List<Pair> stablePairs = findStablePairs(menList);
      
      // for(Pair p : stablePairs) {
      //   System.out.println(String.format("%s\t: %s", p.man, p.woman));
      // }
   }
}