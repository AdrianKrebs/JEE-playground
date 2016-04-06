package services.book.data;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Created by U116523 on 06.04.2016.
 */
@Embeddable
public class EmbeddableSample {

    @Column(name = "STRING_TEST")
    private String testString;

    @Column(name = "DATE_TEST")
    private LocalDate date_test;

    public String getTestString() {
        return testString;
    }

    public LocalDate getDate_test() {
        return date_test;
    }

    public void setDate_test(LocalDate date_test) {
        this.date_test = date_test;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }
}
