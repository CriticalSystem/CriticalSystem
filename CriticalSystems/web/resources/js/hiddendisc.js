//window.addEventListener("keydown", handleKeydown);
//
//function handleKeydown(event){
//  // キーコード(どのキーが押されたか)を取得
//  var keyCode = event.keyCode;
//  
//  // 条件文で制御する
//  if (keyCode === 13) {
//    var code = "";
////    for(var i = 0;  i < 8;  i++){
//
//    }
////    document.fm.member_code.value = code;
////  }
//}

window.document.onkeydown = checkKey;
var scan = false;
var code1 = "";
function checkKey(){
    
    if(event.keyCode === 9){
        if(scan){
        }else{
            scan = true;
            alert('読み込み開始');
            code1 = "";
        }
        return false;
    }
    
    if(scan){ 
        code1 += String.fromCharCode(event.keyCode);
        if(code1.length === 13){
            alert(code1);
            console.log(code1);
            document.getElementById('disc_code').value = code1;
            document.getElementById("btn1").click();
        }
    }
}
