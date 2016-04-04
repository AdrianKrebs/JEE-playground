/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.book.batch;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Adrian
 */
@Named
@Dependent
public class SalesWriter extends AbstractItemWriter
{
  /*  @PersistenceContext
    EntityManager em;*/
    
    
    @Override
    @Transactional
    public void writeItems(List items) throws Exception
    {
      /*  for (Sales sale: (List<Sales>)items)
        {
            em.persist(sale);
            
        }*/
    }
    
    
    
}
