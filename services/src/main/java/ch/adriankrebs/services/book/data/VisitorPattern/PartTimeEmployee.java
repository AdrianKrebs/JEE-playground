package ch.adriankrebs.services.book.data.VisitorPattern;

import javax.persistence.Entity;

/**
 * Created by Adrian on 4/9/2016.
 */

@Entity
public class PartTimeEmployee  extends  Employee{


    protected Float hourlyWage;


    public Float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Float hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public void accept(EmployeeVisitor visitor) {
        visitor.visit(this);

    }
}
