package services.book.util;

/**
 * Created by Adrian on 5/30/2016.
 */
public class Strings {


    public static void main(String[] args) {

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
