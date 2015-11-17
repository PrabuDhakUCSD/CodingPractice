package dp;
import java.util.*;

public class TextJustifier {
    public static List<Integer> justify(String[] input, int L) {
        int len = input.length;
        
        int[] cost = new int[len];
        int[] numWordsBeforeWord = new int[len];
        
        for (int end=0; end<len; end++) {
            int sentenceLength = 0;
            for (int start=end; start>=0; start--) {
                if (start == end) {
                    sentenceLength += input[end].length();
                    cost[end] = (int) Math.pow(L-sentenceLength, 2);
                    numWordsBeforeWord[end] = 1;
                } else {
                    sentenceLength = sentenceLength + input[start].length() + 1;
                    
                    if (sentenceLength > L)
                        break;
                    
                    int currentCost = (int) Math.pow(L-sentenceLength, 2);
                    
                    if (currentCost < cost[end]) {
                        cost[end] = currentCost;
                        numWordsBeforeWord[end] = end-start+1;
                    }
                }
            }
        }
        
        List<Integer> sentenceEndIndices = new ArrayList<Integer>();
        int endOfSentenceInd = len-1;
        
        while (true) {
            endOfSentenceInd = endOfSentenceInd - numWordsBeforeWord[endOfSentenceInd];
            if (endOfSentenceInd > 0) {
                sentenceEndIndices.add(0, endOfSentenceInd);
            } else {
                break;
            }
        }
        
        return sentenceEndIndices;
    }
}