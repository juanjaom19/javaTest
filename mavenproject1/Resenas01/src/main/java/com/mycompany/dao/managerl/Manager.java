/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.managerl;

import com.mycompany.dao.NewHibernateUtil;
import com.mycompany.model.Comentarios;
import com.mycompany.model.Peliculas;
import com.mycompany.model.Resenas;
import com.mycompany.model.Usuarios;
import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author usuario
 */
public class Manager {
    public static boolean create(Object o){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("Error al insertar");
            session.getTransaction().rollback();
            return false;
        }finally{
            session.flush();
            session.close();
        }
    }
    
    public static boolean edit(Object o){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("Error al insertar");
            session.getTransaction().rollback();
            return false;
        }finally{
            session.flush();
            session.close();
        }
    }
    
    
    public static boolean delete(Class type, int id){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            session.delete(session.get(type, id));
            session.getTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("Error al insertar");
            session.getTransaction().rollback();
            return false;
        }finally{
            session.flush();
            session.close();
        }
    }
    
    public static List<?> getAll(Class type){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        List<Object> obj = new ArrayList<>();
            
        try{
            session.beginTransaction();
            if(type == Usuarios.class){
                obj = session.createQuery("From Usuarios").list();
            }else if(type == Comentarios.class){
                obj = session.createQuery("From Comentarios").list();
            }else if(type == Peliculas.class){
                obj = session.createQuery("From Pelicualas").list();
            }else if(type == Resenas.class){
                obj = session.createQuery("From Resenas").list();
            }
           
            
        }catch(Exception e){
            System.out.println("Error al insertar");
            session.getTransaction().rollback();
        }finally{
            session.flush();
            session.close();
        }
         return obj;
    }
    
    public static Object getById(Class type, int id){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Object obj = null;
        Query query = null;
        try{
            session.beginTransaction();
            if(type == Usuarios.class){
                query = session.createQuery("From Usuarios Where Id = :id");
            }else if(type == Comentarios.class){
                query = session.createQuery("From Comentarios Where Id = :id");
            }else if(type == Peliculas.class){
                query = session.createQuery("From Peliculas Where Id = :id");
            }else if(type == Resenas.class){
                query = session.createQuery("From Resenas Where Id = :id");
            }
            if(query != null){
                query.setInteger("id", id);
                
                obj = query.uniqueResult();
            }
            
            
        }catch(Exception e){
            System.out.println("Error al insertar");
            session.getTransaction().rollback();
        }finally{
            session.flush();
            session.close();
        }
         return obj;
    }
    
    
    public static Usuarios getUser(String user, String psw){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Usuarios obj = null;
        Query query = null;
        try{
            session.beginTransaction();
            query = session.createQuery("From Usuarios Where Email = :user and Contrasena = :psw");
            query.setString("user", user);
            query.setString("psw", psw);
            obj = (Usuarios)query.uniqueResult();
        }catch(Exception e){
            System.out.println("Error al insertar");
            session.getTransaction().rollback();
        }finally{
            session.flush();
            session.close();
        }
        return obj;
    }
}
