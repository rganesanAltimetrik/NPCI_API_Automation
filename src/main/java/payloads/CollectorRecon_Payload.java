package payloads;

public class CollectorRecon_Payload {

	public String collectorRecon_Payload(String transaction_id, String bap_id, String bpp_id, String payer_account_number, String settlement_reason_code,
										 String order_recon_status, String currency, String id, String amount, String invoice_no){
		String payload = "{\n" +
				"\n" +
				"  \"context\": {\n" +
				"\n" +
				"    \"domain\": \"nic2004:52110\",\n" +
				"\n" +
				"    \"country\": \"IND\",\n" +
				"\n" +
				"    \"city\": \"std:080\",\n" +
				"\n" +
				"    \"action\": \"status\",\n" +
				"\n" +
				"    \"core_version\": \"0.9.3\",\n" +
				"\n" +
				"    \"bap_id\": \""+bap_id+"\",\n" +
				"\n" +
				"    \"bap_uri\": \"https://abc.collectorapp.com\",\n" +
				"\n" +
				"    \"bpp_id\": \""+bpp_id+"\",\n" +
				"\n" +
				"    \"bpp_uri\": \"https://abc.receiverapp.com\",\n" +
				"\n" +
				"    \"transaction_id\": \""+transaction_id+"\",\n" +
				"\n" +
				"    \"message_id\": \"6baa811a-6cbe-4ad3-94e9-cbf96aaff343\",\n" +
				"\n" +
				"    \"timestamp\": \"2022-10-28T10:34:58.469Z\",\n" +
				"\n" +
				"    \"key\": \"string\",\n" +
				"\n" +
				"    \"ttl\": \"string\"\n" +
				"\n" +
				"  },\n" +
				"\n" +
				"  \"message\": {\n" +
				"\n" +
				"    \"orderbook\": {\n" +
				"\n" +
				"      \"orders\": [\n" +
				"\n" +
				"        {\n" +
				"\n" +
				"          \"id\": \""+id+"\",\n" +
				"\n" +
				"          \"invoice_no\": \""+invoice_no+"\",\n" +
				"\n" +
				"          \"collector_app_id\": \"abc.collectorapp.com\",\n" +
				"\n" +
				"          \"receiver_app_id\": \"abc.receiverapp.com\",\n" +
				"\n" +
				"          \"state\": \"Delivered\",\n" +
				"\n" +
				"          \"provider\": {\n" +
				"\n" +
				"            \"name\": {\n" +
				"\n" +
				"              \"name\": \"SABJI XPRESS PVT LTD - BANASWADI\",\n" +
				"\n" +
				"              \"code\": \"18275-ONDC-1\"\n" +
				"\n" +
				"            },\n" +
				"\n" +
				"            \"address\": \"NewDelhi\"\n" +
				"\n" +
				"          },\n" +
				"\n" +
				"          \"payment\": {\n" +
				"\n" +
				"            \"uri\": \"string\",\n" +
				"\n" +
				"            \"tl_method\": \"http/get\",\n" +
				"\n" +
				"            \"params\": {\n" +
				"\n" +
				"              \"transaction_id\": \"string\",\n" +
				"\n" +
				"              \"transaction_status\": \"SUCCESS\",\n" +
				"\n" +
				"              \"amount\": \""+amount+"\",\n" +
				"\n" +
				"              \"currency\": \""+currency+"\"\n" +
				"\n" +
				"            },\n" +
				"\n" +
				"            \"type\": \"ON-ORDER\",\n" +
				"\n" +
				"            \"status\": \"PAID\",\n" +
				"\n" +
				"            \"collected_by\": \"BAP\",\n" +
				"\n" +
				"            \"@ondc/org/collected_by_status\": \"Assert\",\n" +
				"\n" +
				"            \"@ondc/org/buyer_app_finder_fee_type\": \"Amount\",\n" +
				"\n" +
				"            \"@ondc/org/buyer_app_finder_fee_amount\": \"1234.00\",\n" +
				"\n" +
				"            \"@ondc/org/withholding_amount\": \"12345.00\",\n" +
				"\n" +
				"            \"@ondc/org/withholding_amount_status\": \"Assert\",\n" +
				"\n" +
				"            \"@ondc/org/return_window\": \"string\",\n" +
				"\n" +
				"            \"@ondc/org/return_window_status\": \"Assert\",\n" +
				"\n" +
				"            \"@ondc/org/settlement_basis\": \"Collection\",\n" +
				"\n" +
				"            \"@ondc/org/settlement_basis_status\": \"Assert\",\n" +
				"\n" +
				"            \"@ondc/org/settlement_window\": \"string\",\n" +
				"\n" +
				"            \"@ondc/org/settlement_window_status\": \"Assert\",\n" +
				"\n" +
				"            \"@ondc/org/settlement_details\": [\n" +
				"\n" +
				"              {\n" +
				"\n" +
				"                \"settlement_counterparty\": \"buyer-app\",\n" +
				"\n" +
				"                \"settlement_phase\": \"sale-amount\",\n" +
				"\n" +
				"                \"settlement_type\": \"neft\",\n" +
				"\n" +
				"                \"settlement_bank_account_no\": \"99679007677676\",\n" +
				"\n" +
				"                \"settlement_ifsc_code\": \"HDFC900008\",\n" +
				"\n" +
				"                \"upi_address\": \"string\",\n" +
				"\n" +
				"                \"bank_name\": \"HDFC\",\n" +
				"\n" +
				"                \"branch_name\": \"Delhi\",\n" +
				"\n" +
				"                \"beneficiary_address\": \"Delhi\",\n" +
				"\n" +
				"                \"settlement_status\": \"PAID\",\n" +
				"\n" +
				"                \"settlement_reference\": \"K106403902112759\",\n" +
				"\n" +
				"                \"settlement_timestamp\": \"2022-10-28T10:34:58.469Z\"\n" +
				"\n" +
				"              }\n" +
				"\n" +
				"            ]\n" +
				"\n" +
				"          },\n" +
				"\n" +
				"          \"withholding_tax_gst\": {\n" +
				"\n" +
				"            \"currency\": \"string\",\n" +
				"\n" +
				"            \"value\": \"-123\"\n" +
				"\n" +
				"          },\n" +
				"\n" +
				"          \"withholding_tax_tds\": {\n" +
				"\n" +
				"            \"currency\": \"string\",\n" +
				"\n" +
				"            \"value\": \"0673658\"\n" +
				"\n" +
				"          },\n" +
				"\n" +
				"          \"deduction_by_collector\": {\n" +
				"\n" +
				"            \"currency\": \"string\",\n" +
				"\n" +
				"            \"value\": \"-234\"\n" +
				"\n" +
				"          },\n" +
				"\n" +
				"          \"order_recon_status\": "+order_recon_status+",\n" +
				"\n" +
				"          \"payerdetails\": {\n" +
				"\n" +
				"            \"payer_name\": \"“Example1 company Pvt. Ltd\",\n" +
				"\n" +
				"            \"payer_address\": \"Ghaziabad\",\n" +
				"\n" +
				"            \"payer_account_no\": "+payer_account_number+",\n" +
				"\n" +
				"            \"payer_bank_code\": \"HDFC0000000\",\n" +
				"\n" +
				"            \"payer_virtual_payment_address\": \"80abc@abctMh2h\"\n" +
				"\n" +
				"          },\n" +
				"\n" +
				"          \"settlement_reason_code\": \""+settlement_reason_code+"\",\n" +
				"\n" +
				"          \"payout_bank_uri\": \"https://rsp.somebank.com/rsp/\",\n" +
				"\n" +
				"          \"transaction_id\": \"6baa811a-6cbe-4ad3-94e9-cbf96aaff343\",\n" +
				"\n" +
				"          \"created_at\": \"2022-10-28T10:34:58.472Z\",\n" +
				"\n" +
				"          \"updated_at\": \"2022-10-28T10:34:58.472Z\"\n" +
				"\n" +
				"        }\n" +
				"\n" +
				"      ]\n" +
				"\n" +
				"    }\n" +
				"\n" +
				"  }\n" +
				"\n" +
				"}";

		return payload;
	}






}
