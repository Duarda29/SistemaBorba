package dao;

import bean.MebUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


public class UsuariosDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
         session.beginTransaction();// todas as conexão com os bancos de dados precisam de uma...
         session.save(object);
         session.beginTransaction().commit();
        
    }
//não precisa colocar flush e clear porque o no insert apenas esta inserindo, não colo o delete e update que esta "alterandO" o banco
    @Override
    public void update(Object object) {
         session.beginTransaction();
         session.flush();// para limpar o cash do hibernate para não enviar coisas erras
         session.clear();// para limpar o cash do hibernate para não enviar coisas erras
         session.update(object);
         session.beginTransaction().commit();  
    }

    @Override
    public void delete(Object object) {
         session.beginTransaction();
         session.flush();
         session.clear();
         session.delete(object);
         session.beginTransaction().commit(); 
    }

    @Override
    public Object list(int id) {
       session.beginTransaction();
        Criteria criteria = session.createCriteria(MebUsuarios.class); // criteria não é para usar o SELECT * FROM
        criteria.add(Restrictions.eq("idMebUsuarios", id));//metodo estatico, porque é uma classe.// eq é equals // esse id é o parametro da loinha 44
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
               
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MebUsuarios.class); // criteria não é para usar o SELECT * FROM
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }  
}
