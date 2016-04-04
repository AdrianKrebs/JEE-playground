/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.book.batch;

import javax.batch.operations.JobOperator;
import javax.batch.operations.JobStartException;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Properties;

/**
 *
 * @author Adrian
 */
@Stateless
@Named
public class SalesBean
{

  /*  @PersistenceContext
    EntityManager em;
    */
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    public void runJob() {
        
        try {
            JobOperator jobOp = BatchRuntime.getJobOperator();
            long jobId = jobOp.start("eod-sales", new Properties());
            System.out.println("Job Start ID: " +jobId);
            
        } catch (JobStartException ex){
            ex.printStackTrace();
        }

    }
    
    
   /* public List<Sales> getSalesData()
    {
        
        return em.createNamedQuery("Sales.findAll",Sales.class).getResultList();
        
    }*/
}
