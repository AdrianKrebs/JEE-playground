package ch.adriankrebs.services.book.data.VisitorPattern;

/**
 * Created by U116523 on 14.04.2016.
 */
public interface EmployeeVisitor {
    void visit(FullTimeEmployee employee);
    void visit(PartTimeEmployee employee);
}
