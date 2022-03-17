package co.edu.udea.practicafinal.dtos.helpers;

public enum EnumRolesDto {
  RESEARCHER("Investigador"),
  RESEARCH_LEADER("Lider de Investigador"),
  ADMINISTRATOR("Administrador");

  private String description;

  EnumRolesDto(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
