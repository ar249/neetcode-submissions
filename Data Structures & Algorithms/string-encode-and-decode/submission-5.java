class Solution {

    public String encode(List<String> strs) {
         StringBuilder sb = new StringBuilder();
         for(String s : strs)
         {
            int n = s.length();
            sb.append((char) n).append(s);
         }

         return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int n = str.length();
        int i =0;

        while(i < n)
        {
            int size = str.charAt(i++);
            res.add(str.substring(i, i+size));
            i += size;
        }

        return res;
    }
}
