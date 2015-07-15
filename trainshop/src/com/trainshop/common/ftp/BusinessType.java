package com.trainshop.common.ftp;

/**
 * 附件上传业务类型
 * 
 */
public enum BusinessType {
	
	Contract(1), Test(0), Order(2), Bidingplan(3), Contract2(4), Supplier(5),
	Plan(6),
	Change(7),
	Price(8),
	Money(9),
	Money2(10),
	Certification(11),
	Temporary(12),
	Overflow(13),
	ContractJBSH(14),
	Bidingplan_tender(15),
	Bidingplan_prequalification(16),
	Bidingplan_invitation(17),
	Bidingplan_backstandard(18),
	Bidingplan_evaluation(19),
	Bidingplan_negotiation(20),
	Bidingplan_calibration(21),
	
	FrameworkAgreement(22),
	
	Online_BiddingModel(23),
	Online_BiddingDocument(24),
	Online_Supplier(25),
	
	Output(26);

	public static final int VALUE_CONTRACT  = 1 ;    //合同
	public static final int VALUE_TEST  = 0 ;
	public static final int VALUE_ORDER  =1 ;
	public static final int VALUE_BIDINGPLAN  = 3 ;
	public static final int VALUE_CONTRACT2  =  4;
	public static final int VALUE_SUPPLIER  = 5 ;
	public static final int VALUE_PLAN  = 6 ;
	public static final int VALUE_CHANGE  = 7 ;
	public static final int VALUE_PRICE  = 8 ;
	public static final int VALUE_MONEY  = 9 ;
	public static final int VALUE_MONEY2  = 10 ;
	public static final int VALUE_CERTIFICATION  = 11 ;
	public static final int VALUE_TEMPORARY  = 12 ;
	public static final int VALUE_OVERFLOW  = 13 ;
	public static final int VALUE_CONTRACTJBSH = 14 ;
	public static final int VALUE_BIDINGPLAN_TENDER  = 15 ;
	public static final int VALUE_BIDINGPLAN_PREQUALIFICATION  = 16 ;
	public static final int VALUE_BIDINGPLAN_INVITITATION  = 17 ;
	public static final int VALUE_BIDINGPLAN_BACKSTANDARD  = 18 ;
	public static final int VALUE_BIDINGPLAN_EVALUATION  = 19 ;
	public static final int VALUE_BIDINGPLAN_NEGOTIATION  = 20 ;
	public static final int VALUE_BIDINGPLAN_CALIBRATION = 21 ;
	public static final int VALUE_FrameworkAgreement = 22 ;
	
	public static final int VALUE_Online_BiddingModel = 23 ;
	public static final int VALUE_Online_BiddingDocument = 24 ;
	public static final int VALUE_Online_Supplier = 25 ;
	
	public static final int VALUE_Ouput = 26 ;
	
	private int value;

	public static final String BUSINESSTYPE_CONTRACT = "CONTRACT";
	public static final String BUSINESSTYPE_TEST = "TEST";
	public static final String BUSINESSTYPE_ORDER = "ORDER";
	public static final String BUSINESSTYPE_BIDINGPLAN = "BIDINGPLAN";
	public static final String BUSINESSTYPE_CONTRACT2 = "CONTRACT2";
	public static final String BUSINESSTYPE_SUPPLIER = "SUPPLIER";
	public static final String BUSINESSTYPE_PLAN = "PLAN";
	public static final String BUSINESSTYPE_CHANGE = "CHANGE";
	public static final String BUSINESSTYPE_PRICE = "PRICE";
	public static final String BUSINESSTYPE_MONEY = "MONEY";
	public static final String BUSINESSTYPE_MONEY2 = "MONEY2";
	public static final String BUSINESSTYPE_CERTIFICATION = "CERTIFICATION";
	public static final String BUSINESSTYPE_TEMPORARY = "TEMPORARY";
	public static final String BUSINESSTYPE_OVERFLOW = "OVERFLOW";
	public static final String BUSINESSTYPE_CONTRACTJBSH = "CONTRACTJBSH";
	
	public static final String BUSINESSTYPE_BIDINGPLAN_TENDER = "BIDINGPLAN_TENDER";
	public static final String BUSINESSTYPE_BIDINGPLAN_PREQUALIFICATION = "BIDINGPLAN_PREQUALIFICATION";
	public static final String BUSINESSTYPE_BIDINGPLAN_INVITITATION = "BIDINGPLAN_INVITITATION";
	public static final String BUSINESSTYPE_BIDINGPLAN_BACKSTANDARD = "BIDINGPLAN_BACKSTANDARD";
	public static final String BUSINESSTYPE_BIDINGPLAN_EVALUATION = "BIDINGPLAN_EVALUATION";
	public static final String BUSINESSTYPE_BIDINGPLAN_NEGOTIATION = "BIDINGPLAN_NEGOTIATION";
	public static final String BUSINESSTYPE_BIDINGPLAN_CALIBRATION = "BIDINGPLAN_CALIBRATION";
	
	public static final String BUSINESSTYPE_FRAMEWORKAGREEMENT = "FRAMEWORKAGREEMENT";
	
	public static final String BUSINESSTYPE_ONLINE_BIDDINGMODEL = "ONLINE_BIDDINGMODEL";
	public static final String BUSINESSTYPE_ONLINE_BIDDINGDOCUMENT = "ONLINE_BIDDINGDOCUMENT";
	public static final String BUSINESSTYPE_ONLINE_SUPPLIER = "ONLINE_SUPPLIER";
	
	public static final String BUSINESSTYPE_OUTPUT = "OUTPUT";

	BusinessType(int val) {
		this.value = val;
	}

	public int value() {
		return this.value;
	}

	public int value(String argv) {
		return parse(argv).value;
	}
	
	public static BusinessType parse(int argv) {
		if (Contract.value == argv) {
			return Contract;
		} else if (Order.value == argv) {
			return Order;
		} else if (Bidingplan.value == argv) {
			return Bidingplan;
		} else if (Contract2.value == argv) {
			return Contract2;
		} else if (Supplier.value == argv) {
			return Supplier;
		} else if (Plan.value == argv) {
			return Plan;
		} else if (Change.value == argv) {
			return Change;
		} else if (Price.value == argv) {
			return Price;
		} else if (Money.value == argv) {
			return Money;
		} else if (Money2.value == argv) {
			return Money2;
		} else if (Certification.value == argv) {
			return Certification;
		} else if (Temporary.value == argv) {
			return Temporary;
		} else if (Overflow.value == argv) {
			return Overflow;
		} else if (ContractJBSH.value == argv) {
			return ContractJBSH;
		}else if (Bidingplan_tender.value == argv) {
			return Bidingplan_tender;
		}else if (Bidingplan_prequalification.value == argv) {
			return Bidingplan_prequalification;
		}else if (Bidingplan_invitation.value == argv) {
			return Bidingplan_invitation;
		}else if (Bidingplan_backstandard.value == argv) {
			return Bidingplan_backstandard;
		}else if (Bidingplan_evaluation.value == argv) {
			return Bidingplan_evaluation;
		}else if (Bidingplan_negotiation.value == argv) {
			return Bidingplan_negotiation;
		}else if (Bidingplan_calibration.value == argv) {
			return Bidingplan_calibration;
		}else if (FrameworkAgreement.value == argv) {
			return FrameworkAgreement;
		}else if (Online_BiddingModel.value == argv) {
			return Online_BiddingModel;
		}else if (Online_BiddingDocument.value == argv) {
			return Online_BiddingDocument;
		}else if (Online_Supplier.value == argv) {
			return Online_Supplier;
		}else if (Output.value == argv) {
			return Output;
		}else{
			throw new IllegalArgumentException("unknow business type [" + argv
					+ "]");
		}
	}
	
	public static BusinessType parse(String argv) {
		if (BUSINESSTYPE_CONTRACT.equalsIgnoreCase(argv)) {
			return Contract;
		} else if (BUSINESSTYPE_TEST.equalsIgnoreCase(argv)) {
			return Test;
		} else if (BUSINESSTYPE_ORDER.equalsIgnoreCase(argv)) {
			return Order;
		} else if (BUSINESSTYPE_BIDINGPLAN.equalsIgnoreCase(argv)) {
			return Bidingplan;
		} else if (BUSINESSTYPE_CONTRACT2.equalsIgnoreCase(argv)) {
			return Contract;
		} else if (BUSINESSTYPE_SUPPLIER.equalsIgnoreCase(argv)) {
			return Supplier;
		} else if (BUSINESSTYPE_PLAN.equalsIgnoreCase(argv)) {
			return Plan;
		} else if (BUSINESSTYPE_CHANGE.equalsIgnoreCase(argv)) {
			return Change;
		} else if (BUSINESSTYPE_PRICE.equalsIgnoreCase(argv)) {
			return Price;
		} else if (BUSINESSTYPE_MONEY.equalsIgnoreCase(argv)) {
			return Money;
		} else if (BUSINESSTYPE_MONEY2.equalsIgnoreCase(argv)) {
			return Money2;
		} else if (BUSINESSTYPE_CERTIFICATION.equalsIgnoreCase(argv)) {
			return Certification;
		} else if (BUSINESSTYPE_TEMPORARY.equalsIgnoreCase(argv)) {
			return Temporary;
		} else if (BUSINESSTYPE_OVERFLOW.equalsIgnoreCase(argv)) {
			return Overflow;
		}else if (BUSINESSTYPE_CONTRACTJBSH.equalsIgnoreCase(argv)) {
			return ContractJBSH;
		} else if (BUSINESSTYPE_BIDINGPLAN_BACKSTANDARD.equalsIgnoreCase(argv)) {
			return Bidingplan_backstandard;
		} else if (BUSINESSTYPE_BIDINGPLAN_CALIBRATION.equalsIgnoreCase(argv)) {
			return Bidingplan_calibration;
		} else if (BUSINESSTYPE_BIDINGPLAN_EVALUATION.equalsIgnoreCase(argv)) {
			return Bidingplan_evaluation;
		} else if (BUSINESSTYPE_BIDINGPLAN_INVITITATION.equalsIgnoreCase(argv)) {
			return Bidingplan_invitation;
		} else if (BUSINESSTYPE_BIDINGPLAN_NEGOTIATION.equalsIgnoreCase(argv)) {
			return Bidingplan_negotiation;
		} else if (BUSINESSTYPE_BIDINGPLAN_PREQUALIFICATION.equalsIgnoreCase(argv)) {
			return Bidingplan_prequalification;
		} else if (BUSINESSTYPE_BIDINGPLAN_TENDER.equalsIgnoreCase(argv)) {
			return Bidingplan_tender;
		} else if (BUSINESSTYPE_FRAMEWORKAGREEMENT.equalsIgnoreCase(argv)) {
			return FrameworkAgreement;
		} else if (BUSINESSTYPE_ONLINE_BIDDINGMODEL.equalsIgnoreCase(argv)) {
			return Online_BiddingModel;
		} else if (BUSINESSTYPE_ONLINE_BIDDINGDOCUMENT.equalsIgnoreCase(argv)) {
			return Online_BiddingDocument;
		} else if (BUSINESSTYPE_ONLINE_SUPPLIER.equalsIgnoreCase(argv)) {
			return Online_Supplier;
		}else if (BUSINESSTYPE_OUTPUT.equalsIgnoreCase(argv)) {
			return Output;
		}else{
			throw new IllegalArgumentException("unknow business type [" + argv
					+ "]");
		}
	}

    public static String getString(BusinessType type){
    	switch (type) {
		case Contract:
			return BUSINESSTYPE_CONTRACT;
		case Test:
			return BUSINESSTYPE_TEST;
		case Order:
			return BUSINESSTYPE_ORDER;
		case Bidingplan:
			return BUSINESSTYPE_BIDINGPLAN;
		case Contract2:
			return BUSINESSTYPE_CONTRACT2;
		case Supplier:
			return BUSINESSTYPE_SUPPLIER;
		case Plan:
			return BUSINESSTYPE_PLAN;
		case Change:
			return BUSINESSTYPE_CHANGE;
		case Price:
			return BUSINESSTYPE_PRICE;
		case Money:
			return BUSINESSTYPE_MONEY;
		case Money2:
			return BUSINESSTYPE_MONEY2;
		case Certification:
			return BUSINESSTYPE_CERTIFICATION;
		case Temporary:
			return BUSINESSTYPE_TEMPORARY;
		case Overflow:
			return BUSINESSTYPE_OVERFLOW;
		case ContractJBSH:
			return BUSINESSTYPE_CONTRACTJBSH;
		case Bidingplan_backstandard:
			return BUSINESSTYPE_BIDINGPLAN_BACKSTANDARD;
		case Bidingplan_calibration:
			return BUSINESSTYPE_BIDINGPLAN_CALIBRATION;
		case Bidingplan_evaluation:
			return BUSINESSTYPE_BIDINGPLAN_EVALUATION;
		case Bidingplan_invitation:
			return BUSINESSTYPE_BIDINGPLAN_INVITITATION;
		case Bidingplan_negotiation:
			return BUSINESSTYPE_BIDINGPLAN_NEGOTIATION;
		case Bidingplan_prequalification:
			return BUSINESSTYPE_BIDINGPLAN_PREQUALIFICATION;
		case Bidingplan_tender:
			return BUSINESSTYPE_BIDINGPLAN_TENDER;
		case FrameworkAgreement:
			return BUSINESSTYPE_FRAMEWORKAGREEMENT;
		case Online_BiddingModel:
			return BUSINESSTYPE_ONLINE_BIDDINGMODEL;
		case Online_BiddingDocument:
			return BUSINESSTYPE_ONLINE_BIDDINGDOCUMENT;
		case Online_Supplier:
			return BUSINESSTYPE_ONLINE_SUPPLIER;
		case Output:
			return BUSINESSTYPE_OUTPUT;
		default:
			throw new IllegalArgumentException("Unknow business type ["+type.value+"]");
		}
    }
	
	public static String getBusinessTypeCNName(BusinessType businessType){
		switch (businessType) {
		case Contract:
			return "合同";
		case Test:
			return "测试";
		case Order:
			return "定单";
		case Bidingplan:
			return "招标计划";
		case Contract2:
			return "合同维护";
		case Supplier:
			return "供应商";
		case Plan:
			return "合约规划";
		case Change:
			return "事项变更";
		case Price:
			return "价款变更";
		case Money:
			return "合同请款";
		case Money2:
			return "非合同请款";
		case Certification:
			return "证照及成果";
		case Temporary:
			return "暂收款";
		case Overflow:
			return "溢缴款";
		case ContractJBSH:
			return "合同結算";
		case Bidingplan_backstandard:
			return "回标";
		case Bidingplan_calibration:
			return "定标";
		case Bidingplan_evaluation:
			return "评标";
		case Bidingplan_invitation:
			return "发标";
		case Bidingplan_negotiation:
			return "议标";
		case Bidingplan_prequalification:
			return "资格预审";
		case Bidingplan_tender:
			return "标书编制";
		case FrameworkAgreement:
			return "框架协议";
		case Online_BiddingModel:
			return "供应商标书下载";
		case Online_BiddingDocument:
			return "供应商标书上传";
		case Online_Supplier:
			return "供应商注册";
		case Output:
			return "产值管理";
		default:
			throw new IllegalArgumentException("Unknow business type ["+businessType+"]");
		}
		
	}
}
