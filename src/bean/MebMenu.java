package bean;
// Generated 14/09/2023 15:05:40 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meb_menu"
    ,catalog="db_maria_borba"
)
public class MebMenu  implements java.io.Serializable {


     private int idMebMenu;
     private int mebPizza;
     private String mebBorda;
     private String mebPorcao;
     private int mebBebidas;
     private int mebTamanhos;

    public MebMenu() {
    }

	
    public MebMenu(int idMebMenu, int mebPizza) {
        this.idMebMenu = idMebMenu;
        this.mebPizza = mebPizza;
    }
    public MebMenu(int idMebMenu, int mebPizza, String mebBorda, String mebPorcao, int mebBebidas, int mebTamanhos) {
       this.idMebMenu = idMebMenu;
       this.mebPizza = mebPizza;
       this.mebBorda = mebBorda;
       this.mebPorcao = mebPorcao;
       this.mebBebidas = mebBebidas;
       this.mebTamanhos = mebTamanhos;
    }
   
     @Id 

    
    @Column(name="id_meb_menu", unique=true, nullable=false)
    public int getIdMebMenu() {
        return this.idMebMenu;
    }
    
    public void setIdMebMenu(int idMebMenu) {
        this.idMebMenu = idMebMenu;
    }

    
    @Column(name="meb_pizza", nullable=false)
    public int getMebPizza() {
        return this.mebPizza;
    }
    
    public void setMebPizza(int mebPizza) {
        this.mebPizza = mebPizza;
    }

    
    @Column(name="meb_borda", length=45)
    public String getMebBorda() {
        return this.mebBorda;
    }
    
    public void setMebBorda(String mebBorda) {
        this.mebBorda = mebBorda;
    }

    
    @Column(name="meb_porcao", length=45)
    public String getMebPorcao() {
        return this.mebPorcao;
    }
    
    public void setMebPorcao(String mebPorcao) {
        this.mebPorcao = mebPorcao;
    }

    
    @Column(name="meb_bebidas")
    public int getMebBebidas() {
        return this.mebBebidas;
    }
    
    public void setMebBebidas(int mebBebidas) {
        this.mebBebidas = mebBebidas;
    }

    
    @Column(name="meb_tamanhos")
    public int getMebTamanhos() {
        return this.mebTamanhos;
    }
    
    public void setMebTamanhos(int mebTamanhos) {
        this.mebTamanhos = mebTamanhos;
    }
}


