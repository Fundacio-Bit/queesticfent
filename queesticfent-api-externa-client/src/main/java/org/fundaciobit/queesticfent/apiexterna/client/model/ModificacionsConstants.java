/*
 * API REST EXTERNA de queesticfent
 * Conjunt de Serveis REST de queesticfent per ser accedits des de l'exterior
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: otae@fundaciobit.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.fundaciobit.queesticfent.apiexterna.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ModificacionsConstants
 */
@JsonPropertyOrder({
  ModificacionsConstants.JSON_PROPERTY_R_O_L_E_E_J_B_F_U_L_L_A_C_C_E_S_S,
  ModificacionsConstants.JSON_PROPERTY_R_O_L_E_E_J_B_B_A_S_I_C_A_C_C_E_S_S,
  ModificacionsConstants.JSON_PROPERTY_R_O_L_E_E_J_B_W_S_A_C_C_E_S_S
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ModificacionsConstants {
  public static final String JSON_PROPERTY_R_O_L_E_E_J_B_F_U_L_L_A_C_C_E_S_S = "ROLE_EJB_FULL_ACCESS";
  private String ROLE_EJB_FULL_ACCESS = "QEF_ADMIN";

  public static final String JSON_PROPERTY_R_O_L_E_E_J_B_B_A_S_I_C_A_C_C_E_S_S = "ROLE_EJB_BASIC_ACCESS";
  private Integer ROLE_EJB_BASIC_ACCESS;

  public static final String JSON_PROPERTY_R_O_L_E_E_J_B_W_S_A_C_C_E_S_S = "ROLE_EJB_WS_ACCESS";
  private Integer ROLE_EJB_WS_ACCESS;

  public ModificacionsConstants() {
  }

  @JsonCreator
  public ModificacionsConstants(
    @JsonProperty(JSON_PROPERTY_R_O_L_E_E_J_B_F_U_L_L_A_C_C_E_S_S) String ROLE_EJB_FULL_ACCESS, 
    @JsonProperty(JSON_PROPERTY_R_O_L_E_E_J_B_B_A_S_I_C_A_C_C_E_S_S) Integer ROLE_EJB_BASIC_ACCESS, 
    @JsonProperty(JSON_PROPERTY_R_O_L_E_E_J_B_W_S_A_C_C_E_S_S) Integer ROLE_EJB_WS_ACCESS
  ) {
    this();
    this.ROLE_EJB_FULL_ACCESS = ROLE_EJB_FULL_ACCESS;
    this.ROLE_EJB_BASIC_ACCESS = ROLE_EJB_BASIC_ACCESS;
    this.ROLE_EJB_WS_ACCESS = ROLE_EJB_WS_ACCESS;
  }

   /**
   * Constant ROLE_EJB_FULL_ACCESS
   * @return ROLE_EJB_FULL_ACCESS
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_R_O_L_E_E_J_B_F_U_L_L_A_C_C_E_S_S)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getROLEEJBFULLACCESS() {
    return ROLE_EJB_FULL_ACCESS;
  }




   /**
   * Constant ROLE_EJB_BASIC_ACCESS
   * @return ROLE_EJB_BASIC_ACCESS
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_R_O_L_E_E_J_B_B_A_S_I_C_A_C_C_E_S_S)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getROLEEJBBASICACCESS() {
    return ROLE_EJB_BASIC_ACCESS;
  }




   /**
   * Constant ROLE_EJB_WS_ACCESS
   * @return ROLE_EJB_WS_ACCESS
  **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_R_O_L_E_E_J_B_W_S_A_C_C_E_S_S)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getROLEEJBWSACCESS() {
    return ROLE_EJB_WS_ACCESS;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModificacionsConstants modificacionsConstants = (ModificacionsConstants) o;
    return Objects.equals(this.ROLE_EJB_FULL_ACCESS, modificacionsConstants.ROLE_EJB_FULL_ACCESS) &&
        Objects.equals(this.ROLE_EJB_BASIC_ACCESS, modificacionsConstants.ROLE_EJB_BASIC_ACCESS) &&
        Objects.equals(this.ROLE_EJB_WS_ACCESS, modificacionsConstants.ROLE_EJB_WS_ACCESS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ROLE_EJB_FULL_ACCESS, ROLE_EJB_BASIC_ACCESS, ROLE_EJB_WS_ACCESS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModificacionsConstants {\n");
    sb.append("    ROLE_EJB_FULL_ACCESS: ").append(toIndentedString(ROLE_EJB_FULL_ACCESS)).append("\n");
    sb.append("    ROLE_EJB_BASIC_ACCESS: ").append(toIndentedString(ROLE_EJB_BASIC_ACCESS)).append("\n");
    sb.append("    ROLE_EJB_WS_ACCESS: ").append(toIndentedString(ROLE_EJB_WS_ACCESS)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

