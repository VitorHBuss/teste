/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

/**
 *
 * @author vhbus
 */
import vo.Produtos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BdProdutos {
                public List pesquisa(String busca){
                String sql = "select * from produtos where nome like ?";
                List lista = new ArrayList();
                try{
                    PreparedStatement ps = Bd.getCon().prepareStatement(sql);
                    ps.setString(1, "%" + busca + "%");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Produtos registro = new Produtos();
                        registro.setNome(rs.getString("nome"));
                        lista.add(registro);
                    }
                }
                catch (SQLException e) {
                    System.out.println("Erro SQL: " + e.getMessage());
                }
                return lista;
            }
}