package ken.ball.inventory.entity;

public class Order {

/*
    UIM_ORD_OID               NUMBER,
    UIM_ORD_OTYPE             VARCHAR2(255 BYTE),
    VERSION                   NUMBER              DEFAULT 0,
    UIM_ORD_TYPE              VARCHAR2(10 BYTE),
    UIM_ORD_SUBTYPE           VARCHAR2(10 BYTE),
    SERV_REQ_DATE             DATE,
    REQ_BANDWIDTH             NUMBER,
    BW_ASSURANCE_TYPE         VARCHAR2(5 BYTE),
    REF_SERVICE_TYPE          VARCHAR2(10 BYTE),
    REF_SERVICE_NO            VARCHAR2(10 BYTE),
    L1_ORDER_NO               VARCHAR2(20 BYTE),
    DEPLOYMENT_METHOD         VARCHAR2(20 BYTE),
    CREATED_T                 DATE                DEFAULT sysdate,
    MOD_T                     DATE                DEFAULT sysdate,
    EFF_T                     DATE,
    TERM_T                    DATE,
    STATUS                    VARCHAR2(50 BYTE),
    CREATED_BY                VARCHAR2(255 BYTE),
    MODIFIED_BY               VARCHAR2(255 BYTE),
    NAME                      VARCHAR2(255 BYTE),
    DESCR                     VARCHAR2(255 BYTE),
    FR_L1PID                  VARCHAR2(20 BYTE),
    TO_L1PID                  VARCHAR2(20 BYTE),
    FR_STBTYPE                VARCHAR2(10 BYTE),
    TO_STBTYPE                VARCHAR2(10 BYTE),
    SRVBDRY_NUM               VARCHAR2(6 BYTE),
    LOT_HSE_IND               VARCHAR2(1 BYTE),
    UNIT_NUM                  VARCHAR2(5 BYTE),
    FLOOR_NUM                 VARCHAR2(3 BYTE),
    BUILD_SEQ                 NUMBER(22),
    BUILD_CD                  VARCHAR2(3 BYTE),
    BUILD_NAME                VARCHAR2(30 BYTE),
    DISTR_NUM                 NUMBER(22),
    HLOT_NUM                  VARCHAR2(15 BYTE),
    LDLOT_NUM                 VARCHAR2(8 BYTE),
    SECT_CD                   VARCHAR2(4 BYTE),
    STREET_NUM                VARCHAR2(11 BYTE),
    STREET_NAME               VARCHAR2(23 BYTE),
    ST_CATG_CD                VARCHAR2(3 BYTE),
    ADDTL_WORKGROUP           VARCHAR2(50 BYTE),
    AREA_CD                   VARCHAR2(20 BYTE),
    AREANAME                  VARCHAR2(20 BYTE),
    DEPLOYMENT_SCENARIO       VARCHAR2(20 BYTE),
    FAILED_REASON             VARCHAR2(255 BYTE),
    OC_ID                     VARCHAR2(20 BYTE),
    UIM_ORD_SYS               VARCHAR2(5 BYTE),
    CUSTOMER_NAME             VARCHAR2(255 BYTE),
    NEXT_SYSTEM               VARCHAR2(10 BYTE),
    ASSIGNED_STAFF_NO         VARCHAR2(20 BYTE),
    APPLY_DT                  DATE,
    ACTION_TYPE               VARCHAR2(3 BYTE),
    LEGACY_COMPL_DATE         DATE,
    ORD_COMPL_DATE            DATE,
    L2ORDNUM                  VARCHAR2(12 BYTE),
    PROJ_CODE                 VARCHAR2(20 BYTE),
    GON                       NUMBER(12),
    CXS_REQUEST_NO            NUMBER(6),
    CXS_ACTIVITY_NO           NUMBER(5),
    SYS_MSG                   VARCHAR2(255 BYTE),
    REAL_ID                   VARCHAR2(8 BYTE),
    REAL_DATE                 DATE,
    MODEM_CODE                VARCHAR2(50 BYTE),
    FR_NID                    VARCHAR2(32 BYTE),
    BW_S                      NUMBER,
    BW_B                      NUMBER,
    BW_P                      NUMBER,
    BW_V                      NUMBER,
    ON_DMD_PON_SB             VARCHAR2(1 BYTE),
    SALES_TYPE                VARCHAR2(30 BYTE),
    ORDSUBTYPE                VARCHAR2(1 BYTE),
    ACCT_MGR                  VARCHAR2(40 BYTE),
    ASM                       VARCHAR2(40 BYTE),
    FIRST_ISS_DATE            DATE,
    FIRST_SR_DATE             DATE,
    USER_NAME                 VARCHAR2(80 BYTE),
    ISS_STAFF_ID              VARCHAR2(12 BYTE),
    CUST_CONTACT_NAME         VARCHAR2(40 BYTE),
    CUST_CONTACT_PHONE        VARCHAR2(64 BYTE),
    CUST_CONTACT_FAX          VARCHAR2(64 BYTE),
    STATUS_DATE               DATE,
    SERVICE_CD                VARCHAR2(900 BYTE),
    UIM_TORD_TYPE             VARCHAR2(1 BYTE),
    PRODGRP                   VARCHAR2(30 BYTE),
    RESOURCE_USED_UP_DATE     DATE,
    FIRST_CALL_DATE           DATE,
    RESOURCE_USED_UP_BY       VARCHAR2(8 BYTE),
    EXTEND_COVERAGE_RPT_DATE  DATE,
    EXTEND_COVERAGE_RPT_BY    VARCHAR2(8 BYTE),
    DRAGON_STATUS             VARCHAR2(1 BYTE),
    DRAGON_STATUS_MOD_T       DATE,
    RESUME_RPT_DATE           DATE,
    ACCT_TYPE                 VARCHAR2(1 BYTE),
    BW_2N                     VARCHAR2(10 BYTE),
    L2_JOB                    VARCHAR2(10 BYTE),
    L2_MODEM_CODE             VARCHAR2(20 BYTE),
    EYE_TYPE                  VARCHAR2(80 BYTE),
    FTTD_IND                  VARCHAR2(10 BYTE),
    FIBRE_DROP_IND            VARCHAR2(50 BYTE),
    WIRING_STATUS             VARCHAR2(20 BYTE),
    WIRING_STATUS_UPD_BY      VARCHAR2(8 BYTE),
    WIRING_STATUS_UPD_DATE    DATE,
    FALLBACK_IND              VARCHAR2(1 BYTE),
    DRAGON_ORDER_NO           VARCHAR2(20 BYTE),
    SERVICE_NO_PREFIX         VARCHAR2(2 BYTE),
    L2_MODEM_GRP              VARCHAR2(20 BYTE),
    RESOURCE_USED_UP_REASON   VARCHAR2(100 BYTE),
    RESOURCE_USED_UP_REMARK   VARCHAR2(50 BYTE),
    STILL_FALLOUT_RPT_DATE    DATE,
    VENDOR_IND                VARCHAR2(50 BYTE),
    PLATFORM_IND              VARCHAR2(50 BYTE),
    FIBRE_DROP_IND_FS         VARCHAR2(50 BYTE),
    DIV_IND                   VARCHAR2(20 BYTE),
    DIV_REF_TYPE              VARCHAR2(10 BYTE),
    DIV_REF_NO                VARCHAR2(10 BYTE),
    DIV_TYPE                  VARCHAR2(20 BYTE),
    FSA_NO                    VARCHAR2(8 BYTE),
    CAN_REISSUE_BSN           VARCHAR2(10 BYTE),
    PLANNING_TEAM             VARCHAR2(10 BYTE),
    BR_NO                     VARCHAR2(30 BYTE)

 */
    private Long id;
    private Profile profile;
    private EMOrder emOrder;
    private String refSrvType;
    private String refSrvNo;
    private String orderType;
    private String orderSubType;
    private String SrvReqDate;
    private String deploymentScenario;
    private String status;
    private String failedReason;
    private String orderCompletionDate;
    private String frL1Pid;
    private String frStbType;
    private String toL1Pid;
    private String toStbType;
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
