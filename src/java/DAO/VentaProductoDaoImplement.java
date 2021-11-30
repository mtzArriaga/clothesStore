/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Venta;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Model.Ventaproducto;

/**
 *
 * @author PC7
 */
public class VentaProductoDaoImplement implements VentaProductoDao{
     public void insertarVentaProducto(Ventaproducto ventaproducto) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(ventaproducto);
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
    public void modificarVentaProducto(Ventaproducto ventaproducto) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(ventaproducto);
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
    public void eliminarVentaProducto(Ventaproducto ventaproducto) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ventaproducto);
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
    public List<Ventaproducto> mostrarVentaProducto() {
        Session session = null;
        List<Ventaproducto> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Ingeniero hace referencia a la clase que está en el paquete model.
            Query query = session.createQuery("from Ventaproducto");
            lista = (List<Ventaproducto>) query.list();
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
