//快递公司集合
//及时更新
var expTypes={"status":"200","msg":"sucess","result":
				{"AAEWEB":"AAE","ARAMEX":"Aramex","DHL":"DHL",
				"DPEX":"DPEX","DEXP":"D速","EMS":"EMS","EWE":"EWE",
				"FEDEX":"FEDEX","FEDEXIN":"FedEx国际","PCA":"PCA",
				"TNT":"TNT","UPS":"UPS","ANJELEX":"安捷","ANE":"安能快递",
				"ANEEX":"安能快递","ANXINDA":"安信达","EES":"百福东方",
				"HTKY":"百世快递","BSKY":"百世快运","FLYWAYEX":"程光",
				"DTW":"大田","DEPPON":"德邦快递","GCE":"飞洋",
				"PHOENIXEXP":"凤凰","FTD":"富腾达","GSD":"共速达",
				"GTO":"国通快递","BLACKDOG":"黑狗","HENGLU":"恒路",
				"HYE":"鸿远","HQKY":"华企","JOUST":"急先达",
				"TMS":"加运美","JIAJI":"佳吉","JIAYI":"佳怡",
				"KERRY":"嘉里物流","HREX":"锦程快递","PEWKEE":"晋越",
				"JD":"京东快递","KKE":"京广快递","JIUYESCM":"九曳",
				"KYEXPRESS":"跨越","FASTEXPRESS":"快捷","BLUESKY":"蓝天",
				"LTS":"联昊通","LBEX":"龙邦快递","CAE":"民航","ND56":"能达",
				"PEISI":"配思航宇","EFSPOST":"平安快递","CHINZ56":"秦远物流",
				"QCKD":"全晨","QFKD":"全峰快递","APEX":"全一","RFD":"如风达",
				"SFC":"三态","STO":"申通快递","SFWL":"盛丰","SHENGHUI":"盛辉",
				"SDEX":"顺达快递","SFEXPRESS":"顺丰","SUNING":"苏宁",
				"SURE":"速尔","HOAU":"天地华宇","TTKDEX":"天天",
				"VANGEN":"万庚","WANJIA":"万家物流","EWINSHINE":"万象",
				"GZWENJIE":"文捷航空","XBWL":"新邦","XFEXPRESS":"信丰",
				"BROADASIA":"亚风","YIEXPRESS":"宜送","QEXPRESS":"易达通",
				"ETD":"易通达","UC56":"优速快递","CHINAPOST":"邮政包裹",
				"YFHEX":"原飞航","YTO":"圆通快递","YADEX":"源安达",
				"YCGWL":"远成","YFEXPRESS":"越丰","YTEXPRESS":"运通",
				"YUNDA":"韵达快递","ZJS":"宅急送","ZMKMEX":"芝麻开门",
				"COE":"中国东方","CRE":"中铁快运","ZTKY":"中铁物流",
				"ZTO":"中通快递","ZTO56":"中通快运","CNPL":"中邮"}
			};
/*添加快递集合--下拉框*/
function addExpType(dom){
	var obj=$("<option value='auto'>自动识别</option>");
	$(dom).append(obj);
	$.each(expTypes.result,function(k,v){
		var obj=$("<option value='"+k+"'>"+v+"</option>");
		$(dom).append(obj);
	});
}