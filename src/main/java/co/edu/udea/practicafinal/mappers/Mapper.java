package co.edu.udea.practicafinal.mappers;

public interface Mapper {
  <T, R> T mapFromEntityToDto(T value);
  <T, R> T mapFromDtoToEntity(T value);
}
