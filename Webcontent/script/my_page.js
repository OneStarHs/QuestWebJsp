function requestPay() {
    IMP.request_pay({
      pg: "tosspayments",
      pay_method: "card",
      merchant_uid: "test_limu5z7e",
      name: "테스트 결제",
      amount: 100,
      buyer_tel: "010-0000-0000",
    });
  }