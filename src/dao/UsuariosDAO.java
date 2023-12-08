package dao;

import bean.MebUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


public class UsuariosDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
         session.beginTransaction();// todas as conexão com os bancos de dados precisam de uma...
         session.save(object);
         session.getTransaction().commit();
        
    }
//não precisa colocar flush e clear porque o no insert apenas esta inserindo, não colo o delete e update que esta "alterandO" o banco
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
        Criteria criteria = session.createCriteria(MebUsuarios.class); // criteria não é para usar o SELECT * FROM
        criteria.add(Restrictions.eq("id_meb_usuarios", id));//metodo estatico, porque é uma classe.// eq é equals // esse id é o parametro da loinha 44
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
               
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MebUsuarios.class); // criteria não é para usar o SELECT * FROM
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }  
     public List listNome(String mebNome){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebUsuarios.class);
        crit.add(Restrictions.like("mebNome", mebNome, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listCpf(String mebCpf){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebUsuarios.class);
        crit.add(Restrictions.like("mebCpf", mebCpf, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
   
    public List listNomeCpf(String mebNome, String mebCpf){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebUsuarios.class);
        crit.add(Restrictions.like("mebNome", mebNome, MatchMode.ANYWHERE));
        crit.add(Restrictions.like("mebCpf", mebCpf, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public List listNivel(int mebNivel){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebUsuarios.class);
        crit.add(Restrictions.ge("mebNivel", mebNivel));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
     public List listNomeNivel(String mebNome, int mebNivel){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebUsuarios.class);
        crit.add(Restrictions.like("mebNome", mebNome, MatchMode.ANYWHERE));
        crit.add(Restrictions.ge("mebNivel", mebNivel));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
     
     
     
     
}
