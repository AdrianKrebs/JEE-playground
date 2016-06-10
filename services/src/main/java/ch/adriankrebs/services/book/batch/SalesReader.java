/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.adriankrebs.services.book.batch;

import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 *
 * @author Adrian
 */

@Named
@Dependent
public class SalesReader extends AbstractItemReader
{
    
    private BufferedReader reader;
    
    
 
    
    public void open (Serializable checkpoint) 
    {
        reader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/sales.csv")));
        
        
        
        
        
        
    }

    
    
    // this method is responsible for reading the next item from the stream, with null indicating the end of the stream
    @Override
    public Object readItem() throws Exception
    {
               String string = null;
        try {
            string = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return string;

    }
    
    
}
