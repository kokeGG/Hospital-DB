/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Koke
 */
public interface CRUD {
    
    public List lista();
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
}
