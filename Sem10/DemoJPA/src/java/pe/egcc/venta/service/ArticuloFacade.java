/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.venta.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.egcc.venta.domain.Articulo;

/**
 *
 * @author Alumno-CT
 */
@Stateless
public class ArticuloFacade extends AbstractFacade<Articulo> {

  @PersistenceContext(unitName = "DemoJPAPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ArticuloFacade() {
    super(Articulo.class);
  }
  
}
