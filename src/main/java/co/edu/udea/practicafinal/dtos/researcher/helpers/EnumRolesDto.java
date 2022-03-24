package co.edu.udea.practicafinal.dtos.researcher.helpers;

/**
 * Clase de tipo enunm de Tranferencia de Datos (Dto) para contener la informacion de los diferentes roles de la aplicacion
 */
public enum EnumRolesDto {
  RESEARCHER("Investigador"),
  RESEARCH_LEADER("Lider de Investigacion"),
  ADMINISTRATOR("Administrador");

  private String description;

  EnumRolesDto(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
