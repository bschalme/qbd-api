-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: qbd
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `qbd`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `qbd` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `qbd`;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `AccountType` varchar(255) DEFAULT NULL,
  `DetailAccountType` varchar(255) DEFAULT NULL,
  `AccountNumber` varchar(255) DEFAULT NULL,
  `BankNumber` varchar(255) DEFAULT NULL,
  `LastCheckNumber` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Balance` decimal(15,5) DEFAULT NULL,
  `TotalBalance` decimal(15,5) DEFAULT NULL,
  `CashFlowClassification` varchar(255) DEFAULT NULL,
  `SpecialAccountType` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxAccount` varchar(255) DEFAULT NULL,
  `TaxLineID` int(11) DEFAULT NULL,
  `TaxLineInfo` varchar(255) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `accountIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `additionalcontactdetail`
--

DROP TABLE IF EXISTS `additionalcontactdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `additionalcontactdetail` (
  `ContactName` varchar(255) DEFAULT NULL,
  `ContactValue` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `additionalcontactdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `additionalnotesdetail`
--

DROP TABLE IF EXISTS `additionalnotesdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `additionalnotesdetail` (
  `NoteID` int(11) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `additionalnotesdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `appliedtotxndetail`
--

DROP TABLE IF EXISTS `appliedtotxndetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appliedtotxndetail` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnType` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `BalanceRemaining` decimal(15,5) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `DiscountAmount` decimal(15,5) DEFAULT NULL,
  `DiscountAccountRef_ListID` varchar(255) DEFAULT NULL,
  `DiscountAccountRef_FullName` varchar(255) DEFAULT NULL,
  `DiscountClassRef_ListID` varchar(255) DEFAULT NULL,
  `DiscountClassRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `appliedtotxndetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `arrefundcreditcard`
--

DROP TABLE IF EXISTS `arrefundcreditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arrefundcreditcard` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `RefundFromAccountRef_ListID` varchar(255) DEFAULT NULL,
  `RefundFromAccountRef_FullName` varchar(255) DEFAULT NULL,
  `ARAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ARAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `Address_Addr1` varchar(255) DEFAULT NULL,
  `Address_Addr2` varchar(255) DEFAULT NULL,
  `Address_Addr3` varchar(255) DEFAULT NULL,
  `Address_Addr4` varchar(255) DEFAULT NULL,
  `Address_Addr5` varchar(255) DEFAULT NULL,
  `Address_City` varchar(255) DEFAULT NULL,
  `Address_State` varchar(255) DEFAULT NULL,
  `Address_PostalCode` varchar(255) DEFAULT NULL,
  `Address_Country` varchar(255) DEFAULT NULL,
  `Address_Note` varchar(255) DEFAULT NULL,
  `AddressBlock_Addr1` varchar(255) DEFAULT NULL,
  `AddressBlock_Addr2` varchar(255) DEFAULT NULL,
  `AddressBlock_Addr3` varchar(255) DEFAULT NULL,
  `AddressBlock_Addr4` varchar(255) DEFAULT NULL,
  `AddressBlock_Addr5` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_ListID` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CreditCardTxnInfo` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `arrefundcreditcardIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `VendorRef_ListID` varchar(255) DEFAULT NULL,
  `VendorRef_FullName` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr1` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr2` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr3` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr4` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr5` varchar(255) DEFAULT NULL,
  `VendorAddress_City` varchar(255) DEFAULT NULL,
  `VendorAddress_State` varchar(255) DEFAULT NULL,
  `VendorAddress_PostalCode` varchar(255) DEFAULT NULL,
  `VendorAddress_Country` varchar(255) DEFAULT NULL,
  `VendorAddress_Note` varchar(255) DEFAULT NULL,
  `APAccountRef_ListID` varchar(255) DEFAULT NULL,
  `APAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `AmountDue` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountDueInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `IsPaid` varchar(255) DEFAULT NULL,
  `OpenAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `billIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billingrate`
--

DROP TABLE IF EXISTS `billingrate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billingrate` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BillingRateType` varchar(255) DEFAULT NULL,
  `FixedBillingRate` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `billingrateIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billingrateperitemdetail`
--

DROP TABLE IF EXISTS `billingrateperitemdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billingrateperitemdetail` (
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `CustomRate` varchar(255) DEFAULT NULL,
  `CustomRatePercent` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `billingrateperitemdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billpaymentcheck`
--

DROP TABLE IF EXISTS `billpaymentcheck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billpaymentcheck` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `PayeeEntityRef_ListID` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_FullName` varchar(255) DEFAULT NULL,
  `APAccountRef_ListID` varchar(255) DEFAULT NULL,
  `APAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `BankAccountRef_ListID` varchar(255) DEFAULT NULL,
  `BankAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Address_Addr1` varchar(255) DEFAULT NULL,
  `Address_Addr2` varchar(255) DEFAULT NULL,
  `Address_Addr3` varchar(255) DEFAULT NULL,
  `Address_Addr4` varchar(255) DEFAULT NULL,
  `Address_Addr5` varchar(255) DEFAULT NULL,
  `Address_City` varchar(255) DEFAULT NULL,
  `Address_State` varchar(255) DEFAULT NULL,
  `Address_PostalCode` varchar(255) DEFAULT NULL,
  `Address_Country` varchar(255) DEFAULT NULL,
  `Address_Note` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `billpaymentcheckIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billpaymentcreditcard`
--

DROP TABLE IF EXISTS `billpaymentcreditcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billpaymentcreditcard` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `PayeeEntityRef_ListID` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_FullName` varchar(255) DEFAULT NULL,
  `APAccountRef_ListID` varchar(255) DEFAULT NULL,
  `APAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `CreditCardAccountRef_ListID` varchar(255) DEFAULT NULL,
  `CreditCardAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `billpaymentcreditcardIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `buildassembly`
--

DROP TABLE IF EXISTS `buildassembly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buildassembly` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `ItemInventoryAssemblyRef_ListID` varchar(255) DEFAULT NULL,
  `ItemInventoryAssemblyRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `IsPending` varchar(255) DEFAULT NULL,
  `QuantityToBuild` varchar(255) DEFAULT NULL,
  `MarkPendingIfRequired` varchar(255) DEFAULT NULL,
  `QuantityCanBuild` varchar(255) DEFAULT NULL,
  `QuantityOnHand` varchar(255) DEFAULT NULL,
  `QuantityOnSalesOrder` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `buildassemblyIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cashbackinfodetail`
--

DROP TABLE IF EXISTS `cashbackinfodetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cashbackinfodetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `cashbackinfodetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `charge`
--

DROP TABLE IF EXISTS `charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `charge` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `BalanceRemaining` decimal(15,5) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `ARAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ARAccountRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `BilledDate` datetime DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `IsPaid` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `chargeIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `check`
--

DROP TABLE IF EXISTS `check`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `check` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_ListID` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_FullName` varchar(255) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Address_Addr1` varchar(255) DEFAULT NULL,
  `Address_Addr2` varchar(255) DEFAULT NULL,
  `Address_Addr3` varchar(255) DEFAULT NULL,
  `Address_Addr4` varchar(255) DEFAULT NULL,
  `Address_Addr5` varchar(255) DEFAULT NULL,
  `Address_City` varchar(255) DEFAULT NULL,
  `Address_State` varchar(255) DEFAULT NULL,
  `Address_PostalCode` varchar(255) DEFAULT NULL,
  `Address_Country` varchar(255) DEFAULT NULL,
  `Address_Note` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `classIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `IsSampleCompany` varchar(255) DEFAULT NULL,
  `CompanyName` varchar(255) DEFAULT NULL,
  `LegalCompanyName` varchar(255) DEFAULT NULL,
  `Address_Addr1` varchar(255) DEFAULT NULL,
  `Address_Addr2` varchar(255) DEFAULT NULL,
  `Address_Addr3` varchar(255) DEFAULT NULL,
  `Address_Addr4` varchar(255) DEFAULT NULL,
  `Address_Addr5` varchar(255) DEFAULT NULL,
  `Address_City` varchar(255) DEFAULT NULL,
  `Address_State` varchar(255) DEFAULT NULL,
  `Address_PostalCode` varchar(255) DEFAULT NULL,
  `Address_Country` varchar(255) DEFAULT NULL,
  `Address_Note` varchar(255) DEFAULT NULL,
  `LegalAddress_Addr1` varchar(255) DEFAULT NULL,
  `LegalAddress_Addr2` varchar(255) DEFAULT NULL,
  `LegalAddress_Addr3` varchar(255) DEFAULT NULL,
  `LegalAddress_Addr4` varchar(255) DEFAULT NULL,
  `LegalAddress_Addr5` varchar(255) DEFAULT NULL,
  `LegalAddress_City` varchar(255) DEFAULT NULL,
  `LegalAddress_State` varchar(255) DEFAULT NULL,
  `LegalAddress_PostalCode` varchar(255) DEFAULT NULL,
  `LegalAddress_Country` varchar(255) DEFAULT NULL,
  `LegalAddress_Note` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Addr1` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Addr2` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Addr3` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Addr4` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Addr5` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_City` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_State` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_PostalCode` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Country` varchar(255) DEFAULT NULL,
  `CompanyAddressForCustomer_Note` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `CompanyEmailForCustomer` varchar(255) DEFAULT NULL,
  `CompanyWebSite` varchar(255) DEFAULT NULL,
  `FirstMonthFiscalYear` varchar(255) DEFAULT NULL,
  `FirstMonthIncomeTaxYear` varchar(255) DEFAULT NULL,
  `CompanyType` varchar(255) DEFAULT NULL,
  `EIN` varchar(255) DEFAULT NULL,
  `TaxForm` varchar(255) DEFAULT NULL,
  `SubscribedServices` varchar(255) DEFAULT NULL,
  `AccountantCopy` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `componentitemlinedetail`
--

DROP TABLE IF EXISTS `componentitemlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componentitemlinedetail` (
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `QuantityOnHand` varchar(255) DEFAULT NULL,
  `QuantityNeeded` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `componentitemlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contactsdetail`
--

DROP TABLE IF EXISTS `contactsdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactsdetail` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Contact` varchar(255) DEFAULT NULL,
  `Salutation` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `JobTitle` varchar(255) DEFAULT NULL,
  `AdditionalContactRef_ListID` varchar(255) DEFAULT NULL,
  `AdditionalContactRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `contactsdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `creditcardcharge`
--

DROP TABLE IF EXISTS `creditcardcharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcardcharge` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_ListID` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `creditcardchargeIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `creditcardcredit`
--

DROP TABLE IF EXISTS `creditcardcredit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcardcredit` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_ListID` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `creditcardcreditIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `creditmemo`
--

DROP TABLE IF EXISTS `creditmemo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditmemo` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ARAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ARAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TemplateRef_ListID` varchar(255) DEFAULT NULL,
  `TemplateRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `BillAddress_Addr1` varchar(255) DEFAULT NULL,
  `BillAddress_Addr2` varchar(255) DEFAULT NULL,
  `BillAddress_Addr3` varchar(255) DEFAULT NULL,
  `BillAddress_Addr4` varchar(255) DEFAULT NULL,
  `BillAddress_Addr5` varchar(255) DEFAULT NULL,
  `BillAddress_City` varchar(255) DEFAULT NULL,
  `BillAddress_State` varchar(255) DEFAULT NULL,
  `BillAddress_PostalCode` varchar(255) DEFAULT NULL,
  `BillAddress_Country` varchar(255) DEFAULT NULL,
  `BillAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `IsPending` varchar(255) DEFAULT NULL,
  `PONumber` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `SalesRepRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepRef_FullName` varchar(255) DEFAULT NULL,
  `FOB` varchar(255) DEFAULT NULL,
  `ShipDate` datetime DEFAULT NULL,
  `ShipMethodRef_ListID` varchar(255) DEFAULT NULL,
  `ShipMethodRef_FullName` varchar(255) DEFAULT NULL,
  `Subtotal` decimal(15,5) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxPercentage` varchar(255) DEFAULT NULL,
  `SalesTaxTotal` decimal(15,5) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CreditRemaining` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `CreditRemainingInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_FullName` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `IsToBeEmailed` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `creditmemoIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `creditmemolinedetail`
--

DROP TABLE IF EXISTS `creditmemolinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditmemolinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `RatePercent` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `creditmemolinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `creditmemolinegroupdetail`
--

DROP TABLE IF EXISTS `creditmemolinegroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditmemolinegroupdetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `creditmemolinegroupdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `CurrencyCode` varchar(255) DEFAULT NULL,
  `ThousandSeparator` varchar(255) DEFAULT NULL,
  `ThousandSeparatorGrouping` varchar(255) DEFAULT NULL,
  `DecimalPlaces` varchar(255) DEFAULT NULL,
  `DecimalSeparator` varchar(255) DEFAULT NULL,
  `IsUserDefinedCurrency` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AsOfDate` datetime DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `currencyIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `CompanyName` varchar(255) DEFAULT NULL,
  `Salutation` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `JobTitle` varchar(255) DEFAULT NULL,
  `Suffix` varchar(255) DEFAULT NULL,
  `BillAddress_Addr1` varchar(255) DEFAULT NULL,
  `BillAddress_Addr2` varchar(255) DEFAULT NULL,
  `BillAddress_Addr3` varchar(255) DEFAULT NULL,
  `BillAddress_Addr4` varchar(255) DEFAULT NULL,
  `BillAddress_Addr5` varchar(255) DEFAULT NULL,
  `BillAddress_City` varchar(255) DEFAULT NULL,
  `BillAddress_State` varchar(255) DEFAULT NULL,
  `BillAddress_PostalCode` varchar(255) DEFAULT NULL,
  `BillAddress_Country` varchar(255) DEFAULT NULL,
  `BillAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `PrintAs` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `Pager` varchar(255) DEFAULT NULL,
  `AltPhone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Cc` varchar(255) DEFAULT NULL,
  `Contact` varchar(255) DEFAULT NULL,
  `AltContact` varchar(255) DEFAULT NULL,
  `CustomerTypeRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerTypeRef_FullName` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `SalesRepRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepRef_FullName` varchar(255) DEFAULT NULL,
  `Balance` decimal(15,5) DEFAULT NULL,
  `TotalBalance` decimal(15,5) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCountry` varchar(255) DEFAULT NULL,
  `ResaleNumber` varchar(255) DEFAULT NULL,
  `AccountNumber` varchar(255) DEFAULT NULL,
  `CreditLimit` decimal(15,5) DEFAULT NULL,
  `PreferredPaymentMethodRef_ListID` varchar(255) DEFAULT NULL,
  `PreferredPaymentMethodRef_FullName` varchar(255) DEFAULT NULL,
  `CreditCardNumber` varchar(255) DEFAULT NULL,
  `ExpirationMonth` int(11) DEFAULT NULL,
  `ExpirationYear` int(11) DEFAULT NULL,
  `NameOnCard` varchar(255) DEFAULT NULL,
  `CreditCardAddress` varchar(255) DEFAULT NULL,
  `CreditCardPostalCode` varchar(255) DEFAULT NULL,
  `JobStatus` varchar(255) DEFAULT NULL,
  `JobStartDate` datetime DEFAULT NULL,
  `JobProjectedEndDate` datetime DEFAULT NULL,
  `JobEndDate` datetime DEFAULT NULL,
  `JobDesc` varchar(255) DEFAULT NULL,
  `JobTypeRef_ListID` varchar(255) DEFAULT NULL,
  `JobTypeRef_FullName` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `PriceLevelRef_ListID` varchar(255) DEFAULT NULL,
  `PriceLevelRef_FullName` varchar(255) DEFAULT NULL,
  `TaxRegistrationNumber` varchar(255) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `IsStatementWithParent` varchar(255) DEFAULT NULL,
  `PreferredDeliveryMethod` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `customerIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customermsg`
--

DROP TABLE IF EXISTS `customermsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customermsg` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `customermsgIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `customertype`
--

DROP TABLE IF EXISTS `customertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customertype` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `customertypeIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dataextdef`
--

DROP TABLE IF EXISTS `dataextdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dataextdef` (
  `OwnerID` varchar(255) DEFAULT NULL,
  `DataExtID` int(11) DEFAULT NULL,
  `DataExtName` varchar(255) DEFAULT NULL,
  `DataExtType` varchar(255) DEFAULT NULL,
  `AssignToObject` varchar(255) DEFAULT NULL,
  `DataExtListRequire` varchar(255) DEFAULT NULL,
  `DataExtTxnRequire` varchar(255) DEFAULT NULL,
  `DataExtFormatString` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dataextdetail`
--

DROP TABLE IF EXISTS `dataextdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dataextdetail` (
  `OwnerID` varchar(255) DEFAULT NULL,
  `DataExtName` varchar(255) DEFAULT NULL,
  `DataExtType` varchar(255) DEFAULT NULL,
  `DataExtValue` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  `OwnerType` varchar(255) DEFAULT NULL,
  KEY `dataextdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `datedriventerms`
--

DROP TABLE IF EXISTS `datedriventerms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datedriventerms` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `DayOfMonthDue` int(11) DEFAULT NULL,
  `DueNextMonthDays` int(11) DEFAULT NULL,
  `DiscountDayOfMonth` int(11) DEFAULT NULL,
  `DiscountPct` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `datedriventermsIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `defaultunitdetail`
--

DROP TABLE IF EXISTS `defaultunitdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defaultunitdetail` (
  `UnitUsedFor` varchar(255) DEFAULT NULL,
  `Unit` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `defaultunitdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `deposit`
--

DROP TABLE IF EXISTS `deposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deposit` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `DepositToAccountRef_ListID` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `DepositTotal` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `DepositTotalInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `depositIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `depositlinedetail`
--

DROP TABLE IF EXISTS `depositlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `depositlinedetail` (
  `TxnType` varchar(255) DEFAULT NULL,
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnLineID` varchar(255) DEFAULT NULL,
  `PaymentTxnLineID` varchar(255) DEFAULT NULL,
  `EntityRef_ListID` varchar(255) DEFAULT NULL,
  `EntityRef_FullName` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CheckNumber` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_ListID` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `depositlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `earningsdetail`
--

DROP TABLE IF EXISTS `earningsdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `earningsdetail` (
  `PayrollItemWageRef_ListID` varchar(255) DEFAULT NULL,
  `PayrollItemWageRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `RatePercent` varchar(255) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `Salutation` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Suffix` varchar(255) DEFAULT NULL,
  `JobTitle` varchar(255) DEFAULT NULL,
  `SupervisorRef_ListID` varchar(255) DEFAULT NULL,
  `SupervisorRef_FullName` varchar(255) DEFAULT NULL,
  `Department` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `TargetBonus` decimal(15,5) DEFAULT NULL,
  `EmployeeAddress_Addr1` varchar(255) DEFAULT NULL,
  `EmployeeAddress_Addr2` varchar(255) DEFAULT NULL,
  `EmployeeAddress_Addr3` varchar(255) DEFAULT NULL,
  `EmployeeAddress_Addr4` varchar(255) DEFAULT NULL,
  `EmployeeAddress_City` varchar(255) DEFAULT NULL,
  `EmployeeAddress_State` varchar(255) DEFAULT NULL,
  `EmployeeAddress_PostalCode` varchar(255) DEFAULT NULL,
  `EmployeeAddress_Country` varchar(255) DEFAULT NULL,
  `PrintAs` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `Pager` varchar(255) DEFAULT NULL,
  `PagerPIN` varchar(255) DEFAULT NULL,
  `AltPhone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `SSN` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `EmergencyContactPrimaryName` varchar(255) DEFAULT NULL,
  `EmergencyContactPrimaryValue` varchar(255) DEFAULT NULL,
  `EmergencyContactPrimaryRelation` varchar(255) DEFAULT NULL,
  `EmergencyContactSecondaryName` varchar(255) DEFAULT NULL,
  `EmergencyContactSecondaryValue` varchar(255) DEFAULT NULL,
  `EmergencyContactSecondaryRelation` varchar(255) DEFAULT NULL,
  `EmployeeType` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `PartOrFullTime` varchar(255) DEFAULT NULL,
  `Exempt` varchar(255) DEFAULT NULL,
  `KeyEmployee` varchar(255) DEFAULT NULL,
  `HiredDate` datetime DEFAULT NULL,
  `OriginalHireDate` datetime DEFAULT NULL,
  `AdjustedServiceDate` datetime DEFAULT NULL,
  `ReleasedDate` datetime DEFAULT NULL,
  `BirthDate` datetime DEFAULT NULL,
  `USCitizen` varchar(255) DEFAULT NULL,
  `Ethnicity` varchar(255) DEFAULT NULL,
  `Disabled` varchar(255) DEFAULT NULL,
  `DisabilityDesc` varchar(255) DEFAULT NULL,
  `OnFile` varchar(255) DEFAULT NULL,
  `WorkAuthExpireDate` datetime DEFAULT NULL,
  `USVeteran` varchar(255) DEFAULT NULL,
  `MilitaryStatus` varchar(255) DEFAULT NULL,
  `AccountNumber` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `BillingRateRef_ListID` varchar(255) DEFAULT NULL,
  `BillingRateRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `employeeIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `employeepayrollinfodetail`
--

DROP TABLE IF EXISTS `employeepayrollinfodetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeepayrollinfodetail` (
  `PayPeriod` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `IsUsingTimeDataToCreatePaychecks` varchar(255) DEFAULT NULL,
  `UseTimeDataToCreatePaychecks` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `employeepayrollinfodetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entity` (
  `ListID` varchar(200) DEFAULT NULL,
  `FullName` varchar(200) DEFAULT NULL,
  `TableName` varchar(200) DEFAULT NULL,
  KEY `EntityListIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `error_table`
--

DROP TABLE IF EXISTS `error_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `error_table` (
  `Error_Num` varchar(200) DEFAULT NULL,
  `Error_Table` varchar(200) DEFAULT NULL,
  `Error_Field` varchar(200) DEFAULT NULL,
  `IDKEY` varchar(40) DEFAULT NULL,
  `Error_Desc` varchar(255) DEFAULT NULL,
  `TIME_DATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estimate`
--

DROP TABLE IF EXISTS `estimate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estimate` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `TemplateRef_ListID` varchar(255) DEFAULT NULL,
  `TemplateRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `BillAddress_Addr1` varchar(255) DEFAULT NULL,
  `BillAddress_Addr2` varchar(255) DEFAULT NULL,
  `BillAddress_Addr3` varchar(255) DEFAULT NULL,
  `BillAddress_Addr4` varchar(255) DEFAULT NULL,
  `BillAddress_Addr5` varchar(255) DEFAULT NULL,
  `BillAddress_City` varchar(255) DEFAULT NULL,
  `BillAddress_State` varchar(255) DEFAULT NULL,
  `BillAddress_PostalCode` varchar(255) DEFAULT NULL,
  `BillAddress_Country` varchar(255) DEFAULT NULL,
  `BillAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `PONumber` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `SalesRepRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepRef_FullName` varchar(255) DEFAULT NULL,
  `FOB` varchar(255) DEFAULT NULL,
  `Subtotal` decimal(15,5) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxPercentage` varchar(255) DEFAULT NULL,
  `SalesTaxTotal` decimal(15,5) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `TotalAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_FullName` varchar(255) DEFAULT NULL,
  `IsToBeEmailed` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `estimateIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estimatelinedetail`
--

DROP TABLE IF EXISTS `estimatelinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estimatelinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `RatePercent` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `MarkupRate` varchar(255) DEFAULT NULL,
  `MarkupRatePercent` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `estimatelinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estimatelinegroupdetail`
--

DROP TABLE IF EXISTS `estimatelinegroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estimatelinegroupdetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `estimatelinegroupdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fixedassetsalesinfodetail`
--

DROP TABLE IF EXISTS `fixedassetsalesinfodetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fixedassetsalesinfodetail` (
  `SalesDesc` varchar(255) DEFAULT NULL,
  `SalesDate` datetime DEFAULT NULL,
  `SalesPrice` varchar(255) DEFAULT NULL,
  `SalesExpense` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `fixedassetsalesinfodetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `TableName` varchar(200) DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `QBWFile` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventoryadjustment`
--

DROP TABLE IF EXISTS `inventoryadjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventoryadjustment` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `inventoryadjustmentIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventoryadjustmentlinedetail`
--

DROP TABLE IF EXISTS `inventoryadjustmentlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventoryadjustmentlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `QuantityDifference` varchar(255) DEFAULT NULL,
  `ValueDifference` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `inventoryadjustmentlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inventorysite`
--

DROP TABLE IF EXISTS `inventorysite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventorysite` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentSiteRef_ListID` varchar(255) DEFAULT NULL,
  `ParentSiteRef_FullName` varchar(255) DEFAULT NULL,
  `IsDefaultSite` varchar(255) DEFAULT NULL,
  `SiteDesc` varchar(255) DEFAULT NULL,
  `Contact` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `SiteAddress_Addr1` varchar(255) DEFAULT NULL,
  `SiteAddress_Addr2` varchar(255) DEFAULT NULL,
  `SiteAddress_Addr3` varchar(255) DEFAULT NULL,
  `SiteAddress_Addr4` varchar(255) DEFAULT NULL,
  `SiteAddress_Addr5` varchar(255) DEFAULT NULL,
  `SiteAddress_City` varchar(255) DEFAULT NULL,
  `SiteAddress_State` varchar(255) DEFAULT NULL,
  `SiteAddress_PostalCode` varchar(255) DEFAULT NULL,
  `SiteAddress_Country` varchar(255) DEFAULT NULL,
  `SiteAddressBlock_Addr1` varchar(255) DEFAULT NULL,
  `SiteAddressBlock_Addr2` varchar(255) DEFAULT NULL,
  `SiteAddressBlock_Addr3` varchar(255) DEFAULT NULL,
  `SiteAddressBlock_Addr4` varchar(255) DEFAULT NULL,
  `SiteAddressBlock_Addr5` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `inventorysiteIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ARAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ARAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TemplateRef_ListID` varchar(255) DEFAULT NULL,
  `TemplateRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `BillAddress_Addr1` varchar(255) DEFAULT NULL,
  `BillAddress_Addr2` varchar(255) DEFAULT NULL,
  `BillAddress_Addr3` varchar(255) DEFAULT NULL,
  `BillAddress_Addr4` varchar(255) DEFAULT NULL,
  `BillAddress_Addr5` varchar(255) DEFAULT NULL,
  `BillAddress_City` varchar(255) DEFAULT NULL,
  `BillAddress_State` varchar(255) DEFAULT NULL,
  `BillAddress_PostalCode` varchar(255) DEFAULT NULL,
  `BillAddress_Country` varchar(255) DEFAULT NULL,
  `BillAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `IsPending` varchar(255) DEFAULT NULL,
  `IsFinanceCharge` varchar(255) DEFAULT NULL,
  `PONumber` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `SalesRepRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepRef_FullName` varchar(255) DEFAULT NULL,
  `FOB` varchar(255) DEFAULT NULL,
  `ShipDate` datetime DEFAULT NULL,
  `ShipMethodRef_ListID` varchar(255) DEFAULT NULL,
  `ShipMethodRef_FullName` varchar(255) DEFAULT NULL,
  `Subtotal` decimal(15,5) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxPercentage` varchar(255) DEFAULT NULL,
  `SalesTaxTotal` decimal(15,5) DEFAULT NULL,
  `AppliedAmount` decimal(15,5) DEFAULT NULL,
  `BalanceRemaining` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `BalanceRemainingInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `IsPaid` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_FullName` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `IsToBeEmailed` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `SuggestedDiscountAmount` decimal(15,5) DEFAULT NULL,
  `SuggestedDiscountDate` datetime DEFAULT NULL,
  `Other` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `invoiceIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoicelinedetail`
--

DROP TABLE IF EXISTS `invoicelinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoicelinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `RatePercent` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `LinkedTxnID` varchar(255) DEFAULT NULL,
  `LinkedTxnLineID` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `invoicelinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoicelinegroupdetail`
--

DROP TABLE IF EXISTS `invoicelinegroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoicelinegroupdetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `invoicelinegroupdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemdiscount`
--

DROP TABLE IF EXISTS `itemdiscount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemdiscount` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `ItemDesc` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `DiscountRate` varchar(255) DEFAULT NULL,
  `DiscountRatePercent` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemdiscountIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemfixedasset`
--

DROP TABLE IF EXISTS `itemfixedasset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemfixedasset` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `AcquiredAs` varchar(255) DEFAULT NULL,
  `PurchaseDesc` varchar(255) DEFAULT NULL,
  `PurchaseDate` datetime DEFAULT NULL,
  `PurchaseCost` varchar(255) DEFAULT NULL,
  `VendorOrPayeeName` varchar(255) DEFAULT NULL,
  `AssetAccountRef_ListID` varchar(255) DEFAULT NULL,
  `AssetAccountRef_FullName` varchar(255) DEFAULT NULL,
  `AssetDesc` varchar(255) DEFAULT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `PONumber` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `WarrantyExpDate` datetime DEFAULT NULL,
  `Notes` longtext,
  `AssetNumber` varchar(255) DEFAULT NULL,
  `CostBasis` decimal(15,5) DEFAULT NULL,
  `YearEndAccumulatedDepreciation` decimal(15,5) DEFAULT NULL,
  `YearEndBookValue` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemfixedassetIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemgroup`
--

DROP TABLE IF EXISTS `itemgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemgroup` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ItemDesc` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `SpecialItemType` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemgroupIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemgrouplinedetail`
--

DROP TABLE IF EXISTS `itemgrouplinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemgrouplinedetail` (
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `itemgrouplinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `iteminventory`
--

DROP TABLE IF EXISTS `iteminventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iteminventory` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `ManufacturerPartNumber` varchar(255) DEFAULT NULL,
  `UnitOfMeasureSetRef_ListID` varchar(255) DEFAULT NULL,
  `UnitOfMeasureSetRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `SalesDesc` varchar(255) DEFAULT NULL,
  `SalesPrice` varchar(255) DEFAULT NULL,
  `IncomeAccountRef_ListID` varchar(255) DEFAULT NULL,
  `IncomeAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PurchaseDesc` varchar(255) DEFAULT NULL,
  `PurchaseCost` varchar(255) DEFAULT NULL,
  `COGSAccountRef_ListID` varchar(255) DEFAULT NULL,
  `COGSAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PrefVendorRef_ListID` varchar(255) DEFAULT NULL,
  `PrefVendorRef_FullName` varchar(255) DEFAULT NULL,
  `AssetAccountRef_ListID` varchar(255) DEFAULT NULL,
  `AssetAccountRef_FullName` varchar(255) DEFAULT NULL,
  `ReorderPoint` varchar(255) DEFAULT NULL,
  `Max` varchar(255) DEFAULT NULL,
  `QuantityOnHand` varchar(255) DEFAULT NULL,
  `AverageCost` varchar(255) DEFAULT NULL,
  `QuantityOnOrder` varchar(255) DEFAULT NULL,
  `QuantityOnSalesOrder` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `iteminventoryIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `iteminventoryassembly`
--

DROP TABLE IF EXISTS `iteminventoryassembly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iteminventoryassembly` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `UnitOfMeasureSetRef_ListID` varchar(255) DEFAULT NULL,
  `UnitOfMeasureSetRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesDesc` varchar(255) DEFAULT NULL,
  `SalesPrice` varchar(255) DEFAULT NULL,
  `IncomeAccountRef_ListID` varchar(255) DEFAULT NULL,
  `IncomeAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PurchaseDesc` varchar(255) DEFAULT NULL,
  `PurchaseCost` varchar(255) DEFAULT NULL,
  `PurchaseTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `PurchaseTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `COGSAccountRef_ListID` varchar(255) DEFAULT NULL,
  `COGSAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PrefVendorRef_ListID` varchar(255) DEFAULT NULL,
  `PrefVendorRef_FullName` varchar(255) DEFAULT NULL,
  `AssetAccountRef_ListID` varchar(255) DEFAULT NULL,
  `AssetAccountRef_FullName` varchar(255) DEFAULT NULL,
  `BuildPoint` varchar(255) DEFAULT NULL,
  `Max` varchar(255) DEFAULT NULL,
  `QuantityOnHand` varchar(255) DEFAULT NULL,
  `AverageCost` varchar(255) DEFAULT NULL,
  `QuantityOnOrder` varchar(255) DEFAULT NULL,
  `QuantityOnSalesOrder` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `iteminventoryassemblyIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `iteminventoryassemblylinedetail`
--

DROP TABLE IF EXISTS `iteminventoryassemblylinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iteminventoryassemblylinedetail` (
  `ItemInventoryRef_ListID` varchar(255) DEFAULT NULL,
  `ItemInventoryRef_FullName` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `iteminventoryassemblylinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemnoninventory`
--

DROP TABLE IF EXISTS `itemnoninventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemnoninventory` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `ManufacturerPartNumber` varchar(255) DEFAULT NULL,
  `UnitOfMeasureSetRef_ListID` varchar(255) DEFAULT NULL,
  `UnitOfMeasureSetRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemnoninventoryIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemothercharge`
--

DROP TABLE IF EXISTS `itemothercharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemothercharge` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `SpecialItemType` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemotherchargeIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itempayment`
--

DROP TABLE IF EXISTS `itempayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itempayment` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ItemDesc` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_ListID` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_ListID` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itempaymentIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemreceipt`
--

DROP TABLE IF EXISTS `itemreceipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemreceipt` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `VendorRef_ListID` varchar(255) DEFAULT NULL,
  `VendorRef_FullName` varchar(255) DEFAULT NULL,
  `APAccountRef_ListID` varchar(255) DEFAULT NULL,
  `APAccountRef_FullName` varchar(255) DEFAULT NULL,
  `LiabilityAccountRef_ListID` varchar(255) DEFAULT NULL,
  `LiabilityAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `TotalAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `LinkedTxn` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemreceiptIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `ListID` varchar(200) DEFAULT NULL,
  `FullName` varchar(200) DEFAULT NULL,
  `TableName` varchar(200) DEFAULT NULL,
  KEY `ItemsListIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsalestax`
--

DROP TABLE IF EXISTS `itemsalestax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsalestax` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ItemDesc` varchar(255) DEFAULT NULL,
  `IsUsedOnPurchaseTransaction` varchar(255) DEFAULT NULL,
  `TaxRate` varchar(255) DEFAULT NULL,
  `TaxVendorRef_ListID` varchar(255) DEFAULT NULL,
  `TaxVendorRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemsalestaxIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsalestaxgroup`
--

DROP TABLE IF EXISTS `itemsalestaxgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsalestaxgroup` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ItemDesc` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemsalestaxgroupIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsalestaxgrouplinedetail`
--

DROP TABLE IF EXISTS `itemsalestaxgrouplinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsalestaxgrouplinedetail` (
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `itemsalestaxgrouplinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemservice`
--

DROP TABLE IF EXISTS `itemservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemservice` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `UnitOfMeasureSetRef_ListID` varchar(255) DEFAULT NULL,
  `UnitOfMeasureSetRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemserviceIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsites`
--

DROP TABLE IF EXISTS `itemsites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsites` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `ItemInventoryAssemblyRef_ListID` varchar(255) DEFAULT NULL,
  `ItemInventoryAssemblyRef_FullName` varchar(255) DEFAULT NULL,
  `ItemInventoryRef_ListID` varchar(255) DEFAULT NULL,
  `ItemInventoryRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `ReorderLevel` varchar(255) DEFAULT NULL,
  `QuantityOnHand` varchar(255) DEFAULT NULL,
  `QuantityOnPurchaseOrders` varchar(255) DEFAULT NULL,
  `QuantityOnSalesOrders` varchar(255) DEFAULT NULL,
  `QuantityToBeBuiltByPendingBuildTxns` varchar(255) DEFAULT NULL,
  `QuantityRequiredByPendingBuildTxns` varchar(255) DEFAULT NULL,
  `QuantityOnPendingTransfers` varchar(255) DEFAULT NULL,
  `AssemblyBuildPoint` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemsitesIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `itemsubtotal`
--

DROP TABLE IF EXISTS `itemsubtotal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemsubtotal` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `BarCodeValue` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ItemDesc` varchar(255) DEFAULT NULL,
  `SpecialItemType` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `itemsubtotalIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `jobtype`
--

DROP TABLE IF EXISTS `jobtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobtype` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `jobtypeIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `journalcreditlinedetail`
--

DROP TABLE IF EXISTS `journalcreditlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalcreditlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `IsAdjustment` varchar(255) DEFAULT NULL,
  `EntityRef_ListID` varchar(255) DEFAULT NULL,
  `EntityRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `BillableStatus` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `journalcreditlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `journaldebitlinedetail`
--

DROP TABLE IF EXISTS `journaldebitlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journaldebitlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `EntityRef_ListID` varchar(255) DEFAULT NULL,
  `EntityRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `BillableStatus` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `journaldebitlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `journalentry`
--

DROP TABLE IF EXISTS `journalentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalentry` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `IsAdjustment` varchar(255) DEFAULT NULL,
  `IsHomeCurrencyAdjustment` varchar(255) DEFAULT NULL,
  `IsAmountsEnteredInHomeCurrency` varchar(255) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `TxnType` varchar(200) DEFAULT NULL,
  KEY `journalentryIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `linkedtxndetail`
--

DROP TABLE IF EXISTS `linkedtxndetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linkedtxndetail` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnType` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `LinkType` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `linkedtxndetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `othername`
--

DROP TABLE IF EXISTS `othername`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `othername` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `CompanyName` varchar(255) DEFAULT NULL,
  `Salutation` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `Suffix` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Addr1` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Addr2` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Addr3` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Addr4` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Addr5` varchar(255) DEFAULT NULL,
  `OtherNameAddress_City` varchar(255) DEFAULT NULL,
  `OtherNameAddress_State` varchar(255) DEFAULT NULL,
  `OtherNameAddress_PostalCode` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Country` varchar(255) DEFAULT NULL,
  `OtherNameAddress_Note` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `Pager` varchar(255) DEFAULT NULL,
  `AltPhone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Contact` varchar(255) DEFAULT NULL,
  `AltContact` varchar(255) DEFAULT NULL,
  `AccountNumber` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `othernameIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentmethod` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `PaymentMethodType` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `paymentmethodIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payrollitemnonwage`
--

DROP TABLE IF EXISTS `payrollitemnonwage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payrollitemnonwage` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `NonWageType` varchar(255) DEFAULT NULL,
  `ExpenseAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ExpenseAccountRef_FullName` varchar(255) DEFAULT NULL,
  `LiabilityAccountRef_ListID` varchar(255) DEFAULT NULL,
  `LiabilityAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `payrollitemnonwageIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payrollitemwage`
--

DROP TABLE IF EXISTS `payrollitemwage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payrollitemwage` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `WageType` varchar(255) DEFAULT NULL,
  `ExpenseAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ExpenseAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `payrollitemwageIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pricelevel`
--

DROP TABLE IF EXISTS `pricelevel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pricelevel` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `PriceLevelType` varchar(255) DEFAULT NULL,
  `PriceLevelFixedPercentage` varchar(255) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `pricelevelIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pricelevelperitemdetail`
--

DROP TABLE IF EXISTS `pricelevelperitemdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pricelevelperitemdetail` (
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `CustomPrice` varchar(255) DEFAULT NULL,
  `CustomPricePercent` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `pricelevelperitemdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchaseorder`
--

DROP TABLE IF EXISTS `purchaseorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorder` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `VendorRef_ListID` varchar(255) DEFAULT NULL,
  `VendorRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `ShipToEntityRef_ListID` varchar(255) DEFAULT NULL,
  `ShipToEntityRef_FullName` varchar(255) DEFAULT NULL,
  `TemplateRef_ListID` varchar(255) DEFAULT NULL,
  `TemplateRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr1` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr2` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr3` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr4` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr5` varchar(255) DEFAULT NULL,
  `VendorAddress_City` varchar(255) DEFAULT NULL,
  `VendorAddress_State` varchar(255) DEFAULT NULL,
  `VendorAddress_PostalCode` varchar(255) DEFAULT NULL,
  `VendorAddress_Country` varchar(255) DEFAULT NULL,
  `VendorAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `ExpectedDate` datetime DEFAULT NULL,
  `ShipMethodRef_ListID` varchar(255) DEFAULT NULL,
  `ShipMethodRef_FullName` varchar(255) DEFAULT NULL,
  `FOB` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `TotalAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `VendorMsg` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `IsToBeEmailed` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `IsManuallyClosed` varchar(255) DEFAULT NULL,
  `IsFullyReceived` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `purchaseorderIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchaseorderlinedetail`
--

DROP TABLE IF EXISTS `purchaseorderlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorderlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `ManufacturerPartNumber` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `ReceivedQuantity` varchar(255) DEFAULT NULL,
  `UnbilledQuantity` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `IsManuallyClosed` varchar(255) DEFAULT NULL,
  `IsBilled` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `purchaseorderlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `purchaseorderlinegroupdetail`
--

DROP TABLE IF EXISTS `purchaseorderlinegroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchaseorderlinegroupdetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `purchaseorderlinegroupdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `receivepayment`
--

DROP TABLE IF EXISTS `receivepayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receivepayment` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ARAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ARAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `TotalAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `PaymentMethodRef_ListID` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_ListID` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_FullName` varchar(255) DEFAULT NULL,
  `UnusedPayment` decimal(15,5) DEFAULT NULL,
  `UnusedCredits` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `receivepaymentIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `receivepaymenttodeposit`
--

DROP TABLE IF EXISTS `receivepaymenttodeposit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `receivepaymenttodeposit` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnLineID` varchar(255) DEFAULT NULL,
  `TxnType` varchar(255) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refundappliedtotxndetail`
--

DROP TABLE IF EXISTS `refundappliedtotxndetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refundappliedtotxndetail` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnType` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `CreditRemaining` decimal(15,5) DEFAULT NULL,
  `RefundAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `refundappliedtotxndetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `relatedunitdetail`
--

DROP TABLE IF EXISTS `relatedunitdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relatedunitdetail` (
  `Name` varchar(255) DEFAULT NULL,
  `Abbreviation` varchar(255) DEFAULT NULL,
  `ConversionRatio` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `relatedunitdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesandpurchasedetail`
--

DROP TABLE IF EXISTS `salesandpurchasedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesandpurchasedetail` (
  `SalesDesc` varchar(255) DEFAULT NULL,
  `SalesPrice` varchar(255) DEFAULT NULL,
  `IncomeAccountRef_ListID` varchar(255) DEFAULT NULL,
  `IncomeAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PurchaseDesc` varchar(255) DEFAULT NULL,
  `PurchaseCost` varchar(255) DEFAULT NULL,
  `PurchaseTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `PurchaseTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `ExpenseAccountRef_ListID` varchar(255) DEFAULT NULL,
  `ExpenseAccountRef_FullName` varchar(255) DEFAULT NULL,
  `PrefVendorRef_ListID` varchar(255) DEFAULT NULL,
  `PrefVendorRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salesandpurchasedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesorder`
--

DROP TABLE IF EXISTS `salesorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorder` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `TemplateRef_ListID` varchar(255) DEFAULT NULL,
  `TemplateRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `BillAddress_Addr1` varchar(255) DEFAULT NULL,
  `BillAddress_Addr2` varchar(255) DEFAULT NULL,
  `BillAddress_Addr3` varchar(255) DEFAULT NULL,
  `BillAddress_Addr4` varchar(255) DEFAULT NULL,
  `BillAddress_Addr5` varchar(255) DEFAULT NULL,
  `BillAddress_City` varchar(255) DEFAULT NULL,
  `BillAddress_State` varchar(255) DEFAULT NULL,
  `BillAddress_PostalCode` varchar(255) DEFAULT NULL,
  `BillAddress_Country` varchar(255) DEFAULT NULL,
  `BillAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `PONumber` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `SalesRepRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepRef_FullName` varchar(255) DEFAULT NULL,
  `FOB` varchar(255) DEFAULT NULL,
  `ShipDate` datetime DEFAULT NULL,
  `ShipMethodRef_ListID` varchar(255) DEFAULT NULL,
  `ShipMethodRef_FullName` varchar(255) DEFAULT NULL,
  `Subtotal` decimal(15,5) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxPercentage` varchar(255) DEFAULT NULL,
  `SalesTaxTotal` decimal(15,5) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `TotalAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `IsManuallyClosed` varchar(255) DEFAULT NULL,
  `IsFullyInvoiced` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_FullName` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `IsToBeEmailed` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other` varchar(255) DEFAULT NULL,
  `LinkedTxn` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `salesorderIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesorderlinedetail`
--

DROP TABLE IF EXISTS `salesorderlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorderlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `RatePercent` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Invoiced` varchar(255) DEFAULT NULL,
  `IsManuallyClosed` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salesorderlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesorderlinegroupdetail`
--

DROP TABLE IF EXISTS `salesorderlinegroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorderlinegroupdetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salesorderlinegroupdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesorpurchasedetail`
--

DROP TABLE IF EXISTS `salesorpurchasedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesorpurchasedetail` (
  `Description` varchar(255) DEFAULT NULL,
  `Price` varchar(255) DEFAULT NULL,
  `PricePercent` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salesorpurchasedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesreceipt`
--

DROP TABLE IF EXISTS `salesreceipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesreceipt` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `TemplateRef_ListID` varchar(255) DEFAULT NULL,
  `TemplateRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `BillAddress_Addr1` varchar(255) DEFAULT NULL,
  `BillAddress_Addr2` varchar(255) DEFAULT NULL,
  `BillAddress_Addr3` varchar(255) DEFAULT NULL,
  `BillAddress_Addr4` varchar(255) DEFAULT NULL,
  `BillAddress_Addr5` varchar(255) DEFAULT NULL,
  `BillAddress_City` varchar(255) DEFAULT NULL,
  `BillAddress_State` varchar(255) DEFAULT NULL,
  `BillAddress_PostalCode` varchar(255) DEFAULT NULL,
  `BillAddress_Country` varchar(255) DEFAULT NULL,
  `BillAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `IsPending` varchar(255) DEFAULT NULL,
  `CheckNumber` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_ListID` varchar(255) DEFAULT NULL,
  `PaymentMethodRef_FullName` varchar(255) DEFAULT NULL,
  `DueDate` datetime DEFAULT NULL,
  `SalesRepRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepRef_FullName` varchar(255) DEFAULT NULL,
  `ShipDate` datetime DEFAULT NULL,
  `ShipMethodRef_ListID` varchar(255) DEFAULT NULL,
  `ShipMethodRef_FullName` varchar(255) DEFAULT NULL,
  `FOB` varchar(255) DEFAULT NULL,
  `Subtotal` decimal(15,5) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxPercentage` varchar(255) DEFAULT NULL,
  `SalesTaxTotal` decimal(15,5) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `TotalAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerMsgRef_FullName` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `IsToBeEmailed` varchar(255) DEFAULT NULL,
  `IsTaxIncluded` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerSalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_ListID` varchar(255) DEFAULT NULL,
  `DepositToAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Other` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `salesreceiptIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesreceiptlinedetail`
--

DROP TABLE IF EXISTS `salesreceiptlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesreceiptlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `RatePercent` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `Other1` varchar(255) DEFAULT NULL,
  `Other2` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salesreceiptlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesreceiptlinegroupdetail`
--

DROP TABLE IF EXISTS `salesreceiptlinegroupdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesreceiptlinegroupdetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `IsPrintItemsInGroup` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `ServiceDate` datetime DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salesreceiptlinegroupdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salesrep`
--

DROP TABLE IF EXISTS `salesrep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesrep` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Initial` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `SalesRepEntityRef_ListID` varchar(255) DEFAULT NULL,
  `SalesRepEntityRef_FullName` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `salesrepIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salestaxcode`
--

DROP TABLE IF EXISTS `salestaxcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salestaxcode` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `IsTaxable` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `ItemPurchaseTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemPurchaseTaxRef_FullName` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `salestaxcodeIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salestaxpaymentcheck`
--

DROP TABLE IF EXISTS `salestaxpaymentcheck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salestaxpaymentcheck` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `PayeeEntityRef_ListID` varchar(255) DEFAULT NULL,
  `PayeeEntityRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `BankAccountRef_ListID` varchar(255) DEFAULT NULL,
  `BankAccountRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Address_Addr1` varchar(255) DEFAULT NULL,
  `Address_Addr2` varchar(255) DEFAULT NULL,
  `Address_Addr3` varchar(255) DEFAULT NULL,
  `Address_Addr4` varchar(255) DEFAULT NULL,
  `Address_Addr5` varchar(255) DEFAULT NULL,
  `Address_City` varchar(255) DEFAULT NULL,
  `Address_State` varchar(255) DEFAULT NULL,
  `Address_PostalCode` varchar(255) DEFAULT NULL,
  `Address_Country` varchar(255) DEFAULT NULL,
  `Address_Note` varchar(255) DEFAULT NULL,
  `IsToBePrinted` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `salestaxpaymentcheckIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `salestaxpaymentchecklinedetail`
--

DROP TABLE IF EXISTS `salestaxpaymentchecklinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salestaxpaymentchecklinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_ListID` varchar(255) DEFAULT NULL,
  `ItemSalesTaxRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `salestaxpaymentchecklinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipmethod`
--

DROP TABLE IF EXISTS `shipmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipmethod` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `shipmethodIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shiptoaddressdetail`
--

DROP TABLE IF EXISTS `shiptoaddressdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shiptoaddressdetail` (
  `Name` varchar(255) DEFAULT NULL,
  `Addr1` varchar(255) DEFAULT NULL,
  `Addr2` varchar(255) DEFAULT NULL,
  `Addr3` varchar(255) DEFAULT NULL,
  `Addr4` varchar(255) DEFAULT NULL,
  `Addr5` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `PostalCode` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `Note` varchar(255) DEFAULT NULL,
  `DefaultShipTo` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `shiptoaddressdetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sickhoursdetail`
--

DROP TABLE IF EXISTS `sickhoursdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sickhoursdetail` (
  `HoursAvailable` varchar(255) DEFAULT NULL,
  `AccrualPeriod` varchar(255) DEFAULT NULL,
  `HoursAccrued` varchar(255) DEFAULT NULL,
  `MaximumHours` varchar(255) DEFAULT NULL,
  `IsResettingHoursEachNewYear` varchar(255) DEFAULT NULL,
  `HoursUsed` varchar(255) DEFAULT NULL,
  `AccrualStartDate` datetime DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `standardterms`
--

DROP TABLE IF EXISTS `standardterms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standardterms` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `StdDueDays` int(11) DEFAULT NULL,
  `StdDiscountDays` int(11) DEFAULT NULL,
  `DiscountPct` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `standardtermsIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `template`
--

DROP TABLE IF EXISTS `template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `TemplateType` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `templateIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `terms`
--

DROP TABLE IF EXISTS `terms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terms` (
  `ListID` varchar(200) DEFAULT NULL,
  `FullName` varchar(200) DEFAULT NULL,
  `TableName` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `timetracking`
--

DROP TABLE IF EXISTS `timetracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetracking` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `EntityRef_ListID` varchar(255) DEFAULT NULL,
  `EntityRef_FullName` varchar(255) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ItemServiceRef_ListID` varchar(255) DEFAULT NULL,
  `ItemServiceRef_FullName` varchar(255) DEFAULT NULL,
  `Rate` varchar(255) DEFAULT NULL,
  `Duration` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `PayrollItemWageRef_ListID` varchar(255) DEFAULT NULL,
  `PayrollItemWageRef_FullName` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `IsBillable` varchar(255) DEFAULT NULL,
  `IsBilled` varchar(255) DEFAULT NULL,
  `BillableStatus` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `timetrackingIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todo` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `IsActive` varchar(255) DEFAULT NULL,
  `IsDone` varchar(255) DEFAULT NULL,
  `ReminderDate` datetime DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `todoIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnType` varchar(255) DEFAULT NULL,
  `TxnLineID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EntityRef_ListID` varchar(255) DEFAULT NULL,
  `EntityRef_FullName` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `AmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transfer`
--

DROP TABLE IF EXISTS `transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transfer` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `TransferFromAccountRef_ListID` varchar(255) DEFAULT NULL,
  `TransferFromAccountRef_FullName` varchar(255) DEFAULT NULL,
  `FromAccountBalance` decimal(15,5) DEFAULT NULL,
  `TransferToAccountRef_ListID` varchar(255) DEFAULT NULL,
  `TransferToAccountRef_FullName` varchar(255) DEFAULT NULL,
  `ToAccountBalance` decimal(15,5) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `transferIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transferinventory`
--

DROP TABLE IF EXISTS `transferinventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferinventory` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `FromInventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `FromInventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `ToInventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `ToInventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `ExternalGUID` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `transferinventoryIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transferinventorylinedetail`
--

DROP TABLE IF EXISTS `transferinventorylinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferinventorylinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `FromInventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `FromInventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `ToInventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `ToInventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `QuantityTransferred` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `transferinventorylinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `txnexpenselinedetail`
--

DROP TABLE IF EXISTS `txnexpenselinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `txnexpenselinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `AccountRef_ListID` varchar(255) DEFAULT NULL,
  `AccountRef_FullName` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `BillableStatus` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `txnexpenselinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `txnitemgrouplinedetail`
--

DROP TABLE IF EXISTS `txnitemgrouplinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `txnitemgrouplinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_ListID` varchar(255) DEFAULT NULL,
  `ItemGroupRef_FullName` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `txnitemgrouplinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `txnitemlinedetail`
--

DROP TABLE IF EXISTS `txnitemlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `txnitemlinedetail` (
  `TxnLineID` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteRef_FullName` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_ListID` varchar(255) DEFAULT NULL,
  `InventorySiteLocationRef_FullName` varchar(255) DEFAULT NULL,
  `SerialNumber` varchar(255) DEFAULT NULL,
  `LotNumber` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Quantity` varchar(255) DEFAULT NULL,
  `UnitOfMeasure` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_ListID` varchar(255) DEFAULT NULL,
  `OverrideUOMSetRef_FullName` varchar(255) DEFAULT NULL,
  `Cost` varchar(255) DEFAULT NULL,
  `Amount` decimal(15,5) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `BillableStatus` varchar(255) DEFAULT NULL,
  `LinkedTxnID` varchar(255) DEFAULT NULL,
  `LinkedTxnLineID` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `txnitemlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `txnpaymentlinedetail`
--

DROP TABLE IF EXISTS `txnpaymentlinedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `txnpaymentlinedetail` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TxnType` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `TotalAmount` decimal(15,5) DEFAULT NULL,
  `AppliedAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL,
  `GroupIDKEY` varchar(255) DEFAULT NULL,
  KEY `txnpaymentlinedetailID` (`IDKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `unitofmeasureset`
--

DROP TABLE IF EXISTS `unitofmeasureset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unitofmeasureset` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `UnitOfMeasureType` varchar(255) DEFAULT NULL,
  `BaseUnitName` varchar(255) DEFAULT NULL,
  `BaseUnitAbbreviation` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `unitofmeasuresetIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `userconfig`
--

DROP TABLE IF EXISTS `userconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userconfig` (
  `Name` varchar(200) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `LastLogin` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vacationhoursdetail`
--

DROP TABLE IF EXISTS `vacationhoursdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacationhoursdetail` (
  `HoursAvailable` varchar(255) DEFAULT NULL,
  `AccrualPeriod` varchar(255) DEFAULT NULL,
  `HoursAccrued` varchar(255) DEFAULT NULL,
  `MaximumHours` varchar(255) DEFAULT NULL,
  `IsResettingHoursEachNewYear` varchar(255) DEFAULT NULL,
  `HoursUsed` varchar(255) DEFAULT NULL,
  `AccrualStartDate` datetime DEFAULT NULL,
  `IDKEY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `vehicleIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehiclemileage`
--

DROP TABLE IF EXISTS `vehiclemileage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiclemileage` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `VehicleRef_ListID` varchar(255) DEFAULT NULL,
  `VehicleRef_FullName` varchar(255) DEFAULT NULL,
  `CustomerRef_ListID` varchar(255) DEFAULT NULL,
  `CustomerRef_FullName` varchar(255) DEFAULT NULL,
  `ItemRef_ListID` varchar(255) DEFAULT NULL,
  `ItemRef_FullName` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `TripStartDate` datetime DEFAULT NULL,
  `TripEndDate` datetime DEFAULT NULL,
  `OdometerStart` varchar(255) DEFAULT NULL,
  `OdometerEnd` varchar(255) DEFAULT NULL,
  `TotalMiles` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `BillableStatus` varchar(255) DEFAULT NULL,
  `StandardMileageRate` varchar(255) DEFAULT NULL,
  `StandardMileageTotalAmount` decimal(15,5) DEFAULT NULL,
  `BillableRate` varchar(255) DEFAULT NULL,
  `BillableAmount` decimal(15,5) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `vehiclemileageIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ClassRef_ListID` varchar(255) DEFAULT NULL,
  `ClassRef_FullName` varchar(255) DEFAULT NULL,
  `CompanyName` varchar(255) DEFAULT NULL,
  `Salutation` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `MiddleName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `JobTitle` varchar(255) DEFAULT NULL,
  `Suffix` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr1` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr2` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr3` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr4` varchar(255) DEFAULT NULL,
  `VendorAddress_Addr5` varchar(255) DEFAULT NULL,
  `VendorAddress_City` varchar(255) DEFAULT NULL,
  `VendorAddress_State` varchar(255) DEFAULT NULL,
  `VendorAddress_PostalCode` varchar(255) DEFAULT NULL,
  `VendorAddress_Country` varchar(255) DEFAULT NULL,
  `VendorAddress_Note` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr1` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr2` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr3` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr4` varchar(255) DEFAULT NULL,
  `ShipAddress_Addr5` varchar(255) DEFAULT NULL,
  `ShipAddress_City` varchar(255) DEFAULT NULL,
  `ShipAddress_State` varchar(255) DEFAULT NULL,
  `ShipAddress_PostalCode` varchar(255) DEFAULT NULL,
  `ShipAddress_Country` varchar(255) DEFAULT NULL,
  `ShipAddress_Note` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Mobile` varchar(255) DEFAULT NULL,
  `Pager` varchar(255) DEFAULT NULL,
  `AltPhone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Cc` varchar(255) DEFAULT NULL,
  `Contact` varchar(255) DEFAULT NULL,
  `AltContact` varchar(255) DEFAULT NULL,
  `NameOnCheck` varchar(255) DEFAULT NULL,
  `Notes` longtext,
  `AccountNumber` varchar(255) DEFAULT NULL,
  `VendorTypeRef_ListID` varchar(255) DEFAULT NULL,
  `VendorTypeRef_FullName` varchar(255) DEFAULT NULL,
  `TermsRef_ListID` varchar(255) DEFAULT NULL,
  `TermsRef_FullName` varchar(255) DEFAULT NULL,
  `CreditLimit` decimal(15,5) DEFAULT NULL,
  `VendorTaxIdent` varchar(255) DEFAULT NULL,
  `IsVendorEligibleFor1099` varchar(255) DEFAULT NULL,
  `Balance` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `BillingRateRef_ListID` varchar(255) DEFAULT NULL,
  `BillingRateRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxCodeRef_FullName` varchar(255) DEFAULT NULL,
  `SalesTaxCountry` varchar(255) DEFAULT NULL,
  `IsSalesTaxAgency` varchar(255) DEFAULT NULL,
  `SalesTaxReturnRef_ListID` varchar(255) DEFAULT NULL,
  `SalesTaxReturnRef_FullName` varchar(255) DEFAULT NULL,
  `TaxRegistrationNumber` varchar(255) DEFAULT NULL,
  `ReportingPeriod` varchar(255) DEFAULT NULL,
  `IsTaxTrackedOnPurchases` varchar(255) DEFAULT NULL,
  `TaxOnPurchasesAccountRef_ListID` varchar(255) DEFAULT NULL,
  `TaxOnPurchasesAccountRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxTrackedOnSales` varchar(255) DEFAULT NULL,
  `TaxOnSalesAccountRef_ListID` varchar(255) DEFAULT NULL,
  `TaxOnSalesAccountRef_FullName` varchar(255) DEFAULT NULL,
  `IsTaxOnTax` varchar(255) DEFAULT NULL,
  `PrefillAccountRef_ListID` varchar(255) DEFAULT NULL,
  `PrefillAccountRef_FullName` varchar(255) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `vendorIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendorcredit`
--

DROP TABLE IF EXISTS `vendorcredit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendorcredit` (
  `TxnID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `TxnNumber` int(11) DEFAULT NULL,
  `VendorRef_ListID` varchar(255) DEFAULT NULL,
  `VendorRef_FullName` varchar(255) DEFAULT NULL,
  `APAccountRef_ListID` varchar(255) DEFAULT NULL,
  `APAccountRef_FullName` varchar(255) DEFAULT NULL,
  `TxnDate` datetime DEFAULT NULL,
  `CreditAmount` decimal(15,5) DEFAULT NULL,
  `CurrencyRef_ListID` varchar(255) DEFAULT NULL,
  `CurrencyRef_FullName` varchar(255) DEFAULT NULL,
  `ExchangeRate` float DEFAULT NULL,
  `CreditAmountInHomeCurrency` decimal(15,5) DEFAULT NULL,
  `RefNumber` varchar(255) DEFAULT NULL,
  `Memo` varchar(255) DEFAULT NULL,
  `OpenAmount` decimal(15,5) DEFAULT NULL,
  `CustomField1` varchar(50) DEFAULT NULL,
  `CustomField2` varchar(50) DEFAULT NULL,
  `CustomField3` varchar(50) DEFAULT NULL,
  `CustomField4` varchar(50) DEFAULT NULL,
  `CustomField5` varchar(50) DEFAULT NULL,
  `CustomField6` varchar(50) DEFAULT NULL,
  `CustomField7` varchar(50) DEFAULT NULL,
  `CustomField8` varchar(50) DEFAULT NULL,
  `CustomField9` varchar(50) DEFAULT NULL,
  `CustomField10` varchar(50) DEFAULT NULL,
  `CustomField11` varchar(50) DEFAULT NULL,
  `CustomField12` varchar(50) DEFAULT NULL,
  `CustomField13` varchar(50) DEFAULT NULL,
  `CustomField14` varchar(50) DEFAULT NULL,
  `CustomField15` varchar(50) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `vendorcreditIdIndex` (`TxnID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendortype`
--

DROP TABLE IF EXISTS `vendortype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendortype` (
  `ListID` varchar(255) DEFAULT NULL,
  `TimeCreated` varchar(255) DEFAULT NULL,
  `TimeModified` varchar(255) DEFAULT NULL,
  `EditSequence` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `FullName` varchar(255) DEFAULT NULL,
  `IsActive` varchar(255) DEFAULT NULL,
  `ParentRef_ListID` varchar(255) DEFAULT NULL,
  `ParentRef_FullName` varchar(255) DEFAULT NULL,
  `Sublevel` int(11) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  KEY `vendortypeIdIndex` (`ListID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-02 15:48:06
