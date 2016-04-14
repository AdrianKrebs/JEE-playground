package services.book.data.VisitorPattern;

import javax.persistence.Entity;

/**
 * Created by Adrian on 4/9/2016.
 */

@Entity
public class FullTimeEmployee extends Employee {


    protected Integer salary;


    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public void calculatePay(Employee employee) {

    }
}
