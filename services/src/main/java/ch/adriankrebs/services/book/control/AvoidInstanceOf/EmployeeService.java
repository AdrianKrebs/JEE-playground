package ch.adriankrebs.services.book.control.AvoidInstanceOf;

import ch.adriankrebs.services.book.data.VisitorPattern.Employee;
import ch.adriankrebs.services.book.data.VisitorPattern.EmployeeVisitor;
import ch.adriankrebs.services.book.data.VisitorPattern.FullTimeEmployee;
import ch.adriankrebs.services.book.data.VisitorPattern.PartTimeEmployee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by U116523 on 06.04.2016.
 */
@Stateless
@LocalBean
public class EmployeeService {

    // as soon as the service  gets too big we create a controller


    public void displayEmployeeWithUglyInstanceof(Employee employee) {

        if (employee instanceof FullTimeEmployee) {

            FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
            calcSalaray(fullTimeEmployee);

        } else if (employee instanceof PartTimeEmployee) {

            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
            calcHourlywage(partTimeEmployee);

        }

      //  employee.calculatePay(employee);

    }

    public void displayEmployeeWithVisitor(Employee employee) {
        EmployeeVisitor visitor = new EmployeeVisitor() {

            @Override
            public void visit(FullTimeEmployee employee) {
                calcSalaray(employee);
            }

            @Override
            public void visit(PartTimeEmployee employee) {
                calcHourlywage(employee);

            }
        };

        employee.accept(visitor);
    }

    private void calcSalaray(FullTimeEmployee fullTimeEmployee) {

    }

    private void calcHourlywage(PartTimeEmployee partTimeEmployee) {

    }


}
