package ch.adriankrebs.services.book.data.VisitorPattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Adrian on 4/9/2016.
 */

@Entity
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // no body for abstract methods
    // each type of employee is payed differently
    //public abstract void calculatePay(Employee employee);

    //declare basic behaviour for all Employees here in the abstract class
    //public void fireEmployee(Employee employee) {
     //   System.out.println("you are fired! "+ employee.getName());
   // }

    public abstract void accept(EmployeeVisitor visitor);

}
