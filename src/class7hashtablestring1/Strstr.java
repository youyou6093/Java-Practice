package class7hashtablestring1;

public class Strstr {
    public int strstr(String large, String small) {
        for (int i = 0; i <= large.length() - small.length(); i++) {
            String cur = large.substring(i, i + small.length());
            if (cur.equals(small)) {
                return i;
            }
        }
        return -1;
    }
}
