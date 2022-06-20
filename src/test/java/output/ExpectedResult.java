package output;

class ExpectedResult {

  static String result () {
    return """
        [ {
          "user_id" : 102,
          "name" : "Frances Satterfield",
          "orders" : [ {
            "order_id" : 965,
            "total" : "224.75",
            "date" : "2021-11-22",
            "products" : [ {
              "product_id" : 6,
              "value" : "224.75"
            } ]
          }, {
            "order_id" : 966,
            "total" : "224.75",
            "date" : "2021-11-22",
            "products" : [ {
              "product_id" : 6,
              "value" : "224.75"
            } ]
          } ]
        }, {
          "user_id" : 103,
          "name" : "Gail Bradtke",
          "orders" : [ {
            "order_id" : 966,
            "total" : "1564.21",
            "date" : "2021-05-07",
            "products" : [ {
              "product_id" : 5,
              "value" : "1564.21"
            } ]
          } ]
        }, {
          "user_id" : 88,
          "name" : "Terra Daniel DDS",
          "orders" : [ {
            "order_id" : 835,
            "total" : "1899.02",
            "date" : "2021-09-09",
            "products" : [ {
              "product_id" : 4,
              "value" : "1899.02"
            } ]
          }, {
            "order_id" : 836,
            "total" : "5697.06",
            "date" : "2021-09-09",
            "products" : [ {
              "product_id" : 3,
              "value" : "1899.02"
            }, {
              "product_id" : 4,
              "value" : "1899.02"
            }, {
              "product_id" : 10,
              "value" : "1899.02"
            } ]
          } ]
        } ]""";
  }
}