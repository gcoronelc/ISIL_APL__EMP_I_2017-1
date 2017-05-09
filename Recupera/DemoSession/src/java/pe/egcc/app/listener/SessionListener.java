package pe.egcc.app.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.err.println("EGCC: Sesion iniciada.");
    List<String> lista = new ArrayList<>();
    se.getSession().setAttribute("lista", lista);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    System.err.println("EGCC: Sesion finalizada.");
  }
}
