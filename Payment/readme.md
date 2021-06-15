建表语句
DROP TABLE IF EXISTS `PAYMENT_TRANSACTION`;
CREATE TABLE `PAYMENT_TRANSACTION`  (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `TERMINAL_ID` BIGINT(20) NOT NULL DEFAULT 1,
  `DRIVER_CODE` VARCHAR(255) CHARACTER SET LATIN1 COLLATE LATIN1_SWEDISH_CI NOT NULL,
  `MERCHANT_ID` VARCHAR(255) CHARACTER SET LATIN1 COLLATE LATIN1_SWEDISH_CI NOT NULL,
  `PAYMENT_AMOUNT` BIGINT(20) NOT NULL,
  `STATUS` INT(11) NOT NULL,
  `CURRENCY_CODE` VARCHAR(10) CHARACTER SET LATIN1 COLLATE LATIN1_SWEDISH_CI NOT NULL,
  `TRANSACTION_TYPE` INT(11) NOT NULL,
  `TRANSACTION_ID` BIGINT(20) NOT NULL,
  `TRANS_DATE_TIME` TIMESTAMP(0) NULL DEFAULT NULL,
  `PAYMENT_METHOD` INT(11) NOT NULL,
  `REMARKS` VARCHAR(255) CHARACTER SET LATIN1 COLLATE LATIN1_SWEDISH_CI NULL DEFAULT NULL,
  `CREATED_BY` VARCHAR(255) CHARACTER SET LATIN1 COLLATE LATIN1_SWEDISH_CI NOT NULL,
  `CREATED_DATE` TIMESTAMP(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `LAST_MODIFIED_BY` VARCHAR(255) CHARACTER SET LATIN1 COLLATE LATIN1_SWEDISH_CI NULL DEFAULT NULL,
  `LAST_MODIFIED_DATE` TIMESTAMP(0) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = LATIN1 COLLATE = LATIN1_SWEDISH_CI ROW_FORMAT = DYNAMIC;