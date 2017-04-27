Connection cn = null;    
try {
  // Inicio de la Tx
  cn = AccesoDB.getConnection();
  cn.setAutoCommit(false);
  
} catch (SQLException e) {
  try {
	cn.rollback();
  } catch (Exception e1) {
  }
  throw new RuntimeException(e.getMessage());
} catch (Exception e) {
  try {
	cn.rollback();
  } catch (Exception e1) {
  }
  throw new RuntimeException("Error en el proceso.");
} finally {
  try {
	cn.close();
  } catch (Exception e) {
  }
}