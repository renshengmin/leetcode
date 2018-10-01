class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> retList = new ArrayList<>();
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        String[] wordsA = A.split(" ");
        for (String word : wordsA) {
            mapA.put(word, mapA.getOrDefault(word, 0) + 1);
        }
        String[] wordsB = B.split(" ");
        for (String word : wordsB) {
            mapB.put(word, mapB.getOrDefault(word, 0) + 1);
        }
        
        
        for (String word : mapA.keySet()) {
            if (mapA.get(word) < 2 && !mapB.containsKey(word)) {
                retList.add(word);
            }
        }
        for (String word : mapB.keySet()) {
            if (mapB.get(word) < 2 && !mapA.containsKey(word)) {
                retList.add(word);
            }
        }
        
        String[] ret = new String[retList.size()];
        return retList.toArray(ret);
        
    }
}
