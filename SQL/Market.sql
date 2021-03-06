﻿CREATE TABLE Goods (
gd_ID CHAR(32) NOT NULL,
gd_Name VARCHAR2(50) NULL,
gd_Price  NUMBER(5,2) NULL,
gd_Count INT NULL,
gd_State  INT DEFAULT 1 NULL,
gt_ID CHAR(32) NULL,
PRIMARY KEY (gd_ID) 
);

CREATE TABLE GoodsType (
gt_ID CHAR(32) NOT NULL,
gt_Name VARCHAR2(20) NULL,
gt_RID CHAR(32) NULL,
PRIMARY KEY (gt_ID) 
);

CREATE TABLE Buy (
buy_ID CHAR(32) NOT NULL,
buyer_ID CHAR(32) NULL,
buy_Date DATE DEFAULT sysdate NULL,
buy_Sate INT DEFAULT 0 NULL,
PRIMARY KEY (buy_ID) 
);

COMMENT ON COLUMN Buy.buy_Sate IS '默认未支付';

CREATE TABLE BuyInfo (
buyi_ID CHAR(32) NOT NULL,
buy_ID CHAR(32) NULL,
gd_ID CHAR(32) NULL,
buyi_Count INT NULL,
PRIMARY KEY (buyi_ID) 
);

CREATE TABLE Buyer (
buyer_ID CHAR(32) NOT NULL,
buyer_Name VARCHAR2(20) NULL,
buyer_Pass VARCHAR2(20) NULL,
buyer_Money NUMBER NULL,
buyer_State INT DEFAULT 1 NULL,
buyer_Phone VARCHAR2(15) NULL,
buyer_Email VARCHAR2(30) NULL,
PRIMARY KEY (buyer_ID) 
);

CREATE TABLE Sell (
sale_ID CHAR(32) NOT NULL,
buyer_ID CHAR(32) NULL,
sale_Date DATE NULL,
PRIMARY KEY (sale_ID) 
);

CREATE TABLE SellInfo (
sli_ID CHAR(32) NOT NULL,
sale_ID CHAR(32) NULL,
gd_ID CHAR(32) NULL,
sli_State NUMBER(11) DEFAULT 1 NULL,
PRIMARY KEY (sli_ID) 
);

COMMENT ON COLUMN SellInfo.sli_State IS '默认卖出商品状态为1';

CREATE TABLE GoodsComment (
gc_ID CHAR(32) NOT NULL,
buyer_ID CHAR(32) NULL,
gd_ID CHAR(32) NULL,
gc_Date DATE DEFAULT sysdate NULL,
gc_Comment VARCHAR2(1024) NULL,
gc_State INT DEFAULT 1 NULL,
PRIMARY KEY (gc_ID) 
);

COMMENT ON COLUMN GoodsComment.gc_Date IS '当前系统时间';
COMMENT ON COLUMN GoodsComment.gc_State IS '默认评论成功';

CREATE TABLE Grounding (
gr_ID CHAR(32) NOT NULL,
seller_ID CHAR(32) NULL,
gr_Date DATE NULL,
PRIMARY KEY (gr_ID) 
);

CREATE TABLE GroundingInfo (
gri_ID CHAR(32) NOT NULL,
gr_ID CHAR(32) NULL,
gd_ID CHAR(32) NULL,
gri_State INT DEFAULT 1 NULL,
PRIMARY KEY (gri_ID) 
);

COMMENT ON COLUMN GroundingInfo.gri_State IS '默认上架成功,预上架状态为0';

CREATE TABLE Undercarriage (
uc_ID CHAR(32) NOT NULL,
seller_ID CHAR(32) NULL,
uc_Date DATE NULL,
PRIMARY KEY (uc_ID) 
);

CREATE TABLE UndercarriageInfo (
uci_ID CHAR(32) NOT NULL,
uc_ID CHAR(32) NULL,
uci_State INT DEFAULT 1 NOT NULL,
gd_Id CHAR(32) NULL,
PRIMARY KEY (uci_ID) 
);

COMMENT ON COLUMN UndercarriageInfo.uci_State IS '默认下架成功，状态为1，预下架状态为0';

CREATE TABLE Seller (
seller_ID CHAR(32) NOT NULL,
seller_Name VARCHAR2(20) NULL,
seller_Pass VARCHAR2(20) NULL,
seller_Money NUMBER NULL,
PRIMARY KEY (seller_ID) 
);

CREATE TABLE ChargeLog (
cl_ID CHAR(32) NOT NULL,
cl_Money NUMBER(9,2) NULL,
cl_State INT DEFAULT 0 NULL,
buyer_ID CHAR(32) NULL,
PRIMARY KEY (cl_ID) 
);

COMMENT ON COLUMN ChargeLog.cl_State IS '充值默认状态';


ALTER TABLE Buy ADD CONSTRAINT fk_buyer_buy FOREIGN KEY (buyer_ID) REFERENCES Buyer (buyer_ID);
ALTER TABLE BuyInfo ADD CONSTRAINT fk_buy_buyInfo FOREIGN KEY (buy_ID) REFERENCES Buy (buy_ID);
ALTER TABLE Goods ADD CONSTRAINT fk_gdType_goods FOREIGN KEY (gt_ID) REFERENCES GoodsType (gt_ID);
ALTER TABLE BuyInfo ADD CONSTRAINT fk_goods_buyInfo FOREIGN KEY (gd_ID) REFERENCES Goods (gd_ID);
ALTER TABLE SellInfo ADD CONSTRAINT fk_sale_slInfo FOREIGN KEY (sale_ID) REFERENCES Sell (sale_ID);
ALTER TABLE SellInfo ADD CONSTRAINT fk_goods_slInfo FOREIGN KEY (gd_ID) REFERENCES Goods (gd_ID);
ALTER TABLE Sell ADD CONSTRAINT fk_buyer_sell FOREIGN KEY (buyer_ID) REFERENCES Buyer (buyer_ID);
ALTER TABLE GoodsComment ADD CONSTRAINT fk_buyer_goodComment FOREIGN KEY (buyer_ID) REFERENCES Buyer (buyer_ID);
ALTER TABLE GoodsComment ADD CONSTRAINT fk_good_goodComment FOREIGN KEY (gd_ID) REFERENCES Goods (gd_ID);
ALTER TABLE Grounding ADD CONSTRAINT fk_seller_gri FOREIGN KEY (seller_ID) REFERENCES Seller (seller_ID);
ALTER TABLE GroundingInfo ADD CONSTRAINT fk_grounding_gri FOREIGN KEY (gr_ID) REFERENCES Grounding (gr_ID);
ALTER TABLE Undercarriage ADD CONSTRAINT fk_seller_uc FOREIGN KEY (seller_ID) REFERENCES Seller (seller_ID);
ALTER TABLE UndercarriageInfo ADD CONSTRAINT fk_uc_uci FOREIGN KEY (uc_ID) REFERENCES Undercarriage (uc_ID);
ALTER TABLE UndercarriageInfo ADD CONSTRAINT fk_goods_uci FOREIGN KEY (gd_ID) REFERENCES Goods (gd_ID);
ALTER TABLE GroundingInfo ADD CONSTRAINT fk_goods_gri FOREIGN KEY (gd_ID) REFERENCES Goods (gd_ID);
ALTER TABLE ChargeLog ADD CONSTRAINT fk_buyer_cl FOREIGN KEY (buyer_ID) REFERENCES Buyer (buyer_ID);


commit;


----------------------------------------------------------------------------------------------

--table "BUYER" ---------------------------------------------------------------------------------

INSERT INTO "BUYER" VALUES ('brid2015101611032157884121884352', 'zhangs', 'zs123', -648, 1, NULL, NULL);


--table "GOODS" ---------------------------------------------------------------------------------

INSERT INTO "GOODS" VALUES ('gdid2015101701320765292847619167', '莫代尔单件秋裤打底裤', 36, 20, 1, 'gtid2015101710563927190186730412');

--table "GOODSTYPE" ---------------------------------------------------------------------------------

INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701430586552997804554', '母婴', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710132331757024527892', '秋裤', 'gtid2015101701422983214512991528');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710314851205819957682', '秋连衣裙', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701431537898689902095', '家居', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710313023916586719180', '大码女装', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701405277984046451527', '女人', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701432833495679062148', '美食', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701435918113499239591', '美妆', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101702105272500043004842', '保暖裤', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710311766978012016714', '中年女装', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710315862489414331498', '外穿保暖衣', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701424343529332467226', '数码', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710313962160261636826', '保暖上衣', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701422983214512991528', '男人', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101701441633796784125328', '箱包', '1000');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710223304169607601227', '羊绒裤', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710243975803489277571', '精工表', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710264847035685182148', '瑞士表', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710321145345592636231', '春秋外套', 'gtid2015101701405277984046451527');
INSERT INTO "GOODSTYPE" VALUES ('gtid2015101710563927190186730412', '秋裤', 'gtid2015101701405277984046451527');

--table "GOODSTYPE" ---------------------------------------------------------------------------------

INSERT INTO "SELLER" VALUES ('srid2015101611032157884121884352', 'admin', 'admin', 576);
