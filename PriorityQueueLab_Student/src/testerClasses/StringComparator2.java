package testerClasses;

import java.util.Comparator;

public class StringComparator2 implements Comparator<String> { 
     public int compare(String s1, String s2) { 
         return s1.compareTo(s2); 
     } 
}