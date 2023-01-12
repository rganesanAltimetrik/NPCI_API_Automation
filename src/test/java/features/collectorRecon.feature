Feature: Validating Collector Recon API's

  Scenario Outline: Validate Collector Recon API with valid request
    Given Add Collector Recon Payload with "<transaction_id>" "<bap_id>" "<bpp_id>" "<payer_account_number>" "<settlement_reason_code>" "<order_recon_status>" "<currency>" "<id>" "<amount>" "<invoice_no>"
    When user calls "CollectorRecon_API" with "POST" http request for Collector Recon
    Then the API call got success with status code 201 for Collector Recon
    And validate the "ACK" is available in response body of Collector Recon

    Examples:
      |transaction_id  |bap_id                |bpp_id               |payer_account_number  |settlement_reason_code  |order_recon_status  |currency  |id                |amount   |invoice_no        |
      |random          |abc.collectorapp.com  |abc.receiverapp.com  |50942492429424        |01                      |null                |INR       |K106403902112759  |1234.00  |2022/XYZ/12345-2  |


  Scenario Outline: Validate Collector Recon API with invalid request
    Given Add Collector Recon Payload with "<transaction_id>" "<bap_id>" "<bpp_id>" "<payer_account_number>" "<settlement_reason_code>" "<order_recon_status>" "<currency>" "<id>" "<amount>" "<invoice_no>"
    When user calls "CollectorRecon_API" with "POST" http request for Collector Recon
    Then the API call got success with status code 400 for Collector Recon
    And validate the "NACK" is available in response body of Collector Recon
    And validate the "<error_code>" is available in response body of Collector Recon
    And validate the "<error_message>" is available in response body of Collector Recon

    Examples:
      |transaction_id  |bap_id                 |bpp_id                |payer_account_number  |settlement_reason_code  |order_recon_status  |currency  |id                |amount   |invoice_no        |error_code  |error_message       |
      |random          |abc.collectorapp. Com  |abc.receiverapp.com   |50942492429424        |01                      |null                |INR       |K106403902112759  |1234.00  |2022/XYZ/12345-2  |02          |No collector found  |
      |random          |abc.collectorapp.com   |abc.receiverapp. Com  |50942492429424        |01                      |null                |INR       |K106403902112759  |1234.00  |2022/XYZ/12345-2  |03          |No receiver found   |