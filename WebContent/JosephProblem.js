function show() {  
     
    var a = document.getElementById('stringarraay').value+" ";  
    // 显示  
    // document.getElementById('result').innerText = a;  
    var li = document.createElement('li');  
    li.innerText = a;  
  
    document.getElementById('josephlist').appendChild(li);  
    // alert('hello');  
    $('#josephlist').on('click','li',function(){ 
        //弹出点击的li标签的value值 
    	   var Uarry=$("#josephlist li");
          var count=$(this).index();//获取li的下标  
          var Tresult=Uarry.eq(count).text();  
          $("#stringarraay").val(Tresult); // alert('hello'); 
      }); 
}  
function sub()
  {
	function IsNum(s){
	
	if (s != null && s != "") {
		  var r,re;
	        re = /\d*/i; //\d表示数字,*表示匹配多个数字
	        r = s.match(re);
	        return (r==s)?true:false;
	}
	return false;
	}
	if(IsNum($("#interval").val())&&IsNum($("#startindex").val())){
		var interval=$("#interval").val();
		var startIndex=$("#startindex").val();
	}
	else
		{
		alert("please input a number!");

		}
	
	var jsondata = {
		"stringArray" : $("#stringarraay").val(),
		"interval" : interval,
		"startIndex" : startIndex
	};
	var encoded = JSON.stringify(jsondata);
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json;char-set=utf-8",
		url : "josephservletjson",
		data : encoded,
		success : function(data, textStatus) {
			$("#result").html("The last people is:" + data.lastPeople);
			var objs = eval(data); //解析json对象  
			var obj = objs[0];
		}
	});

}