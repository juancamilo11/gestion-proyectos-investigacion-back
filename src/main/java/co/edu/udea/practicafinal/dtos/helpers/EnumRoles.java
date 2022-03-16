package co.edu.udea.practicafinal.dtos.helpers;

public enum EnumRoles {
  RESEARCHER("Investigador"),
  RESEARCH_LEADER("Lider de Investigador"),
  ADMINISTRATOR("Administrador");

  private String description;

  EnumRoles(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
