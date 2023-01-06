Feature: Validating Collector Recon API's

  Scenario Outline: Verify Transaction
    Given Add Collector Recon Payload with "<transaction_id>" "<collector_app_id>" "<collector_app_id>"
    When user calls "CollectorRecon_API" with "POST" http request for Collector Recon
    Then the API call got success with status code <status_code> for Collector Recon
    And "status" in response body is "ACK" for Collector Recon

    Examples:
      |transaction_id 	 |collector_app_id     |collector_app_id     |status_code |
      |random            |abc.collectorapp.com |abc.receiverapp.com  |201         |