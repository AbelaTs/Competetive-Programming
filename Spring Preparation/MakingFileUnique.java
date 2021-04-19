//https://leetcode.com/problems/making-file-names-unique/

class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String ,Integer> labelMap =new HashMap<>();
    String result []=new String[names.length];
    for(int index=0;index<names.length;index++)
    {
        String word=names[index];   
        if(labelMap.containsKey(word)) 
        {
           result[index]=word+"("+labelMap.get(word)+")";
            labelMap.put(word,labelMap.get(word)+1);
           if(labelMap.containsKey(result[index]))
           {
               index--;
            continue;
           }
           
           labelMap.put(result[index],1);
        }
        else
        {
            result[index]=word;
            labelMap.put(word,1); 
        }
    }

    return result;
    }
}