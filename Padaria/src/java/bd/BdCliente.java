/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

/**
 *
 * @author vhbus
 */
import vo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BdCliente {
    public void insere (Cliente cliente){
        String sql = "insert into cliente (nome, cep, rua, bairro, numero, complemento, cidade, estado, telefone, cpf, rg) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Bd.getCon().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCep());
            ps.setString(3, cliente.getRua());
            ps.setString(4, cliente.getBairro());
            ps.setString(5, cliente.getNumero());
            ps.setString(6, cliente.getComplemento());
            ps.setString(7, cliente.getCidade());
            ps.setString(8, cliente.getEstado());
            ps.setString(9, cliente.getTelefone());
            ps.setString(10, cliente.getCpf());
            ps.setString(11, cliente.getRg());
            ps.execute();
        }
        catch (SQLException e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    public void salva (Cliente cliente){
        if(cliente.getCodigo() == 0){
            insere(cliente);
        }
        else{
            String sql = "update cliente set nome = ?, cep = ?, rua = ?, bairro = ?, numero = ?, complemento = ?, cidade = ?, estado = ?, telefone = ?, cpf = ?, rg = ? where codigo = ?";
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(12, cliente.getCodigo());
                ps.setString(1,cliente.getNome());
                ps.setString(2,cliente.getCep());
                ps.setString(3,cliente.getRua());
                ps.setString(4,cliente.getBairro());
                ps.setString(5,cliente.getNumero());
                ps.setString(6,cliente.getComplemento());
                ps.setString(7,cliente.getCidade());
                ps.setString(8,cliente.getEstado());
                ps.setString(9,cliente.getTelefone());
                ps.setString(10,cliente.getCpf());
                ps.setString(11,cliente.getRg());
                ps.execute();
            } catch (SQLException e){
                System.out.println("Erro SQL: " + e.getMessage());
            }
        }
    }
        public Cliente localiza(int codigo){
            String sql = "select * from cliente where codigo=?";
            Cliente registro = new Cliente();
            try {
                PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                ps.setInt(1, codigo);
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    registro.setCodigo(rs.getInt("codigo"));
                    registro.setNome(rs.getString("nome"));
                    registro.setCep(rs.getString("cep"));
                    registro.setRua(rs.getString("rua"));
                    registro.setBairro(rs.getString("bairro"));
                    registro.setNumero(rs.getString("numero"));
                    registro.setComplemento(rs.getString("complemento"));
                    registro.setCidade(rs.getString("cidade"));
                    registro.setEstado(rs.getString("estado"));
                    registro.setTelefone(rs.getString("telefone"));
                    registro.setCpf(rs.getString("cpf"));
                    registro.setRg(rs.getString("rg"));
                }
            }
                catch (SQLException e){
                        System.out.println("Erro SQL: " + e.getMessage());
                        }
                return registro;
            }
            public List pesquisa(String busca){
                String sql = "select * from cliente where nome like ?";
                List lista = new ArrayList();
                try{
                    PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                    ps.setString(1, "%" + busca + "%");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Cliente registro = new Cliente();
                        registro.setCodigo(rs.getInt("codigo"));
                        registro.setNome(rs.getString("nome"));
                        registro.setCep(rs.getString("cep"));
                        registro.setRua(rs.getString("rua"));
                        registro.setBairro(rs.getString("bairro"));
                        registro.setNumero(rs.getString("numero"));
                        registro.setComplemento(rs.getString("complemento"));
                        registro.setCidade(rs.getString("cidade"));
                        registro.setEstado(rs.getString("estado"));
                        registro.setTelefone(rs.getString("telefone"));
                        registro.setCpf(rs.getString("cpf"));
                        registro.setRg(rs.getString("rg"));
                        lista.add(registro);
                    }
                }
                catch (SQLException e) {
                    System.out.println("Erro SQL: " + e.getMessage());
                }
                return lista;
            }
            public void exclui(int codigo) {
                String sql = "delete from cliente where codigo = ?";
                try{
                    PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                    ps.setInt (1, codigo);
                    ps.execute();
                }
                catch (SQLException e){
                    System.out.println("Erro SQL: " + e.getMessage());
                }
            }
        }