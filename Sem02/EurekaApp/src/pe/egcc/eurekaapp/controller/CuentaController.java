package pe.egcc.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eureka.service.CuentaService;

public class CuentaController {


  private CuentaService cuentaService;

  public CuentaController() {
    cuentaService = new CuentaService();
  }

  public double conSaldoCuenta(String cuenta) {
    return cuentaService.conSaldoCuenta(cuenta);
  }

  public List<Map<String, ?>> conMovimientos(String cuenta) {
    return cuentaService.conMovimientos(cuenta);
  }
  
  
  
  
}
