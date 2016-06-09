package services.book.util;

/**
 * Created by Adrian on 4/26/2016.
 */
public class Basics {

    //TODO: Working directories -> paths
    //TODO: Imports --> wildcards
    //TODO: instance variables, local variabless
    //TODO: garbage collection


    // https://docs.oracle.com/javase/tutorial/extra/certification/index.html


    // declaration here
    String[] test; // works as i know it
    String test2[]; // works as well!!!


    // only allowed between two digits
    int underscore$test = 1_223;
    double underscoreDouble = 1_2231.23424;

    public Basics(String[] test) {

        // init in constructor
        test2 = new String[10];
        test2[0] = "test";


        // a lower datatype is allowed, higher not
        short testNumber = 5;
        char testChar = 'a';
        int testInt = testNumber * 5;

        // widening and narrowing
        testInt = testChar;


        // ---- calling order
        /*First, static statements/blocks are called IN THE ORDER they are defined.
                Next, instance initializer statements/blocks are called IN THE ORDER they are defined.
                Finally, the constructor is called
                */


    }


    private void forLoopWithoutBraces() {

// jesus christ this works --> same principe as an if statement without braces -> just the first line is executed
        OUTER_LOOP:
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 4; j++) {
                if (j * i % 2 == 0)
                    continue OUTER_LOOP;
            }
    }

    private void exclusiceOrTest() {
        // in case of booleans xor is x != y

        boolean[] all = {false, true};
        for (boolean a : all) {
            for (boolean b : all) {
                boolean c = a ^ b;
                System.out.println(a + " ^ " + b + " = " + c);
            }
        }
    }

    private void doingWhile() {


        int i = 1, j = 10;
        do {
            if (i++ > --j) {
                continue;
            }
        } while (i < 5);
        System.out.println("i=" + i + " j=" + j);


    }


    private void ternaryOperator() {
        // booleanExpression ? expression1 : expression2
        int x = 5;
        System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);

        System.out.println((x > 2) ? ((x < 4) ? 10 : 8) : 7);

    }


    private void variableInitialization() {
        // local variable
        String test;

        // fails because not initialized -_> nullpointer
        //System.out.println(test);
    }

    private void garbageCollectionTest() {


        // The most important distinction is that while procedural programming uses procedures to operate on data structures, object-oriented programming bundles the two together,
        // so an "object", which is an instance of a class, operates on its "own" data structure

        //  Java compiles to bytecode instead of native machine code. The Java virtual machine interprets and executes that bytecode,
        // and translates it to native machine code using a just-in-time compiler to make it run fast.


        WeekendWarrior warrior = new WeekendWarrior();
        WeekendWarrior warrior1 = warrior;
        // calling system.gc suggest that java might wish to run the gc. java is free to ignore the request.
        // finalize runs if an object attempts to be garbage collected
        System.gc();


    }

    private void testImports() {
        // * does not import classes in sub-packages. just all classes in the same package
    }


    private class WeekendWarrior {
        String test;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }


        // this shit is allowed --> not a constructor!!!!
        public void WeekendWarrior() {

        }

        // constructor
        public WeekendWarrior() {
        }
    }

    /* access modifiers in Java
    ---------------------------
    Access Levels
Modifier        Class   Package Subclass    World
public            Y       Y       Y          Y
protected         Y       Y       Y          N
(Default)         Y       Y       N          N
private           Y       N       N          N
     */






}
