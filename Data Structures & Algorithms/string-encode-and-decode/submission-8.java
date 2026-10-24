class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs)
        {
            int l = str.length();
            sb.append((char) l).append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int l = str.length();
        List<String> res = new ArrayList<>();
        int i = 0;

        while(i<l)
        {
            int size = str.charAt(i++);
            res.add(str.substring(i, i+size));
            i += size;
        }

        return res;

    }
}
