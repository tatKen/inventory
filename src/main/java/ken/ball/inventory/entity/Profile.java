package ken.ball.inventory.entity;

public class Profile {
//    UIM_LINK_OID        NUMBER,
//    UIM_LINK_OTYPE      VARCHAR2(255 BYTE),
//    VERSION             NUMBER                    DEFAULT 0,
//    CREATED_T           DATE                      DEFAULT sysdate,
//    MOD_T               DATE                      DEFAULT sysdate,
//    EFF_T               DATE,
//    TERM_T              DATE,
//    STATUS              VARCHAR2(10 BYTE),
//    CREATED_BY          VARCHAR2(255 BYTE),
//    MODIFIED_BY         VARCHAR2(255 BYTE),
//    NAME                VARCHAR2(255 BYTE),
//    DESCR               VARCHAR2(255 BYTE),
//    DEPLOYMENT_METHOD   VARCHAR2(20 BYTE),
//    SCENARIO            VARCHAR2(255 BYTE),
//    REF_SERVICE_TYPE    VARCHAR2(10 BYTE),
//    REF_SERVICE_NO      VARCHAR2(10 BYTE),
//    LAST_L1_ORD_NO      VARCHAR2(20 BYTE),
//    ADDTL_WORKGROUP     VARCHAR2(50 BYTE),
//    SRVBDRY_NUM         VARCHAR2(6 BYTE),
//    UNIT_NUM            VARCHAR2(5 BYTE),
//    FLOOR_NUM           VARCHAR2(3 BYTE),
//    VCI                 VARCHAR2(10 BYTE),
//    VPI                 VARCHAR2(10 BYTE),
//    CUST_IP             VARCHAR2(20 BYTE),
//    SUBLOCAL_INFO       VARCHAR2(50 BYTE),
//    ONT_POWER_LEVEL     VARCHAR2(20 BYTE),
//    REAL_ID             VARCHAR2(8 BYTE),
//    REAL_DATE           DATE,
//    BW_2N               VARCHAR2(10 BYTE),
//    FTTD_IND            VARCHAR2(10 BYTE),
//    FIBRE_DROP_IND      VARCHAR2(50 BYTE),
//    SERVICE_NO_PREFIX   VARCHAR2(2 BYTE),
//    LAST_DRAGON_ORD_NO  VARCHAR2(20 BYTE),
//    VENDOR_IND          VARCHAR2(50 BYTE),
//    PLATFORM_IND        VARCHAR2(50 BYTE),
//    FIBRE_DROP_IND_FS   VARCHAR2(50 BYTE),
//    DIV_IND             VARCHAR2(20 BYTE),
//    DIV_REF_TYPE        VARCHAR2(10 BYTE),
//    DIV_REF_NO          VARCHAR2(10 BYTE),
//    DIV_TYPE            VARCHAR2(20 BYTE),
//    FSA_NO              VARCHAR2(8 BYTE)

    private Long id;
    private String profileType;
    private EMProfile emProfile;
    private Linkconn linkconn;
    private LinkOnt linkOnt;
    private Order order;
    private String status;
    private String deploymentMethod;
    private String scenario;
    private String l1Pid;
    private String stbType;
    private String sbNo;
    private String floor;
    private String unit;
    private String buildingName;
    private String distrNo;
    private String streetNo;
    private String streetName;
    private String distrCd;
    private String sectCd;
    private String areaCd;
    private String customerName;
    private String customerPhone;
    private String modemCd;
    private int bwB;
    private int bwP;
    private int bwS;
    private int bwV;
}
