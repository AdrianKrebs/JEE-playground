package ch.adriankrebs.services.book.util;

/**
 * Created by Adrian on 2/18/2017.
 */
public class Enums {

    enum TesterEnum {
        WINTER("winter"), SPRING("spring"), SUMMER("summer"), FALL("fall");
        private String name;
        private static String TEST;

        // enum constructors cant acccess static varaibles due to initialization order -> consturctory -> static variables
        private TesterEnum(String name) {
            this.name = name;
            ;
        }

        public String getData() {
            return "test";
        }
    }

    public enum Pets {
        DOG(1, "D"), CAT(2, "C") {
            @Override
            public String getData() {
                return type + name;
            } // overriding is perfectly fine
        },
        FISH(3, "F");
        int type;
        String name;

        Pets(int t, String s) {
            this.name = s;
            this.type = t;
        }

        public String getData() {
            return name + type;
        }
    }

}
