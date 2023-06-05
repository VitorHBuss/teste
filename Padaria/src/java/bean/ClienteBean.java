/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author vhbus
 */
import bd.BdCliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import vo.Cliente;
@ManagedBean
@SessionScoped
public class ClienteBean {
    private Cliente cliente;
    private final BdCliente bda = new BdCliente();
    private DataModel<Cliente> lista;
    public ClienteBean(){
        atualizaLista();
    }
    public String salva(){
        bda.salva(cliente);
        atualizaLista();
        return "index";
    }
    public final void atualizaLista(){
        lista = new ListDataModel (bda.pesquisa(""));
    }
    public String exclui() {
        cliente = lista.getRowData();
        bda.exclui(cliente.getCodigo());
        atualizaLista();
        return "";
    }
    public String novo() {
        cliente = new Cliente();
        cliente.setNome(cliente.getNome());
        return "cadastro";
    }
    public String edita() {
        cliente = lista.getRowData();
        return "cliente";
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    /**
     * @return the lista
     */
    public DataModel<Cliente> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(DataModel<Cliente> lista) {
        this.lista = lista;
    }
}
