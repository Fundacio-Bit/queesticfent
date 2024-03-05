
package org.fundaciobit.queesticfent.api.externa.secure.modificacions;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Bean que inclou informació d'una entrada.")
public class ModificacioRest {

    @Schema(type = "integer", format = "int64")
    long modificacioID;// PK
    @Schema(type = "integer", format = "int64")
    long accioID;
    java.lang.String usuariID;
    @Schema(type = "integer", format = "int64")
    long projecteID;
    @JsonProperty("data")
    @Schema(description = "Data de l'entrada", type = "string", format = "date-time", pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssX")
    java.sql.Timestamp data;
    java.lang.String dada1;
    java.lang.String dada2;

    /** Constructor Buit */
    public ModificacioRest() {
    }

    public ModificacioRest(long modificacioID, long accioID, String usuariID, Long projecteID, Timestamp data,
            String dada1, String dada2) {
        super();
        this.modificacioID = modificacioID;
        this.accioID = accioID;
        this.usuariID = usuariID;
        this.projecteID = projecteID;
        this.data = data;
        this.dada1 = dada1;
        this.dada2 = dada2;
    }

    public long getModificacioID() {
        return (modificacioID);
    };

    public void setModificacioID(long _modificacioID_) {
        this.modificacioID = _modificacioID_;
    };

    public long getAccioID() {
        return (accioID);
    };

    public void setAccioID(long _accioID_) {
        this.accioID = _accioID_;
    };

    public java.lang.String getUsuariID() {
        return (usuariID);
    };

    public void setUsuariID(java.lang.String _usuariID_) {
        this.usuariID = _usuariID_;
    };

    public java.lang.Long getProjecteID() {
        return (projecteID);
    };

    public void setProjecteID(java.lang.Long _projecteID_) {
        this.projecteID = _projecteID_;
    };

    public java.sql.Timestamp getData() {
        return (data);
    };

    public void setData(java.sql.Timestamp _data_) {
        this.data = _data_;
    };

    public java.lang.String getDada1() {
        return (dada1);
    };

    public void setDada1(java.lang.String _dada1_) {
        this.dada1 = _dada1_;
    };

    public java.lang.String getDada2() {
        return (dada2);
    };

    public void setDada2(java.lang.String _dada2_) {
        this.dada2 = _dada2_;
    };

}
