package dao;

import bean.MebProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author maria
 */
public class ProdutosDAO extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(MebProdutos.class); // criteria não é para usar o SELECT * FROM
        criteria.add(Restrictions.eq("idMebProdutos", id));//metodo estatico, porque é uma classe.// eq é equals // esse id é o parametro da loinha 44
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MebProdutos.class); // criteria não é para usar o SELECT * FROM
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
      public List listNome(String mebNomeProduto){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebProdutos.class);
        crit.add(Restrictions.like("mebNomeProduto", mebNomeProduto, MatchMode.ANYWHERE));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public List listPais(int mebCategoria){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebProdutos.class);
        crit.add(Restrictions.ge("mebCategoria", mebCategoria));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
      public List listNomePais(String mebNomeProduto, int mebCategoria){
        session.beginTransaction();
        Criteria crit = session.createCriteria(MebProdutos.class);
        crit.add(Restrictions.like("mebNomeProduto", mebNomeProduto, MatchMode.ANYWHERE));
        crit.add(Restrictions.ge("mebCategoria", mebCategoria));
        List lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }
    
}
