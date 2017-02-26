package ch.adriankrebs.services.book.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Adrian on 5/30/2016.
 */
public class Strings {


    public static void main(String[] args) {

        Strings str = new Strings();
        str.reversing();

        new StringBuilder("world").insert(0, "hello ").toString();

        System.out.println("hello world".compareTo("Hello world") < 0);

        final String FPATH = "/home/user/index.html";
        Filename myHomePage = new Filename(FPATH, '/', '.');
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());


        String s = "MINIMUM";
        System.out.println(s.substring(4, 7)); //1 ---> first  index is including second index is excluding
        System.out.println(s.substring(5)); //2  ---> including 5th index till end
        System.out.println(s.substring(s.indexOf('I', 3))); //3 --> returns true
//        System.out.println(s.substring(s.indexOf('I', 4))); //4 --> exception because  no I cant be found when u start at 4th index


        String result = "AniMaL ".trim().toLowerCase().replace('a', 'A');


        StringBuilder sb = new StringBuilder("animals");
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
        int len = sb.length();
        char ch = sb.charAt(6);
        System.out.println(sub + " " + len + " " + ch);


        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("a");
        System.out.println(one == two); // false
        System.out.println(one == three); // true


        "My name is ".concat("Rumplestiltskin");

        System.out.printf("The value of the float " +
                        "variable is %f, while " +
                        "the value of the " +
                        "integer variable is %d, " +
                        "and the string is %s",
                4.2f, 42, "42");


        // creates empty builder, capacity 16
        StringBuilder sb2 = new StringBuilder();
// adds 9 character string at beginning
        sb2.append("Greetings");


        // only available variable in String --> valid dot operator
        System.out.println(String.CASE_INSENSITIVE_ORDER);


        String test = "2";
        test += "123";

        StringBuilder sb7 = new StringBuilder("12345678");
        sb7.setLength(5);
        sb7.setLength(10);
        System.out.println("length:"+sb7.length());
        sb.append(1);


        String add =""+ 1 + 2;
        String add2 =1 + 2 + "";

        System.out.println(add + " --- " +add2);




    }

    private void reversing() {
        /*
              String Builder methods:
              -------------------------------
              setLength
              ensureCapacity
              reverse
              append


              StringBuilder is MUTABLE --> with append i.e






*/


        StringBuilder sb2 = new StringBuilder();
        sb2.append("aaa").insert(1, "bb").insert(5, "ccc");
        System.out.println(sb2);


        String palindrome = "Dot saw I was Tod";

        StringBuilder sb = new StringBuilder(palindrome);


        sb.reverse();  // reverse it
        sb.delete(0,2);
        System.out.println(sb);
         // int test = palindrome.substring(6, 5).length(); throws outofbound exception
        sb.delete(0, sb.length());

        StringBuilder numbers = new StringBuilder("0123456789");
        numbers.delete(2, 8);
        numbers.append(4);
        numbers.append("-").insert(2, "+");
        System.out.println(numbers);

        // second argument is offset ---> so 0 to 8 of  ddd-ddd-ddd is appended, no index available unlike insert
        System.out.println(new StringBuilder("xxxx").append("ddd-ddd-ddd", 0, 8).toString());
//        This will return xxxxddd-ddd-.



        // correct --> first is index, second offset, third start
        System.out.println(new StringBuilder("xxxx").insert(0, "ddd-ddd-ddd", 0, 8).toString());



    }

    private void substringing() {

       // The following code gets from the Niagara palindrome the substring that extends from index 11 up to, but not including, index 15, which is the word "roar":

        String anotherPalindrome = "Niagara. O roar again!";
        String roar = anotherPalindrome.substring(11, 15);

    }

    private void comparing() {

        // will result in false
//        Notice that the Strings differ at the first position.
// The value returned by compareTo is (Unicode value of the left hand side - Unicode value of the right hand side).
//
//        Although not required for the exam, it is good to know that for English alphabets, the unicode value of
// any lower case letter is always 32 more than the unicode value of the same letter in upper case. So, 'a' - 'A' or 'h' - 'H' is 32.
        System.out.println("hello world".compareTo("Hello world") < 0);
    }



    // The program steps through the string referred to by searchMe one character at a time. For each character,
    // the program calls the regionMatches method to determine whether the substring beginning with the current character matches the string the program is looking for.
    public static boolean findStringInString(String searchMe, String findMe) {

        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;

        // subtract because as soon as i < findMeLength we never ever find the string
        for (int i = 0;
             i <= (searchMeLength - findMeLength);
             i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                System.out.println(searchMe.substring(i, i + findMeLength));
                return foundIt;
            }
        }

            System.out.println("No match found.");
            return false;


}



    public static class Filename {
        private String fullPath;
        private char pathSeparator,
                extensionSeparator;

        public Filename(String str, char sep, char ext) {
            fullPath = str;
            pathSeparator = sep;
            extensionSeparator = ext;
        }

        public String extension() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            // skip dot + 1 -_> from dot + 1 till end
            return fullPath.substring(dot + 1);
        }

        // gets filename without extension
        public String filename() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(sep + 1, dot);
        }

        public String path() {
            int sep = fullPath.lastIndexOf(pathSeparator);
            // from 0 till sep
            return fullPath.substring(0,sep);
        }
    }


    public class Anagram {

        public  boolean areAnagrams(String string1,
                                          String string2) {

            String workingCopy1 = removeJunk(string1);
            String workingCopy2 = removeJunk(string2);

            workingCopy1 = workingCopy1.toLowerCase();
            workingCopy2 = workingCopy2.toLowerCase();

            workingCopy1 = sort(workingCopy1);
            workingCopy2 = sort(workingCopy2);

            return workingCopy1.equals(workingCopy2);
        }

        protected  String removeJunk(String string) {
            int i, len = string.length();
            StringBuilder dest = new StringBuilder(len);
            char c;

            for (i = (len - 1); i >= 0; i--) {
                c = string.charAt(i);
                if (Character.isLetter(c)) {
                    dest.append(c);
                }
            }

            return dest.toString();
        }

        protected  String sort(String string) {
            char[] charArray = string.toCharArray();

            java.util.Arrays.sort(charArray);

            return new String(charArray);
        }

        public  void main(String[] args) {
            String string1 = "Cosmo and Laine:";
            String string2 = "Maid, clean soon!";

            System.out.println();
            System.out.println("Testing whether the following "
                    + "strings are anagrams:");
            System.out.println("    String 1: " + string1);
            System.out.println("    String 2: " + string2);
            System.out.println();

            if (areAnagrams(string1, string2)) {
                System.out.println("They ARE anagrams!");
            } else {
                System.out.println("They are NOT anagrams!");
            }



           boolean b = "String".replace('g','g')=="String"; // ---> true
            //replace returns the same object if there is no change.


//            Object a, b, c ;
//            a = new String("A");
//            b = new String("B");
//            c = a;
//            a = b;
//            System.out.println(""+c);

            // A since String overrides toString
        }
    }







    /*

    --------------------------------String methods -------------------------------------------

    .intern()
    -------------
     String.equals() is quite the same as String.intern() <--- when u need speed s.intern() == t.intern() is true if and only if s.equals(t) is true.
     String.equalsIgnoreCase



    .substring()
    --------------
    String substring(int beginIndex)
          Returns a new string that is a substring of this string.
String substring(int beginIndex, int endIndex)
          Returns a new string that is a substring of this string.


    int indexOf(int ch)
          Returns the index within this string of the first occurrence of the specified character.
    int indexOf(int ch, int fromIndex)
          Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
    int indexOf(String str)
          Returns the index within this string of the first occurrence of the specified substring.
    int indexOf(String str, int fromIndex)
          Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.


      which ones are final?
      --------------------
      String, StringBuilder, and StringBuffer - all are final classes.

    1. Remember that wrapper classes (java.lang.Boolean, java.lang.Integer, java.lang.Long, java.lang.Short etc.) are also final and so they cannot be extended.

    2. java.lang.Number, however, is not final. Integer, Long, Double etc. extend Number.

    3. java.lang.System is final as well.




    .concat() ---> IMMUTABILITY!!!
    ------------------

    Strings are immutable so doing abc.concat("abc") will create a new string "abc" but will not affect the original string "".




    a few more
    ----------------------


    tring();
    replace();
    contains();
    startsWith();
    charAt();


    Method chaining
    -----------------------------------
    Strings are immutable so doing abc.concat("abc") will create a new string "abc" but will not affect the original string "".





     */


}
