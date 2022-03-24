package co.edu.udea.practicafinal.entities.helpers;

/**
 * Clase Entidad, modelo para los atributos de la de los tipos de roles
 */

public enum EnumRoles {
  RESEARCHER("Investigador"),
  RESEARCH_LEADER("Lider de Investigacion"),
  ADMINISTRATOR("Administrador");

  private String description;

  EnumRoles(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
