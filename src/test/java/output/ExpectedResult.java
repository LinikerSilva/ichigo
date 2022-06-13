package output;

class ExpectedResult {

  static String result () {
    return """
        [
          {
            "user_id": 102,
            "name": "Frances Satterfield",
            "orders": {
              "965": {
                "order_id": 965,
                "date": "2021-11-22",
                "total": "224.75",
                "products": {
                  "6": {
                    "product_id": 6,
                    "value": "224.75"
                  }
                }
              },
              "966": {
                "order_id": 966,
                "date": "2021-11-22",
                "total": "224.75",
                "products": {
                  "6": {
                    "product_id": 6,
                    "value": "224.75"
                  }
                }
              }
            }
          },
          {
            "user_id": 103,
            "name": "Gail Bradtke",
            "orders": {
              "966": {
                "order_id": 966,
                "date": "2021-05-07",
                "total": "1564.21",
                "products": {
                  "5": {
                    "product_id": 5,
                    "value": "1564.21"
                  }
                }
              }
            }
          },
          {
            "user_id": 88,
            "name": "Terra Daniel DDS",
            "orders": {
              "835": {
                "order_id": 835,
                "date": "2021-09-09",
                "total": "1899.02",
                "products": {
                  "4": {
                    "product_id": 4,
                    "value": "1899.02"
                  }
                }
              },
              "836": {
                "order_id": 836,
                "date": "2021-09-09",
                "total": "5697.06",
                "products": {
                  "3": {
                    "product_id": 3,
                    "value": "1899.02"
                  },
                  "4": {
                    "product_id": 4,
                    "value": "1899.02"
                  },
                  "10": {
                    "product_id": 10,
                    "value": "1899.02"
                  }
                }
              }
            }
          }
        ]""";
  }
}