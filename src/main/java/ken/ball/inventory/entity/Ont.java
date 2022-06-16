package ken.ball.inventory.entity;

public class Ont {
//    OLT_ID              VARCHAR2(32 BYTE)         NOT NULL,
//    ONT_ID              VARCHAR2(32 BYTE)         NOT NULL,
//    VERSION             NUMBER                    DEFAULT 0,
//    NID                 VARCHAR2(32 BYTE),
//    NIDEN               VARCHAR2(32 BYTE),
//    RTPORT              VARCHAR2(20 BYTE),
//    CREATED_T           DATE                      DEFAULT sysdate,
//    CREATED_BY          VARCHAR2(255 BYTE),
//    MODIFIED_BY         VARCHAR2(255 BYTE),
//    MOD_T               DATE                      DEFAULT sysdate,
//    STATUS              VARCHAR2(10 BYTE),
//    SLOT_ID             VARCHAR2(32 BYTE)         NOT NULL,
//    LAST_SYNC_DATE      DATE                      DEFAULT sysdate,
//    LAST_SYNC_ID        NUMBER,
//    ONT_OID             NUMBER                    NOT NULL,
//    INTERFACE_NO        VARCHAR2(32 BYTE)         NOT NULL,
//    EXCHANGE_ID         VARCHAR2(10 BYTE),
//    REAL_ID             VARCHAR2(8 BYTE),
//    REAL_DATE           DATE,
//    LAST_ASSIGNED_DATE  DATE,
//    PROJECT_CODE        VARCHAR2(20 BYTE),
//    RELEASE_DATE        DATE                      DEFAULT sysdate,
//    RESERVE_SYSTEM      VARCHAR2(20 BYTE)
    private Long id;
    private LinkOnt linkOnt;
    private String status;
    private String oltId;
    private String ontId;
    private String slotId;
    private String interfaceNo;
    private String nid;
    private String niden;
    private String projectCd;
}
