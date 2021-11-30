/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import Model.Empleado;
/**
 *
 * @author PC7
 */
public class EmpleadoDaoImplement implements EmpleadoDao{
    public void insertarEmpleado(Empleado empleado) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empleado);
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
    public void modificarEmpleado(Empleado empleado) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(empleado);
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
    public void eliminarEmpleado(Empleado empleado) {
        Session  session = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empleado);
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
    public List<Empleado> mostrarEmpleado() {
        Session session = null;
        List<Empleado> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            //Ingeniero hace referencia a la clase que está en el paquete model.
            Query query = session.createQuery("from Empleado");
            lista = (List<Empleado>) query.list();
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
