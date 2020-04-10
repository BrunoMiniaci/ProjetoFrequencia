package br.mack.ps2.persistencia;

import br.mack.ps2.entidades.Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleDAOMySQL implements ControleDAO {
    private String createSQL = "INSERT INTO aluno VALUES (?, ?, ?)";
    private String readSQL = "SELECT * FROM aluno";
    private String updateSQL = "UPDATE aluno SET nome=?, curso=? WHERE id=?";
    private String deleteSQL = "DELETE FROM aluno WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Controle controle) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            //Inicializando os valores
            stm.setLong(1, controle.getTia());
            stm.setString(2, controle.getEntrada());
            stm.setString(3, controle.getSaida());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Controle> read() {
        Connection conexao = mysql.getConnection();
        List<Controle> controles = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Controle controle = new Controle();
                controle.setTia(rs.getInt("Tia"));
                controle.setEntrada(rs.getString("Entrada"));
                controle.setSaida(rs.getString("Saida"));
                controles.add(controle);
            }

            return controles;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return controles;
    }

    @Override
    public boolean update(Controle controle) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setString(1, controle.getEntrada());
            stm.setString(2, controle.getSaida());
            stm.setLong(3, controle.getTia());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Controle controle) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setLong(1, controle.getTia());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return  registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
