import java.util.*;

public class DedupContactsUsingGraph {
    static class Contact {
        String a;
        String b;
        String c;
        
        public Contact(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof Contact))
                return false;
            
            Contact otherContact = (Contact) other;
            
            return (a.equals(otherContact.a) || a.equals(otherContact.b) || a.equals(otherContact.c) ||
                    b.equals(otherContact.a) || b.equals(otherContact.b) || b.equals(otherContact.c) ||
                    c.equals(otherContact.a) || c.equals(otherContact.b) || c.equals(otherContact.c));
        }
    }
    
    public static void groupContacts(Contact[] contacts) {
        int len = contacts.length;
        int[][] adjMat = new int[len][len];
        
        for(int i=0; i<len-1; i++) {
            for (int j=i+1; j<len; j++) {
                if (contacts[i].equals(contacts[j])) {
                    adjMat[i][j] = adjMat[j][i] = 1;
                }
            }
        }
        
        List<Integer> out = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        for(int i=0; i<len; i++) {
            if (!visited.contains(i)) {
                dfsVisit(i, adjMat, visited, out);
                out.add(-1);
            }
        }
        
        for(int i : out) {
            if (i == -1)
                System.out.println("\n");
            else
                System.out.print(i + ",");
        }
    }
    
    private static void dfsVisit(int nodeId, int[][] adjMat, Set<Integer> visited, List<Integer> out) {
        visited.add(nodeId);
        out.add(nodeId);
        
        for(int childId=0; childId < adjMat.length; childId++) {
            if (adjMat[nodeId][childId] != 0 && !visited.contains(childId)) {
                dfsVisit(childId, adjMat, visited, out);
            }
        }
    }
    
    public static void main(String[] args) {
        
        Contact[] contacts = {new Contact("Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"), 
                new Contact("Lucky", "lucky@gmail.com", "+1234567"),
                new Contact("gaurav123", "+5412312", "gaurav123@skype.com"),
                new Contact("gaurav1993", "+5412312", "gaurav@gfgQA.com"),
                new Contact("raja", "+2231210", "raja@gfg.com"),
                new Contact("bahubali", "+878312", "raja")};
        
        groupContacts(contacts);
    }
}
