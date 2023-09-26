package bean;
// Generated 25/09/2023 11:58:18 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MebUsuarios generated by hbm2java
 */
@Entity
@Table(name="meb_usuarios"
    ,catalog="db_maria_borba"
)
public class MebUsuarios  implements java.io.Serializable {


     private int idMebUsuarios;
     private String mebNome;
     private String mebApelido;
     private String mebCpf;
     private Date mebDataNascimento;
     private String mebSenha;
     private int mebNivel;
     private String mebAtivo;

    public MebUsuarios() {
    }

	
    public MebUsuarios(int idMebUsuarios, String mebNome, String mebApelido, String mebCpf, Date mebDataNascimento, String mebSenha, int mebNivel, String mebAtivo) {
        this.idMebUsuarios = idMebUsuarios;
        this.mebNome = mebNome;
        this.mebApelido = mebApelido;
        this.mebCpf = mebCpf;
        this.mebDataNascimento = mebDataNascimento;
        this.mebSenha = mebSenha;
        this.mebNivel = mebNivel;
        this.mebAtivo = mebAtivo;
    }
    
     @Id 

    
    @Column(name="id_meb_usuarios", unique=true, nullable=false)
    public int getIdMebUsuarios() {
        return this.idMebUsuarios;
    }
    
    public void setIdMebUsuarios(int idMebUsuarios) {
        this.idMebUsuarios = idMebUsuarios;
    }

    
    @Column(name="meb_nome", nullable=false, length=45)
    public String getMebNome() {
        return this.mebNome;
    }
    
    public void setMebNome(String mebNome) {
        this.mebNome = mebNome;
    }

    
    @Column(name="meb_apelido", nullable=false, length=45)
    public String getMebApelido() {
        return this.mebApelido;
    }
    
    public void setMebApelido(String mebApelido) {
        this.mebApelido = mebApelido;
    }

    
    @Column(name="meb_cpf", nullable=false, length=20)
    public String getMebCpf() {
        return this.mebCpf;
    }
    
    public void setMebCpf(String mebCpf) {
        this.mebCpf = mebCpf;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="meb_dataNascimento", nullable=false, length=10)
    public Date getMebDataNascimento() {
        return this.mebDataNascimento;
    }
    
    public void setMebDataNascimento(Date mebDataNascimento) {
        this.mebDataNascimento = mebDataNascimento;
    }

    
    @Column(name="meb_senha", nullable=false, length=45)
    public String getMebSenha() {
        return this.mebSenha;
    }
    
    public void setMebSenha(String mebSenha) {
        this.mebSenha = mebSenha;
    }

    
    @Column(name="meb_nivel", nullable=false)
    public int getMebNivel() {
        return this.mebNivel;
    }
    
    public void setMebNivel(int mebNivel) {
        this.mebNivel = mebNivel;
    }

    
    @Column(name="meb_ativo", nullable=false, length=20)
    public String getMebAtivo() {
        return this.mebAtivo;
    }
    
    public void setMebAtivo(String mebAtivo) {
        this.mebAtivo = mebAtivo;
    }


}


