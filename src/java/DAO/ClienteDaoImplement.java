/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Model.Cliente;
/**
 *
 * @author PC7
 */
public class ClienteDaoImplement implements ClienteDao{
    public void insertarCliente(Cliente cliente) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
            //Query query = session.createSQLQuery(""); Para crear nuestras propias consultas o insert 
            session.getTransaction().commit();
        } catch (HibernateException  e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
            //Query query = session.createSQLQuery(""); Para crear nuestras propias consultas o insert 
            session.getTransaction().commit();
        } catch (HibernateException  e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            //Query query = session.createSQLQuery(""); Para crear nuestras propias consultas o insert 
            session.getTransaction().commit();
        } catch (HibernateException  e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Cliente> mostrarCliente() {
        Session session = null;
        List<Cliente> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Ingeniero hace referencia a la clase que está en el paquete model.
            Query query = session.createQuery("from Cliente");
            lista = (List<Cliente>) query.list();
        } catch (HibernateException e) {
         System.out.println(e.getMessage());            
        }finally{
            if(session != null){
                session.close();
            }
        }
        return lista;
    }
}
