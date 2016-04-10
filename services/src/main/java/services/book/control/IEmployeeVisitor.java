package services.book.control;

import services.book.data.FullTimeEmployee;
import services.book.data.PartTimeEmployee;

/**
 * Created by Adrian on 4/9/2016.
 */
public interface IEmployeeVisitor {

    void visit(FullTimeEmployee fullTimeEmployee);

    void visit(PartTimeEmployee partTimeEmployee);

}
