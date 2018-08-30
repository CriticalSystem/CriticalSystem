function setState() {
    var zip = document.getElementById("member_register:postal_code").value;

    // ここでzipのバリデーションを行ってください

    $.ajax({
      type : 'get',
      url : 'https://maps.googleapis.com/maps/api/geocode/json',
      crossDomain : true,
      dataType : 'json',
      data : {
        address : zip,
        language : 'ja',
        sensor : false
      },
      success : function(resp){
        if(resp.status == "OK"){
          // APIのレスポンスから住所情報を取得
          var obj = resp.results[0].address_components;
          if (obj.length < 5) {
            alert('正しい郵便番号を入力してください');
            return false;
          }
	  if(obj.length == 5){
          document.getElementById("member_register:todouhuken").value = obj[3].long_name; // 国
          document.getElementById("member_register:sikutyouson").value = obj[2].long_name; // 都道府県
          document.getElementById("member_register:banti").value = obj[1].long_name;  // 市区町村
	  }else if (obj.length == 6){
	  document.getElementById("member_register:todouhuken").value = obj[4].long_name; // 国
          document.getElementById("member_register:sikutyouson").value = obj[3].long_name + obj[2].long_name; // 都道府県
          document.getElementById("member_register:banti").value = obj[1].long_name;  // 市区町村
	  }
        }else{
          alert('住所情報が取得できませんでした');
          return false;
        }
      }
    });
  }
