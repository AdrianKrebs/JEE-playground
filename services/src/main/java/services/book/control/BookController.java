package services.book.control;

import services.book.data.Employee;
import services.book.data.FullTimeEmployee;
import services.book.data.PartTimeEmployee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by U116523 on 06.04.2016.
 */
@Stateless
@LocalBean
public class BookController {

    // as soon as the service  gets too big we create a controller


    public void convertEmployee(Employee employee) {

//        if (employee instanceof FullTimeEmployee) {
//
//            FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;
//            calcSalaray(fullTimeEmployee);
//
//        } else if (employee instanceof PartTimeEmployee) {
//
//            PartTimeEmployee partTimeEmployee = (PartTimeEmployee) employee;
//            calcHourlywage(partTimeEmployee);
//
//        }


        employee.calculatePay(employee);



    }

    private void calcSalaray(FullTimeEmployee fullTimeEmployee) {

    }

    private void calcHourlywage(PartTimeEmployee partTimeEmployee) {

    }


}
