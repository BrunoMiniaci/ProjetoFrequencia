package br.mack.ps2;

import br.mack.ps2.persistencia.ControleDAOMySQL;

import java.sql.*;
public class App {
    public static void main(final String[] args) {
        ControleDAOMySQL mysqlDAO = new ControleDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}