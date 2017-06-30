/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.isil.colegio.controller;

import isil.colegio.service.PlanificacionService;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author CHRISTIAN
 */
@ManagedBean
public class ListarSecciones {
    
    private List<Map<String, ?>> list;

    public List<Map<String, ?>> getList() {
        return list;
    }

    public void setList(List<Map<String, ?>> list) {
        this.list = list;
    }
    
    
    public void getListaSecciones(){
        PlanificacionService service = new PlanificacionService();
        
        list = service.listarSecciones();
    
    }
    
}
