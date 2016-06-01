/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oncore.chhs.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author oncore
 */
@Entity
@Table(name = "CONTACT")
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMC_UID")
    private Integer emcUid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "EMC_VALUE")
    private String emcValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CREATE_USER_ID")
    private String createUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "UPDATE_USER_ID")
    private String updateUserId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPDATE_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTs;
    @JoinColumn(name = "EMC_TYPE_CD", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private EmcTypeCd emcTypeCd;
    @JoinColumn(name = "USR_UID_FK", referencedColumnName = "USR_UID")
    @ManyToOne(optional = false)
    private Users usrUidFk;

    public Contact() {
    }

    public Contact(Integer emcUid) {
        this.emcUid = emcUid;
    }

    public Contact(Integer emcUid, String emcValue, String createUserId, Date createTs, String updateUserId, Date updateTs) {
        this.emcUid = emcUid;
        this.emcValue = emcValue;
        this.createUserId = createUserId;
        this.createTs = createTs;
        this.updateUserId = updateUserId;
        this.updateTs = updateTs;
    }

    public Integer getEmcUid() {
        return emcUid;
    }

    public void setEmcUid(Integer emcUid) {
        this.emcUid = emcUid;
    }

    public String getEmcValue() {
        return emcValue;
    }

    public void setEmcValue(String emcValue) {
        this.emcValue = emcValue;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public EmcTypeCd getEmcTypeCd() {
        return emcTypeCd;
    }

    public void setEmcTypeCd(EmcTypeCd emcTypeCd) {
        this.emcTypeCd = emcTypeCd;
    }

    public Users getUsrUidFk() {
        return usrUidFk;
    }

    public void setUsrUidFk(Users usrUidFk) {
        this.usrUidFk = usrUidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emcUid != null ? emcUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.emcUid == null && other.emcUid != null) || (this.emcUid != null && !this.emcUid.equals(other.emcUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oncore.chhs.persistence.entity.Contact[ emcUid=" + emcUid + " ]";
    }
    
}
