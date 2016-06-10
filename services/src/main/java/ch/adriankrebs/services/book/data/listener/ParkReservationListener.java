/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.adriankrebs.services.book.data.listener;

import ch.adriankrebs.services.book.data.Book;

import javax.annotation.Resource;
import javax.persistence.PrePersist;

/**
 *
 * @author Juneau
 */
public class ParkReservationListener {
    
    @Resource(name="jndi/AcmeMail")
    javax.mail.Session mailSession;
    
    @PrePersist
    public void prePersist(Book book){
        System.out.println("A Book is submitted " + book.getName());
        // use the mail session
    }
    
}
