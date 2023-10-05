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
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Modificacio
 */
@JsonPropertyOrder({
  Modificacio.JSON_PROPERTY_LANGUAGE,
  Modificacio.JSON_PROPERTY_USUARI_I_D,
  Modificacio.JSON_PROPERTY_PROJECTE_I_D,
  Modificacio.JSON_PROPERTY_DATA,
  Modificacio.JSON_PROPERTY_DADA1
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Modificacio {
  public static final String JSON_PROPERTY_LANGUAGE = "language";
  private String language;

  public static final String JSON_PROPERTY_USUARI_I_D = "usuariID";
  private String usuariID;

  public static final String JSON_PROPERTY_PROJECTE_I_D = "projecteID";
  private Long projecteID;

  public static final String JSON_PROPERTY_DATA = "data";
  private OffsetDateTime data;

  public static final String JSON_PROPERTY_DADA1 = "dada1";
  private String dada1;

  public Modificacio() {
  }

  public Modificacio language(String language) {
    
    this.language = language;
    return this;
  }

   /**
   * Get language
   * @return language
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLanguage() {
    return language;
  }


  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLanguage(String language) {
    this.language = language;
  }


  public Modificacio usuariID(String usuariID) {
    
    this.usuariID = usuariID;
    return this;
  }

   /**
   * Get usuariID
   * @return usuariID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_USUARI_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUsuariID() {
    return usuariID;
  }


  @JsonProperty(JSON_PROPERTY_USUARI_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUsuariID(String usuariID) {
    this.usuariID = usuariID;
  }


  public Modificacio projecteID(Long projecteID) {
    
    this.projecteID = projecteID;
    return this;
  }

   /**
   * Get projecteID
   * @return projecteID
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROJECTE_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getProjecteID() {
    return projecteID;
  }


  @JsonProperty(JSON_PROPERTY_PROJECTE_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProjecteID(Long projecteID) {
    this.projecteID = projecteID;
  }


  public Modificacio data(OffsetDateTime data) {
    
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getData() {
    return data;
  }


  @JsonProperty(JSON_PROPERTY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setData(OffsetDateTime data) {
    this.data = data;
  }


  public Modificacio dada1(String dada1) {
    
    this.dada1 = dada1;
    return this;
  }

   /**
   * Get dada1
   * @return dada1
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DADA1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDada1() {
    return dada1;
  }


  @JsonProperty(JSON_PROPERTY_DADA1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDada1(String dada1) {
    this.dada1 = dada1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Modificacio modificacio = (Modificacio) o;
    return Objects.equals(this.language, modificacio.language) &&
        Objects.equals(this.usuariID, modificacio.usuariID) &&
        Objects.equals(this.projecteID, modificacio.projecteID) &&
        Objects.equals(this.data, modificacio.data) &&
        Objects.equals(this.dada1, modificacio.dada1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(language, usuariID, projecteID, data, dada1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Modificacio {\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    usuariID: ").append(toIndentedString(usuariID)).append("\n");
    sb.append("    projecteID: ").append(toIndentedString(projecteID)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    dada1: ").append(toIndentedString(dada1)).append("\n");
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

