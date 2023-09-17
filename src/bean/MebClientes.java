package bean;
// Generated 14/09/2023 15:05:40 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="meb_clientes"
    ,catalog="db_maria_borba"
)
public class MebClientes  implements java.io.Serializable {


     private int idMebClientes;
     private String mebNome;
     private String mebSobrenome;
     private String mebGenero;
     private String mebRg;
     private String mebCpf;
     private String mebCep;
     private String mebEndereco;
     private String mebNumCasa;
     private String mebBairro;
     private int mebEstado;
     private int mebPais;
     private String mebCelular;
     private String mebEmail;
     private String mebTelefoneResidencial;

    public MebClientes() {
    }

	
    public MebClientes(int idMebClientes, String mebNome, String mebSobrenome, String mebRg, String mebCpf, String mebCep, String mebEndereco, String mebNumCasa, String mebBairro, int mebEstado, int mebPais, String mebCelular, String mebTelefoneResidencial) {
        this.idMebClientes = idMebClientes;
        this.mebNome = mebNome;
        this.mebSobrenome = mebSobrenome;
        this.mebRg = mebRg;
        this.mebCpf = mebCpf;
        this.mebCep = mebCep;
        this.mebEndereco = mebEndereco;
        this.mebNumCasa = mebNumCasa;
        this.mebBairro = mebBairro;
        this.mebEstado = mebEstado;
        this.mebPais = mebPais;
        this.mebCelular = mebCelular;
        this.mebTelefoneResidencial = mebTelefoneResidencial;
    }
    public MebClientes(int idMebClientes, String mebNome, String mebSobrenome, String mebGenero, String mebRg, String mebCpf, String mebCep, String mebEndereco, String mebNumCasa, String mebBairro, int mebEstado, int mebPais, String mebCelular, String mebEmail, String mebTelefoneResidencial) {
       this.idMebClientes = idMebClientes;
       this.mebNome = mebNome;
       this.mebSobrenome = mebSobrenome;
       this.mebGenero = mebGenero;
       this.mebRg = mebRg;
       this.mebCpf = mebCpf;
       this.mebCep = mebCep;
       this.mebEndereco = mebEndereco;
       this.mebNumCasa = mebNumCasa;
       this.mebBairro = mebBairro;
       this.mebEstado = mebEstado;
       this.mebPais = mebPais;
       this.mebCelular = mebCelular;
       this.mebEmail = mebEmail;
       this.mebTelefoneResidencial = mebTelefoneResidencial;
    }
   
     @Id 

    
    @Column(name="id_meb_clientes", unique=true, nullable=false)
    public int getIdMebClientes() {
        return this.idMebClientes;
    }
    
    public void setIdMebClientes(int idMebClientes) {
        this.idMebClientes = idMebClientes;
    }

    
    @Column(name="meb_nome", nullable=false, length=45)
    public String getMebNome() {
        return this.mebNome;
    }
    
    public void setMebNome(String mebNome) {
        this.mebNome = mebNome;
    }

    
    @Column(name="meb_sobrenome", nullable=false, length=45)
    public String getMebSobrenome() {
        return this.mebSobrenome;
    }
    
    public void setMebSobrenome(String mebSobrenome) {
        this.mebSobrenome = mebSobrenome;
    }

    
    @Column(name="meb_genero", length=20)
    public String getMebGenero() {
        return this.mebGenero;
    }
    
    public void setMebGenero(String mebGenero) {
        this.mebGenero = mebGenero;
    }

    
    @Column(name="meb_rg", nullable=false, length=15)
    public String getMebRg() {
        return this.mebRg;
    }
    
    public void setMebRg(String mebRg) {
        this.mebRg = mebRg;
    }

    
    @Column(name="meb_cpf", nullable=false, length=20)
    public String getMebCpf() {
        return this.mebCpf;
    }
    
    public void setMebCpf(String mebCpf) {
        this.mebCpf = mebCpf;
    }

    
    @Column(name="meb_cep", nullable=false, length=30)
    public String getMebCep() {
        return this.mebCep;
    }
    
    public void setMebCep(String mebCep) {
        this.mebCep = mebCep;
    }

    
    @Column(name="meb_endereco", nullable=false, length=45)
    public String getMebEndereco() {
        return this.mebEndereco;
    }
    
    public void setMebEndereco(String mebEndereco) {
        this.mebEndereco = mebEndereco;
    }

    
    @Column(name="meb_numCasa", nullable=false, length=10)
    public String getMebNumCasa() {
        return this.mebNumCasa;
    }
    
    public void setMebNumCasa(String mebNumCasa) {
        this.mebNumCasa = mebNumCasa;
    }

    
    @Column(name="meb_bairro", nullable=false, length=45)
    public String getMebBairro() {
        return this.mebBairro;
    }
    
    public void setMebBairro(String mebBairro) {
        this.mebBairro = mebBairro;
    }

    
    @Column(name="meb_estado", nullable=false)
    public int getMebEstado() {
        return this.mebEstado;
    }
    
    public void setMebEstado(int mebEstado) {
        this.mebEstado = mebEstado;
    }

    
    @Column(name="meb_pais", nullable=false)
    public int getMebPais() {
        return this.mebPais;
    }
    
    public void setMebPais(int mebPais) {
        this.mebPais = mebPais;
    }

    
    @Column(name="meb_celular", nullable=false, length=45)
    public String getMebCelular() {
        return this.mebCelular;
    }
    
    public void setMebCelular(String mebCelular) {
        this.mebCelular = mebCelular;
    }

    
    @Column(name="meb_email", length=45)
    public String getMebEmail() {
        return this.mebEmail;
    }
    
    public void setMebEmail(String mebEmail) {
        this.mebEmail = mebEmail;
    }

    
    @Column(name="meb_telefoneResidencial", nullable=false, length=45)
    public String getMebTelefoneResidencial() {
        return this.mebTelefoneResidencial;
    }
    
    public void setMebTelefoneResidencial(String mebTelefoneResidencial) {
        this.mebTelefoneResidencial = mebTelefoneResidencial;
    }
}


