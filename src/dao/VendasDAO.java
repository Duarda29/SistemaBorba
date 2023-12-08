package dao;

import bean.MebVendas;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author maria
 */
public class VendasDAO extends DAO_Abstract {

    @Override
     public void insert(Object object) {
         session.beginTransaction();// todas as conexão com os bancos de dados precisam de uma...
         session.save(object);
         session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
         session.beginTransaction();
         session.flush();// para limpar o cash do hibernate para não enviar coisas erras
         session.clear();// para limpar o cash do hibernate para não enviar coisas erras
         session.update(object);
         session.getTransaction().commit();  
    }

    @Override
    public void delete(Object object) {
         session.beginTransaction();
         session.flush();
         session.clear();
         session.delete(object);
         session.getTransaction().commit(); 
    }

    @Override
     public Object list(int id) {
       session.beginTransaction();
        Criteria criteria = session.createCriteria(MebVendas.class); // criteria não é para usar o SELECT * FROM
        criteria.add(Restrictions.eq("idMebVendas", id));//metodo estatico, porque é uma classe.// eq é equals // esse id é o parametro da loinha 44
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
     public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MebVendas.class); // criteria não é para usar o SELECT * FROM
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
     
     public List listData(Date data){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebVendas.class);
        crit.add(Restrictions.ge("mebData", data));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listTotal(double mebTotal){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebVendas.class);
        crit.add(Restrictions.like("mebTotal", mebTotal));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
   
    public List listDataTotal(Date data , double mebTotal){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebVendas.class);
        crit.add(Restrictions.ge("mebData", data));
        crit.add(Restrictions.like("mebTotal", mebTotal));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }

}
