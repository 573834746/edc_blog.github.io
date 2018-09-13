/*-----------------------------------------------------------------------------
* @Description: 验证码 
* @author: 	xuyihong(xuyihong@163.com)
* @date		2015.09.24
* ---------------------------------------------------------------------------*/
function showCheck(a){/* 显示验证码图片 */
	var c = document.getElementById("myCanvas");
  var ctx = c.getContext("2d");
	ctx.clearRect(0,0,1000,1000);
	ctx.font = "80px Arial";
	ctx.fillText(a,0,100);
}

var code ; //在全局 定义验证码      
function createCode(){       
    code = "";      
    var codeLength = 4;//验证码的长度
    var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
          
    for(var i=0;i<codeLength;i++) {
       var charIndex = Math.floor(Math.random()*60);      
      code +=selectChar[charIndex];
    }      
    if(code.length != codeLength){      
      createCode();      
    }
    showCheck(code);
}
          

function validate () {
    var inputCode = document.getElementById("J_codetext").value.toUpperCase();
    var codeToUp=code.toUpperCase();
    if(inputCode.length <=0) {
      document.getElementById("J_codetext").value="";
      document.getElementById("J_codetext").setAttribute("placeholder","验证码未输入");
      createCode();
      return false;
    }
    else if(inputCode != codeToUp ){
      document.getElementById("J_codetext").value="";
      document.getElementById("J_codetext").setAttribute("placeholder","验证码有误");
      createCode();
      return false;
    }
    else {
      document.getElementById("J_codetext").value="";
      createCode();
      return true;
    }

}

// download
$(document).ready(function(){
  $(".J_download").bind("click",function(){
    $(".J_before").hide(40);
    $(".J_after").show(200);
    createCode();
  });
  $(".btn-no").bind("click",function(){
    $(".J_after").hide(40);
    $(".J_before").show(200);
  });
})
//为确定按钮添加回车事件
// document.onkeydown=function(event){
//     var e = event || window.event || arguments.callee.caller.arguments[0];
//     if(e && e.keyCode==13){ // enter 键
//         validate();
//     }
// }; 