package ch.adriankrebs.services.book.util;

/**
 * Created by Adrian on 4/26/2016.
 */
public class Basics {


    // https://docs.oracle.com/javase/tutorial/extra/certification/index.html


    // class variables --> static instance variables
    // instance variables
    // local variables

    // variables may have the same name in another scope


    // declaration here
    String[] test; // works as i know it
    String test2[]; // works as well!!!


    // only allowed between two digits
    int underscore$test = 1_223;
    double underscoreDouble = 1_2231.23_424;

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

    private void implicitNarrowingOrWidening() {
//        A narrowing primitive conversion may be used if all of the following conditions are satisfied:
//
//        1. The expression is a constant expression of type int.
//
//        2. The type of the variable is byte, short, or char.
//
//        3. The value of the expression (which is known at compile time, because it is a constant expression) is representable in the type of the variabl

    }


//    the only difference is that the prefix version (++result) evaluates to the incremented value, whereas the postfix version (result++) evaluates to the original value

    private void prefixing() {
        int i = 3;
        i++;
        // prints 4
        System.out.println(i);
        ++i;
        // prints 5
        System.out.println(i);
        // prints 6
        System.out.println(++i);
        // prints 6
        System.out.println(i++);
        // prints 7
        System.out.println(i);

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
    public Object getObject(Object a) //0
    {

        // b is never garbage collected in this method!!!!!!!!!!!
        Object b = new Object();  //XXX

        Object c, d = new Object(); //1
        c = b; //2
        b = a = null; //3
        return c; //4
    }

    private void testImports() {
        // * does not import classes in sub-packages. just all classes in the same package

//        This is required because Y is accessing class X. static import of LOGICID is NOT
// required because Y is accessing LOGICID through X ( X.LOGICID). Had it been just System.out.println(LOGICID),
// only one import statement: import static com.foo.X.*; would have worked.

        //   Refer to the member by its fully qualified name
        //  Import the package member
        // Import the member's entire package

//        graphics.Rectangle myRect = new graphics.Rectangle();
//        import graphics.Rectangle;
//        import graphics.Rectangle.*;

//        Be aware that the second import statement will not import Rectangle.

        // NOT HIRARCHICAL !!!

//        Importing java.awt.* imports all of the types in the java.awt package,
// but it does not import java.awt.color, java.awt.font, or any other java.awt.xxxx packages.
// If you plan to use the classes and other types in java.awt.color as well as those in java.awt, you must import both packages with all their files:
//
//        import java.awt.*;
//        import java.awt.color.*;


//        the static import statement gives you a way to import the constants and static methods that you want to use so that you do not need to prefix the name of their class.

//        import static java.lang.Math.PI;
//        or as a group:
//
//        import static java.lang.Math.*;


        // Bad Syntax. Syntax for importing static fields is:
        //  import static <package>.<classname>.*; or import static <package>.<classname>.<fieldname>;


        // CLASSPATH

//        The full path to the classes directory, <path_two>\classes, is called the class path,
// and is set with the CLASSPATH system variable. Both the compiler and the JVM construct the path to your .class files by adding the package name to the class path.

//        The path names for a package's source and class files mirror the name of the package.
//

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

    public static void main(String[] args) {

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







