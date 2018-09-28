//checked

package class8hashtablestring1;

public class Strstr {
    public int strstr(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        int prime1 = 31, prime2 = 101;         //prime1 is for multiplying, prime 2 is for modular
        int hash = small.charAt(0) % prime2;   //target
        int rolling = large.charAt(0) % prime2;  //rolling hash
        int seed = 1;                            //simplify future calculation
        for (int i = 1; i < small.length(); i++) {
            hash = (hash * prime1 % prime2 + small.charAt(i)) % prime2;
            rolling = (rolling * prime1 % prime2 + large.charAt(i)) % prime2;
            seed =  seed * prime1 % prime2;
        }
        if (hash == rolling && equal(large, small, 0)) {
            return 0;
        }
        for (int i = 1; i <= large.length() - small.length(); i++) {
            rolling = (rolling - (large.charAt(i - 1) * seed) % prime2); //remove the beginning element
            //make sure it is larger than 0;
            if (rolling < 0) {
                rolling += prime2;
            }
            rolling = (rolling * prime1 % prime2 + large.charAt(i + small.length() - 1)) % prime2; //add the new element
            if (rolling == hash && equal(large, small, i)) {
                return i;
            }
        }
        return -1;




    }


    public boolean equal(String large, String small, int index) {
        for (int i = index; i < index + small.length(); i++) {
            if (large.charAt(i) != small.charAt(i - index)) {
                return false;
            }
        }
        return true;
    }
}
