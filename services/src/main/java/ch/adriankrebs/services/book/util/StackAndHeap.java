package ch.adriankrebs.services.book.util;

/**
 * Created by Adrian on 8/5/2016.
 */
public class StackAndHeap {

    /*
    All Java objects are stored in your program memory’s heap. The heap, which is also
    referred to as the free store, represents a large pool of unused memory allocated to your
    Java application.


    Do not confuse a reference with the object that it refers to; they are two different entities. The reference is a variable that has a name and can be used to access the contents
of an object. A reference can be assigned to another reference, passed to a method, or
returned from a method. All references are the same size, no matter what their type is.
An object sits on the heap and does not have a name. Therefore, you have no way to
access an object except through a reference. Objects come in all different shapes and
sizes and consume varying amounts of memory. An object cannot be assigned to another

Stack values only exist within the scope of the function they are created in. Once it returns, they are discarded.
Heap values however exist on the heap. They are created at some point in time, and destructed at another (either by GC or manually, depending on the language/runtime).

Now Java only stores primitives on the stack. This keeps the stack small and helps keeping individual stack frames small, thus allowing more nested calls.
Objects are created on the heap, and only references (which in turn are primitives) are passed around on the stack.
     */
}
