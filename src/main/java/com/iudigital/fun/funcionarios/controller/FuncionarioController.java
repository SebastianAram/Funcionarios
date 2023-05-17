
package com.iudigital.fun.funcionarios.controller;

import com.iudigital.fun.funcionarios.data.FuncionarioDao;
import com.iudigital.fun.funcionarios.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;


public class FuncionarioController {
    
   private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }
    public List<Funcionario> obtenerFuncionarios() throws SQLException{
        return funcionarioDao.obtenerFuncionarios();
    }
   
    public void crear(Funcionario funcionario) throws SQLException{
        funcionarioDao.crear(funcionario);
    }
    
    public Funcionario obtenerFuncionario(int id) throws SQLException{
        return funcionarioDao.obtenerFuncionario(id);
    }
    
    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(id, funcionario);
    }
    
    public void eliminarFuncionario(int id) throws SQLException{
        funcionarioDao.eliminarFuncionario(id);
    }
}
