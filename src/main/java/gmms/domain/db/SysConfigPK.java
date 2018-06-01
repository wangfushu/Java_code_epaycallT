package gmms.domain.db;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * Created by wangfs on 2017-09-05 helloword.
 */


public class SysConfigPK implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CF_PLAZANO")
    private String cfPlazaNo;

    @Id
    @Column(name = "CF_CONFIGNAME")
    private String cfConfigName;

    @Id
    @Column(name = "CF_PCNO")
    private String cfPCNo;

    public SysConfigPK(String cfPlazaNo, String cfConfigName, String cfPCNo) {
        this.cfPlazaNo = cfPlazaNo;
        this.cfConfigName = cfConfigName;
        this.cfPCNo = cfPCNo;
    }

    public SysConfigPK() {
    }
}
