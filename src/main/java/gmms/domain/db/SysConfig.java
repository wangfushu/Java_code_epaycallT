package gmms.domain.db;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangfs on 2017-09-05 helloword.
 */

@Entity
@Table(name = "SYS_CONFIG")
@SuppressWarnings("serial")
@IdClass(SysConfigPK.class)
public class SysConfig {

    @Id
    @Column(name = "CF_PLAZANO")
    private String cfPlazaNo;

    @Id
    @Column(name = "CF_CONFIGNAME")
    private String cfConfigName;


    @Column(name = "CF_CONFIGVALUE")
    private String cfConfigValue;

    @Column(name = "CF_CONFIGDESCRIPTION")
    private String cfConfigDescription;

    @Id
    @Column(name = "CF_PCNO")
    private String cfPCNo;

    @Column(name = "CF_UPDATETIME")
    private Date cfUpdateTime;

    public String getCfPlazaNo() {
        return cfPlazaNo;
    }

    public void setCfPlazaNo(String cfPlazaNo) {
        this.cfPlazaNo = cfPlazaNo;
    }

    public String getCfConfigName() {
        return cfConfigName;
    }

    public void setCfConfigName(String cfConfigName) {
        this.cfConfigName = cfConfigName;
    }

    public String getCfConfigValue() {
        return cfConfigValue;
    }

    public void setCfConfigValue(String cfConfigValue) {
        this.cfConfigValue = cfConfigValue;
    }

    public String getCfConfigDescription() {
        return cfConfigDescription;
    }

    public void setCfConfigDescription(String cfConfigDescription) {
        this.cfConfigDescription = cfConfigDescription;
    }

    public String getCfPCNo() {
        return cfPCNo;
    }

    public void setCfPCNo(String cfPCNo) {
        this.cfPCNo = cfPCNo;
    }

    public Date getCfUpdateTime() {
        return cfUpdateTime;
    }

    public void setCfUpdateTime(Date cfUpdateTime) {
        this.cfUpdateTime = cfUpdateTime;
    }
}
