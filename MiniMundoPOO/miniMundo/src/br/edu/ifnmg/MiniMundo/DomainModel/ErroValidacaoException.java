/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.MiniMundo.DomainModel;

/**
 *
 * @author pimen
 */
public class ErroValidacaoException extends Exception{
    
    public ErroValidacaoException(String message)
    {
        super(message);
    }
    
}
