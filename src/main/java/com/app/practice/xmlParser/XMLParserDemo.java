package com.app.practice.xmlParser;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import jdk.internal.org.xml.sax.InputSource;


public class XMLParserDemo {

    public static void main(String[] args) throws Exception {
        XMLParserDemo demo = new XMLParserDemo();
        demo.xPathProcessor();
    }

    public void xPathProcessor() throws Exception {

        //Create DocumentBuilderFactory for reading xml file
        //DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //DocumentBuilder builder = factory.newDocumentBuilder();
        //Document doc = builder.parse("smartphone.xml");

        String xmlString = "<root>\n"
                + "    <wallet>\n"
                + "        <getAllBanks id=\"0\">\n"
                + "            <getBankListByBankAccountNumber>null</getBankListByBankAccountNumber>\n"
                + "            <getAccountNumber>1496954122832818964</getAccountNumber>\n"
                + "            <getTimeCreated>Wed May 08 08:04:34 PDT 2013</getTimeCreated>\n"
                + "            <getAchNonfinalTransCount>2</getAchNonfinalTransCount>\n"
                + "            <getIachNonfinalTransCount>2</getIachNonfinalTransCount>\n"
                + "            <getBankAccountNumberHmac>1Dz-wiTR5WcVpXBREogq7OjK6wA</getBankAccountNumberHmac>\n"
                + "            <getBranchNumber/>\n"
                + "            <getBufsNonfinalTransCount>0</getBufsNonfinalTransCount>\n"
                + "            <getIsAdminBypass>false</getIsAdminBypass>\n"
                + "            <getBankAccountNumberLast4>8499</getBankAccountNumberLast4>\n"
                + "            <getPendingAuthCount>3</getPendingAuthCount>\n"
                + "            <getIsYodleeVerified>false</getIsYodleeVerified>\n"
                + "            <getIsRandomDepositOrIAVVerified>true</getIsRandomDepositOrIAVVerified>\n"
                + "            <getIsUntrustedBank>false</getIsUntrustedBank>\n"
                + "            <getIsNapIvrConfirmed>null</getIsNapIvrConfirmed>\n"
                + "            <getIsDeactivated>false</getIsDeactivated>\n"
                + "            <getAchNonfinalTransAmountSumUsd>\n"
                + "                <has_negative_balance>false</has_negative_balance>\n"
                + "                <amount_in_cents_raw>3793</amount_in_cents_raw>\n"
                + "                <usd_amount_in_cents>3793</usd_amount_in_cents>\n"
                + "                <getUsdAmount>37</getUsdAmount>\n"
                + "                <getCurrencyCode>USD</getCurrencyCode>\n"
                + "            </getAchNonfinalTransAmountSumUsd>\n"
                + "            <getBankListByBankAcctNumberHmac>null</getBankListByBankAcctNumberHmac>\n"
                + "            <getAuthMemberNumberVerifyTime>null</getAuthMemberNumberVerifyTime>\n"
                + "            <getIachNonFinalTransAmountSumUsd>\n"
                + "                <has_negative_balance>false</has_negative_balance>\n"
                + "                <amount_in_cents_raw>3793</amount_in_cents_raw>\n"
                + "                <usd_amount_in_cents>3793</usd_amount_in_cents>\n"
                + "                <getUsdAmount>37</getUsdAmount>\n"
                + "                <getCurrencyCode>USD</getCurrencyCode>\n"
                + "            </getIachNonFinalTransAmountSumUsd>\n"
                + "            <getIsoCurrency>EUR</getIsoCurrency>\n"
                + "            <getStatus>65</getStatus>\n"
                + "            <getIsConfirmed>true</getIsConfirmed>\n"
                + "            <getRoutingNumber>12030000</getRoutingNumber>\n"
                + "            <getBankAccountNumberRaw/>\n"
                + "            <getBankAccountNumberLength>0</getBankAccountNumberLength>\n"
                + "            <getIsDisabled>false</getIsDisabled>\n"
                + "            <getIsRtnBad>false</getIsRtnBad>\n"
                + "            <getAuthVerifyTime>Tue May 14 09:19:48 PDT 2013</getAuthVerifyTime>\n"
                + "            <getBankBalanceCurrencyCode/>\n"
                + "            <getBankBalance>null</getBankBalance>\n"
                + "            <getExternalBankBalance>null</getExternalBankBalance>\n"
                + "            <getNativeBankAccountName>null</getNativeBankAccountName>\n"
                + "            <getBankName>Deutsche Kreditbank Berlin</getBankName>\n"
                + "            <getBankAccountName>Thomas Schnee</getBankAccountName>\n"
                + "            <getIsoCountry>DE</getIsoCountry>\n"
                + "            <getEncryptedId>BA-A2WXYGAPQM5JQ</getEncryptedId>\n"
                + "            <getVendorId/>\n"
                + "            <getBufsNonfinalTransAmountSumUsd>\n"
                + "                <has_negative_balance>false</has_negative_balance>\n"
                + "                <amount_in_cents_raw>0</amount_in_cents_raw>\n"
                + "                <usd_amount_in_cents>0</usd_amount_in_cents>\n"
                + "                <getUsdAmount>0</getUsdAmount>\n"
                + "                <getCurrencyCode>USD</getCurrencyCode>\n"
                + "            </getBufsNonfinalTransAmountSumUsd>\n"
                + "            <firstTimeTypeAstatusS>Mon Nov 30 14:25:53 PST 2015</firstTimeTypeAstatusS>\n"
                + "            <nocCausedDuplicate>false</nocCausedDuplicate>\n"
                + "            <getBankAccountHolderName/>\n"
                + "            <hasNsfRdrReturn>false</hasNsfRdrReturn>\n"
                + "            <hasUnAuthRdrReturn>false</hasUnAuthRdrReturn>\n"
                + "            <getBankIdentifierCode/>\n"
                + "            <getExternalBankBalanceCurrencyCode/>\n"
                + "            <getIsFigoVerified>null</getIsFigoVerified>\n"
                + "            <getVendorDataTimestamp>null</getVendorDataTimestamp>\n"
                + "            <getExternalAccountType>null</getExternalAccountType>\n"
                + "            <getAuthStatus>null</getAuthStatus>\n"
                + "            <getCollectionPoint>null</getCollectionPoint>\n"
                + "            <getIsRtpEnabled>false</getIsRtpEnabled>\n"
                + "            <getDataSource/>\n"
                + "            <getRouting>Deutsche Kreditbank Berlin</getRouting>\n"
                + "            <getFlags>\n"
                + "                <getFlagsAsLong>134217728</getFlagsAsLong>\n"
                + "                <getFlags>134217728</getFlags>\n"
                + "            </getFlags>\n"
                + "            <getId>186791759</getId>\n"
                + "        </getAllBanks>\n"
                + "        <getAllBanks id=\"1\">\n"
                + "            <getBankListByBankAccountNumber>null</getBankListByBankAccountNumber>\n"
                + "            <getAccountNumber>1496954122832818964</getAccountNumber>\n"
                + "            <getTimeCreated>Fri Oct 12 11:18:35 PDT 2007</getTimeCreated>\n"
                + "            <getAchNonfinalTransCount>0</getAchNonfinalTransCount>\n"
                + "            <getIachNonfinalTransCount>0</getIachNonfinalTransCount>\n"
                + "            <getBankAccountNumberHmac>CmyjSljd94IuPyxnOR5CXYS40v4</getBankAccountNumberHmac>\n"
                + "            <getBranchNumber/>\n"
                + "            <getBufsNonfinalTransCount>0</getBufsNonfinalTransCount>\n"
                + "            <getIsAdminBypass>false</getIsAdminBypass>\n"
                + "            <getBankAccountNumberLast4>1945</getBankAccountNumberLast4>\n"
                + "            <getPendingAuthCount>0</getPendingAuthCount>\n"
                + "            <getIsYodleeVerified>false</getIsYodleeVerified>\n"
                + "            <getIsRandomDepositOrIAVVerified>true</getIsRandomDepositOrIAVVerified>\n"
                + "            <getIsUntrustedBank>false</getIsUntrustedBank>\n"
                + "            <getIsNapIvrConfirmed>null</getIsNapIvrConfirmed>\n"
                + "            <getIsDeactivated>true</getIsDeactivated>\n"
                + "            <getAchNonfinalTransAmountSumUsd>\n"
                + "                <has_negative_balance>false</has_negative_balance>\n"
                + "                <amount_in_cents_raw>0</amount_in_cents_raw>\n"
                + "                <usd_amount_in_cents>0</usd_amount_in_cents>\n"
                + "                <getUsdAmount>0</getUsdAmount>\n"
                + "                <getCurrencyCode>USD</getCurrencyCode>\n"
                + "            </getAchNonfinalTransAmountSumUsd>\n"
                + "            <getBankListByBankAcctNumberHmac>null</getBankListByBankAcctNumberHmac>\n"
                + "            <getAuthMemberNumberVerifyTime>null</getAuthMemberNumberVerifyTime>\n"
                + "            <getIachNonFinalTransAmountSumUsd>\n"
                + "                <has_negative_balance>false</has_negative_balance>\n"
                + "                <amount_in_cents_raw>0</amount_in_cents_raw>\n"
                + "                <usd_amount_in_cents>0</usd_amount_in_cents>\n"
                + "                <getUsdAmount>0</getUsdAmount>\n"
                + "                <getCurrencyCode>USD</getCurrencyCode>\n"
                + "            </getIachNonFinalTransAmountSumUsd>\n"
                + "            <getIsoCurrency>EUR</getIsoCurrency>\n"
                + "            <getStatus>65</getStatus>\n"
                + "            <getIsConfirmed>true</getIsConfirmed>\n"
                + "            <getRoutingNumber>65351260</getRoutingNumber>\n"
                + "            <getBankAccountNumberRaw/>\n"
                + "            <getBankAccountNumberLength>0</getBankAccountNumberLength>\n"
                + "            <getIsDisabled>false</getIsDisabled>\n"
                + "            <getIsRtnBad>false</getIsRtnBad>\n"
                + "            <getAuthVerifyTime>Tue Oct 16 11:17:55 PDT 2007</getAuthVerifyTime>\n"
                + "            <getBankBalanceCurrencyCode/>\n"
                + "            <getBankBalance>null</getBankBalance>\n"
                + "            <getExternalBankBalance>null</getExternalBankBalance>\n"
                + "            <getNativeBankAccountName>null</getNativeBankAccountName>\n"
                + "            <getBankName>Sparkasse Zollernalb</getBankName>\n"
                + "            <getBankAccountName>Thomas Schnee</getBankAccountName>\n"
                + "            <getIsoCountry>DE</getIsoCountry>\n"
                + "            <getEncryptedId>BA-DUUWRHBRM2PJU</getEncryptedId>\n"
                + "            <getVendorId/>\n"
                + "            <getBufsNonfinalTransAmountSumUsd>\n"
                + "                <has_negative_balance>false</has_negative_balance>\n"
                + "                <amount_in_cents_raw>0</amount_in_cents_raw>\n"
                + "                <usd_amount_in_cents>0</usd_amount_in_cents>\n"
                + "                <getUsdAmount>0</getUsdAmount>\n"
                + "                <getCurrencyCode>USD</getCurrencyCode>\n"
                + "            </getBufsNonfinalTransAmountSumUsd>\n"
                + "            <firstTimeTypeAstatusS>Wed Dec 31 16:00:00 PST 1969</firstTimeTypeAstatusS>\n"
                + "            <nocCausedDuplicate>false</nocCausedDuplicate>\n"
                + "            <getBankAccountHolderName/>\n"
                + "            <hasNsfRdrReturn>false</hasNsfRdrReturn>\n"
                + "            <hasUnAuthRdrReturn>false</hasUnAuthRdrReturn>\n"
                + "            <getBankIdentifierCode/>\n"
                + "            <getExternalBankBalanceCurrencyCode/>\n"
                + "            <getIsFigoVerified>null</getIsFigoVerified>\n"
                + "            <getVendorDataTimestamp>null</getVendorDataTimestamp>\n"
                + "            <getExternalAccountType>null</getExternalAccountType>\n"
                + "            <getAuthStatus>null</getAuthStatus>\n"
                + "            <getCollectionPoint>null</getCollectionPoint>\n"
                + "            <getIsRtpEnabled>false</getIsRtpEnabled>\n"
                + "            <getDataSource/>\n"
                + "            <getRouting>Sparkasse Zollernalb</getRouting>\n"
                + "            <getFlags>\n"
                + "                <getFlagsAsLong>637535237</getFlagsAsLong>\n"
                + "                <getFlags>637535237</getFlags>\n"
                + "            </getFlags>\n"
                + "            <getId>67159901</getId>\n"
                + "        </getAllBanks>\n"
                + "    </wallet>\n"
                + "</root>";
        Document doc = convertStringToDocument(xmlString);

        String xpathString = "/root/wallet/getAllBanks/getBankAccountNumberLast4/text()";
        //"/smartphones/smartphone/brand/text()";

        // Create XPathFactory for creating XPath Object
        XPathFactory xPathFactory = XPathFactory.newInstance();

        // Create XPath object from XPathFactory
        XPath xpath = xPathFactory.newXPath();

        // Compile the XPath expression for getting all brands
        XPathExpression xPathExpr = xpath.compile(xpathString);

        // XPath text example : executing xpath expression in java
        Object result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Java Xpath text example: All brands of popular smartphones ");
        printXpathResult(result);

        /*//get all models by xpath expression in java
        xPathExpr = xpath.compile("/smartphones/smartphone/model/text()");
        result = xPathExpr.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Java Xpath text example: All popular smartphone model ");
        printXpathResult(result);

        // XPath count example : XPath expression to count elements in xml
        xPathExpr = xpath.compile("count(/smartphones/smartphone)");
        Double count = (Double) xPathExpr.evaluate(doc, XPathConstants.NUMBER);
        System.out.println("XPath count example: How many Smartphones we have: ");
        System.out.println("Count of elements: " + count);

        // XPath conditional exampl e: Do we have any HTC smartphone
        xPathExpr = xpath.compile("count(/smartphones/smartphone[brand='HTC']) > 0");
        Boolean test = (Boolean) xPathExpr.evaluate(doc, XPathConstants.BOOLEAN);
        System.out.println("XPath boolean example: Do we have any HTC smartphone ");
        System.out.println(test);*/

    }

    private void printXpathResult(Object result) {
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }

    private static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new org.xml.sax.InputSource(new StringReader(xmlStr)));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
