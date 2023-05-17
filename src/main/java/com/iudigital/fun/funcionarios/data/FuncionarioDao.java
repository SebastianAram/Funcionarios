
package com.iudigital.fun.funcionarios.data;

import com.iudigital.fun.funcionarios.domain.Funcionario;
import com.iudigital.fun.funcionarios.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao {
    
    private static final String GET_FUNCIONARIOS = "select * from Funcionarios";
    private static final String CREATE_FUNCIONARIOS = "INSERT INTO Funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, estado_civil, sexo, direccion, telefono, fecha_nacimiento, id_grupo, id_academia)\n" +
                            "VALUES\n" +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String GET_FUNCIONARIOID = "select * from Funcionarios where id = ?";
    
    private static final String UPDATE_FUNCIONARIOS = "update Funcionarios set tipo_identificacion = ?, numero_identificacion = ?, nombres = ?, apellidos = ?, estado_civil = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?, id_grupo = ?, id_academia = ? where id = ?";
    
    private static final String DELETE_FUNCIONARIOS = "delete from Funcionarios where id = ?";
    
    public List<Funcionario> obtenerFuncionarios () throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList <> ();
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setIdGrupo(resultSet.getInt("id_grupo"));
                funcionario.setIdAcademia(resultSet.getInt("id_academia"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
        } finally {
            if (connection != null) {
                connection.close();
        }
            if (preparedStatement != null) {
                preparedStatement.close();
        }
            if (resultSet != null) {
                resultSet.close();
        }
        }
        
    }
    
    public void crear(Funcionario funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIOS);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setInt(10, funcionario.getIdGrupo());
            preparedStatement.setInt(11, funcionario.getIdAcademia());
            preparedStatement.executeUpdate();
        } finally{
            if (connection != null) {
                connection.close();
        }
            if (preparedStatement != null) {
                preparedStatement.close();
        }
        }
    }
    
    public Funcionario obtenerFuncionario(int id) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setIdGrupo(resultSet.getInt("id_grupo"));
                funcionario.setIdAcademia(resultSet.getInt("id_academia"));
            }
            return funcionario;
        } finally{
            if (connection != null) {
                connection.close();
        }
            if (preparedStatement != null) {
                preparedStatement.close();
        }
            if (resultSet != null) {
                resultSet.close();
        }
        }
    }
    public void actualizarFuncionario (int id, Funcionario funcionario) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIOS);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setInt(10, funcionario.getIdGrupo());
            preparedStatement.setInt(11, funcionario.getIdAcademia());
            preparedStatement.setInt(12, funcionario.getId());
            preparedStatement.executeUpdate();
        } finally{
            if (connection != null) {
                connection.close();
        }
            if (preparedStatement != null) {
                preparedStatement.close();
        }
        }
    }
    
    public void eliminarFuncionario(int id) throws SQLException { 
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIOS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally{
            if (connection != null) {
                connection.close();
        }
            if (preparedStatement != null) {
                preparedStatement.close();
        }
        }
    }
}
