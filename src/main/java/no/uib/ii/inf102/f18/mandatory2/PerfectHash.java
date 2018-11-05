package no.uib.ii.inf102.f18.mandatory2;

import java.util.ArrayList;
import java.util.List;

public class PerfectHash {

    public static void main(String[] args) {
        Kattio kattio = new Kattio(System.in);
        int length = kattio.getInt();
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = kattio.getWord();
        }
        hash(strings);
    }
    private static void hash(String[] strings){
        int a = 2;
        List<Integer> hashes = new ArrayList<>(strings.length);
        for (int M = strings.length; M <= 500; M++) {
            //No clue what an acceptable cutoff for a is, but same as M seemed like a fair enough choice and it solves the Kattis task.
            for(int i = 0; i<500;i++){
                for (String string : strings) {
                    int h = hash(string, M, i);
                    if (!hashes.contains(h)) {
                        hashes.add(h);
                    } else {
                        hashes.clear();
                        break;
                    }
                }
                if(!hashes.isEmpty()){
                    a = i;
                    break;
                }
            }
            if(!hashes.isEmpty()){
                System.out.printf("%d %d\n",a,M);
                return;
            }
            hashes.clear();
        }
    }

    private static int hash(String s, int M,int a) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (a * hash + s.charAt(i)) % M;
        }
        return hash;
    }
}
