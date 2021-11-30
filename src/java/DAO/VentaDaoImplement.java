/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Producto;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Model.Venta;
/**
 *
 * @author PC7
 */
public class VentaDaoImplement implements VentaDao{
     public void insertarVenta(Venta venta) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(venta);
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
    public void modificarVenta(Venta venta) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(venta);
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
    public void eliminarVenta(Venta venta) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(venta);
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
    public List<Venta> mostrarVenta() {
        Session session = null;
        List<Venta> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Ingeniero hace referencia a la clase que está en el paquete model.
            Query query = session.createQuery("from Venta");
            lista = (List<Venta>) query.list();
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
