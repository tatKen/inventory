package ken.ball.inventory.entity;

public class Phyconn {
//    UIM_PHYCONN_OID    NUMBER,
//    UIM_PHYCONN_OTYPE  VARCHAR2(255 BYTE),
//    VERSION            NUMBER                     DEFAULT 0,
//    CREATED_T          DATE                       DEFAULT sysdate,
//    MOD_T              DATE                       DEFAULT sysdate,
//    EFF_T              DATE,
//    TERM_T             DATE,
//    STATUS             VARCHAR2(10 BYTE),
//    CREATED_BY         VARCHAR2(255 BYTE),
//    MODIFIED_BY        VARCHAR2(255 BYTE),
//    CATEGORY           VARCHAR2(255 BYTE),
//    NAME               VARCHAR2(255 BYTE),
//    DESCR              VARCHAR2(255 BYTE),
//    SRC_OBJ_OID        NUMBER,
//    TGT_OBJ_OID        NUMBER,
//    SRC_OBJ_TYPE       VARCHAR2(255 BYTE),
//    TGT_OBJ_TYPE       VARCHAR2(255 BYTE),
//    NATURE             VARCHAR2(20 BYTE),
//    SRC_CARD_OID       NUMBER,
//    TGT_CARD_OID       NUMBER,
//    SRC_CARD_OTYPE     VARCHAR2(255 BYTE),
//    TGT_CARD_OTYPE     VARCHAR2(255 BYTE),
//    LAST_SYNC_ID       NUMBER,
//    LAST_SYNC_DATE     DATE,
//    REAL_ID            VARCHAR2(8 BYTE),
//    REAL_DATE          DATE

    private Long id;
    private String phyconnType;
    private Linkconn linkconn;
    private String status;
    private Card srcCard;
    private Port srcPort;
    private Card tgtCard;
    private Port tgtPort;
    private String nature;

}
