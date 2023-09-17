package bean;
// Generated 14/09/2023 15:05:40 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MebProdutos generated by hbm2java
 */
@Entity
@Table(name="meb_produtos"
    ,catalog="db_maria_borba"
)
public class MebProdutos  implements java.io.Serializable {


     private int idMebProdutos;
     private String mebQuantidade;
     private String mebNomeProduto;
     private int mebCategoria;
     private String mebComplemento;
     private String mebEntrega;

    public MebProdutos() {
    }

	
    public MebProdutos(int idMebProdutos, String mebQuantidade, String mebNomeProduto, int mebCategoria, String mebComplemento, String mebEntrega) {
        this.idMebProdutos = idMebProdutos;
        this.mebQuantidade = mebQuantidade;
        this.mebNomeProduto = mebNomeProduto;
        this.mebCategoria = mebCategoria;
        this.mebComplemento = mebComplemento;
        this.mebEntrega = mebEntrega;
    }
   
   
     @Id 

    
    @Column(name="id_meb_produtos", unique=true, nullable=false)
    public int getIdMebProdutos() {
        return this.idMebProdutos;
    }
    
    public void setIdMebProdutos(int idMebProdutos) {
        this.idMebProdutos = idMebProdutos;
    }

    
    @Column(name="meb_quantidade", nullable=false, length=45)
    public String getMebQuantidade() {
        return this.mebQuantidade;
    }
    
    public void setMebQuantidade(String mebQuantidade) {
        this.mebQuantidade = mebQuantidade;
    }

    
    @Column(name="meb_nomeProduto", nullable=false, length=45)
    public String getMebNomeProduto() {
        return this.mebNomeProduto;
    }
    
    public void setMebNomeProduto(String mebNomeProduto) {
        this.mebNomeProduto = mebNomeProduto;
    }

    
    @Column(name="meb_categoria", nullable=false)
    public int getMebCategoria() {
        return this.mebCategoria;
    }
    
    public void setMebCategoria(int mebCategoria) {
        this.mebCategoria = mebCategoria;
    }

    
    @Column(name="meb_complemento", nullable=false, length=45)
    public String getMebComplemento() {
        return this.mebComplemento;
    }
    
    public void setMebComplemento(String mebComplemento) {
        this.mebComplemento = mebComplemento;
    }

    
    @Column(name="meb_entrega", nullable=false, length=45)
    public String getMebEntrega() {
        return this.mebEntrega;
    }
    
    public void setMebEntrega(String mebEntrega) {
        this.mebEntrega = mebEntrega;
    }

}


