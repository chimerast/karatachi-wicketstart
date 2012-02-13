package root.entity;

import java.io.Serializable;

import org.seasar.dao.annotation.tiger.Bean;

@Bean(table = "corp_bss")
public class CorpBss implements Serializable {
    private static final long serialVersionUID = 1L;

    public String globalId;
    public long corpId;
    public String corpFrmlNameVch;
    public String corpLegalNameVch;
    public int legalNameDisplaySgn;
    public String corpImfrmlNameVch;
    public String corpNameKanaVch;
    public String corpNameEngVch;
    public String addSrchNameVch;
    public String srchCorpNameVch;
    public int corpSttsId;
    public int corpSttsApTyp;
    public int listSgn;
    public int listYmd;
    public String listMktId;
    public int delistYmd;
    public String secIdntCd;
    public String msCompanyId;
    public String tykzCorpCd;
    public String edinetCd;
    public String cik;
    public int corpSgn;
    public int inoutTyp;
    public String mainIdstId;
    public String busiDscrpVch;
    public String prblmToDealWithVch;
    public String busiRiskVch;
    public String rAndDActVch;
    public String opeRsltAnlysVch;
    public String busiInvstSmryVch;
    public String tykzSmryVch;
    public String shortDescription;
    public String mediumDescription;
    public String longDescription;
    public int closeTyp;
    public int dataDigitTyp;
    public String wbstVch;
    public String presidentNameVch;
    public String adrsVch;
    public String telVch;
    public int estblYmd;
    public int accTermNum;
    public int mostRcntQuarterYear;
    public int mostRcntQuarterPeriodNum;
    public String mostRcntQuarterAccSttlCd;
    public int mostRcntFullYearYear;
    public int mostRcntFullYearPeriodNum;
    public int coEmplyNum;
    public int coEmplyAccSttlPeriodNum;
    public int ncEmplyNum;
    public int ncEmplyAccSttlPeriodNum;
    public double avgAnnlIncmNum;
    public int avgAnnlIncmAccSttlPeriodNum;
    public int avgAgeNum;
    public int avgAgeAccSttlPeriodNum;
    public String lineBankVch;
    public String countryId;
    public int globalOptionTyp;
    public String currencyId;
}
